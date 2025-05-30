package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.jsbridge.api.WVCamera$UploadParams;
import com.uploader.export.IUploaderTask;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TBUploadService$3 implements IUploaderTask {
    final /* synthetic */ TBUploadService this$0;
    final /* synthetic */ WVCamera$UploadParams val$params;
    final /* synthetic */ File val$tmpFile;

    TBUploadService$3(TBUploadService tBUploadService, WVCamera$UploadParams wVCamera$UploadParams, File file) {
        this.this$0 = tBUploadService;
        this.val$params = wVCamera$UploadParams;
        this.val$tmpFile = file;
    }

    public String getBizType() {
        return this.val$params.bizCode;
    }

    public String getFilePath() {
        return this.val$tmpFile.getAbsolutePath();
    }

    public String getFileType() {
        return ".jpg";
    }

    public Map<String, String> getMetaInfo() {
        if (this.val$params.extraInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = this.val$params.extraInfo.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, this.val$params.extraInfo.optString(next));
        }
        return hashMap;
    }
}
