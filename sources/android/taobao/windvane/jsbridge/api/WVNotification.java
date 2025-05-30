package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.util.TaoLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVNotification extends WVApiPlugin {
    private static final String TAG = "WVNotification";

    public final void beep(String str, WVCallBackContext wVCallBackContext) {
        try {
            new 1(this, Integer.parseInt(new JSONObject(str).optString("count"))).start();
            wVCallBackContext.success("{}");
        } catch (JSONException unused) {
            TaoLog.e("WVNotification", "openWindow: param parse to JSON error, param=" + str);
            wVCallBackContext.error("param error");
        }
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"beep".equals(str)) {
            return false;
        }
        beep(str2, wVCallBackContext);
        return true;
    }
}
