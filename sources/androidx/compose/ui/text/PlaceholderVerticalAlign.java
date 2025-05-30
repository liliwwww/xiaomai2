package androidx.compose.ui.text;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PlaceholderVerticalAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int AboveBaseline = m1859constructorimpl(1);
    private static final int Top = m1859constructorimpl(2);
    private static final int Bottom = m1859constructorimpl(3);
    private static final int Center = m1859constructorimpl(4);
    private static final int TextTop = m1859constructorimpl(5);
    private static final int TextBottom = m1859constructorimpl(6);
    private static final int TextCenter = m1859constructorimpl(7);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAboveBaseline-J6kI3mc, reason: not valid java name */
        public final int m1865getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        /* renamed from: getBottom-J6kI3mc, reason: not valid java name */
        public final int m1866getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        /* renamed from: getCenter-J6kI3mc, reason: not valid java name */
        public final int m1867getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        /* renamed from: getTextBottom-J6kI3mc, reason: not valid java name */
        public final int m1868getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        /* renamed from: getTextCenter-J6kI3mc, reason: not valid java name */
        public final int m1869getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }

        /* renamed from: getTextTop-J6kI3mc, reason: not valid java name */
        public final int m1870getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        /* renamed from: getTop-J6kI3mc, reason: not valid java name */
        public final int m1871getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }
    }

    private /* synthetic */ PlaceholderVerticalAlign(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m1858boximpl(int i) {
        return new PlaceholderVerticalAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1859constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1860equalsimpl(int i, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i == ((PlaceholderVerticalAlign) obj).m1864unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1861equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1862hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1863toStringimpl(int i) {
        return m1861equalsimpl0(i, AboveBaseline) ? "AboveBaseline" : m1861equalsimpl0(i, Top) ? "Top" : m1861equalsimpl0(i, Bottom) ? "Bottom" : m1861equalsimpl0(i, Center) ? "Center" : m1861equalsimpl0(i, TextTop) ? "TextTop" : m1861equalsimpl0(i, TextBottom) ? "TextBottom" : m1861equalsimpl0(i, TextCenter) ? "TextCenter" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m1860equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1862hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1863toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1864unboximpl() {
        return this.value;
    }
}
