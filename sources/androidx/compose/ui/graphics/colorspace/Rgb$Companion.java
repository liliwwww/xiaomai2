package androidx.compose.ui.graphics.colorspace;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Rgb$Companion {
    private Rgb$Companion() {
    }

    public /* synthetic */ Rgb$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final float area(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = ((((((f * f4) + (f2 * f5)) + (f3 * f6)) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
        return f7 < 0.0f ? -f7 : f7;
    }

    private final boolean compare(double d, DoubleFunction doubleFunction, DoubleFunction doubleFunction2) {
        return Math.abs(doubleFunction.invoke(d) - doubleFunction2.invoke(d)) <= 0.001d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WhitePoint computeWhitePoint(float[] fArr) {
        float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 1.0f, 1.0f});
        float f = mul3x3Float3[0] + mul3x3Float3[1] + mul3x3Float3[2];
        return new WhitePoint(mul3x3Float3[0] / f, mul3x3Float3[1] / f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] computeXYZMatrix(float[] fArr, WhitePoint whitePoint) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float x = whitePoint.getX();
        float y = whitePoint.getY();
        float f7 = 1;
        float f8 = (f7 - f) / f2;
        float f9 = (f7 - f3) / f4;
        float f10 = (f7 - f5) / f6;
        float f11 = (f7 - x) / y;
        float f12 = f / f2;
        float f13 = (f3 / f4) - f12;
        float f14 = (x / y) - f12;
        float f15 = f9 - f8;
        float f16 = (f5 / f6) - f12;
        float f17 = (((f11 - f8) * f13) - (f14 * f15)) / (((f10 - f8) * f13) - (f15 * f16));
        float f18 = (f14 - (f16 * f17)) / f13;
        float f19 = (1.0f - f18) - f17;
        float f20 = f19 / f2;
        float f21 = f18 / f4;
        float f22 = f17 / f6;
        return new float[]{f20 * f, f19, f20 * ((1.0f - f) - f2), f21 * f3, f18, f21 * ((1.0f - f3) - f4), f22 * f5, f17, f22 * ((1.0f - f5) - f6)};
    }

    private final boolean contains(float[] fArr, float[] fArr2) {
        float[] fArr3 = {fArr[0] - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2], fArr[3] - fArr2[3], fArr[4] - fArr2[4], fArr[5] - fArr2[5]};
        return cross(fArr3[0], fArr3[1], fArr2[0] - fArr2[4], fArr2[1] - fArr2[5]) >= 0.0f && cross(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) >= 0.0f && cross(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) >= 0.0f && cross(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) >= 0.0f && cross(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) >= 0.0f && cross(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) >= 0.0f;
    }

    private final float cross(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSrgb(float[] fArr, WhitePoint whitePoint, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, int i) {
        if (i == 0) {
            return true;
        }
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (!ColorSpaceKt.compare(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
            return false;
        }
        if (!(f == 0.0f)) {
            return false;
        }
        if (!(f2 == 1.0f)) {
            return false;
        }
        Rgb srgb = colorSpaces.getSrgb();
        for (double d = 0.0d; d <= 1.0d; d += 0.00392156862745098d) {
            if (!compare(d, doubleFunction, srgb.getOetfOrig$ui_graphics_release()) || !compare(d, doubleFunction2, srgb.getEotfOrig$ui_graphics_release())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWideGamut(float[] fArr, float f, float f2) {
        float area = area(fArr);
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return (area / area(colorSpaces.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release())) || (f < 0.0f && f2 > 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] xyPrimaries(float[] fArr) {
        float[] fArr2 = new float[6];
        if (fArr.length == 9) {
            float f = fArr[0] + fArr[1] + fArr[2];
            fArr2[0] = fArr[0] / f;
            fArr2[1] = fArr[1] / f;
            float f2 = fArr[3] + fArr[4] + fArr[5];
            fArr2[2] = fArr[3] / f2;
            fArr2[3] = fArr[4] / f2;
            float f3 = fArr[6] + fArr[7] + fArr[8];
            fArr2[4] = fArr[6] / f3;
            fArr2[5] = fArr[7] / f3;
        } else {
            ArraysKt.copyInto$default(fArr, fArr2, 0, 0, 6, 6, (Object) null);
        }
        return fArr2;
    }

    @NotNull
    public final float[] computePrimaries$ui_graphics_release(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "toXYZ");
        float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 0.0f, 0.0f});
        float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 1.0f, 0.0f});
        float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 0.0f, 1.0f});
        float f = mul3x3Float3[0] + mul3x3Float3[1] + mul3x3Float3[2];
        float f2 = mul3x3Float32[0] + mul3x3Float32[1] + mul3x3Float32[2];
        float f3 = mul3x3Float33[0] + mul3x3Float33[1] + mul3x3Float33[2];
        return new float[]{mul3x3Float3[0] / f, mul3x3Float3[1] / f, mul3x3Float32[0] / f2, mul3x3Float32[1] / f2, mul3x3Float33[0] / f3, mul3x3Float33[1] / f3};
    }
}
