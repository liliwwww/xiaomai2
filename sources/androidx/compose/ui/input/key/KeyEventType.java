package androidx.compose.ui.input.key;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyEventType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Unknown = m1944constructorimpl(0);
    private static final int KeyUp = m1944constructorimpl(1);
    private static final int KeyDown = m1944constructorimpl(2);

    private /* synthetic */ KeyEventType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEventType m1943boximpl(int i) {
        return new KeyEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1944constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1945equalsimpl(int i, Object obj) {
        return (obj instanceof KeyEventType) && i == ((KeyEventType) obj).m1949unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1946equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1947hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1948toStringimpl(int i) {
        return m1946equalsimpl0(i, KeyUp) ? "KeyUp" : m1946equalsimpl0(i, KeyDown) ? "KeyDown" : m1946equalsimpl0(i, Unknown) ? "Unknown" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m1945equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1947hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1948toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1949unboximpl() {
        return this.value;
    }
}
