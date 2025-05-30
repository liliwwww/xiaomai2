package android.taobao.windvane.connect;

import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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

    public void connect(final String str, final HttpConnectListener<HttpResponse> httpConnectListener, String str2) {
        if (str == null) {
            return;
        }
        WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.connect.ConnectManager.1
            @Override // java.lang.Runnable
            public void run() {
                TaoLog.m18d("WVThreadPool", "Task has been executed");
                try {
                    new HttpConnector().syncConnect(new HttpRequest(str), httpConnectListener);
                } catch (Exception e) {
                    TaoLog.m18d("WVThreadPool", "Task exception:" + e.getMessage());
                }
            }
        }, str2);
    }

    public void connect(final HttpRequest httpRequest, final HttpConnectListener<HttpResponse> httpConnectListener) {
        if (httpRequest == null) {
            return;
        }
        WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.connect.ConnectManager.2
            @Override // java.lang.Runnable
            public void run() {
                new HttpConnector().syncConnect(httpRequest, httpConnectListener);
            }
        });
    }
}
