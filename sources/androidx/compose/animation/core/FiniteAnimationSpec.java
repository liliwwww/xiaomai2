package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface FiniteAnimationSpec<T> extends AnimationSpec<T> {
    @NotNull
    /* renamed from: vectorize */
    <V extends AnimationVector> VectorizedFiniteAnimationSpec<V> mo83vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}
