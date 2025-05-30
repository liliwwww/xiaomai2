package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidCanvas implements Canvas {

    @NotNull
    private Canvas internalCanvas = AndroidCanvas_androidKt.access$getEmptyCanvas$p();

    @NotNull
    private final Rect srcRect = new Rect();

    @NotNull
    private final Rect dstRect = new Rect();

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
            long m858unboximpl = list.get(first).m858unboximpl();
            long m858unboximpl2 = list.get(first + 1).m858unboximpl();
            this.internalCanvas.drawLine(Offset.m848getXimpl(m858unboximpl), Offset.m849getYimpl(m858unboximpl), Offset.m848getXimpl(m858unboximpl2), Offset.m849getYimpl(m858unboximpl2), paint.asFrameworkPaint());
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
            long m858unboximpl = list.get(i).m858unboximpl();
            this.internalCanvas.drawPoint(Offset.m848getXimpl(m858unboximpl), Offset.m849getYimpl(m858unboximpl), paint.asFrameworkPaint());
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

    /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void m928clipPathmtrdDE(@NotNull Path path, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m939toRegionOp7u2Bmg(i));
    }

    /* renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void m929clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m939toRegionOp7u2Bmg(i));
    }

    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public /* synthetic */ void m930clipRectmtrdDE(androidx.compose.ui.geometry.Rect rect, int i) {
        kq.a(this, rect, i);
    }

    /* renamed from: concat-58bKbWc, reason: not valid java name */
    public void m931concat58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        if (MatrixKt.isIdentity-58bKbWc(fArr)) {
            return;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(matrix, fArr);
        this.internalCanvas.concat(matrix);
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.b(this, rect, f, f2, z, paint);
    }

    public /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.c(this, rect, f, f2, z, paint);
    }

    /* renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void m932drawCircle9KIMszo(long j, float f, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m848getXimpl(j), Offset.m849getYimpl(j), f, paint.asFrameworkPaint());
    }

    /* renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void m933drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m848getXimpl(j), Offset.m849getYimpl(j), paint.asFrameworkPaint());
    }

    /* renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void m934drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        rect.left = IntOffset.getX-impl(j);
        rect.top = IntOffset.getY-impl(j);
        rect.right = IntOffset.getX-impl(j) + IntSize.getWidth-impl(j2);
        rect.bottom = IntOffset.getY-impl(j) + IntSize.getHeight-impl(j2);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        rect2.left = IntOffset.getX-impl(j3);
        rect2.top = IntOffset.getY-impl(j3);
        rect2.right = IntOffset.getX-impl(j3) + IntSize.getWidth-impl(j4);
        rect2.bottom = IntOffset.getY-impl(j3) + IntSize.getHeight-impl(j4);
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    /* renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void m935drawLineWko1d7g(long j, long j2, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawLine(Offset.m848getXimpl(j), Offset.m849getYimpl(j), Offset.m848getXimpl(j2), Offset.m849getYimpl(j2), paint.asFrameworkPaint());
    }

    public void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawOval(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        kq.d(this, rect, paint);
    }

    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
    }

    /* renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void m936drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        PointMode$Companion pointMode$Companion = PointMode.Companion;
        if (PointMode.equals-impl0(i, pointMode$Companion.m1189getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.equals-impl0(i, pointMode$Companion.m1191getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.equals-impl0(i, pointMode$Companion.m1190getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    /* renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void m937drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        PointMode$Companion pointMode$Companion = PointMode.Companion;
        if (PointMode.equals-impl0(i, pointMode$Companion.m1189getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.equals-impl0(i, pointMode$Companion.m1191getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.equals-impl0(i, pointMode$Companion.m1190getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    public void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    public /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        kq.e(this, rect, paint);
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    /* renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void m938drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.toAndroidVertexMode-JOOmi9M(vertices.getVertexMode-c2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @NotNull
    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void saveLayer(@NotNull androidx.compose.ui.geometry.Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    public final void setInternalCanvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    public /* synthetic */ void skewRad(float f, float f2) {
        kq.f(this, f, f2);
    }

    @NotNull
    /* renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m939toRegionOp7u2Bmg(int i) {
        return ClipOp.m1036equalsimpl0(i, ClipOp.Companion.getDifference-rtfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }
}
