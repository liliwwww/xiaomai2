package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.ImageTool;
import androidx.core.app.NotificationCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVImage$3 implements ImageTool.ImageSaveCallback {
    final /* synthetic */ WVImage this$0;
    final /* synthetic */ WVCallBackContext val$callback;

    WVImage$3(WVImage wVImage, WVCallBackContext wVCallBackContext) {
        this.this$0 = wVImage;
        this.val$callback = wVCallBackContext;
    }

    public void error(String str) {
        WVResult wVResult = new WVResult();
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, str);
        this.val$callback.error(wVResult);
    }

    public void success() {
        this.val$callback.success();
    }
}
