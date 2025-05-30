package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.debug.WVDebug;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVCamera;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class TBJsApiManager {
    public static void initJsApi() {
        WVCamera.registerUploadService(TBUploadService.class);
        WVPluginManager.registerPlugin("WVServer", WVServer.class);
        WVPluginManager.registerPlugin("WVACCS", WVACCS.class);
        WVPluginManager.registerPlugin("WVApplication", WVApplication.class);
        WVPluginManager.registerPlugin("WVWebPerformance", WVWebPerformance.class);
        WVPluginManager.registerPlugin("WVReporter", WVReporterExtra.class);
        WVDebug.init();
    }
}
