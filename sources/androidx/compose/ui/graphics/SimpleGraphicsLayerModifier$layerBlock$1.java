package androidx.compose.ui.graphics;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SimpleGraphicsLayerModifier$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ SimpleGraphicsLayerModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.this$0 = simpleGraphicsLayerModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
        graphicsLayerScope.setScaleX(SimpleGraphicsLayerModifier.access$getScaleX$p(this.this$0));
        graphicsLayerScope.setScaleY(SimpleGraphicsLayerModifier.access$getScaleY$p(this.this$0));
        graphicsLayerScope.setAlpha(SimpleGraphicsLayerModifier.access$getAlpha$p(this.this$0));
        graphicsLayerScope.setTranslationX(SimpleGraphicsLayerModifier.access$getTranslationX$p(this.this$0));
        graphicsLayerScope.setTranslationY(SimpleGraphicsLayerModifier.access$getTranslationY$p(this.this$0));
        graphicsLayerScope.setShadowElevation(SimpleGraphicsLayerModifier.access$getShadowElevation$p(this.this$0));
        graphicsLayerScope.setRotationX(SimpleGraphicsLayerModifier.access$getRotationX$p(this.this$0));
        graphicsLayerScope.setRotationY(SimpleGraphicsLayerModifier.access$getRotationY$p(this.this$0));
        graphicsLayerScope.setRotationZ(SimpleGraphicsLayerModifier.access$getRotationZ$p(this.this$0));
        graphicsLayerScope.setCameraDistance(SimpleGraphicsLayerModifier.access$getCameraDistance$p(this.this$0));
        graphicsLayerScope.m1138setTransformOrigin__ExYCQ(SimpleGraphicsLayerModifier.access$getTransformOrigin$p(this.this$0));
        graphicsLayerScope.setShape(SimpleGraphicsLayerModifier.access$getShape$p(this.this$0));
        graphicsLayerScope.setClip(SimpleGraphicsLayerModifier.access$getClip$p(this.this$0));
        graphicsLayerScope.setRenderEffect(SimpleGraphicsLayerModifier.access$getRenderEffect$p(this.this$0));
        graphicsLayerScope.m1135setAmbientShadowColor8_81llA(SimpleGraphicsLayerModifier.access$getAmbientShadowColor$p(this.this$0));
        graphicsLayerScope.m1137setSpotShadowColor8_81llA(SimpleGraphicsLayerModifier.access$getSpotShadowColor$p(this.this$0));
        graphicsLayerScope.m1136setCompositingStrategyaDBOjCE(SimpleGraphicsLayerModifier.access$getCompositingStrategy$p(this.this$0));
    }
}
