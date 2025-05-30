package androidx.compose.material;

import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DefaultElevationOverlay implements ElevationOverlay {

    @NotNull
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    @Composable
    @ReadOnlyComposable
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo2052apply7g2Lkgo(long j, float f, @Nullable Composer composer, int i) {
        long m2095calculateForegroundColorCLU3JFs;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, i, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (C0856Dp.m5215compareTo0680j_4(f, C0856Dp.m5216constructorimpl(0)) > 0 && !colors.isLight()) {
            m2095calculateForegroundColorCLU3JFs = ElevationOverlayKt.m2095calculateForegroundColorCLU3JFs(j, f, composer, (i & 112) | (i & 14));
            j = ColorKt.m2832compositeOverOWjLjI(m2095calculateForegroundColorCLU3JFs, j);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j;
    }
}
