package androidx.compose.ui.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m2224getUnspecifiedXSAIIZE();

    @Stable
    @NotNull
    public static final ParagraphStyle lerp(@NotNull ParagraphStyle paragraphStyle, @NotNull ParagraphStyle paragraphStyle2, float f) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "start");
        Intrinsics.checkNotNullParameter(paragraphStyle2, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextAlign-buA522U(), paragraphStyle2.getTextAlign-buA522U(), f);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextDirection-mmuk1to(), paragraphStyle2.getTextDirection-mmuk1to(), f);
        long m1885lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m1885lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight-XSAIIZE(), paragraphStyle2.getLineHeight-XSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, m1885lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), (LineBreak) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineBreak(), paragraphStyle2.getLineBreak(), f), (Hyphens) SpanStyleKt.lerpDiscrete(paragraphStyle.getHyphens(), paragraphStyle2.getHyphens(), f), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    @NotNull
    public static final ParagraphStyle resolveParagraphStyleDefaults(@NotNull ParagraphStyle paragraphStyle, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, "direction");
        TextAlign textAlign = paragraphStyle.getTextAlign-buA522U();
        TextAlign textAlign2 = TextAlign.box-impl(textAlign != null ? textAlign.unbox-impl() : TextAlign.Companion.getStart-e0LSkKk());
        TextDirection m2067boximpl = TextDirection.m2067boximpl(TextStyleKt.m1896resolveTextDirectionYj3eThk(layoutDirection, paragraphStyle.getTextDirection-mmuk1to()));
        long j = TextUnitKt.m2231isUnspecifiedR2X_6o(paragraphStyle.getLineHeight-XSAIIZE()) ? DefaultLineHeight : paragraphStyle.getLineHeight-XSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        LineBreak lineBreak = paragraphStyle.getLineBreak();
        if (lineBreak == null) {
            lineBreak = LineBreak.Companion.getSimple();
        }
        LineBreak lineBreak2 = lineBreak;
        Hyphens hyphens = paragraphStyle.getHyphens();
        if (hyphens == null) {
            hyphens = Hyphens.Companion.getNone();
        }
        Hyphens hyphens2 = hyphens;
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(textAlign2, m2067boximpl, j, textIndent2, platformStyle, lineHeightStyle, lineBreak2, hyphens2, textMotion, (DefaultConstructorMarker) null);
    }
}
