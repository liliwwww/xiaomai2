package android.taobao.windvane.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVWebChromeClient extends WebChromeClient {
    private static final long MAX_QUOTA = 20971520;
    private static final String TAG = "WVWebChromeClient";
    protected Context mContext;
    public WebChromeClient extraWebChromeClient = null;
    public IWVWebView mWebView = null;

    public WVWebChromeClient() {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (WVEventService.getInstance().onEvent(2001).isSuccess) {
            return true;
        }
        String message = consoleMessage.message();
        if (!TextUtils.isEmpty(message) && message.startsWith("hybrid://")) {
            TaoLog.e(TAG, "Call from console.log");
            if (this.mWebView != null) {
                WVJsBridge.getInstance().callMethod(this.mWebView, message);
                return true;
            }
        }
        if (message == null || !message.startsWith("wvNativeCallback")) {
            if (TaoLog.getLogStatus()) {
                int i = 1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
                if (i == 1) {
                    TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i == 2) {
                    TaoLog.e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i != 3) {
                    TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else {
                    TaoLog.w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                }
            }
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }
        String substring = message.substring(message.indexOf("/") + 1);
        int indexOf = substring.indexOf("/");
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        ValueCallback nativeCallback = WVNativeCallbackUtil.getNativeCallback(substring2);
        if (nativeCallback != null) {
            nativeCallback.onReceiveValue(substring3);
            WVNativeCallbackUtil.clearNativeCallback(substring2);
        } else {
            TaoLog.e(TAG, "NativeCallback failed: " + substring3);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (j2 < MAX_QUOTA) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "onJsPrompt: %s; defaultValue: %s; url: %s", str2, str3, str);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(2003, (IWVWebView) webView, str, new Object[]{str2, str3, jsPromptResult}).isSuccess) {
            return true;
        }
        if (str3 == null || !str3.equals("wv_hybrid:")) {
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            if (webChromeClient != null) {
                return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return false;
        }
        TaoLog.e(TAG, "Call from console.prompt");
        WVJsBridge.getInstance().callMethod((WVWebView) webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    public WVWebChromeClient(Context context) {
        this.mContext = context;
    }
}
