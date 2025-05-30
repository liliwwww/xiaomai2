package android.taobao.windvane.connect;

import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ConnectManager$1 implements Runnable {
    final /* synthetic */ ConnectManager this$0;
    final /* synthetic */ HttpConnectListener val$listener;
    final /* synthetic */ String val$url;

    ConnectManager$1(ConnectManager connectManager, String str, HttpConnectListener httpConnectListener) {
        this.this$0 = connectManager;
        this.val$url = str;
        this.val$listener = httpConnectListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoLog.d("WVThreadPool", "Task has been executed");
        try {
            new HttpConnector().syncConnect(new HttpRequest(this.val$url), this.val$listener);
        } catch (Exception e) {
            TaoLog.d("WVThreadPool", "Task exception:" + e.getMessage());
        }
    }
}
