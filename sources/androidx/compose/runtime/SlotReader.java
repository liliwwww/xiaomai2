package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SlotReader {
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;

    @NotNull
    private final int[] groups;
    private final int groupsSize;
    private int parent;

    @NotNull
    private final Object[] slots;
    private final int slotsSize;

    @NotNull
    private final SlotTable table;

    public SlotReader(@NotNull SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize = slotTable.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.currentEnd = groupsSize;
        this.parent = -1;
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotReader.currentGroup;
        }
        return slotReader.anchor(i);
    }

    private final Object aux(int[] iArr, int i) {
        return SlotTableKt.access$hasAux(iArr, i) ? this.slots[SlotTableKt.access$auxIndex(iArr, i)] : Composer.Companion.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i) {
        if (SlotTableKt.access$hasObjectKey(iArr, i)) {
            return this.slots[SlotTableKt.access$objectKeyIndex(iArr, i)];
        }
        return null;
    }

    @NotNull
    public final Anchor anchor(int i) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int access$search = SlotTableKt.access$search(anchors$runtime_release, i, this.groupsSize);
        if (access$search < 0) {
            Anchor anchor = new Anchor(i);
            anchors$runtime_release.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = anchors$runtime_release.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this);
    }

    public final boolean containsMark(int i) {
        return SlotTableKt.access$containsMark(this.groups, i);
    }

    public final void endEmpty() {
        int i = this.emptyCount;
        if (!(i > 0)) {
            throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
        }
        this.emptyCount = i - 1;
    }

    public final void endGroup() {
        if (this.emptyCount == 0) {
            if (!(this.currentGroup == this.currentEnd)) {
                ComposerKt.composeRuntimeError("endGroup() not called at the end of a group".toString());
                throw new KotlinNothingValueException();
            }
            int access$parentAnchor = SlotTableKt.access$parentAnchor(this.groups, this.parent);
            this.parent = access$parentAnchor;
            this.currentEnd = access$parentAnchor < 0 ? this.groupsSize : access$parentAnchor + SlotTableKt.access$groupSize(this.groups, access$parentAnchor);
        }
    }

    @NotNull
    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int i = this.currentGroup;
        int i2 = 0;
        while (i < this.currentEnd) {
            arrayList.add(new KeyInfo(SlotTableKt.access$key(this.groups, i), objectKey(this.groups, i), i, SlotTableKt.access$isNode(this.groups, i) ? 1 : SlotTableKt.access$nodeCount(this.groups, i), i2));
            i += SlotTableKt.access$groupSize(this.groups, i);
            i2++;
        }
        return arrayList;
    }

    public final void forEachData$runtime_release(int i, @NotNull Function2<? super Integer, Object, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, i);
        int i2 = i + 1;
        int access$dataAnchor = i2 < this.table.getGroupsSize() ? SlotTableKt.access$dataAnchor(this.table.getGroups(), i2) : this.table.getSlotsSize();
        for (int i3 = access$slotAnchor; i3 < access$dataAnchor; i3++) {
            function2.invoke(Integer.valueOf(i3 - access$slotAnchor), this.slots[i3]);
        }
    }

    @Nullable
    public final Object get(int i) {
        int i2 = this.currentSlot + i;
        return i2 < this.currentSlotEnd ? this.slots[i2] : Composer.Companion.getEmpty();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    @Nullable
    public final Object getGroupAux() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return aux(this.groups, i);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return SlotTableKt.access$key(this.groups, i);
        }
        return 0;
    }

    @Nullable
    public final Object getGroupNode() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return node(this.groups, i);
        }
        return null;
    }

    @Nullable
    public final Object getGroupObjectKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return objectKey(this.groups, i);
        }
        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int i = this.currentGroup;
        int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, i);
        int i2 = i + 1;
        return (i2 < this.groupsSize ? SlotTableKt.access$dataAnchor(this.groups, i2) : this.slotsSize) - access$slotAnchor;
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getNodeCount() {
        return SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i = this.parent;
        if (i >= 0) {
            return SlotTableKt.access$nodeCount(this.groups, i);
        }
        return 0;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    @NotNull
    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    @Nullable
    public final Object groupAux(int i) {
        return aux(this.groups, i);
    }

    public final int groupEnd(int i) {
        return i + SlotTableKt.access$groupSize(this.groups, i);
    }

    @Nullable
    public final Object groupGet(int i) {
        return groupGet(this.currentGroup, i);
    }

    public final int groupKey(int i) {
        return SlotTableKt.access$key(this.groups, i);
    }

    @Nullable
    public final Object groupObjectKey(int i) {
        return objectKey(this.groups, i);
    }

    public final int groupSize(int i) {
        return SlotTableKt.access$groupSize(this.groups, i);
    }

    public final boolean hasMark(int i) {
        return SlotTableKt.access$hasMark(this.groups, i);
    }

    public final boolean hasObjectKey(int i) {
        return SlotTableKt.access$hasObjectKey(this.groups, i);
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean isNode() {
        return SlotTableKt.access$isNode(this.groups, this.currentGroup);
    }

    @Nullable
    public final Object next() {
        int i;
        if (this.emptyCount > 0 || (i = this.currentSlot) >= this.currentSlotEnd) {
            return Composer.Companion.getEmpty();
        }
        Object[] objArr = this.slots;
        this.currentSlot = i + 1;
        return objArr[i];
    }

    @Nullable
    public final Object node(int i) {
        if (SlotTableKt.access$isNode(this.groups, i)) {
            return node(this.groups, i);
        }
        return null;
    }

    public final int nodeCount(int i) {
        return SlotTableKt.access$nodeCount(this.groups, i);
    }

    public final int parent(int i) {
        return SlotTableKt.access$parentAnchor(this.groups, i);
    }

    public final int parentOf(int i) {
        if (i >= 0 && i < this.groupsSize) {
            return SlotTableKt.access$parentAnchor(this.groups, i);
        }
        throw new IllegalArgumentException(("Invalid group index " + i).toString());
    }

    public final void reposition(int i) {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeRuntimeError("Cannot reposition while in an empty region".toString());
            throw new KotlinNothingValueException();
        }
        this.currentGroup = i;
        int access$parentAnchor = i < this.groupsSize ? SlotTableKt.access$parentAnchor(this.groups, i) : -1;
        this.parent = access$parentAnchor;
        if (access$parentAnchor < 0) {
            this.currentEnd = this.groupsSize;
        } else {
            this.currentEnd = access$parentAnchor + SlotTableKt.access$groupSize(this.groups, access$parentAnchor);
        }
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void restoreParent(int i) {
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, i) + i;
        int i2 = this.currentGroup;
        if (i2 >= i && i2 <= access$groupSize) {
            this.parent = i;
            this.currentEnd = access$groupSize;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        ComposerKt.composeRuntimeError(("Index " + i + " is not a parent of " + i2).toString());
        throw new KotlinNothingValueException();
    }

    public final int skipGroup() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeRuntimeError("Cannot skip while in an empty region".toString());
            throw new KotlinNothingValueException();
        }
        int access$nodeCount = SlotTableKt.access$isNode(this.groups, this.currentGroup) ? 1 : SlotTableKt.access$nodeCount(this.groups, this.currentGroup);
        int i = this.currentGroup;
        this.currentGroup = i + SlotTableKt.access$groupSize(this.groups, i);
        return access$nodeCount;
    }

    public final void skipToGroupEnd() {
        if (this.emptyCount == 0) {
            this.currentGroup = this.currentEnd;
        } else {
            ComposerKt.composeRuntimeError("Cannot skip the enclosing group while in an empty region".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void startGroup() {
        if (this.emptyCount <= 0) {
            if (!(SlotTableKt.access$parentAnchor(this.groups, this.currentGroup) == this.parent)) {
                throw new IllegalArgumentException("Invalid slot table detected".toString());
            }
            int i = this.currentGroup;
            this.parent = i;
            this.currentEnd = i + SlotTableKt.access$groupSize(this.groups, i);
            int i2 = this.currentGroup;
            int i3 = i2 + 1;
            this.currentGroup = i3;
            this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, i2);
            this.currentSlotEnd = i2 >= this.groupsSize - 1 ? this.slotsSize : SlotTableKt.access$dataAnchor(this.groups, i3);
        }
    }

    public final void startNode() {
        if (this.emptyCount <= 0) {
            if (!SlotTableKt.access$isNode(this.groups, this.currentGroup)) {
                throw new IllegalArgumentException("Expected a node group".toString());
            }
            startGroup();
        }
    }

    @NotNull
    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }

    private final Object node(int[] iArr, int i) {
        return SlotTableKt.access$isNode(iArr, i) ? this.slots[SlotTableKt.access$nodeIndex(iArr, i)] : Composer.Companion.getEmpty();
    }

    @Nullable
    public final Object groupGet(int i, int i2) {
        int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, i);
        int i3 = i + 1;
        int i4 = access$slotAnchor + i2;
        return i4 < (i3 < this.groupsSize ? SlotTableKt.access$dataAnchor(this.groups, i3) : this.slotsSize) ? this.slots[i4] : Composer.Companion.getEmpty();
    }

    public final int groupKey(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            return SlotTableKt.access$key(this.groups, this.table.anchorIndex(anchor));
        }
        return 0;
    }

    public final boolean isNode(int i) {
        return SlotTableKt.access$isNode(this.groups, i);
    }
}
