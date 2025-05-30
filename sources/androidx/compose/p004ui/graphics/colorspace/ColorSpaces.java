package androidx.compose.p004ui.graphics.colorspace;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.qy;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ColorSpaces {

    @NotNull
    private static final Rgb Aces;

    @NotNull
    private static final Rgb Acescg;

    @NotNull
    private static final Rgb AdobeRgb;

    @NotNull
    private static final Rgb Bt2020;

    @NotNull
    private static final Rgb Bt709;

    @NotNull
    private static final ColorSpace CieLab;

    @NotNull
    private static final ColorSpace CieXyz;

    @NotNull
    private static final ColorSpace[] ColorSpacesArray;

    @NotNull
    private static final Rgb DciP3;

    @NotNull
    private static final Rgb DisplayP3;

    @NotNull
    private static final Rgb ExtendedSrgb;

    @NotNull
    public static final ColorSpaces INSTANCE = new ColorSpaces();

    @NotNull
    private static final Rgb LinearExtendedSrgb;

    @NotNull
    private static final Rgb LinearSrgb;

    @NotNull
    private static final TransferParameters NoneTransferParameters;

    @NotNull
    private static final Rgb Ntsc1953;

    @NotNull
    private static final float[] Ntsc1953Primaries;

    @NotNull
    private static final ColorSpace Oklab;

    @NotNull
    private static final Rgb ProPhotoRgb;

    @NotNull
    private static final Rgb SmpteC;

    @NotNull
    private static final Rgb Srgb;

    @NotNull
    private static final float[] SrgbPrimaries;

    @NotNull
    private static final TransferParameters SrgbTransferParameters;

    @NotNull
    private static final Rgb Unspecified;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        SrgbPrimaries = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        Ntsc1953Primaries = fArr2;
        TransferParameters transferParameters = new TransferParameters(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        SrgbTransferParameters = transferParameters;
        TransferParameters transferParameters2 = new TransferParameters(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        NoneTransferParameters = transferParameters2;
        Illuminant illuminant = Illuminant.INSTANCE;
        Rgb rgb = new Rgb("sRGB IEC61966-2.1", fArr, illuminant.getD65(), transferParameters, 0);
        Srgb = rgb;
        Rgb rgb2 = new Rgb("sRGB IEC61966-2.1 (Linear)", fArr, illuminant.getD65(), 1.0d, 0.0f, 1.0f, 1);
        LinearSrgb = rgb2;
        Rgb rgb3 = new Rgb("scRGB-nl IEC 61966-2-2:2003", fArr, illuminant.getD65(), null, qy.a, ry.a, -0.799f, 2.399f, transferParameters, 2);
        ExtendedSrgb = rgb3;
        Rgb rgb4 = new Rgb("scRGB IEC 61966-2-2:2003", fArr, illuminant.getD65(), 1.0d, -0.5f, 7.499f, 3);
        LinearExtendedSrgb = rgb4;
        Rgb rgb5 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 4);
        Bt709 = rgb5;
        Rgb rgb6 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, 0.0d, 0.0d, 96, null), 5);
        Bt2020 = rgb6;
        Rgb rgb7 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        DciP3 = rgb7;
        Rgb rgb8 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, illuminant.getD65(), transferParameters, 7);
        DisplayP3 = rgb8;
        Rgb rgb9 = new Rgb("NTSC (1953)", fArr2, illuminant.getC(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 8);
        Ntsc1953 = rgb9;
        Rgb rgb10 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, illuminant.getD65(), new TransferParameters(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 9);
        SmpteC = rgb10;
        Rgb rgb11 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, illuminant.getD65(), 2.2d, 0.0f, 1.0f, 10);
        AdobeRgb = rgb11;
        Rgb rgb12 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, illuminant.getD50(), new TransferParameters(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d, 0.0d, 0.0d, 96, null), 11);
        ProPhotoRgb = rgb12;
        Rgb rgb13 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, illuminant.getD60(), 1.0d, -65504.0f, 65504.0f, 12);
        Aces = rgb13;
        Rgb rgb14 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, illuminant.getD60(), 1.0d, -65504.0f, 65504.0f, 13);
        Acescg = rgb14;
        Xyz xyz = new Xyz("Generic XYZ", 14);
        CieXyz = xyz;
        Lab lab = new Lab("Generic L*a*b*", 15);
        CieLab = lab;
        Rgb rgb15 = new Rgb("None", fArr, illuminant.getD65(), transferParameters2, 16);
        Unspecified = rgb15;
        Oklab oklab = new Oklab("Oklab", 17);
        Oklab = oklab;
        ColorSpacesArray = new ColorSpace[]{rgb, rgb2, rgb3, rgb4, rgb5, rgb6, rgb7, rgb8, rgb9, rgb10, rgb11, rgb12, rgb13, rgb14, xyz, lab, rgb15, oklab};
    }

    private ColorSpaces() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double ExtendedSrgb$lambda$0(double d) {
        return ColorSpaceKt.absRcpResponse(d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double ExtendedSrgb$lambda$1(double d) {
        return ColorSpaceKt.absResponse(d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    @NotNull
    public final Rgb getAces() {
        return Aces;
    }

    @NotNull
    public final Rgb getAcescg() {
        return Acescg;
    }

    @NotNull
    public final Rgb getAdobeRgb() {
        return AdobeRgb;
    }

    @NotNull
    public final Rgb getBt2020() {
        return Bt2020;
    }

    @NotNull
    public final Rgb getBt709() {
        return Bt709;
    }

    @NotNull
    public final ColorSpace getCieLab() {
        return CieLab;
    }

    @NotNull
    public final ColorSpace getCieXyz() {
        return CieXyz;
    }

    @NotNull
    public final ColorSpace getColorSpace$ui_graphics_release(int i) {
        return getColorSpacesArray$ui_graphics_release()[i];
    }

    @NotNull
    public final ColorSpace[] getColorSpacesArray$ui_graphics_release() {
        return ColorSpacesArray;
    }

    @NotNull
    public final Rgb getDciP3() {
        return DciP3;
    }

    @NotNull
    public final Rgb getDisplayP3() {
        return DisplayP3;
    }

    @NotNull
    public final Rgb getExtendedSrgb() {
        return ExtendedSrgb;
    }

    @NotNull
    public final Rgb getLinearExtendedSrgb() {
        return LinearExtendedSrgb;
    }

    @NotNull
    public final Rgb getLinearSrgb() {
        return LinearSrgb;
    }

    @NotNull
    public final Rgb getNtsc1953() {
        return Ntsc1953;
    }

    @NotNull
    public final float[] getNtsc1953Primaries$ui_graphics_release() {
        return Ntsc1953Primaries;
    }

    @NotNull
    public final ColorSpace getOklab() {
        return Oklab;
    }

    @NotNull
    public final Rgb getProPhotoRgb() {
        return ProPhotoRgb;
    }

    @NotNull
    public final Rgb getSmpteC() {
        return SmpteC;
    }

    @NotNull
    public final Rgb getSrgb() {
        return Srgb;
    }

    @NotNull
    public final float[] getSrgbPrimaries$ui_graphics_release() {
        return SrgbPrimaries;
    }

    @NotNull
    public final TransferParameters getSrgbTransferParameters$ui_graphics_release() {
        return SrgbTransferParameters;
    }

    @NotNull
    public final Rgb getUnspecified$ui_graphics_release() {
        return Unspecified;
    }

    @Nullable
    public final ColorSpace match(@NotNull float[] fArr, @NotNull TransferParameters transferParameters) {
        Intrinsics.checkNotNullParameter(fArr, "toXYZD50");
        Intrinsics.checkNotNullParameter(transferParameters, "function");
        for (ColorSpace colorSpace : ColorSpacesArray) {
            if (ColorModel.m3146equalsimpl0(colorSpace.m3155getModelxdoWZVw(), ColorModel.Companion.m3153getRgbxdoWZVw())) {
                ColorSpace adapt$default = ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), null, 2, null);
                Intrinsics.checkNotNull(adapt$default, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
                Rgb rgb = (Rgb) adapt$default;
                if (ColorSpaceKt.compare(fArr, rgb.getTransform$ui_graphics_release()) && ColorSpaceKt.compare(transferParameters, rgb.getTransferParameters())) {
                    return colorSpace;
                }
            }
        }
        return null;
    }
}
