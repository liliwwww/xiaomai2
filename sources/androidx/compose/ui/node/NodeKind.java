package androidx.compose.ui.node;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NodeKind<T> {
    private final int mask;

    private /* synthetic */ NodeKind(int i) {
        this.mask = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NodeKind m1659boximpl(int i) {
        return new NodeKind(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> int m1660constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1661equalsimpl(int i, Object obj) {
        return (obj instanceof NodeKind) && i == ((NodeKind) obj).m1667unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1662equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1663hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: or-H91voCI, reason: not valid java name */
    public static final int m1664orH91voCI(int i, int i2) {
        return i | i2;
    }

    /* renamed from: or-impl, reason: not valid java name */
    public static final int m1665orimpl(int i, int i2) {
        return i | i2;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1666toStringimpl(int i) {
        return "NodeKind(mask=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1661equalsimpl(this.mask, obj);
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return m1663hashCodeimpl(this.mask);
    }

    public String toString() {
        return m1666toStringimpl(this.mask);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1667unboximpl() {
        return this.mask;
    }
}
