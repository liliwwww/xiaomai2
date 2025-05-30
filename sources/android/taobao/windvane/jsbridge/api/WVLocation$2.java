package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVLocation$2 implements Runnable {
    final /* synthetic */ WVLocation this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$param;

    WVLocation$2(WVLocation wVLocation, WVCallBackContext wVCallBackContext, String str) {
        this.this$0 = wVLocation;
        this.val$callback = wVCallBackContext;
        this.val$param = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.requestLocation(this.val$callback, this.val$param);
    }
}
