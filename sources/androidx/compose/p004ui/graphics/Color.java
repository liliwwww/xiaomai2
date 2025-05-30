package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.graphics.colorspace.ColorSpace;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p004ui.graphics.colorspace.Rgb;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class Color {
    private final long value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getBlack-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2798getBlack0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getBlue-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2799getBlue0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getCyan-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2800getCyan0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getDarkGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2801getDarkGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2802getGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getGreen-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2803getGreen0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getLightGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2804getLightGray0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getMagenta-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2805getMagenta0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getRed-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2806getRed0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getTransparent-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2807getTransparent0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2808getUnspecified0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getWhite-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2809getWhite0d7_KjU$annotations() {
        }

        @Stable
        /* renamed from: getYellow-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m2810getYellow0d7_KjU$annotations() {
        }

        /* renamed from: hsl-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m2811hslJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            float f5 = (i & 8) != 0 ? 1.0f : f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m2826hslJlNiLsg(f, f2, f3, f5, rgb);
        }

        private final float hslToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (i + (f / 30.0f)) % 12.0f;
            return f3 - ((f2 * Math.min(f3, 1.0f - f3)) * Math.max(-1.0f, Math.min(f4 - 3, Math.min(9 - f4, 1.0f))));
        }

        /* renamed from: hsv-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m2812hsvJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            float f5 = (i & 8) != 0 ? 1.0f : f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m2827hsvJlNiLsg(f, f2, f3, f5, rgb);
        }

        private final float hsvToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (i + (f / 60.0f)) % 6.0f;
            return f3 - ((f2 * f3) * Math.max(0.0f, Math.min(f4, Math.min(4 - f4, 1.0f))));
        }

        /* renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m2813getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m2814getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getCyan-0d7_KjU, reason: not valid java name */
        public final long m2815getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
        public final long m2816getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU, reason: not valid java name */
        public final long m2817getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getGreen-0d7_KjU, reason: not valid java name */
        public final long m2818getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getLightGray-0d7_KjU, reason: not valid java name */
        public final long m2819getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getMagenta-0d7_KjU, reason: not valid java name */
        public final long m2820getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m2821getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m2822getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m2823getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m2824getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getYellow-0d7_KjU, reason: not valid java name */
        public final long m2825getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        
            if ((0.0f <= r8 && r8 <= 1.0f) != false) goto L25;
         */
        /* renamed from: hsl-JlNiLsg, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final long m2826hslJlNiLsg(float r6, float r7, float r8, float r9, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.graphics.colorspace.Rgb r10) {
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
                long r6 = androidx.compose.p004ui.graphics.ColorKt.Color(r0, r1, r6, r9, r10)
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Color.Companion.m2826hslJlNiLsg(float, float, float, float, androidx.compose.ui.graphics.colorspace.Rgb):long");
        }

        /* renamed from: hsv-JlNiLsg, reason: not valid java name */
        public final long m2827hsvJlNiLsg(float f, float f2, float f3, float f4, @NotNull Rgb rgb) {
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

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m2777boximpl(long j) {
        return new Color(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2778component1impl(long j) {
        return m2793getRedimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2779component2impl(long j) {
        return m2792getGreenimpl(j);
    }

    @Stable
    /* renamed from: component3-impl, reason: not valid java name */
    public static final float m2780component3impl(long j) {
        return m2790getBlueimpl(j);
    }

    @Stable
    /* renamed from: component4-impl, reason: not valid java name */
    public static final float m2781component4impl(long j) {
        return m2789getAlphaimpl(j);
    }

    @Stable
    @NotNull
    /* renamed from: component5-impl, reason: not valid java name */
    public static final ColorSpace m2782component5impl(long j) {
        return m2791getColorSpaceimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2783constructorimpl(long j) {
        return j;
    }

    /* renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m2784convertvNxB06k(long j, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        ColorSpace m2791getColorSpaceimpl = m2791getColorSpaceimpl(j);
        return Intrinsics.areEqual(colorSpace, m2791getColorSpaceimpl) ? j : ColorSpaceKt.m3158connectYBCOT_4$default(m2791getColorSpaceimpl, colorSpace, 0, 2, null).mo3160transformToColorwmQWz5c$ui_graphics_release(m2793getRedimpl(j), m2792getGreenimpl(j), m2790getBlueimpl(j), m2789getAlphaimpl(j));
    }

    @Stable
    /* renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m2785copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m2791getColorSpaceimpl(j));
    }

    /* renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m2786copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2789getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m2793getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m2792getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m2790getBlueimpl(j);
        }
        return m2785copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2787equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m2797unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2788equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getAlpha$annotations() {
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m2789getAlphaimpl(long j) {
        float ulongToDouble;
        float f;
        if (ULong.constructor-impl(63 & j) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return ulongToDouble / f;
    }

    @Stable
    public static /* synthetic */ void getBlue$annotations() {
    }

    /* renamed from: getBlue-impl, reason: not valid java name */
    public static final float m2790getBlueimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 255))) / 255.0f : Float16.m2907toFloatimpl(Float16.m2891constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 16) & 65535)));
    }

    @Stable
    public static /* synthetic */ void getColorSpace$annotations() {
    }

    @NotNull
    /* renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m2791getColorSpaceimpl(long j) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.constructor-impl(j & 63)];
    }

    @Stable
    public static /* synthetic */ void getGreen$annotations() {
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final float m2792getGreenimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 40) & 255))) / 255.0f : Float16.m2907toFloatimpl(Float16.m2891constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 65535)));
    }

    @Stable
    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final float m2793getRedimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 255))) / 255.0f : Float16.m2907toFloatimpl(Float16.m2891constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 65535)));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2794hashCodeimpl(long j) {
        return ULong.hashCode-impl(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2795toStringimpl(long j) {
        return "Color(" + m2793getRedimpl(j) + ", " + m2792getGreenimpl(j) + ", " + m2790getBlueimpl(j) + ", " + m2789getAlphaimpl(j) + ", " + m2791getColorSpaceimpl(j).getName() + ')';
    }

    public boolean equals(Object obj) {
        return m2787equalsimpl(this.value, obj);
    }

    /* renamed from: getValue-s-VKNKU, reason: not valid java name */
    public final long m2796getValuesVKNKU() {
        return this.value;
    }

    public int hashCode() {
        return m2794hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2795toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2797unboximpl() {
        return this.value;
    }
}
