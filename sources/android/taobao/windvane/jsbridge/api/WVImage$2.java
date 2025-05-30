package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVImage$2 implements Runnable {
    final /* synthetic */ WVImage this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$params;

    WVImage$2(WVImage wVImage, String str, WVCallBackContext wVCallBackContext) {
        this.this$0 = wVImage;
        this.val$params = str;
        this.val$callback = wVCallBackContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoLog.d(WVAPI.PluginName.API_IMAGE, "PERMISSION GRANTED");
        WVImage.access$000(this.this$0, this.val$params, this.val$callback);
    }
}
