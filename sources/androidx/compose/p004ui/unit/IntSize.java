package androidx.compose.p004ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class IntSize {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m5371constructorimpl(0);
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m5381getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m5368boximpl(long j) {
        return new IntSize(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m5369component1impl(long j) {
        return m5376getWidthimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m5370component2impl(long j) {
        return m5375getHeightimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5371constructorimpl(long j) {
        return j;
    }

    @Stable
    /* renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m5372divYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m5376getWidthimpl(j) / i, m5375getHeightimpl(j) / i);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5373equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m5380unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5374equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final int m5375getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final int m5376getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5377hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m5378timesYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m5376getWidthimpl(j) * i, m5375getHeightimpl(j) * i);
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5379toStringimpl(long j) {
        return m5376getWidthimpl(j) + " x " + m5375getHeightimpl(j);
    }

    public boolean equals(Object obj) {
        return m5373equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5377hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m5379toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5380unboximpl() {
        return this.packedValue;
    }
}
