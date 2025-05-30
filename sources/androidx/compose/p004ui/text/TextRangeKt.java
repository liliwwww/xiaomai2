package androidx.compose.p004ui.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextRangeKt {
    public static final long TextRange(int i, int i2) {
        return TextRange.m4738constructorimpl(packWithCheck(i, i2));
    }

    /* renamed from: constrain-8ffj60Q, reason: not valid java name */
    public static final long m4755constrain8ffj60Q(long j, int i, int i2) {
        int coerceIn = RangesKt.coerceIn(TextRange.m4749getStartimpl(j), i, i2);
        int coerceIn2 = RangesKt.coerceIn(TextRange.m4744getEndimpl(j), i, i2);
        return (coerceIn == TextRange.m4749getStartimpl(j) && coerceIn2 == TextRange.m4744getEndimpl(j)) ? j : TextRange(coerceIn, coerceIn2);
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
    public static final String m4756substringFDrldGo(@NotNull CharSequence charSequence, long j) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        return charSequence.subSequence(TextRange.m4747getMinimpl(j), TextRange.m4746getMaximpl(j)).toString();
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }
}
