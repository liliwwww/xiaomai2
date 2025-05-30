package android.taobao.windvane.webview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.util.TaoLog;
import android.webkit.DownloadListener;
import android.widget.Toast;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVWebView$WVDownLoadListener implements DownloadListener {
    final /* synthetic */ WVWebView this$0;

    WVWebView$WVDownLoadListener(WVWebView wVWebView) {
        this.this$0 = wVWebView;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVWebView", "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
        }
        if (!this.this$0.supportDownload) {
            TaoLog.w("WVWebView", "DownloadListener is not support for webview.");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.this$0.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this.this$0.context, "对不起，您的设备找不到相应的程序", 1).show();
            TaoLog.e("WVWebView", "DownloadListener not found activity to open this url.");
        }
    }
}
