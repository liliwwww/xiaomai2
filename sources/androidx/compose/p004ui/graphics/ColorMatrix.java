package androidx.compose.p004ui.graphics;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class ColorMatrix {

    @NotNull
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m2842boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static float[] m2843constructorimpl(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m2844constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m2843constructorimpl(fArr);
    }

    /* renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m2845convertRgbToYuvimpl(float[] fArr) {
        m2852resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m2846convertYuvToRgbimpl(float[] fArr) {
        m2852resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m2847dotMe4OoYI(float[] fArr, float[] fArr2, int i, float[] fArr3, int i2) {
        int i3 = i * 5;
        return (fArr2[i3 + 0] * fArr3[0 + i2]) + (fArr2[i3 + 1] * fArr3[5 + i2]) + (fArr2[i3 + 2] * fArr3[10 + i2]) + (fArr2[i3 + 3] * fArr3[15 + i2]);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2848equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m2863unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2849equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final float m2850getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2851hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m2852resetimpl(float[] fArr) {
        ArraysKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m2853rotateInternalimpl(float[] fArr, float f, Function2<? super Float, ? super Float, Unit> function2) {
        m2852resetimpl(fArr);
        double d = (f * 3.141592653589793d) / 180.0d;
        function2.invoke(Float.valueOf((float) Math.cos(d)), Float.valueOf((float) Math.sin(d)));
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m2854setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 5) + i2] = f;
    }

    /* renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m2855setjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "src");
        ArraysKt.copyInto$default(fArr2, fArr, 0, 0, 0, 14, (Object) null);
    }

    /* renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m2856setToRotateBlueimpl(float[] fArr, float f) {
        m2852resetimpl(fArr);
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[6] = cos;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[5] = -sin;
    }

    /* renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m2857setToRotateGreenimpl(float[] fArr, float f) {
        m2852resetimpl(fArr);
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[12] = cos;
        fArr[0] = cos;
        fArr[2] = -sin;
        fArr[10] = sin;
    }

    /* renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m2858setToRotateRedimpl(float[] fArr, float f) {
        m2852resetimpl(fArr);
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[12] = cos;
        fArr[6] = cos;
        fArr[7] = sin;
        fArr[11] = -sin;
    }

    /* renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m2859setToSaturationimpl(float[] fArr, float f) {
        m2852resetimpl(fArr);
        float f2 = 1 - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = f2 * 0.072f;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    /* renamed from: setToScale-impl, reason: not valid java name */
    public static final void m2860setToScaleimpl(float[] fArr, float f, float f2, float f3, float f4) {
        m2852resetimpl(fArr);
        fArr[0] = f;
        fArr[6] = f2;
        fArr[12] = f3;
        fArr[18] = f4;
    }

    /* renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m2861timesAssignjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "colorMatrix");
        float m2847dotMe4OoYI = m2847dotMe4OoYI(fArr, fArr, 0, fArr2, 0);
        float m2847dotMe4OoYI2 = m2847dotMe4OoYI(fArr, fArr, 0, fArr2, 1);
        float m2847dotMe4OoYI3 = m2847dotMe4OoYI(fArr, fArr, 0, fArr2, 2);
        float m2847dotMe4OoYI4 = m2847dotMe4OoYI(fArr, fArr, 0, fArr2, 3);
        float f = (fArr[0] * fArr2[4]) + (fArr[1] * fArr2[9]) + (fArr[2] * fArr2[14]) + (fArr[3] * fArr2[19]) + fArr[4];
        float m2847dotMe4OoYI5 = m2847dotMe4OoYI(fArr, fArr, 1, fArr2, 0);
        float m2847dotMe4OoYI6 = m2847dotMe4OoYI(fArr, fArr, 1, fArr2, 1);
        float m2847dotMe4OoYI7 = m2847dotMe4OoYI(fArr, fArr, 1, fArr2, 2);
        float m2847dotMe4OoYI8 = m2847dotMe4OoYI(fArr, fArr, 1, fArr2, 3);
        float f2 = (fArr[5] * fArr2[4]) + (fArr[6] * fArr2[9]) + (fArr[7] * fArr2[14]) + (fArr[8] * fArr2[19]) + fArr[9];
        float m2847dotMe4OoYI9 = m2847dotMe4OoYI(fArr, fArr, 2, fArr2, 0);
        float m2847dotMe4OoYI10 = m2847dotMe4OoYI(fArr, fArr, 2, fArr2, 1);
        float m2847dotMe4OoYI11 = m2847dotMe4OoYI(fArr, fArr, 2, fArr2, 2);
        float m2847dotMe4OoYI12 = m2847dotMe4OoYI(fArr, fArr, 2, fArr2, 3);
        float f3 = (fArr[10] * fArr2[4]) + (fArr[11] * fArr2[9]) + (fArr[12] * fArr2[14]) + (fArr[13] * fArr2[19]) + fArr[14];
        float m2847dotMe4OoYI13 = m2847dotMe4OoYI(fArr, fArr, 3, fArr2, 0);
        float m2847dotMe4OoYI14 = m2847dotMe4OoYI(fArr, fArr, 3, fArr2, 1);
        float m2847dotMe4OoYI15 = m2847dotMe4OoYI(fArr, fArr, 3, fArr2, 2);
        float m2847dotMe4OoYI16 = m2847dotMe4OoYI(fArr, fArr, 3, fArr2, 3);
        float f4 = (fArr[15] * fArr2[4]) + (fArr[16] * fArr2[9]) + (fArr[17] * fArr2[14]) + (fArr[18] * fArr2[19]) + fArr[19];
        fArr[0] = m2847dotMe4OoYI;
        fArr[1] = m2847dotMe4OoYI2;
        fArr[2] = m2847dotMe4OoYI3;
        fArr[3] = m2847dotMe4OoYI4;
        fArr[4] = f;
        fArr[5] = m2847dotMe4OoYI5;
        fArr[6] = m2847dotMe4OoYI6;
        fArr[7] = m2847dotMe4OoYI7;
        fArr[8] = m2847dotMe4OoYI8;
        fArr[9] = f2;
        fArr[10] = m2847dotMe4OoYI9;
        fArr[11] = m2847dotMe4OoYI10;
        fArr[12] = m2847dotMe4OoYI11;
        fArr[13] = m2847dotMe4OoYI12;
        fArr[14] = f3;
        fArr[15] = m2847dotMe4OoYI13;
        fArr[16] = m2847dotMe4OoYI14;
        fArr[17] = m2847dotMe4OoYI15;
        fArr[18] = m2847dotMe4OoYI16;
        fArr[19] = f4;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2862toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m2848equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m2851hashCodeimpl(this.values);
    }

    public String toString() {
        return m2862toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m2863unboximpl() {
        return this.values;
    }
}
