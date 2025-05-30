package androidx.compose.p004ui.node;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
final class DistanceAndInLayer {
    private final long packedValue;

    private /* synthetic */ DistanceAndInLayer(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndInLayer m4296boximpl(long j) {
        return new DistanceAndInLayer(j);
    }

    /* renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m4297compareToS_HNhKs(long j, long j2) {
        boolean m4303isInLayerimpl = m4303isInLayerimpl(j);
        return m4303isInLayerimpl != m4303isInLayerimpl(j2) ? m4303isInLayerimpl ? -1 : 1 : (int) Math.signum(m4301getDistanceimpl(j) - m4301getDistanceimpl(j2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4298constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4299equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndInLayer) && j == ((DistanceAndInLayer) obj).m4305unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4300equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m4301getDistanceimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4302hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m4303isInLayerimpl(long j) {
        return ((int) (j & 4294967295L)) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4304toStringimpl(long j) {
        return "DistanceAndInLayer(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m4299equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m4302hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4304toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4305unboximpl() {
        return this.packedValue;
    }
}
