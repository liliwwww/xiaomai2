package androidx.compose.ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ColorModel {
    private static final long Cmyk;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCmyk-xdoWZVw, reason: not valid java name */
        public final long m1240getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }

        /* renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m1241getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m1242getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m1243getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m1233constructorimpl((0 & 4294967295L) | j2);
        Xyz = m1233constructorimpl((1 & 4294967295L) | j2);
        Lab = m1233constructorimpl(j2 | (2 & 4294967295L));
        Cmyk = m1233constructorimpl((j & 4294967295L) | (4 << 32));
    }

    private /* synthetic */ ColorModel(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorModel m1232boximpl(long j) {
        return new ColorModel(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1233constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1234equalsimpl(long j, Object obj) {
        return (obj instanceof ColorModel) && j == ((ColorModel) obj).m1239unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1235equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m1236getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1237hashCodeimpl(long j) {
        return c8.a(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1238toStringimpl(long j) {
        return m1235equalsimpl0(j, Rgb) ? "Rgb" : m1235equalsimpl0(j, Xyz) ? "Xyz" : m1235equalsimpl0(j, Lab) ? "Lab" : m1235equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1234equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1237hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1238toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1239unboximpl() {
        return this.packedValue;
    }
}
