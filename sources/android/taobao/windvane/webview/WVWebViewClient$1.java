package android.taobao.windvane.webview;

import android.taobao.windvane.monitor.WVMonitorService;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVWebViewClient$1 implements ValueCallback<String> {
    final /* synthetic */ WVWebViewClient this$0;
    final /* synthetic */ String val$monitorUrl;

    WVWebViewClient$1(WVWebViewClient wVWebViewClient, String str) {
        this.this$0 = wVWebViewClient;
        this.val$monitorUrl = str;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(String str) {
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(this.val$monitorUrl, str);
            WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(this.val$monitorUrl, WVWebViewClient.access$000(this.this$0));
        }
    }
}
