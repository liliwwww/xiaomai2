package androidx.compose.material;

import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextDirection;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.text.style.TextIndent;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public final class Typography {

    @NotNull
    private final TextStyle body1;

    @NotNull
    private final TextStyle body2;

    @NotNull
    private final TextStyle button;

    @NotNull
    private final TextStyle caption;

    /* renamed from: h1 */
    @NotNull
    private final TextStyle f97h1;

    /* renamed from: h2 */
    @NotNull
    private final TextStyle f98h2;

    /* renamed from: h3 */
    @NotNull
    private final TextStyle f99h3;

    /* renamed from: h4 */
    @NotNull
    private final TextStyle f100h4;

    /* renamed from: h5 */
    @NotNull
    private final TextStyle f101h5;

    /* renamed from: h6 */
    @NotNull
    private final TextStyle f102h6;

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
        this.f97h1 = textStyle;
        this.f98h2 = textStyle2;
        this.f99h3 = textStyle3;
        this.f100h4 = textStyle4;
        this.f101h5 = textStyle5;
        this.f102h6 = textStyle6;
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
        return Intrinsics.areEqual(this.f97h1, typography.f97h1) && Intrinsics.areEqual(this.f98h2, typography.f98h2) && Intrinsics.areEqual(this.f99h3, typography.f99h3) && Intrinsics.areEqual(this.f100h4, typography.f100h4) && Intrinsics.areEqual(this.f101h5, typography.f101h5) && Intrinsics.areEqual(this.f102h6, typography.f102h6) && Intrinsics.areEqual(this.subtitle1, typography.subtitle1) && Intrinsics.areEqual(this.subtitle2, typography.subtitle2) && Intrinsics.areEqual(this.body1, typography.body1) && Intrinsics.areEqual(this.body2, typography.body2) && Intrinsics.areEqual(this.button, typography.button) && Intrinsics.areEqual(this.caption, typography.caption) && Intrinsics.areEqual(this.overline, typography.overline);
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
        return this.f97h1;
    }

    @NotNull
    public final TextStyle getH2() {
        return this.f98h2;
    }

    @NotNull
    public final TextStyle getH3() {
        return this.f99h3;
    }

    @NotNull
    public final TextStyle getH4() {
        return this.f100h4;
    }

    @NotNull
    public final TextStyle getH5() {
        return this.f101h5;
    }

    @NotNull
    public final TextStyle getH6() {
        return this.f102h6;
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
        return (((((((((((((((((((((((this.f97h1.hashCode() * 31) + this.f98h2.hashCode()) * 31) + this.f99h3.hashCode()) * 31) + this.f100h4.hashCode()) * 31) + this.f101h5.hashCode()) * 31) + this.f102h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    @NotNull
    public String toString() {
        return "Typography(h1=" + this.f97h1 + ", h2=" + this.f98h2 + ", h3=" + this.f99h3 + ", h4=" + this.f100h4 + ", h5=" + this.f101h5 + ", h6=" + this.f102h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FontFamily.Companion.getDefault() : fontFamily, (i & 2) != 0 ? new TextStyle(0L, TextUnitKt.getSp(96), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle, (i & 4) != 0 ? new TextStyle(0L, TextUnitKt.getSp(60), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle2, (i & 8) != 0 ? new TextStyle(0L, TextUnitKt.getSp(48), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle3, (i & 16) != 0 ? new TextStyle(0L, TextUnitKt.getSp(34), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle4, (i & 32) != 0 ? new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle5, (i & 64) != 0 ? new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle6, (i & 128) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle7, (i & 256) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle8, (i & 512) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle9, (i & 1024) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle10, (i & 2048) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle11, (i & 4096) != 0 ? new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle12, (i & 8192) != 0 ? new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (DefaultConstructorMarker) null) : textStyle13);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Typography(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.font.FontFamily r2, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r3, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r4, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r5, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r6, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r7, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r8, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r9, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r10, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r11, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r12, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r13, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r14, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.TextStyle r15) {
        /*
            r1 = this;
            java.lang.String r0 = "defaultFontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "h1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "h2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "h3"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "h4"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "h5"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "h6"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "subtitle1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "subtitle2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "body1"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "body2"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "button"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "caption"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "overline"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r3, r2)
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r4, r2)
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r5, r2)
            androidx.compose.ui.text.TextStyle r6 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r6, r2)
            androidx.compose.ui.text.TextStyle r7 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r7, r2)
            androidx.compose.ui.text.TextStyle r8 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r8, r2)
            androidx.compose.ui.text.TextStyle r9 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r9, r2)
            androidx.compose.ui.text.TextStyle r10 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r10, r2)
            androidx.compose.ui.text.TextStyle r11 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r11, r2)
            androidx.compose.ui.text.TextStyle r12 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r12, r2)
            androidx.compose.ui.text.TextStyle r13 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r13, r2)
            androidx.compose.ui.text.TextStyle r14 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r14, r2)
            androidx.compose.ui.text.TextStyle r15 = androidx.compose.material.TypographyKt.access$withDefaultFontFamily(r15, r2)
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle):void");
    }
}
