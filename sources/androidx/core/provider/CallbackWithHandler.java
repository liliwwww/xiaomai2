package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class CallbackWithHandler {

    @NonNull
    private final FontsContractCompat$FontRequestCallback mCallback;

    @NonNull
    private final Handler mCallbackHandler;

    CallbackWithHandler(@NonNull FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, @NonNull Handler handler) {
        this.mCallback = fontsContractCompat$FontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int i) {
        this.mCallbackHandler.post(new 2(this, this.mCallback, i));
    }

    private void onTypefaceRetrieved(@NonNull Typeface typeface) {
        this.mCallbackHandler.post(new 1(this, this.mCallback, typeface));
    }

    void onTypefaceResult(@NonNull FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        if (fontRequestWorker$TypefaceResult.isSuccess()) {
            onTypefaceRetrieved(fontRequestWorker$TypefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(fontRequestWorker$TypefaceResult.mResult);
        }
    }

    CallbackWithHandler(@NonNull FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback) {
        this.mCallback = fontsContractCompat$FontRequestCallback;
        this.mCallbackHandler = CalleeHandler.create();
    }
}
