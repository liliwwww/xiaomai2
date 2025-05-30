package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LiveRegionMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Polite = m1800constructorimpl(0);
    private static final int Assertive = m1800constructorimpl(1);

    private /* synthetic */ LiveRegionMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m1799boximpl(int i) {
        return new LiveRegionMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m1800constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1801equalsimpl(int i, Object obj) {
        return (obj instanceof LiveRegionMode) && i == ((LiveRegionMode) obj).m1805unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1802equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1803hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1804toStringimpl(int i) {
        return m1802equalsimpl0(i, Polite) ? "Polite" : m1802equalsimpl0(i, Assertive) ? "Assertive" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1801equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1803hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1804toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1805unboximpl() {
        return this.value;
    }
}
