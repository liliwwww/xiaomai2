package android.taobao.windvane.jsbridge.api;

import android.graphics.Bitmap;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVFileInfo;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVCamera$6 implements Runnable {
    final /* synthetic */ WVCamera this$0;
    final /* synthetic */ Bitmap val$bm2;
    final /* synthetic */ WVFileInfo val$fileInfo;
    final /* synthetic */ WVCamera$UploadParams val$params;
    final /* synthetic */ String val$targetPath;

    WVCamera$6(WVCamera wVCamera, Bitmap bitmap, WVFileInfo wVFileInfo, String str, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = wVCamera;
        this.val$bm2 = bitmap;
        this.val$fileInfo = wVFileInfo;
        this.val$targetPath = str;
        this.val$params = wVCamera$UploadParams;
    }

    @Override // java.lang.Runnable
    public void run() {
        FileOutputStream fileOutputStream;
        WVResult wVResult = new WVResult();
        if (this.val$bm2 != null) {
            WVCacheManager.getInstance().writeToFile(this.val$fileInfo, new byte[]{0});
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(WVCacheManager.getInstance().getCacheDir(true), this.val$fileInfo.fileName));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception unused) {
            }
            try {
                this.val$bm2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                Bitmap bitmap = this.val$bm2;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.val$bm2.recycle();
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileOutputStream2 = fileOutputStream;
                TaoLog.e("WVCamera", "fail to create bitmap file");
                wVResult.addData("msg", "fail to create bitmap file");
                wVResult.setResult("CREATE_BITMAP_ERROR");
                WVCamera.access$800(this.this$0).error(wVResult);
                Bitmap bitmap2 = this.val$bm2;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.val$bm2.recycle();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        return;
                    } catch (Exception unused4) {
                        return;
                    }
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Bitmap bitmap3 = this.val$bm2;
                if (bitmap3 != null && !bitmap3.isRecycled()) {
                    this.val$bm2.recycle();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        WVCamera.access$900(this.this$0, this.val$targetPath, this.val$params);
        wVResult.setSuccess();
        wVResult.addData(HttpConnector.URL, this.val$params.localUrl);
        wVResult.addData("localPath", this.val$targetPath);
        TaoLog.d("WVCamera", "url:" + this.val$params.localUrl + " localPath:" + this.val$targetPath);
        WVCamera.access$800(this.this$0).fireEvent("WVPhoto.Event.takePhotoSuccess", wVResult.toJsonString());
    }
}
