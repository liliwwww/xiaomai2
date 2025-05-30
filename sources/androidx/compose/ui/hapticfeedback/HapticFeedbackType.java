package androidx.compose.ui.hapticfeedback;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class HapticFeedbackType {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int value;

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m1366boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1367constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1368equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m1372unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1369equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1370hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1371toStringimpl(int i) {
        Companion companion = Companion;
        return m1369equalsimpl0(i, companion.getLongPress-5zf0vsI()) ? "LongPress" : m1369equalsimpl0(i, companion.getTextHandleMove-5zf0vsI()) ? "TextHandleMove" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m1368equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1370hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1371toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1372unboximpl() {
        return this.value;
    }
}
