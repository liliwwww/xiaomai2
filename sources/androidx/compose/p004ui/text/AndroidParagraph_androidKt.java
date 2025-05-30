package androidx.compose.p004ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.p004ui.text.android.TextLayout;
import androidx.compose.p004ui.text.android.style.IndentationFixSpan;
import androidx.compose.p004ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p004ui.text.style.Hyphens;
import androidx.compose.p004ui.text.style.LineBreak;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        if (!z || TextUnit.m5394equalsimpl0(textStyle.m4771getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5394equalsimpl0(textStyle.m4771getLetterSpacingXSAIIZE(), TextUnit.Companion.m5408getUnspecifiedXSAIIZE()) || textStyle.m4773getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign m4773getTextAlignbuA522U = textStyle.m4773getTextAlignbuA522U();
        TextAlign.Companion companion = TextAlign.Companion;
        if (m4773getTextAlignbuA522U == null ? false : TextAlign.m5075equalsimpl0(m4773getTextAlignbuA522U.m5078unboximpl(), companion.m5084getStarte0LSkKk())) {
            return false;
        }
        TextAlign m4773getTextAlignbuA522U2 = textStyle.m4773getTextAlignbuA522U();
        return !(m4773getTextAlignbuA522U2 == null ? false : TextAlign.m5075equalsimpl0(m4773getTextAlignbuA522U2.m5078unboximpl(), companion.m5081getJustifye0LSkKk()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m4618toLayoutAlignAMY3VfE(TextAlign textAlign) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlign == null ? false : TextAlign.m5075equalsimpl0(textAlign.m5078unboximpl(), companion.m5082getLefte0LSkKk())) {
            return 3;
        }
        if (textAlign == null ? false : TextAlign.m5075equalsimpl0(textAlign.m5078unboximpl(), companion.m5083getRighte0LSkKk())) {
            return 4;
        }
        if (textAlign == null ? false : TextAlign.m5075equalsimpl0(textAlign.m5078unboximpl(), companion.m5079getCentere0LSkKk())) {
            return 2;
        }
        if (textAlign == null ? false : TextAlign.m5075equalsimpl0(textAlign.m5078unboximpl(), companion.m5084getStarte0LSkKk())) {
            return 0;
        }
        return textAlign == null ? false : TextAlign.m5075equalsimpl0(textAlign.m5078unboximpl(), companion.m5080getEnde0LSkKk()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m4619toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        if (strategy == null ? false : LineBreak.Strategy.m5015equalsimpl0(strategy.m5018unboximpl(), companion.m5021getSimplefcGXIks())) {
            return 0;
        }
        if (strategy == null ? false : LineBreak.Strategy.m5015equalsimpl0(strategy.m5018unboximpl(), companion.m5020getHighQualityfcGXIks())) {
            return 1;
        }
        return strategy == null ? false : LineBreak.Strategy.m5015equalsimpl0(strategy.m5018unboximpl(), companion.m5019getBalancedfcGXIks()) ? 2 : 0;
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
    public static final int m4620toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        if (strictness == null ? false : LineBreak.Strictness.m5025equalsimpl0(strictness.m5028unboximpl(), companion.m5029getDefaultusljTpc())) {
            return 0;
        }
        if (strictness == null ? false : LineBreak.Strictness.m5025equalsimpl0(strictness.m5028unboximpl(), companion.m5030getLooseusljTpc())) {
            return 1;
        }
        if (strictness == null ? false : LineBreak.Strictness.m5025equalsimpl0(strictness.m5028unboximpl(), companion.m5031getNormalusljTpc())) {
            return 2;
        }
        return strictness == null ? false : LineBreak.Strictness.m5025equalsimpl0(strictness.m5028unboximpl(), companion.m5032getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m4621toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        if (wordBreak == null ? false : LineBreak.WordBreak.m5036equalsimpl0(wordBreak.m5039unboximpl(), companion.m5040getDefaultjp8hJ3c())) {
            return 0;
        }
        return wordBreak == null ? false : LineBreak.WordBreak.m5036equalsimpl0(wordBreak.m5039unboximpl(), companion.m5041getPhrasejp8hJ3c()) ? 1 : 0;
    }
}
