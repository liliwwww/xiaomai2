package androidx.compose.ui.text.style;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LineHeightStyle$Trim {
    private static final int FlagTrimBottom = 16;
    private static final int FlagTrimTop = 1;
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int FirstLineTop = m2055constructorimpl(1);
    private static final int LastLineBottom = m2055constructorimpl(16);
    private static final int Both = m2055constructorimpl(17);
    private static final int None = m2055constructorimpl(0);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBoth-EVpEnUU, reason: not valid java name */
        public final int m2063getBothEVpEnUU() {
            return LineHeightStyle$Trim.Both;
        }

        /* renamed from: getFirstLineTop-EVpEnUU, reason: not valid java name */
        public final int m2064getFirstLineTopEVpEnUU() {
            return LineHeightStyle$Trim.FirstLineTop;
        }

        /* renamed from: getLastLineBottom-EVpEnUU, reason: not valid java name */
        public final int m2065getLastLineBottomEVpEnUU() {
            return LineHeightStyle$Trim.LastLineBottom;
        }

        /* renamed from: getNone-EVpEnUU, reason: not valid java name */
        public final int m2066getNoneEVpEnUU() {
            return LineHeightStyle$Trim.None;
        }
    }

    private /* synthetic */ LineHeightStyle$Trim(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineHeightStyle$Trim m2054boximpl(int i) {
        return new LineHeightStyle$Trim(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2055constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2056equalsimpl(int i, Object obj) {
        return (obj instanceof LineHeightStyle$Trim) && i == ((LineHeightStyle$Trim) obj).m2062unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2057equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2058hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2059isTrimFirstLineTopimpl$ui_text_release(int i) {
        return (i & 1) > 0;
    }

    /* renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2060isTrimLastLineBottomimpl$ui_text_release(int i) {
        return (i & 16) > 0;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2061toStringimpl(int i) {
        return i == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i == Both ? "LineHeightStyle.Trim.Both" : i == None ? "LineHeightStyle.Trim.None" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2056equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2058hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2061toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2062unboximpl() {
        return this.value;
    }
}
