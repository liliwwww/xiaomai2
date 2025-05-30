package android.taobao.windvane.connect;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ConnectManager$2 implements Runnable {
    final /* synthetic */ ConnectManager this$0;
    final /* synthetic */ HttpConnectListener val$listener;
    final /* synthetic */ HttpRequest val$request;

    ConnectManager$2(ConnectManager connectManager, HttpRequest httpRequest, HttpConnectListener httpConnectListener) {
        this.this$0 = connectManager;
        this.val$request = httpRequest;
        this.val$listener = httpConnectListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        new HttpConnector().syncConnect(this.val$request, this.val$listener);
    }
}
