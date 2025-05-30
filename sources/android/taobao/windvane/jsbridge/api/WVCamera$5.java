package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVCamera$5 implements View.OnClickListener {
    final /* synthetic */ WVCamera this$0;

    WVCamera$5(WVCamera wVCamera) {
        this.this$0 = wVCamera;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WVCamera.access$400(this.this$0).hide();
        WVResult wVResult = new WVResult();
        if (WVCamera.access$500(this.this$0)[0].equals(view.getTag())) {
            WVCamera.access$600(this.this$0);
        } else {
            if (WVCamera.access$500(this.this$0)[1].equals(view.getTag())) {
                WVCamera.access$700(this.this$0);
                return;
            }
            wVResult.addData("msg", "CANCELED_BY_USER");
            TaoLog.w("WVCamera", "take photo cancel, and callback.");
            WVCamera.access$800(this.this$0).error(wVResult);
        }
    }
}
