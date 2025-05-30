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
public final class CheckboxDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @Composable
    @NotNull
    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m684colorszjMxDiM(long j, long j2, long j3, long j4, long j5, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(469524104);
        long m697getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m697getSecondary0d7_KjU() : j;
        long j6 = (i2 & 2) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m694getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long m699getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m699getSurface0d7_KjU() : j3;
        long j7 = (i2 & 8) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m694getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        long j8 = (i2 & 16) != 0 ? Color.copy-wmQWz5c$default(m697getSecondary0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, i, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:220)");
        }
        Object[] objArr = {Color.box-impl(m697getSecondary0d7_KjU), Color.box-impl(j6), Color.box-impl(m699getSurface0d7_KjU), Color.box-impl(j7), Color.box-impl(j8)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultCheckboxColors(m699getSurface0d7_KjU, Color.copy-wmQWz5c$default(m699getSurface0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), m697getSecondary0d7_KjU, Color.copy-wmQWz5c$default(m697getSecondary0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j7, Color.copy-wmQWz5c$default(j7, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j8, m697getSecondary0d7_KjU, j6, j7, j8, null);
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
