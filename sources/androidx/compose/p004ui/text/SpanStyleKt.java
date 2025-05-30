package androidx.compose.p004ui.text;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.ShadowKt;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.font.FontWeightKt;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.BaselineShiftKt;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextDrawStyleKt;
import androidx.compose.p004ui.text.style.TextForegroundStyle;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.text.style.TextGeometricTransformKt;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m2822getTransparent0d7_KjU();
        DefaultColor = companion.m2813getBlack0d7_KjU();
    }

    @NotNull
    public static final SpanStyle lerp(@NotNull SpanStyle spanStyle, @NotNull SpanStyle spanStyle2, float f) {
        Intrinsics.checkNotNullParameter(spanStyle, "start");
        Intrinsics.checkNotNullParameter(spanStyle2, AliRequestAdapter.PHASE_STOP);
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long m4715lerpTextUnitInheritableC3pnCVY = m4715lerpTextUnitInheritableC3pnCVY(spanStyle.m4711getFontSizeXSAIIZE(), spanStyle2.m4711getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m4712getFontStyle4Lr2A7w(), spanStyle2.m4712getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m4713getFontSynthesisZQGJjVo(), spanStyle2.m4713getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long m4715lerpTextUnitInheritableC3pnCVY2 = m4715lerpTextUnitInheritableC3pnCVY(spanStyle.m4714getLetterSpacingXSAIIZE(), spanStyle2.m4714getLetterSpacingXSAIIZE(), f);
        BaselineShift m4709getBaselineShift5SSeXJ0 = spanStyle.m4709getBaselineShift5SSeXJ0();
        float m4994unboximpl = m4709getBaselineShift5SSeXJ0 != null ? m4709getBaselineShift5SSeXJ0.m4994unboximpl() : BaselineShift.m4989constructorimpl(0.0f);
        BaselineShift m4709getBaselineShift5SSeXJ02 = spanStyle2.m4709getBaselineShift5SSeXJ0();
        float m5001lerpjWV1Mfo = BaselineShiftKt.m5001lerpjWV1Mfo(m4994unboximpl, m4709getBaselineShift5SSeXJ02 != null ? m4709getBaselineShift5SSeXJ02.m4994unboximpl() : BaselineShift.m4989constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long m2838lerpjxsXWHM = ColorKt.m2838lerpjxsXWHM(spanStyle.m4708getBackground0d7_KjU(), spanStyle2.m4708getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(lerp, m4715lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m4715lerpTextUnitInheritableC3pnCVY2, BaselineShift.m4988boximpl(m5001lerpjWV1Mfo), lerp3, localeList, m2838lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m4715lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        return (TextUnitKt.m5415isUnspecifiedR2X_6o(j) || TextUnitKt.m5415isUnspecifiedR2X_6o(j2)) ? ((TextUnit) lerpDiscrete(TextUnit.m5387boximpl(j), TextUnit.m5387boximpl(j2), f)).m5406unboximpl() : TextUnitKt.m5417lerpC3pnCVY(j, j2, f);
    }

    @NotNull
    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "style");
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextForegroundStyle m4716invoke() {
                long j;
                TextForegroundStyle.Companion companion = TextForegroundStyle.Companion;
                j = SpanStyleKt.DefaultColor;
                return companion.m5098from8_81llA(j);
            }
        });
        long m4711getFontSizeXSAIIZE = TextUnitKt.m5415isUnspecifiedR2X_6o(spanStyle.m4711getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m4711getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle m4712getFontStyle4Lr2A7w = spanStyle.m4712getFontStyle4Lr2A7w();
        FontStyle m4831boximpl = FontStyle.m4831boximpl(m4712getFontStyle4Lr2A7w != null ? m4712getFontStyle4Lr2A7w.m4837unboximpl() : FontStyle.Companion.m4839getNormal_LCdwA());
        FontSynthesis m4713getFontSynthesisZQGJjVo = spanStyle.m4713getFontSynthesisZQGJjVo();
        FontSynthesis m4840boximpl = FontSynthesis.m4840boximpl(m4713getFontSynthesisZQGJjVo != null ? m4713getFontSynthesisZQGJjVo.m4848unboximpl() : FontSynthesis.Companion.m4849getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long m4714getLetterSpacingXSAIIZE = TextUnitKt.m5415isUnspecifiedR2X_6o(spanStyle.m4714getLetterSpacingXSAIIZE()) ? DefaultLetterSpacing : spanStyle.m4714getLetterSpacingXSAIIZE();
        BaselineShift m4709getBaselineShift5SSeXJ0 = spanStyle.m4709getBaselineShift5SSeXJ0();
        BaselineShift m4988boximpl = BaselineShift.m4988boximpl(m4709getBaselineShift5SSeXJ0 != null ? m4709getBaselineShift5SSeXJ0.m4994unboximpl() : BaselineShift.Companion.m4998getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long m4708getBackground0d7_KjU = spanStyle.m4708getBackground0d7_KjU();
        if (!(m4708getBackground0d7_KjU != Color.Companion.m2823getUnspecified0d7_KjU())) {
            m4708getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j = m4708getBackground0d7_KjU;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, m4711getFontSizeXSAIIZE, fontWeight2, m4831boximpl, m4840boximpl, fontFamily2, str, m4714getLetterSpacingXSAIIZE, m4988boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
