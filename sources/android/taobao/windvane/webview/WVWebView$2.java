package android.taobao.windvane.webview;

import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVWebView$2 implements View.OnClickListener {
    final /* synthetic */ WVWebView this$0;

    WVWebView$2(WVWebView wVWebView) {
        this.this$0 = wVWebView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (WVWebView.access$300(this.this$0) != null && WVWebView.access$300(this.this$0).length > 0 && WVWebView.access$300(this.this$0)[0].equals(view.getTag())) {
            try {
                PermissionProposer.buildPermissionTask(this.this$0.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new 2(this)).setTaskOnPermissionDenied(new 1(this)).execute();
            } catch (Exception unused) {
            }
        }
        if (WVWebView.access$200(this.this$0) != null) {
            WVWebView.access$200(this.this$0).hide();
        }
    }
}
