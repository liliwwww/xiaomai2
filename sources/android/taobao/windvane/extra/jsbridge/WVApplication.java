package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVApplication extends WVApiPlugin {
    private void getNotificationSettings(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        if (Build.VERSION.SDK_INT < 22) {
            wVResult.addData(NotificationCompat.CATEGORY_STATUS, EnvironmentCompat.MEDIA_UNKNOWN);
            wVCallBackContext.success(wVResult);
        } else if (WVUtils.isNotificationEnabled(this.mContext)) {
            wVResult.addData(NotificationCompat.CATEGORY_STATUS, "authorized");
            wVCallBackContext.success(wVResult);
        } else {
            wVResult.addData(NotificationCompat.CATEGORY_STATUS, "denied");
            wVCallBackContext.success(wVResult);
        }
    }

    private void openSettings(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            try {
                str2 = new JSONObject(str).optString("type", "");
            } catch (JSONException unused) {
                wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
                str2 = null;
            }
            if (!"Notification".equals(str2)) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                Context context = this.mContext;
                if (context != null) {
                    intent.setData(Uri.fromParts(WVConfigManager.CONFIGNAME_PACKAGE, context.getPackageName(), null));
                    this.mContext.startActivity(intent);
                    wVCallBackContext.success();
                    return;
                } else {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "fail to open Application Settings");
                    wVCallBackContext.error(wVResult);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("app_package", this.mContext.getPackageName());
                intent2.putExtra("app_uid", this.mContext.getApplicationInfo().uid);
                Context context2 = this.mContext;
                if (context2 != null) {
                    context2.startActivity(intent2);
                    wVCallBackContext.success();
                    return;
                }
            }
            WVResult wVResult2 = new WVResult();
            wVResult2.addData(NotificationCompat.CATEGORY_MESSAGE, "fail to open Notification Settings");
            wVCallBackContext.error(wVResult2);
        } catch (Throwable unused2) {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getNotificationSettings".equals(str)) {
            getNotificationSettings(wVCallBackContext, str2);
            return true;
        }
        if (!"openSettings".equals(str)) {
            return false;
        }
        openSettings(wVCallBackContext, str2);
        return true;
    }
}
