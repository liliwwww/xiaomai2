package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.jsbridge.api.WVCamera$UploadParams;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TBUploadService$1 implements Runnable {
    final /* synthetic */ TBUploadService this$0;
    final /* synthetic */ WVCamera$UploadParams val$params;

    TBUploadService$1(TBUploadService tBUploadService, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = tBUploadService;
        this.val$params = wVCamera$UploadParams;
    }

    @Override // java.lang.Runnable
    public void run() {
        TBUploadService.access$000(this.this$0, this.val$params);
    }
}
