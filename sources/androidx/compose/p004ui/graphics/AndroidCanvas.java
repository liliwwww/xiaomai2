package androidx.compose.p004ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.PointMode;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
@PublishedApi
/* loaded from: classes.dex */
public final class AndroidCanvas implements Canvas {

    @NotNull
    private final Rect dstRect;

    @NotNull
    private Canvas internalCanvas;

    @NotNull
    private final Rect srcRect;

    public AndroidCanvas() {
        Canvas canvas;
        canvas = AndroidCanvas_androidKt.EmptyCanvas;
        this.internalCanvas = canvas;
        this.srcRect = new Rect();
        this.dstRect = new Rect();
    }

    private final void drawLines(List<Offset> list, Paint paint, int i) {
        if (list.size() < 2) {
            return;
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, list.size() - 1), i);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            long m2566unboximpl = list.get(first).m2566unboximpl();
            long m2566unboximpl2 = list.get(first + 1).m2566unboximpl();
            this.internalCanvas.drawLine(Offset.m2556getXimpl(m2566unboximpl), Offset.m2557getYimpl(m2566unboximpl), Offset.m2556getXimpl(m2566unboximpl2), Offset.m2557getYimpl(m2566unboximpl2), paint.asFrameworkPaint());
            if (first == last) {
                return;
            } else {
                first += step2;
            }
        }
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long m2566unboximpl = list.get(i).m2566unboximpl();
            this.internalCanvas.drawPoint(Offset.m2556getXimpl(m2566unboximpl), Offset.m2557getYimpl(m2566unboximpl), paint.asFrameworkPaint());
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i) {
        if (fArr.length < 4 || fArr.length % 2 != 0) {
            return;
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, fArr.length - 3), i * 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            this.internalCanvas.drawLine(fArr[first], fArr[first + 1], fArr[first + 2], fArr[first + 3], paint.asFrameworkPaint());
            if (first == last) {
                return;
            } else {
                first += step2;
            }
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i) {
        if (fArr.length % 2 != 0) {
            return;
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, fArr.length - 1), i);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            this.internalCanvas.drawPoint(fArr[first], fArr[first + 1], paint.asFrameworkPaint());
            if (first == last) {
                return;
            } else {
                first += step2;
            }
        }
    }

    @PublishedApi
    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo2650clipPathmtrdDE(@NotNull Path path, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m2661toRegionOp7u2Bmg(i));
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo2651clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m2661toRegionOp7u2Bmg(i));
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public /* synthetic */ void mo2652clipRectmtrdDE(androidx.compose.p004ui.geometry.Rect rect, int i) {
        kq.a(this, rect, i);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo2653concat58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        if (MatrixKt.m3006isIdentity58bKbWc(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        AndroidMatrixConversions_androidKt.m2668setFromEL8BTi8(matrix, fArr);
        this.internalCanvas.concat(matrix);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawArc(androidx.compose.p004ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.b(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawArcRad(androidx.compose.p004ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.c(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo2654drawCircle9KIMszo(long j, float f, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), f, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo2655drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo2656drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        rect.left = IntOffset.m5334getXimpl(j);
        rect.top = IntOffset.m5335getYimpl(j);
        rect.right = IntOffset.m5334getXimpl(j) + IntSize.m5376getWidthimpl(j2);
        rect.bottom = IntOffset.m5335getYimpl(j) + IntSize.m5375getHeightimpl(j2);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        rect2.left = IntOffset.m5334getXimpl(j3);
        rect2.top = IntOffset.m5335getYimpl(j3);
        rect2.right = IntOffset.m5334getXimpl(j3) + IntSize.m5376getWidthimpl(j4);
        rect2.bottom = IntOffset.m5335getYimpl(j3) + IntSize.m5375getHeightimpl(j4);
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo2657drawLineWko1d7g(long j, long j2, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawLine(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawOval(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawOval(androidx.compose.p004ui.geometry.Rect rect, Paint paint) {
        kq.d(this, rect, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo2658drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m3048equalsimpl0(i, companion.m3052getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m3048equalsimpl0(i, companion.m3054getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m3048equalsimpl0(i, companion.m3053getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo2659drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        PointMode.Companion companion = PointMode.Companion;
        if (PointMode.m3048equalsimpl0(i, companion.m3052getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.m3048equalsimpl0(i, companion.m3054getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.m3048equalsimpl0(i, companion.m3053getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawRect(androidx.compose.p004ui.geometry.Rect rect, Paint paint) {
        kq.e(this, rect, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo2660drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m2701toAndroidVertexModeJOOmi9M(vertices.m3141getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @NotNull
    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void saveLayer(@NotNull androidx.compose.p004ui.geometry.Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    public final void setInternalCanvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void skewRad(float f, float f2) {
        kq.f(this, f, f2);
    }

    @NotNull
    /* renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m2661toRegionOp7u2Bmg(int i) {
        return ClipOp.m2771equalsimpl0(i, ClipOp.Companion.m2775getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }
}
