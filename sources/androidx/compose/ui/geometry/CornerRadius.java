package androidx.compose.ui.geometry;

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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CornerRadius {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, (Object) null);
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
        public static /* synthetic */ void m1015getZerokKHJgLs$annotations() {
        }

        /* renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m1016getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    private /* synthetic */ CornerRadius(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CornerRadius m997boximpl(long j) {
        return new CornerRadius(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m998component1impl(long j) {
        return m1006getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m999component2impl(long j) {
        return m1007getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1000constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-OHQCggk, reason: not valid java name */
    public static final long m1001copyOHQCggk(long j, float f, float f2) {
        return CornerRadiusKt.CornerRadius(f, f2);
    }

    /* renamed from: copy-OHQCggk$default, reason: not valid java name */
    public static /* synthetic */ long m1002copyOHQCggk$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1006getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m1007getYimpl(j);
        }
        return m1001copyOHQCggk(j, f, f2);
    }

    @Stable
    /* renamed from: div-Bz7bX_o, reason: not valid java name */
    public static final long m1003divBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m1006getXimpl(j) / f, m1007getYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1004equalsimpl(long j, Object obj) {
        return (obj instanceof CornerRadius) && j == ((CornerRadius) obj).m1014unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1005equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m1006getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m1007getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1008hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-vF7b-mM, reason: not valid java name */
    public static final long m1009minusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m1006getXimpl(j) - m1006getXimpl(j2), m1007getYimpl(j) - m1007getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-vF7b-mM, reason: not valid java name */
    public static final long m1010plusvF7bmM(long j, long j2) {
        return CornerRadiusKt.CornerRadius(m1006getXimpl(j) + m1006getXimpl(j2), m1007getYimpl(j) + m1007getYimpl(j2));
    }

    @Stable
    /* renamed from: times-Bz7bX_o, reason: not valid java name */
    public static final long m1011timesBz7bX_o(long j, float f) {
        return CornerRadiusKt.CornerRadius(m1006getXimpl(j) * f, m1007getYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1012toStringimpl(long j) {
        if (m1006getXimpl(j) == m1007getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m1006getXimpl(j), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m1006getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1007getYimpl(j), 1) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-kKHJgLs, reason: not valid java name */
    public static final long m1013unaryMinuskKHJgLs(long j) {
        return CornerRadiusKt.CornerRadius(-m1006getXimpl(j), -m1007getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m1004equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1008hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1012toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1014unboximpl() {
        return this.packedValue;
    }
}
