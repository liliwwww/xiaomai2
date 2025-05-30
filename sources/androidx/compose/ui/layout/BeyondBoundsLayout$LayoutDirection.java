package androidx.compose.ui.layout;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BeyondBoundsLayout$LayoutDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Before = m2041constructorimpl(1);
    private static final int After = m2041constructorimpl(2);
    private static final int Left = m2041constructorimpl(3);
    private static final int Right = m2041constructorimpl(4);
    private static final int Above = m2041constructorimpl(5);
    private static final int Below = m2041constructorimpl(6);

    private /* synthetic */ BeyondBoundsLayout$LayoutDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BeyondBoundsLayout$LayoutDirection m2040boximpl(int i) {
        return new BeyondBoundsLayout$LayoutDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2041constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2042equalsimpl(int i, Object obj) {
        return (obj instanceof BeyondBoundsLayout$LayoutDirection) && i == ((BeyondBoundsLayout$LayoutDirection) obj).m2046unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2043equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2044hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2045toStringimpl(int i) {
        return m2043equalsimpl0(i, Before) ? "Before" : m2043equalsimpl0(i, After) ? "After" : m2043equalsimpl0(i, Left) ? "Left" : m2043equalsimpl0(i, Right) ? "Right" : m2043equalsimpl0(i, Above) ? "Above" : m2043equalsimpl0(i, Below) ? "Below" : "invalid LayoutDirection";
    }

    public boolean equals(Object obj) {
        return m2042equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2044hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2045toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2046unboximpl() {
        return this.value;
    }
}
