package androidx.emoji2.text;

import androidx.core.text.PrecomputedTextCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class UnprecomputeTextOnModificationSpannable$PrecomputedTextDetector {
    UnprecomputeTextOnModificationSpannable$PrecomputedTextDetector() {
    }

    boolean isPrecomputedText(CharSequence charSequence) {
        return charSequence instanceof PrecomputedTextCompat;
    }
}
