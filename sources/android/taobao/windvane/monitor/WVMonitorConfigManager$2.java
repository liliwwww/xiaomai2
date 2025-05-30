package android.taobao.windvane.monitor;

import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.config.WVConfigUpdateCallback$CONFIG_UPDATE_STATUS;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMonitorConfigManager$2 extends HttpConnectListener<HttpResponse> {
    final /* synthetic */ WVMonitorConfigManager this$0;
    final /* synthetic */ WVConfigUpdateCallback val$callback;
    final /* synthetic */ String val$finalMonitorConfigUrl;

    WVMonitorConfigManager$2(WVMonitorConfigManager wVMonitorConfigManager, WVConfigUpdateCallback wVConfigUpdateCallback, String str) {
        this.this$0 = wVMonitorConfigManager;
        this.val$callback = wVConfigUpdateCallback;
        this.val$finalMonitorConfigUrl = str;
    }

    @Override // android.taobao.windvane.connect.HttpConnectListener
    public void onError(int i, String str) {
        WVConfigUpdateCallback wVConfigUpdateCallback = this.val$callback;
        if (wVConfigUpdateCallback != null) {
            wVConfigUpdateCallback.updateError(this.val$finalMonitorConfigUrl, str);
            this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
        }
        TaoLog.d("WVPackageMonitorImpl", "update moniter failed! : " + str);
        super.onError(i, str);
    }

    @Override // android.taobao.windvane.connect.HttpConnectListener
    public void onFinish(HttpResponse httpResponse, int i) {
        if (this.val$callback == null) {
            return;
        }
        if (httpResponse == null || httpResponse.getData() == null) {
            this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.NULL_DATA, 0);
            return;
        }
        try {
            String str = new String(httpResponse.getData(), "utf-8");
            if (this.this$0.needSaveConfig(str)) {
                ConfigStorage.putStringVal("wv_main_config", "monitorwv-data", str);
                this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.SUCCESS, 1);
            } else {
                this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.NO_VERSION, 0);
            }
        } catch (UnsupportedEncodingException unused) {
            this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
        }
    }
}
