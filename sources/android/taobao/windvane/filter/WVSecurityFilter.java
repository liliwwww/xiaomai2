package android.taobao.windvane.filter;

import android.annotation.SuppressLint;
import android.taobao.windvane.service.WVWebViewClientFilter;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVSecurityFilter extends WVWebViewClientFilter {
    @SuppressLint({"NewApi", "DefaultLocale"})
    public WVWrapWebResourceResponse shouldInterceptRequest(IWVWebView iWVWebView, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVSecurityFilter", "WVSecurityFilter shouldInterceptRequest url =" + str);
        }
        return (TextUtils.isEmpty(str) || str.length() <= 6 || !str.substring(0, 7).toLowerCase().startsWith("file://")) ? super.shouldInterceptRequest(iWVWebView, str) : new WVWrapWebResourceResponse("", "utf-8", null, null);
    }
}
