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
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2631getUnspecifiedNHjbRc$annotations() {
        }

        @Stable
        /* renamed from: getZero-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2632getZeroNHjbRc$annotations() {
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m2633getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m2634getZeroNHjbRc() {
            return Size.Zero;
        }
    }

    private /* synthetic */ Size(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m2613boximpl(long j) {
        return new Size(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2614component1impl(long j) {
        return m2625getWidthimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2615component2impl(long j) {
        return m2622getHeightimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2616constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m2617copyxjbvk4A(long j, float f, float f2) {
        return SizeKt.Size(f, f2);
    }

    /* renamed from: copy-xjbvk4A$default, reason: not valid java name */
    public static /* synthetic */ long m2618copyxjbvk4A$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2625getWidthimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2622getHeightimpl(j);
        }
        return m2617copyxjbvk4A(j, f, f2);
    }

    @Stable
    /* renamed from: div-7Ah8Wj8, reason: not valid java name */
    public static final long m2619div7Ah8Wj8(long j, float f) {
        return SizeKt.Size(m2625getWidthimpl(j) / f, m2622getHeightimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2620equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).m2630unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2621equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m2622getHeightimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    @Stable
    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    /* renamed from: getMaxDimension-impl, reason: not valid java name */
    public static final float m2623getMaxDimensionimpl(long j) {
        return Math.max(Math.abs(m2625getWidthimpl(j)), Math.abs(m2622getHeightimpl(j)));
    }

    @Stable
    public static /* synthetic */ void getMinDimension$annotations() {
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m2624getMinDimensionimpl(long j) {
        return Math.min(Math.abs(m2625getWidthimpl(j)), Math.abs(m2622getHeightimpl(j)));
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m2625getWidthimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2626hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m2627isEmptyimpl(long j) {
        return m2625getWidthimpl(j) <= 0.0f || m2622getHeightimpl(j) <= 0.0f;
    }

    @Stable
    /* renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m2628times7Ah8Wj8(long j, float f) {
        return SizeKt.Size(m2625getWidthimpl(j) * f, m2622getHeightimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2629toStringimpl(long j) {
        if (!(j != Companion.m2633getUnspecifiedNHjbRc())) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(m2625getWidthimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m2622getHeightimpl(j), 1) + ')';
    }

    public boolean equals(Object obj) {
        return m2620equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2626hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2629toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2630unboximpl() {
        return this.packedValue;
    }
}
