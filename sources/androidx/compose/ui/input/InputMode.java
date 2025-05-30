package androidx.compose.ui.input;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InputMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Touch = m1352constructorimpl(1);
    private static final int Keyboard = m1352constructorimpl(2);

    private /* synthetic */ InputMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InputMode m1351boximpl(int i) {
        return new InputMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1352constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1353equalsimpl(int i, Object obj) {
        return (obj instanceof InputMode) && i == ((InputMode) obj).m1357unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1354equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1355hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1356toStringimpl(int i) {
        return m1354equalsimpl0(i, Touch) ? "Touch" : m1354equalsimpl0(i, Keyboard) ? "Keyboard" : "Error";
    }

    public boolean equals(Object obj) {
        return m1353equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1355hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1356toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1357unboximpl() {
        return this.value;
    }
}
