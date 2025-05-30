package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(int i, int i2, boolean z, boolean z2) {
        return i2 == 0 ? TextRangeKt.TextRange(i, i) : i == 0 ? z ? TextRangeKt.TextRange(1, 0) : TextRangeKt.TextRange(0, 1) : i == i2 ? z ? TextRangeKt.TextRange(i2 - 1, i2) : TextRangeKt.TextRange(i2, i2 - 1) : z ? !z2 ? TextRangeKt.TextRange(i - 1, i) : TextRangeKt.TextRange(i + 1, i) : !z2 ? TextRangeKt.TextRange(i, i + 1) : TextRangeKt.TextRange(i, i - 1);
    }
}
