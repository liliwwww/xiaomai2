package android.taobao.windvane.monitor;

import android.taobao.windvane.monitor.WVMonitorData;
import android.taobao.windvane.monitor.WVPerformanceMonitorInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVMonitorData$extra {
    public int statusCode;
    final /* synthetic */ WVMonitorData this$0;
    public String via;
    public WVPerformanceMonitorInterface.NetStat netStat = null;
    public Map<String, Long> selfDefine = new ConcurrentHashMap();
    public Map<String, WVMonitorData.resStat> resStat = new ConcurrentHashMap();

    public WVMonitorData$extra(WVMonitorData wVMonitorData) {
        this.this$0 = wVMonitorData;
    }
}
