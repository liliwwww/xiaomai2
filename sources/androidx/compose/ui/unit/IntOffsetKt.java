package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m2637constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    @Stable
    /* renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m2654lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m2643getXimpl(j), IntOffset.m2643getXimpl(j2), f), MathHelpersKt.lerp(IntOffset.m2644getYimpl(j), IntOffset.m2644getYimpl(j2), f));
    }

    @Stable
    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m2655minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.getX-impl(j) - IntOffset.m2643getXimpl(j2), Offset.getY-impl(j) - IntOffset.m2644getYimpl(j2));
    }

    @Stable
    /* renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m2656minusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m2643getXimpl(j) - Offset.getX-impl(j2), IntOffset.m2644getYimpl(j) - Offset.getY-impl(j2));
    }

    @Stable
    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m2657plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.getX-impl(j) + IntOffset.m2643getXimpl(j2), Offset.getY-impl(j) + IntOffset.m2644getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m2658plusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m2643getXimpl(j) + Offset.getX-impl(j2), IntOffset.m2644getYimpl(j) + Offset.getY-impl(j2));
    }

    @Stable
    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m2659roundk4lQ0M(long j) {
        return IntOffset(MathKt.roundToInt(Offset.getX-impl(j)), MathKt.roundToInt(Offset.getY-impl(j)));
    }

    @Stable
    /* renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m2660toOffsetgyyYBs(long j) {
        return OffsetKt.Offset(IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j));
    }
}
