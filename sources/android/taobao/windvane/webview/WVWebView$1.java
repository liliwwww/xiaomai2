package android.taobao.windvane.webview;

import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.view.View;
import android.webkit.WebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVWebView$1 implements View.OnLongClickListener {
    final /* synthetic */ WVWebView this$0;

    WVWebView$1(WVWebView wVWebView) {
        this.this$0 = wVWebView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        WebView.HitTestResult hitTestResult;
        try {
            hitTestResult = this.this$0.getHitTestResult();
        } catch (Exception unused) {
            hitTestResult = null;
        }
        if (hitTestResult == null || !WVWebView.access$000(this.this$0)) {
            return false;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVWebView", "Long click on WebView, " + hitTestResult.getExtra());
        }
        if (hitTestResult.getType() != 8 && hitTestResult.getType() != 5) {
            return false;
        }
        WVWebView.access$102(this.this$0, hitTestResult.getExtra());
        WVWebView wVWebView = this.this$0;
        WVWebView.access$202(wVWebView, new PopupWindowController(wVWebView.context, wVWebView, WVWebView.access$300(wVWebView), WVWebView.access$400(this.this$0)));
        WVWebView.access$200(this.this$0).show();
        return true;
    }
}
