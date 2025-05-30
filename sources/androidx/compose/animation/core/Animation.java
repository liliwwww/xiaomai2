package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;
import tb.u8;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Animation<T, V extends AnimationVector> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static <T, V extends AnimationVector> boolean isFinishedFromNanos(@NotNull Animation<T, V> animation, long j) {
            return u8.b(animation, j);
        }
    }

    long getDurationNanos();

    T getTargetValue();

    @NotNull
    TwoWayConverter<T, V> getTypeConverter();

    T getValueFromNanos(long j);

    @NotNull
    V getVelocityVectorFromNanos(long j);

    boolean isFinishedFromNanos(long j);

    boolean isInfinite();
}
