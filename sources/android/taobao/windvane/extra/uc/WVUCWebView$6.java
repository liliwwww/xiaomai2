package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.NetWork;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebView$6 implements Callable<Boolean> {
    final /* synthetic */ WVUCWebView this$0;

    WVUCWebView$6(WVUCWebView wVUCWebView) {
        this.this$0 = wVUCWebView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        return Boolean.valueOf(NetWork.isConnectionInexpensive());
    }
}
