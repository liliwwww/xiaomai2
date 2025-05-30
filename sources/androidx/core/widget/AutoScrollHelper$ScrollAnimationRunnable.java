package androidx.core.widget;

import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AutoScrollHelper$ScrollAnimationRunnable implements Runnable {
    final /* synthetic */ AutoScrollHelper this$0;

    AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
        this.this$0 = autoScrollHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        AutoScrollHelper autoScrollHelper = this.this$0;
        if (autoScrollHelper.mAnimating) {
            if (autoScrollHelper.mNeedsReset) {
                autoScrollHelper.mNeedsReset = false;
                autoScrollHelper.mScroller.start();
            }
            AutoScrollHelper.ClampedScroller clampedScroller = this.this$0.mScroller;
            if (clampedScroller.isFinished() || !this.this$0.shouldAnimate()) {
                this.this$0.mAnimating = false;
                return;
            }
            AutoScrollHelper autoScrollHelper2 = this.this$0;
            if (autoScrollHelper2.mNeedsCancel) {
                autoScrollHelper2.mNeedsCancel = false;
                autoScrollHelper2.cancelTargetTouch();
            }
            clampedScroller.computeScrollDelta();
            this.this$0.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
        }
    }
}
