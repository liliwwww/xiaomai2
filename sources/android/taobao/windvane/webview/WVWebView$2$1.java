package android.taobao.windvane.webview;

import android.taobao.windvane.util.WVConstants;
import android.taobao.windvane.webview.WVWebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVWebView$2$1 implements Runnable {
    final /* synthetic */ WVWebView.2 this$1;

    WVWebView$2$1(WVWebView.2 r1) {
        this.this$1 = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
    }
}
