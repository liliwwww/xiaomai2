package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface SelectionAdjustment {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                return j;
            }
        };

        @NotNull
        private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (TextRange.m4743getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m4749getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, textRange != null ? TextRange.m4748getReversedimpl(textRange.m4753unboximpl()) : false);
                }
                return j;
            }
        };

        @NotNull
        private static final SelectionAdjustment Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
                long m1836adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m1836adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m1836adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
                return m1836adjustByBoundaryDvylE;
            }
        };

        @NotNull
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* renamed from: adjust-ZXO7KMw */
            public long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
                long m1836adjustByBoundaryDvylE;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                m1836adjustByBoundaryDvylE = SelectionAdjustment.Companion.$$INSTANCE.m1836adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(textLayoutResult.getLayoutInput().getText()));
                return m1836adjustByBoundaryDvylE;
            }
        };

        @NotNull
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$CharacterWithWordAccelerate$1
            private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
                long m4725getWordBoundaryjx7JFs = textLayoutResult.m4725getWordBoundaryjx7JFs(i);
                return i == TextRange.m4749getStartimpl(m4725getWordBoundaryjx7JFs) || i == TextRange.m4744getEndimpl(m4725getWordBoundaryjx7JFs);
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
                long m4725getWordBoundaryjx7JFs = textLayoutResult.m4725getWordBoundaryjx7JFs(i);
                int m4749getStartimpl = textLayoutResult.getLineForOffset(TextRange.m4749getStartimpl(m4725getWordBoundaryjx7JFs)) == i2 ? TextRange.m4749getStartimpl(m4725getWordBoundaryjx7JFs) : textLayoutResult.getLineStart(i2);
                int m4744getEndimpl = textLayoutResult.getLineForOffset(TextRange.m4744getEndimpl(m4725getWordBoundaryjx7JFs)) == i2 ? TextRange.m4744getEndimpl(m4725getWordBoundaryjx7JFs) : TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, null);
                if (m4749getStartimpl == i3) {
                    return m4744getEndimpl;
                }
                if (m4744getEndimpl == i3) {
                    return m4749getStartimpl;
                }
                int i4 = (m4749getStartimpl + m4744getEndimpl) / 2;
                if (z ^ z2) {
                    if (i <= i4) {
                        return m4749getStartimpl;
                    }
                } else if (i < i4) {
                    return m4749getStartimpl;
                }
                return m4744getEndimpl;
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
            public long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
                int updateSelectionBoundary;
                int i2;
                Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                if (textRange == null) {
                    return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo1834adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
                }
                if (TextRange.m4743getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m4749getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, TextRange.m4748getReversedimpl(textRange.m4753unboximpl()));
                }
                if (z) {
                    i2 = updateSelectionBoundary(textLayoutResult, TextRange.m4749getStartimpl(j), i, TextRange.m4749getStartimpl(textRange.m4753unboximpl()), TextRange.m4744getEndimpl(j), true, TextRange.m4748getReversedimpl(j));
                    updateSelectionBoundary = TextRange.m4744getEndimpl(j);
                } else {
                    int m4749getStartimpl = TextRange.m4749getStartimpl(j);
                    updateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m4744getEndimpl(j), i, TextRange.m4744getEndimpl(textRange.m4753unboximpl()), TextRange.m4749getStartimpl(j), false, TextRange.m4748getReversedimpl(j));
                    i2 = m4749getStartimpl;
                }
                return TextRangeKt.TextRange(i2, updateSelectionBoundary);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: adjustByBoundary--Dv-ylE, reason: not valid java name */
        public final long m1836adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, Function1<? super Integer, TextRange> function1) {
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                return TextRange.Companion.m4754getZerod9O1mEE();
            }
            int lastIndex = StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
            long m4753unboximpl = ((TextRange) function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m4749getStartimpl(j), 0, lastIndex)))).m4753unboximpl();
            long m4753unboximpl2 = ((TextRange) function1.invoke(Integer.valueOf(RangesKt.coerceIn(TextRange.m4744getEndimpl(j), 0, lastIndex)))).m4753unboximpl();
            return TextRangeKt.TextRange(TextRange.m4748getReversedimpl(j) ? TextRange.m4744getEndimpl(m4753unboximpl) : TextRange.m4749getStartimpl(m4753unboximpl), TextRange.m4748getReversedimpl(j) ? TextRange.m4749getStartimpl(m4753unboximpl2) : TextRange.m4744getEndimpl(m4753unboximpl2));
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

    /* renamed from: adjust-ZXO7KMw, reason: not valid java name */
    long mo1834adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange);
}
