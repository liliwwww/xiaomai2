package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    /* compiled from: Taobao */
    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            ((TimeCycleSplineSet) this).mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - ((TimeCycleSplineSet) this).last_time;
            if (Float.isNaN(((TimeCycleSplineSet) this).last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                ((TimeCycleSplineSet) this).last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    ((TimeCycleSplineSet) this).last_cycle = 0.0f;
                }
            }
            float f4 = (float) ((((TimeCycleSplineSet) this).last_cycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            ((TimeCycleSplineSet) this).last_cycle = f4;
            ((TimeCycleSplineSet) this).last_time = j;
            float calcWave = calcWave(f4);
            ((TimeCycleSplineSet) this).mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z = ((TimeCycleSplineSet) this).mContinue;
                float[] fArr3 = this.mTempValues;
                ((TimeCycleSplineSet) this).mContinue = z | (((double) fArr3[i]) != 0.0d);
                fArr2[i] = (fArr3[i] * calcWave) + f3;
                i++;
            }
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (f2 != 0.0f) {
                ((TimeCycleSplineSet) this).mContinue = true;
            }
            return ((TimeCycleSplineSet) this).mContinue;
        }

        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i2];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i3);
                ConstraintAttribute valueAt = this.mConstraintAttributeList.valueAt(i3);
                float[] valueAt2 = this.mWaveProperties.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    if (i4 < this.mTempValues.length) {
                        dArr2[i3][i4] = r8[i4];
                        i4++;
                    }
                }
                dArr2[i3][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i3][numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            ((TimeCycleSplineSet) this).mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
            this.mWaveProperties.append(i, new float[]{f, f2});
            ((TimeCycleSplineSet) this).mWaveShape = Math.max(((TimeCycleSplineSet) this).mWaveShape, i2);
        }
    }

    /* compiled from: Taobao */
    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f, j, view, keyCache));
            }
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    /* compiled from: Taobao */
    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f, j, view, keyCache));
            }
            return ((TimeCycleSplineSet) this).mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j) {
        ViewTimeCycle rotationXset;
        str.hashCode();
        switch (str) {
            case "rotationX":
                rotationXset = new RotationXset();
                break;
            case "rotationY":
                rotationXset = new RotationYset();
                break;
            case "translationX":
                rotationXset = new TranslationXset();
                break;
            case "translationY":
                rotationXset = new TranslationYset();
                break;
            case "translationZ":
                rotationXset = new TranslationZset();
                break;
            case "progress":
                rotationXset = new ProgressSet();
                break;
            case "scaleX":
                rotationXset = new ScaleXset();
                break;
            case "scaleY":
                rotationXset = new ScaleYset();
                break;
            case "rotation":
                rotationXset = new RotationSet();
                break;
            case "elevation":
                rotationXset = new ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new PathRotate();
                break;
            case "alpha":
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j);
        return rotationXset;
    }

    public float get(float f, long j, View view, KeyCache keyCache) {
        ((TimeCycleSplineSet) this).mCurveFit.getPos(f, ((TimeCycleSplineSet) this).mCache);
        float[] fArr = ((TimeCycleSplineSet) this).mCache;
        float f2 = fArr[1];
        if (f2 == 0.0f) {
            ((TimeCycleSplineSet) this).mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(((TimeCycleSplineSet) this).last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, ((TimeCycleSplineSet) this).mType, 0);
            ((TimeCycleSplineSet) this).last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                ((TimeCycleSplineSet) this).last_cycle = 0.0f;
            }
        }
        float f3 = (float) ((((TimeCycleSplineSet) this).last_cycle + (((j - ((TimeCycleSplineSet) this).last_time) * 1.0E-9d) * f2)) % 1.0d);
        ((TimeCycleSplineSet) this).last_cycle = f3;
        keyCache.setFloatValue(view, ((TimeCycleSplineSet) this).mType, 0, f3);
        ((TimeCycleSplineSet) this).last_time = j;
        float f4 = ((TimeCycleSplineSet) this).mCache[0];
        float calcWave = (calcWave(((TimeCycleSplineSet) this).last_cycle) * f4) + ((TimeCycleSplineSet) this).mCache[2];
        ((TimeCycleSplineSet) this).mContinue = (f4 == 0.0f && f2 == 0.0f) ? false : true;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);
}
