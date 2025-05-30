package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.api.WVContacts;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVContacts$6$1 implements Runnable {
    final /* synthetic */ WVContacts.6 this$1;

    WVContacts$6$1(WVContacts.6 r1) {
        this.this$1 = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVContacts.6 r0 = this.this$1;
        WVContacts.access$200(r0.this$0, r0.val$callback);
    }
}
