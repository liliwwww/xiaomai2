package androidx.compose.p004ui.graphics.colorspace;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.p004ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Lab extends ColorSpace {

    /* renamed from: A */
    private static final float f116A = 0.008856452f;

    /* renamed from: B */
    private static final float f117B = 7.787037f;

    /* renamed from: C */
    private static final float f118C = 0.13793103f;

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: D */
    private static final float f119D = 0.20689656f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lab(@NotNull String str, int i) {
        super(str, ColorModel.Companion.m3152getLabxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        float f = fArr[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f2 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f3 = fArr[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f4 = fArr[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float pow = f2 > f116A ? (float) Math.pow(f2, 0.33333334f) : (f2 * f117B) + f118C;
        float pow2 = f3 > f116A ? (float) Math.pow(f3, 0.33333334f) : (f3 * f117B) + f118C;
        float pow3 = f4 > f116A ? (float) Math.pow(f4, 0.33333334f) : (f4 * f117B) + f118C;
        fArr[0] = RangesKt.coerceIn((116.0f * pow2) - 16.0f, 0.0f, 100.0f);
        fArr[1] = RangesKt.coerceIn((pow - pow2) * 500.0f, -128.0f, 128.0f);
        fArr[2] = RangesKt.coerceIn((pow2 - pow3) * 200.0f, -128.0f, 128.0f);
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return i == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn = (RangesKt.coerceIn(f, 0.0f, 100.0f) + 16.0f) / 116.0f;
        float coerceIn2 = (RangesKt.coerceIn(f, -128.0f, 128.0f) * 0.002f) + coerceIn;
        float f4 = coerceIn2 > f119D ? coerceIn2 * coerceIn2 * coerceIn2 : (coerceIn2 - f118C) * 0.12841855f;
        float f5 = coerceIn > f119D ? coerceIn * coerceIn * coerceIn : (coerceIn - f118C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        return (Float.floatToIntBits(f4 * illuminant.getD50Xyz$ui_graphics_release()[0]) << 32) | (Float.floatToIntBits(f5 * illuminant.getD50Xyz$ui_graphics_release()[1]) & 4294967295L);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        fArr[0] = RangesKt.coerceIn(fArr[0], 0.0f, 100.0f);
        fArr[1] = RangesKt.coerceIn(fArr[1], -128.0f, 128.0f);
        fArr[2] = RangesKt.coerceIn(fArr[2], -128.0f, 128.0f);
        float f = (fArr[0] + 16.0f) / 116.0f;
        float f2 = (fArr[1] * 0.002f) + f;
        float f3 = f - (fArr[2] * 0.005f);
        float f4 = f2 > f119D ? f2 * f2 * f2 : (f2 - f118C) * 0.12841855f;
        float f5 = f > f119D ? f * f * f : (f - f118C) * 0.12841855f;
        float f6 = f3 > f119D ? f3 * f3 * f3 : (f3 - f118C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        fArr[0] = f4 * illuminant.getD50Xyz$ui_graphics_release()[0];
        fArr[1] = f5 * illuminant.getD50Xyz$ui_graphics_release()[1];
        fArr[2] = f6 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn = ((RangesKt.coerceIn(f, 0.0f, 100.0f) + 16.0f) / 116.0f) - (RangesKt.coerceIn(f3, -128.0f, 128.0f) * 0.005f);
        return (coerceIn > f119D ? coerceIn * coerceIn * coerceIn : 0.12841855f * (coerceIn - f118C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3156xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Illuminant illuminant = Illuminant.INSTANCE;
        float f5 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f6 = f2 / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f7 = f3 / illuminant.getD50Xyz$ui_graphics_release()[2];
        float pow = f5 > f116A ? (float) Math.pow(f5, 0.33333334f) : (f5 * f117B) + f118C;
        float pow2 = f6 > f116A ? (float) Math.pow(f6, 0.33333334f) : (f6 * f117B) + f118C;
        return ColorKt.Color(RangesKt.coerceIn((116.0f * pow2) - 16.0f, 0.0f, 100.0f), RangesKt.coerceIn((pow - pow2) * 500.0f, -128.0f, 128.0f), RangesKt.coerceIn((pow2 - (f7 > f116A ? (float) Math.pow(f7, 0.33333334f) : (f7 * f117B) + f118C)) * 200.0f, -128.0f, 128.0f), f4, colorSpace);
    }
}
