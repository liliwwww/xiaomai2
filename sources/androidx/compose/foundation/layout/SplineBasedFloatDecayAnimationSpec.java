package androidx.compose.foundation.layout;

import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.foundation.layout.AndroidFlingSpline;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    private final float magicPhysicalCoefficient;

    public SplineBasedFloatDecayAnimationSpec(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.magicPhysicalCoefficient = 386.0878f * density.getDensity() * 160.0f * 0.84f;
    }

    private final double getSplineDeceleration(float f) {
        return AndroidFlingSpline.INSTANCE.deceleration(f, WindowInsetsConnection_androidKt.access$getPlatformFlingScrollFriction$p() * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float f) {
        return ((float) (WindowInsetsConnection_androidKt.access$getPlatformFlingScrollFriction$p() * this.magicPhysicalCoefficient * Math.exp((WindowInsetsConnection_androidKt.access$getDecelerationRate$p() / WindowInsetsConnection_androidKt.access$getDecelMinusOne$p()) * getSplineDeceleration(f)))) * Math.signum(f);
    }

    public float getAbsVelocityThreshold() {
        return 0.0f;
    }

    public long getDurationNanos(float f, float f2) {
        return (long) (Math.exp(getSplineDeceleration(f2) / WindowInsetsConnection_androidKt.access$getDecelMinusOne$p()) * 1.0E9d);
    }

    public float getTargetValue(float f, float f2) {
        return f + flingDistance(f2);
    }

    public float getValueFromNanos(long j, float f, float f2) {
        long durationNanos = getDurationNanos(0.0f, f2);
        return f + (flingDistance(f2) * AndroidFlingSpline.FlingResult.getDistanceCoefficient-impl(AndroidFlingSpline.INSTANCE.flingPosition-LfoxSSI(durationNanos > 0 ? j / durationNanos : 1.0f)));
    }

    public float getVelocityFromNanos(long j, float f, float f2) {
        long durationNanos = getDurationNanos(0.0f, f2);
        return ((AndroidFlingSpline.FlingResult.getVelocityCoefficient-impl(AndroidFlingSpline.INSTANCE.flingPosition-LfoxSSI(durationNanos > 0 ? j / durationNanos : 1.0f)) * flingDistance(f2)) / durationNanos) * 1.0E9f;
    }
}
