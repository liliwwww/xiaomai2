package android.taobao.windvane.extra.uc;

import android.os.SystemClock;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.taobao.monitor.procedure.ViewToken;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$1 implements ValueCallback<String> {
    final /* synthetic */ WVUCWebViewClient this$0;
    final /* synthetic */ WVUCWebView val$webview;

    WVUCWebViewClient$1(WVUCWebViewClient wVUCWebViewClient, WVUCWebView wVUCWebView) {
        this.this$0 = wVUCWebViewClient;
        this.val$webview = wVUCWebView;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(String str) {
        try {
            JSONObject metaObject = this.this$0.getMetaObject(str);
            if (metaObject != null && this.val$webview != null) {
                if (!metaObject.has("WV.Meta.Performance.JSFSP")) {
                    this.val$webview.setTag(ViewToken.APM_VIEW_TOKEN, "valid_view");
                    TaoLog.d("WVUCWebViewClient", "no JSFSP setTag " + SystemClock.uptimeMillis());
                } else if (TextUtils.isEmpty(metaObject.optString("WV.Meta.Performance.JSFSP"))) {
                    this.val$webview.setTag(ViewToken.APM_VIEW_TOKEN, "valid_view");
                    TaoLog.d("WVUCWebViewClient", "no version setTag " + SystemClock.uptimeMillis());
                } else if (!this.val$webview.isReportedFSP()) {
                    this.val$webview.setTag(ViewToken.APM_VIEW_TOKEN, "invalid_view");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
