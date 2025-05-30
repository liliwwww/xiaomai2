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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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

    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        int anchorIndex;
        int i;
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        Anchor anchor = obj instanceof Anchor ? (Anchor) obj : null;
        if (anchor == null || !this.table.ownsAnchor(anchor) || (anchorIndex = this.table.anchorIndex(anchor)) < (i = this.group) || anchorIndex - i >= SlotTableKt.access$groupSize(this.table.getGroups(), this.group)) {
            return null;
        }
        return new SlotTableGroup(this.table, anchorIndex, this.version);
    }

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
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group);
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
        if (!SlotTableKt.access$hasObjectKey(this.table.getGroups(), this.group)) {
            return Integer.valueOf(SlotTableKt.access$key(this.table.getGroups(), this.group));
        }
        Object obj = this.table.getSlots()[SlotTableKt.access$objectKeyIndex(this.table.getGroups(), this.group)];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @Nullable
    public Object getNode() {
        if (SlotTableKt.access$isNode(this.table.getGroups(), this.group)) {
            return this.table.getSlots()[SlotTableKt.access$nodeIndex(this.table.getGroups(), this.group)];
        }
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int groupSize = this.group + getGroupSize();
        return (groupSize < this.table.getGroupsSize() ? SlotTableKt.access$dataAnchor(this.table.getGroups(), groupSize) : this.table.getSlotsSize()) - SlotTableKt.access$dataAnchor(this.table.getGroups(), this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    @Nullable
    public String getSourceInfo() {
        if (!SlotTableKt.access$hasAux(this.table.getGroups(), this.group)) {
            return null;
        }
        Object obj = this.table.getSlots()[SlotTableKt.access$auxIndex(this.table.getGroups(), this.group)];
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

    public boolean isEmpty() {
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group) == 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<CompositionGroup> iterator() {
        validateRead();
        SlotTable slotTable = this.table;
        int i = this.group;
        return new GroupIterator(slotTable, i + 1, i + SlotTableKt.access$groupSize(slotTable.getGroups(), this.group));
    }

    public /* synthetic */ SlotTableGroup(SlotTable slotTable, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(slotTable, i, (i3 & 4) != 0 ? slotTable.getVersion$runtime_release() : i2);
    }
}
