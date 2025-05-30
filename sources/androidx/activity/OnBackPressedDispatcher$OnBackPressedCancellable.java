package androidx.activity;

import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class OnBackPressedDispatcher$OnBackPressedCancellable implements Cancellable {
    private final OnBackPressedCallback mOnBackPressedCallback;
    final /* synthetic */ OnBackPressedDispatcher this$0;

    OnBackPressedDispatcher$OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    @Override // androidx.activity.Cancellable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public void cancel() {
        this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
        this.mOnBackPressedCallback.removeCancellable(this);
        if (BuildCompat.isAtLeastT()) {
            this.mOnBackPressedCallback.setIsEnabledConsumer(null);
            this.this$0.updateBackInvokedCallbackState();
        }
    }
}
