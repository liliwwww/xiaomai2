package androidx.compose.ui.input.pointer;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerEventType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Unknown = m1989constructorimpl(0);
    private static final int Press = m1989constructorimpl(1);
    private static final int Release = m1989constructorimpl(2);
    private static final int Move = m1989constructorimpl(3);
    private static final int Enter = m1989constructorimpl(4);
    private static final int Exit = m1989constructorimpl(5);
    private static final int Scroll = m1989constructorimpl(6);

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m1988boximpl(int i) {
        return new PointerEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m1989constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1990equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).m1994unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1991equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1992hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1993toStringimpl(int i) {
        return m1991equalsimpl0(i, Press) ? "Press" : m1991equalsimpl0(i, Release) ? "Release" : m1991equalsimpl0(i, Move) ? "Move" : m1991equalsimpl0(i, Enter) ? "Enter" : m1991equalsimpl0(i, Exit) ? "Exit" : m1991equalsimpl0(i, Scroll) ? "Scroll" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1990equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1992hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1993toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1994unboximpl() {
        return this.value;
    }
}
