package android.taobao.windvane.extra.jsbridge;

import android.widget.Toast;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVServer$3 implements Runnable {
    final /* synthetic */ WVServer this$0;

    WVServer$3(WVServer wVServer) {
        this.this$0 = wVServer;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(WVServer.access$1000(this.this$0), " 哎呦喂，被挤爆啦，请稍后重试", 1).show();
    }
}
