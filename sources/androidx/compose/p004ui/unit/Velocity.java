package androidx.compose.p004ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class Velocity {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getZero-9UxMQ8M$annotations, reason: not valid java name */
        public static /* synthetic */ void m5451getZero9UxMQ8M$annotations() {
        }

        /* renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m5452getZero9UxMQ8M() {
            return Velocity.Zero;
        }
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m5432boximpl(long j) {
        return new Velocity(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m5433component1impl(long j) {
        return m5441getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m5434component2impl(long j) {
        return m5442getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5435constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m5436copyOhffZ5M(long j, float f, float f2) {
        return VelocityKt.Velocity(f, f2);
    }

    /* renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m5437copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5441getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m5442getYimpl(j);
        }
        return m5436copyOhffZ5M(j, f, f2);
    }

    @Stable
    /* renamed from: div-adjELrA, reason: not valid java name */
    public static final long m5438divadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5441getXimpl(j) / f, m5442getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5439equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m5450unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5440equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m5441getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m5442getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5443hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m5444minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m5441getXimpl(j) - m5441getXimpl(j2), m5442getYimpl(j) - m5442getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m5445plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m5441getXimpl(j) + m5441getXimpl(j2), m5442getYimpl(j) + m5442getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m5446remadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5441getXimpl(j) % f, m5442getYimpl(j) % f);
    }

    @Stable
    /* renamed from: times-adjELrA, reason: not valid java name */
    public static final long m5447timesadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5441getXimpl(j) * f, m5442getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5448toStringimpl(long j) {
        return '(' + m5441getXimpl(j) + ", " + m5442getYimpl(j) + ") px/sec";
    }

    @Stable
    /* renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m5449unaryMinus9UxMQ8M(long j) {
        return VelocityKt.Velocity(-m5441getXimpl(j), -m5442getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m5439equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5443hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m5448toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5450unboximpl() {
        return this.packedValue;
    }
}
