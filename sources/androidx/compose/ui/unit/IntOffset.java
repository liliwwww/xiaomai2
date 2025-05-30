package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IntOffset {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m2653getZeronOccac() {
            return IntOffset.Zero;
        }
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m2634boximpl(long j) {
        return new IntOffset(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m2635component1impl(long j) {
        return m2643getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m2636component2impl(long j) {
        return m2644getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2637constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m2638copyiSbpLlY(long j, int i, int i2) {
        return IntOffsetKt.IntOffset(i, i2);
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m2639copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m2643getXimpl(j);
        }
        if ((i3 & 2) != 0) {
            i2 = m2644getYimpl(j);
        }
        return m2638copyiSbpLlY(j, i, i2);
    }

    @Stable
    /* renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m2640divBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(m2643getXimpl(j) / f), MathKt.roundToInt(m2644getYimpl(j) / f));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2641equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m2652unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2642equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m2643getXimpl(long j) {
        return (int) (j >> 32);
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m2644getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2645hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m2646minusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m2643getXimpl(j) - m2643getXimpl(j2), m2644getYimpl(j) - m2644getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m2647plusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m2643getXimpl(j) + m2643getXimpl(j2), m2644getYimpl(j) + m2644getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m2648remBjo55l4(long j, int i) {
        return IntOffsetKt.IntOffset(m2643getXimpl(j) % i, m2644getYimpl(j) % i);
    }

    @Stable
    /* renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m2649timesBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(m2643getXimpl(j) * f), MathKt.roundToInt(m2644getYimpl(j) * f));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2650toStringimpl(long j) {
        return '(' + m2643getXimpl(j) + ", " + m2644getYimpl(j) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m2651unaryMinusnOccac(long j) {
        return IntOffsetKt.IntOffset(-m2643getXimpl(j), -m2644getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m2641equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2645hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m2650toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2652unboximpl() {
        return this.packedValue;
    }
}
