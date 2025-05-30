package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Color$Companion {
    private Color$Companion() {
    }

    public /* synthetic */ Color$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Stable
    /* renamed from: getBlack-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1059getBlack0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getBlue-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1060getBlue0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getCyan-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1061getCyan0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getDarkGray-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1062getDarkGray0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getGray-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1063getGray0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getGreen-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1064getGreen0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getLightGray-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1065getLightGray0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getMagenta-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1066getMagenta0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getRed-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1067getRed0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getTransparent-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1068getTransparent0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getUnspecified-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1069getUnspecified0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getWhite-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1070getWhite0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getYellow-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1071getYellow0d7_KjU$annotations() {
    }

    /* renamed from: hsl-JlNiLsg$default, reason: not valid java name */
    public static /* synthetic */ long m1072hslJlNiLsg$default(Color$Companion color$Companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
        float f5 = (i & 8) != 0 ? 1.0f : f4;
        if ((i & 16) != 0) {
            rgb = ColorSpaces.INSTANCE.getSrgb();
        }
        return color$Companion.m1087hslJlNiLsg(f, f2, f3, f5, rgb);
    }

    private final float hslToRgbComponent(int i, float f, float f2, float f3) {
        float f4 = (i + (f / 30.0f)) % 12.0f;
        return f3 - ((f2 * Math.min(f3, 1.0f - f3)) * Math.max(-1.0f, Math.min(f4 - 3, Math.min(9 - f4, 1.0f))));
    }

    /* renamed from: hsv-JlNiLsg$default, reason: not valid java name */
    public static /* synthetic */ long m1073hsvJlNiLsg$default(Color$Companion color$Companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
        float f5 = (i & 8) != 0 ? 1.0f : f4;
        if ((i & 16) != 0) {
            rgb = ColorSpaces.INSTANCE.getSrgb();
        }
        return color$Companion.m1088hsvJlNiLsg(f, f2, f3, f5, rgb);
    }

    private final float hsvToRgbComponent(int i, float f, float f2, float f3) {
        float f4 = (i + (f / 60.0f)) % 6.0f;
        return f3 - ((f2 * f3) * Math.max(0.0f, Math.min(f4, Math.min(4 - f4, 1.0f))));
    }

    /* renamed from: getBlack-0d7_KjU, reason: not valid java name */
    public final long m1074getBlack0d7_KjU() {
        return Color.access$getBlack$cp();
    }

    /* renamed from: getBlue-0d7_KjU, reason: not valid java name */
    public final long m1075getBlue0d7_KjU() {
        return Color.access$getBlue$cp();
    }

    /* renamed from: getCyan-0d7_KjU, reason: not valid java name */
    public final long m1076getCyan0d7_KjU() {
        return Color.access$getCyan$cp();
    }

    /* renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
    public final long m1077getDarkGray0d7_KjU() {
        return Color.access$getDarkGray$cp();
    }

    /* renamed from: getGray-0d7_KjU, reason: not valid java name */
    public final long m1078getGray0d7_KjU() {
        return Color.access$getGray$cp();
    }

    /* renamed from: getGreen-0d7_KjU, reason: not valid java name */
    public final long m1079getGreen0d7_KjU() {
        return Color.access$getGreen$cp();
    }

    /* renamed from: getLightGray-0d7_KjU, reason: not valid java name */
    public final long m1080getLightGray0d7_KjU() {
        return Color.access$getLightGray$cp();
    }

    /* renamed from: getMagenta-0d7_KjU, reason: not valid java name */
    public final long m1081getMagenta0d7_KjU() {
        return Color.access$getMagenta$cp();
    }

    /* renamed from: getRed-0d7_KjU, reason: not valid java name */
    public final long m1082getRed0d7_KjU() {
        return Color.access$getRed$cp();
    }

    /* renamed from: getTransparent-0d7_KjU, reason: not valid java name */
    public final long m1083getTransparent0d7_KjU() {
        return Color.access$getTransparent$cp();
    }

    /* renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
    public final long m1084getUnspecified0d7_KjU() {
        return Color.access$getUnspecified$cp();
    }

    /* renamed from: getWhite-0d7_KjU, reason: not valid java name */
    public final long m1085getWhite0d7_KjU() {
        return Color.access$getWhite$cp();
    }

    /* renamed from: getYellow-0d7_KjU, reason: not valid java name */
    public final long m1086getYellow0d7_KjU() {
        return Color.access$getYellow$cp();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if ((0.0f <= r8 && r8 <= 1.0f) != false) goto L25;
     */
    /* renamed from: hsl-JlNiLsg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m1087hslJlNiLsg(float r6, float r7, float r8, float r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.Rgb r10) {
        /*
            r5 = this;
            java.lang.String r0 = "colorSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 > 0) goto L14
            r3 = 1135869952(0x43b40000, float:360.0)
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 > 0) goto L14
            r3 = 1
            goto L15
        L14:
            r3 = 0
        L15:
            if (r3 == 0) goto L34
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 > 0) goto L23
            int r4 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r4 > 0) goto L23
            r4 = 1
            goto L24
        L23:
            r4 = 0
        L24:
            if (r4 == 0) goto L34
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L30
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 > 0) goto L30
            r0 = 1
            goto L31
        L30:
            r0 = 0
        L31:
            if (r0 == 0) goto L34
            goto L35
        L34:
            r1 = 0
        L35:
            if (r1 == 0) goto L4b
            float r0 = r5.hslToRgbComponent(r2, r6, r7, r8)
            r1 = 8
            float r1 = r5.hslToRgbComponent(r1, r6, r7, r8)
            r2 = 4
            float r6 = r5.hslToRgbComponent(r2, r6, r7, r8)
            long r6 = androidx.compose.ui.graphics.ColorKt.Color(r0, r1, r6, r9, r10)
            return r6
        L4b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "HSL ("
            r9.append(r10)
            r9.append(r6)
            java.lang.String r6 = ", "
            r9.append(r6)
            r9.append(r7)
            r9.append(r6)
            r9.append(r8)
            java.lang.String r6 = ") must be in range (0..360, 0..1, 0..1)"
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Color$Companion.m1087hslJlNiLsg(float, float, float, float, androidx.compose.ui.graphics.colorspace.Rgb):long");
    }

    /* renamed from: hsv-JlNiLsg, reason: not valid java name */
    public final long m1088hsvJlNiLsg(float f, float f2, float f3, float f4, @NotNull Rgb rgb) {
        Intrinsics.checkNotNullParameter(rgb, "colorSpace");
        boolean z = false;
        if (0.0f <= f && f <= 360.0f) {
            if (0.0f <= f2 && f2 <= 1.0f) {
                if (0.0f <= f3 && f3 <= 1.0f) {
                    z = true;
                }
            }
        }
        if (z) {
            return ColorKt.Color(hsvToRgbComponent(5, f, f2, f3), hsvToRgbComponent(3, f, f2, f3), hsvToRgbComponent(1, f, f2, f3), f4, rgb);
        }
        throw new IllegalArgumentException(("HSV (" + f + ", " + f2 + ", " + f3 + ") must be in range (0..360, 0..1, 0..1)").toString());
    }
}
