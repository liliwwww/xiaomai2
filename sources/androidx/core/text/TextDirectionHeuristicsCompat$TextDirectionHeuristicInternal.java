package androidx.core.text;

import java.nio.CharBuffer;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;

    TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(final TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm, boolean z) {
        new TextDirectionHeuristicCompat(textDirectionHeuristicsCompat$TextDirectionAlgorithm) { // from class: androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
            private final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;

            {
                this.mAlgorithm = textDirectionHeuristicsCompat$TextDirectionAlgorithm;
            }

            private boolean doCheck(CharSequence charSequence, int i, int i2) {
                int checkRtl = this.mAlgorithm.checkRtl(charSequence, i, i2);
                if (checkRtl == 0) {
                    return true;
                }
                if (checkRtl != 1) {
                    return defaultIsRtl();
                }
                return false;
            }

            protected abstract boolean defaultIsRtl();

            public boolean isRtl(char[] cArr, int i, int i2) {
                return isRtl(CharBuffer.wrap(cArr), i, i2);
            }

            public boolean isRtl(CharSequence charSequence, int i, int i2) {
                if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                    throw new IllegalArgumentException();
                }
                return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence, i, i2);
            }
        };
        this.mDefaultIsRtl = z;
    }

    @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
    protected boolean defaultIsRtl() {
        return this.mDefaultIsRtl;
    }
}
