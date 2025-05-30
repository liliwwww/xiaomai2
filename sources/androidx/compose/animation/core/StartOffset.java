package androidx.compose.animation.core;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class StartOffset {
    private final long value;

    private /* synthetic */ StartOffset(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m85boximpl(long j) {
        return new StartOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m86constructorimpl(int i, int i2) {
        return m87constructorimpl(i * i2);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m87constructorimpl(long j) {
        return j;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m88constructorimpl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.Companion.getDelay-Eo1U57Q();
        }
        return m86constructorimpl(i, i2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m89equalsimpl(long j, Object obj) {
        return (obj instanceof StartOffset) && j == ((StartOffset) obj).m95unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m90equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m91getOffsetMillisimpl(long j) {
        return Math.abs((int) j);
    }

    /* renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m92getOffsetTypeEo1U57Q(long j) {
        boolean z = j > 0;
        if (z) {
            return StartOffsetType.Companion.getFastForward-Eo1U57Q();
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return StartOffsetType.Companion.getDelay-Eo1U57Q();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m93hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m94toStringimpl(long j) {
        return "StartOffset(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m89equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m93hashCodeimpl(this.value);
    }

    public String toString() {
        return m94toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m95unboximpl() {
        return this.value;
    }
}
