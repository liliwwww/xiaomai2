package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVPageTrackerAPI extends WVApiPlugin {
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!str.equals("reportPerformanceInfo")) {
            return false;
        }
        reportPerformanceInfo(str2, wVCallBackContext);
        return true;
    }

    public void reportPerformanceInfo(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        if (((WVApiPlugin) this).performance == null) {
            wVResult.setResult(WVResult.FAIL);
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "performance object does not exist");
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ((WVApiPlugin) this).performance.receiveJSMessageForCustomizedFSP(jSONObject.optLong("firstScreenPaint"));
            JSONObject jSONObject2 = jSONObject.getJSONObject("otherPerformanceStage");
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    ((WVApiPlugin) this).performance.receiveJSMessageForCustomizedStage(jSONObject2.optLong(next), next);
                }
            }
            wVCallBackContext.success();
        } catch (Exception e) {
            wVResult.setResult(WVResult.FAIL);
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "exception: " + e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }
}
