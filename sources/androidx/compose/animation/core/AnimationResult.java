package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimationResult<T, V extends AnimationVector> {
    public static final int $stable = 0;

    @NotNull
    private final AnimationEndReason endReason;

    @NotNull
    private final AnimationState<T, V> endState;

    public AnimationResult(@NotNull AnimationState<T, V> animationState, @NotNull AnimationEndReason animationEndReason) {
        Intrinsics.checkNotNullParameter(animationState, "endState");
        Intrinsics.checkNotNullParameter(animationEndReason, "endReason");
        this.endState = animationState;
        this.endReason = animationEndReason;
    }

    @NotNull
    public final AnimationEndReason getEndReason() {
        return this.endReason;
    }

    @NotNull
    public final AnimationState<T, V> getEndState() {
        return this.endState;
    }

    @NotNull
    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + ')';
    }
}
