package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransitionKt$updateTransition$2$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Transition $transition$inlined;

    public TransitionKt$updateTransition$2$1$invoke$$inlined$onDispose$1(Transition transition) {
        this.$transition$inlined = transition;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$transition$inlined.onTransitionEnd$animation_core_release();
    }
}
