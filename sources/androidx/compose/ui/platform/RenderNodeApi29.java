package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.CompositingStrategy$Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kq;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RenderNodeApi29 implements DeviceRenderNode {
    private int internalCompositingStrategy;

    @Nullable
    private RenderEffect internalRenderEffect;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    private final RenderNode renderNode;

    public RenderNodeApi29(@NotNull AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        this.ownerView = androidComposeView;
        this.renderNode = new RenderNode("Compose");
        this.internalCompositingStrategy = CompositingStrategy.Companion.m1075getAutoNrFUSI();
    }

    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    public void drawInto(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawRenderNode(this.renderNode);
    }

    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getAmbientShadowColor(), this.renderNode.getSpotShadowColor(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect, this.internalCompositingStrategy, null);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    public int getBottom() {
        return this.renderNode.getBottom();
    }

    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public int m1789getCompositingStrategyNrFUSI() {
        return this.internalCompositingStrategy;
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    public int getHeight() {
        return this.renderNode.getHeight();
    }

    public void getInverseMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    public int getLeft() {
        return this.renderNode.getLeft();
    }

    public void getMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getMatrix(matrix);
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Nullable
    public RenderEffect getRenderEffect() {
        return this.internalRenderEffect;
    }

    public int getRight() {
        return this.renderNode.getRight();
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public int getSpotShadowColor() {
        return this.renderNode.getSpotShadowColor();
    }

    public int getTop() {
        return this.renderNode.getTop();
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public long getUniqueId() {
        return this.renderNode.getUniqueId();
    }

    public int getWidth() {
        return this.renderNode.getWidth();
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    public final boolean isUsingCompositingLayer$ui_release() {
        return this.renderNode.getUseCompositingLayer();
    }

    public void offsetLeftAndRight(int i) {
        this.renderNode.offsetLeftAndRight(i);
    }

    public void offsetTopAndBottom(int i) {
        this.renderNode.offsetTopAndBottom(i);
    }

    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path path, @NotNull Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvasHolder, "canvasHolder");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        RecordingCanvas beginRecording = this.renderNode.beginRecording();
        Intrinsics.checkNotNullExpressionValue(beginRecording, "renderNode.beginRecording()");
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(beginRecording);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (path != null) {
            androidCanvas.save();
            kq.m(androidCanvas, path, 0, 2, (Object) null);
        }
        function1.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    public void setAmbientShadowColor(int i) {
        this.renderNode.setAmbientShadowColor(i);
    }

    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(f);
    }

    public void setClipToBounds(boolean z) {
        this.renderNode.setClipToBounds(z);
    }

    public void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public void m1790setCompositingStrategyaDBOjCE(int i) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy$Companion compositingStrategy$Companion = CompositingStrategy.Companion;
        if (CompositingStrategy.equals-impl0(i, compositingStrategy$Companion.m1077getOffscreenNrFUSI())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.equals-impl0(i, compositingStrategy$Companion.m1076getModulateAlphaNrFUSI())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i;
    }

    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    public boolean setHasOverlappingRendering(boolean z) {
        return this.renderNode.setHasOverlappingRendering(z);
    }

    public void setOutline(@Nullable Outline outline) {
        this.renderNode.setOutline(outline);
    }

    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    public boolean setPosition(int i, int i2, int i3, int i4) {
        return this.renderNode.setPosition(i, i2, i3, i4);
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    public void setRotationZ(float f) {
        this.renderNode.setRotationZ(f);
    }

    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    public void setSpotShadowColor(int i) {
        this.renderNode.setSpotShadowColor(i);
    }

    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }
}
