package android.taobao.windvane;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import com.taobao.application.common.Apm;
import com.taobao.application.common.IAppPreferences;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WindVaneSDKForTB$1 implements Apm.OnApmEventListener {
    final /* synthetic */ IAppPreferences val$preferences;

    WindVaneSDKForTB$1(IAppPreferences iAppPreferences) {
        this.val$preferences = iAppPreferences;
    }

    public void onEvent(int i) {
        WindVaneSDKForTB.access$002(this.val$preferences.getBoolean("isInBackground", false));
        boolean z = WVMonitorService.getPackageMonitorInterface() != null;
        if (i == 2 && z) {
            long currentTimeMillis = System.currentTimeMillis();
            TaoLog.i("WindVaneSDKForTB", "app active at time : " + currentTimeMillis);
            GlobalConfig.isBackground = false;
            WVConfigManager.getInstance().updateConfig(WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeAppActive);
            WVMonitorService.getPackageMonitorInterface().uploadStartAppTime(currentTimeMillis);
        }
        if (i == 1 && z) {
            long currentTimeMillis2 = System.currentTimeMillis();
            TaoLog.i("WindVaneSDKForTB", "app background at time : " + currentTimeMillis2);
            GlobalConfig.isBackground = true;
            WVMonitorService.getPackageMonitorInterface().uploadBackgroundTime(currentTimeMillis2);
        }
    }
}
