package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014d  */
    @androidx.compose.runtime.Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r9, float r10, float r11, float r12, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.ColorSpace r13) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    @Stable
    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1065compositeOverOWjLjI(long j, long j2) {
        long m1047convertvNxB06k = Color.m1047convertvNxB06k(j, Color.m1054getColorSpaceimpl(j2));
        float m1052getAlphaimpl = Color.m1052getAlphaimpl(j2);
        float m1052getAlphaimpl2 = Color.m1052getAlphaimpl(m1047convertvNxB06k);
        float f = 1.0f - m1052getAlphaimpl2;
        float f2 = (m1052getAlphaimpl * f) + m1052getAlphaimpl2;
        return Color((f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m1056getRedimpl(m1047convertvNxB06k) * m1052getAlphaimpl2) + ((Color.m1056getRedimpl(j2) * m1052getAlphaimpl) * f)) / f2, (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m1055getGreenimpl(m1047convertvNxB06k) * m1052getAlphaimpl2) + ((Color.m1055getGreenimpl(j2) * m1052getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m1053getBlueimpl(m1047convertvNxB06k) * m1052getAlphaimpl2) + ((Color.m1053getBlueimpl(j2) * m1052getAlphaimpl) * f)) / f2, f2, Color.m1054getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m1066getComponents8_81llA(long j) {
        return new float[]{Color.m1056getRedimpl(j), Color.m1055getGreenimpl(j), Color.m1053getBlueimpl(j), Color.m1052getAlphaimpl(j)};
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m1067isSpecified8_81llA(long j) {
        return j != Color.Companion.getUnspecified-0d7_KjU();
    }

    @Stable
    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1068isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m1069isUnspecified8_81llA(long j) {
        return j == Color.Companion.getUnspecified-0d7_KjU();
    }

    @Stable
    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1070isUnspecified8_81llA$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m1071lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m1047convertvNxB06k = Color.m1047convertvNxB06k(j, oklab);
        long m1047convertvNxB06k2 = Color.m1047convertvNxB06k(j2, oklab);
        float m1052getAlphaimpl = Color.m1052getAlphaimpl(m1047convertvNxB06k);
        float m1056getRedimpl = Color.m1056getRedimpl(m1047convertvNxB06k);
        float m1055getGreenimpl = Color.m1055getGreenimpl(m1047convertvNxB06k);
        float m1053getBlueimpl = Color.m1053getBlueimpl(m1047convertvNxB06k);
        float m1052getAlphaimpl2 = Color.m1052getAlphaimpl(m1047convertvNxB06k2);
        float m1056getRedimpl2 = Color.m1056getRedimpl(m1047convertvNxB06k2);
        float m1055getGreenimpl2 = Color.m1055getGreenimpl(m1047convertvNxB06k2);
        float m1053getBlueimpl2 = Color.m1053getBlueimpl(m1047convertvNxB06k2);
        return Color.m1047convertvNxB06k(Color(MathHelpersKt.lerp(m1056getRedimpl, m1056getRedimpl2, f), MathHelpersKt.lerp(m1055getGreenimpl, m1055getGreenimpl2, f), MathHelpersKt.lerp(m1053getBlueimpl, m1053getBlueimpl2, f), MathHelpersKt.lerp(m1052getAlphaimpl, m1052getAlphaimpl2, f), oklab), Color.m1054getColorSpaceimpl(j2));
    }

    @Stable
    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m1072luminance8_81llA(long j) {
        Rgb m1054getColorSpaceimpl = Color.m1054getColorSpaceimpl(j);
        if (!ColorModel.equals-impl0(m1054getColorSpaceimpl.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.toString-impl(m1054getColorSpaceimpl.getModel-xdoWZVw()))).toString());
        }
        Intrinsics.checkNotNull(m1054getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = m1054getColorSpaceimpl.getEotfFunc$ui_graphics_release();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m1056getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m1055getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m1053getBlueimpl(j)) * 0.0722d)));
    }

    private static final float saturate(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    /* renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m1073takeOrElseDxMtmZc(long j, @NotNull Function0<Color> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Color.Companion.getUnspecified-0d7_KjU() ? 1 : (j == Color.Companion.getUnspecified-0d7_KjU() ? 0 : -1)) != 0 ? j : ((Color) function0.invoke()).m1060unboximpl();
    }

    @Stable
    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m1074toArgb8_81llA(long j) {
        ColorSpace m1054getColorSpaceimpl = Color.m1054getColorSpaceimpl(j);
        if (m1054getColorSpaceimpl.isSrgb()) {
            return (int) ULong.constructor-impl(j >>> 32);
        }
        float[] m1066getComponents8_81llA = m1066getComponents8_81llA(j);
        ColorSpaceKt.m1280connectYBCOT_4$default(m1054getColorSpaceimpl, null, 0, 3, null).transform(m1066getComponents8_81llA);
        return ((int) ((m1066getComponents8_81llA[2] * 255.0f) + 0.5f)) | (((int) ((m1066getComponents8_81llA[3] * 255.0f) + 0.5f)) << 24) | (((int) ((m1066getComponents8_81llA[0] * 255.0f) + 0.5f)) << 16) | (((int) ((m1066getComponents8_81llA[1] * 255.0f) + 0.5f)) << 8);
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    @Stable
    public static final long Color(int i) {
        return Color.m1046constructorimpl(ULong.constructor-impl(ULong.constructor-impl(i) << 32));
    }

    @Stable
    public static final long Color(long j) {
        return Color.m1046constructorimpl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(j) & 4294967295L) << 32));
    }

    @Stable
    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }
}
