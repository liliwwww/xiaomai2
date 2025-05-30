package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DensityKt;
import androidx.compose.p004ui.unit.DpRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    private boolean clip;

    @Nullable
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float shadowElevation;
    private float translationX;
    private float translationY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float alpha = 1.0f;
    private long ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private long spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
    private float cameraDistance = 8.0f;
    private long transformOrigin = TransformOrigin.Companion.m3130getCenterSzJe1aQ();

    @NotNull
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private int compositingStrategy = CompositingStrategy.Companion.m2871getAutoNrFUSI();
    private long size = Size.Companion.m2633getUnspecifiedNHjbRc();

    @NotNull
    private Density graphicsDensity = DensityKt.Density$default(1.0f, 0.0f, 2, null);

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: getAmbientShadowColor-0d7_KjU */
    public long mo2938getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: getCompositingStrategy--NrFUSI */
    public int mo2939getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @NotNull
    public final Density getGraphicsDensity$ui_release() {
        return this.graphicsDensity;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    @Nullable
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    @NotNull
    public Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: getSize-NH-jbRc */
    public long mo2940getSizeNHjbRc() {
        return this.size;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: getSpotShadowColor-0d7_KjU */
    public long mo2941getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: getTransformOrigin-SzJe1aQ */
    public long mo2942getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public float getTranslationY() {
        return this.translationY;
    }

    public final void reset() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setShadowElevation(0.0f);
        mo2943setAmbientShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        mo2945setSpotShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        setRotationX(0.0f);
        setRotationY(0.0f);
        setRotationZ(0.0f);
        setCameraDistance(8.0f);
        mo2946setTransformOrigin__ExYCQ(TransformOrigin.Companion.m3130getCenterSzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        setClip(false);
        setRenderEffect(null);
        mo2944setCompositingStrategyaDBOjCE(CompositingStrategy.Companion.m2871getAutoNrFUSI());
        m3059setSizeuvyYCjk(Size.Companion.m2633getUnspecifiedNHjbRc());
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo1276roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo1277roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setAlpha(float f) {
        this.alpha = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo2943setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setClip(boolean z) {
        this.clip = z;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public void mo2944setCompositingStrategyaDBOjCE(int i) {
        this.compositingStrategy = i;
    }

    public final void setGraphicsDensity$ui_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.graphicsDensity = density;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setRotationX(float f) {
        this.rotationX = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setRotationY(float f) {
        this.rotationY = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setRotationZ(float f) {
        this.rotationZ = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setScaleX(float f) {
        this.scaleX = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setScaleY(float f) {
        this.scaleY = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setShadowElevation(float f) {
        this.shadowElevation = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        this.shape = shape;
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m3059setSizeuvyYCjk(long j) {
        this.size = j;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo2945setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    /* renamed from: setTransformOrigin-__ExYCQ */
    public void mo2946setTransformOrigin__ExYCQ(long j) {
        this.transformOrigin = j;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setTranslationX(float f) {
        this.translationX = f;
    }

    @Override // androidx.compose.p004ui.graphics.GraphicsLayerScope
    public void setTranslationY(float f) {
        this.translationY = f;
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo1278toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1279toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1280toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo1281toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo1282toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo1283toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo1284toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo1285toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1286toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1287toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
