package androidx.compose.p004ui.text;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.text.style.Hyphens;
import androidx.compose.p004ui.text.style.LineBreak;
import androidx.compose.p004ui.text.style.LineHeightStyle;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDirection;
import androidx.compose.p004ui.text.style.TextIndent;
import androidx.compose.p004ui.text.style.TextIndentKt;
import androidx.compose.p004ui.text.style.TextMotion;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();

    @Stable
    @NotNull
    public static final ParagraphStyle lerp(@NotNull ParagraphStyle paragraphStyle, @NotNull ParagraphStyle paragraphStyle2, float f) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "start");
        Intrinsics.checkNotNullParameter(paragraphStyle2, AliRequestAdapter.PHASE_STOP);
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(paragraphStyle.m4653getTextAlignbuA522U(), paragraphStyle2.m4653getTextAlignbuA522U(), f);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(paragraphStyle.m4654getTextDirectionmmuk1to(), paragraphStyle2.m4654getTextDirectionmmuk1to(), f);
        long m4715lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m4715lerpTextUnitInheritableC3pnCVY(paragraphStyle.m4652getLineHeightXSAIIZE(), paragraphStyle2.m4652getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, m4715lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), (LineBreak) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineBreak(), paragraphStyle2.getLineBreak(), f), (Hyphens) SpanStyleKt.lerpDiscrete(paragraphStyle.getHyphens(), paragraphStyle2.getHyphens(), f), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), null);
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
        TextAlign m4653getTextAlignbuA522U = paragraphStyle.m4653getTextAlignbuA522U();
        TextAlign m5072boximpl = TextAlign.m5072boximpl(m4653getTextAlignbuA522U != null ? m4653getTextAlignbuA522U.m5078unboximpl() : TextAlign.Companion.m5084getStarte0LSkKk());
        TextDirection m5085boximpl = TextDirection.m5085boximpl(TextStyleKt.m4775resolveTextDirectionYj3eThk(layoutDirection, paragraphStyle.m4654getTextDirectionmmuk1to()));
        long m4652getLineHeightXSAIIZE = TextUnitKt.m5415isUnspecifiedR2X_6o(paragraphStyle.m4652getLineHeightXSAIIZE()) ? DefaultLineHeight : paragraphStyle.m4652getLineHeightXSAIIZE();
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
        return new ParagraphStyle(m5072boximpl, m5085boximpl, m4652getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, lineBreak2, hyphens2, textMotion, null);
    }
}
