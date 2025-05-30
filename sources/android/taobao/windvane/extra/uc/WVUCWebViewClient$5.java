package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$5 implements Runnable {
    final /* synthetic */ WVUCWebViewClient this$0;

    WVUCWebViewClient$5(WVUCWebViewClient wVUCWebViewClient) {
        this.this$0 = wVUCWebViewClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoLog.e("WVUCWebViewClient.sandbox", "crash count reset - " + this.this$0.crashCount);
        this.this$0.crashCount = 0;
    }
}
