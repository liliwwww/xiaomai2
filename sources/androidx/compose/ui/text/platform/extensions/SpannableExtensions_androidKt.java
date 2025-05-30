package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SpannableExtensions_androidKt {
    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m2471createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long j2 = TextUnit.getType-UIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2699getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.toPx--R2X_6o(j));
        }
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2698getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.getValue-impl(j));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(@Nullable SpanStyle spanStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(function3, "block");
        if (list.size() <= 1) {
            if (!list.isEmpty()) {
                function3.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
                return;
            }
            return;
        }
        int size = list.size();
        int i = size * 2;
        Integer[] numArr = new Integer[i];
        for (int i2 = 0; i2 < i; i2++) {
            numArr[i2] = 0;
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i3);
            numArr[i3] = Integer.valueOf(range.getStart());
            numArr[i3 + size] = Integer.valueOf(range.getEnd());
        }
        ArraysKt.sort(numArr);
        int intValue = ((Number) ArraysKt.first(numArr)).intValue();
        for (int i4 = 0; i4 < i; i4++) {
            int intValue2 = numArr[i4].intValue();
            if (intValue2 != intValue) {
                int size3 = list.size();
                SpanStyle spanStyle2 = spanStyle;
                for (int i5 = 0; i5 < size3; i5++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i5);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                        spanStyle2 = merge(spanStyle2, range2.getItem());
                    }
                }
                if (spanStyle2 != null) {
                    function3.invoke(spanStyle2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                }
                intValue = intValue2;
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m2348getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m2472resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long j2 = TextUnit.getType-UIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2699getSpUIouoOA())) {
            return density.toPx--R2X_6o(j);
        }
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2698getEmUIouoOA())) {
            return TextUnit.getValue-impl(j) * f;
        }
        return Float.NaN;
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m2473setBackgroundRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setBackground");
        if (j != Color.Companion.m1084getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.toArgb-8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m2474setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.unbox-impl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m2475setColorRPmYEkk(spannable, ((SolidColor) brush).getValue-0d7_KjU(), i, i2);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m2475setColorRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setColor");
        if (j != Color.Companion.m1084getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.toArgb-8_81llA(j)), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().m2302getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m2347getFontStyle4Lr2A7w(), textStyle.m2348getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null) : null, arrayList, new setFontAttributes.1(spannable, function4));
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m2476setFontSizeKmRG4DE(@NotNull Spannable spannable, long j, @NotNull Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long j2 = TextUnit.getType-UIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2699getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.toPx--R2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m2694equalsimpl0(j2, companion.m2698getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.getValue-impl(j)), i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m2477setLineHeightKmRG4DE(@NotNull Spannable spannable, long j, float f, @NotNull Density density, @NotNull LineHeightStyle lineHeightStyle) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float m2472resolveLineHeightInPxo2QH7mI = m2472resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m2472resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(m2472resolveLineHeightInPxo2QH7mI, 0, ((spannable.length() == 0) || StringsKt.last(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.isTrimFirstLineTop-impl$ui_text_release(lineHeightStyle.m2498getTrimEVpEnUU()), LineHeightStyle.Trim.isTrimLastLineBottom-impl$ui_text_release(lineHeightStyle.m2498getTrimEVpEnUU()), lineHeightStyle.m2497getAlignmentPIaL0Z0()), 0, spannable.length());
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m2478setLineHeightr9BaKPg(@NotNull Spannable spannable, long j, float f, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        float m2472resolveLineHeightInPxo2QH7mI = m2472resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m2472resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(m2472resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    public static final void setLocaleList(@NotNull Spannable spannable, @Nullable LocaleList localeList, int i, int i2) {
        Object localeSpan;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                localeSpan = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                localeSpan = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, localeSpan, i, i2);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.toArgb-8_81llA(shadow.getColor-0d7_KjU()), Offset.getX-impl(shadow.getOffset-F1C5BW0()), Offset.getY-impl(shadow.getOffset-F1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    public static final void setSpan(@NotNull Spannable spannable, @NotNull Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 33);
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m2474setBaselineShift0ocSgnM(spannable, item.m2298getBaselineShift5SSeXJ0(), start, end);
        m2475setColorRPmYEkk(spannable, item.m2299getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m2476setFontSizeKmRG4DE(spannable, item.m2300getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m2473setBackgroundRPmYEkk(spannable, item.m2297getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
        MetricAffectingSpan m2471createLetterSpacingSpaneAf_CNQ = m2471createLetterSpacingSpaneAf_CNQ(item.m2303getLetterSpacingXSAIIZE(), density);
        if (m2471createLetterSpacingSpaneAf_CNQ != null) {
            arrayList.add(new SpanRange(m2471createLetterSpacingSpaneAf_CNQ, start, end));
        }
    }

    public static final void setSpanStyles(@NotNull Spannable spannable, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull Density density, @NotNull Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(function4, "resolveTypeface");
        setFontAttributes(spannable, textStyle, list, function4);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density, arrayList);
            }
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SpanRange spanRange = (SpanRange) arrayList.get(i2);
            setSpan(spannable, spanRange.component1(), spanRange.component2(), spanRange.component3());
        }
    }

    public static final void setTextDecoration(@NotNull Spannable spannable, @Nullable TextDecoration textDecoration, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i, i2);
        }
    }

    public static final void setTextIndent(@NotNull Spannable spannable, @Nullable TextIndent textIndent, float f, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        if (textIndent != null) {
            if ((TextUnit.equals-impl0(textIndent.m2519getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.equals-impl0(textIndent.m2520getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.isUnspecified--R2X_6o(textIndent.m2519getFirstLineXSAIIZE()) || TextUnitKt.isUnspecified--R2X_6o(textIndent.m2520getRestLineXSAIIZE())) {
                return;
            }
            long j = TextUnit.getType-UIouoOA(textIndent.m2519getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float f2 = 0.0f;
            float f3 = TextUnitType.m2694equalsimpl0(j, companion.m2699getSpUIouoOA()) ? density.toPx--R2X_6o(textIndent.m2519getFirstLineXSAIIZE()) : TextUnitType.m2694equalsimpl0(j, companion.m2698getEmUIouoOA()) ? TextUnit.getValue-impl(textIndent.m2519getFirstLineXSAIIZE()) * f : 0.0f;
            long j2 = TextUnit.getType-UIouoOA(textIndent.m2520getRestLineXSAIIZE());
            if (TextUnitType.m2694equalsimpl0(j2, companion.m2699getSpUIouoOA())) {
                f2 = density.toPx--R2X_6o(textIndent.m2520getRestLineXSAIIZE());
            } else if (TextUnitType.m2694equalsimpl0(j2, companion.m2698getEmUIouoOA())) {
                f2 = TextUnit.getValue-impl(textIndent.m2520getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(f3), (int) Math.ceil(f2)), 0, spannable.length());
        }
    }
}
