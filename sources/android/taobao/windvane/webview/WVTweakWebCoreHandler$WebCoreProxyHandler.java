package android.taobao.windvane.webview;

import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVTweakWebCoreHandler$WebCoreProxyHandler extends Handler {
    final Handler handler;

    public WVTweakWebCoreHandler$WebCoreProxyHandler(Handler handler) {
        super(handler.getLooper());
        this.handler = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WebCoreProxyHandler", "handle message: " + message.what);
            }
            this.handler.handleMessage(message);
        } catch (Throwable th) {
            TaoLog.e("WebCoreProxyHandler", "handleMessage exception: " + th);
        }
    }
}
