package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVScreen$2 implements Runnable {
    final /* synthetic */ WVScreen this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$params;

    WVScreen$2(WVScreen wVScreen, WVCallBackContext wVCallBackContext, String str) {
        this.this$0 = wVScreen;
        this.val$callback = wVCallBackContext;
        this.val$params = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.capture(this.val$callback, this.val$params);
    }
}
