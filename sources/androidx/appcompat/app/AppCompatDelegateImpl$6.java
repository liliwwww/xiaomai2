package androidx.appcompat.app;

import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$6 implements Runnable {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$6(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
        this.this$0.endOnGoingFadeAnimation();
        if (!this.this$0.shouldAnimateActionModeView()) {
            this.this$0.mActionModeView.setAlpha(1.0f);
            this.this$0.mActionModeView.setVisibility(0);
        } else {
            this.this$0.mActionModeView.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
            appCompatDelegateImpl2.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView).alpha(1.0f);
            this.this$0.mFadeAnim.setListener(new 1(this));
        }
    }
}
