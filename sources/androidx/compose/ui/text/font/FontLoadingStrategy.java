package androidx.compose.ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontLoadingStrategy {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Blocking = m2374constructorimpl(0);
    private static final int OptionalLocal = m2374constructorimpl(1);
    private static final int Async = m2374constructorimpl(2);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAsync-PKNRLFQ, reason: not valid java name */
        public final int m2380getAsyncPKNRLFQ() {
            return FontLoadingStrategy.Async;
        }

        /* renamed from: getBlocking-PKNRLFQ, reason: not valid java name */
        public final int m2381getBlockingPKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        /* renamed from: getOptionalLocal-PKNRLFQ, reason: not valid java name */
        public final int m2382getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }
    }

    private /* synthetic */ FontLoadingStrategy(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontLoadingStrategy m2373boximpl(int i) {
        return new FontLoadingStrategy(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2374constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2375equalsimpl(int i, Object obj) {
        return (obj instanceof FontLoadingStrategy) && i == ((FontLoadingStrategy) obj).m2379unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2376equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2377hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2378toStringimpl(int i) {
        if (m2376equalsimpl0(i, Blocking)) {
            return "Blocking";
        }
        if (m2376equalsimpl0(i, OptionalLocal)) {
            return "Optional";
        }
        if (m2376equalsimpl0(i, Async)) {
            return "Async";
        }
        return "Invalid(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2375equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m2377hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2378toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2379unboximpl() {
        return this.value;
    }
}
