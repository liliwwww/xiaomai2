package android.taobao.windvane.monitor;

import android.taobao.windvane.config.WVConfigHandler;
import android.taobao.windvane.config.WVConfigUpdateCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMonitorConfigManager$1 extends WVConfigHandler {
    final /* synthetic */ WVMonitorConfigManager this$0;

    WVMonitorConfigManager$1(WVMonitorConfigManager wVMonitorConfigManager) {
        this.this$0 = wVMonitorConfigManager;
    }

    @Override // android.taobao.windvane.config.WVConfigHandler
    public void update(String str, WVConfigUpdateCallback wVConfigUpdateCallback) {
        WVMonitorConfigManager.access$000(this.this$0, wVConfigUpdateCallback, str, getSnapshotN());
    }
}
