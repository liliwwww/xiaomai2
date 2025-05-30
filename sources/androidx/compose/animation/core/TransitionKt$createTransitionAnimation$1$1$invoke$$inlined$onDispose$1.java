package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Transition $this_createTransitionAnimation$inlined;
    final /* synthetic */ Transition.TransitionAnimationState $transitionAnimation$inlined;

    public TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1(Transition transition, Transition.TransitionAnimationState transitionAnimationState) {
        this.$this_createTransitionAnimation$inlined = transition;
        this.$transitionAnimation$inlined = transitionAnimationState;
    }

    public void dispose() {
        this.$this_createTransitionAnimation$inlined.removeAnimation$animation_core_release(this.$transitionAnimation$inlined);
    }
}
