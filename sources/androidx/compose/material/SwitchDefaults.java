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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m680colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, @Nullable Composer composer, int i, int i2, int i3) {
        float f3;
        long j9;
        long j10;
        long j11;
        long j12;
        int i4;
        long j13;
        composer.startReplaceableGroup(-1032127534);
        long j14 = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondaryVariant-0d7_KjU() : j;
        long j15 = (i3 & 2) != 0 ? j14 : j2;
        float f4 = (i3 & 4) != 0 ? 0.54f : f;
        long j16 = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU() : j3;
        long j17 = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface-0d7_KjU() : j4;
        float f5 = (i3 & 32) != 0 ? 0.38f : f2;
        if ((i3 & 64) != 0) {
            f3 = f4;
            j9 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            f3 = f4;
            j9 = j5;
        }
        if ((i3 & 128) != 0) {
            j10 = j14;
            j11 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j10 = j14;
            j11 = j6;
        }
        if ((i3 & 256) != 0) {
            i4 = 6;
            j12 = j9;
            j13 = ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(j16, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU());
        } else {
            j12 = j9;
            i4 = 6;
            j13 = j7;
        }
        long m1065compositeOverOWjLjI = (i3 & 512) != 0 ? ColorKt.m1065compositeOverOWjLjI(Color.m1049copywmQWz5c$default(j17, ContentAlpha.INSTANCE.getDisabled(composer, i4), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface-0d7_KjU()) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1032127534, i, i2, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:278)");
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j10, Color.m1049copywmQWz5c$default(j15, f3, 0.0f, 0.0f, 0.0f, 14, null), j16, Color.m1049copywmQWz5c$default(j17, f5, 0.0f, 0.0f, 0.0f, 14, null), j12, Color.m1049copywmQWz5c$default(j11, f3, 0.0f, 0.0f, 0.0f, 14, null), j13, Color.m1049copywmQWz5c$default(m1065compositeOverOWjLjI, f5, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
