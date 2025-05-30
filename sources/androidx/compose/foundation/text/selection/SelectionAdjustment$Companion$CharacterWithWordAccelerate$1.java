package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 implements SelectionAdjustment {
    SelectionAdjustment$Companion$CharacterWithWordAccelerate$1() {
    }

    private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
        long m1890getWordBoundaryjx7JFs = textLayoutResult.m1890getWordBoundaryjx7JFs(i);
        return i == TextRange.getStart-impl(m1890getWordBoundaryjx7JFs) || i == TextRange.getEnd-impl(m1890getWordBoundaryjx7JFs);
    }

    private final boolean isExpanding(int i, int i2, boolean z, boolean z2) {
        if (i2 == -1) {
            return true;
        }
        if (i == i2) {
            return false;
        }
        if (z ^ z2) {
            if (i < i2) {
                return true;
            }
        } else if (i > i2) {
            return true;
        }
        return false;
    }

    private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, boolean z, boolean z2) {
        long m1890getWordBoundaryjx7JFs = textLayoutResult.m1890getWordBoundaryjx7JFs(i);
        int i4 = textLayoutResult.getLineForOffset(TextRange.getStart-impl(m1890getWordBoundaryjx7JFs)) == i2 ? TextRange.getStart-impl(m1890getWordBoundaryjx7JFs) : textLayoutResult.getLineStart(i2);
        int i5 = textLayoutResult.getLineForOffset(TextRange.getEnd-impl(m1890getWordBoundaryjx7JFs)) == i2 ? TextRange.getEnd-impl(m1890getWordBoundaryjx7JFs) : TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, null);
        if (i4 == i3) {
            return i5;
        }
        if (i5 == i3) {
            return i4;
        }
        int i6 = (i4 + i5) / 2;
        if (z ^ z2) {
            if (i <= i6) {
                return i4;
            }
        } else if (i < i6) {
            return i4;
        }
        return i5;
    }

    private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (i == i2) {
            return i3;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        return lineForOffset != textLayoutResult.getLineForOffset(i3) ? snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2) : (isExpanding(i, i2, z, z2) && isAtWordBoundary(textLayoutResult, i3)) ? snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2) : i;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
    /* renamed from: adjust-ZXO7KMw */
    public long mo463adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
        int updateSelectionBoundary;
        int i2;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (textRange == null) {
            return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo463adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
        }
        if (TextRange.getCollapsed-impl(j)) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.getStart-impl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, TextRange.getReversed-impl(textRange.unbox-impl()));
        }
        if (z) {
            i2 = updateSelectionBoundary(textLayoutResult, TextRange.getStart-impl(j), i, TextRange.getStart-impl(textRange.unbox-impl()), TextRange.getEnd-impl(j), true, TextRange.getReversed-impl(j));
            updateSelectionBoundary = TextRange.getEnd-impl(j);
        } else {
            int i3 = TextRange.getStart-impl(j);
            updateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.getEnd-impl(j), i, TextRange.getEnd-impl(textRange.unbox-impl()), TextRange.getStart-impl(j), false, TextRange.getReversed-impl(j));
            i2 = i3;
        }
        return TextRangeKt.TextRange(i2, updateSelectionBoundary);
    }
}
