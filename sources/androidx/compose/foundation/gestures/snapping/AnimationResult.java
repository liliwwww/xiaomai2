package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class AnimationResult<T, V extends AnimationVector> {

    @NotNull
    private final AnimationState<T, V> currentAnimationState;
    private final T remainingOffset;

    public AnimationResult(T t, @NotNull AnimationState<T, V> animationState) {
        Intrinsics.checkNotNullParameter(animationState, "currentAnimationState");
        this.remainingOffset = t;
        this.currentAnimationState = animationState;
    }

    public final T component1() {
        return this.remainingOffset;
    }

    @NotNull
    public final AnimationState<T, V> component2() {
        return this.currentAnimationState;
    }

    @NotNull
    public final AnimationState<T, V> getCurrentAnimationState() {
        return this.currentAnimationState;
    }

    public final T getRemainingOffset() {
        return this.remainingOffset;
    }
}
