package android.taobao.windvane.extra.uc;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebView$8 implements Runnable {
    final /* synthetic */ WVUCWebView this$0;
    final /* synthetic */ View val$v;

    WVUCWebView$8(WVUCWebView wVUCWebView, View view) {
        this.this$0 = wVUCWebView;
        this.val$v = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$v.requestLayout();
    }
}
