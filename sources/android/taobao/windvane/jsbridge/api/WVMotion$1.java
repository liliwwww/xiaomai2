package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import androidx.core.app.NotificationCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMotion$1 implements Runnable {
    final /* synthetic */ WVMotion this$0;
    final /* synthetic */ WVCallBackContext val$callback;

    WVMotion$1(WVMotion wVMotion, WVCallBackContext wVCallBackContext) {
        this.this$0 = wVMotion;
        this.val$callback = wVCallBackContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVResult wVResult = new WVResult();
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "NO_PERMISSION");
        this.val$callback.error(wVResult);
    }
}
