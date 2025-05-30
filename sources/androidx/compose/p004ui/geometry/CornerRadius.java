package androidx.compose.p004ui.geometry;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class CornerRadius {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getZero-kKHJgLs$annotations, reason: not valid java name */
        public static /* synthetic */ void m2540getZerokKHJgLs$annotations() {
        }

        /* renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m2541getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    private /* synthetic */ CornerRadius(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CornerRadius m2522boximpl(long j) {
        return new CornerRadius(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2523component1impl(long j) {
        return m2531getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2524component2impl(long j) {
        return m2532getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2525constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-OHQCggk, reason: not valid java name */
    public static final long m2526copyOHQCggk(long j, float f, float f2) {
        return CornerRadiusKt.CornerRadius(f, f2);
    }

    /* renamed from: copy-OHQCggk$default, reason: not valid java name */
    public static /* synthetic */ long m2527copyOHQCggk$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2531getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2532getYimpl(j);
        }
        return m2526copyOHQCggk(j, f, f2);
    }

    @Stable
    /* renamed from: div-Bz7bX_o, reason: not valid java name */
    public static final long m2528divBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m2531getXimpl(j) / f, m2532getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2529equalsimpl(long j, Object obj) {
        return (obj instanceof CornerRadius) && j == ((CornerRadius) obj).m2539unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2530equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m2531getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m2532getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2533hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-vF7b-mM, reason: not valid java name */
    public static final long m2534minusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m2531getXimpl(j) - m2531getXimpl(j2), m2532getYimpl(j) - m2532getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-vF7b-mM, reason: not valid java name */
    public static final long m2535plusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m2531getXimpl(j) + m2531getXimpl(j2), m2532getYimpl(j) + m2532getYimpl(j2));
    }

    @Stable
    /* renamed from: times-Bz7bX_o, reason: not valid java name */
    public static final long m2536timesBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m2531getXimpl(j) * f, m2532getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2537toStringimpl(long j) {
        if (m2531getXimpl(j) == m2532getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m2531getXimpl(j), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m2531getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m2532getYimpl(j), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-kKHJgLs, reason: not valid java name */
    public static final long m2538unaryMinuskKHJgLs(long j) {
        return CornerRadiusKt.CornerRadius(-m2531getXimpl(j), -m2532getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m2529equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2533hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2537toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2539unboximpl() {
        return this.packedValue;
    }
}
