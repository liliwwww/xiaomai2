package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewLayer extends View implements GraphicLayerInfo, OwnedLayer {
    private static boolean hasRetrievedMethod;

    @Nullable
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;

    @Nullable
    private static Method updateDisplayListIfDirtyMethod;

    @NotNull
    private final CanvasHolder canvasHolder;

    @Nullable
    private Rect clipBoundsCache;
    private boolean clipToBounds;

    @NotNull
    private final DrawChildContainer container;

    @Nullable
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;

    @Nullable
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;

    @NotNull
    private final LayerMatrixCache<View> matrixCache;

    @NotNull
    private final OutlineResolver outlineResolver;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Function2<View, Matrix, Unit> getMatrix = new Function2<View, Matrix, Unit>() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$getMatrix$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((View) obj, (Matrix) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull View view, @NotNull Matrix matrix) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            matrix.set(view.getMatrix());
        }
    };

    @NotNull
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            OutlineResolver outlineResolver;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outlineResolver = ((ViewLayer) view).outlineResolver;
            Outline outline2 = outlineResolver.getOutline();
            Intrinsics.checkNotNull(outline2);
            outline.set(outline2);
        }
    };

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        @NotNull
        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void updateDisplayList(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(29)
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayer(@NotNull AndroidComposeView androidComposeView, @NotNull DrawChildContainer drawChildContainer, @NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        super(androidComposeView.getContext());
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        Intrinsics.checkNotNullParameter(drawChildContainer, "container");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.Companion.m1223getCenterSzJe1aQ();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getOutline() != null ? OutlineProvider : null);
    }

    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        boolean recycle$ui_release = this.ownerView.recycle$ui_release(this);
        if (Build.VERSION.SDK_INT >= 23 || shouldUseDispatchDraw || !recycle$ui_release) {
            this.container.removeViewInLayout(this);
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z = false;
        setInvalidated(false);
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            z = true;
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(androidCanvas);
        }
        if (z) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    public void drawLayer(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    @NotNull
    public final DrawChildContainer getContainer() {
        return this.container;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.layerId;
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    /* renamed from: inverseTransform-58bKbWc, reason: not valid java name */
    public void m2234inverseTransform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        float[] fArr2 = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
        if (fArr2 != null) {
            androidx.compose.ui.graphics.Matrix.timesAssign-58bKbWc(fArr, fArr2);
        }
    }

    /* renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    public boolean m2235isInLayerk4lQ0M(long j) {
        float f = Offset.getX-impl(j);
        float f2 = Offset.getY-impl(j);
        if (this.clipToBounds) {
            return 0.0f <= f && f < ((float) getWidth()) && 0.0f <= f2 && f2 < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.isInOutline-k-4lQ0M(j);
        }
        return true;
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void mapBounds(@NotNull MutableRect mutableRect, boolean z) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        if (!z) {
            androidx.compose.ui.graphics.Matrix.map-impl(this.matrixCache.calculateMatrix-GrdbGEg(this), mutableRect);
            return;
        }
        float[] fArr = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
        if (fArr != null) {
            androidx.compose.ui.graphics.Matrix.map-impl(fArr, mutableRect);
        } else {
            mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* renamed from: mapOffset-8S9VItk, reason: not valid java name */
    public long m2236mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.ui.graphics.Matrix.map-MK-Hz9U(this.matrixCache.calculateMatrix-GrdbGEg(this), j);
        }
        float[] fArr = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
        return fArr != null ? androidx.compose.ui.graphics.Matrix.map-MK-Hz9U(fArr, j) : Offset.Companion.m1022getInfiniteF1C5BW0();
    }

    /* renamed from: move--gyyYBs, reason: not valid java name */
    public void m2237movegyyYBs(long j) {
        int m2643getXimpl = IntOffset.m2643getXimpl(j);
        if (m2643getXimpl != getLeft()) {
            offsetLeftAndRight(m2643getXimpl - getLeft());
            this.matrixCache.invalidate();
        }
        int m2644getYimpl = IntOffset.m2644getYimpl(j);
        if (m2644getYimpl != getTop()) {
            offsetTopAndBottom(m2644getYimpl - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* renamed from: resize-ozmzZPI, reason: not valid java name */
    public void m2238resizeozmzZPI(long j) {
        int m2685getWidthimpl = IntSize.m2685getWidthimpl(j);
        int m2684getHeightimpl = IntSize.m2684getHeightimpl(j);
        if (m2685getWidthimpl == getWidth() && m2684getHeightimpl == getHeight()) {
            return;
        }
        float f = m2685getWidthimpl;
        setPivotX(TransformOrigin.getPivotFractionX-impl(this.mTransformOrigin) * f);
        float f2 = m2684getHeightimpl;
        setPivotY(TransformOrigin.getPivotFractionY-impl(this.mTransformOrigin) * f2);
        this.outlineResolver.update-uvyYCjk(SizeKt.Size(f, f2));
        updateOutlineResolver();
        layout(getLeft(), getTop(), getLeft() + m2685getWidthimpl, getTop() + m2684getHeightimpl);
        resetClipBounds();
        this.matrixCache.invalidate();
    }

    public void reuseLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        if (Build.VERSION.SDK_INT >= 23 || shouldUseDispatchDraw) {
            this.container.addView(this);
        } else {
            setVisibility(0);
        }
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m1223getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * getResources().getDisplayMetrics().densityDpi);
    }

    /* renamed from: transform-58bKbWc, reason: not valid java name */
    public void m2239transform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        androidx.compose.ui.graphics.Matrix.timesAssign-58bKbWc(fArr, this.matrixCache.calculateMatrix-GrdbGEg(this));
    }

    public void updateDisplayList() {
        if (!this.isInvalidated || shouldUseDispatchDraw) {
            return;
        }
        setInvalidated(false);
        Companion.updateDisplayList(this);
    }

    /* renamed from: updateLayerProperties-dDxr-wY, reason: not valid java name */
    public void m2240updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, @NotNull Shape shape, boolean z, @Nullable RenderEffect renderEffect, long j2, long j3, int i, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.mTransformOrigin = j;
        setScaleX(f);
        setScaleY(f2);
        setAlpha(f3);
        setTranslationX(f4);
        setTranslationY(f5);
        setElevation(f6);
        setRotation(f9);
        setRotationX(f7);
        setRotationY(f8);
        setPivotX(TransformOrigin.getPivotFractionX-impl(this.mTransformOrigin) * getWidth());
        setPivotY(TransformOrigin.getPivotFractionY-impl(this.mTransformOrigin) * getHeight());
        setCameraDistancePx(f10);
        boolean z2 = true;
        this.clipToBounds = z && shape == RectangleShapeKt.getRectangleShape();
        resetClipBounds();
        boolean z3 = getManualClipPath() != null;
        setClipToOutline(z && shape != RectangleShapeKt.getRectangleShape());
        boolean update = this.outlineResolver.update(shape, getAlpha(), getClipToOutline(), getElevation(), layoutDirection, density);
        updateOutlineResolver();
        boolean z4 = getManualClipPath() != null;
        if (z3 != z4 || (z4 && update)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = ViewLayerVerificationHelper28.INSTANCE;
            viewLayerVerificationHelper28.setOutlineAmbientShadowColor(this, ColorKt.toArgb-8_81llA(j2));
            viewLayerVerificationHelper28.setOutlineSpotShadowColor(this, ColorKt.toArgb-8_81llA(j3));
        }
        if (i2 >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, renderEffect);
        }
        CompositingStrategy.Companion companion = CompositingStrategy.Companion;
        if (CompositingStrategy.m1114equalsimpl0(i, companion.getOffscreen--NrFUSI())) {
            setLayerType(2, null);
        } else if (CompositingStrategy.m1114equalsimpl0(i, companion.getModulateAlpha--NrFUSI())) {
            setLayerType(0, null);
            z2 = false;
        } else {
            setLayerType(0, null);
        }
        this.mHasOverlappingRendering = z2;
    }
}
