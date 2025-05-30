package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: Access modifiers changed from: protected */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
    private boolean mCanceled = false;
    int mFinalVisibility;
    final /* synthetic */ AbsActionBarView this$0;

    protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(View view) {
        if (this.mCanceled) {
            return;
        }
        AbsActionBarView absActionBarView = this.this$0;
        absActionBarView.mVisibilityAnim = null;
        AbsActionBarView.access$101(absActionBarView, this.mFinalVisibility);
    }

    public void onAnimationStart(View view) {
        AbsActionBarView.access$001(this.this$0, 0);
        this.mCanceled = false;
    }

    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
        this.this$0.mVisibilityAnim = viewPropertyAnimatorCompat;
        this.mFinalVisibility = i;
        return this;
    }
}
