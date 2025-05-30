package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.getTransparent-0d7_KjU();
        DefaultColor = companion.getBlack-0d7_KjU();
    }

    @NotNull
    public static final SpanStyle lerp(@NotNull SpanStyle spanStyle, @NotNull SpanStyle spanStyle2, float f) {
        Intrinsics.checkNotNullParameter(spanStyle, "start");
        Intrinsics.checkNotNullParameter(spanStyle2, "stop");
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long m1885lerpTextUnitInheritableC3pnCVY = m1885lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize-XSAIIZE(), spanStyle2.getFontSize-XSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle-4Lr2A7w(), spanStyle2.getFontStyle-4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis-ZQGJjVo(), spanStyle2.getFontSynthesis-ZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long m1885lerpTextUnitInheritableC3pnCVY2 = m1885lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing-XSAIIZE(), spanStyle2.getLetterSpacing-XSAIIZE(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift-5SSeXJ0();
        float m2006unboximpl = baselineShift != null ? baselineShift.m2006unboximpl() : BaselineShift.m2001constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift-5SSeXJ0();
        float m2007lerpjWV1Mfo = BaselineShiftKt.m2007lerpjWV1Mfo(m2006unboximpl, baselineShift2 != null ? baselineShift2.m2006unboximpl() : BaselineShift.m2001constructorimpl(0.0f), f);
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
        long m1071lerpjxsXWHM = ColorKt.m1071lerpjxsXWHM(spanStyle.getBackground-0d7_KjU(), spanStyle2.getBackground-0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(lerp, m1885lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m1885lerpTextUnitInheritableC3pnCVY2, BaselineShift.m2000boximpl(m2007lerpjWV1Mfo), lerp3, localeList, m1071lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
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
    public static final long m1885lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        return (TextUnitKt.m2231isUnspecifiedR2X_6o(j) || TextUnitKt.m2231isUnspecifiedR2X_6o(j2)) ? ((TextUnit) lerpDiscrete(TextUnit.m2203boximpl(j), TextUnit.m2203boximpl(j2), f)).m2222unboximpl() : TextUnitKt.m2233lerpC3pnCVY(j, j2, f);
    }

    @NotNull
    public static final SpanStyle resolveSpanStyleDefaults(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "style");
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(resolveSpanStyleDefaults.1.INSTANCE);
        long j = TextUnitKt.m2231isUnspecifiedR2X_6o(spanStyle.getFontSize-XSAIIZE()) ? DefaultFontSize : spanStyle.getFontSize-XSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle-4Lr2A7w();
        FontStyle m1924boximpl = FontStyle.m1924boximpl(fontStyle != null ? fontStyle.m1930unboximpl() : FontStyle.Companion.getNormal-_-LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis-ZQGJjVo();
        FontSynthesis fontSynthesis2 = FontSynthesis.box-impl(fontSynthesis != null ? fontSynthesis.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU());
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
        long j2 = TextUnitKt.m2231isUnspecifiedR2X_6o(spanStyle.getLetterSpacing-XSAIIZE()) ? DefaultLetterSpacing : spanStyle.getLetterSpacing-XSAIIZE();
        BaselineShift baselineShift = spanStyle.getBaselineShift-5SSeXJ0();
        BaselineShift m2000boximpl = BaselineShift.m2000boximpl(baselineShift != null ? baselineShift.m2006unboximpl() : BaselineShift.Companion.getNone-y9eOQZs());
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
        long j3 = spanStyle.getBackground-0d7_KjU();
        if (!(j3 != Color.Companion.getUnspecified-0d7_KjU())) {
            j3 = DefaultBackgroundColor;
        }
        long j4 = j3;
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
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, j, fontWeight2, m1924boximpl, fontSynthesis2, fontFamily2, str, j2, m2000boximpl, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
