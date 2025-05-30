package androidx.compose.p004ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.CornerRadiusKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.geometry.RoundRectKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidPath;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kq;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class OutlineResolver {
    private boolean cacheIsDirty;

    @NotNull
    private final Outline cachedOutline;

    @Nullable
    private Path cachedRrectPath;

    @Nullable
    private androidx.compose.p004ui.graphics.Outline calculatedOutline;

    @NotNull
    private Density density;
    private boolean isSupportedOutline;

    @NotNull
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;

    @Nullable
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;

    @NotNull
    private Shape shape;
    private long size;

    @Nullable
    private Path tmpOpPath;

    @Nullable
    private Path tmpPath;

    @Nullable
    private RoundRect tmpRoundRect;

    @Nullable
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.density = density;
        this.isSupportedOutline = true;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        Size.Companion companion = Size.Companion;
        this.size = companion.m2634getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m2572getZeroF1C5BW0();
        this.rectSize = companion.m2634getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m4558isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        if (!(roundRect.getLeft() == Offset.m2556getXimpl(j))) {
            return false;
        }
        if (!(roundRect.getTop() == Offset.m2557getYimpl(j))) {
            return false;
        }
        if (!(roundRect.getRight() == Offset.m2556getXimpl(j) + Size.m2625getWidthimpl(j2))) {
            return false;
        }
        if (roundRect.getBottom() == Offset.m2557getYimpl(j) + Size.m2622getHeightimpl(j2)) {
            return (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) > f ? 1 : (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == f ? 0 : -1)) == 0;
        }
        return false;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m2572getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m2625getWidthimpl(j) <= 0.0f || Size.m2622getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.p004ui.graphics.Outline mo1164createOutlinePq9zytI = this.shape.mo1164createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = mo1164createOutlinePq9zytI;
            if (mo1164createOutlinePq9zytI instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) mo1164createOutlinePq9zytI).getRect());
            } else if (mo1164createOutlinePq9zytI instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) mo1164createOutlinePq9zytI).getRoundRect());
            } else if (mo1164createOutlinePq9zytI instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) mo1164createOutlinePq9zytI).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((AndroidPath) path).getInternalPath());
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float m2531getXimpl = CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(MathKt.roundToInt(roundRect.getLeft()), MathKt.roundToInt(roundRect.getTop()), MathKt.roundToInt(roundRect.getRight()), MathKt.roundToInt(roundRect.getBottom()), m2531getXimpl);
            this.roundedCornerRadius = m2531getXimpl;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    public final void clipToOutline(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Path clipPath = getClipPath();
        if (clipPath != null) {
            kq.m(canvas, clipPath, 0, 2, (Object) null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f <= 0.0f) {
            kq.n(canvas, Offset.m2556getXimpl(this.rectTopLeft), Offset.m2557getYimpl(this.rectTopLeft), Offset.m2556getXimpl(this.rectTopLeft) + Size.m2625getWidthimpl(this.rectSize), Offset.m2557getYimpl(this.rectTopLeft) + Size.m2622getHeightimpl(this.rectSize), 0, 16, (Object) null);
            return;
        }
        Path path = this.tmpPath;
        RoundRect roundRect = this.tmpRoundRect;
        if (path == null || !m4558isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
            RoundRect m2610RoundRectgG7oq9Y = RoundRectKt.m2610RoundRectgG7oq9Y(Offset.m2556getXimpl(this.rectTopLeft), Offset.m2557getYimpl(this.rectTopLeft), Offset.m2556getXimpl(this.rectTopLeft) + Size.m2625getWidthimpl(this.rectSize), Offset.m2557getYimpl(this.rectTopLeft) + Size.m2622getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
            if (path == null) {
                path = AndroidPath_androidKt.Path();
            } else {
                path.reset();
            }
            path.addRoundRect(m2610RoundRectgG7oq9Y);
            this.tmpRoundRect = m2610RoundRectgG7oq9Y;
            this.tmpPath = path;
        }
        kq.m(canvas, path, 0, 2, (Object) null);
    }

    @Nullable
    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    @Nullable
    public final android.graphics.Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m4559isInOutlinek4lQ0M(long j) {
        androidx.compose.p004ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final boolean update(@NotNull Shape shape, float f, boolean z, float f2, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.cachedOutline.setAlpha(f);
        boolean z2 = !Intrinsics.areEqual(this.shape, shape);
        if (z2) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        boolean z3 = z || f2 > 0.0f;
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* renamed from: update-uvyYCjk, reason: not valid java name */
    public final void m4560updateuvyYCjk(long j) {
        if (Size.m2621equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        this.cacheIsDirty = true;
    }
}
