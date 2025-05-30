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
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import tb.bg5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TBUploadService$4 implements ITaskListener {
    final /* synthetic */ TBUploadService this$0;
    final /* synthetic */ WVCamera$UploadParams val$params;
    final /* synthetic */ WVResult val$result;

    TBUploadService$4(TBUploadService tBUploadService, WVResult wVResult, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = tBUploadService;
        this.val$result = wVResult;
        this.val$params = wVCamera$UploadParams;
    }

    public void onCancel(IUploaderTask iUploaderTask) {
    }

    public void onFailure(IUploaderTask iUploaderTask, bg5 bg5Var) {
        this.val$result.addData("subCode", bg5Var.b);
        this.val$result.addData("errorCode", bg5Var.a);
        this.val$result.addData("errorMsg", bg5Var.c);
        this.val$result.addData("localPath", this.val$params.filePath);
        Message.obtain(TBUploadService.access$100(this.this$0), 2003, this.val$result).sendToTarget();
    }

    public void onPause(IUploaderTask iUploaderTask) {
    }

    public void onProgress(IUploaderTask iUploaderTask, int i) {
        TaoLog.e("TBUploadService", "uploadFile onProgress " + String.valueOf(i));
    }

    public void onResume(IUploaderTask iUploaderTask) {
    }

    public void onStart(IUploaderTask iUploaderTask) {
    }

    public void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult) {
        Bitmap readZoomImage;
        this.val$result.setSuccess();
        this.val$result.addData(HttpConnector.URL, this.val$params.localUrl);
        this.val$result.addData("localPath", this.val$params.filePath);
        String fileUrl = iTaskResult.getFileUrl();
        this.val$result.addData("resourceURL", fileUrl);
        this.val$result.addData("isLastPic", String.valueOf(this.val$params.isLastPic));
        this.val$result.addData("mutipleSelection", this.val$params.mutipleSelection);
        WVCamera$UploadParams wVCamera$UploadParams = this.val$params;
        if (wVCamera$UploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(wVCamera$UploadParams.filePath, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END)) != null) {
            this.val$result.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
        }
        int lastIndexOf = fileUrl.lastIndexOf("/") + 1;
        if (lastIndexOf != 0) {
            this.val$result.addData("tfsKey", fileUrl.substring(lastIndexOf));
        }
        WVCamera$UploadParams wVCamera$UploadParams2 = this.val$params;
        if (wVCamera$UploadParams2.isLastPic) {
            this.val$result.addData("images", wVCamera$UploadParams2.images);
        }
        Message.obtain(TBUploadService.access$100(this.this$0), 2002, this.val$result).sendToTarget();
    }

    public void onWait(IUploaderTask iUploaderTask) {
    }
}
