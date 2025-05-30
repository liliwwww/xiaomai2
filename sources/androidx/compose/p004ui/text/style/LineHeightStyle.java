package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class LineHeightStyle {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    /* compiled from: Taobao */
    @JvmInline
    /* loaded from: classes.dex */
    public static final class Alignment {
        private final float topRatio;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final float Top = m5045constructorimpl(0.0f);
        private static final float Center = m5045constructorimpl(0.5f);
        private static final float Proportional = m5045constructorimpl(-1.0f);
        private static final float Bottom = m5045constructorimpl(1.0f);

        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBottom-PIaL0Z0$annotations, reason: not valid java name */
            public static /* synthetic */ void m5051getBottomPIaL0Z0$annotations() {
            }

            /* renamed from: getCenter-PIaL0Z0$annotations, reason: not valid java name */
            public static /* synthetic */ void m5052getCenterPIaL0Z0$annotations() {
            }

            /* renamed from: getProportional-PIaL0Z0$annotations, reason: not valid java name */
            public static /* synthetic */ void m5053getProportionalPIaL0Z0$annotations() {
            }

            /* renamed from: getTop-PIaL0Z0$annotations, reason: not valid java name */
            public static /* synthetic */ void m5054getTopPIaL0Z0$annotations() {
            }

            /* renamed from: getBottom-PIaL0Z0, reason: not valid java name */
            public final float m5055getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }

            /* renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m5056getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m5057getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* renamed from: getTop-PIaL0Z0, reason: not valid java name */
            public final float m5058getTopPIaL0Z0() {
                return Alignment.Top;
            }
        }

        @ExperimentalTextApi
        private /* synthetic */ Alignment(float f) {
            this.topRatio = f;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Alignment m5044boximpl(float f) {
            return new Alignment(f);
        }

        @ExperimentalTextApi
        /* renamed from: constructor-impl, reason: not valid java name */
        public static float m5045constructorimpl(float f) {
            boolean z = true;
            if (!(0.0f <= f && f <= 1.0f)) {
                if (!(f == -1.0f)) {
                    z = false;
                }
            }
            if (z) {
                return f;
            }
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5046equalsimpl(float f, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f, ((Alignment) obj).m5050unboximpl()) == 0;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5047equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5048hashCodeimpl(float f) {
            return Float.floatToIntBits(f);
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5049toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        public boolean equals(Object obj) {
            return m5046equalsimpl(this.topRatio, obj);
        }

        public int hashCode() {
            return m5048hashCodeimpl(this.topRatio);
        }

        @NotNull
        public String toString() {
            return m5049toStringimpl(this.topRatio);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ float m5050unboximpl() {
            return this.topRatio;
        }
    }

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    /* loaded from: classes.dex */
    public static final class Trim {
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int FirstLineTop = m5060constructorimpl(1);
        private static final int LastLineBottom = m5060constructorimpl(16);
        private static final int Both = m5060constructorimpl(17);
        private static final int None = m5060constructorimpl(0);

        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m5068getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getFirstLineTop-EVpEnUU, reason: not valid java name */
            public final int m5069getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* renamed from: getLastLineBottom-EVpEnUU, reason: not valid java name */
            public final int m5070getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m5071getNoneEVpEnUU() {
                return Trim.None;
            }
        }

        private /* synthetic */ Trim(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Trim m5059boximpl(int i) {
            return new Trim(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m5060constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5061equalsimpl(int i, Object obj) {
            return (obj instanceof Trim) && i == ((Trim) obj).m5067unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5062equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5063hashCodeimpl(int i) {
            return i;
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
        public static final boolean m5064isTrimFirstLineTopimpl$ui_text_release(int i) {
            return (i & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
        public static final boolean m5065isTrimLastLineBottomimpl$ui_text_release(int i) {
            return (i & 16) > 0;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5066toStringimpl(int i) {
            return i == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i == Both ? "LineHeightStyle.Trim.Both" : i == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5061equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5063hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5066toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5067unboximpl() {
            return this.value;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Default = new LineHeightStyle(Alignment.Companion.m5057getProportionalPIaL0Z0(), Trim.Companion.m5068getBothEVpEnUU(), defaultConstructorMarker);
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.m5047equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m5062equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    /* renamed from: getAlignment-PIaL0Z0, reason: not valid java name */
    public final float m5042getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU, reason: not valid java name */
    public final int m5043getTrimEVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.m5048hashCodeimpl(this.alignment) * 31) + Trim.m5063hashCodeimpl(this.trim);
    }

    @NotNull
    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m5049toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m5066toStringimpl(this.trim)) + ')';
    }
}
