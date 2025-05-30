package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m2136binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        float f = DefaultSelectionBackgroundAlpha;
        float f2 = DefaultSelectionBackgroundAlpha;
        float f3 = 0.2f;
        for (int i = 0; i < 7; i++) {
            float m2138calculateContrastRationb2GgbA = (m2138calculateContrastRationb2GgbA(j, f, j2, j3) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= m2138calculateContrastRationb2GgbA && m2138calculateContrastRationb2GgbA <= 0.01f) {
                break;
            }
            if (m2138calculateContrastRationb2GgbA < 0.0f) {
                f2 = f;
            } else {
                f3 = f;
            }
            f = (f2 + f3) / 2.0f;
        }
        return f;
    }

    /* renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m2137calculateContrastRatioOWjLjI(long j, long j2) {
        float m2839luminance8_81llA = ColorKt.m2839luminance8_81llA(j) + 0.05f;
        float m2839luminance8_81llA2 = ColorKt.m2839luminance8_81llA(j2) + 0.05f;
        return Math.max(m2839luminance8_81llA, m2839luminance8_81llA2) / Math.min(m2839luminance8_81llA, m2839luminance8_81llA2);
    }

    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m2138calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long m2832compositeOverOWjLjI = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m2137calculateContrastRatioOWjLjI(ColorKt.m2832compositeOverOWjLjI(j2, m2832compositeOverOWjLjI), m2832compositeOverOWjLjI);
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m2139calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        return Color.m2786copywmQWz5c$default(j, m2138calculateContrastRationb2GgbA(j, DefaultSelectionBackgroundAlpha, j2, j3) >= DesiredContrastRatio ? DefaultSelectionBackgroundAlpha : m2138calculateContrastRationb2GgbA(j, 0.2f, j2, j3) < DesiredContrastRatio ? 0.2f : m2136binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3), 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Composable
    @NotNull
    public static final TextSelectionColors rememberTextSelectionColors(@NotNull Colors colors, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long m2016getPrimary0d7_KjU = colors.m2016getPrimary0d7_KjU();
        long m2009getBackground0d7_KjU = colors.m2009getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long m2033contentColorFor4WTKRHQ = ColorsKt.m2033contentColorFor4WTKRHQ(colors, m2009getBackground0d7_KjU);
        if (!(m2033contentColorFor4WTKRHQ != Color.Companion.m2823getUnspecified0d7_KjU())) {
            m2033contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m2797unboximpl();
        }
        composer.endReplaceableGroup();
        long m2786copywmQWz5c$default = Color.m2786copywmQWz5c$default(m2033contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color m2777boximpl = Color.m2777boximpl(m2016getPrimary0d7_KjU);
        Color m2777boximpl2 = Color.m2777boximpl(m2009getBackground0d7_KjU);
        Color m2777boximpl3 = Color.m2777boximpl(m2786copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(m2777boximpl) | composer.changed(m2777boximpl2) | composer.changed(m2777boximpl3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextSelectionColors(colors.m2016getPrimary0d7_KjU(), m2139calculateSelectionBackgroundColorysEtTa8(m2016getPrimary0d7_KjU, m2786copywmQWz5c$default, m2009getBackground0d7_KjU), null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors = (TextSelectionColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors;
    }
}
