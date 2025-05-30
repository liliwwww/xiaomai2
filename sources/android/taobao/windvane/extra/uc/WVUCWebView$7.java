package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.view.View;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebView$7 implements View.OnLongClickListener {
    final /* synthetic */ WVUCWebView this$0;

    WVUCWebView$7(WVUCWebView wVUCWebView) {
        this.this$0 = wVUCWebView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        try {
            WebView.HitTestResult hitTestResult = this.this$0.getHitTestResult();
            if (hitTestResult == null || !WVUCWebView.access$1200(this.this$0)) {
                return false;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVUCWebView", "Long click on WebView, " + hitTestResult.getExtra());
            }
            if (hitTestResult.getType() != 8 && hitTestResult.getType() != 5) {
                return false;
            }
            WVUCWebView.access$102(this.this$0, hitTestResult.getExtra());
            WVUCWebView wVUCWebView = this.this$0;
            Context _getContext = wVUCWebView._getContext();
            WVUCWebView wVUCWebView2 = this.this$0;
            WVUCWebView.access$202(wVUCWebView, new PopupWindowController(_getContext, wVUCWebView2, WVUCWebView.access$000(wVUCWebView2), WVUCWebView.access$1300(this.this$0)));
            WVUCWebView.access$200(this.this$0).show();
            return true;
        } catch (Exception e) {
            TaoLog.e("WVUCWebView", "getHitTestResult error:" + e.getMessage());
            return false;
        }
    }
}
