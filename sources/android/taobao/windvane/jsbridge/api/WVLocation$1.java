package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVLocation$1 implements Runnable {
    final /* synthetic */ WVLocation this$0;
    final /* synthetic */ WVCallBackContext val$callback;

    WVLocation$1(WVLocation wVLocation, WVCallBackContext wVCallBackContext) {
        this.this$0 = wVLocation;
        this.val$callback = wVCallBackContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVResult wVResult = new WVResult();
        wVResult.addData("msg", "no permission");
        this.val$callback.error(wVResult);
    }
}
