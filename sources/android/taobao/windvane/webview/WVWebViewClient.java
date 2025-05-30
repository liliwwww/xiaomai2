package android.taobao.windvane.webview;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.net.MailTo;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVWebViewClient extends WebViewClient {
    private static final String TAG = "WVWebViewClient";
    boolean isError;
    protected Context mContext;
    private String currentUrl = null;
    private long mPageFinshTime = 0;
    public WebViewClient extraWebViewClient = null;

    public WVWebViewClient(Context context) {
        this.mContext = context;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        TaoLog.i(TAG, "onPageFinished : " + str);
        this.mPageFinshTime = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        if (webView instanceof WVWebView) {
            ((WVWebView) webView).setCurrentUrl(str, "onPageFinished");
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(WVEventId.PAGE_Finished, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
        }
        WVWebView wVWebView = (WVWebView) webView;
        if (TaoLog.getLogStatus()) {
            TaoLog.v(TAG, "Page finish: " + str);
        }
        wVWebView.onMessage(401, (Object) null);
        wVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", "8.5.0"));
        wVWebView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,lee:lee>0?lee-s:0})})(window.performance)", new 1(this, str));
        wVWebView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new 2(this, wVWebView));
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.isError = false;
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(WVEventId.PAGE_Started, (IWVWebView) webView, str, bitmap);
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "onPageStarted : " + str);
        }
        this.currentUrl = str;
        ((WVWebView) webView).onMessage(WVURLRuleConstants.CART, (Object) null);
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(WVEventId.PAGE_ReceivedError, (IWVWebView) webView, str2, Integer.valueOf(i), str, str2).isSuccess) {
            return;
        }
        String url = webView.getUrl();
        if (url == null || url.equals(str2)) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + "]");
            hashMap.put("url", str2);
            ((WVWebView) webView).onMessage(402, hashMap);
            this.isError = true;
            webView.setVisibility(4);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url == null) {
                url = str2;
            }
            errorMonitor.didOccurNativeError(url, i, str);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(WVEventId.PAGE_ReceivedSslError, (IWVWebView) webView, url, sslError2);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, WVEventId.PAGE_ReceivedSslError, sslError2);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0142  */
    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.webview.WVWebViewClient.shouldInterceptRequest(android.webkit.WebView, java.lang.String):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "ACCESS_FORBIDDEN");
                hashMap.put("url", str);
                ((WVWebView) webView).onMessage(402, hashMap);
            } else {
                webView.loadUrl(forbiddenDomainRedirectURL);
            }
            return true;
        }
        IWVWebView iWVWebView = (IWVWebView) webView;
        if (WVURLFilter.doFilter(str, this.mContext, iWVWebView)) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
            return true;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.v(TAG, "shouldOverrideUrlLoading: " + str);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(WVEventId.PAGE_OverrideUrlLoading, iWVWebView, str, new Object[0]).isSuccess) {
            return true;
        }
        if (str.startsWith(MailTo.MAILTO_SCHEME) || str.startsWith("tel:")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
            }
            return true;
        }
        try {
            if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                    WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                }
                if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(this.mContext, (IWVWebView) webView, str)) {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.v(TAG, "intercept url: " + str);
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
        }
        if (WVURLInterceptService.getWVABTestHandler() != null && WVUrlUtil.shouldTryABTest(str)) {
            String aBTestUrl = WVURLInterceptService.getWVABTestHandler().toABTestUrl(str);
            if (!TextUtils.isEmpty(aBTestUrl) && !aBTestUrl.equals(str)) {
                TaoLog.i(TAG, str + " abTestUrl to : " + aBTestUrl);
                webView.loadUrl(aBTestUrl);
                return true;
            }
        }
        if (webView instanceof WVWebView) {
            ((WVWebView) webView).setCurrentUrl(str, "shouldOverrideUrlLoading");
        }
        TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            return webViewClient.shouldOverrideUrlLoading(webView, str);
        }
        return false;
    }
}
