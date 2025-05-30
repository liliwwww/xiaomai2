package androidx.compose.p004ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
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
        public final long m3151getCmykxdoWZVw() {
            return ColorModel.Cmyk;
        }

        /* renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m3152getLabxdoWZVw() {
            return ColorModel.Lab;
        }

        /* renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m3153getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m3154getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m3144constructorimpl((0 & 4294967295L) | j2);
        Xyz = m3144constructorimpl((1 & 4294967295L) | j2);
        Lab = m3144constructorimpl(j2 | (2 & 4294967295L));
        Cmyk = m3144constructorimpl((j & 4294967295L) | (4 << 32));
    }

    private /* synthetic */ ColorModel(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorModel m3143boximpl(long j) {
        return new ColorModel(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3144constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3145equalsimpl(long j, Object obj) {
        return (obj instanceof ColorModel) && j == ((ColorModel) obj).m3150unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3146equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getComponentCount$annotations() {
    }

    /* renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m3147getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3148hashCodeimpl(long j) {
        return c8.a(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3149toStringimpl(long j) {
        return m3146equalsimpl0(j, Rgb) ? "Rgb" : m3146equalsimpl0(j, Xyz) ? "Xyz" : m3146equalsimpl0(j, Lab) ? "Lab" : m3146equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3145equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3148hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3149toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3150unboximpl() {
        return this.packedValue;
    }
}
