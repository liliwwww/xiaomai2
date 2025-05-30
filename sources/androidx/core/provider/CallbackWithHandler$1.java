package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.FontsContractCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class CallbackWithHandler$1 implements Runnable {
    final /* synthetic */ CallbackWithHandler this$0;
    final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
    final /* synthetic */ Typeface val$typeface;

    CallbackWithHandler$1(CallbackWithHandler callbackWithHandler, FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontRequestCallback;
        this.val$typeface = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onTypefaceRetrieved(this.val$typeface);
    }
}
