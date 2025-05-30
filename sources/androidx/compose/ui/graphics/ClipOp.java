package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ClipOp {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Difference = m1034constructorimpl(0);
    private static final int Intersect = m1034constructorimpl(1);
    private final int value;

    private /* synthetic */ ClipOp(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ClipOp m1033boximpl(int i) {
        return new ClipOp(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1034constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1035equalsimpl(int i, Object obj) {
        return (obj instanceof ClipOp) && i == ((ClipOp) obj).m1039unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1036equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1037hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1038toStringimpl(int i) {
        return m1036equalsimpl0(i, Difference) ? "Difference" : m1036equalsimpl0(i, Intersect) ? "Intersect" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1035equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1037hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1038toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1039unboximpl() {
        return this.value;
    }
}
