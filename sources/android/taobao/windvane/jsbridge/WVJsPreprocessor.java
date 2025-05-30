package android.taobao.windvane.jsbridge;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVUrlMatchUtils;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVJsPreprocessor extends WVJSAPIPageAuth {
    @Override // android.taobao.windvane.jsbridge.WVJSAPIAuthCheck
    public boolean apiAuthCheck(String str, String str2, String str3, String str4) {
        if (WVUrlMatchUtils.getInstance().checkJsApiPermission(str, str2, str3)) {
            return true;
        }
        AppMonitorUtil.commitFail("UrlConfigJsApiType", 1, str2 + "." + str3, str);
        return false;
    }

    @Override // android.taobao.windvane.jsbridge.WVJSAPIPageAuth
    protected boolean needAuth(IWVWebView iWVWebView) {
        if (WVCommonConfig.commonConfig.useURLConfig) {
            return iWVWebView.canUseGlobalUrlConfig() || iWVWebView.canUseUrlConfig();
        }
        return false;
    }
}
