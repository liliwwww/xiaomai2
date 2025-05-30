package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class StringHelpersKt {
    public static final int findParagraphEnd(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i2 = i + 1; i2 < length; i2++) {
            if (charSequence.charAt(i2) == '\n') {
                return i2;
            }
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i2 = i - 1; i2 > 0; i2--) {
            if (charSequence.charAt(i2 - 1) == '\n') {
                return i2;
            }
        }
        return 0;
    }

    public static final long getParagraphBoundary(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return TextRangeKt.TextRange(findParagraphStart(charSequence, i), findParagraphEnd(charSequence, i));
    }
}
