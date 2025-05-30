package androidx.core.provider;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FontRequestWorker$TypefaceResult {
    final int mResult;
    final Typeface mTypeface;

    FontRequestWorker$TypefaceResult(int i) {
        this.mTypeface = null;
        this.mResult = i;
    }

    @SuppressLint({"WrongConstant"})
    boolean isSuccess() {
        return this.mResult == 0;
    }

    @SuppressLint({"WrongConstant"})
    FontRequestWorker$TypefaceResult(@NonNull Typeface typeface) {
        this.mTypeface = typeface;
        this.mResult = 0;
    }
}
