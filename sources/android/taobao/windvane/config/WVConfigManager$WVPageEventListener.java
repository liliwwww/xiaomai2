package android.taobao.windvane.config;

import android.app.Activity;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVConfigManager$WVPageEventListener implements WVEventListener {
    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        IWVWebView iWVWebView;
        if (i != 3002 && i != 1002) {
            return null;
        }
        if (WVConfigManager.launch && wVEventContext != null && (iWVWebView = wVEventContext.webView) != null && (iWVWebView._getContext() instanceof Activity) && !wVEventContext.webView._getContext().getClass().getSimpleName().equals("MainActivity3")) {
            WVConfigManager.launch = false;
        }
        if (i == 3002) {
            WVConfigManager.access$000().updateConfig(WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeActive);
            return null;
        }
        WVConfigManager.access$000().updateConfig(WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeFinish);
        return null;
    }
}
