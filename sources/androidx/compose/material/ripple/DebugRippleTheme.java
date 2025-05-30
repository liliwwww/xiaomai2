package androidx.compose.material.ripple;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
final class DebugRippleTheme implements RippleTheme {

    @NotNull
    public static final DebugRippleTheme INSTANCE = new DebugRippleTheme();

    private DebugRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    /* renamed from: defaultColor-WaAFU9c */
    public long mo2135defaultColorWaAFU9c(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(2042140174);
        long m2378defaultRippleColor5vOe2sY = RippleTheme.Companion.m2378defaultRippleColor5vOe2sY(Color.Companion.m2813getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return m2378defaultRippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Composable
    @NotNull
    public RippleAlpha rippleAlpha(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1629816343);
        RippleAlpha m2377defaultRippleAlphaDxMtmZc = RippleTheme.Companion.m2377defaultRippleAlphaDxMtmZc(Color.Companion.m2813getBlack0d7_KjU(), true);
        composer.endReplaceableGroup();
        return m2377defaultRippleAlphaDxMtmZc;
    }
}
