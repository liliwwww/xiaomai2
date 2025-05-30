package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Points = m1198constructorimpl(0);
    private static final int Lines = m1198constructorimpl(1);
    private static final int Polygon = m1198constructorimpl(2);

    private /* synthetic */ PointMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointMode m1197boximpl(int i) {
        return new PointMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1198constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1199equalsimpl(int i, Object obj) {
        return (obj instanceof PointMode) && i == ((PointMode) obj).m1203unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1200equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1201hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1202toStringimpl(int i) {
        return m1200equalsimpl0(i, Points) ? "Points" : m1200equalsimpl0(i, Lines) ? "Lines" : m1200equalsimpl0(i, Polygon) ? "Polygon" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1199equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1201hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1202toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1203unboximpl() {
        return this.value;
    }
}
