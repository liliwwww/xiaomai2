package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMotion$2 implements Runnable {
    final /* synthetic */ WVMotion this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$params;

    WVMotion$2(WVMotion wVMotion, WVCallBackContext wVCallBackContext, String str) {
        this.this$0 = wVMotion;
        this.val$callback = wVCallBackContext;
        this.val$params = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.listenBlow(this.val$callback, this.val$params);
    }
}
