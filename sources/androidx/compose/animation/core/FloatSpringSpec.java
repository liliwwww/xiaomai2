package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.qk1;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;

    @NotNull
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public FloatSpringSpec(float f, float f2, float f3) {
        this.dampingRatio = f;
        this.stiffness = f2;
        this.visibilityThreshold = f3;
        SpringSimulation springSimulation = new SpringSimulation(1.0f);
        springSimulation.setDampingRatio(f);
        springSimulation.setStiffness(f2);
        this.spring = springSimulation;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public long getDurationNanos(float f, float f2, float f3) {
        float stiffness = this.spring.getStiffness();
        float dampingRatio = this.spring.getDampingRatio();
        float f4 = f - f2;
        float f5 = this.visibilityThreshold;
        return SpringEstimationKt.estimateAnimationDurationMillis(stiffness, dampingRatio, f3 / f5, f4 / f5, 1.0f) * AnimationKt.MillisToNanos;
    }

    public float getEndVelocity(float f, float f2, float f3) {
        return 0.0f;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public float getValueFromNanos(long j, float f, float f2, float f3) {
        long j2 = j / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(f2);
        return Motion.m78getValueimpl(this.spring.updateValues-IJZedt4$animation_core_release(f, f3, j2));
    }

    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long j2 = j / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(f2);
        return Motion.m79getVelocityimpl(this.spring.updateValues-IJZedt4$animation_core_release(f, f3, j2));
    }

    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return qk1.b(this, twoWayConverter);
    }

    /* renamed from: vectorize, reason: collision with other method in class */
    public /* synthetic */ VectorizedFloatAnimationSpec m67vectorize(TwoWayConverter twoWayConverter) {
        return qk1.c(this, twoWayConverter);
    }

    public /* synthetic */ FloatSpringSpec(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? 0.01f : f3);
    }
}
