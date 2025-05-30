package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface VectorizedDecayAnimationSpec<V extends AnimationVector> {
    float getAbsVelocityThreshold();

    long getDurationNanos(@NotNull V v, @NotNull V v2);

    @NotNull
    V getTargetValue(@NotNull V v, @NotNull V v2);

    @NotNull
    V getValueFromNanos(long j, @NotNull V v, @NotNull V v2);

    @NotNull
    V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2);
}
