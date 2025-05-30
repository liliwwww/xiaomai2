package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BlendMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m972constructorimpl(0);
    private static final int Src = m972constructorimpl(1);
    private static final int Dst = m972constructorimpl(2);
    private static final int SrcOver = m972constructorimpl(3);
    private static final int DstOver = m972constructorimpl(4);
    private static final int SrcIn = m972constructorimpl(5);
    private static final int DstIn = m972constructorimpl(6);
    private static final int SrcOut = m972constructorimpl(7);
    private static final int DstOut = m972constructorimpl(8);
    private static final int SrcAtop = m972constructorimpl(9);
    private static final int DstAtop = m972constructorimpl(10);
    private static final int Xor = m972constructorimpl(11);
    private static final int Plus = m972constructorimpl(12);
    private static final int Modulate = m972constructorimpl(13);
    private static final int Screen = m972constructorimpl(14);
    private static final int Overlay = m972constructorimpl(15);
    private static final int Darken = m972constructorimpl(16);
    private static final int Lighten = m972constructorimpl(17);
    private static final int ColorDodge = m972constructorimpl(18);
    private static final int ColorBurn = m972constructorimpl(19);
    private static final int Hardlight = m972constructorimpl(20);
    private static final int Softlight = m972constructorimpl(21);
    private static final int Difference = m972constructorimpl(22);
    private static final int Exclusion = m972constructorimpl(23);
    private static final int Multiply = m972constructorimpl(24);
    private static final int Hue = m972constructorimpl(25);
    private static final int Saturation = m972constructorimpl(26);
    private static final int Color = m972constructorimpl(27);
    private static final int Luminosity = m972constructorimpl(28);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m978getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m979getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m980getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m981getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m982getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m983getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m984getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m985getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m986getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m987getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m988getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m989getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m990getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m991getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m992getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m993getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m994getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m995getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m996getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m997getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m998getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m999getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m1000getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m1001getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m1002getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m1003getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m1004getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m1005getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m1006getXor0nO6VwU() {
            return BlendMode.Xor;
        }
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m971boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m972constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m973equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m977unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m974equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m975hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m976toStringimpl(int i) {
        return m974equalsimpl0(i, Clear) ? "Clear" : m974equalsimpl0(i, Src) ? "Src" : m974equalsimpl0(i, Dst) ? "Dst" : m974equalsimpl0(i, SrcOver) ? "SrcOver" : m974equalsimpl0(i, DstOver) ? "DstOver" : m974equalsimpl0(i, SrcIn) ? "SrcIn" : m974equalsimpl0(i, DstIn) ? "DstIn" : m974equalsimpl0(i, SrcOut) ? "SrcOut" : m974equalsimpl0(i, DstOut) ? "DstOut" : m974equalsimpl0(i, SrcAtop) ? "SrcAtop" : m974equalsimpl0(i, DstAtop) ? "DstAtop" : m974equalsimpl0(i, Xor) ? "Xor" : m974equalsimpl0(i, Plus) ? "Plus" : m974equalsimpl0(i, Modulate) ? "Modulate" : m974equalsimpl0(i, Screen) ? "Screen" : m974equalsimpl0(i, Overlay) ? "Overlay" : m974equalsimpl0(i, Darken) ? "Darken" : m974equalsimpl0(i, Lighten) ? "Lighten" : m974equalsimpl0(i, ColorDodge) ? "ColorDodge" : m974equalsimpl0(i, ColorBurn) ? "ColorBurn" : m974equalsimpl0(i, Hardlight) ? "HardLight" : m974equalsimpl0(i, Softlight) ? "Softlight" : m974equalsimpl0(i, Difference) ? "Difference" : m974equalsimpl0(i, Exclusion) ? "Exclusion" : m974equalsimpl0(i, Multiply) ? "Multiply" : m974equalsimpl0(i, Hue) ? "Hue" : m974equalsimpl0(i, Saturation) ? ExifInterface.TAG_SATURATION : m974equalsimpl0(i, Color) ? "Color" : m974equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m973equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m975hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m976toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m977unboximpl() {
        return this.value;
    }
}
