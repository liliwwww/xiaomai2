package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface AnimationSpec<T> {
    @NotNull
    <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}
