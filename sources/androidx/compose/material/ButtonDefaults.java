package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;

    @NotNull
    private static final PaddingValues ContentPadding;

    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;

    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float m5216constructorimpl = C0856Dp.m5216constructorimpl(16);
        ButtonHorizontalPadding = m5216constructorimpl;
        float f = 8;
        float m5216constructorimpl2 = C0856Dp.m5216constructorimpl(f);
        ButtonVerticalPadding = m5216constructorimpl2;
        PaddingValues m1390PaddingValuesa9UjIt4 = PaddingKt.m1390PaddingValuesa9UjIt4(m5216constructorimpl, m5216constructorimpl2, m5216constructorimpl, m5216constructorimpl2);
        ContentPadding = m1390PaddingValuesa9UjIt4;
        MinWidth = C0856Dp.m5216constructorimpl(64);
        MinHeight = C0856Dp.m5216constructorimpl(36);
        IconSize = C0856Dp.m5216constructorimpl(18);
        IconSpacing = C0856Dp.m5216constructorimpl(f);
        OutlinedBorderSize = C0856Dp.m5216constructorimpl(1);
        float m5216constructorimpl3 = C0856Dp.m5216constructorimpl(f);
        TextButtonHorizontalPadding = m5216constructorimpl3;
        TextButtonContentPadding = PaddingKt.m1390PaddingValuesa9UjIt4(m5216constructorimpl3, m1390PaddingValuesa9UjIt4.mo1377calculateTopPaddingD9Ej5fM(), m5216constructorimpl3, m1390PaddingValuesa9UjIt4.mo1374calculateBottomPaddingD9Ej5fM());
    }

    private ButtonDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1965buttonColorsro_MJ88(long j, long j2, long j3, long j4, @Nullable Composer composer, int i, int i2) {
        long j5;
        composer.startReplaceableGroup(1870371134);
        long m2016getPrimary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2016getPrimary0d7_KjU() : j;
        long m2034contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m2034contentColorForek8zF_U(m2016getPrimary0d7_KjU, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j5 = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(materialTheme.getColors(composer, 6).m2015getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m2020getSurface0d7_KjU());
        } else {
            j5 = j3;
        }
        long m2786copywmQWz5c$default = (i2 & 8) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:402)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m2016getPrimary0d7_KjU, m2034contentColorForek8zF_U, j5, m2786copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1966elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        float m5216constructorimpl = (i2 & 1) != 0 ? C0856Dp.m5216constructorimpl(2) : f;
        float m5216constructorimpl2 = (i2 & 2) != 0 ? C0856Dp.m5216constructorimpl(8) : f2;
        float m5216constructorimpl3 = (i2 & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f3;
        float m5216constructorimpl4 = (i2 & 8) != 0 ? C0856Dp.m5216constructorimpl(4) : f4;
        float m5216constructorimpl5 = (i2 & 16) != 0 ? C0856Dp.m5216constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:368)");
        }
        Object[] objArr = {C0856Dp.m5214boximpl(m5216constructorimpl), C0856Dp.m5214boximpl(m5216constructorimpl2), C0856Dp.m5214boximpl(m5216constructorimpl3), C0856Dp.m5214boximpl(m5216constructorimpl4), C0856Dp.m5214boximpl(m5216constructorimpl5)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultButtonElevation(m5216constructorimpl, m5216constructorimpl2, m5216constructorimpl3, m5216constructorimpl4, m5216constructorimpl5, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultButtonElevation defaultButtonElevation = (DefaultButtonElevation) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonElevation;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1967elevationyajeYGU(float f, float f2, float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1428576874);
        float m5216constructorimpl = (i2 & 1) != 0 ? C0856Dp.m5216constructorimpl(2) : f;
        float m5216constructorimpl2 = (i2 & 2) != 0 ? C0856Dp.m5216constructorimpl(8) : f2;
        float m5216constructorimpl3 = (i2 & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:342)");
        }
        float f4 = 4;
        ButtonElevation m1966elevationR_JCAzs = m1966elevationR_JCAzs(m5216constructorimpl, m5216constructorimpl2, m5216constructorimpl3, C0856Dp.m5216constructorimpl(f4), C0856Dp.m5216constructorimpl(f4), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1966elevationR_JCAzs;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1968getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1969getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1970getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1971getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @JvmName(name = "getOutlinedBorder")
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-2091313033);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2091313033, i, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:473)");
        }
        BorderStroke m1135BorderStrokecXLIe8U = BorderStrokeKt.m1135BorderStrokecXLIe8U(OutlinedBorderSize, Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1135BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1972getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    @NotNull
    /* renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1973outlinedButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2124406093);
        long m2020getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU() : j;
        long m2016getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2016getPrimary0d7_KjU() : j2;
        long m2786copywmQWz5c$default = (i2 & 4) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:425)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m2020getSurface0d7_KjU, m2016getPrimary0d7_KjU, m2020getSurface0d7_KjU, m2786copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1974textButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long m2822getTransparent0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m2822getTransparent0d7_KjU() : j;
        long m2016getPrimary0d7_KjU = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2016getPrimary0d7_KjU() : j2;
        long m2786copywmQWz5c$default = (i2 & 4) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:446)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(m2822getTransparent0d7_KjU, m2016getPrimary0d7_KjU, m2822getTransparent0d7_KjU, m2786copywmQWz5c$default, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
