package androidx.compose.p004ui.input.pointer;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class PointerButtons {
    private final int packedValue;

    private /* synthetic */ PointerButtons(int i) {
        this.packedValue = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerButtons m4016boximpl(int i) {
        return new PointerButtons(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4017constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4018equalsimpl(int i, Object obj) {
        return (obj instanceof PointerButtons) && i == ((PointerButtons) obj).m4022unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4019equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4020hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4021toStringimpl(int i) {
        return "PointerButtons(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m4018equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4020hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4021toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4022unboximpl() {
        return this.packedValue;
    }
}
