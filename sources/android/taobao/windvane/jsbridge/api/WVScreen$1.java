package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import androidx.core.app.NotificationCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVScreen$1 implements Runnable {
    final /* synthetic */ WVScreen this$0;
    final /* synthetic */ WVCallBackContext val$callback;

    WVScreen$1(WVScreen wVScreen, WVCallBackContext wVCallBackContext) {
        this.this$0 = wVScreen;
        this.val$callback = wVCallBackContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVResult wVResult = new WVResult();
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "no permission");
        this.val$callback.error(wVResult);
    }
}
