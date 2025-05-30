package androidx.compose.p004ui.node;

import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.TransformOrigin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class LayerPositionalProperties {
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float translationX;
    private float translationY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float cameraDistance = 8.0f;
    private long transformOrigin = TransformOrigin.Companion.m3130getCenterSzJe1aQ();

    public final void copyFrom(@NotNull LayerPositionalProperties layerPositionalProperties) {
        Intrinsics.checkNotNullParameter(layerPositionalProperties, "other");
        this.scaleX = layerPositionalProperties.scaleX;
        this.scaleY = layerPositionalProperties.scaleY;
        this.translationX = layerPositionalProperties.translationX;
        this.translationY = layerPositionalProperties.translationY;
        this.rotationX = layerPositionalProperties.rotationX;
        this.rotationY = layerPositionalProperties.rotationY;
        this.rotationZ = layerPositionalProperties.rotationZ;
        this.cameraDistance = layerPositionalProperties.cameraDistance;
        this.transformOrigin = layerPositionalProperties.transformOrigin;
    }

    public final boolean hasSameValuesAs(@NotNull LayerPositionalProperties layerPositionalProperties) {
        Intrinsics.checkNotNullParameter(layerPositionalProperties, "other");
        if (this.scaleX == layerPositionalProperties.scaleX) {
            if (this.scaleY == layerPositionalProperties.scaleY) {
                if (this.translationX == layerPositionalProperties.translationX) {
                    if (this.translationY == layerPositionalProperties.translationY) {
                        if (this.rotationX == layerPositionalProperties.rotationX) {
                            if (this.rotationY == layerPositionalProperties.rotationY) {
                                if (this.rotationZ == layerPositionalProperties.rotationZ) {
                                    if ((this.cameraDistance == layerPositionalProperties.cameraDistance) && TransformOrigin.m3124equalsimpl0(this.transformOrigin, layerPositionalProperties.transformOrigin)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void copyFrom(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "scope");
        this.scaleX = graphicsLayerScope.getScaleX();
        this.scaleY = graphicsLayerScope.getScaleY();
        this.translationX = graphicsLayerScope.getTranslationX();
        this.translationY = graphicsLayerScope.getTranslationY();
        this.rotationX = graphicsLayerScope.getRotationX();
        this.rotationY = graphicsLayerScope.getRotationY();
        this.rotationZ = graphicsLayerScope.getRotationZ();
        this.cameraDistance = graphicsLayerScope.getCameraDistance();
        this.transformOrigin = graphicsLayerScope.mo2942getTransformOriginSzJe1aQ();
    }
}
