package androidx.compose.p004ui.graphics.colorspace;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.p004ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Oklab extends ColorSpace {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final float[] InverseM1;

    @NotNull
    private static final float[] InverseM2;

    /* renamed from: M1 */
    @NotNull
    private static final float[] f120M1;

    /* renamed from: M2 */
    @NotNull
    private static final float[] f121M2;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] mul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        f120M1 = mul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f121M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(mul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oklab(@NotNull String str, int i) {
        super(str, ColorModel.Companion.m3152getLabxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        ColorSpaceKt.mul3x3Float3(f120M1, fArr);
        double d = 0.33333334f;
        fArr[0] = Math.signum(fArr[0]) * ((float) Math.pow(Math.abs(fArr[0]), d));
        fArr[1] = Math.signum(fArr[1]) * ((float) Math.pow(Math.abs(fArr[1]), d));
        fArr[2] = Math.signum(fArr[2]) * ((float) Math.pow(Math.abs(fArr[2]), d));
        ColorSpaceKt.mul3x3Float3(f121M2, fArr);
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float coerceIn2 = RangesKt.coerceIn(f2, -0.5f, 0.5f);
        float coerceIn3 = RangesKt.coerceIn(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, coerceIn, coerceIn2, coerceIn3);
        float f4 = mul3x3Float3_0 * mul3x3Float3_0 * mul3x3Float3_0;
        float f5 = mul3x3Float3_1 * mul3x3Float3_1 * mul3x3Float3_1;
        float f6 = mul3x3Float3_2 * mul3x3Float3_2 * mul3x3Float3_2;
        float[] fArr2 = InverseM1;
        float mul3x3Float3_02 = ColorSpaceKt.mul3x3Float3_0(fArr2, f4, f5, f6);
        float mul3x3Float3_12 = ColorSpaceKt.mul3x3Float3_1(fArr2, f4, f5, f6);
        return (Float.floatToIntBits(mul3x3Float3_02) << 32) | (Float.floatToIntBits(mul3x3Float3_12) & 4294967295L);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        fArr[0] = RangesKt.coerceIn(fArr[0], 0.0f, 1.0f);
        fArr[1] = RangesKt.coerceIn(fArr[1], -0.5f, 0.5f);
        fArr[2] = RangesKt.coerceIn(fArr[2], -0.5f, 0.5f);
        ColorSpaceKt.mul3x3Float3(InverseM2, fArr);
        fArr[0] = fArr[0] * fArr[0] * fArr[0];
        fArr[1] = fArr[1] * fArr[1] * fArr[1];
        fArr[2] = fArr[2] * fArr[2] * fArr[2];
        ColorSpaceKt.mul3x3Float3(InverseM1, fArr);
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float coerceIn2 = RangesKt.coerceIn(f2, -0.5f, 0.5f);
        float coerceIn3 = RangesKt.coerceIn(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, coerceIn, coerceIn2, coerceIn3);
        float f4 = mul3x3Float3_2 * mul3x3Float3_2 * mul3x3Float3_2;
        return ColorSpaceKt.mul3x3Float3_2(InverseM1, mul3x3Float3_0 * mul3x3Float3_0 * mul3x3Float3_0, mul3x3Float3_1 * mul3x3Float3_1 * mul3x3Float3_1, f4);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3156xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float[] fArr = f120M1;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, f, f2, f3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, f, f2, f3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, f, f2, f3);
        double d = 0.33333334f;
        float signum = Math.signum(mul3x3Float3_0) * ((float) Math.pow(Math.abs(mul3x3Float3_0), d));
        float signum2 = Math.signum(mul3x3Float3_1) * ((float) Math.pow(Math.abs(mul3x3Float3_1), d));
        float signum3 = Math.signum(mul3x3Float3_2) * ((float) Math.pow(Math.abs(mul3x3Float3_2), d));
        float[] fArr2 = f121M2;
        return ColorKt.Color(ColorSpaceKt.mul3x3Float3_0(fArr2, signum, signum2, signum3), ColorSpaceKt.mul3x3Float3_1(fArr2, signum, signum2, signum3), ColorSpaceKt.mul3x3Float3_2(fArr2, signum, signum2, signum3), f4, colorSpace);
    }
}
