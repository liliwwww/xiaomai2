package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVUCPrecacheManager;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVConstants;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVURLFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.RenderProcessGoneDetail;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVUCWebViewClient extends WebViewClient {
    private static final String SANDBOX_TAG = "WVUCWebViewClient.sandbox";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_SMS = "sms:";
    public static final String SCHEME_TEL = "tel:";
    private static final String TAG = "WVUCWebViewClient";
    boolean isError;
    protected WeakReference<Context> mContext;
    private Handler mRenderProcessHandler;
    public int crashCount = 0;
    private boolean useOldBridge = false;
    private Runnable mCrashCountReseter = new 5(this);

    public WVUCWebViewClient(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public static String getMetaDataScript() {
        String[] strArr = {"WV.Meta.Performance.JSFSP"};
        String str = "(function(){var d=document,r={}";
        String str2 = "";
        for (int i = 0; i < 1; i++) {
            str = str + String.format(",n%d='%s',e%d=d.getElementById(n%d)", Integer.valueOf(i), strArr[i], Integer.valueOf(i), Integer.valueOf(i));
            str2 = str2 + String.format("if(e%d){r[n%d]=e%d.getAttribute('value')}", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i));
        }
        return str + String.format(";%sreturn JSON.stringify(r);})()", str2);
    }

    private void getMetaInfo(WVUCWebView wVUCWebView) {
        String metaDataScript = getMetaDataScript();
        if (metaDataScript == null || wVUCWebView == null) {
            return;
        }
        wVUCWebView.evaluateJavascript(metaDataScript, new 1(this, wVUCWebView));
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0139  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006b -> B:17:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.uc.webview.export.WebResourceResponse shouldInterceptRequestInternal(com.uc.webview.export.WebView r11, java.lang.String r12, android.taobao.windvane.service.WVEventResult r13) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.uc.WVUCWebViewClient.shouldInterceptRequestInternal(com.uc.webview.export.WebView, java.lang.String, android.taobao.windvane.service.WVEventResult):com.uc.webview.export.WebResourceResponse");
    }

    private void tryPreCacheResources(WebView webView) {
        if (WVUCPrecacheManager.canClearPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            UCCore.clearPrecacheResources((String[]) null);
            WVUCPrecacheManager.setHasPrecache(false);
        }
        if (WVUCPrecacheManager.canPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            WVUCPrecacheManager.resetPrecacheConfig();
            HashSet<String> preMemCacheUrlSet = WVUCPrecacheManager.preMemCacheUrlSet();
            if (preMemCacheUrlSet != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> it = preMemCacheUrlSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    WebResourceResponse shouldInterceptRequest = shouldInterceptRequest(webView, new WebResourceRequest(next, new HashMap()));
                    if (shouldInterceptRequest != null) {
                        hashMap.put(next, shouldInterceptRequest);
                    }
                }
                if (hashMap.size() > 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("maxAge", "3600");
                    hashMap2.put("ignoreQuery", "1");
                    UCCore.precacheResources(hashMap, hashMap2);
                    WVUCPrecacheManager.setHasPrecache(true);
                }
            }
        }
    }

    public JSONObject getMetaObject(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            return new JSONObject(str.replace("\\", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String str2;
        TaoLog.e(TAG, "onPageFinished : " + str);
        if (webView instanceof IFullTrace) {
            IFullTrace iFullTrace = (IFullTrace) webView;
            FullTraceUtils.addStage(iFullTrace.getSpanWrapper(), "onPageFinished");
            FullTraceUtils.addProperty(iFullTrace.getSpanWrapper(), "H5_URL", str);
        }
        try {
            if (webView instanceof WVUCWebView) {
                getMetaInfo((WVUCWebView) webView);
            } else {
                TaoLog.e(TAG, "view is " + webView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFinishLoad(str, webView);
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        UCExtension uCExtension = null;
        if (webView instanceof WVUCWebView) {
            wVUCWebView.setCurrentUrl(str, "onPageFinished");
            wVUCWebView.onMessage(401, null);
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_HAND, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
            iWVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", GlobalConfig.VERSION));
        }
        if (WVMonitorService.getPerformanceMonitor() != null) {
            UCExtension uCExtension2 = webView.getUCExtension();
            boolean isLoadFromCachedPage = uCExtension2 != null ? uCExtension2.isLoadFromCachedPage() : false;
            str2 = null;
            WVMonitorService.getPerformanceMonitor().didGetPageStatusCode(str, -1, isLoadFromCachedPage ? 72 : WVUCWebView.getFromType(), null, null, null, null, null);
            uCExtension = uCExtension2;
        } else {
            str2 = null;
        }
        webView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,les=t.loadEventStart,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,les:les>0?les-s:0,lee:lee>0?lee-s:0})})(window.performance)", new 2(this, str, currentTimeMillis));
        TaoLog.i(TAG, str + " LayerType : " + webView.getLayerType());
        if (webView.getCurrentViewCoreType() == 2) {
            webView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new 3(this, webView));
        }
        if (WebView.getCoreType() == 1 || WebView.getCoreType() == 3) {
            TaoLog.d(TAG, "onPageFinished.  core type = " + WebView.getCoreType());
            AppMonitorUtil.commitSuccess("WebViewCoreTypeByPV", str2);
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "U4");
            }
            if (uCExtension != null && !((WVUCWebView) webView).isStaticWebView()) {
                if (CommonUtils.isMainProcess(webView.getContext())) {
                    uCExtension.getCoreStatus(2, new 4(this));
                } else if (WVMonitorService.getWvMonitorInterface() != null) {
                    WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV("0", "0", "-1", "0", "0", "-1");
                }
            }
        } else {
            AppMonitorUtil.commitFail("WebViewCoreTypeByPV", WebView.getCoreType(), "", "");
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "Android");
            }
        }
        if (WebView.getCoreType() == 3) {
            if (webView.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
            tryPreCacheResources(webView);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (webView instanceof IFullTrace) {
            FullTraceUtils.addStage(((IFullTrace) webView).getFalcoSpan(), "onPageStarted");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidStartLoad();
        this.isError = false;
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        if (webView instanceof WVUCWebView) {
            WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_CONTEXT_MENU, (IWVWebView) webView, str, new Object[]{bitmap});
            wVUCWebView.onMessage(WVConstants.NOTIFY_PAGE_START, null);
            wVUCWebView.mPageStart = System.currentTimeMillis();
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        TaoLog.e(TAG, "onPageStarted : " + str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        FalcoSpan falcoSpan;
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1005, (IWVWebView) webView, str2, new Object[]{Integer.valueOf(i), str, str2}).isSuccess) {
            return;
        }
        String url = webView.getUrl();
        if ((webView instanceof IFullTrace) && (falcoSpan = ((IFullTrace) webView).getFalcoSpan()) != null) {
            FullTraceUtils.addStage(falcoSpan, "onReceivedError");
            falcoSpan.setTag("errorCode", Integer.valueOf(i));
            falcoSpan.setTag("description", str);
            falcoSpan.setTag("failingUrl", str2);
            falcoSpan.finish("onReceivedError");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFailLoadWithError(String.valueOf(i), str);
        if (((i > -16 && i < 0) || i == -80 || i == -50) && (webView instanceof WVUCWebView) && (url == null || url.equals(str2))) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + "]");
            hashMap.put(HttpConnector.URL, str2);
            this.isError = true;
            webView.setVisibility(4);
            wVUCWebView.onMessage(402, hashMap);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url != null) {
                str2 = url;
            }
            errorMonitor.didOccurNativeError(str2, i, str);
        }
    }

    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof WVUCWebView) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", "SSL_ERROR");
            hashMap.put(HttpConnector.URL, url);
            ((WVUCWebView) webView).onMessage(402, hashMap);
        }
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_CELL, (IWVWebView) webView, url, new Object[]{sslError2});
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, PointerIconCompat.TYPE_CELL, sslError2);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TaoLog.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView + ", crash:" + renderProcessGoneDetail.didCrash() + ", priority:" + renderProcessGoneDetail.rendererPriorityAtExit());
        int i = this.crashCount;
        if (i >= 5) {
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitRenderType(webView.getUrl(), "R_Fail", WVCommonConfig.commonConfig.webMultiPolicy);
            }
            this.crashCount = 0;
            Log.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView.getClass().getSimpleName() + ", crash:" + renderProcessGoneDetail.didCrash(), new Throwable());
            return false;
        }
        if (webView == null) {
            TaoLog.e(SANDBOX_TAG, "onRenderProcessGone - WebView is null");
            return false;
        }
        this.crashCount = i + 1;
        if (this.mRenderProcessHandler == null) {
            this.mRenderProcessHandler = new Handler(Looper.getMainLooper());
        }
        this.mRenderProcessHandler.postDelayed(new 6(this, webView), 200L);
        this.mRenderProcessHandler.removeCallbacks(this.mCrashCountReseter);
        this.mRenderProcessHandler.postDelayed(this.mCrashCountReseter, 20000L);
        return true;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (WebView.getCoreType() != 3) {
            TaoLog.e(TAG, "Only U4 WebView will use shouldInterceptRequest(API Level 21), return null.");
            return null;
        }
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            TaoLog.e(TAG, "shouldInterceptRequest, invalid request.");
            return null;
        }
        String uri = webResourceRequest.getUrl().toString();
        if (WVUCPrecacheManager.getInstance().hasPrecacheDoc(uri)) {
            WVUCPrecacheManager.getInstance().clearPrecacheDoc(uri);
            return null;
        }
        if (webView instanceof IWVWebView) {
            return shouldInterceptRequestInternal(webView, uri, WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_TEXT, (IWVWebView) webView, uri, new Object[]{webResourceRequest.getRequestHeaders(), Integer.valueOf((!(webView instanceof WVUCWebView) || ((WVUCWebView) webView).getUCExtension() == null) ? 2 : 3)}));
        }
        return null;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof IFullTrace) {
                FullTraceUtils.addCustomStageAndFinish(((IFullTrace) webView).getFalcoSpan(), (String) null);
                ((IFullTrace) webView).setFalcoSpan(FullTraceUtils.makeSpanChildOf("windvaneSubPage", "H5SubPage", ((IFullTrace) webView).getOpenTracingContext()));
            }
        } catch (Throwable th) {
            TaoLog.e(TAG, "getSpan failed " + CommonUtils.getStackTrace(th));
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "ACCESS_FORBIDDEN");
                hashMap.put(HttpConnector.URL, str);
                ((WVUCWebView) webView).onMessage(402, hashMap);
            } else {
                webView.loadUrl(forbiddenDomainRedirectURL);
            }
            return true;
        }
        IWVWebView iWVWebView = (IWVWebView) webView;
        if (WVURLFilter.doFilter(str, this.mContext.get(), iWVWebView)) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
            AppMonitorUtil.commitFail("UrlConfigFilterType", 3, "WVUCWebView.shouldOverrideUrlLoading", str);
            return true;
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_HELP, iWVWebView, str, new Object[0]).isSuccess) {
            return true;
        }
        Context context = webView.getContext();
        if (str.startsWith(SCHEME_MAILTO) || str.startsWith(SCHEME_TEL) || str.startsWith(SCHEME_SMS)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                if (context != null) {
                    context.startActivity(intent);
                }
            } catch (ActivityNotFoundException unused) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
            }
            return true;
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.receiveHtmlUrl(str);
        try {
            if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                    WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                }
                if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(context, (IWVWebView) webView, str)) {
                    TaoLog.i(TAG, "intercept url : " + str);
                    return true;
                }
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
        }
        if (webView instanceof WVUCWebView) {
            UCNetworkDelegate.getInstance().onUrlChange(wVUCWebView, str);
            wVUCWebView.setCachedUrl(str);
        }
        TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("userAgent", webView.getSettings().getUserAgentString());
            WMLPrefetch.getInstance().prefetchData(str, hashMap2);
        } catch (Throwable th2) {
            TaoLog.e(TAG, "failed to call prefetch: " + th2.getMessage());
            th2.printStackTrace();
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (WebView.getCoreType() == 3) {
            TaoLog.e(TAG, "U4 WebView will not use shouldInterceptRequest(API Level 11), return null.");
            return null;
        }
        if (!(webView instanceof IWVWebView)) {
            return null;
        }
        int i = 2;
        if (webView instanceof WVUCWebView) {
            i = ((WVUCWebView) webView).getUCExtension() == null ? 2 : 3;
        }
        return shouldInterceptRequestInternal(webView, str, WVEventService.getInstance().onEvent(PointerIconCompat.TYPE_WAIT, (IWVWebView) webView, str, new Object[]{Integer.valueOf(i)}));
    }
}
