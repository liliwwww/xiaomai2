package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RadioButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m798colorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1370708026);
        long m697getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m697getSecondary0d7_KjU() : j;
        long j4 = (i2 & 2) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m694getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long j5 = (i2 & 4) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m694getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:156)");
        }
        Color color = Color.box-impl(m697getSecondary0d7_KjU);
        Color color2 = Color.box-impl(j4);
        Color color3 = Color.box-impl(j5);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(color) | composer.changed(color2) | composer.changed(color3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultRadioButtonColors(m697getSecondary0d7_KjU, j4, j5, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
