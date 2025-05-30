package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CanvasDrawScopeKt {

    @NotNull
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo1327clipPathmtrdDE(@NotNull Path path, int i) {
                Intrinsics.checkNotNullParameter(path, "path");
                drawContext.getCanvas().clipPath-mtrdD-E(path, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo1328clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
                drawContext.getCanvas().clipRect-N_I0leg(f, f2, f3, f4, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo1329getCenterF1C5BW0() {
                return SizeKt.m913getCenteruvyYCjk(mo1330getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo1330getSizeNHjbRc() {
                return drawContext.getSize-NH-jbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float f, float f2, float f3, float f4) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long Size = SizeKt.Size(Size.m903getWidthimpl(mo1330getSizeNHjbRc()) - (f3 + f), Size.m900getHeightimpl(mo1330getSizeNHjbRc()) - (f4 + f2));
                if (!(Size.m903getWidthimpl(Size) >= 0.0f && Size.m900getHeightimpl(Size) >= 0.0f)) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext2.setSize-uvyYCjk(Size);
                canvas.translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo1331rotateUv8p0NA(float f, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m848getXimpl(j), Offset.m849getYimpl(j));
                canvas.rotate(f);
                canvas.translate(-Offset.m848getXimpl(j), -Offset.m849getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo1332scale0AR0LA0(float f, float f2, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m848getXimpl(j), Offset.m849getYimpl(j));
                canvas.scale(f, f2);
                canvas.translate(-Offset.m848getXimpl(j), -Offset.m849getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo1333transform58bKbWc(@NotNull float[] fArr) {
                Intrinsics.checkNotNullParameter(fArr, "matrix");
                drawContext.getCanvas().concat-58bKbWc(fArr);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float f, float f2) {
                drawContext.getCanvas().translate(f, f2);
            }
        };
    }
}
