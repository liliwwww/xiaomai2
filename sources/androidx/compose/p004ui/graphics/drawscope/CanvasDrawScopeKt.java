package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DensityKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt {

    @NotNull
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo3213clipPathmtrdDE(@NotNull Path path, int i) {
                Intrinsics.checkNotNullParameter(path, "path");
                DrawContext.this.getCanvas().mo2650clipPathmtrdDE(path, i);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo3214clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
                DrawContext.this.getCanvas().mo2651clipRectN_I0leg(f, f2, f3, f4, i);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo3215getCenterF1C5BW0() {
                return SizeKt.m2635getCenteruvyYCjk(mo3216getSizeNHjbRc());
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo3216getSizeNHjbRc() {
                return DrawContext.this.mo3211getSizeNHjbRc();
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            public void inset(float f, float f2, float f3, float f4) {
                Canvas canvas = DrawContext.this.getCanvas();
                DrawContext drawContext2 = DrawContext.this;
                long Size = SizeKt.Size(Size.m2625getWidthimpl(mo3216getSizeNHjbRc()) - (f3 + f), Size.m2622getHeightimpl(mo3216getSizeNHjbRc()) - (f4 + f2));
                if (!(Size.m2625getWidthimpl(Size) >= 0.0f && Size.m2622getHeightimpl(Size) >= 0.0f)) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext2.mo3212setSizeuvyYCjk(Size);
                canvas.translate(f, f2);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo3217rotateUv8p0NA(float f, long j) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
                canvas.rotate(f);
                canvas.translate(-Offset.m2556getXimpl(j), -Offset.m2557getYimpl(j));
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo3218scale0AR0LA0(float f, float f2, long j) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
                canvas.scale(f, f2);
                canvas.translate(-Offset.m2556getXimpl(j), -Offset.m2557getYimpl(j));
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo3219transform58bKbWc(@NotNull float[] fArr) {
                Intrinsics.checkNotNullParameter(fArr, "matrix");
                DrawContext.this.getCanvas().mo2653concat58bKbWc(fArr);
            }

            @Override // androidx.compose.p004ui.graphics.drawscope.DrawTransform
            public void translate(float f, float f2) {
                DrawContext.this.getCanvas().translate(f, f2);
            }
        };
    }
}
