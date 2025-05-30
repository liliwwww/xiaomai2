package android.taobao.windvane.extra.upload;

import android.taobao.windvane.connect.HttpConnectListener;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UploadFileConnection implements Runnable {
    private static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    private static final int DEFAULT_READ_TIMEOUT = 60000;
    public static final int ERROE_CODE_FAIL = 1;
    public static final String ERROE_MSG_FAIL = "FAIL";
    public static final int ERR_CODE_TOKEN_INVALID = 2;
    public static final String ERR_MSG_TOKEN_INVALID = "TOKEN_IS_INVALID";
    private static final String TAG = "UploadFileConnection";
    private String accessToken;
    private String mFileExt;
    private String mFilePath;
    private HttpConnectListener<UploadFileData> mListener;
    private int tryNum;

    public UploadFileConnection(String str, String str2, HttpConnectListener<UploadFileData> httpConnectListener) {
        this.mListener = httpConnectListener;
        this.mFilePath = str;
        this.mFileExt = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106 A[Catch: JSONException -> 0x016a, TryCatch #3 {JSONException -> 0x016a, blocks: (B:53:0x00fd, B:55:0x0106, B:57:0x0165), top: B:52:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0172  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.upload.UploadFileConnection.run():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b4, code lost:
    
        if (r13 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01b6, code lost:
    
        r13.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01bd, code lost:
    
        if (android.taobao.windvane.util.TaoLog.getLogStatus() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01bf, code lost:
    
        android.taobao.windvane.util.TaoLog.m18d(android.taobao.windvane.extra.upload.UploadFileConnection.TAG, "upload file fail.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ca, code lost:
    
        return new android.taobao.windvane.connect.HttpResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0184, code lost:
    
        if (r13 == null) goto L70;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.taobao.windvane.connect.HttpResponse uploadFile(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.upload.UploadFileConnection.uploadFile(java.lang.String, java.lang.String):android.taobao.windvane.connect.HttpResponse");
    }
}
