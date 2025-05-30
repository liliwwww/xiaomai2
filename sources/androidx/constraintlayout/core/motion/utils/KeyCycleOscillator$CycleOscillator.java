package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class KeyCycleOscillator$CycleOscillator {
    private static final String TAG = "CycleOscillator";
    static final int UNSET = -1;
    private final int OFFST;
    private final int PHASE;
    private final int VALUE;
    CurveFit mCurveFit;
    float[] mOffset;
    Oscillator mOscillator;
    float mPathLength;
    float[] mPeriod;
    float[] mPhase;
    double[] mPosition;
    float[] mScale;
    double[] mSplineSlopeCache;
    double[] mSplineValueCache;
    float[] mValues;
    private final int mVariesBy;
    int mWaveShape;

    KeyCycleOscillator$CycleOscillator(int i, String str, int i2, int i3) {
        Oscillator oscillator = new Oscillator();
        this.mOscillator = oscillator;
        this.OFFST = 0;
        this.PHASE = 1;
        this.VALUE = 2;
        this.mWaveShape = i;
        this.mVariesBy = i2;
        oscillator.setType(i, str);
        this.mValues = new float[i3];
        this.mPosition = new double[i3];
        this.mPeriod = new float[i3];
        this.mOffset = new float[i3];
        this.mPhase = new float[i3];
        this.mScale = new float[i3];
    }

    public double getLastPhase() {
        return this.mSplineValueCache[1];
    }

    public double getSlope(float f) {
        CurveFit curveFit = this.mCurveFit;
        if (curveFit != null) {
            double d = f;
            curveFit.getSlope(d, this.mSplineSlopeCache);
            this.mCurveFit.getPos(d, this.mSplineValueCache);
        } else {
            double[] dArr = this.mSplineSlopeCache;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d2 = f;
        double value = this.mOscillator.getValue(d2, this.mSplineValueCache[1]);
        double slope = this.mOscillator.getSlope(d2, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
        double[] dArr2 = this.mSplineSlopeCache;
        return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
    }

    public double getValues(float f) {
        CurveFit curveFit = this.mCurveFit;
        if (curveFit != null) {
            curveFit.getPos(f, this.mSplineValueCache);
        } else {
            double[] dArr = this.mSplineValueCache;
            dArr[0] = this.mOffset[0];
            dArr[1] = this.mPhase[0];
            dArr[2] = this.mValues[0];
        }
        double[] dArr2 = this.mSplineValueCache;
        return dArr2[0] + (this.mOscillator.getValue(f, dArr2[1]) * this.mSplineValueCache[2]);
    }

    public void setPoint(int i, int i2, float f, float f2, float f3, float f4) {
        this.mPosition[i] = i2 / 100.0d;
        this.mPeriod[i] = f;
        this.mOffset[i] = f2;
        this.mPhase[i] = f3;
        this.mValues[i] = f4;
    }

    public void setup(float f) {
        this.mPathLength = f;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, this.mPosition.length, 3);
        float[] fArr = this.mValues;
        this.mSplineValueCache = new double[fArr.length + 2];
        this.mSplineSlopeCache = new double[fArr.length + 2];
        if (this.mPosition[0] > 0.0d) {
            this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
        }
        double[] dArr2 = this.mPosition;
        int length = dArr2.length - 1;
        if (dArr2[length] < 1.0d) {
            this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
        }
        for (int i = 0; i < dArr.length; i++) {
            dArr[i][0] = this.mOffset[i];
            dArr[i][1] = this.mPhase[i];
            dArr[i][2] = this.mValues[i];
            this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
        }
        this.mOscillator.normalize();
        double[] dArr3 = this.mPosition;
        if (dArr3.length > 1) {
            this.mCurveFit = CurveFit.get(0, dArr3, dArr);
        } else {
            this.mCurveFit = null;
        }
    }
}
