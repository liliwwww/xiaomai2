package androidx.compose.animation.core;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Motion {
    private final long packedValue;

    private /* synthetic */ Motion(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Motion m72boximpl(long j) {
        return new Motion(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m73constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-XB9eQnU, reason: not valid java name */
    public static final long m74copyXB9eQnU(long j, float f, float f2) {
        return SpringSimulationKt.Motion(f, f2);
    }

    /* renamed from: copy-XB9eQnU$default, reason: not valid java name */
    public static /* synthetic */ long m75copyXB9eQnU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m78getValueimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m79getVelocityimpl(j);
        }
        return m74copyXB9eQnU(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m76equalsimpl(long j, Object obj) {
        return (obj instanceof Motion) && j == ((Motion) obj).m82unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m77equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m78getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getVelocity-impl, reason: not valid java name */
    public static final float m79getVelocityimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m80hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m81toStringimpl(long j) {
        return "Motion(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m76equalsimpl(this.packedValue, obj);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m80hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m81toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m82unboximpl() {
        return this.packedValue;
    }
}
