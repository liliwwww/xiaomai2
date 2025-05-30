package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextRange {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m2318boximpl(long j) {
        return new TextRange(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2319constructorimpl(long j) {
        return j;
    }

    /* renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m2320contains5zctL8(long j, long j2) {
        return m2328getMinimpl(j) <= m2328getMinimpl(j2) && m2327getMaximpl(j2) <= m2327getMaximpl(j);
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m2321containsimpl(long j, int i) {
        return i < m2327getMaximpl(j) && m2328getMinimpl(j) <= i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2322equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m2334unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2323equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m2324getCollapsedimpl(long j) {
        return m2330getStartimpl(j) == m2325getEndimpl(j);
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m2325getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getLength-impl, reason: not valid java name */
    public static final int m2326getLengthimpl(long j) {
        return m2327getMaximpl(j) - m2328getMinimpl(j);
    }

    /* renamed from: getMax-impl, reason: not valid java name */
    public static final int m2327getMaximpl(long j) {
        return m2330getStartimpl(j) > m2325getEndimpl(j) ? m2330getStartimpl(j) : m2325getEndimpl(j);
    }

    /* renamed from: getMin-impl, reason: not valid java name */
    public static final int m2328getMinimpl(long j) {
        return m2330getStartimpl(j) > m2325getEndimpl(j) ? m2325getEndimpl(j) : m2330getStartimpl(j);
    }

    /* renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m2329getReversedimpl(long j) {
        return m2330getStartimpl(j) > m2325getEndimpl(j);
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m2330getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2331hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m2332intersects5zctL8(long j, long j2) {
        return m2328getMinimpl(j) < m2327getMaximpl(j2) && m2328getMinimpl(j2) < m2327getMaximpl(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2333toStringimpl(long j) {
        return "TextRange(" + m2330getStartimpl(j) + ", " + m2325getEndimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m2322equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2331hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2333toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2334unboximpl() {
        return this.packedValue;
    }
}
