package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;

    @NotNull
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m800colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, @Nullable Composer composer, int i, int i2, int i3) {
        long j11;
        composer.startReplaceableGroup(436017687);
        long m695getPrimary0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m695getPrimary0d7_KjU() : j;
        if ((i3 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j11 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(materialTheme.getColors(composer, 6).m694getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), materialTheme.getColors(composer, 6).m699getSurface0d7_KjU());
        } else {
            j11 = j2;
        }
        long m695getPrimary0d7_KjU2 = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m695getPrimary0d7_KjU() : j3;
        long j12 = (i3 & 8) != 0 ? Color.copy-wmQWz5c$default(m695getPrimary0d7_KjU2, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        long j13 = (i3 & 16) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m694getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5;
        long j14 = (i3 & 32) != 0 ? Color.copy-wmQWz5c$default(j13, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long j15 = (i3 & 64) != 0 ? Color.copy-wmQWz5c$default(ColorsKt.contentColorFor-ek8zF_U(m695getPrimary0d7_KjU2, composer, (i >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long j16 = (i3 & 128) != 0 ? Color.copy-wmQWz5c$default(m695getPrimary0d7_KjU2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long j17 = (i3 & 256) != 0 ? Color.copy-wmQWz5c$default(j15, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j9;
        long j18 = (i3 & 512) != 0 ? Color.copy-wmQWz5c$default(j14, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, i, i2, "androidx.compose.material.SliderDefaults.colors (Slider.kt:478)");
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(m695getPrimary0d7_KjU, j11, m695getPrimary0d7_KjU2, j12, j13, j14, j15, j16, j17, j18, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
