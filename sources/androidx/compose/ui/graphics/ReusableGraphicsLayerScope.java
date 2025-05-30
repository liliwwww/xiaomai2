package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    private long transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();

    @NotNull
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private int compositingStrategy = CompositingStrategy.Companion.m1075getAutoNrFUSI();
    private long size = Size.Companion.m911getUnspecifiedNHjbRc();

    @NotNull
    private Density graphicsDensity = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);

    public float getAlpha() {
        return this.alpha;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public long m1194getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public boolean getClip() {
        return this.clip;
    }

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public int m1195getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @NotNull
    public final Density getGraphicsDensity$ui_release() {
        return this.graphicsDensity;
    }

    @Nullable
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @NotNull
    public Shape getShape() {
        return this.shape;
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m1196getSizeNHjbRc() {
        return this.size;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public long m1197getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    public long m1198getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public float getTranslationX() {
        return this.translationX;
    }

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
        m1201setAmbientShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        m1204setSpotShadowColor8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        setRotationX(0.0f);
        setRotationY(0.0f);
        setRotationZ(0.0f);
        setCameraDistance(8.0f);
        m1205setTransformOrigin__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
        setShape(RectangleShapeKt.getRectangleShape());
        setClip(false);
        setRenderEffect(null);
        m1202setCompositingStrategyaDBOjCE(CompositingStrategy.Companion.m1075getAutoNrFUSI());
        m1203setSizeuvyYCjk(Size.Companion.m911getUnspecifiedNHjbRc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ int m1199roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public /* synthetic */ int m1200roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public void m1201setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
    }

    public void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    public void setClip(boolean z) {
        this.clip = z;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public void m1202setCompositingStrategyaDBOjCE(int i) {
        this.compositingStrategy = i;
    }

    public final void setGraphicsDensity$ui_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.graphicsDensity = density;
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public void setRotationX(float f) {
        this.rotationX = f;
    }

    public void setRotationY(float f) {
        this.rotationY = f;
    }

    public void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
    }

    public void setShadowElevation(float f) {
        this.shadowElevation = f;
    }

    public void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        this.shape = shape;
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m1203setSizeuvyYCjk(long j) {
        this.size = j;
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public void m1204setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
    }

    /* renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    public void m1205setTransformOrigin__ExYCQ(long j) {
        this.transformOrigin = j;
    }

    public void setTranslationX(float f) {
        this.translationX = f;
    }

    public void setTranslationY(float f) {
        this.translationY = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public /* synthetic */ float m1206toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m1207toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m1208toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public /* synthetic */ long m1209toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ float m1210toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public /* synthetic */ float m1211toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public /* synthetic */ long m1212toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public /* synthetic */ long m1213toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m1214toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m1215toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
