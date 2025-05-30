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
/* loaded from: classes.dex */
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
        List<Integer> dataAnchors;
        dataAnchors = SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
        return dataAnchors;
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        int key;
        int groupSize;
        int nodeCount;
        boolean hasMark;
        boolean containsMark;
        boolean hasObjectKey;
        boolean isNode;
        boolean hasAux;
        int slotAnchor;
        int auxIndex;
        int nodeIndex;
        int objectKeyIndex;
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(") key=");
        key = SlotTableKt.key(this.groups, i);
        sb.append(key);
        groupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        nodeCount = SlotTableKt.nodeCount(this.groups, i);
        sb.append(nodeCount);
        sb.append(", size=");
        sb.append(groupSize);
        hasMark = SlotTableKt.hasMark(this.groups, i);
        if (hasMark) {
            sb.append(", mark");
        }
        containsMark = SlotTableKt.containsMark(this.groups, i);
        if (containsMark) {
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
            hasObjectKey = SlotTableKt.hasObjectKey(this.groups, i);
            if (hasObjectKey) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" objectKey=");
                Object[] objArr = this.slots;
                objectKeyIndex = SlotTableKt.objectKeyIndex(this.groups, i);
                sb2.append(objArr[objectKeyIndex]);
                sb.append(sb2.toString());
            }
            isNode = SlotTableKt.isNode(this.groups, i);
            if (isNode) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" node=");
                Object[] objArr2 = this.slots;
                nodeIndex = SlotTableKt.nodeIndex(this.groups, i);
                sb3.append(objArr2[nodeIndex]);
                sb.append(sb3.toString());
            }
            hasAux = SlotTableKt.hasAux(this.groups, i);
            if (hasAux) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" aux=");
                Object[] objArr3 = this.slots;
                auxIndex = SlotTableKt.auxIndex(this.groups, i);
                sb4.append(objArr3[auxIndex]);
                sb.append(sb4.toString());
            }
            slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (slotAnchor < emitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(slotAnchor);
                sb.append(": ");
                for (int i5 = slotAnchor; i5 < emitGroup$dataIndex2; i5++) {
                    if (i5 != slotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i5]));
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i6 = i + groupSize;
        while (i4 < i6) {
            i4 += emitGroup(sb, i4, i2 + 1);
        }
        return groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        int dataAnchor;
        if (i >= slotTable.groupsSize) {
            return slotTable.slotsSize;
        }
        dataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i);
        return dataAnchor;
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int i) {
        while (i > 0) {
            Iterator<Object> it = new DataIterator(this, i).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) next;
                }
            }
            i = SlotTableKt.parentAnchor(this.groups, i);
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        List<Integer> groupSizes;
        groupSizes = SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
        return groupSizes;
    }

    private final boolean invalidateGroup(int i) {
        while (i >= 0) {
            Iterator<Object> it = new DataIterator(this, i).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    return recomposeScopeImpl.invalidateForResult(null) != InvalidationResult.IGNORED;
                }
            }
            i = SlotTableKt.parentAnchor(this.groups, i);
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
        List<Integer> keys;
        keys = SlotTableKt.keys(this.groups, this.groupsSize * 5);
        return keys;
    }

    private final List<Integer> nodes() {
        List<Integer> nodeCounts;
        nodeCounts = SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
        return nodeCounts;
    }

    private final List<Integer> parentIndexes() {
        List<Integer> parentAnchors;
        parentAnchors = SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
        return parentAnchors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d0, code lost:
    
        if (r9 != false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int verifyWellFormed$validateGroup(kotlin.jvm.internal.Ref.IntRef r9, androidx.compose.runtime.SlotTable r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SlotTable.verifyWellFormed$validateGroup(kotlin.jvm.internal.Ref$IntRef, androidx.compose.runtime.SlotTable, int, int):int");
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
        int search = SlotTableKt.search(arrayList, i, this.groupsSize);
        if (search < 0) {
            Anchor anchor = new Anchor(i);
            arrayList.add(-(search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(search);
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
        boolean containsMark;
        if (this.groupsSize <= 0) {
            return false;
        }
        containsMark = SlotTableKt.containsMark(this.groups, 0);
        return containsMark;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    @Nullable
    public CompositionGroup find(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "identityToFind");
        return new SlotTableGroup(this, 0, 0, 4, null).find(obj);
    }

    @NotNull
    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
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
        int groupSize;
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
            groupSize = SlotTableKt.groupSize(this.groups, i);
            int i2 = groupSize + i;
            int location$runtime_release = anchor.getLocation$runtime_release();
            if (i <= location$runtime_release && location$runtime_release < i2) {
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

    @Override // androidx.compose.runtime.tooling.CompositionData
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
            int search = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
            if (search >= 0 && Intrinsics.areEqual(this.anchors.get(search), anchor)) {
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
        int dataAnchor;
        dataAnchor = SlotTableKt.dataAnchor(this.groups, i);
        int i2 = i + 1;
        return ArraysKt.toList(this.slots).subList(dataAnchor, i2 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i2) : this.slots.length);
    }

    public final void verifyWellFormed() {
        int i;
        int i2;
        int groupSize;
        Ref.IntRef intRef = new Ref.IntRef();
        int i3 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i = intRef.element;
                i2 = this.groupsSize;
                if (i >= i2) {
                    break;
                }
                groupSize = SlotTableKt.groupSize(this.groups, i);
                verifyWellFormed$validateGroup(intRef, this, -1, i + groupSize);
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
