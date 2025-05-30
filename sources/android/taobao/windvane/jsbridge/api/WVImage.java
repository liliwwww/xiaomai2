package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVImage extends WVApiPlugin {
    private static final String TAG = "WVImage";

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str, final WVCallBackContext wVCallBackContext) {
        try {
            String optString = new JSONObject(str).optString(HttpConnector.URL, "");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ImageTool.saveImageToDCIM(this.mContext, optString, new ImageTool.ImageSaveCallback() { // from class: android.taobao.windvane.jsbridge.api.WVImage.3
                @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
                public void error(String str2) {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, str2);
                    wVCallBackContext.error(wVResult);
                }

                @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
                public void success() {
                    wVCallBackContext.success();
                }
            });
        } catch (JSONException e) {
            WVResult wVResult = new WVResult();
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if (!TextUtils.equals(str, "saveImage")) {
            return false;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVImage.2
                @Override // java.lang.Runnable
                public void run() {
                    TaoLog.m18d("WVImage", "PERMISSION GRANTED");
                    WVImage.this.saveImage(str2, wVCallBackContext);
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVImage.1
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "NO_PERMISSION");
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
            return true;
        } catch (Exception e) {
            TaoLog.m18d("WVImage", "Run whith some exception!");
            e.printStackTrace();
            return false;
        }
    }
}
