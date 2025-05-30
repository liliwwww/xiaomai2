package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
        float m2142constructorimpl = Dp.m2142constructorimpl(16);
        ButtonHorizontalPadding = m2142constructorimpl;
        float f = 8;
        float m2142constructorimpl2 = Dp.m2142constructorimpl(f);
        ButtonVerticalPadding = m2142constructorimpl2;
        PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(m2142constructorimpl, m2142constructorimpl2, m2142constructorimpl, m2142constructorimpl2);
        ContentPadding = paddingValues;
        MinWidth = Dp.m2142constructorimpl(64);
        MinHeight = Dp.m2142constructorimpl(36);
        IconSize = Dp.m2142constructorimpl(18);
        IconSpacing = Dp.m2142constructorimpl(f);
        OutlinedBorderSize = Dp.m2142constructorimpl(1);
        float m2142constructorimpl3 = Dp.m2142constructorimpl(f);
        TextButtonHorizontalPadding = m2142constructorimpl3;
        TextButtonContentPadding = PaddingKt.PaddingValues-a9UjIt4(m2142constructorimpl3, paddingValues.mo219calculateTopPaddingD9Ej5fM(), m2142constructorimpl3, paddingValues.mo216calculateBottomPaddingD9Ej5fM());
    }

    private ButtonDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m525buttonColorsro_MJ88(long j, long j2, long j3, long j4, @Nullable Composer composer, int i, int i2) {
        long j5;
        composer.startReplaceableGroup(1870371134);
        long j6 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary-0d7_KjU() : j;
        long m561contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m561contentColorForek8zF_U(j6, composer, i & 14) : j2;
        if ((i2 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j5 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(materialTheme.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j5 = j3;
        }
        long m1049copywmQWz5c$default = (i2 & 8) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1870371134, i, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:402)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j6, m561contentColorForek8zF_U, j5, m1049copywmQWz5c$default, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m526elevationR_JCAzs(float f, float f2, float f3, float f4, float f5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-737170518);
        float m2142constructorimpl = (i2 & 1) != 0 ? Dp.m2142constructorimpl(2) : f;
        float m2142constructorimpl2 = (i2 & 2) != 0 ? Dp.m2142constructorimpl(8) : f2;
        float m2142constructorimpl3 = (i2 & 4) != 0 ? Dp.m2142constructorimpl(0) : f3;
        float m2142constructorimpl4 = (i2 & 8) != 0 ? Dp.m2142constructorimpl(4) : f4;
        float m2142constructorimpl5 = (i2 & 16) != 0 ? Dp.m2142constructorimpl(4) : f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-737170518, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:368)");
        }
        Object[] objArr = {Dp.m2140boximpl(m2142constructorimpl), Dp.m2140boximpl(m2142constructorimpl2), Dp.m2140boximpl(m2142constructorimpl3), Dp.m2140boximpl(m2142constructorimpl4), Dp.m2140boximpl(m2142constructorimpl5)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultButtonElevation(m2142constructorimpl, m2142constructorimpl2, m2142constructorimpl3, m2142constructorimpl4, m2142constructorimpl5, null);
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
    public final /* synthetic */ ButtonElevation m527elevationyajeYGU(float f, float f2, float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1428576874);
        float m2142constructorimpl = (i2 & 1) != 0 ? Dp.m2142constructorimpl(2) : f;
        float m2142constructorimpl2 = (i2 & 2) != 0 ? Dp.m2142constructorimpl(8) : f2;
        float m2142constructorimpl3 = (i2 & 4) != 0 ? Dp.m2142constructorimpl(0) : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428576874, i, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:342)");
        }
        float f4 = 4;
        ButtonElevation m526elevationR_JCAzs = m526elevationR_JCAzs(m2142constructorimpl, m2142constructorimpl2, m2142constructorimpl3, Dp.m2142constructorimpl(f4), Dp.m2142constructorimpl(f4), composer, (i & 14) | 27648 | (i & 112) | (i & 896) | ((i << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m526elevationR_JCAzs;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m528getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m529getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m530getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m531getMinWidthD9Ej5fM() {
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
        BorderStroke m124BorderStrokecXLIe8U = BorderStrokeKt.m124BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m124BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m532getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    @NotNull
    /* renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m533outlinedButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2124406093);
        long j4 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU() : j;
        long j5 = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary-0d7_KjU() : j2;
        long m1049copywmQWz5c$default = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124406093, i, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:425)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j4, j5, j4, m1049copywmQWz5c$default, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m534textButtonColorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(182742216);
        long j4 = (i2 & 1) != 0 ? Color.Companion.getTransparent-0d7_KjU() : j;
        long j5 = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary-0d7_KjU() : j2;
        long m1049copywmQWz5c$default = (i2 & 4) != 0 ? Color.m1049copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(182742216, i, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:446)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(j4, j5, j4, m1049copywmQWz5c$default, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
