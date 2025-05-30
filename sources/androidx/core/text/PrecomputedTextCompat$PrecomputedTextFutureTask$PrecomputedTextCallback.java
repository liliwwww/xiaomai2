package androidx.core.text;

import androidx.annotation.NonNull;
import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
    private PrecomputedTextCompat.Params mParams;
    private CharSequence mText;

    PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(@NonNull PrecomputedTextCompat.Params params, @NonNull CharSequence charSequence) {
        this.mParams = params;
        this.mText = charSequence;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PrecomputedTextCompat call() throws Exception {
        return PrecomputedTextCompat.create(this.mText, this.mParams);
    }
}
