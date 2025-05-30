package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class BlendMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m2704constructorimpl(0);
    private static final int Src = m2704constructorimpl(1);
    private static final int Dst = m2704constructorimpl(2);
    private static final int SrcOver = m2704constructorimpl(3);
    private static final int DstOver = m2704constructorimpl(4);
    private static final int SrcIn = m2704constructorimpl(5);
    private static final int DstIn = m2704constructorimpl(6);
    private static final int SrcOut = m2704constructorimpl(7);
    private static final int DstOut = m2704constructorimpl(8);
    private static final int SrcAtop = m2704constructorimpl(9);
    private static final int DstAtop = m2704constructorimpl(10);
    private static final int Xor = m2704constructorimpl(11);
    private static final int Plus = m2704constructorimpl(12);
    private static final int Modulate = m2704constructorimpl(13);
    private static final int Screen = m2704constructorimpl(14);
    private static final int Overlay = m2704constructorimpl(15);
    private static final int Darken = m2704constructorimpl(16);
    private static final int Lighten = m2704constructorimpl(17);
    private static final int ColorDodge = m2704constructorimpl(18);
    private static final int ColorBurn = m2704constructorimpl(19);
    private static final int Hardlight = m2704constructorimpl(20);
    private static final int Softlight = m2704constructorimpl(21);
    private static final int Difference = m2704constructorimpl(22);
    private static final int Exclusion = m2704constructorimpl(23);
    private static final int Multiply = m2704constructorimpl(24);
    private static final int Hue = m2704constructorimpl(25);
    private static final int Saturation = m2704constructorimpl(26);
    private static final int Color = m2704constructorimpl(27);
    private static final int Luminosity = m2704constructorimpl(28);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m2710getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m2711getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m2712getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m2713getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m2714getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m2715getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m2716getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m2717getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m2718getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m2719getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m2720getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m2721getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m2722getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m2723getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m2724getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m2725getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m2726getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m2727getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m2728getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m2729getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m2730getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m2731getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m2732getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m2733getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m2734getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m2735getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m2736getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m2737getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m2738getXor0nO6VwU() {
            return BlendMode.Xor;
        }
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m2703boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2704constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2705equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m2709unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2706equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2707hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2708toStringimpl(int i) {
        return m2706equalsimpl0(i, Clear) ? "Clear" : m2706equalsimpl0(i, Src) ? "Src" : m2706equalsimpl0(i, Dst) ? "Dst" : m2706equalsimpl0(i, SrcOver) ? "SrcOver" : m2706equalsimpl0(i, DstOver) ? "DstOver" : m2706equalsimpl0(i, SrcIn) ? "SrcIn" : m2706equalsimpl0(i, DstIn) ? "DstIn" : m2706equalsimpl0(i, SrcOut) ? "SrcOut" : m2706equalsimpl0(i, DstOut) ? "DstOut" : m2706equalsimpl0(i, SrcAtop) ? "SrcAtop" : m2706equalsimpl0(i, DstAtop) ? "DstAtop" : m2706equalsimpl0(i, Xor) ? "Xor" : m2706equalsimpl0(i, Plus) ? "Plus" : m2706equalsimpl0(i, Modulate) ? "Modulate" : m2706equalsimpl0(i, Screen) ? "Screen" : m2706equalsimpl0(i, Overlay) ? "Overlay" : m2706equalsimpl0(i, Darken) ? "Darken" : m2706equalsimpl0(i, Lighten) ? "Lighten" : m2706equalsimpl0(i, ColorDodge) ? "ColorDodge" : m2706equalsimpl0(i, ColorBurn) ? "ColorBurn" : m2706equalsimpl0(i, Hardlight) ? "HardLight" : m2706equalsimpl0(i, Softlight) ? "Softlight" : m2706equalsimpl0(i, Difference) ? "Difference" : m2706equalsimpl0(i, Exclusion) ? "Exclusion" : m2706equalsimpl0(i, Multiply) ? "Multiply" : m2706equalsimpl0(i, Hue) ? "Hue" : m2706equalsimpl0(i, Saturation) ? ExifInterface.TAG_SATURATION : m2706equalsimpl0(i, Color) ? "Color" : m2706equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m2705equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2707hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2708toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2709unboximpl() {
        return this.value;
    }
}
