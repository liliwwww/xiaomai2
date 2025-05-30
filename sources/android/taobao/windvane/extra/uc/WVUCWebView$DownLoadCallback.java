package android.taobao.windvane.extra.uc;

import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WVUCWebView$DownLoadCallback implements ValueCallback<SetupTask> {
    private WVUCWebView$DownLoadCallback() {
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(SetupTask setupTask) {
        int percent = setupTask.getPercent();
        if (WVCore.getInstance().getCoreDownLoadBack() != null) {
            WVCore.getInstance().getCoreDownLoadBack().progress(percent);
        }
        TaoLog.i("UCCore", "download progress:[" + percent + "]%");
    }
}
