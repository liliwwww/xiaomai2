package android.taobao.windvane.jsbridge.api;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.DigestUtils;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import java.io.File;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVScreen extends WVApiPlugin {
    private static final String TAG = "WVScreen";

    public void capture(WVCallBackContext wVCallBackContext, String str) {
        String optString;
        String optString2;
        boolean optBoolean;
        long j;
        long j2;
        WVResult wVResult = new WVResult();
        int i = 50;
        if (TextUtils.isEmpty(str)) {
            optString = "";
            optString2 = "app";
            j = 10240;
            j2 = 10240;
            optBoolean = true;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                optString = jSONObject.optString("inAlbum", "false");
                optString2 = jSONObject.optString("type", "view");
                long optLong = jSONObject.optLong("maxShortSide", 10240L);
                long optLong2 = jSONObject.optLong("maxLongSide", 10240L);
                int optInt = jSONObject.optInt("quality", 50);
                if (optInt <= 100 && optInt >= 0) {
                    i = optInt;
                }
                optBoolean = jSONObject.optBoolean("compress", true);
                j = optLong2;
                j2 = optLong;
            } catch (Exception e) {
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "param error: [" + e.getMessage() + "]");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        boolean z = !"false".equals(optString);
        try {
            String virtualPath = WVUtils.getVirtualPath(Long.valueOf(optString2.equals("app") ? ScreenCaptureUtil.captureByActivty((Activity) this.mContext, z, i, j, j2, optBoolean) : ScreenCaptureUtil.capture(this.mWebView.getView(), z, i, j, j2, optBoolean)));
            wVResult.addData(HttpConnector.URL, virtualPath);
            wVResult.addData("localPath", WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(virtualPath));
            wVCallBackContext.success(wVResult);
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if ("capture".equals(str)) {
            Context context = this.mContext;
            if (context == null) {
                return true;
            }
            PermissionProposer.buildPermissionTask(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVScreen.2
                @Override // java.lang.Runnable
                public void run() {
                    WVScreen.this.capture(wVCallBackContext, str2);
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVScreen.1
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "no permission");
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
            return true;
        }
        if ("getOrientation".equals(str)) {
            getOrientation(wVCallBackContext, str2);
            return true;
        }
        if (!"setOrientation".equals(str)) {
            return false;
        }
        setOrientation(wVCallBackContext, str2);
        return true;
    }

    public void getOrientation(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            wVResult.addData("error", "Context must be Activty!");
            wVCallBackContext.error(wVResult);
        } else {
            int requestedOrientation = ((Activity) context).getRequestedOrientation();
            wVResult.addData("orientation", requestedOrientation == 0 ? "landscape" : requestedOrientation == 1 ? "portrait" : EnvironmentCompat.MEDIA_UNKNOWN);
            wVCallBackContext.success(wVResult);
        }
    }

    public void setOrientation(WVCallBackContext wVCallBackContext, String str) {
        new WVResult();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).optString("orientation", "");
            } catch (Exception unused) {
                wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
            }
        }
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            WVResult wVResult = new WVResult();
            wVResult.addData("error", "Context must be Activty!");
            wVCallBackContext.error(wVResult);
            return;
        }
        Activity activity = (Activity) context;
        if (str2.equals("landscape") || str2.equals("landscapeRight")) {
            activity.setRequestedOrientation(0);
        } else if (str2.equals("landscapeLeft")) {
            activity.setRequestedOrientation(8);
        } else if (str2.equals("portrait") || str2.equals("default")) {
            activity.setRequestedOrientation(1);
        } else if (str2.equals("portraitUpsideDown")) {
            activity.setRequestedOrientation(9);
        } else {
            if (!str2.equals("auto")) {
                wVCallBackContext.error();
                return;
            }
            activity.setRequestedOrientation(4);
        }
        wVCallBackContext.success();
    }
}
