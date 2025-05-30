package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final int group;

    @NotNull
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(@NotNull SlotTable slotTable, int i, int i2) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.group = i;
        this.version = i2;
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        int anchorIndex;
        int i;
        int groupSize;
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        Anchor anchor = obj instanceof Anchor ? (Anchor) obj : null;
        if (anchor == null || !this.table.ownsAnchor(anchor) || (anchorIndex = this.table.anchorIndex(anchor)) < (i = this.group)) {
            return null;
        }
        int i2 = anchorIndex - i;
        groupSize = SlotTableKt.groupSize(this.table.getGroups(), this.group);
        if (i2 < groupSize) {
            return new SlotTableGroup(this.table, anchorIndex, this.version);
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @NotNull
    public Iterable<Object> getData() {
        return new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.table.getGroups(), this.group);
        return groupSize;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @NotNull
    public Object getIdentity() {
        validateRead();
        SlotReader openReader = this.table.openReader();
        try {
            return openReader.anchor(this.group);
        } finally {
            openReader.close();
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @NotNull
    public Object getKey() {
        boolean hasObjectKey;
        int key;
        int objectKeyIndex;
        hasObjectKey = SlotTableKt.hasObjectKey(this.table.getGroups(), this.group);
        if (!hasObjectKey) {
            key = SlotTableKt.key(this.table.getGroups(), this.group);
            return Integer.valueOf(key);
        }
        Object[] slots = this.table.getSlots();
        objectKeyIndex = SlotTableKt.objectKeyIndex(this.table.getGroups(), this.group);
        Object obj = slots[objectKeyIndex];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @Nullable
    public Object getNode() {
        boolean isNode;
        int nodeIndex;
        isNode = SlotTableKt.isNode(this.table.getGroups(), this.group);
        if (!isNode) {
            return null;
        }
        Object[] slots = this.table.getSlots();
        nodeIndex = SlotTableKt.nodeIndex(this.table.getGroups(), this.group);
        return slots[nodeIndex];
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int dataAnchor;
        int groupSize = this.group + getGroupSize();
        int dataAnchor2 = groupSize < this.table.getGroupsSize() ? SlotTableKt.dataAnchor(this.table.getGroups(), groupSize) : this.table.getSlotsSize();
        dataAnchor = SlotTableKt.dataAnchor(this.table.getGroups(), this.group);
        return dataAnchor2 - dataAnchor;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @Nullable
    public String getSourceInfo() {
        boolean hasAux;
        int auxIndex;
        hasAux = SlotTableKt.hasAux(this.table.getGroups(), this.group);
        if (!hasAux) {
            return null;
        }
        Object[] slots = this.table.getSlots();
        auxIndex = SlotTableKt.auxIndex(this.table.getGroups(), this.group);
        Object obj = slots[auxIndex];
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @NotNull
    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.table.getGroups(), this.group);
        return groupSize == 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<CompositionGroup> iterator() {
        int groupSize;
        validateRead();
        SlotTable slotTable = this.table;
        int i = this.group;
        groupSize = SlotTableKt.groupSize(slotTable.getGroups(), this.group);
        return new GroupIterator(slotTable, i + 1, i + groupSize);
    }

    public /* synthetic */ SlotTableGroup(SlotTable slotTable, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(slotTable, i, (i3 & 4) != 0 ? slotTable.getVersion$runtime_release() : i2);
    }
}
