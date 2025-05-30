package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DrawCache {

    @Nullable
    private Canvas cachedCanvas;

    @Nullable
    private ImageBitmap mCachedImage;

    @Nullable
    private Density scopeDensity;

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.Companion.m2690getZeroYbymL2g();

    @NotNull
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    private final void clear(DrawScope drawScope) {
        w51.K(drawScope, Color.Companion.m1074getBlack0d7_KjU(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getClear-0nO6VwU(), 62, (Object) null);
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f, colorFilter);
    }

    @PublishedApi
    public static /* synthetic */ void getMCachedImage$annotations() {
    }

    /* renamed from: drawCachedImage-CJJAR-o, reason: not valid java name */
    public final void m1321drawCachedImageCJJARo(long j, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmap = this.mCachedImage;
        Canvas canvas = this.cachedCanvas;
        if (imageBitmap == null || canvas == null || IntSize.m2685getWidthimpl(j) > imageBitmap.getWidth() || IntSize.m2684getHeightimpl(j) > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m1152ImageBitmapx__hDU$default(IntSize.m2685getWidthimpl(j), IntSize.m2684getHeightimpl(j), 0, false, null, 28, null);
            canvas = CanvasKt.Canvas(imageBitmap);
            this.mCachedImage = imageBitmap;
            this.cachedCanvas = canvas;
        }
        this.size = j;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long j2 = IntSizeKt.toSize-ozmzZPI(j);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long j3 = drawParams.component4-NH-jbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.setSize-uvyYCjk(j2);
        canvas.save();
        clear(canvasDrawScope);
        function1.invoke(canvasDrawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.setSize-uvyYCjk(j3);
        imageBitmap.prepareToDraw();
    }

    public final void drawInto(@NotNull DrawScope drawScope, float f, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(drawScope, TypedValues.AttributesType.S_TARGET);
        ImageBitmap imageBitmap = this.mCachedImage;
        if (!(imageBitmap != null)) {
            throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
        }
        w51.z(drawScope, imageBitmap, 0L, this.size, 0L, 0L, f, (DrawStyle) null, colorFilter, 0, 0, 858, (Object) null);
    }

    @Nullable
    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(@Nullable ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }
}
