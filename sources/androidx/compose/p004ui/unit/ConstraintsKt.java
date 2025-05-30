package androidx.compose.p004ui.unit;

import androidx.compose.runtime.Stable;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
            return Constraints.Companion.m5191createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
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
    public static final long m5195constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m5376getWidthimpl(j2), Constraints.m5186getMinWidthimpl(j), Constraints.m5184getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m5375getHeightimpl(j2), Constraints.m5185getMinHeightimpl(j), Constraints.m5183getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m5196constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m5186getMinWidthimpl(j2), Constraints.m5186getMinWidthimpl(j), Constraints.m5184getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m5184getMaxWidthimpl(j2), Constraints.m5186getMinWidthimpl(j), Constraints.m5184getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m5185getMinHeightimpl(j2), Constraints.m5185getMinHeightimpl(j), Constraints.m5183getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m5183getMaxHeightimpl(j2), Constraints.m5185getMinHeightimpl(j), Constraints.m5183getMaxHeightimpl(j)));
    }

    @Stable
    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m5197constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m5185getMinHeightimpl(j), Constraints.m5183getMaxHeightimpl(j));
    }

    @Stable
    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m5198constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m5186getMinWidthimpl(j), Constraints.m5184getMaxWidthimpl(j));
    }

    @Stable
    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m5199isSatisfiedBy4WqzIAM(long j, long j2) {
        int m5186getMinWidthimpl = Constraints.m5186getMinWidthimpl(j);
        int m5184getMaxWidthimpl = Constraints.m5184getMaxWidthimpl(j);
        int m5376getWidthimpl = IntSize.m5376getWidthimpl(j2);
        if (m5186getMinWidthimpl <= m5376getWidthimpl && m5376getWidthimpl <= m5184getMaxWidthimpl) {
            int m5185getMinHeightimpl = Constraints.m5185getMinHeightimpl(j);
            int m5183getMaxHeightimpl = Constraints.m5183getMaxHeightimpl(j);
            int m5375getHeightimpl = IntSize.m5375getHeightimpl(j2);
            if (m5185getMinHeightimpl <= m5375getHeightimpl && m5375getHeightimpl <= m5183getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m5200offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m5186getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m5184getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m5185getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m5183getMaxHeightimpl(j), i2));
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m5201offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m5200offsetNN6EwU(j, i, i2);
    }
}
