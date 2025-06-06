package android.taobao.windvane.extra.p002uc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVContextUtil;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.uc.webview.export.GeolocationPermissions;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.JsResult;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCWebChromeClient extends WebChromeClient {
    public static final int FilePathCallbackID = 15;
    private static final String KEY_CANCEL;
    private static final String KEY_CONFIRM;
    private static final String KEY_FROM;
    private static final String TAG = "WVUCWebChromeClient";
    protected Context mContext;
    public IWVWebView mWebView = null;
    public ValueCallback<Uri[]> mFilePathCallback = null;

    /* compiled from: Taobao */
    /* renamed from: android.taobao.windvane.extra.uc.WVUCWebChromeClient$13 */
    static /* synthetic */ class C012513 {
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

    static {
        KEY_FROM = EnvUtil.isCN() ? "来自于：" : "From: ";
        KEY_CONFIRM = EnvUtil.isCN() ? "确定" : "OK";
        KEY_CANCEL = EnvUtil.isCN() ? "取消" : "Cancel";
    }

    public WVUCWebChromeClient() {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (WVEventService.getInstance().onEvent(WVEventId.PAGE_onConsoleMessage).isSuccess) {
            return true;
        }
        String message = consoleMessage.message();
        if (message != null) {
            if (!TextUtils.isEmpty(message) && message.startsWith("hybrid://")) {
                TaoLog.m18d(TAG, "Call from console.log");
                if (this.mWebView != null) {
                    WVJsBridge.getInstance().callMethod(this.mWebView, message);
                    return true;
                }
            }
            if (message.startsWith("wvNativeCallback")) {
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
        }
        if (TaoLog.getLogStatus()) {
            int i = C012513.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
            if (i == 1) {
                TaoLog.m20d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else if (i == 2) {
                TaoLog.m23e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                IWVWebView iWVWebView = this.mWebView;
                if (iWVWebView != null) {
                    ((WVUCWebView) iWVWebView).wvErrorManager.reportJSError(consoleMessage);
                    ((WVUCWebView) this.mWebView).pageTracker.onPageReceivedJSError();
                }
            } else if (i != 3) {
                TaoLog.m20d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else {
                TaoLog.m32w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        if (webView.isDestroied()) {
            TaoLog.m21e(TAG, "cannot call [onJsAlert], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if ((realContext instanceof Activity) && ((Activity) realContext).isFinishing()) {
            jsResult.confirm();
            return true;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(realContext);
            builder.setTitle(KEY_FROM + Uri.parse(str).getHost()).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable th) {
            TaoLog.m21e(TAG, th.getMessage());
            jsResult.confirm();
        }
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        if (webView.isDestroied()) {
            TaoLog.m21e(TAG, "cannot call [onJsConfirm], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if ((realContext instanceof Activity) && ((Activity) realContext).isFinishing()) {
            jsResult.confirm();
            return true;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(realContext);
            builder.setTitle(KEY_FROM + Uri.parse(str).getHost()).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setNeutralButton(KEY_CANCEL, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.9
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable th) {
            TaoLog.m21e(TAG, th.getMessage());
            jsResult.confirm();
        }
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if (webView.isDestroied()) {
            TaoLog.m21e(TAG, "cannot call [onJsPrompt], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if ((realContext instanceof Activity) && ((Activity) realContext).isFinishing()) {
            jsPromptResult.confirm();
            return true;
        }
        if (str3 != null && str3.equals("wv_hybrid:")) {
            WVJsBridge.getInstance().callMethod((IWVWebView) webView, str2);
            jsPromptResult.confirm("");
            return true;
        }
        try {
            EditText editText = new EditText(realContext);
            editText.setText(str3);
            String host = Uri.parse(str).getHost();
            AlertDialog create = new AlertDialog.Builder(realContext).setTitle(KEY_FROM + host).setView(editText).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.confirm();
                }
            }).setNegativeButton(KEY_CANCEL, new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.cancel();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.10
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsPromptResult.cancel();
                }
            }).create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable th) {
            TaoLog.m21e(TAG, th.getMessage());
            jsPromptResult.confirm();
        }
        return true;
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!WVUrlUtil.isCommonUrl(str)) {
            super.onReceivedTitle(webView, str);
            return;
        }
        TaoLog.m24i(TAG, "ignore default title : " + str);
    }

    public boolean onShowFileChooser(final WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        TaoLog.m18d(TAG, " onShowFileChooser");
        if (fileChooserParams != null && valueCallback != null) {
            this.mFilePathCallback = valueCallback;
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TaoLog.m18d(WVUCWebChromeClient.TAG, " onShowFileChooser permission granted");
                        Intent createIntent = fileChooserParams.createIntent();
                        Context realContext = WVContextUtil.getRealContext(webView.getContext());
                        if (realContext instanceof Activity) {
                            ((Activity) realContext).startActivityForResult(Intent.createChooser(createIntent, "choose"), 15);
                        }
                    }
                }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.3
                    @Override // java.lang.Runnable
                    public void run() {
                        TaoLog.m18d(WVUCWebChromeClient.TAG, " onShowFileChooser permission denied");
                        valueCallback.onReceiveValue(null);
                    }
                }).execute();
                return true;
            } catch (Throwable th) {
                TaoLog.m21e(TAG, th.getMessage());
                th.printStackTrace();
            }
        }
        return false;
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback) {
        TaoLog.m18d(TAG, " openFileChooser");
        if (this.mWebView == null) {
            TaoLog.m21e(TAG, "context is null");
            return;
        }
        if (WVContextUtil.getRealContext(this.mContext) instanceof Application) {
            TaoLog.m21e(TAG, "context can not be application");
            return;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.2
                @Override // java.lang.Runnable
                public void run() {
                    TaoLog.m18d(WVUCWebChromeClient.TAG, " openFileChooser permission granted");
                    WVUCWebChromeClient.super.openFileChooser(valueCallback);
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebChromeClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TaoLog.m18d(WVUCWebChromeClient.TAG, " openFileChooser permission denied");
                }
            }).execute();
        } catch (Exception e) {
            TaoLog.m21e(TAG, e.getMessage());
        }
    }

    public WVUCWebChromeClient(Context context) {
        this.mContext = context;
    }
}
