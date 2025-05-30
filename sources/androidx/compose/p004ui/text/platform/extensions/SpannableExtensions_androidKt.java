package androidx.compose.p004ui.text.platform.extensions;

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
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.ShaderBrush;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.AnnotatedStringKt;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.android.style.BaselineShiftSpan;
import androidx.compose.p004ui.text.android.style.FontFeatureSpan;
import androidx.compose.p004ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.p004ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.p004ui.text.android.style.LineHeightSpan;
import androidx.compose.p004ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.p004ui.text.android.style.ShadowSpan;
import androidx.compose.p004ui.text.android.style.SkewXSpan;
import androidx.compose.p004ui.text.android.style.TextDecorationSpan;
import androidx.compose.p004ui.text.android.style.TypefaceSpan;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.platform.style.DrawStyleSpan;
import androidx.compose.p004ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.LineHeightStyle;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.text.style.TextIndent;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.p004ui.unit.TextUnitType;
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
/* loaded from: classes2.dex */
public final class SpannableExtensions_androidKt {
    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m4976createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo1282toPxR2X_6o(j));
        }
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m5397getValueimpl(j));
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
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m4770getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m4977resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
            return density.mo1282toPxR2X_6o(j);
        }
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA())) {
            return TextUnit.m5397getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m4978setBackgroundRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setBackground");
        if (j != Color.Companion.m2823getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m2841toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m4979setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m4994unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m4980setColorRPmYEkk(spannable, ((SolidColor) brush).m3074getValue0d7_KjU(), i, i2);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m4980setColorRPmYEkk(@NotNull Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setColor");
        if (j != Color.Companion.m2823getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m2841toArgb8_81llA(j)), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    private static final void setFontAttributes(final Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, final Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().m4713getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m4769getFontStyle4Lr2A7w(), textStyle.m4770getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null) : null, arrayList, new Function3<SpanStyle, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SpanStyle spanStyle, int i2, int i3) {
                Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
                Spannable spannable2 = spannable;
                Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function42 = function4;
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontWeight fontWeight = spanStyle.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle m4712getFontStyle4Lr2A7w = spanStyle.m4712getFontStyle4Lr2A7w();
                FontStyle m4831boximpl = FontStyle.m4831boximpl(m4712getFontStyle4Lr2A7w != null ? m4712getFontStyle4Lr2A7w.m4837unboximpl() : FontStyle.Companion.m4839getNormal_LCdwA());
                FontSynthesis m4713getFontSynthesisZQGJjVo = spanStyle.m4713getFontSynthesisZQGJjVo();
                spannable2.setSpan(new TypefaceSpan((Typeface) function42.invoke(fontFamily, fontWeight, m4831boximpl, FontSynthesis.m4840boximpl(m4713getFontSynthesisZQGJjVo != null ? m4713getFontSynthesisZQGJjVo.m4848unboximpl() : FontSynthesis.Companion.m4849getAllGVVA2EU()))), i2, i3, 33);
            }
        });
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m4981setFontSizeKmRG4DE(@NotNull Spannable spannable, long j, @NotNull Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.mo1282toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m5397getValueimpl(j)), i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m4982setLineHeightKmRG4DE(@NotNull Spannable spannable, long j, float f, @NotNull Density density, @NotNull LineHeightStyle lineHeightStyle) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(lineHeightStyle, "lineHeightStyle");
        float m4977resolveLineHeightInPxo2QH7mI = m4977resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m4977resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(m4977resolveLineHeightInPxo2QH7mI, 0, ((spannable.length() == 0) || StringsKt.last(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m5064isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m5043getTrimEVpEnUU()), LineHeightStyle.Trim.m5065isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m5043getTrimEVpEnUU()), lineHeightStyle.m5042getAlignmentPIaL0Z0()), 0, spannable.length());
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m4983setLineHeightr9BaKPg(@NotNull Spannable spannable, long j, float f, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        float m4977resolveLineHeightInPxo2QH7mI = m4977resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(m4977resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(m4977resolveLineHeightInPxo2QH7mI), 0, spannable.length());
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
            setSpan(spannable, new ShadowSpan(ColorKt.m2841toArgb8_81llA(shadow.m3072getColor0d7_KjU()), Offset.m2556getXimpl(shadow.m3073getOffsetF1C5BW0()), Offset.m2557getYimpl(shadow.m3073getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
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
        m4979setBaselineShift0ocSgnM(spannable, item.m4709getBaselineShift5SSeXJ0(), start, end);
        m4980setColorRPmYEkk(spannable, item.m4710getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m4981setFontSizeKmRG4DE(spannable, item.m4711getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m4978setBackgroundRPmYEkk(spannable, item.m4708getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
        MetricAffectingSpan m4976createLetterSpacingSpaneAf_CNQ = m4976createLetterSpacingSpaneAf_CNQ(item.m4714getLetterSpacingXSAIIZE(), density);
        if (m4976createLetterSpacingSpaneAf_CNQ != null) {
            arrayList.add(new SpanRange(m4976createLetterSpacingSpaneAf_CNQ, start, end));
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
            if ((TextUnit.m5394equalsimpl0(textIndent.m5103getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.m5394equalsimpl0(textIndent.m5104getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.m5415isUnspecifiedR2X_6o(textIndent.m5103getFirstLineXSAIIZE()) || TextUnitKt.m5415isUnspecifiedR2X_6o(textIndent.m5104getRestLineXSAIIZE())) {
                return;
            }
            long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(textIndent.m5103getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float f2 = 0.0f;
            float mo1282toPxR2X_6o = TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA()) ? density.mo1282toPxR2X_6o(textIndent.m5103getFirstLineXSAIIZE()) : TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA()) ? TextUnit.m5397getValueimpl(textIndent.m5103getFirstLineXSAIIZE()) * f : 0.0f;
            long m5396getTypeUIouoOA2 = TextUnit.m5396getTypeUIouoOA(textIndent.m5104getRestLineXSAIIZE());
            if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA2, companion.m5430getSpUIouoOA())) {
                f2 = density.mo1282toPxR2X_6o(textIndent.m5104getRestLineXSAIIZE());
            } else if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA2, companion.m5429getEmUIouoOA())) {
                f2 = TextUnit.m5397getValueimpl(textIndent.m5104getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(mo1282toPxR2X_6o), (int) Math.ceil(f2)), 0, spannable.length());
        }
    }
}
