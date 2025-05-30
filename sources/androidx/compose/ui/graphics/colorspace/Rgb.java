package androidx.compose.ui.graphics.colorspace;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ed4;
import tb.fd4;
import tb.hd4;
import tb.id4;
import tb.od4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Rgb extends ColorSpace {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final DoubleFunction DoubleIdentity = fd4.a;

    @NotNull
    private final Function1<Double, Double> eotf;

    @NotNull
    private final DoubleFunction eotfFunc;

    @NotNull
    private final DoubleFunction eotfOrig;

    @NotNull
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;

    @NotNull
    private final Function1<Double, Double> oetf;

    @NotNull
    private final DoubleFunction oetfFunc;

    @NotNull
    private final DoubleFunction oetfOrig;

    @NotNull
    private final float[] primaries;

    @Nullable
    private final TransferParameters transferParameters;

    @NotNull
    private final float[] transform;

    @NotNull
    private final WhitePoint whitePoint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint, @Nullable float[] fArr2, @NotNull DoubleFunction doubleFunction, @NotNull DoubleFunction doubleFunction2, float f, float f2, @Nullable TransferParameters transferParameters, int i) {
        super(str, ColorModel.Companion.m1242getRgbxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        Intrinsics.checkNotNullParameter(doubleFunction, "oetf");
        Intrinsics.checkNotNullParameter(doubleFunction2, "eotf");
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        this.oetf = new oetf.1(this);
        this.oetfFunc = new hd4(this);
        this.eotfOrig = doubleFunction2;
        this.eotf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }

            @NotNull
            public final Double invoke(double d) {
                float f3;
                float f4;
                DoubleFunction eotfOrig$ui_graphics_release = Rgb.this.getEotfOrig$ui_graphics_release();
                f3 = Rgb.this.min;
                double d2 = f3;
                f4 = Rgb.this.max;
                return Double.valueOf(eotfOrig$ui_graphics_release.invoke(RangesKt.coerceIn(d, d2, f4)));
            }
        };
        this.eotfFunc = new id4(this);
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f >= f2) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
        }
        Companion companion = Companion;
        float[] access$xyPrimaries = Companion.access$xyPrimaries(companion, fArr);
        this.primaries = access$xyPrimaries;
        if (fArr2 == null) {
            this.transform = Companion.access$computeXYZMatrix(companion, access$xyPrimaries, whitePoint);
        } else {
            if (fArr2.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.transform = fArr2;
        }
        this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
        this.isWideGamut = Companion.access$isWideGamut(companion, access$xyPrimaries, f, f2);
        this.isSrgb = Companion.access$isSrgb(companion, access$xyPrimaries, whitePoint, doubleFunction, doubleFunction2, f, f2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double DoubleIdentity$lambda$12(double d) {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$10(double d, double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        }
        return Math.pow(d2, 1.0d / d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$11(double d, double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        }
        return Math.pow(d2, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$2(Function1 function1, double d) {
        Intrinsics.checkNotNullParameter(function1, "$oetf");
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$3(Function1 function1, double d) {
        Intrinsics.checkNotNullParameter(function1, "$eotf");
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$4(Function1 function1, double d) {
        Intrinsics.checkNotNullParameter(function1, "$oetf");
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$5(Function1 function1, double d) {
        Intrinsics.checkNotNullParameter(function1, "$eotf");
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$6(TransferParameters transferParameters, double d) {
        Intrinsics.checkNotNullParameter(transferParameters, "$function");
        return ColorSpaceKt.rcpResponse(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$7(TransferParameters transferParameters, double d) {
        Intrinsics.checkNotNullParameter(transferParameters, "$function");
        return ColorSpaceKt.rcpResponse(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$8(TransferParameters transferParameters, double d) {
        Intrinsics.checkNotNullParameter(transferParameters, "$function");
        return ColorSpaceKt.response(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double _init_$lambda$9(TransferParameters transferParameters, double d) {
        Intrinsics.checkNotNullParameter(transferParameters, "$function");
        return ColorSpaceKt.response(d, transferParameters.getA(), transferParameters.getB(), transferParameters.getC(), transferParameters.getD(), transferParameters.getE(), transferParameters.getF(), transferParameters.getGamma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double eotfFunc$lambda$1(Rgb rgb, double d) {
        Intrinsics.checkNotNullParameter(rgb, "this$0");
        return rgb.eotfOrig.invoke(RangesKt.coerceIn(d, rgb.min, rgb.max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double oetfFunc$lambda$0(Rgb rgb, double d) {
        Intrinsics.checkNotNullParameter(rgb, "this$0");
        return RangesKt.coerceIn(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Rgb.class), Reflection.getOrCreateKotlinClass(obj.getClass())) || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            return Intrinsics.areEqual(transferParameters, rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @NotNull
    public final float[] fromLinear(float f, float f2, float f3) {
        return fromLinear(new float[]{f, f2, f3});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.V);
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, fArr);
        fArr[0] = (float) this.oetfFunc.invoke(fArr[0]);
        fArr[1] = (float) this.oetfFunc.invoke(fArr[1]);
        fArr[2] = (float) this.oetfFunc.invoke(fArr[2]);
        return fArr;
    }

    @NotNull
    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    @NotNull
    public final DoubleFunction getEotfFunc$ui_graphics_release() {
        return this.eotfFunc;
    }

    @NotNull
    public final DoubleFunction getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    @NotNull
    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return this.min;
    }

    @NotNull
    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    @NotNull
    public final DoubleFunction getOetfFunc$ui_graphics_release() {
        return this.oetfFunc;
    }

    @NotNull
    public final DoubleFunction getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    @NotNull
    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    @Nullable
    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    @NotNull
    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    @NotNull
    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int hashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f = this.min;
        int floatToIntBits = (hashCode + (!((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.max;
        int floatToIntBits2 = (floatToIntBits + (!(f2 == 0.0f) ? Float.floatToIntBits(f2) : 0)) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int hashCode2 = floatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        return this.transferParameters == null ? (((hashCode2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : hashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    @NotNull
    public final float[] toLinear(float f, float f2, float f3) {
        return toLinear(new float[]{f, f2, f3});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float invoke = (float) this.eotfFunc.invoke(f);
        float invoke2 = (float) this.eotfFunc.invoke(f2);
        float invoke3 = (float) this.eotfFunc.invoke(f3);
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(this.transform, invoke, invoke2, invoke3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(this.transform, invoke, invoke2, invoke3);
        return (Float.floatToIntBits(mul3x3Float3_0) << 32) | (Float.floatToIntBits(mul3x3Float3_1) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.V);
        fArr[0] = (float) this.eotfFunc.invoke(fArr[0]);
        fArr[1] = (float) this.eotfFunc.invoke(fArr[1]);
        fArr[2] = (float) this.eotfFunc.invoke(fArr[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, fArr);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return ColorSpaceKt.mul3x3Float3_2(this.transform, (float) this.eotfFunc.invoke(f), (float) this.eotfFunc.invoke(f2), (float) this.eotfFunc.invoke(f3));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1245xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color((float) this.oetfFunc.invoke(ColorSpaceKt.mul3x3Float3_0(this.inverseTransform, f, f2, f3)), (float) this.oetfFunc.invoke(ColorSpaceKt.mul3x3Float3_1(this.inverseTransform, f, f2, f3)), (float) this.oetfFunc.invoke(ColorSpaceKt.mul3x3Float3_2(this.inverseTransform, f, f2, f3)), f4, colorSpace);
    }

    @NotNull
    public final float[] fromLinear(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.V);
        fArr[0] = (float) this.oetfFunc.invoke(fArr[0]);
        fArr[1] = (float) this.oetfFunc.invoke(fArr[1]);
        fArr[2] = (float) this.oetfFunc.invoke(fArr[2]);
        return fArr;
    }

    @NotNull
    public final float[] getInverseTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "inverseTransform");
        return ArraysKt.copyInto$default(this.inverseTransform, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] getPrimaries(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        return ArraysKt.copyInto$default(this.primaries, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] getTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "transform");
        return ArraysKt.copyInto$default(this.transform, fArr, 0, 0, 0, 14, (Object) null);
    }

    @NotNull
    public final float[] toLinear(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.V);
        fArr[0] = (float) this.eotfFunc.invoke(fArr[0]);
        fArr[1] = (float) this.eotfFunc.invoke(fArr[1]);
        fArr[2] = (float) this.eotfFunc.invoke(fArr[2]);
        return fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull float[] r17, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r19) {
        /*
            r15 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "name"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            java.lang.String r3 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "oetf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "eotf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r3 = androidx.compose.ui.graphics.colorspace.Rgb.Companion
            float[] r6 = r3.computePrimaries$ui_graphics_release(r0)
            androidx.compose.ui.graphics.colorspace.WhitePoint r7 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r3, r0)
            tb.dd4 r9 = new tb.dd4
            r9.<init>(r1)
            tb.nd4 r10 = new tb.nd4
            r10.<init>(r2)
            r8 = 0
            r11 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r14 = -1
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint, @NotNull Function1<? super Double, Double> function1, @NotNull Function1<? super Double, Double> function12, float f, float f2) {
        this(str, fArr, whitePoint, null, new ed4(function1), new od4(function12), f, f2, null, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        Intrinsics.checkNotNullParameter(function1, "oetf");
        Intrinsics.checkNotNullParameter(function12, "eotf");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull float[] r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.TransferParameters r10) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r9)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r0, r9)
            r6 = -1
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.TransferParameters):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint, @NotNull TransferParameters transferParameters) {
        this(str, fArr, whitePoint, transferParameters, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        Intrinsics.checkNotNullParameter(transferParameters, "function");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull float[] r14, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r15, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.TransferParameters r16, int r17) {
        /*
            r12 = this;
            r9 = r16
            java.lang.String r0 = "name"
            r1 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "primaries"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "whitePoint"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            double r4 = r16.getE()
            r0 = 1
            r6 = 0
            r7 = 0
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 != 0) goto L2a
            r4 = 1
            goto L2b
        L2a:
            r4 = 0
        L2b:
            if (r4 == 0) goto L40
            double r4 = r16.getF()
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 != 0) goto L37
            r4 = 1
            goto L38
        L37:
            r4 = 0
        L38:
            if (r4 == 0) goto L40
            tb.md4 r4 = new tb.md4
            r4.<init>(r9)
            goto L45
        L40:
            tb.jd4 r4 = new tb.jd4
            r4.<init>(r9)
        L45:
            r5 = r4
            double r10 = r16.getE()
            int r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r4 != 0) goto L50
            r4 = 1
            goto L51
        L50:
            r4 = 0
        L51:
            if (r4 == 0) goto L65
            double r10 = r16.getF()
            int r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r4 != 0) goto L5c
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 == 0) goto L65
            tb.kd4 r0 = new tb.kd4
            r0.<init>(r9)
            goto L6a
        L65:
            tb.ld4 r0 = new tb.ld4
            r0.<init>(r9)
        L6a:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r9 = r16
            r10 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull float[] r12, double r13) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r12)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r0, r12)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r1 = r10
            r2 = r11
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], double):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String str, @NotNull float[] fArr, @NotNull WhitePoint whitePoint, double d) {
        this(str, fArr, whitePoint, d, 0.0f, 1.0f, -1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull float[] r24, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r25, double r26, float r28, float r29, int r30) {
        /*
            r22 = this;
            r1 = r26
            java.lang.String r0 = "name"
            r15 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "primaries"
            r13 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "whitePoint"
            r14 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1
            r3 = 0
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L24
            r4 = 1
            goto L25
        L24:
            r4 = 0
        L25:
            if (r4 == 0) goto L2a
            androidx.compose.ui.graphics.colorspace.DoubleFunction r4 = androidx.compose.ui.graphics.colorspace.Rgb.DoubleIdentity
            goto L2f
        L2a:
            tb.cd4 r4 = new tb.cd4
            r4.<init>(r1)
        L2f:
            r17 = r4
            if (r6 != 0) goto L34
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 == 0) goto L3a
            androidx.compose.ui.graphics.colorspace.DoubleFunction r0 = androidx.compose.ui.graphics.colorspace.Rgb.DoubleIdentity
            goto L3f
        L3a:
            tb.gd4 r0 = new tb.gd4
            r0.<init>(r1)
        L3f:
            r18 = r0
            androidx.compose.ui.graphics.colorspace.TransferParameters r19 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r0 = r19
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r20 = 0
            r13 = r20
            r16 = 96
            r15 = r16
            r16 = 0
            r1 = r26
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r5 = 0
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r6 = r17
            r7 = r18
            r8 = r28
            r9 = r29
            r10 = r19
            r11 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull Rgb rgb, @NotNull float[] fArr, @NotNull WhitePoint whitePoint) {
        this(rgb.getName(), rgb.primaries, whitePoint, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
        Intrinsics.checkNotNullParameter(rgb, "colorSpace");
        Intrinsics.checkNotNullParameter(fArr, "transform");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
    }
}
