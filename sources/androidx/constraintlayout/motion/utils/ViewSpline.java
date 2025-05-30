package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            this.mCurveFit.getPos(f, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
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
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f));
            }
        }
    }

    /* compiled from: Taobao */
    public static class PathRotate extends ViewSpline {
        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
        }
    }

    /* compiled from: Taobao */
    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    /* compiled from: Taobao */
    static class ProgressSet extends ViewSpline {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(f)));
                } catch (IllegalAccessException e) {
                    Log.e(ViewSpline.TAG, "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e(ViewSpline.TAG, "unable to setProgress", e2);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    /* compiled from: Taobao */
    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    /* compiled from: Taobao */
    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    /* compiled from: Taobao */
    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f));
            }
        }
    }

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewSpline makeSpline(String str) {
        str.hashCode();
        switch (str) {
        }
        return new AlphaSet();
    }

    public abstract void setProperty(View view, float f);
}
