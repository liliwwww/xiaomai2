package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ey5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> long getDurationNanos(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            Intrinsics.checkNotNullParameter(v, "initialValue");
            Intrinsics.checkNotNullParameter(v2, "targetValue");
            Intrinsics.checkNotNullParameter(v3, "initialVelocity");
            return ey5.b(vectorizedDurationBasedAnimationSpec, v, v2, v3);
        }

        @Deprecated
        @NotNull
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            Intrinsics.checkNotNullParameter(v, "initialValue");
            Intrinsics.checkNotNullParameter(v2, "targetValue");
            Intrinsics.checkNotNullParameter(v3, "initialVelocity");
            return (V) ey5.c(vectorizedDurationBasedAnimationSpec, v, v2, v3);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec) {
            return ey5.d(vectorizedDurationBasedAnimationSpec);
        }
    }

    int getDelayMillis();

    int getDurationMillis();

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    long getDurationNanos(@NotNull V v, @NotNull V v2, @NotNull V v3);
}
