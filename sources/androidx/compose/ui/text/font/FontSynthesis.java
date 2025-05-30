package androidx.compose.ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontSynthesis {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m2386constructorimpl(0);
    private static final int All = m2386constructorimpl(1);
    private static final int Weight = m2386constructorimpl(2);
    private static final int Style = m2386constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m2394getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m2395getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m2396getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m2397getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m2385boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2386constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2387equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m2393unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2388equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2389hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: isStyleOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2390isStyleOnimpl$ui_text_release(int i) {
        return m2388equalsimpl0(i, All) || m2388equalsimpl0(i, Style);
    }

    /* renamed from: isWeightOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2391isWeightOnimpl$ui_text_release(int i) {
        return m2388equalsimpl0(i, All) || m2388equalsimpl0(i, Weight);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2392toStringimpl(int i) {
        return m2388equalsimpl0(i, None) ? "None" : m2388equalsimpl0(i, All) ? "All" : m2388equalsimpl0(i, Weight) ? "Weight" : m2388equalsimpl0(i, Style) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2387equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2389hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2392toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2393unboximpl() {
        return this.value;
    }
}
