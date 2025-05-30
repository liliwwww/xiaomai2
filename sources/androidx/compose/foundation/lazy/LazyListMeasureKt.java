package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyListMeasureKt {

    @NotNull
    private static final Pair<Integer, Integer> EmptyRange = TuplesKt.to(Integer.MIN_VALUE, Integer.MIN_VALUE);

    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, List<LazyMeasuredItem> list2, List<LazyMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr2[i8] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i9 = iArr2[first];
                    LazyMeasuredItem lazyMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        i9 = (i6 - i9) - lazyMeasuredItem.getSize();
                    }
                    arrayList.add(lazyMeasuredItem.position(i9, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i10 = i5;
            for (int i11 = 0; i11 < size2; i11++) {
                LazyMeasuredItem lazyMeasuredItem2 = list2.get(i11);
                i10 -= lazyMeasuredItem2.getSizeWithSpacings();
                arrayList.add(lazyMeasuredItem2.position(i10, i, i2));
            }
            int size3 = list.size();
            int i12 = i5;
            for (int i13 = 0; i13 < size3; i13++) {
                LazyMeasuredItem lazyMeasuredItem3 = list.get(i13);
                arrayList.add(lazyMeasuredItem3.position(i12, i, i2));
                i12 += lazyMeasuredItem3.getSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i14 = 0; i14 < size4; i14++) {
                LazyMeasuredItem lazyMeasuredItem4 = list3.get(i14);
                arrayList.add(lazyMeasuredItem4.position(i12, i, i2));
                i12 += lazyMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List<LazyMeasuredItem> createItemsAfterList(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, List<LazyMeasuredItem> list, LazyMeasuredItemProvider lazyMeasuredItemProvider, int i, int i2, List<? extends LazyListPinnedItem> list2) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int index = ((LazyMeasuredItem) CollectionsKt.last(list)).getIndex();
        if (lazyListBeyondBoundsInfo.hasIntervals()) {
            index = Math.max(createItemsAfterList$endIndex(lazyListBeyondBoundsInfo, i), index);
        }
        int min = Math.min(index + i2, i - 1);
        int index2 = ((LazyMeasuredItem) CollectionsKt.last(list)).getIndex() + 1;
        if (index2 <= min) {
            while (true) {
                createItemsAfterList$addItem(objectRef, lazyMeasuredItemProvider, index2);
                if (index2 == min) {
                    break;
                }
                index2++;
            }
        }
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            LazyListPinnedItem lazyListPinnedItem = list2.get(i3);
            if (lazyListPinnedItem.getIndex() > min && lazyListPinnedItem.getIndex() < i) {
                createItemsAfterList$addItem(objectRef, lazyMeasuredItemProvider, lazyListPinnedItem.getIndex());
            }
        }
        List<LazyMeasuredItem> list3 = (List) objectRef.element;
        return list3 == null ? CollectionsKt.emptyList() : list3;
    }

    private static final void createItemsAfterList$addItem(Ref.ObjectRef<List<LazyMeasuredItem>> objectRef, LazyMeasuredItemProvider lazyMeasuredItemProvider, int i) {
        if (objectRef.element == null) {
            objectRef.element = new ArrayList();
        }
        Object obj = objectRef.element;
        if (obj == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ((List) obj).add(lazyMeasuredItemProvider.m267getAndMeasureZjPyQlc(DataIndex.m245constructorimpl(i)));
    }

    private static final int createItemsAfterList$endIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i) {
        return Math.min(lazyListBeyondBoundsInfo.getEnd(), i - 1);
    }

    /* renamed from: createItemsBeforeList-_ok666U, reason: not valid java name */
    private static final List<LazyMeasuredItem> m262createItemsBeforeList_ok666U(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i, LazyMeasuredItemProvider lazyMeasuredItemProvider, int i2, int i3, List<? extends LazyListPinnedItem> list) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int min = lazyListBeyondBoundsInfo.hasIntervals() ? Math.min(createItemsBeforeList__ok666U$startIndex(lazyListBeyondBoundsInfo, i2), i) : i;
        int max = Math.max(0, min - i3);
        int i4 = i - 1;
        if (max <= i4) {
            while (true) {
                createItemsBeforeList__ok666U$addItem$5(objectRef, lazyMeasuredItemProvider, i4);
                if (i4 == max) {
                    break;
                }
                i4--;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            LazyListPinnedItem lazyListPinnedItem = list.get(i5);
            if (lazyListPinnedItem.getIndex() < max) {
                createItemsBeforeList__ok666U$addItem$5(objectRef, lazyMeasuredItemProvider, lazyListPinnedItem.getIndex());
            }
        }
        List<LazyMeasuredItem> list2 = (List) objectRef.element;
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final void createItemsBeforeList__ok666U$addItem$5(Ref.ObjectRef<List<LazyMeasuredItem>> objectRef, LazyMeasuredItemProvider lazyMeasuredItemProvider, int i) {
        if (objectRef.element == null) {
            objectRef.element = new ArrayList();
        }
        Object obj = objectRef.element;
        if (obj == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ((List) obj).add(lazyMeasuredItemProvider.m267getAndMeasureZjPyQlc(DataIndex.m245constructorimpl(i)));
    }

    private static final int createItemsBeforeList__ok666U$startIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i) {
        return Math.min(lazyListBeyondBoundsInfo.getStart(), i - 1);
    }

    private static final boolean getNotInEmptyRange(int i) {
        return i != Integer.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e2  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measureLazyList-QaF8Ofo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m263measureLazyListQaF8Ofo(int r29, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyMeasuredItemProvider r30, int r31, int r32, int r33, int r34, int r35, int r36, float r37, long r38, boolean r40, @org.jetbrains.annotations.NotNull java.util.List<java.lang.Integer> r41, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r43, boolean r44, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r45, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r46, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r47, int r48, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.foundation.lazy.LazyListPinnedItem> r49, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r50) {
        /*
            Method dump skipped, instructions count: 915
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m263measureLazyListQaF8Ofo(int, androidx.compose.foundation.lazy.LazyMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo, int, java.util.List, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }
}
