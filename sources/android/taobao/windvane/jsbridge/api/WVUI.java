package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVUI extends WVApiPlugin {
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("showLoadingBox".equals(str)) {
            showLoading(str2, wVCallBackContext);
            return true;
        }
        if (!"hideLoadingBox".equals(str)) {
            return false;
        }
        hideLoading(str2, wVCallBackContext);
        return true;
    }

    public final void hideLoading(String str, WVCallBackContext wVCallBackContext) {
        ((WVApiPlugin) this).mWebView.hideLoadingView();
        wVCallBackContext.success();
    }

    public final void showLoading(String str, WVCallBackContext wVCallBackContext) {
        ((WVApiPlugin) this).mWebView.showLoadingView();
        wVCallBackContext.success();
    }
}
