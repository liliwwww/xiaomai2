package android.taobao.windvane.jsbridge;

import android.taobao.windvane.monitor.WVMonitorService;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVAppEvent extends WVApiPlugin {
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        return true;
    }

    public void onPause() {
        ((WVApiPlugin) this).mWebView.fireEvent("WV.Event.APP.Background", "{}");
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didExitAtTime(((WVApiPlugin) this).mWebView.getUrl(), System.currentTimeMillis());
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        String dataOnActive = ((WVApiPlugin) this).mWebView.getDataOnActive();
        if (TextUtils.isEmpty(dataOnActive)) {
            dataOnActive = "{}";
        }
        ((WVApiPlugin) this).mWebView.fireEvent("WV.Event.APP.Active", dataOnActive);
        ((WVApiPlugin) this).mWebView.setDataOnActive((String) null);
    }
}
