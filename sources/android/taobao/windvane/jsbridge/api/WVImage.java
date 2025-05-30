package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVImage extends WVApiPlugin {
    private static final String TAG = "WVImage";

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str, WVCallBackContext wVCallBackContext) {
        try {
            String optString = new JSONObject(str).optString(HttpConnector.URL, "");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ImageTool.saveImageToDCIM(this.mContext, optString, (ImageTool.ImageSaveCallback) new 3(this, wVCallBackContext));
        } catch (JSONException e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TextUtils.equals(str, "saveImage")) {
            return false;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new 2(this, str2, wVCallBackContext)).setTaskOnPermissionDenied(new 1(this, wVCallBackContext)).execute();
            return true;
        } catch (Exception e) {
            TaoLog.d(TAG, "Run whith some exception!");
            e.printStackTrace();
            return false;
        }
    }
}
