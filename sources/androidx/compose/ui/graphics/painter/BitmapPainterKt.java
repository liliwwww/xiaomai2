package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BitmapPainterKt {
    @NotNull
    /* renamed from: BitmapPainter-QZhYCtY, reason: not valid java name */
    public static final BitmapPainter m1350BitmapPainterQZhYCtY(@NotNull ImageBitmap imageBitmap, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, j, j2, (DefaultConstructorMarker) null);
        bitmapPainter.setFilterQuality-vDHp3xo$ui_graphics_release(i);
        return bitmapPainter;
    }

    /* renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static /* synthetic */ BitmapPainter m1351BitmapPainterQZhYCtY$default(ImageBitmap imageBitmap, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = IntOffset.Companion.getZero-nOcc-ac();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = FilterQuality.Companion.m1086getLowfv9h1I();
        }
        return m1350BitmapPainterQZhYCtY(imageBitmap, j3, j4, i);
    }
}
