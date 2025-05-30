package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m2210equalsimpl0(textStyle.getLetterSpacing-XSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m2210equalsimpl0(textStyle.getLetterSpacing-XSAIIZE(), TextUnit.Companion.m2224getUnspecifiedXSAIIZE()) || textStyle.getTextAlign-buA522U() == null) {
            return false;
        }
        TextAlign textAlign = textStyle.getTextAlign-buA522U();
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getStart-e0LSkKk())) {
            return false;
        }
        TextAlign textAlign2 = textStyle.getTextAlign-buA522U();
        return !(textAlign2 == null ? false : TextAlign.equals-impl0(textAlign2.unbox-impl(), companion.getJustify-e0LSkKk()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m1834toLayoutAlignAMY3VfE(TextAlign textAlign) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getLeft-e0LSkKk())) {
            return 3;
        }
        if (textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getRight-e0LSkKk())) {
            return 4;
        }
        if (textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getCenter-e0LSkKk())) {
            return 2;
        }
        if (textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getStart-e0LSkKk())) {
            return 0;
        }
        return textAlign == null ? false : TextAlign.equals-impl0(textAlign.unbox-impl(), companion.getEnd-e0LSkKk()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m1835toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        if (strategy == null ? false : LineBreak.Strategy.m2021equalsimpl0(strategy.m2024unboximpl(), companion.getSimple-fcGXIks())) {
            return 0;
        }
        if (strategy == null ? false : LineBreak.Strategy.m2021equalsimpl0(strategy.m2024unboximpl(), companion.getHighQuality-fcGXIks())) {
            return 1;
        }
        return strategy == null ? false : LineBreak.Strategy.m2021equalsimpl0(strategy.m2024unboximpl(), companion.getBalanced-fcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toLayoutHyphenationFrequency(Hyphens hyphens) {
        Hyphens.Companion companion = Hyphens.Companion;
        if (Intrinsics.areEqual(hyphens, companion.getAuto())) {
            return Build.VERSION.SDK_INT <= 32 ? 1 : 3;
        }
        Intrinsics.areEqual(hyphens, companion.getNone());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8, reason: not valid java name */
    public static final int m1836toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        if (strictness == null ? false : LineBreak.Strictness.m2028equalsimpl0(strictness.m2031unboximpl(), companion.getDefault-usljTpc())) {
            return 0;
        }
        if (strictness == null ? false : LineBreak.Strictness.m2028equalsimpl0(strictness.m2031unboximpl(), companion.getLoose-usljTpc())) {
            return 1;
        }
        if (strictness == null ? false : LineBreak.Strictness.m2028equalsimpl0(strictness.m2031unboximpl(), companion.getNormal-usljTpc())) {
            return 2;
        }
        return strictness == null ? false : LineBreak.Strictness.m2028equalsimpl0(strictness.m2031unboximpl(), companion.getStrict-usljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m1837toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        if (wordBreak == null ? false : LineBreak.WordBreak.m2035equalsimpl0(wordBreak.m2038unboximpl(), companion.getDefault-jp8hJ3c())) {
            return 0;
        }
        return wordBreak == null ? false : LineBreak.WordBreak.m2035equalsimpl0(wordBreak.m2038unboximpl(), companion.getPhrase-jp8hJ3c()) ? 1 : 0;
    }
}
