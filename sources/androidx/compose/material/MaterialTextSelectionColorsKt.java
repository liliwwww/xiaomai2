package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m607binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        float f = DefaultSelectionBackgroundAlpha;
        float f2 = DefaultSelectionBackgroundAlpha;
        float f3 = 0.2f;
        for (int i = 0; i < 7; i++) {
            float m609calculateContrastRationb2GgbA = (m609calculateContrastRationb2GgbA(j, f, j2, j3) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= m609calculateContrastRationb2GgbA && m609calculateContrastRationb2GgbA <= 0.01f) {
                break;
            }
            if (m609calculateContrastRationb2GgbA < 0.0f) {
                f2 = f;
            } else {
                f3 = f;
            }
            f = (f2 + f3) / 2.0f;
        }
        return f;
    }

    /* renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m608calculateContrastRatioOWjLjI(long j, long j2) {
        float m1072luminance8_81llA = ColorKt.m1072luminance8_81llA(j) + 0.05f;
        float m1072luminance8_81llA2 = ColorKt.m1072luminance8_81llA(j2) + 0.05f;
        return Math.max(m1072luminance8_81llA, m1072luminance8_81llA2) / Math.min(m1072luminance8_81llA, m1072luminance8_81llA2);
    }

    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m609calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long m1065compositeOverOWjLjI = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m608calculateContrastRatioOWjLjI(ColorKt.m1065compositeOverOWjLjI(j2, m1065compositeOverOWjLjI), m1065compositeOverOWjLjI);
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m610calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        return Color.m1049copywmQWz5c$default(j, m609calculateContrastRationb2GgbA(j, DefaultSelectionBackgroundAlpha, j2, j3) >= DesiredContrastRatio ? DefaultSelectionBackgroundAlpha : m609calculateContrastRationb2GgbA(j, 0.2f, j2, j3) < DesiredContrastRatio ? 0.2f : m607binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3), 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Composable
    @NotNull
    public static final TextSelectionColors rememberTextSelectionColors(@NotNull Colors colors, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        composer.startReplaceableGroup(-721696685);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long j = colors.getPrimary-0d7_KjU();
        long j2 = colors.getBackground-0d7_KjU();
        composer.startReplaceableGroup(35572910);
        long m560contentColorFor4WTKRHQ = ColorsKt.m560contentColorFor4WTKRHQ(colors, j2);
        if (!(m560contentColorFor4WTKRHQ != Color.Companion.getUnspecified-0d7_KjU())) {
            m560contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1060unboximpl();
        }
        composer.endReplaceableGroup();
        long m1049copywmQWz5c$default = Color.m1049copywmQWz5c$default(m560contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color m1040boximpl = Color.m1040boximpl(j);
        Color m1040boximpl2 = Color.m1040boximpl(j2);
        Color m1040boximpl3 = Color.m1040boximpl(m1049copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(m1040boximpl) | composer.changed(m1040boximpl2) | composer.changed(m1040boximpl3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextSelectionColors(colors.getPrimary-0d7_KjU(), m610calculateSelectionBackgroundColorysEtTa8(j, m1049copywmQWz5c$default, j2), null);
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
