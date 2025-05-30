package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m5328constructorimpl((i2 & 4294967295L) | (i << 32));
    }

    @Stable
    /* renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m5345lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m5334getXimpl(j), IntOffset.m5334getXimpl(j2), f), MathHelpersKt.lerp(IntOffset.m5335getYimpl(j), IntOffset.m5335getYimpl(j2), f));
    }

    @Stable
    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m5346minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m2556getXimpl(j) - IntOffset.m5334getXimpl(j2), Offset.m2557getYimpl(j) - IntOffset.m5335getYimpl(j2));
    }

    @Stable
    /* renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m5347minusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m5334getXimpl(j) - Offset.m2556getXimpl(j2), IntOffset.m5335getYimpl(j) - Offset.m2557getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m5348plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m2556getXimpl(j) + IntOffset.m5334getXimpl(j2), Offset.m2557getYimpl(j) + IntOffset.m5335getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m5349plusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m5334getXimpl(j) + Offset.m2556getXimpl(j2), IntOffset.m5335getYimpl(j) + Offset.m2557getYimpl(j2));
    }

    @Stable
    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m5350roundk4lQ0M(long j) {
        return IntOffset(MathKt.roundToInt(Offset.m2556getXimpl(j)), MathKt.roundToInt(Offset.m2557getYimpl(j)));
    }

    @Stable
    /* renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m5351toOffsetgyyYBs(long j) {
        return OffsetKt.Offset(IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j));
    }
}
