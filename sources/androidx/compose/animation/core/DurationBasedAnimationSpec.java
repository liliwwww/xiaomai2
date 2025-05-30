package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DurationBasedAnimationSpec<T> extends FiniteAnimationSpec<T> {
    @NotNull
    /* renamed from: vectorize */
    <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> mo88vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter);
}
