package android.taobao.windvane.extra.jsbridge;

import android.graphics.Bitmap;
import android.os.Message;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.extra.upload.UploadFileData;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera$UploadParams;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TBUploadService$2 extends HttpConnectListener<UploadFileData> {
    final /* synthetic */ TBUploadService this$0;
    final /* synthetic */ WVCamera$UploadParams val$params;

    TBUploadService$2(TBUploadService tBUploadService, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = tBUploadService;
        this.val$params = wVCamera$UploadParams;
    }

    public void onError(int i, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("TBUploadService", "upload file error. code: " + i + ";msg: " + str);
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("errorCode", Integer.valueOf(i));
        wVResult.addData("errorMsg", str);
        wVResult.addData("localPath", this.val$params.filePath);
        wVResult.addData("isLastPic", String.valueOf(this.val$params.isLastPic));
        wVResult.addData("mutipleSelection", this.val$params.mutipleSelection);
        Message obtain = Message.obtain();
        obtain.what = 2003;
        obtain.obj = wVResult;
        TBUploadService.access$100(this.this$0).sendMessage(obtain);
    }

    public void onStart() {
        TBUploadService.access$100(this.this$0).sendEmptyMessage(2001);
    }

    public void onFinish(UploadFileData uploadFileData, int i) {
        Bitmap readZoomImage;
        if (uploadFileData == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2002;
        WVResult wVResult = new WVResult();
        wVResult.setSuccess();
        WVCamera$UploadParams wVCamera$UploadParams = this.val$params;
        if (wVCamera$UploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(wVCamera$UploadParams.filePath, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END)) != null) {
            wVResult.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
        }
        wVResult.addData(HttpConnector.URL, this.val$params.localUrl);
        wVResult.addData("localPath", this.val$params.filePath);
        wVResult.addData("resourceURL", uploadFileData.resourceUri);
        wVResult.addData("isLastPic", String.valueOf(this.val$params.isLastPic));
        wVResult.addData("mutipleSelection", this.val$params.mutipleSelection);
        wVResult.addData("tfsKey", uploadFileData.tfsKey);
        WVCamera$UploadParams wVCamera$UploadParams2 = this.val$params;
        if (wVCamera$UploadParams2.isLastPic) {
            wVResult.addData("images", wVCamera$UploadParams2.images);
        }
        obtain.obj = wVResult;
        TBUploadService.access$100(this.this$0).sendMessage(obtain);
    }
}
