package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class HandleImageCache {

    @NotNull
    public static final HandleImageCache INSTANCE = new HandleImageCache();

    @Nullable
    private static Canvas canvas;

    @Nullable
    private static CanvasDrawScope canvasDrawScope;

    @Nullable
    private static ImageBitmap imageBitmap;

    private HandleImageCache() {
    }

    @Nullable
    public final Canvas getCanvas() {
        return canvas;
    }

    @Nullable
    public final CanvasDrawScope getCanvasDrawScope() {
        return canvasDrawScope;
    }

    @Nullable
    public final ImageBitmap getImageBitmap() {
        return imageBitmap;
    }

    public final void setCanvas(@Nullable Canvas canvas2) {
        canvas = canvas2;
    }

    public final void setCanvasDrawScope(@Nullable CanvasDrawScope canvasDrawScope2) {
        canvasDrawScope = canvasDrawScope2;
    }

    public final void setImageBitmap(@Nullable ImageBitmap imageBitmap2) {
        imageBitmap = imageBitmap2;
    }
}
