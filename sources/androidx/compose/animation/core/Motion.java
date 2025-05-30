package androidx.compose.animation.core;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class Motion {
    private final long packedValue;

    private /* synthetic */ Motion(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Motion m1054boximpl(long j) {
        return new Motion(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1055constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-XB9eQnU, reason: not valid java name */
    public static final long m1056copyXB9eQnU(long j, float f, float f2) {
        return SpringSimulationKt.Motion(f, f2);
    }

    /* renamed from: copy-XB9eQnU$default, reason: not valid java name */
    public static /* synthetic */ long m1057copyXB9eQnU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1060getValueimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m1061getVelocityimpl(j);
        }
        return m1056copyXB9eQnU(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1058equalsimpl(long j, Object obj) {
        return (obj instanceof Motion) && j == ((Motion) obj).m1064unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1059equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m1060getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getVelocity-impl, reason: not valid java name */
    public static final float m1061getVelocityimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1062hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1063toStringimpl(long j) {
        return "Motion(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1058equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m1062hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1063toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1064unboximpl() {
        return this.packedValue;
    }
}
