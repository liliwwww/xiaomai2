package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Transition$3 extends AnimatorListenerAdapter {
    final /* synthetic */ Transition this$0;

    Transition$3(Transition transition) {
        this.this$0 = transition;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.this$0.end();
        animator.removeListener(this);
    }
}
