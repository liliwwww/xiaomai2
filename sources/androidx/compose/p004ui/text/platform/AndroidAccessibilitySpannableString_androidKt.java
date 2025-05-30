package androidx.compose.p004ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.RestrictTo;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.InternalTextApi;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TtsAnnotation;
import androidx.compose.p004ui.text.UrlAnnotation;
import androidx.compose.p004ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.p004ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.font.GenericFontFamily;
import androidx.compose.p004ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p004ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.p004ui.text.platform.extensions.UrlAnnotationExtensions_androidKt;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.po1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m4980setColorRPmYEkk(spannableString, spanStyle.m4710getColor0d7_KjU(), i, i2);
        SpannableExtensions_androidKt.m4981setFontSizeKmRG4DE(spannableString, spanStyle.m4711getFontSizeXSAIIZE(), density, i, i2);
        if (spanStyle.getFontWeight() != null || spanStyle.m4712getFontStyle4Lr2A7w() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m4712getFontStyle4Lr2A7w = spanStyle.m4712getFontStyle4Lr2A7w();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m4789getAndroidTypefaceStyleFO1MlWM(fontWeight, m4712getFontStyle4Lr2A7w != null ? m4712getFontStyle4Lr2A7w.m4837unboximpl() : FontStyle.Companion.m4839getNormal_LCdwA())), i, i2, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i, i2, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis m4713getFontSynthesisZQGJjVo = spanStyle.m4713getFontSynthesisZQGJjVo();
                Object value = po1.a(resolver, fontFamily, (FontWeight) null, 0, m4713getFontSynthesisZQGJjVo != null ? m4713getFontSynthesisZQGJjVo.m4848unboximpl() : FontSynthesis.Companion.m4849getAllGVVA2EU(), 6, (Object) null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i, i2, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.Companion;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i, i2, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i, i2);
        SpannableExtensions_androidKt.m4978setBackgroundRPmYEkk(spannableString, spanStyle.m4708getBackground0d7_KjU(), i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    @NotNull
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString(annotatedString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    @NotNull
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        SpanStyle m4706copyIuqyXdg;
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        int size = spanStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i);
            SpanStyle component1 = range.component1();
            int component2 = range.component2();
            int component3 = range.component3();
            m4706copyIuqyXdg = component1.m4706copyIuqyXdg((r35 & 1) != 0 ? component1.m4710getColor0d7_KjU() : 0L, (r35 & 2) != 0 ? component1.fontSize : 0L, (r35 & 4) != 0 ? component1.fontWeight : null, (r35 & 8) != 0 ? component1.fontStyle : null, (r35 & 16) != 0 ? component1.fontSynthesis : null, (r35 & 32) != 0 ? component1.fontFamily : null, (r35 & 64) != 0 ? component1.fontFeatureSettings : null, (r35 & 128) != 0 ? component1.letterSpacing : 0L, (r35 & 256) != 0 ? component1.baselineShift : null, (r35 & 512) != 0 ? component1.textGeometricTransform : null, (r35 & 1024) != 0 ? component1.localeList : null, (r35 & 2048) != 0 ? component1.background : 0L, (r35 & 4096) != 0 ? component1.textDecoration : null, (r35 & 8192) != 0 ? component1.shadow : null);
            setSpanStyle(spannableString, m4706copyIuqyXdg, component2, component3, density, resolver);
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range<TtsAnnotation> range2 = ttsAnnotations.get(i2);
            TtsAnnotation component12 = range2.component1();
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(component12), range2.component2(), range2.component3(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i3 = 0; i3 < size3; i3++) {
            AnnotatedString.Range<UrlAnnotation> range3 = urlAnnotations.get(i3);
            UrlAnnotation component13 = range3.component1();
            spannableString.setSpan(UrlAnnotationExtensions_androidKt.toSpan(component13), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }
}
