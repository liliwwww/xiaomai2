package androidx.compose.foundation.layout;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.foundation.layout.AndroidFlingSpline;
import androidx.compose.p004ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    private final float magicPhysicalCoefficient;

    public SplineBasedFloatDecayAnimationSpec(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.magicPhysicalCoefficient = 386.0878f * density.getDensity() * 160.0f * 0.84f;
    }

    private final double getSplineDeceleration(float f) {
        float f2;
        AndroidFlingSpline androidFlingSpline = AndroidFlingSpline.INSTANCE;
        f2 = WindowInsetsConnection_androidKt.PlatformFlingScrollFriction;
        return androidFlingSpline.deceleration(f, f2 * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float f) {
        float f2;
        double d;
        double d2;
        double splineDeceleration = getSplineDeceleration(f);
        f2 = WindowInsetsConnection_androidKt.PlatformFlingScrollFriction;
        double d3 = f2 * this.magicPhysicalCoefficient;
        d = WindowInsetsConnection_androidKt.DecelerationRate;
        d2 = WindowInsetsConnection_androidKt.DecelMinusOne;
        return ((float) (d3 * Math.exp((d / d2) * splineDeceleration))) * Math.signum(f);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float f, float f2) {
        double d;
        double splineDeceleration = getSplineDeceleration(f2);
        d = WindowInsetsConnection_androidKt.DecelMinusOne;
        return (long) (Math.exp(splineDeceleration / d) * 1.0E9d);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float f, float f2) {
        return f + flingDistance(f2);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long j, float f, float f2) {
        long durationNanos = getDurationNanos(0.0f, f2);
        return f + (flingDistance(f2) * AndroidFlingSpline.FlingResult.m1336getDistanceCoefficientimpl(AndroidFlingSpline.INSTANCE.m1331flingPositionLfoxSSI(durationNanos > 0 ? j / durationNanos : 1.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long j, float f, float f2) {
        long durationNanos = getDurationNanos(0.0f, f2);
        return ((AndroidFlingSpline.FlingResult.m1337getVelocityCoefficientimpl(AndroidFlingSpline.INSTANCE.m1331flingPositionLfoxSSI(durationNanos > 0 ? j / durationNanos : 1.0f)) * flingDistance(f2)) / durationNanos) * 1.0E9f;
    }
}
