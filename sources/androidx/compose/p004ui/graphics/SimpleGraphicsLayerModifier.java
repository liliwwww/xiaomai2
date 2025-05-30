package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.C0790a;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class SimpleGraphicsLayerModifier extends InspectorValueInfo implements LayoutModifier {
    private final float alpha;
    private final long ambientShadowColor;
    private final float cameraDistance;
    private final boolean clip;
    private final int compositingStrategy;

    @NotNull
    private final Function1<GraphicsLayerScope, Unit> layerBlock;

    @Nullable
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;

    @NotNull
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, j2, j3, (i2 & 65536) != 0 ? CompositingStrategy.Companion.m2871getAutoNrFUSI() : i, function1, null);
    }

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, j2, j3, i, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = obj instanceof SimpleGraphicsLayerModifier ? (SimpleGraphicsLayerModifier) obj : null;
        if (simpleGraphicsLayerModifier == null) {
            return false;
        }
        if (!(this.scaleX == simpleGraphicsLayerModifier.scaleX)) {
            return false;
        }
        if (!(this.scaleY == simpleGraphicsLayerModifier.scaleY)) {
            return false;
        }
        if (!(this.alpha == simpleGraphicsLayerModifier.alpha)) {
            return false;
        }
        if (!(this.translationX == simpleGraphicsLayerModifier.translationX)) {
            return false;
        }
        if (!(this.translationY == simpleGraphicsLayerModifier.translationY)) {
            return false;
        }
        if (!(this.shadowElevation == simpleGraphicsLayerModifier.shadowElevation)) {
            return false;
        }
        if (!(this.rotationX == simpleGraphicsLayerModifier.rotationX)) {
            return false;
        }
        if (!(this.rotationY == simpleGraphicsLayerModifier.rotationY)) {
            return false;
        }
        if (this.rotationZ == simpleGraphicsLayerModifier.rotationZ) {
            return ((this.cameraDistance > simpleGraphicsLayerModifier.cameraDistance ? 1 : (this.cameraDistance == simpleGraphicsLayerModifier.cameraDistance ? 0 : -1)) == 0) && TransformOrigin.m3124equalsimpl0(this.transformOrigin, simpleGraphicsLayerModifier.transformOrigin) && Intrinsics.areEqual(this.shape, simpleGraphicsLayerModifier.shape) && this.clip == simpleGraphicsLayerModifier.clip && Intrinsics.areEqual(this.renderEffect, simpleGraphicsLayerModifier.renderEffect) && Color.m2788equalsimpl0(this.ambientShadowColor, simpleGraphicsLayerModifier.ambientShadowColor) && Color.m2788equalsimpl0(this.spotShadowColor, simpleGraphicsLayerModifier.spotShadowColor) && CompositingStrategy.m2867equalsimpl0(this.compositingStrategy, simpleGraphicsLayerModifier.compositingStrategy);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((((((((((((((Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.shadowElevation)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + TransformOrigin.m3127hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + l3.a(this.clip)) * 31;
        RenderEffect renderEffect = this.renderEffect;
        return ((((((floatToIntBits + (renderEffect != null ? renderEffect.hashCode() : 0)) * 31) + Color.m2794hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m2794hashCodeimpl(this.spotShadowColor)) * 31) + CompositingStrategy.m2868hashCodeimpl(this.compositingStrategy);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m141a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m142b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable placeable = Placeable.this;
                function1 = this.layerBlock;
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, function1, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m143c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m144d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha = " + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + ((Object) TransformOrigin.m3128toStringimpl(this.transformOrigin)) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + this.renderEffect + ", ambientShadowColor=" + ((Object) Color.m2795toStringimpl(this.ambientShadowColor)) + ", spotShadowColor=" + ((Object) Color.m2795toStringimpl(this.spotShadowColor)) + ", compositingStrategy=" + ((Object) CompositingStrategy.m2869toStringimpl(this.compositingStrategy)) + ')';
    }

    private SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.translationX = f4;
        this.translationY = f5;
        this.shadowElevation = f6;
        this.rotationX = f7;
        this.rotationY = f8;
        this.rotationZ = f9;
        this.cameraDistance = f10;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.renderEffect = renderEffect;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = i;
        this.layerBlock = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
                float f11;
                float f12;
                float f13;
                float f14;
                float f15;
                float f16;
                float f17;
                float f18;
                float f19;
                float f20;
                long j4;
                Shape shape2;
                boolean z2;
                RenderEffect renderEffect2;
                long j5;
                long j6;
                int i2;
                Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
                f11 = SimpleGraphicsLayerModifier.this.scaleX;
                graphicsLayerScope.setScaleX(f11);
                f12 = SimpleGraphicsLayerModifier.this.scaleY;
                graphicsLayerScope.setScaleY(f12);
                f13 = SimpleGraphicsLayerModifier.this.alpha;
                graphicsLayerScope.setAlpha(f13);
                f14 = SimpleGraphicsLayerModifier.this.translationX;
                graphicsLayerScope.setTranslationX(f14);
                f15 = SimpleGraphicsLayerModifier.this.translationY;
                graphicsLayerScope.setTranslationY(f15);
                f16 = SimpleGraphicsLayerModifier.this.shadowElevation;
                graphicsLayerScope.setShadowElevation(f16);
                f17 = SimpleGraphicsLayerModifier.this.rotationX;
                graphicsLayerScope.setRotationX(f17);
                f18 = SimpleGraphicsLayerModifier.this.rotationY;
                graphicsLayerScope.setRotationY(f18);
                f19 = SimpleGraphicsLayerModifier.this.rotationZ;
                graphicsLayerScope.setRotationZ(f19);
                f20 = SimpleGraphicsLayerModifier.this.cameraDistance;
                graphicsLayerScope.setCameraDistance(f20);
                j4 = SimpleGraphicsLayerModifier.this.transformOrigin;
                graphicsLayerScope.mo2946setTransformOrigin__ExYCQ(j4);
                shape2 = SimpleGraphicsLayerModifier.this.shape;
                graphicsLayerScope.setShape(shape2);
                z2 = SimpleGraphicsLayerModifier.this.clip;
                graphicsLayerScope.setClip(z2);
                renderEffect2 = SimpleGraphicsLayerModifier.this.renderEffect;
                graphicsLayerScope.setRenderEffect(renderEffect2);
                j5 = SimpleGraphicsLayerModifier.this.ambientShadowColor;
                graphicsLayerScope.mo2943setAmbientShadowColor8_81llA(j5);
                j6 = SimpleGraphicsLayerModifier.this.spotShadowColor;
                graphicsLayerScope.mo2945setSpotShadowColor8_81llA(j6);
                i2 = SimpleGraphicsLayerModifier.this.compositingStrategy;
                graphicsLayerScope.mo2944setCompositingStrategyaDBOjCE(i2);
            }
        };
    }
}
