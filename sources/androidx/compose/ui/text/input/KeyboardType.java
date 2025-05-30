package androidx.compose.ui.text.input;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyboardType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Text = m1974constructorimpl(1);
    private static final int Ascii = m1974constructorimpl(2);
    private static final int Number = m1974constructorimpl(3);
    private static final int Phone = m1974constructorimpl(4);
    private static final int Uri = m1974constructorimpl(5);
    private static final int Email = m1974constructorimpl(6);
    private static final int Password = m1974constructorimpl(7);
    private static final int NumberPassword = m1974constructorimpl(8);
    private static final int Decimal = m1974constructorimpl(9);

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m1973boximpl(int i) {
        return new KeyboardType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1974constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1975equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).m1979unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1976equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1977hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1978toStringimpl(int i) {
        return m1976equalsimpl0(i, Text) ? "Text" : m1976equalsimpl0(i, Ascii) ? "Ascii" : m1976equalsimpl0(i, Number) ? "Number" : m1976equalsimpl0(i, Phone) ? "Phone" : m1976equalsimpl0(i, Uri) ? "Uri" : m1976equalsimpl0(i, Email) ? "Email" : m1976equalsimpl0(i, Password) ? "Password" : m1976equalsimpl0(i, NumberPassword) ? "NumberPassword" : m1976equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m1975equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1977hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1978toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1979unboximpl() {
        return this.value;
    }
}
