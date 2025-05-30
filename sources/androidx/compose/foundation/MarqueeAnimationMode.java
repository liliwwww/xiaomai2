package androidx.compose.foundation;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MarqueeAnimationMode {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Immediately = m135constructorimpl(0);
    private static final int WhileFocused = m135constructorimpl(1);
    private final int value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalFoundationApi
        /* renamed from: getImmediately-ZbEOnfQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m141getImmediatelyZbEOnfQ$annotations() {
        }

        @ExperimentalFoundationApi
        /* renamed from: getWhileFocused-ZbEOnfQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m142getWhileFocusedZbEOnfQ$annotations() {
        }

        @ExperimentalFoundationApi
        /* renamed from: getImmediately-ZbEOnfQ, reason: not valid java name */
        public final int m143getImmediatelyZbEOnfQ() {
            return MarqueeAnimationMode.Immediately;
        }

        @ExperimentalFoundationApi
        /* renamed from: getWhileFocused-ZbEOnfQ, reason: not valid java name */
        public final int m144getWhileFocusedZbEOnfQ() {
            return MarqueeAnimationMode.WhileFocused;
        }
    }

    private /* synthetic */ MarqueeAnimationMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MarqueeAnimationMode m134boximpl(int i) {
        return new MarqueeAnimationMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m135constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m136equalsimpl(int i, Object obj) {
        return (obj instanceof MarqueeAnimationMode) && i == ((MarqueeAnimationMode) obj).m140unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m137equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m138hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m139toStringimpl(int i) {
        if (m137equalsimpl0(i, Immediately)) {
            return "Immediately";
        }
        if (m137equalsimpl0(i, WhileFocused)) {
            return "WhileFocused";
        }
        throw new IllegalStateException(("invalid value: " + i).toString());
    }

    public boolean equals(Object obj) {
        return m136equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m138hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m139toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m140unboximpl() {
        return this.value;
    }
}
