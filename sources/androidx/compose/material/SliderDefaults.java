package androidx.compose.material;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
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
    public final SliderColors m2212colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, @Nullable Composer composer, int i, int i2, int i3) {
        long j11;
        composer.startReplaceableGroup(436017687);
        long m2016getPrimary0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2016getPrimary0d7_KjU() : j;
        if ((i3 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            j11 = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(materialTheme.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m2020getSurface0d7_KjU());
        } else {
            j11 = j2;
        }
        long m2016getPrimary0d7_KjU2 = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2016getPrimary0d7_KjU() : j3;
        long m2786copywmQWz5c$default = (i3 & 8) != 0 ? Color.m2786copywmQWz5c$default(m2016getPrimary0d7_KjU2, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long m2786copywmQWz5c$default2 = (i3 & 16) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m2786copywmQWz5c$default3 = (i3 & 32) != 0 ? Color.m2786copywmQWz5c$default(m2786copywmQWz5c$default2, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m2786copywmQWz5c$default4 = (i3 & 64) != 0 ? Color.m2786copywmQWz5c$default(ColorsKt.m2034contentColorForek8zF_U(m2016getPrimary0d7_KjU2, composer, (i >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long m2786copywmQWz5c$default5 = (i3 & 128) != 0 ? Color.m2786copywmQWz5c$default(m2016getPrimary0d7_KjU2, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long m2786copywmQWz5c$default6 = (i3 & 256) != 0 ? Color.m2786copywmQWz5c$default(m2786copywmQWz5c$default4, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long m2786copywmQWz5c$default7 = (i3 & 512) != 0 ? Color.m2786copywmQWz5c$default(m2786copywmQWz5c$default3, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, i, i2, "androidx.compose.material.SliderDefaults.colors (Slider.kt:478)");
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(m2016getPrimary0d7_KjU, j11, m2016getPrimary0d7_KjU2, m2786copywmQWz5c$default, m2786copywmQWz5c$default2, m2786copywmQWz5c$default3, m2786copywmQWz5c$default4, m2786copywmQWz5c$default5, m2786copywmQWz5c$default6, m2786copywmQWz5c$default7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
