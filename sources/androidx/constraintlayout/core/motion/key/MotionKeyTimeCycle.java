package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import tb.aq5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;
    private int mWaveShape = 0;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;

    public MotionKeyTimeCycle() {
        ((MotionKey) this).mType = 3;
        ((MotionKey) this).mCustom = new HashMap();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x008c, code lost:
    
        if (r1.equals("scaleX") == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r11) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (((MotionKey) this).mCustom.size() > 0) {
            Iterator it = ((MotionKey) this).mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    public int getId(String str) {
        return aq5.a(str);
    }

    public boolean setValue(int i, int i2) {
        if (i == 100) {
            ((MotionKey) this).mFramePosition = i2;
            return true;
        }
        if (i != 421) {
            return super.setValue(i, i2);
        }
        this.mWaveShape = i2;
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MotionKey m2778clone() {
        return new MotionKeyTimeCycle().copy((MotionKey) this);
    }

    public MotionKeyTimeCycle copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.mTransitionEasing = motionKeyTimeCycle.mTransitionEasing;
        this.mCurveFit = motionKeyTimeCycle.mCurveFit;
        this.mWaveShape = motionKeyTimeCycle.mWaveShape;
        this.mWavePeriod = motionKeyTimeCycle.mWavePeriod;
        this.mWaveOffset = motionKeyTimeCycle.mWaveOffset;
        this.mProgress = motionKeyTimeCycle.mProgress;
        this.mAlpha = motionKeyTimeCycle.mAlpha;
        this.mElevation = motionKeyTimeCycle.mElevation;
        this.mRotation = motionKeyTimeCycle.mRotation;
        this.mTransitionPathRotate = motionKeyTimeCycle.mTransitionPathRotate;
        this.mRotationX = motionKeyTimeCycle.mRotationX;
        this.mRotationY = motionKeyTimeCycle.mRotationY;
        this.mScaleX = motionKeyTimeCycle.mScaleX;
        this.mScaleY = motionKeyTimeCycle.mScaleY;
        this.mTranslationX = motionKeyTimeCycle.mTranslationX;
        this.mTranslationY = motionKeyTimeCycle.mTranslationY;
        this.mTranslationZ = motionKeyTimeCycle.mTranslationZ;
        return this;
    }

    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.mProgress = toFloat(Float.valueOf(f));
            return true;
        }
        if (i == 401) {
            this.mCurveFit = toInt(Float.valueOf(f));
            return true;
        }
        if (i == 403) {
            this.mAlpha = f;
            return true;
        }
        if (i == 416) {
            this.mTransitionPathRotate = toFloat(Float.valueOf(f));
            return true;
        }
        if (i == 423) {
            this.mWavePeriod = toFloat(Float.valueOf(f));
            return true;
        }
        if (i != 424) {
            switch (i) {
                case 304:
                    this.mTranslationX = toFloat(Float.valueOf(f));
                    return true;
                case 305:
                    this.mTranslationY = toFloat(Float.valueOf(f));
                    return true;
                case 306:
                    this.mTranslationZ = toFloat(Float.valueOf(f));
                    return true;
                case 307:
                    this.mElevation = toFloat(Float.valueOf(f));
                    return true;
                case 308:
                    this.mRotationX = toFloat(Float.valueOf(f));
                    return true;
                case 309:
                    this.mRotationY = toFloat(Float.valueOf(f));
                    return true;
                case 310:
                    this.mRotation = toFloat(Float.valueOf(f));
                    return true;
                case 311:
                    this.mScaleX = toFloat(Float.valueOf(f));
                    return true;
                case 312:
                    this.mScaleY = toFloat(Float.valueOf(f));
                    return true;
                default:
                    return super.setValue(i, f);
            }
        }
        this.mWaveOffset = toFloat(Float.valueOf(f));
        return true;
    }

    public boolean setValue(int i, String str) {
        if (i == 420) {
            this.mTransitionEasing = str;
            return true;
        }
        if (i != 421) {
            return super.setValue(i, str);
        }
        this.mWaveShape = 7;
        this.mCustomWaveShape = str;
        return true;
    }

    public boolean setValue(int i, boolean z) {
        return super.setValue(i, z);
    }
}
