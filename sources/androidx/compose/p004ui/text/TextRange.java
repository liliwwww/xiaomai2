package androidx.compose.p004ui.text;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class TextRange {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m4754getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m4737boximpl(long j) {
        return new TextRange(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4738constructorimpl(long j) {
        return j;
    }

    /* renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m4739contains5zctL8(long j, long j2) {
        return m4747getMinimpl(j) <= m4747getMinimpl(j2) && m4746getMaximpl(j2) <= m4746getMaximpl(j);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m4740containsimpl(long j, int i) {
        return i < m4746getMaximpl(j) && m4747getMinimpl(j) <= i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4741equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m4753unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4742equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m4743getCollapsedimpl(long j) {
        return m4749getStartimpl(j) == m4744getEndimpl(j);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m4744getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getLength-impl, reason: not valid java name */
    public static final int m4745getLengthimpl(long j) {
        return m4746getMaximpl(j) - m4747getMinimpl(j);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m4746getMaximpl(long j) {
        return m4749getStartimpl(j) > m4744getEndimpl(j) ? m4749getStartimpl(j) : m4744getEndimpl(j);
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m4747getMinimpl(long j) {
        return m4749getStartimpl(j) > m4744getEndimpl(j) ? m4744getEndimpl(j) : m4749getStartimpl(j);
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m4748getReversedimpl(long j) {
        return m4749getStartimpl(j) > m4744getEndimpl(j);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m4749getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4750hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m4751intersects5zctL8(long j, long j2) {
        return m4747getMinimpl(j) < m4746getMaximpl(j2) && m4747getMinimpl(j2) < m4746getMaximpl(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4752toStringimpl(long j) {
        return "TextRange(" + m4749getStartimpl(j) + ", " + m4744getEndimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m4741equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4750hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m4752toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4753unboximpl() {
        return this.packedValue;
    }
}
