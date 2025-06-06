package android.taobao.windvane.jspatch;

import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVJsPatchListener implements WVEventListener {
    private WeakReference<IWVWebView> webviewReference;

    public WVJsPatchListener(IWVWebView iWVWebView) {
        this.webviewReference = new WeakReference<>(iWVWebView);
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        WeakReference<IWVWebView> weakReference;
        try {
            if (i == 3006) {
                WeakReference<IWVWebView> weakReference2 = this.webviewReference;
                if (weakReference2 == null) {
                    return null;
                }
                IWVWebView iWVWebView = weakReference2.get();
                if (iWVWebView == null) {
                    if (!TaoLog.getLogStatus()) {
                        return null;
                    }
                    TaoLog.i("WVJsPatchListener", "WVJsPatchListener is free");
                    return null;
                }
                iWVWebView.fireEvent((String) objArr[0], (String) objArr[1]);
            } else {
                if (i != 3014 || (weakReference = this.webviewReference) == null) {
                    return null;
                }
                IWVWebView iWVWebView2 = weakReference.get();
                if (iWVWebView2 == null) {
                    if (!TaoLog.getLogStatus()) {
                        return null;
                    }
                    TaoLog.i("WVJsPatchListener", "WVJsPatchListener is free");
                    return null;
                }
                iWVWebView2.fireEvent("WV.Event.APP.TakeScreenshot", "{}");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
