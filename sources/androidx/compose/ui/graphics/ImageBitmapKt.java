package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ImageBitmapKt {
    @NotNull
    /* renamed from: ImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m1151ImageBitmapx__hDU(int i, int i2, int i3, boolean z, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return AndroidImageBitmap_androidKt.m1037ActualImageBitmapx__hDU(i, i2, i3, z, colorSpace);
    }

    /* renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static /* synthetic */ ImageBitmap m1152ImageBitmapx__hDU$default(int i, int i2, int i3, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = ImageBitmapConfig.Companion.m1147getArgb8888_sVssgQ();
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m1151ImageBitmapx__hDU(i, i2, i3, z, colorSpace);
    }

    @NotNull
    public static final PixelMap toPixelMap(@NotNull ImageBitmap imageBitmap, int i, int i2, int i3, int i4, @NotNull int[] iArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(imageBitmap, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "buffer");
        imageBitmap.readPixels(iArr, i, i2, i3, i4, i5, i6);
        return new PixelMap(iArr, i3, i4, i5, i6);
    }

    public static /* synthetic */ PixelMap toPixelMap$default(ImageBitmap imageBitmap, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = 0;
        }
        if ((i7 & 2) != 0) {
            i2 = 0;
        }
        if ((i7 & 4) != 0) {
            i3 = imageBitmap.getWidth();
        }
        if ((i7 & 8) != 0) {
            i4 = imageBitmap.getHeight();
        }
        if ((i7 & 16) != 0) {
            iArr = new int[i3 * i4];
        }
        if ((i7 & 32) != 0) {
            i5 = 0;
        }
        if ((i7 & 64) != 0) {
            i6 = i3;
        }
        return toPixelMap(imageBitmap, i, i2, i3, i4, iArr, i5, i6);
    }
}
