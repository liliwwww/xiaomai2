package androidx.compose.ui.unit;

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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Velocity {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m2701boximpl(long j) {
        return new Velocity(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2702component1impl(long j) {
        return m2710getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2703component2impl(long j) {
        return m2711getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2704constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m2705copyOhffZ5M(long j, float f, float f2) {
        return VelocityKt.Velocity(f, f2);
    }

    /* renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m2706copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2710getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2711getYimpl(j);
        }
        return m2705copyOhffZ5M(j, f, f2);
    }

    @Stable
    /* renamed from: div-adjELrA, reason: not valid java name */
    public static final long m2707divadjELrA(long j, float f) {
        return VelocityKt.Velocity(m2710getXimpl(j) / f, m2711getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2708equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m2719unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2709equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m2710getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m2711getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2712hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m2713minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m2710getXimpl(j) - m2710getXimpl(j2), m2711getYimpl(j) - m2711getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m2714plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m2710getXimpl(j) + m2710getXimpl(j2), m2711getYimpl(j) + m2711getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m2715remadjELrA(long j, float f) {
        return VelocityKt.Velocity(m2710getXimpl(j) % f, m2711getYimpl(j) % f);
    }

    @Stable
    /* renamed from: times-adjELrA, reason: not valid java name */
    public static final long m2716timesadjELrA(long j, float f) {
        return VelocityKt.Velocity(m2710getXimpl(j) * f, m2711getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2717toStringimpl(long j) {
        return '(' + m2710getXimpl(j) + ", " + m2711getYimpl(j) + ") px/sec";
    }

    @Stable
    /* renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m2718unaryMinus9UxMQ8M(long j) {
        return VelocityKt.Velocity(-m2710getXimpl(j), -m2711getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m2708equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2712hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2717toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2719unboximpl() {
        return this.packedValue;
    }
}
