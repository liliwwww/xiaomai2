package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ConstraintsKt {
    @Stable
    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')').toString());
        }
        if (!(i4 >= i3)) {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')').toString());
        }
        if (i >= 0 && i3 >= 0) {
            return Constraints.Companion.m2129createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        }
        throw new IllegalArgumentException(("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0").toString());
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }

    @Stable
    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m2133constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.getWidth-impl(j2), Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.getHeight-impl(j2), Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m2134constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m2124getMinWidthimpl(j2), Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2122getMaxWidthimpl(j2), Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2123getMinHeightimpl(j2), Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m2121getMaxHeightimpl(j2), Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(j)));
    }

    @Stable
    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m2135constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(j));
    }

    @Stable
    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m2136constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(j));
    }

    @Stable
    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m2137isSatisfiedBy4WqzIAM(long j, long j2) {
        int m2124getMinWidthimpl = Constraints.m2124getMinWidthimpl(j);
        int m2122getMaxWidthimpl = Constraints.m2122getMaxWidthimpl(j);
        int i = IntSize.getWidth-impl(j2);
        if (m2124getMinWidthimpl <= i && i <= m2122getMaxWidthimpl) {
            int m2123getMinHeightimpl = Constraints.m2123getMinHeightimpl(j);
            int m2121getMaxHeightimpl = Constraints.m2121getMaxHeightimpl(j);
            int i2 = IntSize.getHeight-impl(j2);
            if (m2123getMinHeightimpl <= i2 && i2 <= m2121getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m2138offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m2124getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m2122getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m2123getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m2121getMaxHeightimpl(j), i2));
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m2139offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m2138offsetNN6EwU(j, i, i2);
    }
}
