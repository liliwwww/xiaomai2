package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AnimatedVectorDrawableCompat$2 extends AnimatorListenerAdapter {
    final /* synthetic */ AnimatedVectorDrawableCompat this$0;

    AnimatedVectorDrawableCompat$2(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ArrayList arrayList = new ArrayList(this.this$0.mAnimationCallbacks);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat$AnimationCallback) arrayList.get(i)).onAnimationEnd(this.this$0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ArrayList arrayList = new ArrayList(this.this$0.mAnimationCallbacks);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat$AnimationCallback) arrayList.get(i)).onAnimationStart(this.this$0);
        }
    }
}
