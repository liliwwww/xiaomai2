package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVACCSService extends TaoBaseService {
    private static final String TAG = "CallbackService";
    private Context mContext = null;

    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.m18d(TAG, "onBind");
    }

    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
        WVEventService.getInstance().onEvent(WVEventId.ACCS_ONCONNECTED);
        TaoLog.m18d(TAG, "onConnected");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        TaoLog.m18d(TAG, "onCreate");
    }

    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (TaoLog.getLogStatus()) {
            TaoLog.m24i(TAG, "serviceId : " + str + " dataId :" + str3);
        }
        WVEventService.getInstance().onEvent(WVEventId.ACCS_ONDATA, str, bArr);
    }

    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
        WVEventService.getInstance().onEvent(WVEventId.ACCS_ONDISONNECTED);
        TaoLog.m18d(TAG, "onDisconnected");
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.m18d(TAG, "onResponse");
    }

    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.m18d(TAG, "onSendData");
    }

    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.m18d(TAG, "onCreate");
    }
}
