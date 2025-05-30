package androidx.compose.p004ui.platform;

import android.view.View;
import androidx.compose.p004ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.p004ui.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {

    @NotNull
    private final int[] tmpLocation = new int[2];

    @NotNull
    private final float[] tmpMatrix = Matrix.m2982constructorimpl$default(null, 1, null);

    /* renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m4489preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m2669setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m4479preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m4490preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        Matrix.m2991resetimpl(this.tmpMatrix);
        Matrix.m3002translateimpl$default(this.tmpMatrix, f, f2, 0.0f, 4, null);
        AndroidComposeView_androidKt.m4479preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m4491transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m4491transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m4490preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m4490preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m4490preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m4490preTranslate3XD1CNM(fArr, r0[0], r0[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(matrix, "viewMatrix");
        m4489preConcattUYjHk(fArr, matrix);
    }

    @Override // androidx.compose.p004ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo4488calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.m2991resetimpl(fArr);
        m4491transformMatrixToWindowEL8BTi8(view, fArr);
    }
}
