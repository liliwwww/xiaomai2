package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private int version;
    private boolean writer;

    @NotNull
    private int[] groups = new int[0];

    @NotNull
    private Object[] slots = new Object[0];

    @NotNull
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(") key=");
        sb.append(SlotTableKt.access$key(this.groups, i));
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, i);
        sb.append(", nodes=");
        sb.append(SlotTableKt.access$nodeCount(this.groups, i));
        sb.append(", size=");
        sb.append(access$groupSize);
        if (SlotTableKt.access$hasMark(this.groups, i)) {
            sb.append(", mark");
        }
        if (SlotTableKt.access$containsMark(this.groups, i)) {
            sb.append(", contains mark");
        }
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int i4 = i + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i4);
        if (emitGroup$dataIndex >= 0 && emitGroup$dataIndex <= emitGroup$dataIndex2) {
            z = true;
        }
        if (!z || emitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + emitGroup$dataIndex + '-' + emitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.access$hasObjectKey(this.groups, i)) {
                sb.append(" objectKey=" + this.slots[SlotTableKt.access$objectKeyIndex(this.groups, i)]);
            }
            if (SlotTableKt.access$isNode(this.groups, i)) {
                sb.append(" node=" + this.slots[SlotTableKt.access$nodeIndex(this.groups, i)]);
            }
            if (SlotTableKt.access$hasAux(this.groups, i)) {
                sb.append(" aux=" + this.slots[SlotTableKt.access$auxIndex(this.groups, i)]);
            }
            int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, i);
            if (access$slotAnchor < emitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(access$slotAnchor);
                sb.append(": ");
                for (int i5 = access$slotAnchor; i5 < emitGroup$dataIndex2; i5++) {
                    if (i5 != access$slotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i5]));
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i6 = i + access$groupSize;
        while (i4 < i6) {
            i4 += emitGroup(sb, i4, i2 + 1);
        }
        return access$groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.access$dataAnchor(slotTable.groups, i);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        while (i > 0) {
            Iterator it = new DataIterator(this, i).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) next;
                }
            }
            i = SlotTableKt.access$parentAnchor(this.groups, i);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, this.groupsSize * 5);
    }

    private final boolean invalidateGroup(int i) {
        while (i >= 0) {
            Iterator it = new DataIterator(this, i).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    return recomposeScopeImpl.invalidateForResult(null) != InvalidationResult.IGNORED;
                }
            }
            i = SlotTableKt.access$parentAnchor(this.groups, i);
        }
        return false;
    }

    private static final void invalidateGroupsWithKey$lambda$14$scanGroup(SlotReader slotReader, int i, List<Anchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        if (slotReader.getGroupKey() != i) {
            slotReader.startGroup();
            while (!slotReader.isGroupEnd()) {
                invalidateGroupsWithKey$lambda$14$scanGroup(slotReader, i, list, booleanRef, slotTable, list2);
            }
            slotReader.endGroup();
            return;
        }
        list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
        if (booleanRef.element) {
            RecomposeScopeImpl findEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
            if (findEffectiveRecomposeScope != null) {
                list2.add(findEffectiveRecomposeScope);
            } else {
                booleanRef.element = false;
                list2.clear();
            }
        }
        slotReader.skipGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.access$keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, this.groupsSize * 5);
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int i3 = intRef.element;
        int i4 = i3 + 1;
        intRef.element = i4;
        int access$parentAnchor = SlotTableKt.access$parentAnchor(slotTable.groups, i3);
        if (!(access$parentAnchor == i)) {
            throw new IllegalStateException(("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + access$parentAnchor).toString());
        }
        int access$groupSize = SlotTableKt.access$groupSize(slotTable.groups, i3) + i3;
        if (!(access$groupSize <= slotTable.groupsSize)) {
            throw new IllegalStateException(("A group extends past the end of the table at " + i3).toString());
        }
        if (!(access$groupSize <= i2)) {
            throw new IllegalStateException(("A group extends past its parent group at " + i3).toString());
        }
        int access$dataAnchor = SlotTableKt.access$dataAnchor(slotTable.groups, i3);
        int access$dataAnchor2 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.access$dataAnchor(slotTable.groups, i4);
        if (!(access$dataAnchor2 <= slotTable.slots.length)) {
            throw new IllegalStateException(("Slots for " + i3 + " extend past the end of the slot table").toString());
        }
        if (!(access$dataAnchor <= access$dataAnchor2)) {
            throw new IllegalStateException(("Invalid data anchor at " + i3).toString());
        }
        if (!(SlotTableKt.access$slotAnchor(slotTable.groups, i3) <= access$dataAnchor2)) {
            throw new IllegalStateException(("Slots start out of range at " + i3).toString());
        }
        if (!(access$dataAnchor2 - access$dataAnchor >= ((SlotTableKt.access$isNode(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.access$hasObjectKey(slotTable.groups, i3) ? 1 : 0)) + (SlotTableKt.access$hasAux(slotTable.groups, i3) ? 1 : 0))) {
            throw new IllegalStateException(("Not enough slots added for group " + i3).toString());
        }
        boolean access$isNode = SlotTableKt.access$isNode(slotTable.groups, i3);
        if (!((access$isNode && slotTable.slots[SlotTableKt.access$nodeIndex(slotTable.groups, i3)] == null) ? false : true)) {
            throw new IllegalStateException(("No node recorded for a node group at " + i3).toString());
        }
        int i5 = 0;
        while (intRef.element < access$groupSize) {
            i5 += verifyWellFormed$validateGroup(intRef, slotTable, i3, access$groupSize);
        }
        int access$nodeCount = SlotTableKt.access$nodeCount(slotTable.groups, i3);
        int access$groupSize2 = SlotTableKt.access$groupSize(slotTable.groups, i3);
        if (!(access$nodeCount == i5)) {
            throw new IllegalStateException(("Incorrect node count detected at " + i3 + ", expected " + access$nodeCount + ", received " + i5).toString());
        }
        int i6 = intRef.element - i3;
        if (!(access$groupSize2 == i6)) {
            throw new IllegalStateException(("Incorrect slot count detected at " + i3 + ", expected " + access$groupSize2 + ", received " + i6).toString());
        }
        if (SlotTableKt.access$containsAnyMark(slotTable.groups, i3)) {
            if (!(i3 <= 0 || SlotTableKt.access$containsMark(slotTable.groups, i))) {
                throw new IllegalStateException(("Expected group " + i + " to record it contains a mark because " + i3 + " does").toString());
            }
        }
        if (access$isNode) {
            return 1;
        }
        return i5;
    }

    @NotNull
    public final Anchor anchor(int i) {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
            throw new KotlinNothingValueException();
        }
        boolean z = false;
        if (i >= 0 && i < this.groupsSize) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.access$search(arrayList, i, this.groupsSize);
        if (access$search < 0) {
            Anchor anchor = new Anchor(i);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new KotlinNothingValueException();
        }
        if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        }
        throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
    }

    @NotNull
    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int i2 = 0;
            while (i2 < i) {
                i2 += emitGroup(sb, i2, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void close$runtime_release(@NotNull SlotReader slotReader) {
        Intrinsics.checkNotNullParameter(slotReader, "reader");
        if (slotReader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.access$containsMark(this.groups, 0);
    }

    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        return new SlotTableGroup(this, 0, 0, 4, null).find(obj);
    }

    @NotNull
    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @NotNull
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @NotNull
    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    @NotNull
    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int i, @NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Writer is active".toString());
            throw new KotlinNothingValueException();
        }
        if (!(i >= 0 && i < this.groupsSize)) {
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new KotlinNothingValueException();
        }
        if (ownsAnchor(anchor)) {
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, i) + i;
            int location$runtime_release = anchor.getLocation$runtime_release();
            if (i <= location$runtime_release && location$runtime_release < access$groupSize) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        SlotReader openReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$14$scanGroup(openReader, i, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            openReader.close();
            SlotWriter openWriter = openWriter();
            try {
                openWriter.startGroup();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Anchor anchor = (Anchor) arrayList.get(i2);
                    if (anchor.toIndexFor(openWriter) >= openWriter.getCurrentGroup()) {
                        openWriter.seek(anchor);
                        openWriter.bashGroup$runtime_release();
                    }
                }
                openWriter.skipToGroupEnd();
                openWriter.endGroup();
                openWriter.close();
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                openWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            openReader.close();
            throw th2;
        }
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @NotNull
    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.readers++;
        return new SlotReader(this);
    }

    @NotNull
    public final SlotWriter openWriter() {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
            throw new KotlinNothingValueException();
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(@NotNull Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            int access$search = SlotTableKt.access$search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
            if (access$search >= 0 && Intrinsics.areEqual(this.anchors.get(access$search), anchor)) {
                return true;
            }
        }
        return false;
    }

    public final <T> T read(@NotNull Function1<? super SlotReader, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotReader openReader = openReader();
        try {
            return (T) function1.invoke(openReader);
        } finally {
            InlineMarker.finallyStart(1);
            openReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void setAnchors$runtime_release(@NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public final void setTo$runtime_release(@NotNull int[] iArr, int i, @NotNull Object[] objArr, int i2, @NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        this.groups = iArr;
        this.groupsSize = i;
        this.slots = objArr;
        this.slotsSize = i2;
        this.anchors = arrayList;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    @NotNull
    public final List<Object> slotsOf$runtime_release(int i) {
        int access$dataAnchor = SlotTableKt.access$dataAnchor(this.groups, i);
        int i2 = i + 1;
        return ArraysKt.toList(this.slots).subList(access$dataAnchor, i2 < this.groupsSize ? SlotTableKt.access$dataAnchor(this.groups, i2) : this.slots.length);
    }

    public final void verifyWellFormed() {
        int i;
        int i2;
        Ref.IntRef intRef = new Ref.IntRef();
        int i3 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i = intRef.element;
                i2 = this.groupsSize;
                if (i >= i2) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(intRef, this, -1, i + SlotTableKt.access$groupSize(this.groups, i));
                }
            }
            if (!(i == i2)) {
                throw new IllegalStateException(("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize).toString());
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            int indexFor = arrayList.get(i4).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                throw new IllegalArgumentException("Invalid anchor, location out of bound".toString());
            }
            if (!(i3 < indexFor)) {
                throw new IllegalArgumentException("Anchor is out of order".toString());
            }
            i4++;
            i3 = indexFor;
        }
    }

    public final <T> T write(@NotNull Function1<? super SlotWriter, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotWriter openWriter = openWriter();
        try {
            return (T) function1.invoke(openWriter);
        } finally {
            InlineMarker.finallyStart(1);
            openWriter.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void close$runtime_release(@NotNull SlotWriter slotWriter, @NotNull int[] iArr, int i, @NotNull Object[] objArr, int i2, @NotNull ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        if (slotWriter.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(iArr, i, objArr, i2, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }
}
