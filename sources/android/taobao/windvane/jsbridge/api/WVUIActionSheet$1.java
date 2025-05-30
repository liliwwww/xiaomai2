package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVUIActionSheet$1 implements View.OnClickListener {
    final /* synthetic */ WVUIActionSheet this$0;

    WVUIActionSheet$1(WVUIActionSheet wVUIActionSheet) {
        this.this$0 = wVUIActionSheet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WVResult wVResult = new WVResult();
        wVResult.addData("type", (String) view.getTag());
        wVResult.addData("_index", WVUIActionSheet.access$000(this.this$0));
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVUIActionSheet", "ActionSheet: click: 8.5.0");
        }
        WVUIActionSheet.access$100(this.this$0).hide();
        wVResult.setSuccess();
        WVUIActionSheet.access$200(this.this$0).success(wVResult);
        WVUIActionSheet.access$200(this.this$0).fireEvent("wv.actionsheet", wVResult.toJsonString());
    }
}
