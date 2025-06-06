package android.taobao.windvane.jsbridge;

import android.taobao.windvane.ha.WVHAManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVHAReport extends WVApiPlugin {
    private Map<String, Object> obtainMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TextUtils.equals(str, "stage")) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                WVHAManager.uploadApmStage(jSONObject.optString("stageName"), obtainMap(jSONObject.optString("stageValues")));
                wVCallBackContext.success();
            } catch (JSONException e) {
                WVResult wVResult = new WVResult();
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
                wVCallBackContext.error(wVResult);
            }
            return true;
        }
        if (!TextUtils.equals(str, "error")) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            String optString = jSONObject2.optString("errorCode");
            String optString2 = jSONObject2.optString("stageName");
            if (TextUtils.isEmpty(optString)) {
                optString = "UNKNOW";
            }
            WVHAManager.uploadApmError(optString2, optString, obtainMap(jSONObject2.optString("stageValues")));
            wVCallBackContext.success();
        } catch (JSONException e2) {
            WVResult wVResult2 = new WVResult();
            wVResult2.addData(NotificationCompat.CATEGORY_MESSAGE, e2.getMessage());
            wVCallBackContext.error(wVResult2);
        }
        return true;
    }
}
