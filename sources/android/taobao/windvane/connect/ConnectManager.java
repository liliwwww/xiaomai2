package android.taobao.windvane.connect;

import android.taobao.windvane.thread.WVThreadPool;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ConnectManager {
    private static ConnectManager mConnectManager;

    private ConnectManager() {
    }

    public static synchronized ConnectManager getInstance() {
        ConnectManager connectManager;
        synchronized (ConnectManager.class) {
            if (mConnectManager == null) {
                mConnectManager = new ConnectManager();
            }
            connectManager = mConnectManager;
        }
        return connectManager;
    }

    public void connect(String str, HttpConnectListener<HttpResponse> httpConnectListener) {
        connect(str, httpConnectListener, null);
    }

    public HttpResponse connectSync(String str, HttpConnectListener<HttpResponse> httpConnectListener) {
        if (str == null) {
            return null;
        }
        try {
            return new HttpConnector().syncConnect(new HttpRequest(str), httpConnectListener);
        } catch (Exception unused) {
            return null;
        }
    }

    public void connect(String str, HttpConnectListener<HttpResponse> httpConnectListener, String str2) {
        if (str == null) {
            return;
        }
        WVThreadPool.getInstance().execute(new 1(this, str, httpConnectListener), str2);
    }

    public void connect(HttpRequest httpRequest, HttpConnectListener<HttpResponse> httpConnectListener) {
        if (httpRequest == null) {
            return;
        }
        WVThreadPool.getInstance().execute(new 2(this, httpRequest, httpConnectListener));
    }
}
