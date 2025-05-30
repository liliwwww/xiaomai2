package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class FocusDirection {
    private static final int Enter;
    private static final int Exit;

    /* renamed from: In */
    private static final int f108In;
    private static final int Out;
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Next = m2477constructorimpl(1);
    private static final int Previous = m2477constructorimpl(2);
    private static final int Left = m2477constructorimpl(3);
    private static final int Right = m2477constructorimpl(4);

    /* renamed from: Up */
    private static final int f109Up = m2477constructorimpl(5);
    private static final int Down = m2477constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2483getEnterdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2484getExitdhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Enter instead.", replaceWith = @ReplaceWith(expression = "Enter", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Enter"}))
        @ExperimentalComposeUiApi
        /* renamed from: getIn-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2485getIndhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Exit instead.", replaceWith = @ReplaceWith(expression = "Exit", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Exit"}))
        @ExperimentalComposeUiApi
        /* renamed from: getOut-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m2486getOutdhqQ8s$annotations() {
        }

        /* renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m2487getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m2488getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m2489getExitdhqQ8s() {
            return FocusDirection.Exit;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getIn-dhqQ-8s, reason: not valid java name */
        public final int m2490getIndhqQ8s() {
            return FocusDirection.f108In;
        }

        /* renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m2491getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m2492getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getOut-dhqQ-8s, reason: not valid java name */
        public final int m2493getOutdhqQ8s() {
            return FocusDirection.Out;
        }

        /* renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m2494getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m2495getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m2496getUpdhqQ8s() {
            return FocusDirection.f109Up;
        }
    }

    static {
        int m2477constructorimpl = m2477constructorimpl(7);
        Enter = m2477constructorimpl;
        int m2477constructorimpl2 = m2477constructorimpl(8);
        Exit = m2477constructorimpl2;
        f108In = m2477constructorimpl;
        Out = m2477constructorimpl2;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m2476boximpl(int i) {
        return new FocusDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2477constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2478equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m2482unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2479equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2480hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2481toStringimpl(int i) {
        return m2479equalsimpl0(i, Next) ? "Next" : m2479equalsimpl0(i, Previous) ? "Previous" : m2479equalsimpl0(i, Left) ? "Left" : m2479equalsimpl0(i, Right) ? "Right" : m2479equalsimpl0(i, f109Up) ? "Up" : m2479equalsimpl0(i, Down) ? "Down" : m2479equalsimpl0(i, Enter) ? "Enter" : m2479equalsimpl0(i, Exit) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return m2478equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2480hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2481toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2482unboximpl() {
        return this.value;
    }
}
