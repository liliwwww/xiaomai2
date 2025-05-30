package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DebugRippleTheme implements RippleTheme {

    @NotNull
    public static final DebugRippleTheme INSTANCE = new DebugRippleTheme();

    private DebugRippleTheme() {
    }

    @Composable
    /* renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long m890defaultColorWaAFU9c(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2042140174);
        long j = RippleTheme.Companion.defaultRippleColor-5vOe2sY(Color.Companion.m1074getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return j;
    }

    @Composable
    @NotNull
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1629816343);
        RippleAlpha rippleAlpha = RippleTheme.Companion.defaultRippleAlpha-DxMtmZc(Color.Companion.m1074getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return rippleAlpha;
    }
}
