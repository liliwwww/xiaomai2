package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActionBarOverlayLayout$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ActionBarOverlayLayout this$0;

    ActionBarOverlayLayout$1(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
        actionBarOverlayLayout.mAnimatingForFling = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
        actionBarOverlayLayout.mAnimatingForFling = false;
    }
}
