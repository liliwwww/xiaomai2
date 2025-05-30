package androidx.compose.ui.layout;

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
public final class ScaleFactor {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m1568boximpl(long j) {
        return new ScaleFactor(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m1569component1impl(long j) {
        return m1577getScaleXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m1570component2impl(long j) {
        return m1578getScaleYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1571constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m1572copy8GGzs04(long j, float f, float f2) {
        return ScaleFactorKt.ScaleFactor(f, f2);
    }

    /* renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m1573copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1577getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m1578getScaleYimpl(j);
        }
        return m1572copy8GGzs04(j, f, f2);
    }

    @Stable
    /* renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m1574div44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m1577getScaleXimpl(j) / f, m1578getScaleYimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1575equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m1582unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1576equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleX$annotations() {
    }

    /* renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m1577getScaleXimpl(long j) {
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
    public static final float m1578getScaleYimpl(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1579hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m1580times44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m1577getScaleXimpl(j) * f, m1578getScaleYimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1581toStringimpl(long j) {
        return "ScaleFactor(" + ScaleFactorKt.access$roundToTenths(m1577getScaleXimpl(j)) + ", " + ScaleFactorKt.access$roundToTenths(m1578getScaleYimpl(j)) + ')';
    }

    public boolean equals(Object obj) {
        return m1575equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1579hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1581toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1582unboximpl() {
        return this.packedValue;
    }
}
