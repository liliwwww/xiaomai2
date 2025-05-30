package android.taobao.windvane.extra.uc;

import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$6 implements Runnable {
    final /* synthetic */ WVUCWebViewClient this$0;
    final /* synthetic */ WebView val$webview;

    WVUCWebViewClient$6(WVUCWebViewClient wVUCWebViewClient, WebView webView) {
        this.this$0 = wVUCWebViewClient;
        this.val$webview = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$webview.isDestroied()) {
            return;
        }
        this.val$webview.reload();
    }
}
