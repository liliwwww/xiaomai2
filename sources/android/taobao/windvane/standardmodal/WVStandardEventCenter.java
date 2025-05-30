package android.taobao.windvane.standardmodal;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVStandardEventCenter extends WVApiPlugin {
    public static void postNotificationToJS(IWVWebView iWVWebView, String str, String str2) {
        WVCallBackContext.fireEvent(iWVWebView, str, str2);
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"postNotificationToNative".equals(str)) {
            return false;
        }
        postNotificationToNative(str2, wVCallBackContext);
        return true;
    }

    public void postNotificationToNative(String str, WVCallBackContext wVCallBackContext) {
        WVEventService.getInstance().onEvent(WVEventId.H5TONATIVE_EVENT, str, wVCallBackContext);
        wVCallBackContext.success();
    }

    public static void postNotificationToJS(String str, String str2) {
        WVEventService.getInstance().onEvent(WVEventId.NATIVETOH5_EVENT, str, str2);
    }
}
