package androidx.compose.ui.text.style;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextMotion$Linearity {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Linear = m2522constructorimpl(1);
    private static final int FontHinting = m2522constructorimpl(2);
    private static final int None = m2522constructorimpl(3);

    private /* synthetic */ TextMotion$Linearity(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextMotion$Linearity m2521boximpl(int i) {
        return new TextMotion$Linearity(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2522constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2523equalsimpl(int i, Object obj) {
        return (obj instanceof TextMotion$Linearity) && i == ((TextMotion$Linearity) obj).m2527unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2524equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2525hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2526toStringimpl(int i) {
        return m2524equalsimpl0(i, Linear) ? "Linearity.Linear" : m2524equalsimpl0(i, FontHinting) ? "Linearity.FontHinting" : m2524equalsimpl0(i, None) ? "Linearity.None" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2523equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2525hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2526toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2527unboximpl() {
        return this.value;
    }
}
