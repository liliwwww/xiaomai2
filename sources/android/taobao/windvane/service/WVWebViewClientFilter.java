package android.taobao.windvane.service;

import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import androidx.core.view.PointerIconCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class WVWebViewClientFilter implements WVEventListener {
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        WVEventResult wVEventResult = new WVEventResult(false);
        if (i != 1008) {
            switch (i) {
                case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                    onPageStarted(wVEventContext.webView, wVEventContext.url);
                    break;
                case PointerIconCompat.TYPE_HAND /* 1002 */:
                    onPageFinished(wVEventContext.webView, wVEventContext.url);
                    break;
                case PointerIconCompat.TYPE_HELP /* 1003 */:
                    wVEventResult.isSuccess = shouldOverrideUrlLoading(wVEventContext.webView, wVEventContext.url);
                    break;
                case 1005:
                    onReceivedError(wVEventContext.webView, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2]);
                    break;
            }
            return wVEventResult;
        }
        WVWrapWebResourceResponse shouldInterceptRequest = shouldInterceptRequest(wVEventContext.webView, wVEventContext.url);
        if (shouldInterceptRequest == null) {
            return wVEventResult;
        }
        wVEventResult.isSuccess = true;
        wVEventResult.resultObj = shouldInterceptRequest;
        return wVEventResult;
    }

    public void onPageFinished(IWVWebView iWVWebView, String str) {
    }

    public void onPageStarted(IWVWebView iWVWebView, String str) {
    }

    public void onReceivedError(IWVWebView iWVWebView, int i, String str, String str2) {
    }

    public WVWrapWebResourceResponse shouldInterceptRequest(IWVWebView iWVWebView, String str) {
        return null;
    }

    public boolean shouldOverrideUrlLoading(IWVWebView iWVWebView, String str) {
        return false;
    }
}
