package androidx.compose.material.ripple;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
        public final RippleAlpha m733defaultRippleAlphaDxMtmZc(long j, boolean z) {
            return z ? ((double) ColorKt.m1072luminance8_81llA(j)) > 0.5d ? RippleThemeKt.access$getLightThemeHighContrastRippleAlpha$p() : RippleThemeKt.access$getLightThemeLowContrastRippleAlpha$p() : RippleThemeKt.access$getDarkThemeRippleAlpha$p();
        }

        /* renamed from: defaultRippleColor-5vOe2sY, reason: not valid java name */
        public final long m734defaultRippleColor5vOe2sY(long j, boolean z) {
            return (z || ((double) ColorKt.m1072luminance8_81llA(j)) >= 0.5d) ? j : Color.Companion.getWhite-0d7_KjU();
        }
    }

    @Composable
    /* renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    long m732defaultColorWaAFU9c(@Nullable Composer composer, int i);

    @Composable
    @NotNull
    RippleAlpha rippleAlpha(@Nullable Composer composer, int i);
}
