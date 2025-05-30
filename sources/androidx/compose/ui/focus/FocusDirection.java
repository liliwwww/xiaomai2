package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusDirection {
    private static final int Enter;
    private static final int Exit;
    private static final int In;
    private static final int Out;
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Next = m962constructorimpl(1);
    private static final int Previous = m962constructorimpl(2);
    private static final int Left = m962constructorimpl(3);
    private static final int Right = m962constructorimpl(4);
    private static final int Up = m962constructorimpl(5);
    private static final int Down = m962constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m968getEnterdhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m969getExitdhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Enter instead.", replaceWith = @ReplaceWith(expression = "Enter", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Enter"}))
        @ExperimentalComposeUiApi
        /* renamed from: getIn-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m970getIndhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Exit instead.", replaceWith = @ReplaceWith(expression = "Exit", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Exit"}))
        @ExperimentalComposeUiApi
        /* renamed from: getOut-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m971getOutdhqQ8s$annotations() {
        }

        /* renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m972getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m973getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m974getExitdhqQ8s() {
            return FocusDirection.Exit;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getIn-dhqQ-8s, reason: not valid java name */
        public final int m975getIndhqQ8s() {
            return FocusDirection.In;
        }

        /* renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m976getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m977getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        @ExperimentalComposeUiApi
        /* renamed from: getOut-dhqQ-8s, reason: not valid java name */
        public final int m978getOutdhqQ8s() {
            return FocusDirection.Out;
        }

        /* renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m979getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m980getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m981getUpdhqQ8s() {
            return FocusDirection.Up;
        }
    }

    static {
        int m962constructorimpl = m962constructorimpl(7);
        Enter = m962constructorimpl;
        int m962constructorimpl2 = m962constructorimpl(8);
        Exit = m962constructorimpl2;
        In = m962constructorimpl;
        Out = m962constructorimpl2;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m961boximpl(int i) {
        return new FocusDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m962constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m963equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m967unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m964equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m965hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m966toStringimpl(int i) {
        return m964equalsimpl0(i, Next) ? "Next" : m964equalsimpl0(i, Previous) ? "Previous" : m964equalsimpl0(i, Left) ? "Left" : m964equalsimpl0(i, Right) ? "Right" : m964equalsimpl0(i, Up) ? "Up" : m964equalsimpl0(i, Down) ? "Down" : m964equalsimpl0(i, Enter) ? "Enter" : m964equalsimpl0(i, Exit) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return m963equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m965hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m966toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m967unboximpl() {
        return this.value;
    }
}
