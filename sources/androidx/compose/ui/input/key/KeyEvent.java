package androidx.compose.ui.input.key;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyEvent {

    @NotNull
    private final android.view.KeyEvent nativeKeyEvent;

    private /* synthetic */ KeyEvent(android.view.KeyEvent keyEvent) {
        this.nativeKeyEvent = keyEvent;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEvent m1936boximpl(android.view.KeyEvent keyEvent) {
        return new KeyEvent(keyEvent);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static android.view.KeyEvent m1937constructorimpl(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "nativeKeyEvent");
        return keyEvent;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1938equalsimpl(android.view.KeyEvent keyEvent, Object obj) {
        return (obj instanceof KeyEvent) && Intrinsics.areEqual(keyEvent, ((KeyEvent) obj).m1942unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1939equalsimpl0(android.view.KeyEvent keyEvent, android.view.KeyEvent keyEvent2) {
        return Intrinsics.areEqual(keyEvent, keyEvent2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1940hashCodeimpl(android.view.KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1941toStringimpl(android.view.KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return m1938equalsimpl(this.nativeKeyEvent, obj);
    }

    @NotNull
    public final android.view.KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }

    public int hashCode() {
        return m1940hashCodeimpl(this.nativeKeyEvent);
    }

    public String toString() {
        return m1941toStringimpl(this.nativeKeyEvent);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ android.view.KeyEvent m1942unboximpl() {
        return this.nativeKeyEvent;
    }
}
