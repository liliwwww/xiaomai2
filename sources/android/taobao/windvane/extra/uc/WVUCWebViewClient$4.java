package android.taobao.windvane.extra.uc;

import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.monitor.WVMonitorService;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$4 implements ValueCallback<Object> {
    final /* synthetic */ WVUCWebViewClient this$0;

    WVUCWebViewClient$4(WVUCWebViewClient wVUCWebViewClient) {
        this.this$0 = wVUCWebViewClient;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (WVMonitorService.getWvMonitorInterface() != null) {
                String str = (String) map.get("rt");
                String str2 = (String) map.get("rtWhy");
                String str3 = (String) map.get("gt");
                String str4 = (String) map.get("gtWhy");
                HashMap hashMap = new HashMap();
                hashMap.put("stage", "onPageFinish");
                hashMap.put("requireRenderType", Integer.valueOf(WVCore.getInstance().getUsedWebMulti()));
                hashMap.put("realRenderType", str);
                hashMap.put("renderTypeReason", str2);
                hashMap.put("requireGpuType", Integer.valueOf(WVCore.getInstance().getUsedGpuMulti()));
                hashMap.put("realGpuType", str3);
                hashMap.put("gpuTypeReason", str4);
                WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV(String.valueOf(WVCore.getInstance().getUsedWebMulti()), str, str2, String.valueOf(WVCore.getInstance().getUsedGpuMulti()), str3, str4);
            }
        }
    }
}
