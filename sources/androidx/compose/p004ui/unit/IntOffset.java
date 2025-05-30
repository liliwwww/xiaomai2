package androidx.compose.p004ui.unit;

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
/* loaded from: classes2.dex */
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
        public final long m5344getZeronOccac() {
            return IntOffset.Zero;
        }
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m5325boximpl(long j) {
        return new IntOffset(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m5326component1impl(long j) {
        return m5334getXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m5327component2impl(long j) {
        return m5335getYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5328constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m5329copyiSbpLlY(long j, int i, int i2) {
        return IntOffsetKt.IntOffset(i, i2);
    }

    /* renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m5330copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m5334getXimpl(j);
        }
        if ((i3 & 2) != 0) {
            i2 = m5335getYimpl(j);
        }
        return m5329copyiSbpLlY(j, i, i2);
    }

    @Stable
    /* renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m5331divBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(m5334getXimpl(j) / f), MathKt.roundToInt(m5335getYimpl(j) / f));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5332equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m5343unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5333equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final int m5334getXimpl(long j) {
        return (int) (j >> 32);
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final int m5335getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5336hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m5337minusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m5334getXimpl(j) - m5334getXimpl(j2), m5335getYimpl(j) - m5335getYimpl(j2));
    }

    @Stable
    /* renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m5338plusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m5334getXimpl(j) + m5334getXimpl(j2), m5335getYimpl(j) + m5335getYimpl(j2));
    }

    @Stable
    /* renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m5339remBjo55l4(long j, int i) {
        return IntOffsetKt.IntOffset(m5334getXimpl(j) % i, m5335getYimpl(j) % i);
    }

    @Stable
    /* renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m5340timesBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(m5334getXimpl(j) * f), MathKt.roundToInt(m5335getYimpl(j) * f));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5341toStringimpl(long j) {
        return '(' + m5334getXimpl(j) + ", " + m5335getYimpl(j) + ')';
    }

    @Stable
    /* renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m5342unaryMinusnOccac(long j) {
        return IntOffsetKt.IntOffset(-m5334getXimpl(j), -m5335getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m5332equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5336hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m5341toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5343unboximpl() {
        return this.packedValue;
    }
}
