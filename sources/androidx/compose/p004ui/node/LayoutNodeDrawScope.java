package androidx.compose.p004ui.node;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements ContentDrawScope, DrawScope {

    @NotNull
    private final CanvasDrawScope canvasDrawScope;

    @Nullable
    private DrawModifierNode drawNode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LayoutNodeDrawScope() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.node.LayoutNodeDrawScope.<init>():void");
    }

    public LayoutNodeDrawScope(@NotNull CanvasDrawScope canvasDrawScope) {
        Intrinsics.checkNotNullParameter(canvasDrawScope, "canvasDrawScope");
        this.canvasDrawScope = canvasDrawScope;
    }

    /* renamed from: draw-x_KDEd0$ui_release, reason: not valid java name */
    public final void m4324drawx_KDEd0$ui_release(@NotNull Canvas canvas, long j, @NotNull NodeCoordinator nodeCoordinator, @NotNull DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(drawModifierNode, "drawNode");
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long m3207component4NHjbRc = drawParams.m3207component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(nodeCoordinator);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m3210setSizeuvyYCjk(j);
        canvas.save();
        drawModifierNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m3210setSizeuvyYCjk(m3207component4NHjbRc);
        this.drawNode = drawModifierNode2;
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-illE91I */
    public void mo3185drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3185drawArcillE91I(brush, f, f2, z, j, j2, f3, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public void mo3186drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3186drawArcyD3GUKo(j, f, f2, z, j2, j3, f3, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-V9BoPsw */
    public void mo3187drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3187drawCircleV9BoPsw(brush, f, j, f2, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo3188drawCircleVaOC9Bg(long j, float f, long j2, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3188drawCircleVaOC9Bg(j, f, j2, f2, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        DrawModifierNode nextDrawNode;
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (nextDrawNode != null) {
            performDraw(nextDrawNode, canvas);
            return;
        }
        NodeCoordinator m4288requireCoordinator64DMado = DelegatableNodeKt.m4288requireCoordinator64DMado(drawModifierNode, NodeKind.m4398constructorimpl(4));
        if (m4288requireCoordinator64DMado.getTail() == drawModifierNode) {
            m4288requireCoordinator64DMado = m4288requireCoordinator64DMado.getWrapped$ui_release();
            Intrinsics.checkNotNull(m4288requireCoordinator64DMado);
        }
        m4288requireCoordinator64DMado.performDraw(canvas);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo3189drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3189drawImage9jGpkUE(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo3190drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3190drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo3191drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3191drawImagegbVJVH8(imageBitmap, j, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo3192drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.mo3192drawLine1RTmtNc(brush, j, j2, f, i, pathEffect, f2, colorFilter, i2);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public void mo3193drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2) {
        this.canvasDrawScope.mo3193drawLineNGM6Ib0(j, j2, j3, f, i, pathEffect, f2, colorFilter, i2);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-AsUm42w */
    public void mo3194drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3194drawOvalAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-n-J9OG0 */
    public void mo3195drawOvalnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3195drawOvalnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo3196drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3196drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo3197drawPathLG529CI(@NotNull Path path, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3197drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8 */
    public void mo3198drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        this.canvasDrawScope.mo3198drawPointsF8ZwMP8(list, i, j, f, i2, pathEffect, f2, colorFilter, i3);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-Gsft0Ws */
    public void mo3199drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.mo3199drawPointsGsft0Ws(list, i, brush, f, i2, pathEffect, f2, colorFilter, i3);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo3200drawRectAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3200drawRectAsUm42w(brush, j, j2, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo3201drawRectnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3201drawRectnJ9OG0(j, j2, j3, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo3202drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3202drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo3203drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, float f, @Nullable ColorFilter colorFilter, int i) {
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.mo3203drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle, f, colorFilter, i);
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo3204getCenterF1C5BW0() {
        return this.canvasDrawScope.mo3204getCenterF1C5BW0();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.p004ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo3205getSizeNHjbRc() {
        return this.canvasDrawScope.mo3205getSizeNHjbRc();
    }

    public final void performDraw(@NotNull DrawModifierNode drawModifierNode, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator m4288requireCoordinator64DMado = DelegatableNodeKt.m4288requireCoordinator64DMado(drawModifierNode, NodeKind.m4398constructorimpl(4));
        m4288requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m4324drawx_KDEd0$ui_release(canvas, IntSizeKt.m5386toSizeozmzZPI(m4288requireCoordinator64DMado.mo4191getSizeYbymL2g()), m4288requireCoordinator64DMado, drawModifierNode);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx--R2X_6o */
    public int mo1276roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.mo1276roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx-0680j_4 */
    public int mo1277roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo1277roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-GaN1DYA */
    public float mo1278toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo1278toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo1279toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo1279toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo1280toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo1280toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    public long mo1281toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo1281toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx--R2X_6o */
    public float mo1282toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo1282toPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx-0680j_4 */
    public float mo1283toPx0680j_4(float f) {
        return this.canvasDrawScope.mo1283toPx0680j_4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ */
    public long mo1284toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo1284toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-0xMU5do */
    public long mo1285toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo1285toSp0xMU5do(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1286toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo1286toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1287toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.mo1287toSpkPz2Gy4(i);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
