package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;
import tb.zn3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathComponent extends VNode {

    @Nullable
    private Brush fill;
    private float fillAlpha;
    private boolean isPathDirty;
    private boolean isStrokeDirty;
    private boolean isTrimPathDirty;

    @NotNull
    private String name;

    @NotNull
    private final PathParser parser;

    @NotNull
    private final Path path;

    @NotNull
    private List<? extends PathNode> pathData;
    private int pathFillType;

    @NotNull
    private final Lazy pathMeasure$delegate;

    @NotNull
    private final Path renderPath;

    @Nullable
    private Brush stroke;
    private float strokeAlpha;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter;
    private float strokeLineWidth;

    @Nullable
    private Stroke strokeStyle;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    public PathComponent() {
        super((DefaultConstructorMarker) null);
        this.name = "";
        this.fillAlpha = 1.0f;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        this.isTrimPathDirty = true;
        this.path = AndroidPath_androidKt.Path();
        this.renderPath = AndroidPath_androidKt.Path();
        this.pathMeasure$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, pathMeasure.2.INSTANCE);
        this.parser = new PathParser();
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure) this.pathMeasure$delegate.getValue();
    }

    private final void updatePath() {
        this.parser.clear();
        this.path.reset();
        this.parser.addPathNodes(this.pathData).toPath(this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        this.renderPath.reset();
        if (this.trimPathStart == 0.0f) {
            if (this.trimPathEnd == 1.0f) {
                zn3.c(this.renderPath, this.path, 0L, 2, (Object) null);
                return;
            }
        }
        getPathMeasure().setPath(this.path, false);
        float length = getPathMeasure().getLength();
        float f = this.trimPathStart;
        float f2 = this.trimPathOffset;
        float f3 = ((f + f2) % 1.0f) * length;
        float f4 = ((this.trimPathEnd + f2) % 1.0f) * length;
        if (f3 <= f4) {
            getPathMeasure().getSegment(f3, f4, this.renderPath, true);
        } else {
            getPathMeasure().getSegment(f3, length, this.renderPath, true);
            getPathMeasure().getSegment(0.0f, f4, this.renderPath, true);
        }
    }

    public void draw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isPathDirty) {
            updatePath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            w51.F(drawScope, this.renderPath, brush, this.fillAlpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke = this.strokeStyle;
            if (this.isStrokeDirty || stroke == null) {
                stroke = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, null, 16, null);
                this.strokeStyle = stroke;
                this.isStrokeDirty = false;
            }
            w51.F(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke, (ColorFilter) null, 0, 48, (Object) null);
        }
    }

    @Nullable
    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* renamed from: getPathFillType-Rg-k1Os, reason: not valid java name */
    public final int m1328getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    @Nullable
    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    /* renamed from: getStrokeLineCap-KaPHkGw, reason: not valid java name */
    public final int m1329getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name */
    public final int m1330getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public final void setFill(@Nullable Brush brush) {
        this.fill = brush;
        invalidate();
    }

    public final void setFillAlpha(float f) {
        this.fillAlpha = f;
        invalidate();
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.name = str;
        invalidate();
    }

    public final void setPathData(@NotNull List<? extends PathNode> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.pathData = list;
        this.isPathDirty = true;
        invalidate();
    }

    /* renamed from: setPathFillType-oQ8Xj4U, reason: not valid java name */
    public final void m1331setPathFillTypeoQ8Xj4U(int i) {
        this.pathFillType = i;
        this.renderPath.m1175setFillTypeoQ8Xj4U(i);
        invalidate();
    }

    public final void setStroke(@Nullable Brush brush) {
        this.stroke = brush;
        invalidate();
    }

    public final void setStrokeAlpha(float f) {
        this.strokeAlpha = f;
        invalidate();
    }

    /* renamed from: setStrokeLineCap-BeK7IIE, reason: not valid java name */
    public final void m1332setStrokeLineCapBeK7IIE(int i) {
        this.strokeLineCap = i;
        this.isStrokeDirty = true;
        invalidate();
    }

    /* renamed from: setStrokeLineJoin-Ww9F2mQ, reason: not valid java name */
    public final void m1333setStrokeLineJoinWw9F2mQ(int i) {
        this.strokeLineJoin = i;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineMiter(float f) {
        this.strokeLineMiter = f;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineWidth(float f) {
        this.strokeLineWidth = f;
        invalidate();
    }

    public final void setTrimPathEnd(float f) {
        if (this.trimPathEnd == f) {
            return;
        }
        this.trimPathEnd = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final void setTrimPathOffset(float f) {
        if (this.trimPathOffset == f) {
            return;
        }
        this.trimPathOffset = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final void setTrimPathStart(float f) {
        if (this.trimPathStart == f) {
            return;
        }
        this.trimPathStart = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    @NotNull
    public String toString() {
        return this.path.toString();
    }
}
