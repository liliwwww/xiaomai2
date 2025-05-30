package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Color {
    private final long value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
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

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m1040boximpl(long j) {
        return new Color(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m1041component1impl(long j) {
        return m1056getRedimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m1042component2impl(long j) {
        return m1055getGreenimpl(j);
    }

    @Stable
    /* renamed from: component3-impl, reason: not valid java name */
    public static final float m1043component3impl(long j) {
        return m1053getBlueimpl(j);
    }

    @Stable
    /* renamed from: component4-impl, reason: not valid java name */
    public static final float m1044component4impl(long j) {
        return m1052getAlphaimpl(j);
    }

    @Stable
    @NotNull
    /* renamed from: component5-impl, reason: not valid java name */
    public static final ColorSpace m1045component5impl(long j) {
        return m1054getColorSpaceimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1046constructorimpl(long j) {
        return j;
    }

    /* renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m1047convertvNxB06k(long j, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        ColorSpace m1054getColorSpaceimpl = m1054getColorSpaceimpl(j);
        return Intrinsics.areEqual(colorSpace, m1054getColorSpaceimpl) ? j : ColorSpaceKt.m1280connectYBCOT_4$default(m1054getColorSpaceimpl, colorSpace, 0, 2, null).mo1282transformToColorwmQWz5c$ui_graphics_release(m1056getRedimpl(j), m1055getGreenimpl(j), m1053getBlueimpl(j), m1052getAlphaimpl(j));
    }

    @Stable
    /* renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m1048copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m1054getColorSpaceimpl(j));
    }

    /* renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m1049copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1052getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m1056getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m1055getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m1053getBlueimpl(j);
        }
        return m1048copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1050equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m1060unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1051equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getAlpha$annotations() {
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m1052getAlphaimpl(long j) {
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
    public static final float m1053getBlueimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 255))) / 255.0f : Float16.m1111toFloatimpl(Float16.m1095constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 16) & 65535)));
    }

    @Stable
    public static /* synthetic */ void getColorSpace$annotations() {
    }

    @NotNull
    /* renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m1054getColorSpaceimpl(long j) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.constructor-impl(j & 63)];
    }

    @Stable
    public static /* synthetic */ void getGreen$annotations() {
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final float m1055getGreenimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 40) & 255))) / 255.0f : Float16.m1111toFloatimpl(Float16.m1095constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 32) & 65535)));
    }

    @Stable
    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final float m1056getRedimpl(long j) {
        return ULong.constructor-impl(63 & j) == 0 ? ((float) UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 255))) / 255.0f : Float16.m1111toFloatimpl(Float16.m1095constructorimpl((short) ULong.constructor-impl(ULong.constructor-impl(j >>> 48) & 65535)));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1057hashCodeimpl(long j) {
        return ULong.hashCode-impl(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1058toStringimpl(long j) {
        return "Color(" + m1056getRedimpl(j) + ", " + m1055getGreenimpl(j) + ", " + m1053getBlueimpl(j) + ", " + m1052getAlphaimpl(j) + ", " + m1054getColorSpaceimpl(j).getName() + ')';
    }

    public boolean equals(Object obj) {
        return m1050equalsimpl(this.value, obj);
    }

    /* renamed from: getValue-s-VKNKU, reason: not valid java name */
    public final long m1059getValuesVKNKU() {
        return this.value;
    }

    public int hashCode() {
        return m1057hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1058toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1060unboximpl() {
        return this.value;
    }
}
