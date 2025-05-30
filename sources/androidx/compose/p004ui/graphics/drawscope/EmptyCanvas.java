package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.Vertices;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class EmptyCanvas implements Canvas {
    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipPath-mtrdD-E */
    public void mo2650clipPathmtrdDE(@NotNull Path path, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipRect-N_I0leg */
    public void mo2651clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: clipRect-mtrdD-E */
    public /* synthetic */ void mo2652clipRectmtrdDE(Rect rect, int i) {
        kq.a(this, rect, i);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: concat-58bKbWc */
    public void mo2653concat58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void disableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawArc(Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.b(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawArcRad(Rect rect, float f, float f2, boolean z, Paint paint) {
        kq.c(this, rect, f, f2, z, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawCircle-9KIMszo */
    public void mo2654drawCircle9KIMszo(long j, float f, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawImage-d-4ec7I */
    public void mo2655drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawImageRect-HPBpro0 */
    public void mo2656drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawLine-Wko1d7g */
    public void mo2657drawLineWko1d7g(long j, long j2, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawOval(Rect rect, Paint paint) {
        kq.d(this, rect, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawPoints-O7TthRY */
    public void mo2658drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawRawPoints-O7TthRY */
    public void mo2659drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void drawRect(Rect rect, Paint paint) {
        kq.e(this, rect, paint);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    /* renamed from: drawVertices-TPEHhCM */
    public void mo2660drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void enableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void restore() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void rotate(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void save() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void saveLayer(@NotNull Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void scale(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void skew(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public /* synthetic */ void skewRad(float f, float f2) {
        kq.f(this, f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Canvas
    public void translate(float f, float f2) {
        throw new UnsupportedOperationException();
    }
}
