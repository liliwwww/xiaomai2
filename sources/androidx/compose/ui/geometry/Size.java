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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
        public static /* synthetic */ void m909getUnspecifiedNHjbRc$annotations() {
        }

        @Stable
        /* renamed from: getZero-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m910getZeroNHjbRc$annotations() {
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m911getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m912getZeroNHjbRc() {
            return Size.Zero;
        }
    }

    private /* synthetic */ Size(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m891boximpl(long j) {
        return new Size(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m892component1impl(long j) {
        return m903getWidthimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m893component2impl(long j) {
        return m900getHeightimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m894constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m895copyxjbvk4A(long j, float f, float f2) {
        return SizeKt.Size(f, f2);
    }

    /* renamed from: copy-xjbvk4A$default, reason: not valid java name */
    public static /* synthetic */ long m896copyxjbvk4A$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m903getWidthimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m900getHeightimpl(j);
        }
        return m895copyxjbvk4A(j, f, f2);
    }

    @Stable
    /* renamed from: div-7Ah8Wj8, reason: not valid java name */
    public static final long m897div7Ah8Wj8(long j, float f) {
        return SizeKt.Size(m903getWidthimpl(j) / f, m900getHeightimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m898equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).m908unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m899equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m900getHeightimpl(long j) {
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
    public static final float m901getMaxDimensionimpl(long j) {
        return Math.max(Math.abs(m903getWidthimpl(j)), Math.abs(m900getHeightimpl(j)));
    }

    @Stable
    public static /* synthetic */ void getMinDimension$annotations() {
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m902getMinDimensionimpl(long j) {
        return Math.min(Math.abs(m903getWidthimpl(j)), Math.abs(m900getHeightimpl(j)));
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m903getWidthimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m904hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m905isEmptyimpl(long j) {
        return m903getWidthimpl(j) <= 0.0f || m900getHeightimpl(j) <= 0.0f;
    }

    @Stable
    /* renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m906times7Ah8Wj8(long j, float f) {
        return SizeKt.Size(m903getWidthimpl(j) * f, m900getHeightimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m907toStringimpl(long j) {
        if (!(j != Companion.m911getUnspecifiedNHjbRc())) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(m903getWidthimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m900getHeightimpl(j), 1) + ')';
    }

    public boolean equals(Object obj) {
        return m898equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m904hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m907toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m908unboximpl() {
        return this.packedValue;
    }
}
