package androidx.compose.ui.input.pointer;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerButtons {
    private final int packedValue;

    private /* synthetic */ PointerButtons(int i) {
        this.packedValue = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerButtons m1414boximpl(int i) {
        return new PointerButtons(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1415constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1416equalsimpl(int i, Object obj) {
        return (obj instanceof PointerButtons) && i == ((PointerButtons) obj).m1420unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1417equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1418hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1419toStringimpl(int i) {
        return "PointerButtons(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1416equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1418hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1419toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1420unboximpl() {
        return this.packedValue;
    }
}
