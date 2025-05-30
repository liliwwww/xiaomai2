package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import tb.qk1;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final int duration;

    @NotNull
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    public FloatTweenSpec(int i, int i2, @NotNull Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.duration = i;
        this.delay = i2;
        this.easing = easing;
    }

    private final long clampPlayTime(long j) {
        return RangesKt.coerceIn(j - this.delay, 0L, this.duration);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float f, float f2, float f3) {
        return (this.delay + this.duration) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public /* synthetic */ float getEndVelocity(float f, float f2, float f3) {
        return qk1.a(this, f, f2, f3);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        int i = this.duration;
        return VectorConvertersKt.lerp(f, f2, this.easing.transform(RangesKt.coerceIn(i == 0 ? 1.0f : clampPlayTime / i, 0.0f, 1.0f)));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        if (clampPlayTime < 0) {
            return 0.0f;
        }
        if (clampPlayTime == 0) {
            return f3;
        }
        return (getValueFromNanos(clampPlayTime * AnimationKt.MillisToNanos, f, f2, f3) - getValueFromNanos((clampPlayTime - 1) * AnimationKt.MillisToNanos, f, f2, f3)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return qk1.b(this, twoWayConverter);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return qk1.c(this, twoWayConverter);
    }

    public /* synthetic */ FloatTweenSpec(int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }
}
