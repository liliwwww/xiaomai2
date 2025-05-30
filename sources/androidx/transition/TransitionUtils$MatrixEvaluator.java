package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TransitionUtils$MatrixEvaluator implements TypeEvaluator<Matrix> {
    final float[] mTempStartValues = new float[9];
    final float[] mTempEndValues = new float[9];
    final Matrix mTempMatrix = new Matrix();

    TransitionUtils$MatrixEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.mTempStartValues);
        matrix2.getValues(this.mTempEndValues);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.mTempEndValues;
            float f2 = fArr[i];
            float[] fArr2 = this.mTempStartValues;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.mTempMatrix.setValues(this.mTempEndValues);
        return this.mTempMatrix;
    }
}
