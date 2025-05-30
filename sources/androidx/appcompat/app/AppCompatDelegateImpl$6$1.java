package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AppCompatDelegateImpl$6$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ AppCompatDelegateImpl.6 this$1;

    AppCompatDelegateImpl$6$1(AppCompatDelegateImpl.6 r1) {
        this.this$1 = r1;
    }

    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
        this.this$1.this$0.mFadeAnim.setListener((ViewPropertyAnimatorListener) null);
        this.this$1.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(0);
    }
}
