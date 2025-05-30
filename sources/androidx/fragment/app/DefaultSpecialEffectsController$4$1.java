package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DefaultSpecialEffectsController$4$1 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController.4 this$1;

    DefaultSpecialEffectsController$4$1(DefaultSpecialEffectsController.4 r1) {
        this.this$1 = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultSpecialEffectsController.4 r0 = this.this$1;
        r0.val$container.endViewTransition(r0.val$viewToAnimate);
        this.this$1.val$animationInfo.completeSpecialEffect();
    }
}
