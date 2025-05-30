package android.taobao.windvane.extra.uc;

import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WVUCWebView$ExceptionValueCallback implements ValueCallback<SetupTask> {
    private WVUCWebView$ExceptionValueCallback() {
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(SetupTask setupTask) {
        WVUCWebView.access$1600().set(false);
        WVUCWebView.access$1700().set(false);
        try {
            if (setupTask.getException() != null) {
                StringWriter stringWriter = new StringWriter();
                setupTask.getException().printStackTrace(new PrintWriter(stringWriter));
                TaoLog.e("UCCore", "UC ExceptionValueCallback : " + stringWriter.toString());
            }
            if (WVCore.getInstance().getCoreDownLoadBack() != null) {
                WVCore.getInstance().getCoreDownLoadBack().initError();
            }
        } catch (Throwable th) {
            TaoLog.e("WVUCWebView", "UC ExceptionValueCallback Throwable : " + th.getMessage());
        }
    }
}
