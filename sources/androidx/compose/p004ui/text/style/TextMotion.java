package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Immutable
@ExperimentalTextApi
/* loaded from: classes.dex */
public final class TextMotion {

    @NotNull
    private static final TextMotion Animated;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TextMotion getAnimated() {
            return TextMotion.Animated;
        }

        @NotNull
        public final TextMotion getStatic() {
            return TextMotion.Static;
        }
    }

    /* compiled from: Taobao */
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class Linearity {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Linear = m5109constructorimpl(1);
        private static final int FontHinting = m5109constructorimpl(2);
        private static final int None = m5109constructorimpl(3);

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getFontHinting-4e0Vf04, reason: not valid java name */
            public final int m5115getFontHinting4e0Vf04() {
                return Linearity.FontHinting;
            }

            /* renamed from: getLinear-4e0Vf04, reason: not valid java name */
            public final int m5116getLinear4e0Vf04() {
                return Linearity.Linear;
            }

            /* renamed from: getNone-4e0Vf04, reason: not valid java name */
            public final int m5117getNone4e0Vf04() {
                return Linearity.None;
            }
        }

        private /* synthetic */ Linearity(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Linearity m5108boximpl(int i) {
            return new Linearity(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        private static int m5109constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m5110equalsimpl(int i, Object obj) {
            return (obj instanceof Linearity) && i == ((Linearity) obj).m5114unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5111equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m5112hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m5113toStringimpl(int i) {
            return m5111equalsimpl0(i, Linear) ? "Linearity.Linear" : m5111equalsimpl0(i, FontHinting) ? "Linearity.FontHinting" : m5111equalsimpl0(i, None) ? "Linearity.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5110equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5112hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5113toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5114unboximpl() {
            return this.value;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Linearity.Companion companion = Linearity.Companion;
        Static = new TextMotion(companion.m5115getFontHinting4e0Vf04(), false, defaultConstructorMarker);
        Animated = new TextMotion(companion.m5116getLinear4e0Vf04(), true, defaultConstructorMarker);
    }

    private TextMotion(int i, boolean z) {
        this.linearity = i;
        this.subpixelTextPositioning = z;
    }

    public /* synthetic */ TextMotion(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    /* renamed from: copy-JdDtMQo$ui_text_release$default, reason: not valid java name */
    public static /* synthetic */ TextMotion m5105copyJdDtMQo$ui_text_release$default(TextMotion textMotion, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = textMotion.linearity;
        }
        if ((i2 & 2) != 0) {
            z = textMotion.subpixelTextPositioning;
        }
        return textMotion.m5106copyJdDtMQo$ui_text_release(i, z);
    }

    @NotNull
    /* renamed from: copy-JdDtMQo$ui_text_release, reason: not valid java name */
    public final TextMotion m5106copyJdDtMQo$ui_text_release(int i, boolean z) {
        return new TextMotion(i, z, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) obj;
        return Linearity.m5111equalsimpl0(this.linearity, textMotion.linearity) && this.subpixelTextPositioning == textMotion.subpixelTextPositioning;
    }

    /* renamed from: getLinearity-4e0Vf04$ui_text_release, reason: not valid java name */
    public final int m5107getLinearity4e0Vf04$ui_text_release() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text_release() {
        return this.subpixelTextPositioning;
    }

    public int hashCode() {
        return (Linearity.m5112hashCodeimpl(this.linearity) * 31) + l3.a(this.subpixelTextPositioning);
    }

    @NotNull
    public String toString() {
        return Intrinsics.areEqual(this, Static) ? "TextMotion.Static" : Intrinsics.areEqual(this, Animated) ? "TextMotion.Animated" : "Invalid";
    }
}
