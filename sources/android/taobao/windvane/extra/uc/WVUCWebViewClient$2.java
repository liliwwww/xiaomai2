package android.taobao.windvane.extra.uc;

import android.taobao.windvane.monitor.WVMonitorService;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$2 implements ValueCallback<String> {
    final /* synthetic */ WVUCWebViewClient this$0;
    final /* synthetic */ long val$mPageFinshTime;
    final /* synthetic */ String val$url;

    WVUCWebViewClient$2(WVUCWebViewClient wVUCWebViewClient, String str, long j) {
        this.this$0 = wVUCWebViewClient;
        this.val$url = str;
        this.val$mPageFinshTime = j;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(String str) {
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(this.val$url, str);
            WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(this.val$url, this.val$mPageFinshTime);
        }
    }
}
