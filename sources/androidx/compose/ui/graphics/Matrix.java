package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Matrix {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;

    @NotNull
    private final float[] values;

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m1151boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static float[] m1152constructorimpl(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m1153constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m1152constructorimpl(fArr);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1154equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).m1174unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1155equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final float m1156getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 4) + i2];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1157hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: invert-impl, reason: not valid java name */
    public static final void m1158invertimpl(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = fArr[11];
        float f13 = fArr[12];
        float f14 = fArr[13];
        float f15 = fArr[14];
        float f16 = fArr[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (((((f17 * f28) - (f18 * f27)) + (f19 * f26)) + (f20 * f25)) - (f21 * f24)) + (f22 * f23);
        if (f29 == 0.0f) {
            return;
        }
        float f30 = 1.0f / f29;
        fArr[0] = (((f6 * f28) - (f7 * f27)) + (f8 * f26)) * f30;
        fArr[1] = ((((-f2) * f28) + (f3 * f27)) - (f4 * f26)) * f30;
        fArr[2] = (((f14 * f22) - (f15 * f21)) + (f16 * f20)) * f30;
        fArr[3] = ((((-f10) * f22) + (f11 * f21)) - (f12 * f20)) * f30;
        float f31 = -f5;
        fArr[4] = (((f31 * f28) + (f7 * f25)) - (f8 * f24)) * f30;
        fArr[5] = (((f28 * f) - (f3 * f25)) + (f4 * f24)) * f30;
        float f32 = -f13;
        fArr[6] = (((f32 * f22) + (f15 * f19)) - (f16 * f18)) * f30;
        fArr[7] = (((f22 * f9) - (f11 * f19)) + (f12 * f18)) * f30;
        fArr[8] = (((f5 * f27) - (f6 * f25)) + (f8 * f23)) * f30;
        fArr[9] = ((((-f) * f27) + (f25 * f2)) - (f4 * f23)) * f30;
        fArr[10] = (((f13 * f21) - (f14 * f19)) + (f16 * f17)) * f30;
        fArr[11] = ((((-f9) * f21) + (f19 * f10)) - (f12 * f17)) * f30;
        fArr[12] = (((f31 * f26) + (f6 * f24)) - (f7 * f23)) * f30;
        fArr[13] = (((f * f26) - (f2 * f24)) + (f3 * f23)) * f30;
        fArr[14] = (((f32 * f20) + (f14 * f18)) - (f15 * f17)) * f30;
        fArr[15] = (((f9 * f20) - (f10 * f18)) + (f11 * f17)) * f30;
    }

    /* renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m1159mapMKHz9U(float[] fArr, long j) {
        float m848getXimpl = Offset.m848getXimpl(j);
        float m849getYimpl = Offset.m849getYimpl(j);
        float f = 1 / (((fArr[3] * m848getXimpl) + (fArr[7] * m849getYimpl)) + fArr[15]);
        if (!((Float.isInfinite(f) || Float.isNaN(f)) ? false : true)) {
            f = 0.0f;
        }
        return OffsetKt.Offset(((fArr[0] * m848getXimpl) + (fArr[4] * m849getYimpl) + fArr[12]) * f, f * ((fArr[1] * m848getXimpl) + (fArr[5] * m849getYimpl) + fArr[13]));
    }

    @NotNull
    /* renamed from: map-impl, reason: not valid java name */
    public static final Rect m1160mapimpl(float[] fArr, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long m1159mapMKHz9U = m1159mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long m1159mapMKHz9U2 = m1159mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long m1159mapMKHz9U3 = m1159mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long m1159mapMKHz9U4 = m1159mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m848getXimpl(m1159mapMKHz9U), Offset.m848getXimpl(m1159mapMKHz9U2)), Math.min(Offset.m848getXimpl(m1159mapMKHz9U3), Offset.m848getXimpl(m1159mapMKHz9U4))), Math.min(Math.min(Offset.m849getYimpl(m1159mapMKHz9U), Offset.m849getYimpl(m1159mapMKHz9U2)), Math.min(Offset.m849getYimpl(m1159mapMKHz9U3), Offset.m849getYimpl(m1159mapMKHz9U4))), Math.max(Math.max(Offset.m848getXimpl(m1159mapMKHz9U), Offset.m848getXimpl(m1159mapMKHz9U2)), Math.max(Offset.m848getXimpl(m1159mapMKHz9U3), Offset.m848getXimpl(m1159mapMKHz9U4))), Math.max(Math.max(Offset.m849getYimpl(m1159mapMKHz9U), Offset.m849getYimpl(m1159mapMKHz9U2)), Math.max(Offset.m849getYimpl(m1159mapMKHz9U3), Offset.m849getYimpl(m1159mapMKHz9U4))));
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m1162resetimpl(float[] fArr) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                fArr[(i2 * 4) + i] = i == i2 ? 1.0f : 0.0f;
                i2++;
            }
            i++;
        }
    }

    /* renamed from: rotateX-impl, reason: not valid java name */
    public static final void m1163rotateXimpl(float[] fArr, float f) {
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[9];
        float f7 = fArr[10];
        float f8 = fArr[13];
        float f9 = fArr[14];
        fArr[1] = (f2 * cos) - (f3 * sin);
        fArr[2] = (f2 * sin) + (f3 * cos);
        fArr[5] = (f4 * cos) - (f5 * sin);
        fArr[6] = (f4 * sin) + (f5 * cos);
        fArr[9] = (f6 * cos) - (f7 * sin);
        fArr[10] = (f6 * sin) + (f7 * cos);
        fArr[13] = (f8 * cos) - (f9 * sin);
        fArr[14] = (f8 * sin) + (f9 * cos);
    }

    /* renamed from: rotateY-impl, reason: not valid java name */
    public static final void m1164rotateYimpl(float[] fArr, float f) {
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[2];
        float f4 = fArr[4];
        float f5 = fArr[6];
        float f6 = fArr[8];
        float f7 = fArr[10];
        float f8 = fArr[12];
        float f9 = fArr[14];
        fArr[0] = (f2 * cos) + (f3 * sin);
        fArr[2] = ((-f2) * sin) + (f3 * cos);
        fArr[4] = (f4 * cos) + (f5 * sin);
        fArr[6] = ((-f4) * sin) + (f5 * cos);
        fArr[8] = (f6 * cos) + (f7 * sin);
        fArr[10] = ((-f6) * sin) + (f7 * cos);
        fArr[12] = (f8 * cos) + (f9 * sin);
        fArr[14] = ((-f8) * sin) + (f9 * cos);
    }

    /* renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m1165rotateZimpl(float[] fArr, float f) {
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = -sin;
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[2];
        float f8 = fArr[6];
        float f9 = fArr[3];
        float f10 = fArr[7];
        fArr[0] = (cos * f2) + (sin * f3);
        fArr[1] = (cos * f5) + (sin * f6);
        fArr[2] = (cos * f7) + (sin * f8);
        fArr[3] = (cos * f9) + (sin * f10);
        fArr[4] = (f2 * f4) + (f3 * cos);
        fArr[5] = (f5 * f4) + (f6 * cos);
        fArr[6] = (f7 * f4) + (f8 * cos);
        fArr[7] = (f4 * f9) + (cos * f10);
    }

    /* renamed from: scale-impl, reason: not valid java name */
    public static final void m1166scaleimpl(float[] fArr, float f, float f2, float f3) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[6] = fArr[6] * f2;
        fArr[7] = fArr[7] * f2;
        fArr[8] = fArr[8] * f3;
        fArr[9] = fArr[9] * f3;
        fArr[10] = fArr[10] * f3;
        fArr[11] = fArr[11] * f3;
    }

    /* renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1167scaleimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        m1166scaleimpl(fArr, f, f2, f3);
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m1168setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 4) + i2] = f;
    }

    /* renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m1169setFrom58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "matrix");
        for (int i = 0; i < 16; i++) {
            fArr[i] = fArr2[i];
        }
    }

    /* renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m1170timesAssign58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr2, "m");
        float f = MatrixKt.access$dot-p89u6pk(fArr, 0, fArr2, 0);
        float f2 = MatrixKt.access$dot-p89u6pk(fArr, 0, fArr2, 1);
        float f3 = MatrixKt.access$dot-p89u6pk(fArr, 0, fArr2, 2);
        float f4 = MatrixKt.access$dot-p89u6pk(fArr, 0, fArr2, 3);
        float f5 = MatrixKt.access$dot-p89u6pk(fArr, 1, fArr2, 0);
        float f6 = MatrixKt.access$dot-p89u6pk(fArr, 1, fArr2, 1);
        float f7 = MatrixKt.access$dot-p89u6pk(fArr, 1, fArr2, 2);
        float f8 = MatrixKt.access$dot-p89u6pk(fArr, 1, fArr2, 3);
        float f9 = MatrixKt.access$dot-p89u6pk(fArr, 2, fArr2, 0);
        float f10 = MatrixKt.access$dot-p89u6pk(fArr, 2, fArr2, 1);
        float f11 = MatrixKt.access$dot-p89u6pk(fArr, 2, fArr2, 2);
        float f12 = MatrixKt.access$dot-p89u6pk(fArr, 2, fArr2, 3);
        float f13 = MatrixKt.access$dot-p89u6pk(fArr, 3, fArr2, 0);
        float f14 = MatrixKt.access$dot-p89u6pk(fArr, 3, fArr2, 1);
        float f15 = MatrixKt.access$dot-p89u6pk(fArr, 3, fArr2, 2);
        float f16 = MatrixKt.access$dot-p89u6pk(fArr, 3, fArr2, 3);
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
        fArr[8] = f9;
        fArr[9] = f10;
        fArr[10] = f11;
        fArr[11] = f12;
        fArr[12] = f13;
        fArr[13] = f14;
        fArr[14] = f15;
        fArr[15] = f16;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1171toStringimpl(float[] fArr) {
        return StringsKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* renamed from: translate-impl, reason: not valid java name */
    public static final void m1172translateimpl(float[] fArr, float f, float f2, float f3) {
        float f4 = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        float f5 = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        float f6 = (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3) + fArr[14];
        float f7 = (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3) + fArr[15];
        fArr[12] = f4;
        fArr[13] = f5;
        fArr[14] = f6;
        fArr[15] = f7;
    }

    /* renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1173translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m1172translateimpl(fArr, f, f2, f3);
    }

    public boolean equals(Object obj) {
        return m1154equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m1157hashCodeimpl(this.values);
    }

    @NotNull
    public String toString() {
        return m1171toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m1174unboximpl() {
        return this.values;
    }

    /* renamed from: map-impl, reason: not valid java name */
    public static final void m1161mapimpl(float[] fArr, @NotNull MutableRect mutableRect) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        long m1159mapMKHz9U = m1159mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long m1159mapMKHz9U2 = m1159mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long m1159mapMKHz9U3 = m1159mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long m1159mapMKHz9U4 = m1159mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m848getXimpl(m1159mapMKHz9U), Offset.m848getXimpl(m1159mapMKHz9U2)), Math.min(Offset.m848getXimpl(m1159mapMKHz9U3), Offset.m848getXimpl(m1159mapMKHz9U4))));
        mutableRect.setTop(Math.min(Math.min(Offset.m849getYimpl(m1159mapMKHz9U), Offset.m849getYimpl(m1159mapMKHz9U2)), Math.min(Offset.m849getYimpl(m1159mapMKHz9U3), Offset.m849getYimpl(m1159mapMKHz9U4))));
        mutableRect.setRight(Math.max(Math.max(Offset.m848getXimpl(m1159mapMKHz9U), Offset.m848getXimpl(m1159mapMKHz9U2)), Math.max(Offset.m848getXimpl(m1159mapMKHz9U3), Offset.m848getXimpl(m1159mapMKHz9U4))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m849getYimpl(m1159mapMKHz9U), Offset.m849getYimpl(m1159mapMKHz9U2)), Math.max(Offset.m849getYimpl(m1159mapMKHz9U3), Offset.m849getYimpl(m1159mapMKHz9U4))));
    }
}
