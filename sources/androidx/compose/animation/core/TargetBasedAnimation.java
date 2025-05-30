package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.u8;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;

    @NotNull
    private final VectorizedAnimationSpec<V> animationSpec;
    private final long durationNanos;

    @NotNull
    private final V endVelocity;
    private final T initialValue;

    @NotNull
    private final V initialValueVector;

    @NotNull
    private final V initialVelocityVector;
    private final T targetValue;

    @NotNull
    private final V targetValueVector;

    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    public TargetBasedAnimation(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, T t2, @Nullable V v) {
        Intrinsics.checkNotNullParameter(vectorizedAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        this.animationSpec = vectorizedAnimationSpec;
        this.typeConverter = twoWayConverter;
        this.initialValue = t;
        this.targetValue = t2;
        V v2 = (V) getTypeConverter().getConvertToVector().invoke(t);
        this.initialValueVector = v2;
        V v3 = (V) getTypeConverter().getConvertToVector().invoke(getTargetValue());
        this.targetValueVector = v3;
        V v4 = (v == null || (v4 = (V) AnimationVectorsKt.copy(v)) == null) ? (V) AnimationVectorsKt.newInstance((AnimationVector) getTypeConverter().getConvertToVector().invoke(t)) : v4;
        this.initialVelocityVector = v4;
        this.durationNanos = vectorizedAnimationSpec.getDurationNanos(v2, v3, v4);
        this.endVelocity = (V) vectorizedAnimationSpec.getEndVelocity(v2, v3, v4);
    }

    @NotNull
    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public T getTargetValue() {
        return this.targetValue;
    }

    @NotNull
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public T getValueFromNanos(long j) {
        if (isFinishedFromNanos(j)) {
            return getTargetValue();
        }
        AnimationVector valueFromNanos = this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int size$animation_core_release = valueFromNanos.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            if (!(!Float.isNaN(valueFromNanos.get$animation_core_release(i)))) {
                throw new IllegalStateException(("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j).toString());
            }
        }
        return (T) getTypeConverter().getConvertFromVector().invoke(valueFromNanos);
    }

    @NotNull
    public V getVelocityVectorFromNanos(long j) {
        return !isFinishedFromNanos(j) ? (V) this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector) : this.endVelocity;
    }

    public /* synthetic */ boolean isFinishedFromNanos(long j) {
        return u8.a(this, j);
    }

    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    @NotNull
    public String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }

    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((VectorizedAnimationSpec<AnimationVector>) vectorizedAnimationSpec, (TwoWayConverter<Object, AnimationVector>) twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((AnimationSpec<Object>) animationSpec, (TwoWayConverter<Object, AnimationVector>) twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TargetBasedAnimation(@NotNull AnimationSpec<T> animationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, T t2, @Nullable V v) {
        this(animationSpec.mo83vectorize(twoWayConverter), twoWayConverter, t, t2, v);
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
    }
}
