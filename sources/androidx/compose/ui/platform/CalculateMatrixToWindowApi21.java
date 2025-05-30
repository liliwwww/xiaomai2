package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {

    @NotNull
    private final int[] tmpLocation = new int[2];

    @NotNull
    private final float[] tmpMatrix = Matrix.m1153constructorimpl$default(null, 1, null);

    /* renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m1731preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m1724preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m1732preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        Matrix.m1162resetimpl(this.tmpMatrix);
        Matrix.m1173translateimpl$default(this.tmpMatrix, f, f2, 0.0f, 4, null);
        AndroidComposeView_androidKt.m1724preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m1733transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m1733transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m1732preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m1732preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m1732preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m1732preTranslate3XD1CNM(fArr, r0[0], r0[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(matrix, "viewMatrix");
        m1731preConcattUYjHk(fArr, matrix);
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo1730calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.m1162resetimpl(fArr);
        m1733transformMatrixToWindowEL8BTi8(view, fArr);
    }
}
