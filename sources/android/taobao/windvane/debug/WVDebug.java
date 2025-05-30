package android.taobao.windvane.debug;

import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVDevelopTool;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVDebug {
    private static boolean isInited;

    public static synchronized void init() {
        synchronized (WVDebug.class) {
            if (!isInited) {
                WVPluginManager.registerPlugin("WVDevelopTool", WVDevelopTool.class);
                isInited = true;
            }
        }
    }
}
