package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p004ui.graphics.BlendMode;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.FilterQuality;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.PaintingStyle;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {

    @Nullable
    private Paint fillPaint;

    @Nullable
    private Paint strokePaint;

    @NotNull
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);

    @NotNull
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1

        @NotNull
        private final DrawTransform transform;

        {
            DrawTransform asDrawTransform;
            asDrawTransform = CanvasDrawScopeKt.asDrawTransform(this);
            this.transform = asDrawTransform;
        }

        @Override // androidx.compose.p004ui.graphics.drawscope.DrawContext
        @NotNull
        public Canvas getCanvas() {
            return CanvasDrawScope.this.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.p004ui.graphics.drawscope.DrawContext
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo3211getSizeNHjbRc() {
            return CanvasDrawScope.this.getDrawParams().m3209getSizeNHjbRc();
        }

        @Override // androidx.compose.p004ui.graphics.drawscope.DrawContext
        @NotNull
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.p004ui.graphics.drawscope.DrawContext
        /* renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo3212setSizeuvyYCjk(long j) {
            CanvasDrawScope.this.getDrawParams().m3210setSizeuvyYCjk(j);
        }
    };

    /* renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m3175configurePaint2qPWKa0(long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint selectPaint = selectPaint(drawStyle);
        long m3183modulate5vOe2sY = m3183modulate5vOe2sY(j, f);
        if (!Color.m2788equalsimpl0(selectPaint.mo2671getColor0d7_KjU(), m3183modulate5vOe2sY)) {
            selectPaint.mo2677setColor8_81llA(m3183modulate5vOe2sY);
        }
        if (selectPaint.getShader() != null) {
            selectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(selectPaint.getColorFilter(), colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2706equalsimpl0(selectPaint.mo2670getBlendMode0nO6VwU(), i)) {
            selectPaint.mo2676setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m2877equalsimpl0(selectPaint.mo2672getFilterQualityfv9h1I(), i2)) {
            selectPaint.mo2678setFilterQualityvDHp3xo(i2);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m3176configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        return canvasDrawScope.m3175configurePaint2qPWKa0(j, drawStyle, f, colorFilter, i, (i3 & 32) != 0 ? DrawScope.Companion.m3236getDefaultFilterQualityfv9h1I() : i2);
    }

    /* renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m3177configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2) {
        Paint selectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo2740applyToPq9zytI(mo3205getSizeNHjbRc(), selectPaint, f);
        } else {
            if (!(selectPaint.getAlpha() == f)) {
                selectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(selectPaint.getColorFilter(), colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2706equalsimpl0(selectPaint.mo2670getBlendMode0nO6VwU(), i)) {
            selectPaint.mo2676setBlendModes9anfk8(i);
        }
        if (!FilterQuality.m2877equalsimpl0(selectPaint.mo2672getFilterQualityfv9h1I(), i2)) {
            selectPaint.mo2678setFilterQualityvDHp3xo(i2);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m3178configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = DrawScope.Companion.m3236getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m3177configurePaintswdJneE(brush, drawStyle, f, colorFilter, i, i2);
    }

    /* renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m3179configureStrokePaintQ_0CZUI(long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint obtainStrokePaint = obtainStrokePaint();
        long m3183modulate5vOe2sY = m3183modulate5vOe2sY(j, f3);
        if (!Color.m2788equalsimpl0(obtainStrokePaint.mo2671getColor0d7_KjU(), m3183modulate5vOe2sY)) {
            obtainStrokePaint.mo2677setColor8_81llA(m3183modulate5vOe2sY);
        }
        if (obtainStrokePaint.getShader() != null) {
            obtainStrokePaint.setShader(null);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getColorFilter(), colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2706equalsimpl0(obtainStrokePaint.mo2670getBlendMode0nO6VwU(), i3)) {
            obtainStrokePaint.mo2676setBlendModes9anfk8(i3);
        }
        if (!(obtainStrokePaint.getStrokeWidth() == f)) {
            obtainStrokePaint.setStrokeWidth(f);
        }
        if (!(obtainStrokePaint.getStrokeMiterLimit() == f2)) {
            obtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3088equalsimpl0(obtainStrokePaint.mo2673getStrokeCapKaPHkGw(), i)) {
            obtainStrokePaint.mo2679setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3098equalsimpl0(obtainStrokePaint.mo2674getStrokeJoinLxFBmk8(), i2)) {
            obtainStrokePaint.mo2680setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m2877equalsimpl0(obtainStrokePaint.mo2672getFilterQualityfv9h1I(), i4)) {
            obtainStrokePaint.mo2678setFilterQualityvDHp3xo(i4);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m3180configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3179configureStrokePaintQ_0CZUI(j, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3236getDefaultFilterQualityfv9h1I() : i4);
    }

    /* renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m3181configureStrokePaintho4zsrM(Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4) {
        Paint obtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo2740applyToPq9zytI(mo3205getSizeNHjbRc(), obtainStrokePaint, f3);
        } else {
            if (!(obtainStrokePaint.getAlpha() == f3)) {
                obtainStrokePaint.setAlpha(f3);
            }
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getColorFilter(), colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2706equalsimpl0(obtainStrokePaint.mo2670getBlendMode0nO6VwU(), i3)) {
            obtainStrokePaint.mo2676setBlendModes9anfk8(i3);
        }
        if (!(obtainStrokePaint.getStrokeWidth() == f)) {
            obtainStrokePaint.setStrokeWidth(f);
        }
        if (!(obtainStrokePaint.getStrokeMiterLimit() == f2)) {
            obtainStrokePaint.setStrokeMiterLimit(f2);
        }
        if (!StrokeCap.m3088equalsimpl0(obtainStrokePaint.mo2673getStrokeCapKaPHkGw(), i)) {
            obtainStrokePaint.mo2679setStrokeCapBeK7IIE(i);
        }
        if (!StrokeJoin.m3098equalsimpl0(obtainStrokePaint.mo2674getStrokeJoinLxFBmk8(), i2)) {
            obtainStrokePaint.mo2680setStrokeJoinWw9F2mQ(i2);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m2877equalsimpl0(obtainStrokePaint.mo2672getFilterQualityfv9h1I(), i4)) {
            obtainStrokePaint.mo2678setFilterQualityvDHp3xo(i4);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m3182configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f, float f2, int i, int i2, PathEffect pathEffect, float f3, ColorFilter colorFilter, int i3, int i4, int i5, Object obj) {
        return canvasDrawScope.m3181configureStrokePaintho4zsrM(brush, f, f2, i, i2, pathEffect, f3, colorFilter, i3, (i5 & 512) != 0 ? DrawScope.Companion.m3236getDefaultFilterQualityfv9h1I() : i4);
    }

    @PublishedApi
    public static /* synthetic */ void getDrawParams$annotations() {
    }

    /* renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m3183modulate5vOe2sY(long j, float f) {
        return !((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0) ? Color.m2786copywmQWz5c$default(j, Color.m2789getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null) : j;
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo2681setStylek9PVt8s(PaintingStyle.Companion.m3018getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo2681setStylek9PVt8s(PaintingStyle.Companion.m3019getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        Paint obtainStrokePaint = obtainStrokePaint();
        Stroke stroke = (Stroke) drawStyle;
        if (!(obtainStrokePaint.getStrokeWidth() == stroke.getWidth())) {
            obtainStrokePaint.setStrokeWidth(stroke.getWidth());
        }
        if (!StrokeCap.m3088equalsimpl0(obtainStrokePaint.mo2673getStrokeCapKaPHkGw(), stroke.m3292getCapKaPHkGw())) {
            obtainStrokePaint.mo2679setStrokeCapBeK7IIE(stroke.m3292getCapKaPHkGw());
        }
        if (!(obtainStrokePaint.getStrokeMiterLimit() == stroke.getMiter())) {
            obtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
        }
        if (!StrokeJoin.m3098equalsimpl0(obtainStrokePaint.mo2674getStrokeJoinLxFBmk8(), stroke.m3293getJoinLxFBmk8())) {
            obtainStrokePaint.mo2680setStrokeJoinWw9F2mQ(stroke.m3293getJoinLxFBmk8());
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
            obtainStrokePaint.setPathEffect(stroke.getPathEffect());
        }
        return obtainStrokePaint;
    }

    /* renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m3184drawyzxVdVo(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawParams drawParams = getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long m3207component4NHjbRc = drawParams.m3207component4NHjbRc();
        DrawParams drawParams2 = getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m3210setSizeuvyYCjk(j);
        canvas.save();
        function1.invoke(this);
        canvas.restore();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m3210setSizeuvyYCjk(m3207component4NHjbRc);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo3185drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2), Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2), f, f2, z, m3178configurePaintswdJneE$default(this, brush, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo3186drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2), Offset.m2556getXimpl(j2) + Size.m2625getWidthimpl(j3), Offset.m2557getYimpl(j2) + Size.m2622getHeightimpl(j3), f, f2, z, m3176configurePaint2qPWKa0$default(this, j, drawStyle, f3, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo3187drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().mo2654drawCircle9KIMszo(j, f, m3178configurePaintswdJneE$default(this, brush, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo3188drawCircleVaOC9Bg(long j, float f, long j2, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().mo2654drawCircle9KIMszo(j2, f, m3176configurePaint2qPWKa0$default(this, j, drawStyle, f2, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo3189drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().mo2656drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m3178configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo3190drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().mo2656drawImageRectHPBpro0(imageBitmap, j, j2, j3, j4, m3177configurePaintswdJneE(null, drawStyle, f, colorFilter, i, i2));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo3191drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().mo2655drawImaged4ec7I(imageBitmap, j, m3178configurePaintswdJneE$default(this, null, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo3192drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.drawParams.getCanvas().mo2657drawLineWko1d7g(j, j2, m3182configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i, StrokeJoin.Companion.m3103getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo3193drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2) {
        this.drawParams.getCanvas().mo2657drawLineWko1d7g(j2, j3, m3180configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i, StrokeJoin.Companion.m3103getMiterLxFBmk8(), pathEffect, f2, colorFilter, i2, 0, 512, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo3194drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2), Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2), m3178configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo3195drawOvalnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2), Offset.m2556getXimpl(j2) + Size.m2625getWidthimpl(j3), Offset.m2557getYimpl(j2) + Size.m2622getHeightimpl(j3), m3176configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo3196drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawPath(path, m3178configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo3197drawPathLG529CI(@NotNull Path path, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawPath(path, m3176configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo3198drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        this.drawParams.getCanvas().mo2658drawPointsO7TthRY(i, list, m3180configureStrokePaintQ_0CZUI$default(this, j, f, 4.0f, i2, StrokeJoin.Companion.m3103getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo3199drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.drawParams.getCanvas().mo2658drawPointsO7TthRY(i, list, m3182configureStrokePaintho4zsrM$default(this, brush, f, 4.0f, i2, StrokeJoin.Companion.m3103getMiterLxFBmk8(), pathEffect, f2, colorFilter, i3, 0, 512, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo3200drawRectAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2), Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2), m3178configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo3201drawRectnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2), Offset.m2556getXimpl(j2) + Size.m2625getWidthimpl(j3), Offset.m2557getYimpl(j2) + Size.m2622getHeightimpl(j3), m3176configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo3202drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2), Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2), CornerRadius.m2531getXimpl(j3), CornerRadius.m2532getYimpl(j3), m3178configurePaintswdJneE$default(this, brush, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo3203drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, float f, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2), Offset.m2556getXimpl(j2) + Size.m2625getWidthimpl(j3), Offset.m2557getYimpl(j2) + Size.m2622getHeightimpl(j3), CornerRadius.m2531getXimpl(j4), CornerRadius.m2532getYimpl(j4), m3176configurePaint2qPWKa0$default(this, j, drawStyle, f, colorFilter, i, 0, 32, null));
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public /* synthetic */ long mo3204getCenterF1C5BW0() {
        return w51.b(this);
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @NotNull
    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public /* synthetic */ long mo3205getSizeNHjbRc() {
        return w51.c(this);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo1276roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo1277roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo1278toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1279toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1280toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo1281toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo1282toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo1283toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo1284toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo1285toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1286toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1287toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }

    /* compiled from: Taobao */
    @PublishedApi
    public static final class DrawParams {

        @NotNull
        private Canvas canvas;

        @NotNull
        private Density density;

        @NotNull
        private LayoutDirection layoutDirection;
        private long size;

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j);
        }

        /* renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m3206copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                density = drawParams.density;
            }
            if ((i & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection2 = layoutDirection;
            if ((i & 4) != 0) {
                canvas = drawParams.canvas;
            }
            Canvas canvas2 = canvas;
            if ((i & 8) != 0) {
                j = drawParams.size;
            }
            return drawParams.m3208copyUg5Nnss(density, layoutDirection2, canvas2, j);
        }

        @NotNull
        public final Density component1() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        @NotNull
        public final Canvas component3() {
            return this.canvas;
        }

        /* renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m3207component4NHjbRc() {
            return this.size;
        }

        @NotNull
        /* renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m3208copyUg5Nnss(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j) {
            Intrinsics.checkNotNullParameter(density, "density");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            return new DrawParams(density, layoutDirection, canvas, j, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m2621equalsimpl0(this.size, drawParams.size);
        }

        @NotNull
        public final Canvas getCanvas() {
            return this.canvas;
        }

        @NotNull
        public final Density getDensity() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m3209getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m2626hashCodeimpl(this.size);
        }

        public final void setCanvas(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "<set-?>");
            this.canvas = canvas;
        }

        public final void setDensity(@NotNull Density density) {
            Intrinsics.checkNotNullParameter(density, "<set-?>");
            this.density = density;
        }

        public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
            this.layoutDirection = layoutDirection;
        }

        /* renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m3210setSizeuvyYCjk(long j) {
            this.size = j;
        }

        @NotNull
        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m2629toStringimpl(this.size)) + ')';
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CanvasDrawScopeKt.DefaultDensity : density, (i & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i & 4) != 0 ? new EmptyCanvas() : canvas, (i & 8) != 0 ? Size.Companion.m2634getZeroNHjbRc() : j, null);
        }
    }
}
