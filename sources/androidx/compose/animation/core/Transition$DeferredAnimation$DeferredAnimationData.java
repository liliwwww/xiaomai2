package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super S, ? extends T> */
/* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.Transition$Segment<S>, ? extends androidx.compose.animation.core.FiniteAnimationSpec<T>> */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Transition$DeferredAnimation$DeferredAnimationData<T, V extends AnimationVector> implements State<T> {

    @NotNull
    private final Transition<S>.TransitionAnimationState<T, V> animation;

    @NotNull
    private Function1<? super S, ? extends T> targetValueByState;
    final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;

    @NotNull
    private Function1<? super Transition$Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super S, ? extends T> */
    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.Transition$Segment<S>, ? extends androidx.compose.animation.core.FiniteAnimationSpec<T>> */
    public Transition$DeferredAnimation$DeferredAnimationData(@NotNull Transition.DeferredAnimation deferredAnimation, @NotNull Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, @NotNull Function1<? super Transition$Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, "animation");
        Intrinsics.checkNotNullParameter(function1, "transitionSpec");
        Intrinsics.checkNotNullParameter(function12, "targetValueByState");
        this.this$0 = deferredAnimation;
        this.animation = transitionAnimationState;
        this.transitionSpec = function1;
        this.targetValueByState = function12;
    }

    @NotNull
    public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
        return this.animation;
    }

    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<S, T> */
    @NotNull
    public final Function1<S, T> getTargetValueByState() {
        return this.targetValueByState;
    }

    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<androidx.compose.animation.core.Transition$Segment<S>, androidx.compose.animation.core.FiniteAnimationSpec<T>> */
    @NotNull
    public final Function1<Transition$Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
        return this.transitionSpec;
    }

    public T getValue() {
        updateAnimationStates(this.this$0.this$0.getSegment());
        return (T) this.animation.getValue();
    }

    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super S, ? extends T> */
    public final void setTargetValueByState(@NotNull Function1<? super S, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.targetValueByState = function1;
    }

    /* JADX WARN: Unknown type variable: S in type: kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.Transition$Segment<S>, ? extends androidx.compose.animation.core.FiniteAnimationSpec<T>> */
    public final void setTransitionSpec(@NotNull Function1<? super Transition$Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.transitionSpec = function1;
    }

    /* JADX WARN: Unknown type variable: S in type: androidx.compose.animation.core.Transition$Segment<S> */
    public final void updateAnimationStates(@NotNull Transition$Segment<S> transition$Segment) {
        Intrinsics.checkNotNullParameter(transition$Segment, "segment");
        Object invoke = this.targetValueByState.invoke(transition$Segment.getTargetState());
        if (!this.this$0.this$0.isSeeking()) {
            this.animation.updateTargetValue$animation_core_release(invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(transition$Segment));
        } else {
            this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(transition$Segment.getInitialState()), invoke, (FiniteAnimationSpec) this.transitionSpec.invoke(transition$Segment));
        }
    }
}
