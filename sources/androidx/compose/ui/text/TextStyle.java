package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262143, (DefaultConstructorMarker) null);

    @NotNull
    private final ParagraphStyle paragraphStyle;

    @Nullable
    private final PlatformTextStyle platformStyle;

    @NotNull
    private final SpanStyle spanStyle;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        @NotNull
        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, drawStyle, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent, platformTextStyle, lineHeightStyle);
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, textAlign, textDirection, j5, textIndent);
    }

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, drawStyle, textAlign, textDirection, j4, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens, textMotion);
    }

    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle, @Nullable PlatformTextStyle platformTextStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    /* renamed from: copy-JO6F4mo$default, reason: not valid java name */
    public static /* synthetic */ TextStyle m2337copyJO6F4mo$default(TextStyle textStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, Object obj) {
        Shadow shadow2;
        DrawStyle drawStyle2;
        DrawStyle drawStyle3;
        TextAlign textAlign2;
        TextAlign textAlign3;
        TextDirection textDirection2;
        TextDirection textDirection3;
        long j5;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        LineBreak lineBreak3;
        Hyphens hyphens2;
        float alpha = (i & 2) != 0 ? textStyle.spanStyle.getAlpha() : f;
        long m2300getFontSizeXSAIIZE = (i & 4) != 0 ? textStyle.spanStyle.m2300getFontSizeXSAIIZE() : j;
        FontWeight fontWeight2 = (i & 8) != 0 ? textStyle.spanStyle.getFontWeight() : fontWeight;
        FontStyle m2301getFontStyle4Lr2A7w = (i & 16) != 0 ? textStyle.spanStyle.m2301getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis m2302getFontSynthesisZQGJjVo = (i & 32) != 0 ? textStyle.spanStyle.m2302getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i & 64) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i & 128) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : str;
        long m2303getLetterSpacingXSAIIZE = (i & 256) != 0 ? textStyle.spanStyle.m2303getLetterSpacingXSAIIZE() : j2;
        BaselineShift m2298getBaselineShift5SSeXJ0 = (i & 512) != 0 ? textStyle.spanStyle.m2298getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? textStyle.spanStyle.getLocaleList() : localeList;
        long m2297getBackground0d7_KjU = (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? textStyle.spanStyle.m2297getBackground0d7_KjU() : j3;
        TextDecoration textDecoration2 = (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? textStyle.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? textStyle.spanStyle.getShadow() : shadow;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0) {
            shadow2 = shadow3;
            drawStyle2 = textStyle.spanStyle.getDrawStyle();
        } else {
            shadow2 = shadow3;
            drawStyle2 = drawStyle;
        }
        if ((i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0) {
            drawStyle3 = drawStyle2;
            textAlign2 = textStyle.paragraphStyle.m2274getTextAlignbuA522U();
        } else {
            drawStyle3 = drawStyle2;
            textAlign2 = textAlign;
        }
        if ((i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0) {
            textAlign3 = textAlign2;
            textDirection2 = textStyle.paragraphStyle.m2275getTextDirectionmmuk1to();
        } else {
            textAlign3 = textAlign2;
            textDirection2 = textDirection;
        }
        if ((i & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0) {
            textDirection3 = textDirection2;
            j5 = textStyle.paragraphStyle.m2273getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j5 = j4;
        }
        TextIndent textIndent3 = (524288 & i) != 0 ? textStyle.paragraphStyle.getTextIndent() : textIndent;
        if ((i & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i & AccessibilityEventCompat.TYPE_WINDOWS_CHANGED) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = textStyle.paragraphStyle.getLineBreak();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        if ((i & AccessibilityEventCompat.TYPE_VIEW_CONTEXT_CLICKED) != 0) {
            lineBreak3 = lineBreak2;
            hyphens2 = textStyle.paragraphStyle.getHyphens();
        } else {
            lineBreak3 = lineBreak2;
            hyphens2 = hyphens;
        }
        return textStyle.m2341copyJO6F4mo(brush, alpha, m2300getFontSizeXSAIIZE, fontWeight2, m2301getFontStyle4Lr2A7w, m2302getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, m2303getLetterSpacingXSAIIZE, m2298getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, m2297getBackground0d7_KjU, textDecoration2, shadow2, drawStyle3, textAlign3, textDirection3, j5, textIndent2, platformTextStyle3, lineHeightStyle3, lineBreak3, hyphens2, (i & 16777216) != 0 ? textStyle.paragraphStyle.getTextMotion() : textMotion);
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getAlpha$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getBrush$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getDrawStyle$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getHyphens$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getLineBreak$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getTextMotion$annotations() {
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    @NotNull
    /* renamed from: copy-HL5avdY, reason: not valid java name */
    public final TextStyle m2339copyHL5avdY(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j5, @Nullable TextIndent textIndent) {
        return new TextStyle(new SpanStyle(Color.equals-impl0(j, this.spanStyle.m2299getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle$ui_text_release() : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, this.spanStyle.getPlatformStyle(), this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), getLineBreak(), getHyphens(), getTextMotion(), null), this.platformStyle);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-In4QEEM, reason: not valid java name */
    public final TextStyle m2340copyIn4QEEM(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable DrawStyle drawStyle, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j5, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle, @Nullable LineBreak lineBreak, @Nullable Hyphens hyphens, @Nullable TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.equals-impl0(j, this.spanStyle.m2299getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle$ui_text_release() : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, null), platformTextStyle);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-JO6F4mo, reason: not valid java name */
    public final TextStyle m2341copyJO6F4mo(@Nullable Brush brush, float f, long j, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j2, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j3, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable DrawStyle drawStyle, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j4, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle, @Nullable LineBreak lineBreak, @Nullable Hyphens hyphens, @Nullable TextMotion textMotion) {
        return new TextStyle(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, null), platformTextStyle);
    }

    @NotNull
    /* renamed from: copy-NOaFTUo, reason: not valid java name */
    public final TextStyle m2342copyNOaFTUo(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j5, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle) {
        return new TextStyle(new SpanStyle(Color.equals-impl0(j, this.spanStyle.m2299getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle$ui_text_release() : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, this.spanStyle.getDrawStyle(), (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, getLineBreak(), getHyphens(), getTextMotion(), null), platformTextStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    @ExperimentalTextApi
    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2343getBackground0d7_KjU() {
        return this.spanStyle.m2297getBackground0d7_KjU();
    }

    @Nullable
    /* renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m2344getBaselineShift5SSeXJ0() {
        return this.spanStyle.m2298getBaselineShift5SSeXJ0();
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2345getColor0d7_KjU() {
        return this.spanStyle.m2299getColor0d7_KjU();
    }

    @ExperimentalTextApi
    @Nullable
    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m2346getFontSizeXSAIIZE() {
        return this.spanStyle.m2300getFontSizeXSAIIZE();
    }

    @Nullable
    /* renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m2347getFontStyle4Lr2A7w() {
        return this.spanStyle.m2301getFontStyle4Lr2A7w();
    }

    @Nullable
    /* renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m2348getFontSynthesisZQGJjVo() {
        return this.spanStyle.m2302getFontSynthesisZQGJjVo();
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    @ExperimentalTextApi
    @Nullable
    public final Hyphens getHyphens() {
        return this.paragraphStyle.getHyphens();
    }

    /* renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m2349getLetterSpacingXSAIIZE() {
        return this.spanStyle.m2303getLetterSpacingXSAIIZE();
    }

    @ExperimentalTextApi
    @Nullable
    public final LineBreak getLineBreak() {
        return this.paragraphStyle.getLineBreak();
    }

    /* renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m2350getLineHeightXSAIIZE() {
        return this.paragraphStyle.m2273getLineHeightXSAIIZE();
    }

    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    @NotNull
    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    @Nullable
    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    @NotNull
    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    @Nullable
    /* renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m2351getTextAlignbuA522U() {
        return this.paragraphStyle.m2274getTextAlignbuA522U();
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    @Nullable
    /* renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m2352getTextDirectionmmuk1to() {
        return this.paragraphStyle.m2275getTextDirectionmmuk1to();
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    @ExperimentalTextApi
    @Nullable
    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameLayoutAffectingAttributes(@NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "other");
        return this == textStyle || (Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(textStyle.spanStyle));
    }

    public int hashCode() {
        int hashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int hashCodeLayoutAffectingAttributes$ui_text_release = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text_release() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCodeLayoutAffectingAttributes$ui_text_release + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final TextStyle merge(@Nullable TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual(textStyle, Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "other");
        return merge(textStyle);
    }

    @Stable
    @NotNull
    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    @Stable
    @NotNull
    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    @NotNull
    public String toString() {
        return "TextStyle(color=" + ((Object) Color.toString-impl(m2345getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.toString-impl(m2346getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m2347getFontStyle4Lr2A7w() + ", fontSynthesis=" + m2348getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.toString-impl(m2349getLetterSpacingXSAIIZE())) + ", baselineShift=" + m2344getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.toString-impl(m2343getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + m2351getTextAlignbuA522U() + ", textDirection=" + m2352getTextDirectionmmuk1to() + ", lineHeight=" + ((Object) TextUnit.toString-impl(m2350getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + getLineBreak() + ", hyphens=" + getHyphens() + ", textMotion=" + getTextMotion() + ')';
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    @Stable
    @NotNull
    public final TextStyle plus(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return merge(spanStyle);
    }

    public /* synthetic */ TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle, paragraphStyle, (i & 4) != 0 ? null : platformTextStyle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextStyle(@NotNull SpanStyle spanStyle, @NotNull ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.access$createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return new TextStyle(toSpanStyle().merge(spanStyle), toParagraphStyle());
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : textAlign, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? null : textDirection, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j5, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? null : textIndent, null);
    }

    @Stable
    @NotNull
    public final TextStyle merge(@NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle));
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, null, null, null, null, null, null), null);
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : textAlign, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? null : textDirection, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j5, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? null : textIndent, (i & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0 ? null : platformTextStyle, (i & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) != 0 ? null : lineHeightStyle, null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, (DrawStyle) null, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, null, null, null, null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : drawStyle, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? null : textAlign, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? null : textDirection, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j5, (i & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0 ? null : textIndent, (i & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END) != 0 ? null : platformTextStyle, (i & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? null : lineHeightStyle, (i & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END) != 0 ? null : lineBreak, (i & AccessibilityEventCompat.TYPE_WINDOWS_CHANGED) != 0 ? null : hyphens, (i & AccessibilityEventCompat.TYPE_VIEW_CONTEXT_CLICKED) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j5, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j5, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, null), platformTextStyle);
    }

    public /* synthetic */ TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : fontSynthesis, (i & 64) != 0 ? null : fontFamily, (i & 128) != 0 ? null : str, (i & 256) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 512) != 0 ? null : baselineShift, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j3, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : shadow, (32768 & i) != 0 ? null : drawStyle, (65536 & i) != 0 ? null : textAlign, (131072 & i) != 0 ? null : textDirection, (262144 & i) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j4, (524288 & i) != 0 ? null : textIndent, (1048576 & i) != 0 ? null : platformTextStyle, (2097152 & i) != 0 ? null : lineHeightStyle, (4194304 & i) != 0 ? null : lineBreak, (8388608 & i) != 0 ? null : hyphens, (i & 16777216) != 0 ? null : textMotion, (DefaultConstructorMarker) null);
    }

    private TextStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, TextAlign textAlign, TextDirection textDirection, long j4, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        this(new SpanStyle(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, j4, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphStyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, null), platformTextStyle);
    }
}
