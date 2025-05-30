package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVCamera$2 implements Runnable {
    final /* synthetic */ WVCamera this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$params;

    WVCamera$2(WVCamera wVCamera, WVCallBackContext wVCallBackContext, String str) {
        this.this$0 = wVCamera;
        this.val$callback = wVCallBackContext;
        this.val$params = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVCamera.access$102(this.this$0, true);
        this.this$0.takePhoto(this.val$callback, this.val$params);
    }
}
