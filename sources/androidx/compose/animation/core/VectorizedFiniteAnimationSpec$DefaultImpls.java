package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.fy5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorizedFiniteAnimationSpec$DefaultImpls {
    @Deprecated
    @NotNull
    public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        return (V) fy5.b(vectorizedFiniteAnimationSpec, v, v2, v3);
    }

    @Deprecated
    public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
        return fy5.c(vectorizedFiniteAnimationSpec);
    }
}
