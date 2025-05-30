package androidx.compose.foundation.layout;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WindowInsetsSides {
    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;
    private final int value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m403getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m404getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m405getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m406getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m407getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m408getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m409getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m410getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m411getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m412getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m413getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m414getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    static {
        int m394constructorimpl = m394constructorimpl(8);
        AllowLeftInLtr = m394constructorimpl;
        int m394constructorimpl2 = m394constructorimpl(4);
        AllowRightInLtr = m394constructorimpl2;
        int m394constructorimpl3 = m394constructorimpl(2);
        AllowLeftInRtl = m394constructorimpl3;
        int m394constructorimpl4 = m394constructorimpl(1);
        AllowRightInRtl = m394constructorimpl4;
        Start = m399plusgK_yJZ4(m394constructorimpl, m394constructorimpl4);
        End = m399plusgK_yJZ4(m394constructorimpl2, m394constructorimpl3);
        int m394constructorimpl5 = m394constructorimpl(16);
        Top = m394constructorimpl5;
        int m394constructorimpl6 = m394constructorimpl(32);
        Bottom = m394constructorimpl6;
        int m399plusgK_yJZ4 = m399plusgK_yJZ4(m394constructorimpl, m394constructorimpl3);
        Left = m399plusgK_yJZ4;
        int m399plusgK_yJZ42 = m399plusgK_yJZ4(m394constructorimpl2, m394constructorimpl4);
        Right = m399plusgK_yJZ42;
        Horizontal = m399plusgK_yJZ4(m399plusgK_yJZ4, m399plusgK_yJZ42);
        Vertical = m399plusgK_yJZ4(m394constructorimpl5, m394constructorimpl6);
    }

    private /* synthetic */ WindowInsetsSides(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m393boximpl(int i) {
        return new WindowInsetsSides(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m394constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m395equalsimpl(int i, Object obj) {
        return (obj instanceof WindowInsetsSides) && i == ((WindowInsetsSides) obj).m402unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m396equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hasAny-bkgdKaI$foundation_layout_release, reason: not valid java name */
    public static final boolean m397hasAnybkgdKaI$foundation_layout_release(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m398hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m399plusgK_yJZ4(int i, int i2) {
        return m394constructorimpl(i | i2);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m400toStringimpl(int i) {
        return "WindowInsetsSides(" + m401valueToStringimpl(i) + ')';
    }

    /* renamed from: valueToString-impl, reason: not valid java name */
    private static final String m401valueToStringimpl(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = Start;
        if ((i & i2) == i2) {
            valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        int i3 = Left;
        if ((i & i3) == i3) {
            valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        int i4 = Top;
        if ((i & i4) == i4) {
            valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        int i5 = End;
        if ((i & i5) == i5) {
            valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        int i6 = Right;
        if ((i & i6) == i6) {
            valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        int i7 = Bottom;
        if ((i & i7) == i7) {
            valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public boolean equals(Object obj) {
        return m395equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m398hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m400toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m402unboximpl() {
        return this.value;
    }
}
