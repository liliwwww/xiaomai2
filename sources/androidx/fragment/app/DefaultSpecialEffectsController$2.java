package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$2 extends AnimatorListenerAdapter {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final /* synthetic */ ViewGroup val$container;
    final /* synthetic */ boolean val$isHideOperation;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;
    final /* synthetic */ View val$viewToAnimate;

    DefaultSpecialEffectsController$2(DefaultSpecialEffectsController defaultSpecialEffectsController, ViewGroup viewGroup, View view, boolean z, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$isHideOperation = z;
        this.val$operation = operation;
        this.val$animationInfo = animationInfo;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.val$container.endViewTransition(this.val$viewToAnimate);
        if (this.val$isHideOperation) {
            this.val$operation.getFinalState().applyState(this.val$viewToAnimate);
        }
        this.val$animationInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animator from operation " + this.val$operation + " has ended.");
        }
    }
}
