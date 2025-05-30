package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridMeasureKt {
    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement$Vertical arrangement$Vertical, Arrangement$Horizontal arrangement$Horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int size = list.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i7);
        if (z3) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr[i9] = list.get(calculateItemsOffsets$reverseAware(i9, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i10 = 0; i10 < size2; i10++) {
                iArr2[i10] = 0;
            }
            if (z) {
                if (arrangement$Vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                arrangement$Vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (arrangement$Horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                arrangement$Horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
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
                    int i11 = iArr2[first];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i11 = (i6 - i11) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(i11, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list.size();
            int i12 = i5;
            for (int i13 = 0; i13 < size3; i13++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i13);
                arrayList.addAll(lazyMeasuredLine2.position(i12, i, i2));
                i12 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d1  */
    @org.jetbrains.annotations.NotNull
    /* renamed from: measureLazyGrid-0cYbdkg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m461measureLazyGrid0cYbdkg(int r24, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyMeasuredLineProvider r25, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider r26, int r27, int r28, int r29, int r30, int r31, int r32, float r33, long r34, boolean r36, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement$Vertical r37, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement$Horizontal r38, boolean r39, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r40, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r41, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable$PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r43) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m461measureLazyGrid0cYbdkg(int, androidx.compose.foundation.lazy.grid.LazyMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }
}
