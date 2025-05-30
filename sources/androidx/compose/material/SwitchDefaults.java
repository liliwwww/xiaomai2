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
/* loaded from: classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m2273colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, @Nullable Composer composer, int i, int i2, int i3) {
        float f3;
        long j9;
        long j10;
        long j11;
        long j12;
        int i4;
        long j13;
        composer.startReplaceableGroup(-1032127534);
        long m2019getSecondaryVariant0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2019getSecondaryVariant0d7_KjU() : j;
        long j14 = (i3 & 2) != 0 ? m2019getSecondaryVariant0d7_KjU : j2;
        float f4 = (i3 & 4) != 0 ? 0.54f : f;
        long m2020getSurface0d7_KjU = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU() : j3;
        long m2015getOnSurface0d7_KjU = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU() : j4;
        float f5 = (i3 & 32) != 0 ? 0.38f : f2;
        if ((i3 & 64) != 0) {
            f3 = f4;
            j9 = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(m2019getSecondaryVariant0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU());
        } else {
            f3 = f4;
            j9 = j5;
        }
        if ((i3 & 128) != 0) {
            j10 = m2019getSecondaryVariant0d7_KjU;
            j11 = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU());
        } else {
            j10 = m2019getSecondaryVariant0d7_KjU;
            j11 = j6;
        }
        if ((i3 & 256) != 0) {
            i4 = 6;
            j12 = j9;
            j13 = ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(m2020getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU());
        } else {
            j12 = j9;
            i4 = 6;
            j13 = j7;
        }
        long m2832compositeOverOWjLjI = (i3 & 512) != 0 ? ColorKt.m2832compositeOverOWjLjI(Color.m2786copywmQWz5c$default(m2015getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, i4), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU()) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1032127534, i, i2, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:278)");
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j10, Color.m2786copywmQWz5c$default(j14, f3, 0.0f, 0.0f, 0.0f, 14, null), m2020getSurface0d7_KjU, Color.m2786copywmQWz5c$default(m2015getOnSurface0d7_KjU, f5, 0.0f, 0.0f, 0.0f, 14, null), j12, Color.m2786copywmQWz5c$default(j11, f3, 0.0f, 0.0f, 0.0f, 14, null), j13, Color.m2786copywmQWz5c$default(m2832compositeOverOWjLjI, f5, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
