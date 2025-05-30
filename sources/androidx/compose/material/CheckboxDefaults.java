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
public final class CheckboxDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m1980colorszjMxDiM(long j, long j2, long j3, long j4, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(469524104);
        long m2018getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2018getSecondary0d7_KjU() : j;
        long m2786copywmQWz5c$default = (i2 & 2) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m2020getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU() : j3;
        long m2786copywmQWz5c$default2 = (i2 & 8) != 0 ? Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2015getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long m2786copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m2786copywmQWz5c$default(m2018getSecondary0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, i, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:220)");
        }
        Object[] objArr = {Color.m2777boximpl(m2018getSecondary0d7_KjU), Color.m2777boximpl(m2786copywmQWz5c$default), Color.m2777boximpl(m2020getSurface0d7_KjU), Color.m2777boximpl(m2786copywmQWz5c$default2), Color.m2777boximpl(m2786copywmQWz5c$default3)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultCheckboxColors(m2020getSurface0d7_KjU, Color.m2786copywmQWz5c$default(m2020getSurface0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), m2018getSecondary0d7_KjU, Color.m2786copywmQWz5c$default(m2018getSecondary0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), m2786copywmQWz5c$default2, Color.m2786copywmQWz5c$default(m2786copywmQWz5c$default2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), m2786copywmQWz5c$default3, m2018getSecondary0d7_KjU, m2786copywmQWz5c$default, m2786copywmQWz5c$default2, m2786copywmQWz5c$default3, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
