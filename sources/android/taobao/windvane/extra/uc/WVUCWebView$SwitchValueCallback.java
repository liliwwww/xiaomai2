package android.taobao.windvane.extra.uc;

import android.taobao.windvane.thread.WVThreadPool;
import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WVUCWebView$SwitchValueCallback implements ValueCallback<SetupTask> {
    long startTime;

    WVUCWebView$SwitchValueCallback(long j) {
        this.startTime = 0L;
        this.startTime = j;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(SetupTask setupTask) {
        WVThreadPool.getInstance().execute(new 1(this));
    }
}
