package android.taobao.windvane.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.service.WVEventId;
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
/* loaded from: classes2.dex */
public class WVWebChromeClient extends WebChromeClient {
    private static final long MAX_QUOTA = 20971520;
    private static final String TAG = "WVWebChromeClient";
    protected Context mContext;
    public WebChromeClient extraWebChromeClient = null;
    public IWVWebView mWebView = null;

    /* compiled from: Taobao */
    /* renamed from: android.taobao.windvane.webview.WVWebChromeClient$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C02281 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WVWebChromeClient() {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (WVEventService.getInstance().onEvent(WVEventId.PAGE_onConsoleMessage).isSuccess) {
            return true;
        }
        String message = consoleMessage.message();
        if (!TextUtils.isEmpty(message) && message.startsWith("hybrid://")) {
            TaoLog.m21e(TAG, "Call from console.log");
            if (this.mWebView != null) {
                WVJsBridge.getInstance().callMethod(this.mWebView, message);
                return true;
            }
        }
        if (message == null || !message.startsWith("wvNativeCallback")) {
            if (TaoLog.getLogStatus()) {
                int i = C02281.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
                if (i == 1) {
                    TaoLog.m20d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i == 2) {
                    TaoLog.m23e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i != 3) {
                    TaoLog.m20d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else {
                    TaoLog.m32w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                }
            }
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }
        String substring = message.substring(message.indexOf(WVNativeCallbackUtil.SEPERATER) + 1);
        int indexOf = substring.indexOf(WVNativeCallbackUtil.SEPERATER);
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        ValueCallback<String> nativeCallback = WVNativeCallbackUtil.getNativeCallback(substring2);
        if (nativeCallback != null) {
            nativeCallback.onReceiveValue(substring3);
            WVNativeCallbackUtil.clearNativeCallback(substring2);
        } else {
            TaoLog.m21e(TAG, "NativeCallback failed: " + substring3);
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
            TaoLog.m26i(TAG, "onJsPrompt: %s; defaultValue: %s; url: %s", str2, str3, str);
        }
        if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(WVEventId.PAGE_onJsPrompt, (IWVWebView) webView, str, str2, str3, jsPromptResult).isSuccess) {
            return true;
        }
        if (str3 == null || !str3.equals("wv_hybrid:")) {
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            if (webChromeClient != null) {
                return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return false;
        }
        TaoLog.m21e(TAG, "Call from console.prompt");
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
