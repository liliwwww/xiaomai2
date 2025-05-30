package androidx.compose.p004ui.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.util.DisplayMetrics;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.graphics.colorspace.ColorSpace;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: classes2.dex */
final class Api26Bitmap {

    @NotNull
    public static final Api26Bitmap INSTANCE = new Api26Bitmap();

    private Api26Bitmap() {
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final ColorSpace composeColorSpace$ui_graphics_release(@NotNull Bitmap bitmap) {
        ColorSpace composeColorSpace$ui_graphics_release;
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        android.graphics.ColorSpace colorSpace = bitmap.getColorSpace();
        return (colorSpace == null || (composeColorSpace$ui_graphics_release = composeColorSpace$ui_graphics_release(colorSpace)) == null) ? ColorSpaces.INSTANCE.getSrgb() : composeColorSpace$ui_graphics_release;
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    /* renamed from: createBitmap-x__-hDU$ui_graphics_release, reason: not valid java name */
    public static final Bitmap m2702createBitmapx__hDU$ui_graphics_release(int i, int i2, int i3, boolean z, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap((DisplayMetrics) null, i, i2, AndroidImageBitmap_androidKt.m2667toBitmapConfig1JJdX4A(i3), z, toFrameworkColorSpace$ui_graphics_release(colorSpace));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          …orkColorSpace()\n        )");
        return createBitmap;
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final android.graphics.ColorSpace toFrameworkColorSpace$ui_graphics_release(@NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        android.graphics.ColorSpace colorSpace2 = android.graphics.ColorSpace.get(Intrinsics.areEqual(colorSpace, colorSpaces.getSrgb()) ? ColorSpace.Named.SRGB : Intrinsics.areEqual(colorSpace, colorSpaces.getAces()) ? ColorSpace.Named.ACES : Intrinsics.areEqual(colorSpace, colorSpaces.getAcescg()) ? ColorSpace.Named.ACESCG : Intrinsics.areEqual(colorSpace, colorSpaces.getAdobeRgb()) ? ColorSpace.Named.ADOBE_RGB : Intrinsics.areEqual(colorSpace, colorSpaces.getBt2020()) ? ColorSpace.Named.BT2020 : Intrinsics.areEqual(colorSpace, colorSpaces.getBt709()) ? ColorSpace.Named.BT709 : Intrinsics.areEqual(colorSpace, colorSpaces.getCieLab()) ? ColorSpace.Named.CIE_LAB : Intrinsics.areEqual(colorSpace, colorSpaces.getCieXyz()) ? ColorSpace.Named.CIE_XYZ : Intrinsics.areEqual(colorSpace, colorSpaces.getDciP3()) ? ColorSpace.Named.DCI_P3 : Intrinsics.areEqual(colorSpace, colorSpaces.getDisplayP3()) ? ColorSpace.Named.DISPLAY_P3 : Intrinsics.areEqual(colorSpace, colorSpaces.getExtendedSrgb()) ? ColorSpace.Named.EXTENDED_SRGB : Intrinsics.areEqual(colorSpace, colorSpaces.getLinearExtendedSrgb()) ? ColorSpace.Named.LINEAR_EXTENDED_SRGB : Intrinsics.areEqual(colorSpace, colorSpaces.getLinearSrgb()) ? ColorSpace.Named.LINEAR_SRGB : Intrinsics.areEqual(colorSpace, colorSpaces.getNtsc1953()) ? ColorSpace.Named.NTSC_1953 : Intrinsics.areEqual(colorSpace, colorSpaces.getProPhotoRgb()) ? ColorSpace.Named.PRO_PHOTO_RGB : Intrinsics.areEqual(colorSpace, colorSpaces.getSmpteC()) ? ColorSpace.Named.SMPTE_C : ColorSpace.Named.SRGB);
        Intrinsics.checkNotNullExpressionValue(colorSpace2, "get(frameworkNamedSpace)");
        return colorSpace2;
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final androidx.compose.p004ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(@NotNull android.graphics.ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        return Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.SRGB)) ? ColorSpaces.INSTANCE.getSrgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ACES)) ? ColorSpaces.INSTANCE.getAces() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ACESCG)) ? ColorSpaces.INSTANCE.getAcescg() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.ADOBE_RGB)) ? ColorSpaces.INSTANCE.getAdobeRgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.BT2020)) ? ColorSpaces.INSTANCE.getBt2020() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.BT709)) ? ColorSpaces.INSTANCE.getBt709() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.CIE_LAB)) ? ColorSpaces.INSTANCE.getCieLab() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.CIE_XYZ)) ? ColorSpaces.INSTANCE.getCieXyz() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.DCI_P3)) ? ColorSpaces.INSTANCE.getDciP3() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.DISPLAY_P3)) ? ColorSpaces.INSTANCE.getDisplayP3() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB)) ? ColorSpaces.INSTANCE.getExtendedSrgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB)) ? ColorSpaces.INSTANCE.getLinearExtendedSrgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_SRGB)) ? ColorSpaces.INSTANCE.getLinearSrgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.NTSC_1953)) ? ColorSpaces.INSTANCE.getNtsc1953() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB)) ? ColorSpaces.INSTANCE.getProPhotoRgb() : Intrinsics.areEqual(colorSpace, android.graphics.ColorSpace.get(ColorSpace.Named.SMPTE_C)) ? ColorSpaces.INSTANCE.getSmpteC() : ColorSpaces.INSTANCE.getSrgb();
    }
}
