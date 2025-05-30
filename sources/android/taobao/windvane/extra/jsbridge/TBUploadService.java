package android.taobao.windvane.extra.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.upload.UploadFileConnection;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.jsbridge.api.WVUploadService;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import com.uploader.export.a;
import java.io.File;
import java.io.IOException;
import mtopsdk.mtop.upload.FileUploadMgr;
import mtopsdk.mtop.upload.domain.UploadFileInfo;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class TBUploadService extends WVUploadService implements Handler.Callback {
    private static final String LAST_PIC = "\"isLastPic\":\"true\"";
    private static final String MUTI_SELECTION = "\"mutipleSelection\":\"1\"";
    private static final int NOTIFY_ERROR = 2003;
    private static final int NOTIFY_FINISH = 2002;
    private static final int NOTIFY_START = 2001;
    private static final String TAG = "TBUploadService";
    private WVCallBackContext mCallback;
    private Handler mHandler;

    public TBUploadService() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMtopUpload(WVCamera.UploadParams uploadParams) {
        try {
            File createTempFile = File.createTempFile("windvane", "." + MimeTypeEnum.JPG.getSuffix(), WVCacheManager.getInstance().getTempDir(true));
            if (!FileManager.copy(new File(uploadParams.filePath), createTempFile)) {
                WVResult wVResult = new WVResult();
                wVResult.addData("errorInfo", "Failed to copy file!");
                this.mCallback.error(wVResult);
                return;
            }
            WVResult wVResult2 = new WVResult();
            try {
                a.a().uploadAsync(new 3(this, uploadParams, createTempFile), new 4(this, wVResult2, uploadParams), this.mHandler);
                TaoLog.i(TAG, "do aus upload " + uploadParams.filePath);
            } catch (Throwable th) {
                TaoLog.w(TAG, "try aus upload error : " + th.getMessage());
                try {
                    UploadFileInfo uploadFileInfo = new UploadFileInfo();
                    uploadFileInfo.setFilePath(createTempFile.getAbsolutePath());
                    uploadFileInfo.setBizCode(uploadParams.bizCode);
                    uploadFileInfo.setPrivateData(uploadParams.extraData);
                    wVResult2.addData("identifier", uploadParams.identifier);
                    wVResult2.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                    wVResult2.addData("mutipleSelection", uploadParams.mutipleSelection);
                    FileUploadMgr.getInstance().addTask(uploadFileInfo, new 5(this, wVResult2, uploadParams), uploadParams.needLogin);
                    TaoLog.i(TAG, "do mtop upload " + uploadParams.filePath);
                } catch (Throwable th2) {
                    TaoLog.e(TAG, "mtop sdk not exist." + th2.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doNormalUpload(WVCamera.UploadParams uploadParams) {
        WVThreadPool.getInstance().execute(new UploadFileConnection(uploadParams.filePath, MimeTypeEnum.JPG.getSuffix(), new 2(this, uploadParams)));
    }

    @Override // android.taobao.windvane.jsbridge.api.WVUploadService
    public void doUpload(WVCamera.UploadParams uploadParams, WVCallBackContext wVCallBackContext) {
        if (uploadParams == null) {
            TaoLog.d(TAG, "UploadParams is null.");
            wVCallBackContext.error(new WVResult());
            return;
        }
        this.mCallback = wVCallBackContext;
        try {
            AppMonitorUtil.commitOffMonitor(wVCallBackContext.getWebview().getUrl(), "TBUploadService bizCode:" + uploadParams.bizCode, uploadParams.v);
        } catch (Throwable unused) {
        }
        if (!"2.0".equals(uploadParams.v)) {
            doNormalUpload(uploadParams);
            return;
        }
        WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
        if (wVIAdapter != null) {
            wVIAdapter.getLoginInfo(null);
        }
        WVThreadPool.getInstance().execute(new 1(this, uploadParams));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:17|(1:19)|20|21|22|23|24|(9:26|27|28|29|30|31|32|33|(2:35|36))|38|39|40|(1:42)|44|(1:46)(3:49|(1:(1:52)(1:53))|54)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[Catch: JSONException -> 0x00dd, TRY_LEAVE, TryCatch #5 {JSONException -> 0x00dd, blocks: (B:40:0x00cb, B:42:0x00d9), top: B:39:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleMessage(android.os.Message r20) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.jsbridge.TBUploadService.handleMessage(android.os.Message):boolean");
    }
}
