package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultElevationOverlay implements ElevationOverlay {

    @NotNull
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    @Composable
    @ReadOnlyComposable
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo717apply7g2Lkgo(long j, float f, @Nullable Composer composer, int i) {
        long m750calculateForegroundColorCLU3JFs;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, i, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (Dp.compareTo-0680j_4(f, Dp.constructor-impl(0)) > 0 && !colors.isLight()) {
            m750calculateForegroundColorCLU3JFs = ElevationOverlayKt.m750calculateForegroundColorCLU3JFs(j, f, composer, (i & 112) | (i & 14));
            j = ColorKt.compositeOver--OWjLjI(m750calculateForegroundColorCLU3JFs, j);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j;
    }
}
