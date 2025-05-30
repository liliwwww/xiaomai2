package android.taobao.windvane.config;

import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVCommonConfig$1 extends HttpConnectListener<HttpResponse> {
    final /* synthetic */ WVCommonConfig this$0;
    final /* synthetic */ WVConfigUpdateCallback val$callback;
    final /* synthetic */ String val$finalCommonConfigUrl;

    WVCommonConfig$1(WVCommonConfig wVCommonConfig, WVConfigUpdateCallback wVConfigUpdateCallback, String str) {
        this.this$0 = wVCommonConfig;
        this.val$callback = wVConfigUpdateCallback;
        this.val$finalCommonConfigUrl = str;
    }

    @Override // android.taobao.windvane.connect.HttpConnectListener
    public void onError(int i, String str) {
        WVConfigUpdateCallback wVConfigUpdateCallback = this.val$callback;
        if (wVConfigUpdateCallback != null) {
            wVConfigUpdateCallback.updateError(this.val$finalCommonConfigUrl, str);
            this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.UNKNOWN_ERROR, 0);
        }
        TaoLog.d("WVCommonConfig", "update common failed! : " + str);
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
            if (ExifInterface.GPS_MEASUREMENT_3D.equals(GlobalConfig.zType)) {
                this.this$0.commonCfg = str;
            }
            int access$000 = WVCommonConfig.access$000(this.this$0, str);
            if (access$000 <= 0) {
                this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.NO_VERSION, 0);
            } else {
                ConfigStorage.putStringVal("wv_main_config", "commonwv-data", str);
                this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.SUCCESS, access$000);
            }
        } catch (UnsupportedEncodingException e) {
            this.val$callback.updateStatus(WVConfigUpdateCallback$CONFIG_UPDATE_STATUS.ENCODING_ERROR, 0);
            TaoLog.e("WVCommonConfig", "config encoding error. " + e.getMessage());
        }
    }
}
