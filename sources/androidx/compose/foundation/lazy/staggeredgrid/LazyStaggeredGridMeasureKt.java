package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (iArr[length] >= i) {
                iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
            }
            if (iArr[length] != -1) {
                lazyStaggeredGridMeasureContext.getSpans().setSpan(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findNextItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getSpans().findNextItemIndex(i, i2);
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getSpans().findPreviousItemIndex(i, i2);
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 < iArr[i3]) {
                i2 = iArr[i3];
                i = i3;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = ((Number) function1.invoke(tArr[i3])).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    public static final int indexOfMinValue(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 > iArr[i3]) {
                i2 = iArr[i3];
                i = i3;
            }
        }
        return i;
    }

    @ExperimentalFoundationApi
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int[] iArr3;
        int[] iArr4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i6;
        boolean z9;
        int i7;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        int i8 = i;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext.getItemProvider().getItemCount();
        if (itemCount > 0) {
            if (!(lazyStaggeredGridMeasureContext.getResolvedSlotSums().length == 0)) {
                int[] copyOf = Arrays.copyOf(iArr, iArr.length);
                String str = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                int[] copyOf2 = Arrays.copyOf(iArr2, iArr2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
                offsetBy(copyOf2, -i8);
                int length = lazyStaggeredGridMeasureContext.getResolvedSlotSums().length;
                ArrayDeque[] arrayDequeArr = new ArrayDeque[length];
                for (int i9 = 0; i9 < length; i9++) {
                    arrayDequeArr[i9] = new ArrayDeque();
                }
                offsetBy(copyOf2, -lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                while (true) {
                    if (!measure$lambda$18$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                        i2 = -1;
                        break;
                    }
                    i2 = indexOfMinValue(copyOf2);
                    int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, copyOf[i2], i2);
                    if (findPreviousItemIndex < 0) {
                        break;
                    }
                    if (lazyStaggeredGridMeasureContext.getSpans().getSpan(findPreviousItemIndex) == -1) {
                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex, i2);
                    }
                    LazyStaggeredGridMeasuredItem andMeasure = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex, i2);
                    arrayDequeArr[i2].addFirst(andMeasure);
                    copyOf[i2] = findPreviousItemIndex;
                    copyOf2[i2] = copyOf2[i2] + andMeasure.getSizeWithSpacings();
                }
                int i10 = -lazyStaggeredGridMeasureContext.getBeforeContentPadding();
                if (copyOf2[0] < i10) {
                    i3 = copyOf2[0] + i8;
                    offsetBy(copyOf2, i10 - copyOf2[0]);
                } else {
                    i3 = i8;
                }
                offsetBy(copyOf2, lazyStaggeredGridMeasureContext.getBeforeContentPadding());
                if (i2 == -1) {
                    i2 = ArraysKt.indexOf(copyOf, 0);
                }
                if (i2 != -1 && measure$lambda$18$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i2) && z) {
                    lazyStaggeredGridMeasureContext.getSpans().reset();
                    int length2 = copyOf.length;
                    int[] iArr5 = new int[length2];
                    for (int i11 = 0; i11 < length2; i11++) {
                        iArr5[i11] = -1;
                    }
                    int length3 = copyOf2.length;
                    int[] iArr6 = new int[length3];
                    for (int i12 = 0; i12 < length3; i12++) {
                        iArr6[i12] = copyOf2[i2];
                    }
                    return measure(lazyStaggeredGridMeasureContext2, i3, iArr5, iArr6, false);
                }
                int[] copyOf3 = Arrays.copyOf(iArr, iArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(this, size)");
                ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf3, itemCount);
                int length4 = iArr2.length;
                int[] iArr7 = new int[length4];
                int i13 = 0;
                while (i13 < length4) {
                    iArr7[i13] = -(iArr2[i13] - i3);
                    i13++;
                    str = str;
                }
                String str2 = str;
                int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), 0);
                int length5 = copyOf3.length;
                int i14 = i3;
                int[] iArr8 = copyOf;
                int i15 = 0;
                int i16 = 0;
                while (i15 < length5) {
                    int i17 = length5;
                    int i18 = copyOf3[i15];
                    int i19 = i16 + 1;
                    int[] iArr9 = copyOf2;
                    if (i18 >= 0) {
                        LazyStaggeredGridMeasuredItem andMeasure2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(i18, i16);
                        iArr7[i16] = iArr7[i16] + andMeasure2.getSizeWithSpacings();
                        i7 = i10;
                        arrayDequeArr[i16].addLast(andMeasure2);
                        lazyStaggeredGridMeasureContext.getSpans().setSpan(i18, i16);
                    } else {
                        i7 = i10;
                    }
                    i15++;
                    length5 = i17;
                    i16 = i19;
                    copyOf2 = iArr9;
                    i10 = i7;
                }
                int[] iArr10 = copyOf2;
                int i20 = i10;
                while (true) {
                    int i21 = 0;
                    while (true) {
                        if (i21 >= length4) {
                            z2 = false;
                            break;
                        }
                        int i22 = iArr7[i21];
                        if (i22 < coerceAtLeast || i22 <= 0) {
                            z2 = true;
                            break;
                        }
                        i21++;
                    }
                    if (!z2) {
                        int i23 = 0;
                        while (true) {
                            if (i23 >= length) {
                                z9 = true;
                                break;
                            }
                            if (!arrayDequeArr[i23].isEmpty()) {
                                z9 = false;
                                break;
                            }
                            i23++;
                        }
                        if (!z9) {
                            i4 = coerceAtLeast;
                            break;
                        }
                    }
                    int indexOfMinValue = indexOfMinValue(iArr7);
                    int findNextItemIndex = findNextItemIndex(lazyStaggeredGridMeasureContext2, copyOf3[indexOfMinValue], indexOfMinValue);
                    if (findNextItemIndex >= itemCount) {
                        int length6 = copyOf3.length;
                        int i24 = Integer.MAX_VALUE;
                        int i25 = 0;
                        int i26 = 0;
                        while (i25 < length6) {
                            int i27 = coerceAtLeast;
                            int i28 = copyOf3[i25];
                            int i29 = i26 + 1;
                            if (i26 != indexOfMinValue) {
                                int findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, i28, i26);
                                while (findNextItemIndex2 < itemCount) {
                                    int min = Math.min(findNextItemIndex2, i24);
                                    lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex2, -1);
                                    findNextItemIndex2 = findNextItemIndex(lazyStaggeredGridMeasureContext2, findNextItemIndex2, i26);
                                    i24 = min;
                                    length6 = length6;
                                }
                            }
                            i25++;
                            coerceAtLeast = i27;
                            i26 = i29;
                            length6 = length6;
                        }
                        i4 = coerceAtLeast;
                        if (i24 != Integer.MAX_VALUE && z) {
                            iArr[indexOfMinValue] = Math.min(iArr[indexOfMinValue], i24);
                            return measure(lazyStaggeredGridMeasureContext2, i8, iArr, iArr2, false);
                        }
                    } else {
                        int i30 = coerceAtLeast;
                        int i31 = i14;
                        String str3 = str2;
                        int[] iArr11 = iArr8;
                        int[] iArr12 = iArr10;
                        int i32 = i20;
                        if (iArr11[indexOfMinValue] == -1) {
                            iArr11[indexOfMinValue] = findNextItemIndex;
                        }
                        lazyStaggeredGridMeasureContext.getSpans().setSpan(findNextItemIndex, indexOfMinValue);
                        LazyStaggeredGridMeasuredItem andMeasure3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findNextItemIndex, indexOfMinValue);
                        iArr7[indexOfMinValue] = iArr7[indexOfMinValue] + andMeasure3.getSizeWithSpacings();
                        arrayDequeArr[indexOfMinValue].addLast(andMeasure3);
                        copyOf3[indexOfMinValue] = findNextItemIndex;
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                        i8 = i;
                        i20 = i32;
                        i14 = i31;
                        iArr10 = iArr12;
                        str2 = str3;
                        iArr8 = iArr11;
                        coerceAtLeast = i30;
                    }
                }
                for (int i33 = 0; i33 < length; i33++) {
                    ArrayDeque arrayDeque = arrayDequeArr[i33];
                    int i34 = iArr7[i33];
                    int lastIndex = CollectionsKt.getLastIndex(arrayDeque);
                    int i35 = 0;
                    int i36 = -1;
                    while (true) {
                        if (i36 >= lastIndex) {
                            lastIndex = i35;
                            break;
                        }
                        i34 -= ((LazyStaggeredGridMeasuredItem) arrayDeque.get(lastIndex)).getSizeWithSpacings();
                        if (i34 <= i20 + lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
                            break;
                        }
                        i36 = -1;
                        i35 = lastIndex;
                        lastIndex--;
                    }
                    for (int i37 = 0; i37 < lastIndex; i37++) {
                        iArr10[i33] = iArr10[i33] - ((LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst()).getSizeWithSpacings();
                    }
                    if (!arrayDeque.isEmpty()) {
                        iArr8[i33] = ((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIndex();
                    }
                }
                int i38 = 0;
                while (true) {
                    if (i38 >= length4) {
                        z3 = true;
                        break;
                    }
                    if (!(iArr7[i38] < lazyStaggeredGridMeasureContext.getMainAxisAvailableSize())) {
                        z3 = false;
                        break;
                    }
                    i38++;
                }
                if (z3) {
                    int mainAxisAvailableSize = lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() - iArr7[indexOfMaxValue(iArr7)];
                    iArr4 = iArr10;
                    offsetBy(iArr4, -mainAxisAvailableSize);
                    offsetBy(iArr7, mainAxisAvailableSize);
                    while (true) {
                        int length7 = iArr4.length;
                        int i39 = 0;
                        while (true) {
                            if (i39 >= length7) {
                                z8 = false;
                                break;
                            }
                            if (iArr4[i39] < lazyStaggeredGridMeasureContext.getBeforeContentPadding()) {
                                z8 = true;
                                break;
                            }
                            i39++;
                        }
                        if (!z8) {
                            i6 = i14;
                            iArr3 = iArr8;
                            break;
                        }
                        int indexOfMinValue2 = indexOfMinValue(iArr4);
                        int findPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, iArr8[indexOfMinValue2] == -1 ? itemCount : iArr8[indexOfMinValue2], indexOfMinValue2);
                        if (findPreviousItemIndex2 < 0) {
                            iArr3 = iArr8;
                            if (measure$lambda$18$misalignedStart(iArr3, lazyStaggeredGridMeasureContext2, iArr4, indexOfMinValue2) && z) {
                                lazyStaggeredGridMeasureContext.getSpans().reset();
                                int length8 = iArr3.length;
                                int[] iArr13 = new int[length8];
                                for (int i40 = 0; i40 < length8; i40++) {
                                    iArr13[i40] = -1;
                                }
                                int length9 = iArr4.length;
                                int[] iArr14 = new int[length9];
                                for (int i41 = 0; i41 < length9; i41++) {
                                    iArr14[i41] = iArr4[indexOfMinValue2];
                                }
                                return measure(lazyStaggeredGridMeasureContext2, i14, iArr13, iArr14, false);
                            }
                            i6 = i14;
                        } else {
                            lazyStaggeredGridMeasureContext.getSpans().setSpan(findPreviousItemIndex2, indexOfMinValue2);
                            LazyStaggeredGridMeasuredItem andMeasure4 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getAndMeasure(findPreviousItemIndex2, indexOfMinValue2);
                            arrayDequeArr[indexOfMinValue2].addFirst(andMeasure4);
                            iArr4[indexOfMinValue2] = iArr4[indexOfMinValue2] + andMeasure4.getSizeWithSpacings();
                            iArr8[indexOfMinValue2] = findPreviousItemIndex2;
                        }
                    }
                    i5 = i6 + mainAxisAvailableSize;
                    int indexOfMinValue3 = indexOfMinValue(iArr4);
                    if (iArr4[indexOfMinValue3] < 0) {
                        int i42 = iArr4[indexOfMinValue3];
                        i5 += i42;
                        offsetBy(iArr7, i42);
                        offsetBy(iArr4, -i42);
                    }
                } else {
                    i5 = i14;
                    iArr3 = iArr8;
                    iArr4 = iArr10;
                }
                float scrollToBeConsumed$foundation_release = (MathKt.getSign(MathKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) != MathKt.getSign(i5) || Math.abs(MathKt.roundToInt(lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(i5)) ? lazyStaggeredGridMeasureContext.getState().getScrollToBeConsumed$foundation_release() : i5;
                int[] copyOf4 = Arrays.copyOf(iArr4, iArr4.length);
                Intrinsics.checkNotNullExpressionValue(copyOf4, str2);
                int length10 = copyOf4.length;
                for (int i43 = 0; i43 < length10; i43++) {
                    copyOf4[i43] = -copyOf4[i43];
                }
                if (lazyStaggeredGridMeasureContext.getBeforeContentPadding() > 0) {
                    for (int i44 = 0; i44 < length; i44++) {
                        ArrayDeque arrayDeque2 = arrayDequeArr[i44];
                        int size = arrayDeque2.size();
                        int i45 = 0;
                        while (i45 < size) {
                            int sizeWithSpacings = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i45)).getSizeWithSpacings();
                            if (i45 != CollectionsKt.getLastIndex(arrayDeque2) && iArr4[i44] != 0 && iArr4[i44] >= sizeWithSpacings) {
                                iArr4[i44] = iArr4[i44] - sizeWithSpacings;
                                i45++;
                                iArr3[i44] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i45)).getIndex();
                            }
                        }
                    }
                }
                int m5184getMaxWidthimpl = lazyStaggeredGridMeasureContext.isVertical() ? Constraints.m5184getMaxWidthimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk()) : ConstraintsKt.m5198constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr7));
                int m5197constrainHeightK40F9xA = lazyStaggeredGridMeasureContext.isVertical() ? ConstraintsKt.m5197constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr7)) : Constraints.m5183getMaxHeightimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk());
                int i46 = 0;
                for (int i47 = 0; i47 < length; i47++) {
                    i46 += arrayDequeArr[i47].size();
                }
                final MutableVector mutableVector = new MutableVector(new LazyStaggeredGridPositionedItem[i46], 0);
                while (true) {
                    int i48 = 0;
                    while (true) {
                        if (i48 >= length) {
                            z4 = false;
                            break;
                        }
                        if (!arrayDequeArr[i48].isEmpty()) {
                            z4 = true;
                            break;
                        }
                        i48++;
                    }
                    if (!z4) {
                        break;
                    }
                    int i49 = -1;
                    int i50 = Integer.MAX_VALUE;
                    for (int i51 = 0; i51 < length; i51++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i51].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                        if (i50 > index) {
                            i50 = index;
                            i49 = i51;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i49].removeFirst();
                    mutableVector.add(lazyStaggeredGridMeasuredItem2.position(i49, copyOf4[i49], i49 == 0 ? 0 : lazyStaggeredGridMeasureContext.getResolvedSlotSums()[i49 - 1] + (lazyStaggeredGridMeasureContext.getCrossAxisSpacing() * i49)));
                    copyOf4[i49] = copyOf4[i49] + lazyStaggeredGridMeasuredItem2.getSizeWithSpacings();
                }
                boolean z10 = iArr3[0] != 0 || iArr4[0] > 0;
                int i52 = 0;
                while (true) {
                    if (i52 >= length4) {
                        z5 = false;
                        break;
                    }
                    if (iArr7[i52] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                        z5 = true;
                        break;
                    }
                    i52++;
                }
                if (!z5) {
                    int length11 = copyOf3.length;
                    int i53 = 0;
                    while (true) {
                        if (i53 >= length11) {
                            z7 = true;
                            break;
                        }
                        if (!(copyOf3[i53] < itemCount + (-1))) {
                            z7 = false;
                            break;
                        }
                        i53++;
                    }
                    if (!z7) {
                        z6 = false;
                        return new LazyStaggeredGridMeasureResult(iArr3, iArr4, scrollToBeConsumed$foundation_release, MeasureScope.CC.m140p(measureScope, m5184getMaxWidthimpl, m5197constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$13
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                                MutableVector<LazyStaggeredGridPositionedItem> mutableVector2 = mutableVector;
                                int size2 = mutableVector2.getSize();
                                if (size2 > 0) {
                                    int i54 = 0;
                                    LazyStaggeredGridPositionedItem[] content = mutableVector2.getContent();
                                    do {
                                        content[i54].place(placementScope);
                                        i54++;
                                    } while (i54 < size2);
                                }
                            }
                        }, 4, null), z6, z10, lazyStaggeredGridMeasureContext.isVertical(), itemCount, mutableVector.asMutableList(), IntSizeKt.IntSize(m5184getMaxWidthimpl, m5197constrainHeightK40F9xA), i20, i4, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), null);
                    }
                }
                z6 = true;
                return new LazyStaggeredGridMeasureResult(iArr3, iArr4, scrollToBeConsumed$foundation_release, MeasureScope.CC.m140p(measureScope, m5184getMaxWidthimpl, m5197constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        MutableVector<LazyStaggeredGridPositionedItem> mutableVector2 = mutableVector;
                        int size2 = mutableVector2.getSize();
                        if (size2 > 0) {
                            int i54 = 0;
                            LazyStaggeredGridPositionedItem[] content = mutableVector2.getContent();
                            do {
                                content[i54].place(placementScope);
                                i54++;
                            } while (i54 < size2);
                        }
                    }
                }, 4, null), z6, z10, lazyStaggeredGridMeasureContext.isVertical(), itemCount, mutableVector.asMutableList(), IntSizeKt.IntSize(m5184getMaxWidthimpl, m5197constrainHeightK40F9xA), i20, i4, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), null);
            }
        }
        return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.CC.m140p(measureScope, Constraints.m5186getMinWidthimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk()), Constraints.m5185getMinHeightimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
            }
        }, 4, null), false, false, lazyStaggeredGridMeasureContext.isVertical(), itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m5186getMinWidthimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk()), Constraints.m5185getMinHeightimpl(lazyStaggeredGridMeasureContext.m1635getConstraintsmsEJaDk())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), null);
    }

    private static final boolean measure$lambda$18$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < (-lazyStaggeredGridMeasureContext.getMainAxisSpacing()) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$18$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        boolean z;
        boolean z2;
        Collection indices = ArraysKt.getIndices(iArr);
        boolean z3 = indices instanceof Collection;
        if (!z3 || !indices.isEmpty()) {
            IntIterator it = indices.iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[nextInt], nextInt) == -1 && iArr2[nextInt] != iArr2[i]) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z3 || !indices.isEmpty()) {
            IntIterator it2 = indices.iterator();
            while (it2.hasNext()) {
                int nextInt2 = it2.nextInt();
                if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[nextInt2], nextInt2) != -1 && iArr2[nextInt2] >= iArr2[i]) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z || z2 || (lazyStaggeredGridMeasureContext.getSpans().getSpan(0) != 0);
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: measureStaggeredGrid-yR9pz_M, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1637measureStaggeredGridyR9pz_M(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull LazyStaggeredGridState lazyStaggeredGridState, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull int[] iArr, long j, boolean z, long j2, int i, int i2, int i3, int i4, int i5) {
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2;
        int findNextItemIndex;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$measureStaggeredGrid");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(iArr, "resolvedSlotSums");
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = r14;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, lazyLayoutItemProvider, iArr, j, z, lazyLayoutMeasureScope, i, j2, i4, i5, i2, i3, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                int[] indices = lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices();
                int[] offsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets();
                if (indices.length == iArr.length) {
                    lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                } else {
                    lazyStaggeredGridMeasureContext3.getSpans().reset();
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    int i6 = 0;
                    while (i6 < length) {
                        if (i6 < indices.length && indices[i6] != -1) {
                            findNextItemIndex = indices[i6];
                        } else if (i6 == 0) {
                            findNextItemIndex = 0;
                        } else {
                            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                            findNextItemIndex = findNextItemIndex(lazyStaggeredGridMeasureContext2, iArr2[i6 - 1], i6);
                            iArr2[i6] = findNextItemIndex;
                            lazyStaggeredGridMeasureContext2.getSpans().setSpan(iArr2[i6], i6);
                            i6++;
                            lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                        }
                        lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
                        iArr2[i6] = findNextItemIndex;
                        lazyStaggeredGridMeasureContext2.getSpans().setSpan(iArr2[i6], i6);
                        i6++;
                        lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                    }
                    lazyStaggeredGridMeasureContext = lazyStaggeredGridMeasureContext3;
                    indices = iArr2;
                }
                objectRef.element = indices;
                if (offsets.length != iArr.length) {
                    int length2 = iArr.length;
                    int[] iArr3 = new int[length2];
                    int i7 = 0;
                    while (i7 < length2) {
                        iArr3[i7] = i7 < offsets.length ? offsets[i7] : i7 == 0 ? 0 : iArr3[i7 - 1];
                        i7++;
                    }
                    offsets = iArr3;
                }
                objectRef2.element = offsets;
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.dispose();
                return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(lazyStaggeredGridState.getScrollToBeConsumed$foundation_release()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) function1.invoke(Integer.valueOf(iArr[i]))).intValue();
        }
        return iArr;
    }
}
