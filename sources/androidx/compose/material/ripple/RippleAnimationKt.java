package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.constructor-impl(10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m892getRippleEndRadiuscSwnlzA(@NotNull Density density, boolean z, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$getRippleEndRadius");
        float f = Offset.getDistance-impl(OffsetKt.Offset(Size.getWidth-impl(j), Size.getHeight-impl(j))) / 2.0f;
        return z ? f + density.toPx-0680j_4(BoundedRippleExtraRadius) : f;
    }

    /* renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m893getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.getWidth-impl(j), Size.getHeight-impl(j)) * 0.3f;
    }
}
