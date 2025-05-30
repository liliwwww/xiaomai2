package android.taobao.windvane.webview;

import android.content.Context;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.webview.WVWebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVWebView$2$2 implements Runnable {
    final /* synthetic */ WVWebView.2 this$1;

    WVWebView$2$2(WVWebView.2 r1) {
        this.this$1 = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Context applicationContext = this.this$1.this$0.context.getApplicationContext();
        str = this.this$1.this$0.mImageUrl;
        ImageTool.saveImageToDCIM(applicationContext, str, this.this$1.this$0.mHandler);
    }
}
