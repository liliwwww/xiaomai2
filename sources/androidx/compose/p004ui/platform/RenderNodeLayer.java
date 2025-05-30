package androidx.compose.p004ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.geometry.MutableRect;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p004ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.CanvasHolder;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.RenderEffect;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.TransformOrigin;
import androidx.compose.p004ui.layout.GraphicLayerInfo;
import androidx.compose.p004ui.node.OwnedLayer;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: classes2.dex */
public final class RenderNodeLayer implements GraphicLayerInfo, OwnedLayer {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((DeviceRenderNode) obj, (Matrix) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull DeviceRenderNode deviceRenderNode, @NotNull Matrix matrix) {
            Intrinsics.checkNotNullParameter(deviceRenderNode, "rn");
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            deviceRenderNode.getMatrix(matrix);
        }
    };

    @NotNull
    private final CanvasHolder canvasHolder;

    @Nullable
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;

    @Nullable
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;

    @NotNull
    private final LayerMatrixCache<DeviceRenderNode> matrixCache;

    @NotNull
    private final OutlineResolver outlineResolver;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    private final DeviceRenderNode renderNode;

    @Nullable
    private Paint softwareLayerPaint;
    private long transformOrigin;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static final class UniqueDrawingIdApi29 {

        @NotNull
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        @DoNotInline
        public static final long getUniqueDrawingId(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public RenderNodeLayer(@NotNull AndroidComposeView androidComposeView, @NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Companion.m3130getCenterSzJe1aQ();
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(androidComposeView) : new RenderNodeApi23(androidComposeView);
        renderNodeApi29.setHasOverlappingRendering(true);
        this.renderNode = renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo2653concat58bKbWc(this.matrixCache.m4536calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.p004ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.p004ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo4439inverseTransform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        float[] m4535calculateInverseMatrixbWbORWo = this.matrixCache.m4535calculateInverseMatrixbWbORWo(this.renderNode);
        if (m4535calculateInverseMatrixbWbORWo != null) {
            androidx.compose.p004ui.graphics.Matrix.m2999timesAssign58bKbWc(fArr, m4535calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo4440isInLayerk4lQ0M(long j) {
        float m2556getXimpl = Offset.m2556getXimpl(j);
        float m2557getYimpl = Offset.m2557getYimpl(j);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= m2556getXimpl && m2556getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= m2557getYimpl && m2557getYimpl < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m4559isInOutlinek4lQ0M(j);
        }
        return true;
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect mutableRect, boolean z) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        if (!z) {
            androidx.compose.p004ui.graphics.Matrix.m2990mapimpl(this.matrixCache.m4536calculateMatrixGrdbGEg(this.renderNode), mutableRect);
            return;
        }
        float[] m4535calculateInverseMatrixbWbORWo = this.matrixCache.m4535calculateInverseMatrixbWbORWo(this.renderNode);
        if (m4535calculateInverseMatrixbWbORWo == null) {
            mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            androidx.compose.p004ui.graphics.Matrix.m2990mapimpl(m4535calculateInverseMatrixbWbORWo, mutableRect);
        }
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo4441mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.p004ui.graphics.Matrix.m2988mapMKHz9U(this.matrixCache.m4536calculateMatrixGrdbGEg(this.renderNode), j);
        }
        float[] m4535calculateInverseMatrixbWbORWo = this.matrixCache.m4535calculateInverseMatrixbWbORWo(this.renderNode);
        return m4535calculateInverseMatrixbWbORWo != null ? androidx.compose.p004ui.graphics.Matrix.m2988mapMKHz9U(m4535calculateInverseMatrixbWbORWo, j) : Offset.Companion.m2570getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo4442movegyyYBs(long j) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int m5334getXimpl = IntOffset.m5334getXimpl(j);
        int m5335getYimpl = IntOffset.m5335getYimpl(j);
        if (left == m5334getXimpl && top == m5335getYimpl) {
            return;
        }
        this.renderNode.offsetLeftAndRight(m5334getXimpl - left);
        this.renderNode.offsetTopAndBottom(m5335getYimpl - top);
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo4443resizeozmzZPI(long j) {
        int m5376getWidthimpl = IntSize.m5376getWidthimpl(j);
        int m5375getHeightimpl = IntSize.m5375getHeightimpl(j);
        float f = m5376getWidthimpl;
        this.renderNode.setPivotX(TransformOrigin.m3125getPivotFractionXimpl(this.transformOrigin) * f);
        float f2 = m5375getHeightimpl;
        this.renderNode.setPivotY(TransformOrigin.m3126getPivotFractionYimpl(this.transformOrigin) * f2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + m5376getWidthimpl, this.renderNode.getTop() + m5375getHeightimpl)) {
            this.outlineResolver.m4560updateuvyYCjk(SizeKt.Size(f, f2));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void reuseLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m3130getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo4444transform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        androidx.compose.p004ui.graphics.Matrix.m2999timesAssign58bKbWc(fArr, this.matrixCache.m4536calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            Function1<? super Canvas, Unit> function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, function1);
            }
        }
    }

    @Override // androidx.compose.p004ui.node.OwnedLayer
    /* renamed from: updateLayerProperties-dDxr-wY */
    public void mo4445updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, @NotNull Shape shape, boolean z, @Nullable RenderEffect renderEffect, long j2, long j3, int i, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.transformOrigin = j;
        boolean z2 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        this.renderNode.setScaleX(f);
        this.renderNode.setScaleY(f2);
        this.renderNode.setAlpha(f3);
        this.renderNode.setTranslationX(f4);
        this.renderNode.setTranslationY(f5);
        this.renderNode.setElevation(f6);
        this.renderNode.setAmbientShadowColor(ColorKt.m2841toArgb8_81llA(j2));
        this.renderNode.setSpotShadowColor(ColorKt.m2841toArgb8_81llA(j3));
        this.renderNode.setRotationZ(f9);
        this.renderNode.setRotationX(f7);
        this.renderNode.setRotationY(f8);
        this.renderNode.setCameraDistance(f10);
        this.renderNode.setPivotX(TransformOrigin.m3125getPivotFractionXimpl(j) * this.renderNode.getWidth());
        this.renderNode.setPivotY(TransformOrigin.m3126getPivotFractionYimpl(j) * this.renderNode.getHeight());
        this.renderNode.setClipToOutline(z && shape != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z && shape == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        this.renderNode.mo4517setCompositingStrategyaDBOjCE(i);
        boolean update = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        boolean z3 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if (z2 != z3 || (z3 && update)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
    }
}
