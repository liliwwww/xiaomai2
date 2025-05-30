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
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SpanStyle {
    private final long background;

    @Nullable
    private final BaselineShift baselineShift;

    @Nullable
    private final DrawStyle drawStyle;

    @Nullable
    private final FontFamily fontFamily;

    @Nullable
    private final String fontFeatureSettings;
    private final long fontSize;

    @Nullable
    private final FontStyle fontStyle;

    @Nullable
    private final FontSynthesis fontSynthesis;

    @Nullable
    private final FontWeight fontWeight;
    private final long letterSpacing;

    @Nullable
    private final LocaleList localeList;

    @Nullable
    private final PlatformSpanStyle platformStyle;

    @Nullable
    private final Shadow shadow;

    @Nullable
    private final TextDecoration textDecoration;

    @NotNull
    private final TextForegroundStyle textForegroundStyle;

    @Nullable
    private final TextGeometricTransform textGeometricTransform;

    @ExperimentalTextApi
    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle);
    }

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow);
    }

    @ExperimentalTextApi
    public /* synthetic */ SpanStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this.textForegroundStyle = textForegroundStyle;
        this.fontSize = j;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j2;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j3;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
        this.drawStyle = drawStyle;
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle);
    }

    /* renamed from: copy-NcG25M8$default, reason: not valid java name */
    public static /* synthetic */ SpanStyle m2292copyNcG25M8$default(SpanStyle spanStyle, Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, Object obj) {
        Shadow shadow2;
        PlatformSpanStyle platformSpanStyle2;
        float alpha = (i & 2) != 0 ? spanStyle.getAlpha() : f;
        long j4 = (i & 4) != 0 ? spanStyle.fontSize : j;
        FontWeight fontWeight2 = (i & 8) != 0 ? spanStyle.fontWeight : fontWeight;
        FontStyle fontStyle2 = (i & 16) != 0 ? spanStyle.fontStyle : fontStyle;
        FontSynthesis fontSynthesis2 = (i & 32) != 0 ? spanStyle.fontSynthesis : fontSynthesis;
        FontFamily fontFamily2 = (i & 64) != 0 ? spanStyle.fontFamily : fontFamily;
        String str2 = (i & 128) != 0 ? spanStyle.fontFeatureSettings : str;
        long j5 = (i & 256) != 0 ? spanStyle.letterSpacing : j2;
        BaselineShift baselineShift2 = (i & 512) != 0 ? spanStyle.baselineShift : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? spanStyle.textGeometricTransform : textGeometricTransform;
        LocaleList localeList2 = (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? spanStyle.localeList : localeList;
        long j6 = (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? spanStyle.background : j3;
        TextDecoration textDecoration2 = (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? spanStyle.textDecoration : textDecoration;
        Shadow shadow3 = (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? spanStyle.shadow : shadow;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0) {
            shadow2 = shadow3;
            platformSpanStyle2 = spanStyle.platformStyle;
        } else {
            shadow2 = shadow3;
            platformSpanStyle2 = platformSpanStyle;
        }
        return spanStyle.m2296copyNcG25M8(brush, alpha, j4, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j5, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, platformSpanStyle2, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? spanStyle.drawStyle : drawStyle);
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

    private final boolean hasSameNonLayoutAttributes(SpanStyle spanStyle) {
        return Intrinsics.areEqual(this.textForegroundStyle, spanStyle.textForegroundStyle) && Intrinsics.areEqual(this.textDecoration, spanStyle.textDecoration) && Intrinsics.areEqual(this.shadow, spanStyle.shadow) && Intrinsics.areEqual(this.drawStyle, spanStyle.drawStyle);
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle spanStyle, SpanStyle spanStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            spanStyle2 = null;
        }
        return spanStyle.merge(spanStyle2);
    }

    private final PlatformSpanStyle mergePlatformStyle(PlatformSpanStyle platformSpanStyle) {
        PlatformSpanStyle platformSpanStyle2 = this.platformStyle;
        return platformSpanStyle2 == null ? platformSpanStyle : platformSpanStyle == null ? platformSpanStyle2 : platformSpanStyle2.merge(platformSpanStyle);
    }

    @NotNull
    /* renamed from: copy-2BkPm_w, reason: not valid java name */
    public final SpanStyle m2293copy2BkPm_w(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle) {
        return new SpanStyle(Color.equals-impl0(j, m2299getColor0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, (DrawStyle) null, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED, (DefaultConstructorMarker) null);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-GSF8kmg, reason: not valid java name */
    public final SpanStyle m2294copyGSF8kmg(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle, @Nullable DrawStyle drawStyle) {
        return new SpanStyle(Color.equals-impl0(j, m2299getColor0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: copy-IuqyXdg, reason: not valid java name */
    public final SpanStyle m2295copyIuqyXdg(long j, long j2, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j3, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j4, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow) {
        return new SpanStyle(Color.equals-impl0(j, m2299getColor0d7_KjU()) ? this.textForegroundStyle : TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, this.platformStyle, this.drawStyle, (DefaultConstructorMarker) null);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-NcG25M8, reason: not valid java name */
    public final SpanStyle m2296copyNcG25M8(@Nullable Brush brush, float f, long j, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j2, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j3, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle, @Nullable DrawStyle drawStyle) {
        return new SpanStyle(TextForegroundStyle.Companion.from(brush, f), j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) && hasSameNonLayoutAttributes(spanStyle);
    }

    @ExperimentalTextApi
    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2297getBackground0d7_KjU() {
        return this.background;
    }

    @Nullable
    /* renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m2298getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2299getColor0d7_KjU() {
        return this.textForegroundStyle.mo2487getColor0d7_KjU();
    }

    @ExperimentalTextApi
    @Nullable
    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m2300getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    @Nullable
    /* renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m2301getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    @Nullable
    /* renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m2302getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m2303getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    @Nullable
    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.shadow;
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    @NotNull
    public final TextForegroundStyle getTextForegroundStyle$ui_text_release() {
        return this.textForegroundStyle;
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        if (this == spanStyle) {
            return true;
        }
        return TextUnit.equals-impl0(this.fontSize, spanStyle.fontSize) && Intrinsics.areEqual(this.fontWeight, spanStyle.fontWeight) && Intrinsics.areEqual(this.fontStyle, spanStyle.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, spanStyle.fontSynthesis) && Intrinsics.areEqual(this.fontFamily, spanStyle.fontFamily) && Intrinsics.areEqual(this.fontFeatureSettings, spanStyle.fontFeatureSettings) && TextUnit.equals-impl0(this.letterSpacing, spanStyle.letterSpacing) && Intrinsics.areEqual(this.baselineShift, spanStyle.baselineShift) && Intrinsics.areEqual(this.textGeometricTransform, spanStyle.textGeometricTransform) && Intrinsics.areEqual(this.localeList, spanStyle.localeList) && Color.equals-impl0(this.background, spanStyle.background) && Intrinsics.areEqual(this.platformStyle, spanStyle.platformStyle);
    }

    public int hashCode() {
        int i = Color.hashCode-impl(m2299getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int hashCode = (((((i + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(getAlpha())) * 31) + TextUnit.hashCode-impl(this.fontSize)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int hashCode2 = (hashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int i2 = (hashCode2 + (fontStyle != null ? FontStyle.hashCode-impl(fontStyle.unbox-impl()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int m2389hashCodeimpl = (i2 + (fontSynthesis != null ? FontSynthesis.m2389hashCodeimpl(fontSynthesis.m2393unboximpl()) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int hashCode3 = (m2389hashCodeimpl + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.hashCode-impl(this.letterSpacing)) * 31;
        BaselineShift baselineShift = this.baselineShift;
        int i3 = (hashCode4 + (baselineShift != null ? BaselineShift.hashCode-impl(baselineShift.unbox-impl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int hashCode5 = (i3 + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int hashCode6 = (((hashCode5 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.hashCode-impl(this.background)) * 31;
        TextDecoration textDecoration = this.textDecoration;
        int hashCode7 = (hashCode6 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        Shadow shadow = this.shadow;
        int hashCode8 = (hashCode7 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        int hashCode9 = (hashCode8 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0)) * 31;
        DrawStyle drawStyle = this.drawStyle;
        return hashCode9 + (drawStyle != null ? drawStyle.hashCode() : 0);
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int i = TextUnit.hashCode-impl(this.fontSize) * 31;
        FontWeight fontWeight = this.fontWeight;
        int hashCode = (i + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int i2 = (hashCode + (fontStyle != null ? FontStyle.hashCode-impl(fontStyle.unbox-impl()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int m2389hashCodeimpl = (i2 + (fontSynthesis != null ? FontSynthesis.m2389hashCodeimpl(fontSynthesis.m2393unboximpl()) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int hashCode2 = (m2389hashCodeimpl + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int hashCode3 = (((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.hashCode-impl(this.letterSpacing)) * 31;
        BaselineShift baselineShift = this.baselineShift;
        int i3 = (hashCode3 + (baselineShift != null ? BaselineShift.hashCode-impl(baselineShift.unbox-impl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int hashCode4 = (i3 + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int hashCode5 = (((hashCode4 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.hashCode-impl(this.background)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        return hashCode5 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final SpanStyle merge(@Nullable SpanStyle spanStyle) {
        if (spanStyle == null) {
            return this;
        }
        TextForegroundStyle merge = this.textForegroundStyle.merge(spanStyle.textForegroundStyle);
        FontFamily fontFamily = spanStyle.fontFamily;
        if (fontFamily == null) {
            fontFamily = this.fontFamily;
        }
        FontFamily fontFamily2 = fontFamily;
        long j = !TextUnitKt.isUnspecified--R2X_6o(spanStyle.fontSize) ? spanStyle.fontSize : this.fontSize;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = this.fontWeight;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.fontStyle;
        if (fontStyle == null) {
            fontStyle = this.fontStyle;
        }
        FontStyle fontStyle2 = fontStyle;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        if (fontSynthesis == null) {
            fontSynthesis = this.fontSynthesis;
        }
        FontSynthesis fontSynthesis2 = fontSynthesis;
        String str = spanStyle.fontFeatureSettings;
        if (str == null) {
            str = this.fontFeatureSettings;
        }
        String str2 = str;
        long j2 = !TextUnitKt.isUnspecified--R2X_6o(spanStyle.letterSpacing) ? spanStyle.letterSpacing : this.letterSpacing;
        BaselineShift baselineShift = spanStyle.baselineShift;
        if (baselineShift == null) {
            baselineShift = this.baselineShift;
        }
        BaselineShift baselineShift2 = baselineShift;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        if (textGeometricTransform == null) {
            textGeometricTransform = this.textGeometricTransform;
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.localeList;
        if (localeList == null) {
            localeList = this.localeList;
        }
        LocaleList localeList2 = localeList;
        long j3 = spanStyle.background;
        if (!(j3 != Color.Companion.m1084getUnspecified0d7_KjU())) {
            j3 = this.background;
        }
        long j4 = j3;
        TextDecoration textDecoration = spanStyle.textDecoration;
        if (textDecoration == null) {
            textDecoration = this.textDecoration;
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.shadow;
        if (shadow == null) {
            shadow = this.shadow;
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle mergePlatformStyle = mergePlatformStyle(spanStyle.platformStyle);
        DrawStyle drawStyle = spanStyle.drawStyle;
        if (drawStyle == null) {
            drawStyle = this.drawStyle;
        }
        return new SpanStyle(merge, j, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j2, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, mergePlatformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    @Stable
    @NotNull
    public final SpanStyle plus(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return merge(spanStyle);
    }

    @NotNull
    public String toString() {
        return "SpanStyle(color=" + ((Object) Color.toString-impl(m2299getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.toString-impl(this.fontSize)) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + ((Object) TextUnit.toString-impl(this.letterSpacing)) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + ((Object) Color.toString-impl(this.background)) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ", drawStyle=" + this.drawStyle + ')';
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j3, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : platformSpanStyle, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow) {
        this(TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : platformSpanStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle) {
        this(TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, (DrawStyle) null, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j, (i & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 4) != 0 ? null : fontWeight, (i & 8) != 0 ? null : fontStyle, (i & 16) != 0 ? null : fontSynthesis, (i & 32) != 0 ? null : fontFamily, (i & 64) != 0 ? null : str, (i & 128) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, (i & 256) != 0 ? null : baselineShift, (i & 512) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j4, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : shadow, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : platformSpanStyle, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(long j, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.Companion.from-8_81llA(j), j2, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j3, baselineShift, textGeometricTransform, localeList, j4, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SpanStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, (i & 2) != 0 ? Float.NaN : f, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j, (i & 8) != 0 ? null : fontWeight, (i & 16) != 0 ? null : fontStyle, (i & 32) != 0 ? null : fontSynthesis, (i & 64) != 0 ? null : fontFamily, (i & 128) != 0 ? null : str, (i & 256) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2, (i & 512) != 0 ? null : baselineShift, (i & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? null : textGeometricTransform, (i & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? null : localeList, (i & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? Color.Companion.m1084getUnspecified0d7_KjU() : j3, (i & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? null : textDecoration, (i & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? null : shadow, (32768 & i) != 0 ? null : platformSpanStyle, (i & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? null : drawStyle, (DefaultConstructorMarker) null);
    }

    private SpanStyle(Brush brush, float f, long j, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j2, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j3, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        this(TextForegroundStyle.Companion.from(brush, f), j, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j2, baselineShift, textGeometricTransform, localeList, j3, textDecoration, shadow, platformSpanStyle, drawStyle, (DefaultConstructorMarker) null);
    }
}
