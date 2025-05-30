package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidImageBitmap implements ImageBitmap {

    @NotNull
    private final Bitmap bitmap;

    public AndroidImageBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
    }

    @NotNull
    public final Bitmap getBitmap$ui_graphics_release() {
        return this.bitmap;
    }

    @NotNull
    public ColorSpace getColorSpace() {
        if (Build.VERSION.SDK_INT < 26) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        Api26Bitmap api26Bitmap = Api26Bitmap.INSTANCE;
        return Api26Bitmap.composeColorSpace$ui_graphics_release(this.bitmap);
    }

    /* renamed from: getConfig-_sVssgQ, reason: not valid java name */
    public int m1036getConfig_sVssgQ() {
        Bitmap.Config config = this.bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
        return AndroidImageBitmap_androidKt.toImageConfig(config);
    }

    public boolean getHasAlpha() {
        return this.bitmap.hasAlpha();
    }

    public int getHeight() {
        return this.bitmap.getHeight();
    }

    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public void prepareToDraw() {
        this.bitmap.prepareToDraw();
    }

    public void readPixels(@NotNull int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "buffer");
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(this);
        if (Build.VERSION.SDK_INT < 26 || asAndroidBitmap.getConfig() != Bitmap.Config.HARDWARE) {
            z = false;
        } else {
            asAndroidBitmap = asAndroidBitmap.copy(Bitmap.Config.ARGB_8888, false);
            z = true;
        }
        asAndroidBitmap.getPixels(iArr, i5, i6, i, i2, i3, i4);
        if (z) {
            asAndroidBitmap.recycle();
        }
    }
}
