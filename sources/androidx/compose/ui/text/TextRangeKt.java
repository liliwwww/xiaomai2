package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextRangeKt {
    public static final long TextRange(int i, int i2) {
        return TextRange.constructor-impl(packWithCheck(i, i2));
    }

    /* renamed from: constrain-8ffj60Q, reason: not valid java name */
    public static final long m1894constrain8ffj60Q(long j, int i, int i2) {
        int coerceIn = RangesKt.coerceIn(TextRange.getStart-impl(j), i, i2);
        int coerceIn2 = RangesKt.coerceIn(TextRange.getEnd-impl(j), i, i2);
        return (coerceIn == TextRange.getStart-impl(j) && coerceIn2 == TextRange.getEnd-impl(j)) ? j : TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        }
        if (i2 >= 0) {
            return (i2 & 4294967295L) | (i << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
    }

    @NotNull
    /* renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m1895substringFDrldGo(@NotNull CharSequence charSequence, long j) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        return charSequence.subSequence(TextRange.getMin-impl(j), TextRange.getMax-impl(j)).toString();
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }
}
