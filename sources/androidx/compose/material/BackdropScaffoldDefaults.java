package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class BackdropScaffoldDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final BackdropScaffoldDefaults INSTANCE = new BackdropScaffoldDefaults();
    private static final float PeekHeight = C0856Dp.m5216constructorimpl(56);
    private static final float HeaderHeight = C0856Dp.m5216constructorimpl(48);
    private static final float FrontLayerElevation = C0856Dp.m5216constructorimpl(1);

    private BackdropScaffoldDefaults() {
    }

    /* renamed from: getFrontLayerElevation-D9Ej5fM, reason: not valid java name */
    public final float m1923getFrontLayerElevationD9Ej5fM() {
        return FrontLayerElevation;
    }

    @Composable
    @JvmName(name = "getFrontLayerScrimColor")
    public final long getFrontLayerScrimColor(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1806270648);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1806270648, i, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerScrimColor> (BackdropScaffold.kt:517)");
        }
        long m2786copywmQWz5c$default = Color.m2786copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2020getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2786copywmQWz5c$default;
    }

    @Composable
    @JvmName(name = "getFrontLayerShape")
    @NotNull
    public final Shape getFrontLayerShape(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1580588700);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1580588700, i, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerShape> (BackdropScaffold.kt:505)");
        }
        float f = 16;
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getLarge(), CornerSizeKt.m1686CornerSize0680j_4(C0856Dp.m5216constructorimpl(f)), CornerSizeKt.m1686CornerSize0680j_4(C0856Dp.m5216constructorimpl(f)), null, null, 12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return copy$default;
    }

    /* renamed from: getHeaderHeight-D9Ej5fM, reason: not valid java name */
    public final float m1924getHeaderHeightD9Ej5fM() {
        return HeaderHeight;
    }

    /* renamed from: getPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m1925getPeekHeightD9Ej5fM() {
        return PeekHeight;
    }
}
