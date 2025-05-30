package androidx.compose.ui.node;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DistanceAndInLayer {
    private final long packedValue;

    private /* synthetic */ DistanceAndInLayer(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m2104boximpl(long j) {
        return new DistanceAndInLayer(j);
    }

    /* renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m2105compareToS_HNhKs(long j, long j2) {
        boolean m2111isInLayerimpl = m2111isInLayerimpl(j);
        return m2111isInLayerimpl != m2111isInLayerimpl(j2) ? m2111isInLayerimpl ? -1 : 1 : (int) Math.signum(m2109getDistanceimpl(j) - m2109getDistanceimpl(j2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2106constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2107equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j == ((DistanceAndInLayer) obj).m2113unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2108equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m2109getDistanceimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2110hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m2111isInLayerimpl(long j) {
        return ((int) (j & 4294967295L)) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2112toStringimpl(long j) {
        return "DistanceAndInLayer(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m2107equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m2110hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2112toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2113unboximpl() {
        return this.packedValue;
    }
}
