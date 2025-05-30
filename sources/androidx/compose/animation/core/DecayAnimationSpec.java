package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DecayAnimationSpec<T> {
    @NotNull
    <V extends AnimationVector> VectorizedDecayAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}
