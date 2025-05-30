package androidx.compose.ui.input.pointer;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Unknown = m2034constructorimpl(0);
    private static final int Touch = m2034constructorimpl(1);
    private static final int Mouse = m2034constructorimpl(2);
    private static final int Stylus = m2034constructorimpl(3);
    private static final int Eraser = m2034constructorimpl(4);

    private /* synthetic */ PointerType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerType m2033boximpl(int i) {
        return new PointerType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2034constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2035equalsimpl(int i, Object obj) {
        return (obj instanceof PointerType) && i == ((PointerType) obj).m2039unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2036equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2037hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2038toStringimpl(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    public boolean equals(Object obj) {
        return m2035equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2037hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2038toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2039unboximpl() {
        return this.value;
    }
}
