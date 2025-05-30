package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Typography {

    @NotNull
    private final TextStyle body1;

    @NotNull
    private final TextStyle body2;

    @NotNull
    private final TextStyle button;

    @NotNull
    private final TextStyle caption;

    @NotNull
    private final TextStyle h1;

    @NotNull
    private final TextStyle h2;

    @NotNull
    private final TextStyle h3;

    @NotNull
    private final TextStyle h4;

    @NotNull
    private final TextStyle h5;

    @NotNull
    private final TextStyle h6;

    @NotNull
    private final TextStyle overline;

    @NotNull
    private final TextStyle subtitle1;

    @NotNull
    private final TextStyle subtitle2;

    public Typography(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13) {
        Intrinsics.checkNotNullParameter(textStyle, "h1");
        Intrinsics.checkNotNullParameter(textStyle2, "h2");
        Intrinsics.checkNotNullParameter(textStyle3, "h3");
        Intrinsics.checkNotNullParameter(textStyle4, "h4");
        Intrinsics.checkNotNullParameter(textStyle5, "h5");
        Intrinsics.checkNotNullParameter(textStyle6, "h6");
        Intrinsics.checkNotNullParameter(textStyle7, "subtitle1");
        Intrinsics.checkNotNullParameter(textStyle8, "subtitle2");
        Intrinsics.checkNotNullParameter(textStyle9, "body1");
        Intrinsics.checkNotNullParameter(textStyle10, "body2");
        Intrinsics.checkNotNullParameter(textStyle11, "button");
        Intrinsics.checkNotNullParameter(textStyle12, "caption");
        Intrinsics.checkNotNullParameter(textStyle13, "overline");
        this.h1 = textStyle;
        this.h2 = textStyle2;
        this.h3 = textStyle3;
        this.h4 = textStyle4;
        this.h5 = textStyle5;
        this.h6 = textStyle6;
        this.subtitle1 = textStyle7;
        this.subtitle2 = textStyle8;
        this.body1 = textStyle9;
        this.body2 = textStyle10;
        this.button = textStyle11;
        this.caption = textStyle12;
        this.overline = textStyle13;
    }

    @NotNull
    public final Typography copy(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13) {
        Intrinsics.checkNotNullParameter(textStyle, "h1");
        Intrinsics.checkNotNullParameter(textStyle2, "h2");
        Intrinsics.checkNotNullParameter(textStyle3, "h3");
        Intrinsics.checkNotNullParameter(textStyle4, "h4");
        Intrinsics.checkNotNullParameter(textStyle5, "h5");
        Intrinsics.checkNotNullParameter(textStyle6, "h6");
        Intrinsics.checkNotNullParameter(textStyle7, "subtitle1");
        Intrinsics.checkNotNullParameter(textStyle8, "subtitle2");
        Intrinsics.checkNotNullParameter(textStyle9, "body1");
        Intrinsics.checkNotNullParameter(textStyle10, "body2");
        Intrinsics.checkNotNullParameter(textStyle11, "button");
        Intrinsics.checkNotNullParameter(textStyle12, "caption");
        Intrinsics.checkNotNullParameter(textStyle13, "overline");
        return new Typography(textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return Intrinsics.areEqual(this.h1, typography.h1) && Intrinsics.areEqual(this.h2, typography.h2) && Intrinsics.areEqual(this.h3, typography.h3) && Intrinsics.areEqual(this.h4, typography.h4) && Intrinsics.areEqual(this.h5, typography.h5) && Intrinsics.areEqual(this.h6, typography.h6) && Intrinsics.areEqual(this.subtitle1, typography.subtitle1) && Intrinsics.areEqual(this.subtitle2, typography.subtitle2) && Intrinsics.areEqual(this.body1, typography.body1) && Intrinsics.areEqual(this.body2, typography.body2) && Intrinsics.areEqual(this.button, typography.button) && Intrinsics.areEqual(this.caption, typography.caption) && Intrinsics.areEqual(this.overline, typography.overline);
    }

    @NotNull
    public final TextStyle getBody1() {
        return this.body1;
    }

    @NotNull
    public final TextStyle getBody2() {
        return this.body2;
    }

    @NotNull
    public final TextStyle getButton() {
        return this.button;
    }

    @NotNull
    public final TextStyle getCaption() {
        return this.caption;
    }

    @NotNull
    public final TextStyle getH1() {
        return this.h1;
    }

    @NotNull
    public final TextStyle getH2() {
        return this.h2;
    }

    @NotNull
    public final TextStyle getH3() {
        return this.h3;
    }

    @NotNull
    public final TextStyle getH4() {
        return this.h4;
    }

    @NotNull
    public final TextStyle getH5() {
        return this.h5;
    }

    @NotNull
    public final TextStyle getH6() {
        return this.h6;
    }

    @NotNull
    public final TextStyle getOverline() {
        return this.overline;
    }

    @NotNull
    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    @NotNull
    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    @NotNull
    public String toString() {
        return "Typography(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FontFamily.Companion.getDefault() : fontFamily, (i & 2) != 0 ? new TextStyle(0L, TextUnitKt.getSp(96), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle, (i & 4) != 0 ? new TextStyle(0L, TextUnitKt.getSp(60), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle2, (i & 8) != 0 ? new TextStyle(0L, TextUnitKt.getSp(48), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle3, (i & 16) != 0 ? new TextStyle(0L, TextUnitKt.getSp(34), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle4, (i & 32) != 0 ? new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle5, (i & 64) != 0 ? new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle6, (i & 128) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle7, (i & 256) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle8, (i & 512) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle9, (i & 1024) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle10, (i & 2048) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle11, (i & 4096) != 0 ? new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle12, (i & 8192) != 0 ? new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Typography(@NotNull FontFamily fontFamily, @NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13) {
        this(TypographyKt.access$withDefaultFontFamily(textStyle, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle2, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle3, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle4, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle5, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle6, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle7, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle8, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle9, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle10, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle11, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle12, fontFamily), TypographyKt.access$withDefaultFontFamily(textStyle13, fontFamily));
        Intrinsics.checkNotNullParameter(fontFamily, "defaultFontFamily");
        Intrinsics.checkNotNullParameter(textStyle, "h1");
        Intrinsics.checkNotNullParameter(textStyle2, "h2");
        Intrinsics.checkNotNullParameter(textStyle3, "h3");
        Intrinsics.checkNotNullParameter(textStyle4, "h4");
        Intrinsics.checkNotNullParameter(textStyle5, "h5");
        Intrinsics.checkNotNullParameter(textStyle6, "h6");
        Intrinsics.checkNotNullParameter(textStyle7, "subtitle1");
        Intrinsics.checkNotNullParameter(textStyle8, "subtitle2");
        Intrinsics.checkNotNullParameter(textStyle9, "body1");
        Intrinsics.checkNotNullParameter(textStyle10, "body2");
        Intrinsics.checkNotNullParameter(textStyle11, "button");
        Intrinsics.checkNotNullParameter(textStyle12, "caption");
        Intrinsics.checkNotNullParameter(textStyle13, "overline");
    }
}
