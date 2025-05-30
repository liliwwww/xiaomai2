package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.dy5;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface VectorizedAnimationSpec<V extends AnimationVector> {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
            Intrinsics.checkNotNullParameter(v, "initialValue");
            Intrinsics.checkNotNullParameter(v2, "targetValue");
            Intrinsics.checkNotNullParameter(v3, "initialVelocity");
            return (V) dy5.b(vectorizedAnimationSpec, v, v2, v3);
        }
    }

    long getDurationNanos(@NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getEndVelocity(@NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    @NotNull
    V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3);

    boolean isInfinite();
}
