package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.graphics.colorspace.ColorModel;
import androidx.compose.p004ui.graphics.colorspace.ColorSpace;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p004ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p004ui.graphics.colorspace.Rgb;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014d  */
    @androidx.compose.runtime.Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long Color(float r9, float r10, float r11, float r12, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.graphics.colorspace.ColorSpace r13) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
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
    public static final long m2832compositeOverOWjLjI(long j, long j2) {
        long m2784convertvNxB06k = Color.m2784convertvNxB06k(j, Color.m2791getColorSpaceimpl(j2));
        float m2789getAlphaimpl = Color.m2789getAlphaimpl(j2);
        float m2789getAlphaimpl2 = Color.m2789getAlphaimpl(m2784convertvNxB06k);
        float f = 1.0f - m2789getAlphaimpl2;
        float f2 = (m2789getAlphaimpl * f) + m2789getAlphaimpl2;
        return Color((f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m2793getRedimpl(m2784convertvNxB06k) * m2789getAlphaimpl2) + ((Color.m2793getRedimpl(j2) * m2789getAlphaimpl) * f)) / f2, (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m2792getGreenimpl(m2784convertvNxB06k) * m2789getAlphaimpl2) + ((Color.m2792getGreenimpl(j2) * m2789getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m2790getBlueimpl(m2784convertvNxB06k) * m2789getAlphaimpl2) + ((Color.m2790getBlueimpl(j2) * m2789getAlphaimpl) * f)) / f2, f2, Color.m2791getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m2833getComponents8_81llA(long j) {
        return new float[]{Color.m2793getRedimpl(j), Color.m2792getGreenimpl(j), Color.m2790getBlueimpl(j), Color.m2789getAlphaimpl(j)};
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m2834isSpecified8_81llA(long j) {
        return j != Color.Companion.m2823getUnspecified0d7_KjU();
    }

    @Stable
    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m2835isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m2836isUnspecified8_81llA(long j) {
        return j == Color.Companion.m2823getUnspecified0d7_KjU();
    }

    @Stable
    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m2837isUnspecified8_81llA$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m2838lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m2784convertvNxB06k = Color.m2784convertvNxB06k(j, oklab);
        long m2784convertvNxB06k2 = Color.m2784convertvNxB06k(j2, oklab);
        float m2789getAlphaimpl = Color.m2789getAlphaimpl(m2784convertvNxB06k);
        float m2793getRedimpl = Color.m2793getRedimpl(m2784convertvNxB06k);
        float m2792getGreenimpl = Color.m2792getGreenimpl(m2784convertvNxB06k);
        float m2790getBlueimpl = Color.m2790getBlueimpl(m2784convertvNxB06k);
        float m2789getAlphaimpl2 = Color.m2789getAlphaimpl(m2784convertvNxB06k2);
        float m2793getRedimpl2 = Color.m2793getRedimpl(m2784convertvNxB06k2);
        float m2792getGreenimpl2 = Color.m2792getGreenimpl(m2784convertvNxB06k2);
        float m2790getBlueimpl2 = Color.m2790getBlueimpl(m2784convertvNxB06k2);
        return Color.m2784convertvNxB06k(Color(MathHelpersKt.lerp(m2793getRedimpl, m2793getRedimpl2, f), MathHelpersKt.lerp(m2792getGreenimpl, m2792getGreenimpl2, f), MathHelpersKt.lerp(m2790getBlueimpl, m2790getBlueimpl2, f), MathHelpersKt.lerp(m2789getAlphaimpl, m2789getAlphaimpl2, f), oklab), Color.m2791getColorSpaceimpl(j2));
    }

    @Stable
    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m2839luminance8_81llA(long j) {
        ColorSpace m2791getColorSpaceimpl = Color.m2791getColorSpaceimpl(j);
        if (!ColorModel.m3146equalsimpl0(m2791getColorSpaceimpl.m3155getModelxdoWZVw(), ColorModel.Companion.m3153getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m3149toStringimpl(m2791getColorSpaceimpl.m3155getModelxdoWZVw()))).toString());
        }
        Intrinsics.checkNotNull(m2791getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) m2791getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m2793getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m2792getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m2790getBlueimpl(j)) * 0.0722d)));
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
    public static final long m2840takeOrElseDxMtmZc(long j, @NotNull Function0<Color> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Color.Companion.m2823getUnspecified0d7_KjU() ? 1 : (j == Color.Companion.m2823getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? j : ((Color) function0.invoke()).m2797unboximpl();
    }

    @Stable
    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m2841toArgb8_81llA(long j) {
        ColorSpace m2791getColorSpaceimpl = Color.m2791getColorSpaceimpl(j);
        if (m2791getColorSpaceimpl.isSrgb()) {
            return (int) ULong.constructor-impl(j >>> 32);
        }
        float[] m2833getComponents8_81llA = m2833getComponents8_81llA(j);
        ColorSpaceKt.m3158connectYBCOT_4$default(m2791getColorSpaceimpl, null, 0, 3, null).transform(m2833getComponents8_81llA);
        return ((int) ((m2833getComponents8_81llA[2] * 255.0f) + 0.5f)) | (((int) ((m2833getComponents8_81llA[3] * 255.0f) + 0.5f)) << 24) | (((int) ((m2833getComponents8_81llA[0] * 255.0f) + 0.5f)) << 16) | (((int) ((m2833getComponents8_81llA[1] * 255.0f) + 0.5f)) << 8);
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    @Stable
    public static final long Color(int i) {
        return Color.m2783constructorimpl(ULong.constructor-impl(ULong.constructor-impl(i) << 32));
    }

    @Stable
    public static final long Color(long j) {
        return Color.m2783constructorimpl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(j) & 4294967295L) << 32));
    }

    @Stable
    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }
}
