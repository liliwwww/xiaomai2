package androidx.compose.ui.text.style;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Ltr = m2068constructorimpl(1);
    private static final int Rtl = m2068constructorimpl(2);
    private static final int Content = m2068constructorimpl(3);
    private static final int ContentOrLtr = m2068constructorimpl(4);
    private static final int ContentOrRtl = m2068constructorimpl(5);

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m2067boximpl(int i) {
        return new TextDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2068constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2069equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m2073unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2070equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2071hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2072toStringimpl(int i) {
        return m2070equalsimpl0(i, Ltr) ? "Ltr" : m2070equalsimpl0(i, Rtl) ? "Rtl" : m2070equalsimpl0(i, Content) ? "Content" : m2070equalsimpl0(i, ContentOrLtr) ? "ContentOrLtr" : m2070equalsimpl0(i, ContentOrRtl) ? "ContentOrRtl" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2069equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2071hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2072toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2073unboximpl() {
        return this.value;
    }
}
