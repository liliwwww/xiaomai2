package androidx.compose.p004ui.text;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class PlaceholderVerticalAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int AboveBaseline = m4661constructorimpl(1);
    private static final int Top = m4661constructorimpl(2);
    private static final int Bottom = m4661constructorimpl(3);
    private static final int Center = m4661constructorimpl(4);
    private static final int TextTop = m4661constructorimpl(5);
    private static final int TextBottom = m4661constructorimpl(6);
    private static final int TextCenter = m4661constructorimpl(7);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAboveBaseline-J6kI3mc, reason: not valid java name */
        public final int m4667getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        /* renamed from: getBottom-J6kI3mc, reason: not valid java name */
        public final int m4668getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        /* renamed from: getCenter-J6kI3mc, reason: not valid java name */
        public final int m4669getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        /* renamed from: getTextBottom-J6kI3mc, reason: not valid java name */
        public final int m4670getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        /* renamed from: getTextCenter-J6kI3mc, reason: not valid java name */
        public final int m4671getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }

        /* renamed from: getTextTop-J6kI3mc, reason: not valid java name */
        public final int m4672getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        /* renamed from: getTop-J6kI3mc, reason: not valid java name */
        public final int m4673getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }
    }

    private /* synthetic */ PlaceholderVerticalAlign(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m4660boximpl(int i) {
        return new PlaceholderVerticalAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4661constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4662equalsimpl(int i, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i == ((PlaceholderVerticalAlign) obj).m4666unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4663equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4664hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4665toStringimpl(int i) {
        return m4663equalsimpl0(i, AboveBaseline) ? "AboveBaseline" : m4663equalsimpl0(i, Top) ? "Top" : m4663equalsimpl0(i, Bottom) ? "Bottom" : m4663equalsimpl0(i, Center) ? "Center" : m4663equalsimpl0(i, TextTop) ? "TextTop" : m4663equalsimpl0(i, TextBottom) ? "TextBottom" : m4663equalsimpl0(i, TextCenter) ? "TextCenter" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4662equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4664hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4665toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4666unboximpl() {
        return this.value;
    }
}
