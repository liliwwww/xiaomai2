package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.util.Log;
import java.util.Enumeration;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVWebPerformance extends WVApiPlugin {
    private static final String TAG = "WVWebPerformance";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TextUtils.equals("timing", str)) {
            timing(wVCallBackContext);
            return true;
        }
        if (!TextUtils.equals("jsBridgeHistory", str)) {
            return false;
        }
        jsBridgeHistory(wVCallBackContext);
        return true;
    }

    public void jsBridgeHistory(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            Enumeration<String> keys = IWVWebView.JsbridgeHis.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                wVResult.addData(nextElement, IWVWebView.JsbridgeHis.get(nextElement));
            }
            wVCallBackContext.success(wVResult);
        } catch (Exception e) {
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    public void timing(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult("HY_NO_PERMISSION");
        if (this.mWebView instanceof WVUCWebView) {
            wVResult = new WVResult("HY_SUCCESS");
            try {
                JSONObject h5MonitorDatas = ((WVUCWebView) this.mWebView).getH5MonitorDatas();
                Log.i(TAG, h5MonitorDatas.toString());
                wVResult.setData(h5MonitorDatas);
            } catch (Exception e) {
                e.printStackTrace();
                wVResult.setResult("HY_FAILED");
            }
            wVCallBackContext.success(wVResult);
        }
        wVCallBackContext.error(wVResult);
    }
}
