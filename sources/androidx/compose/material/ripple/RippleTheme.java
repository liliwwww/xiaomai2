package androidx.compose.material.ripple;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface RippleTheme {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        /* renamed from: defaultRippleAlpha-DxMtmZc, reason: not valid java name */
        public final RippleAlpha m2377defaultRippleAlphaDxMtmZc(long j, boolean z) {
            RippleAlpha rippleAlpha;
            RippleAlpha rippleAlpha2;
            RippleAlpha rippleAlpha3;
            if (!z) {
                rippleAlpha = RippleThemeKt.DarkThemeRippleAlpha;
                return rippleAlpha;
            }
            if (ColorKt.m2839luminance8_81llA(j) > 0.5d) {
                rippleAlpha3 = RippleThemeKt.LightThemeHighContrastRippleAlpha;
                return rippleAlpha3;
            }
            rippleAlpha2 = RippleThemeKt.LightThemeLowContrastRippleAlpha;
            return rippleAlpha2;
        }

        /* renamed from: defaultRippleColor-5vOe2sY, reason: not valid java name */
        public final long m2378defaultRippleColor5vOe2sY(long j, boolean z) {
            return (z || ((double) ColorKt.m2839luminance8_81llA(j)) >= 0.5d) ? j : Color.Companion.m2824getWhite0d7_KjU();
        }
    }

    @Composable
    /* renamed from: defaultColor-WaAFU9c */
    long mo2135defaultColorWaAFU9c(@Nullable Composer composer, int i);

    @Composable
    @NotNull
    RippleAlpha rippleAlpha(@Nullable Composer composer, int i);
}
