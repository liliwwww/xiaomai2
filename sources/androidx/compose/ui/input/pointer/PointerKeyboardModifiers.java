package androidx.compose.ui.input.pointer;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerKeyboardModifiers {
    private final int packedValue;

    private /* synthetic */ PointerKeyboardModifiers(int i) {
        this.packedValue = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerKeyboardModifiers m1476boximpl(int i) {
        return new PointerKeyboardModifiers(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1477constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1478equalsimpl(int i, Object obj) {
        return (obj instanceof PointerKeyboardModifiers) && i == ((PointerKeyboardModifiers) obj).m1482unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1479equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1480hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1481toStringimpl(int i) {
        return "PointerKeyboardModifiers(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1478equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1480hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1481toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1482unboximpl() {
        return this.packedValue;
    }
}
