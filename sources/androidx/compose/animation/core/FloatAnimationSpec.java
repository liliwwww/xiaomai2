package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.qk1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface FloatAnimationSpec extends AnimationSpec<Float> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static float getEndVelocity(@NotNull FloatAnimationSpec floatAnimationSpec, float f, float f2, float f3) {
            return qk1.d(floatAnimationSpec, f, f2, f3);
        }

        @Deprecated
        @NotNull
        public static <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull FloatAnimationSpec floatAnimationSpec, @NotNull TwoWayConverter<Float, V> twoWayConverter) {
            Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
            return qk1.e(floatAnimationSpec, twoWayConverter);
        }
    }

    long getDurationNanos(float f, float f2, float f3);

    float getEndVelocity(float f, float f2, float f3);

    float getValueFromNanos(long j, float f, float f2, float f3);

    float getVelocityFromNanos(long j, float f, float f2, float f3);

    @Override // androidx.compose.animation.core.AnimationSpec
    /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter);

    @Override // androidx.compose.animation.core.AnimationSpec
    @NotNull
    <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull TwoWayConverter<Float, V> twoWayConverter);
}
