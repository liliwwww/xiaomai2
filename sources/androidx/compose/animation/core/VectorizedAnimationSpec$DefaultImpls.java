package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.dy5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorizedAnimationSpec$DefaultImpls {
    @Deprecated
    @NotNull
    public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        return (V) dy5.b(vectorizedAnimationSpec, v, v2, v3);
    }
}
