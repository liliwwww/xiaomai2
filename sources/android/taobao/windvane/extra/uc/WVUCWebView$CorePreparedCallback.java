package android.taobao.windvane.extra.uc;

import android.app.Application;
import android.taobao.windvane.config.GlobalConfig;
import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WVUCWebView$CorePreparedCallback implements ValueCallback<SetupTask> {
    long startTime;

    WVUCWebView$CorePreparedCallback(long j) {
        this.startTime = 0L;
        this.startTime = j;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(SetupTask setupTask) {
        Application application = GlobalConfig.context;
        if (application == null) {
            return;
        }
        WVUCWebView.access$1800(application, this.startTime);
    }
}
