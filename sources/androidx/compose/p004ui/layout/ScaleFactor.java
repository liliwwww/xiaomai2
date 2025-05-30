package androidx.compose.p004ui.layout;

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
public final class ScaleFactor {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m4248getUnspecified_hLwfpc$annotations() {
        }

        /* renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m4249getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m4233boximpl(long j) {
        return new ScaleFactor(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m4234component1impl(long j) {
        return m4242getScaleXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m4235component2impl(long j) {
        return m4243getScaleYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4236constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m4237copy8GGzs04(long j, float f, float f2) {
        return ScaleFactorKt.ScaleFactor(f, f2);
    }

    /* renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m4238copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4242getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m4243getScaleYimpl(j);
        }
        return m4237copy8GGzs04(j, f, f2);
    }

    @Stable
    /* renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m4239div44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m4242getScaleXimpl(j) / f, m4243getScaleYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4240equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m4247unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4241equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleX$annotations() {
    }

    /* renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m4242getScaleXimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m4243getScaleYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4244hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m4245times44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m4242getScaleXimpl(j) * f, m4243getScaleYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4246toStringimpl(long j) {
        float roundToTenths;
        float roundToTenths2;
        StringBuilder sb = new StringBuilder();
        sb.append("ScaleFactor(");
        roundToTenths = ScaleFactorKt.roundToTenths(m4242getScaleXimpl(j));
        sb.append(roundToTenths);
        sb.append(", ");
        roundToTenths2 = ScaleFactorKt.roundToTenths(m4243getScaleYimpl(j));
        sb.append(roundToTenths2);
        sb.append(')');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return m4240equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4244hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m4246toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4247unboximpl() {
        return this.packedValue;
    }
}
