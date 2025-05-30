package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {
    long getDurationNanos(@NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getEndVelocity(@NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    boolean isInfinite();
}
