package androidx.compose.p004ui.input.pointer;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class PointerEventType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m4031constructorimpl(0);
    private static final int Press = m4031constructorimpl(1);
    private static final int Release = m4031constructorimpl(2);
    private static final int Move = m4031constructorimpl(3);
    private static final int Enter = m4031constructorimpl(4);
    private static final int Exit = m4031constructorimpl(5);
    private static final int Scroll = m4031constructorimpl(6);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m4037getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m4038getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m4039getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m4040getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m4041getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m4042getScroll7fucELk() {
            return PointerEventType.Scroll;
        }

        /* renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m4043getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }
    }

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m4030boximpl(int i) {
        return new PointerEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4031constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4032equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).m4036unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4033equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4034hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4035toStringimpl(int i) {
        return m4033equalsimpl0(i, Press) ? "Press" : m4033equalsimpl0(i, Release) ? "Release" : m4033equalsimpl0(i, Move) ? "Move" : m4033equalsimpl0(i, Enter) ? "Enter" : m4033equalsimpl0(i, Exit) ? "Exit" : m4033equalsimpl0(i, Scroll) ? "Scroll" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m4032equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4034hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4035toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4036unboximpl() {
        return this.value;
    }
}
