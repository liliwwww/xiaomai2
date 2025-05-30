package androidx.compose.material.ripple;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = C0856Dp.m5216constructorimpl(10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m2370getRippleEndRadiuscSwnlzA(@NotNull Density density, boolean z, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$getRippleEndRadius");
        float m2554getDistanceimpl = Offset.m2554getDistanceimpl(OffsetKt.Offset(Size.m2625getWidthimpl(j), Size.m2622getHeightimpl(j))) / 2.0f;
        return z ? m2554getDistanceimpl + density.mo1283toPx0680j_4(BoundedRippleExtraRadius) : m2554getDistanceimpl;
    }

    /* renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m2371getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m2625getWidthimpl(j), Size.m2622getHeightimpl(j)) * 0.3f;
    }
}
