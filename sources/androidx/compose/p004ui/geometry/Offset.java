package androidx.compose.p004ui.geometry;

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
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2567getInfiniteF1C5BW0$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2568getUnspecifiedF1C5BW0$annotations() {
        }

        @Stable
        /* renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2569getZeroF1C5BW0$annotations() {
        }

        /* renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m2570getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m2571getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m2572getZeroF1C5BW0() {
            return Offset.Zero;
        }
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m2545boximpl(long j) {
        return new Offset(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2546component1impl(long j) {
        return m2556getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2547component2impl(long j) {
        return m2557getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2548constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m2549copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m2550copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2556getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2557getYimpl(j);
        }
        return m2549copydBAh8RU(j, f, f2);
    }

    @Stable
    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m2551divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2556getXimpl(j) / f, m2557getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2552equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m2566unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2553equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m2554getDistanceimpl(long j) {
        return (float) Math.sqrt((m2556getXimpl(j) * m2556getXimpl(j)) + (m2557getYimpl(j) * m2557getYimpl(j)));
    }

    @Stable
    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m2555getDistanceSquaredimpl(long j) {
        return (m2556getXimpl(j) * m2556getXimpl(j)) + (m2557getYimpl(j) * m2557getYimpl(j));
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m2556getXimpl(long j) {
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
    public static final float m2557getYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Offset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2558hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m2559isValidimpl(long j) {
        if ((Float.isNaN(m2556getXimpl(j)) || Float.isNaN(m2557getYimpl(j))) ? false : true) {
            return true;
        }
        throw new IllegalStateException("Offset argument contained a NaN value.".toString());
    }

    @Stable
    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m2560minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2556getXimpl(j) - m2556getXimpl(j2), m2557getYimpl(j) - m2557getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m2561plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2556getXimpl(j) + m2556getXimpl(j2), m2557getYimpl(j) + m2557getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m2562remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2556getXimpl(j) % f, m2557getYimpl(j) % f);
    }

    @Stable
    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m2563timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2556getXimpl(j) * f, m2557getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2564toStringimpl(long j) {
        if (!OffsetKt.m2575isSpecifiedk4lQ0M(j)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m2556getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m2557getYimpl(j), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m2565unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m2556getXimpl(j), -m2557getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m2552equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2558hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2564toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2566unboximpl() {
        return this.packedValue;
    }
}
