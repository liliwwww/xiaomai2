package android.taobao.windvane.util;

import android.os.Handler;
import android.taobao.windvane.util.ImageTool;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ImageTool$2 implements ImageTool.ImageSaveCallback {
    final /* synthetic */ Handler val$handler;

    ImageTool$2(Handler handler) {
        this.val$handler = handler;
    }

    public void error(String str) {
        Handler handler = this.val$handler;
        if (handler != null) {
            handler.sendEmptyMessage(405);
        }
    }

    public void success() {
        Handler handler = this.val$handler;
        if (handler != null) {
            handler.sendEmptyMessage(404);
        }
    }
}
