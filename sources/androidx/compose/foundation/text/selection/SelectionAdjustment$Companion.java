package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionAdjustment$Companion {
    static final /* synthetic */ SelectionAdjustment$Companion $$INSTANCE = new SelectionAdjustment$Companion();

    @NotNull
    private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
        /* renamed from: adjust-ZXO7KMw, reason: not valid java name */
        public long m603adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            return j;
        }
    };

    @NotNull
    private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
        /* renamed from: adjust-ZXO7KMw, reason: not valid java name */
        public long m602adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            if (TextRange.m2324getCollapsedimpl(j)) {
                return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m2330getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, textRange != null ? TextRange.m2329getReversedimpl(textRange.m2334unboximpl()) : false);
            }
            return j;
        }
    };

    @NotNull
    private static final SelectionAdjustment Word = new Word.1();

    @NotNull
    private static final SelectionAdjustment Paragraph = new Paragraph.1();

    @NotNull
    private static final SelectionAdjustment CharacterWithWordAccelerate = new CharacterWithWordAccelerate.1();

    private SelectionAdjustment$Companion() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: adjustByBoundary--Dv-ylE, reason: not valid java name */
    public final long m601adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, Function1<? super Integer, TextRange> function1) {
        if (textLayoutResult.getLayoutInput().getText().length() == 0) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        int lastIndex = StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
        long m2334unboximpl = ((TextRange) function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m2330getStartimpl(j), 0, lastIndex)))).m2334unboximpl();
        long m2334unboximpl2 = ((TextRange) function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m2325getEndimpl(j), 0, lastIndex)))).m2334unboximpl();
        return TextRangeKt.TextRange(TextRange.m2329getReversedimpl(j) ? TextRange.m2325getEndimpl(m2334unboximpl) : TextRange.m2330getStartimpl(m2334unboximpl), TextRange.m2329getReversedimpl(j) ? TextRange.m2330getStartimpl(m2334unboximpl2) : TextRange.m2325getEndimpl(m2334unboximpl2));
    }

    @NotNull
    public final SelectionAdjustment getCharacter() {
        return Character;
    }

    @NotNull
    public final SelectionAdjustment getCharacterWithWordAccelerate() {
        return CharacterWithWordAccelerate;
    }

    @NotNull
    public final SelectionAdjustment getNone() {
        return None;
    }

    @NotNull
    public final SelectionAdjustment getParagraph() {
        return Paragraph;
    }

    @NotNull
    public final SelectionAdjustment getWord() {
        return Word;
    }
}
