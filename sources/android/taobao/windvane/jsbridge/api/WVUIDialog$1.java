package android.taobao.windvane.jsbridge.api;

import android.content.DialogInterface;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVUIDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ WVUIDialog this$0;

    WVUIDialog$1(WVUIDialog wVUIDialog) {
        this.this$0 = wVUIDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WVResult wVResult = new WVResult();
        String access$000 = i == -1 ? WVUIDialog.access$000(this.this$0) : i == -2 ? WVUIDialog.access$100(this.this$0) : "";
        wVResult.addData("type", access$000);
        wVResult.addData("_index", WVUIDialog.access$200(this.this$0));
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVUIDialog", "click: " + access$000);
        }
        wVResult.setSuccess();
        if (WVUIDialog.access$300(this.this$0) != null) {
            WVUIDialog.access$300(this.this$0).fireEvent("wv.dialog", wVResult.toJsonString());
            WVUIDialog.access$300(this.this$0).success(wVResult);
        }
    }
}
