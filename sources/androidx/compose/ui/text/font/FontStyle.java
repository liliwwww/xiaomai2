package androidx.compose.ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FontStyle {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Normal = m1925constructorimpl(0);
    private static final int Italic = m1925constructorimpl(1);

    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m1924boximpl(int i) {
        return new FontStyle(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1925constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1926equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m1930unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1927equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1928hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1929toStringimpl(int i) {
        return m1927equalsimpl0(i, Normal) ? "Normal" : m1927equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m1926equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1928hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1929toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1930unboximpl() {
        return this.value;
    }
}
