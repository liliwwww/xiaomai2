package androidx.compose.ui.geometry;

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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Offset {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m837boximpl(long j) {
        return new Offset(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m838component1impl(long j) {
        return m848getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m839component2impl(long j) {
        return m849getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m840constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m841copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m842copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m848getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m849getYimpl(j);
        }
        return m841copydBAh8RU(j, f, f2);
    }

    @Stable
    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m843divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m848getXimpl(j) / f, m849getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m844equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m858unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m845equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m846getDistanceimpl(long j) {
        return (float) Math.sqrt((m848getXimpl(j) * m848getXimpl(j)) + (m849getYimpl(j) * m849getYimpl(j)));
    }

    @Stable
    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m847getDistanceSquaredimpl(long j) {
        return (m848getXimpl(j) * m848getXimpl(j)) + (m849getYimpl(j) * m849getYimpl(j));
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m848getXimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m849getYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m850hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m851isValidimpl(long j) {
        if ((Float.isNaN(m848getXimpl(j)) || Float.isNaN(m849getYimpl(j))) ? false : true) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    @Stable
    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m852minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m848getXimpl(j) - m848getXimpl(j2), m849getYimpl(j) - m849getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m853plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m848getXimpl(j) + m848getXimpl(j2), m849getYimpl(j) + m849getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m854remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m848getXimpl(j) % f, m849getYimpl(j) % f);
    }

    @Stable
    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m855timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m848getXimpl(j) * f, m849getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m856toStringimpl(long j) {
        if (!OffsetKt.isSpecified-k-4lQ0M(j)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m848getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m849getYimpl(j), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m857unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m848getXimpl(j), -m849getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m844equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m850hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m856toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m858unboximpl() {
        return this.packedValue;
    }
}
