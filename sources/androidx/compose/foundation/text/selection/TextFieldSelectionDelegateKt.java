package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldSelectionDelegateKt {
    /* renamed from: getTextFieldSelection-bb3KNj8, reason: not valid java name */
    public static final long m476getTextFieldSelectionbb3KNj8(@Nullable TextLayoutResult textLayoutResult, int i, int i2, @Nullable TextRange textRange, boolean z, @NotNull SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (textLayoutResult == null) {
            return TextRangeKt.TextRange(0, 0);
        }
        long TextRange = TextRangeKt.TextRange(i, i2);
        return (textRange == null && Intrinsics.areEqual(selectionAdjustment, SelectionAdjustment.Companion.getCharacter())) ? TextRange : selectionAdjustment.mo463adjustZXO7KMw(textLayoutResult, TextRange, -1, z, textRange);
    }
}
