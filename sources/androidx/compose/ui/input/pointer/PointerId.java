package androidx.compose.ui.input.pointer;

import kotlin.jvm.JvmInline;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerId {
    private final long value;

    private /* synthetic */ PointerId(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerId m1447boximpl(long j) {
        return new PointerId(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1448constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1449equalsimpl(long j, Object obj) {
        return (obj instanceof PointerId) && j == ((PointerId) obj).m1453unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1450equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1451hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1452toStringimpl(long j) {
        return "PointerId(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1449equalsimpl(this.value, obj);
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1451hashCodeimpl(this.value);
    }

    public String toString() {
        return m1452toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1453unboximpl() {
        return this.value;
    }
}
