package androidx.constraintlayout.motion.utils;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewSpline$CustomSet extends ViewSpline {
    String mAttributeName;
    SparseArray<ConstraintAttribute> mConstraintAttributeList;
    float[] mTempValues;

    public ViewSpline$CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
        this.mAttributeName = str.split(",")[1];
        this.mConstraintAttributeList = sparseArray;
    }

    public void setPoint(int i, float f) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    public void setProperty(View view, float f) {
        ((SplineSet) this).mCurveFit.getPos(f, this.mTempValues);
        CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mTempValues);
    }

    public void setup(int i) {
        int size = this.mConstraintAttributeList.size();
        int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
        double[] dArr = new double[size];
        this.mTempValues = new float[numberOfInterpolatedValues];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, numberOfInterpolatedValues);
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.mConstraintAttributeList.keyAt(i2);
            ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i2);
            dArr[i2] = keyAt * 0.01d;
            valueAt.getValuesToInterpolate(this.mTempValues);
            int i3 = 0;
            while (true) {
                if (i3 < this.mTempValues.length) {
                    dArr2[i2][i3] = r6[i3];
                    i3++;
                }
            }
        }
        ((SplineSet) this).mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public void setPoint(int i, ConstraintAttribute constraintAttribute) {
        this.mConstraintAttributeList.append(i, constraintAttribute);
    }
}
