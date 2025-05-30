package androidx.appcompat.view;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewPropertyAnimatorCompatSet$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;
    private boolean mProxyStarted = false;
    private int mProxyEndCount = 0;

    ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
        this.this$0 = viewPropertyAnimatorCompatSet;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
    public void onAnimationEnd(View view) {
        int i = this.mProxyEndCount + 1;
        this.mProxyEndCount = i;
        if (i == this.this$0.mAnimators.size()) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.this$0.mListener;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd((View) null);
            }
            onEnd();
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
    public void onAnimationStart(View view) {
        if (this.mProxyStarted) {
            return;
        }
        this.mProxyStarted = true;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.this$0.mListener;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart((View) null);
        }
    }

    void onEnd() {
        this.mProxyEndCount = 0;
        this.mProxyStarted = false;
        this.this$0.onAnimationsEnded();
    }
}
