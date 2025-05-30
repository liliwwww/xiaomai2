package androidx.core.provider;

import androidx.core.provider.FontsContractCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class CallbackWithHandler$2 implements Runnable {
    final /* synthetic */ CallbackWithHandler this$0;
    final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
    final /* synthetic */ int val$reason;

    CallbackWithHandler$2(CallbackWithHandler callbackWithHandler, FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontRequestCallback;
        this.val$reason = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onTypefaceRequestFailed(this.val$reason);
    }
}
