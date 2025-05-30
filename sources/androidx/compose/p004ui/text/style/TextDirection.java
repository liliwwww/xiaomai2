package androidx.compose.p004ui.text.style;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class TextDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m5086constructorimpl(1);
    private static final int Rtl = m5086constructorimpl(2);
    private static final int Content = m5086constructorimpl(3);
    private static final int ContentOrLtr = m5086constructorimpl(4);
    private static final int ContentOrRtl = m5086constructorimpl(5);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getContent-s_7X-co, reason: not valid java name */
        public final int m5092getContents_7Xco() {
            return TextDirection.Content;
        }

        /* renamed from: getContentOrLtr-s_7X-co, reason: not valid java name */
        public final int m5093getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* renamed from: getContentOrRtl-s_7X-co, reason: not valid java name */
        public final int m5094getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* renamed from: getLtr-s_7X-co, reason: not valid java name */
        public final int m5095getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* renamed from: getRtl-s_7X-co, reason: not valid java name */
        public final int m5096getRtls_7Xco() {
            return TextDirection.Rtl;
        }
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m5085boximpl(int i) {
        return new TextDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m5086constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5087equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m5091unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5088equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5089hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5090toStringimpl(int i) {
        return m5088equalsimpl0(i, Ltr) ? "Ltr" : m5088equalsimpl0(i, Rtl) ? "Rtl" : m5088equalsimpl0(i, Content) ? "Content" : m5088equalsimpl0(i, ContentOrLtr) ? "ContentOrLtr" : m5088equalsimpl0(i, ContentOrRtl) ? "ContentOrRtl" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5087equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5089hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5090toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5091unboximpl() {
        return this.value;
    }
}
