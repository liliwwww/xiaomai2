package android.taobao.windvane.extra.jsbridge;

import android.graphics.Bitmap;
import android.os.Message;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera$UploadParams;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import mtopsdk.mtop.upload.FileUploadBaseListener;
import mtopsdk.mtop.upload.domain.UploadFileInfo;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TBUploadService$5 implements FileUploadBaseListener {
    final /* synthetic */ TBUploadService this$0;
    final /* synthetic */ WVCamera$UploadParams val$params;
    final /* synthetic */ WVResult val$result;

    TBUploadService$5(TBUploadService tBUploadService, WVResult wVResult, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = tBUploadService;
        this.val$result = wVResult;
        this.val$params = wVCamera$UploadParams;
    }

    public void onError(String str, String str2) {
        if (TaoLog.getLogStatus()) {
            TaoLog.w("TBUploadService", "mtop upload file error. code: " + str + ";msg: " + str2);
        }
        this.val$result.addData("errorCode", str);
        this.val$result.addData("errorMsg", str2);
        this.val$result.addData("localPath", this.val$params.filePath);
        Message.obtain(TBUploadService.access$100(this.this$0), 2003, this.val$result).sendToTarget();
    }

    public void onFinish(UploadFileInfo uploadFileInfo, String str) {
        Bitmap readZoomImage;
        this.val$result.setSuccess();
        this.val$result.addData(HttpConnector.URL, this.val$params.localUrl);
        this.val$result.addData("localPath", this.val$params.filePath);
        this.val$result.addData("resourceURL", str);
        WVCamera$UploadParams wVCamera$UploadParams = this.val$params;
        if (wVCamera$UploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(wVCamera$UploadParams.filePath, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END)) != null) {
            this.val$result.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
        }
        int lastIndexOf = str.lastIndexOf("/") + 1;
        if (lastIndexOf != 0) {
            this.val$result.addData("tfsKey", str.substring(lastIndexOf));
        }
        WVCamera$UploadParams wVCamera$UploadParams2 = this.val$params;
        if (wVCamera$UploadParams2.isLastPic) {
            this.val$result.addData("images", wVCamera$UploadParams2.images);
        }
        Message.obtain(TBUploadService.access$100(this.this$0), 2002, this.val$result).sendToTarget();
    }

    public void onProgress(int i) {
    }

    public void onStart() {
        this.val$result.setResult("");
        Message.obtain(TBUploadService.access$100(this.this$0), 2001, this.val$result).sendToTarget();
    }

    public void onError(String str, String str2, String str3) {
        if (TaoLog.getLogStatus()) {
            TaoLog.w("TBUploadService", "mtop upload file error. code: " + str2 + ";msg: " + str3 + ";type: " + str);
        }
        this.val$result.addData("errorType", str);
        this.val$result.addData("errorCode", str2);
        this.val$result.addData("errorMsg", str3);
        this.val$result.addData("localPath", this.val$params.filePath);
        Message.obtain(TBUploadService.access$100(this.this$0), 2003, this.val$result).sendToTarget();
    }

    public void onFinish(String str) {
        this.val$result.setSuccess();
        this.val$result.addData(HttpConnector.URL, this.val$params.localUrl);
        this.val$result.addData("localPath", this.val$params.filePath);
        this.val$result.addData("resourceURL", str);
        int lastIndexOf = str.lastIndexOf("/") + 1;
        if (lastIndexOf != 0) {
            this.val$result.addData("tfsKey", str.substring(lastIndexOf));
        }
        WVCamera$UploadParams wVCamera$UploadParams = this.val$params;
        if (wVCamera$UploadParams.isLastPic) {
            this.val$result.addData("images", wVCamera$UploadParams.images);
        }
        Message.obtain(TBUploadService.access$100(this.this$0), 2002, this.val$result).sendToTarget();
    }
}
