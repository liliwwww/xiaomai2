package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SplineSet$CustomSet extends SplineSet {
    String mAttributeName;
    KeyFrameArray.CustomArray mConstraintAttributeList;
    float[] mTempValues;

    public SplineSet$CustomSet(String str, KeyFrameArray.CustomArray customArray) {
        this.mAttributeName = str.split(",")[1];
        this.mConstraintAttributeList = customArray;
    }

    public void setPoint(int i, float f) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    public void setProperty(WidgetFrame widgetFrame, float f) {
        ((SplineSet) this).mCurveFit.getPos(f, this.mTempValues);
        widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
    }

    public void setup(int i) {
        int size = this.mConstraintAttributeList.size();
        int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
        double[] dArr = new double[size];
        this.mTempValues = new float[numberOfInterpolatedValues];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, numberOfInterpolatedValues);
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.mConstraintAttributeList.keyAt(i2);
            CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i2);
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

    public void setPoint(int i, CustomAttribute customAttribute) {
        this.mConstraintAttributeList.append(i, customAttribute);
    }
}
