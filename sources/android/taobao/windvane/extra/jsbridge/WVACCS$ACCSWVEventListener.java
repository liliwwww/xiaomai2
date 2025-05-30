package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVACCS$ACCSWVEventListener implements WVEventListener {
    private WeakReference<IWVWebView> webview;

    public WVACCS$ACCSWVEventListener(IWVWebView iWVWebView) {
        this.webview = new WeakReference<>(iWVWebView);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        IWVWebView iWVWebView = this.webview.get();
        if (iWVWebView != null) {
            switch (i) {
                case 5001:
                    String str = (String) objArr[0];
                    String str2 = new String((byte[]) objArr[1]);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("serviceId", str);
                        jSONObject.put("resultData", str2);
                        String jSONObject2 = jSONObject.toString();
                        iWVWebView.fireEvent("WV.Event.ACCS.OnData", jSONObject2);
                        if (TaoLog.getLogStatus()) {
                            TaoLog.i("ACCS", jSONObject2);
                            break;
                        }
                    } catch (Throwable unused) {
                        break;
                    }
                    break;
                case 5002:
                    iWVWebView.fireEvent("WV.Event.ACCS.OnConnected", "{}");
                    if (TaoLog.getLogStatus()) {
                        TaoLog.e("ACCS", "ACCS connect");
                        break;
                    }
                    break;
                case 5003:
                    iWVWebView.fireEvent("WV.Event.ACCS.OnDisConnected", "{}");
                    if (TaoLog.getLogStatus()) {
                        TaoLog.e("ACCS", "ACCS disconnect");
                        break;
                    }
                    break;
            }
        } else {
            if (TaoLog.getLogStatus()) {
                TaoLog.e("ACCS", "webview is recycled");
            }
            return null;
        }
        return null;
    }
}
