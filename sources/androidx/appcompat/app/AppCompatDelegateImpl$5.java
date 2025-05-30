package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$5 implements ContentFrameLayout.OnAttachListener {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$5(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onAttachedFromWindow() {
    }

    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }
}
