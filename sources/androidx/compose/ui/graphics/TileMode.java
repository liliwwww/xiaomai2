package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TileMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Clamp = m1216constructorimpl(0);
    private static final int Repeated = m1216constructorimpl(1);
    private static final int Mirror = m1216constructorimpl(2);
    private static final int Decal = m1216constructorimpl(3);

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m1215boximpl(int i) {
        return new TileMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1216constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1217equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).m1221unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1218equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1219hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1220toStringimpl(int i) {
        return m1218equalsimpl0(i, Clamp) ? "Clamp" : m1218equalsimpl0(i, Repeated) ? "Repeated" : m1218equalsimpl0(i, Mirror) ? "Mirror" : m1218equalsimpl0(i, Decal) ? "Decal" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1217equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1219hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1220toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1221unboximpl() {
        return this.value;
    }
}
