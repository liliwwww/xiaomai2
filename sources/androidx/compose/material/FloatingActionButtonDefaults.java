package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m766elevationixp7dh8(float f, float f2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-654132828);
        float f3 = (i2 & 1) != 0 ? Dp.constructor-impl(6) : f;
        float f4 = (i2 & 2) != 0 ? Dp.constructor-impl(12) : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:216)");
        }
        float f5 = 8;
        FloatingActionButtonElevation m767elevationxZ9QkE = m767elevationxZ9QkE(f3, f4, Dp.constructor-impl(f5), Dp.constructor-impl(f5), composer, (i & 14) | 3456 | (i & 112) | ((i << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m767elevationxZ9QkE;
    }

    @Composable
    @NotNull
    /* renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m767elevationxZ9QkE(float f, float f2, float f3, float f4, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(380403812);
        if ((i2 & 1) != 0) {
            f = Dp.constructor-impl(6);
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.constructor-impl(12);
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = Dp.constructor-impl(8);
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Dp.constructor-impl(8);
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:241)");
        }
        Object[] objArr = {Dp.box-impl(f5), Dp.box-impl(f6), Dp.box-impl(f7), Dp.box-impl(f8)};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultFloatingActionButtonElevation(f5, f6, f7, f8, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
