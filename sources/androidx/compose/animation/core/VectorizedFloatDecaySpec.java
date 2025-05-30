package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;

    @NotNull
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatDecaySpec(@NotNull FloatDecayAnimationSpec floatDecayAnimationSpec) {
        Intrinsics.checkNotNullParameter(floatDecayAnimationSpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long getDurationNanos(@NotNull V v, @NotNull V v2) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        long j = 0;
        for (int i = 0; i < size$animation_core_release; i++) {
            j = Math.max(j, this.floatDecaySpec.getDurationNanos(v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        return j;
    }

    @NotNull
    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    @NotNull
    public V getTargetValue(@NotNull V v, @NotNull V v2) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "initialVelocity");
        if (this.targetVector == null) {
            this.targetVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.targetVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.targetVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getTargetValue(v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.targetVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    @NotNull
    public V getValueFromNanos(long j, @NotNull V v, @NotNull V v2) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.valueVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getValueFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.velocityVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getVelocityFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
