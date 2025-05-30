package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(27)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class BitmapCompat$Api27Impl {
    private BitmapCompat$Api27Impl() {
    }

    @DoNotInline
    static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
        if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (Build.VERSION.SDK_INT >= 31) {
            config = BitmapCompat$Api31Impl.getHardwareBitmapConfig(bitmap);
        }
        return bitmap.copy(config, true);
    }

    @DoNotInline
    static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
        Bitmap.Config config = bitmap.getConfig();
        ColorSpace colorSpace = bitmap.getColorSpace();
        ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
            config = Bitmap.Config.RGBA_F16;
            colorSpace = colorSpace2;
        } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = BitmapCompat$Api31Impl.getHardwareBitmapConfig(bitmap);
            }
        }
        return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
    }

    @DoNotInline
    static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
        return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
    }
}
