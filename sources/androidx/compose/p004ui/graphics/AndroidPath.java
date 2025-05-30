package androidx.compose.p004ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.graphics.PathOperation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.zn3;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidPath implements Path {

    @NotNull
    private final Path internalPath;

    @NotNull
    private final Matrix mMatrix;

    @NotNull
    private final float[] radii;

    @NotNull
    private final RectF rectF;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidPath() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.graphics.AndroidPath.<init>():void");
    }

    public AndroidPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "internalPath");
        this.internalPath = path;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new Matrix();
    }

    private final boolean _rectIsValid(Rect rect) {
        if (!(!Float.isNaN(rect.getLeft()))) {
            throw new IllegalStateException("Rect.left is NaN".toString());
        }
        if (!(!Float.isNaN(rect.getTop()))) {
            throw new IllegalStateException("Rect.top is NaN".toString());
        }
        if (!(!Float.isNaN(rect.getRight()))) {
            throw new IllegalStateException("Rect.right is NaN".toString());
        }
        if (!Float.isNaN(rect.getBottom())) {
            return true;
        }
        throw new IllegalStateException("Rect.bottom is NaN".toString());
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void addArc(@NotNull Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        if (!_rectIsValid(rect)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
        this.internalPath.addArc(this.rectF, f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void addArcRad(@NotNull Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        addArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2));
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void addOval(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
        this.internalPath.addOval(this.rectF, Path.Direction.CCW);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    /* renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo2688addPathUv8p0NA(@NotNull Path path, long j) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path path2 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void addRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (!_rectIsValid(rect)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.rectF.set(RectHelper_androidKt.toAndroidRectF(rect));
        this.internalPath.addRect(this.rectF, Path.Direction.CCW);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void addRoundRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "roundRect");
        this.rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        this.radii[0] = CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs());
        this.radii[1] = CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs());
        this.radii[2] = CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs());
        this.radii[3] = CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs());
        this.radii[4] = CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs());
        this.radii[5] = CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs());
        this.radii[6] = CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs());
        this.radii[7] = CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs());
        this.internalPath.addRoundRect(this.rectF, this.radii, Path.Direction.CCW);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void arcTo(@NotNull Rect rect, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.arcTo(this.rectF, f, f2, z);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public /* synthetic */ void arcToRad(Rect rect, float f, float f2, boolean z) {
        zn3.a(this, rect, f, f2, z);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.cubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    @NotNull
    public Rect getBounds() {
        this.internalPath.computeBounds(this.rectF, true);
        RectF rectF = this.rectF;
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    /* renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo2689getFillTypeRgk1Os() {
        return this.internalPath.getFillType() == Path.FillType.EVEN_ODD ? PathFillType.Companion.m3030getEvenOddRgk1Os() : PathFillType.Companion.m3031getNonZeroRgk1Os();
    }

    @NotNull
    public final Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void lineTo(float f, float f2) {
        this.internalPath.lineTo(f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void moveTo(float f, float f2) {
        this.internalPath.moveTo(f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    /* renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo2690opN5in7k0(@NotNull Path path, @NotNull Path path2, int i) {
        Intrinsics.checkNotNullParameter(path, "path1");
        Intrinsics.checkNotNullParameter(path2, "path2");
        PathOperation.Companion companion = PathOperation.Companion;
        Path.Op op = PathOperation.m3035equalsimpl0(i, companion.m3039getDifferenceb3I0S0c()) ? Path.Op.DIFFERENCE : PathOperation.m3035equalsimpl0(i, companion.m3040getIntersectb3I0S0c()) ? Path.Op.INTERSECT : PathOperation.m3035equalsimpl0(i, companion.m3041getReverseDifferenceb3I0S0c()) ? Path.Op.REVERSE_DIFFERENCE : PathOperation.m3035equalsimpl0(i, companion.m3042getUnionb3I0S0c()) ? Path.Op.UNION : Path.Op.XOR;
        Path path3 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path internalPath = ((AndroidPath) path).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path3.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void quadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.quadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void relativeLineTo(float f, float f2) {
        this.internalPath.rLineTo(f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void relativeMoveTo(float f, float f2) {
        this.internalPath.rMoveTo(f, f2);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void relativeQuadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.rQuadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.p004ui.graphics.Path
    /* renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo2691setFillTypeoQ8Xj4U(int i) {
        this.internalPath.setFillType(PathFillType.m3026equalsimpl0(i, PathFillType.Companion.m3030getEvenOddRgk1Os()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.p004ui.graphics.Path
    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo2692translatek4lQ0M(long j) {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        this.internalPath.transform(this.mMatrix);
    }

    public /* synthetic */ AndroidPath(Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Path() : path);
    }
}
