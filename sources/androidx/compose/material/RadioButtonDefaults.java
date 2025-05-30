package androidx.compose.material;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class RadioButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m2205colorsRGew2ao(long j, long j2, long j3, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1370708026);
        long m2018getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2018getSecondary0d7_KjU() : j;
        long m2786copywmQWz5c$default = (i2 & 2) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m2786copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:156)");
        }
        Color m2777boximpl = Color.m2777boximpl(m2018getSecondary0d7_KjU);
        Color m2777boximpl2 = Color.m2777boximpl(m2786copywmQWz5c$default);
        Color m2777boximpl3 = Color.m2777boximpl(m2786copywmQWz5c$default2);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(m2777boximpl) | composer.changed(m2777boximpl2) | composer.changed(m2777boximpl3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultRadioButtonColors(m2018getSecondary0d7_KjU, m2786copywmQWz5c$default, m2786copywmQWz5c$default2, null);
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
