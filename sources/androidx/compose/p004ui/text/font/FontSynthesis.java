package androidx.compose.p004ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class FontSynthesis {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m4841constructorimpl(0);
    private static final int All = m4841constructorimpl(1);
    private static final int Weight = m4841constructorimpl(2);
    private static final int Style = m4841constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m4849getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m4850getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m4851getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m4852getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m4840boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4841constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4842equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m4848unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4843equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4844hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: isStyleOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m4845isStyleOnimpl$ui_text_release(int i) {
        return m4843equalsimpl0(i, All) || m4843equalsimpl0(i, Style);
    }

    /* renamed from: isWeightOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m4846isWeightOnimpl$ui_text_release(int i) {
        return m4843equalsimpl0(i, All) || m4843equalsimpl0(i, Weight);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4847toStringimpl(int i) {
        return m4843equalsimpl0(i, None) ? "None" : m4843equalsimpl0(i, All) ? "All" : m4843equalsimpl0(i, Weight) ? "Weight" : m4843equalsimpl0(i, Style) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4842equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4844hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4847toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4848unboximpl() {
        return this.value;
    }
}
