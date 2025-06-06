package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.http.e;
import tb.zp5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MotionKeyCycle extends MotionKey {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePhase = 0.0f;
    private float mProgress = Float.NaN;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public MotionKeyCycle() {
        this.mType = 4;
        this.mCustom = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith(MotionKey.CUSTOM)) {
                CustomVariable customVariable = this.mCustom.get(str.substring(7));
                if (customVariable != null && customVariable.getType() == 901 && (keyCycleOscillator = hashMap.get(str)) != null) {
                    keyCycleOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, customVariable.getValueToInterpolate(), customVariable);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (keyCycleOscillator2 = hashMap.get(str)) != null) {
                    keyCycleOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo2314clone() {
        return null;
    }

    public void dump() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.mWaveShape + ", mWavePeriod=" + this.mWavePeriod + ", mWaveOffset=" + this.mWaveOffset + ", mWavePhase=" + this.mWavePhase + ", mRotation=" + this.mRotation + '}');
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(MotionKey.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(MotionKey.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(MotionKey.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(MotionKey.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(MotionKey.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(MotionKey.SCALE_Y);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(MotionKey.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(MotionKey.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int getId(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1581616630:
                if (str.equals("customWave")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1310311125:
                if (str.equals("easing")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals(MotionKey.ROTATION_X)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320804:
                if (str.equals(MotionKey.ROTATION)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals(MotionKey.TRANSLATION_X)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(MotionKey.TRANSLATION_Y)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1019779949:
                if (str.equals("offset")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -991726143:
                if (str.equals("period")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(MotionKey.SCALE_X)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(MotionKey.SCALE_Y)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals(MotionKey.ALPHA)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 106629499:
                if (str.equals("phase")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals(MotionKey.VISIBILITY)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 422;
            case 1:
                return 420;
            case 2:
                return e.HTTP_PERM_REDIRECT;
            case 3:
                return 309;
            case 4:
                return 310;
            case 5:
                return 304;
            case 6:
                return 305;
            case 7:
                return 306;
            case '\b':
                return 424;
            case '\t':
                return 315;
            case '\n':
                return 423;
            case 11:
                return 313;
            case '\f':
                return 314;
            case '\r':
                return 311;
            case 14:
                return 312;
            case 15:
                return 403;
            case 16:
                return 425;
            case 17:
                return 401;
            case 18:
                return 416;
            case 19:
                return 421;
            case 20:
                return 402;
            default:
                return -1;
        }
    }

    public float getValue(String str) {
        str.hashCode();
        switch (str) {
            case "rotationX":
                return this.mRotationX;
            case "rotationY":
                return this.mRotationY;
            case "rotationZ":
                return this.mRotation;
            case "translationX":
                return this.mTranslationX;
            case "translationY":
                return this.mTranslationY;
            case "translationZ":
                return this.mTranslationZ;
            case "offset":
                return this.mWaveOffset;
            case "progress":
                return this.mProgress;
            case "scaleX":
                return this.mScaleX;
            case "scaleY":
                return this.mScaleY;
            case "elevation":
                return this.mElevation;
            case "alpha":
                return this.mAlpha;
            case "phase":
                return this.mWavePhase;
            case "pathRotate":
                return this.mTransitionPathRotate;
            default:
                return Float.NaN;
        }
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.mWaveShape + ", Period=" + this.mWavePeriod + ", Offset=" + this.mWaveOffset + ", Phase=" + this.mWavePhase + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            zp5.a(strArr[i]);
            Utils.log(strArr[i] + ":" + getValue(strArr[i]));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, int i2) {
        if (i == 401) {
            this.mCurveFit = i2;
            return true;
        }
        if (i == 421) {
            this.mWaveShape = i2;
            return true;
        }
        if (setValue(i, i2)) {
            return true;
        }
        return super.setValue(i, i2);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, String str) {
        if (i == 420) {
            this.mTransitionEasing = str;
            return true;
        }
        if (i != 422) {
            return super.setValue(i, str);
        }
        this.mCustomWaveShape = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.mProgress = f;
            return true;
        }
        if (i == 403) {
            this.mAlpha = f;
            return true;
        }
        if (i != 416) {
            switch (i) {
                case 304:
                    this.mTranslationX = f;
                    return true;
                case 305:
                    this.mTranslationY = f;
                    return true;
                case 306:
                    this.mTranslationZ = f;
                    return true;
                case e.HTTP_TEMP_REDIRECT /* 307 */:
                    this.mElevation = f;
                    return true;
                case e.HTTP_PERM_REDIRECT /* 308 */:
                    this.mRotationX = f;
                    return true;
                case 309:
                    this.mRotationY = f;
                    return true;
                case 310:
                    this.mRotation = f;
                    return true;
                case 311:
                    this.mScaleX = f;
                    return true;
                case 312:
                    this.mScaleY = f;
                    return true;
                default:
                    switch (i) {
                        case 423:
                            this.mWavePeriod = f;
                            return true;
                        case 424:
                            this.mWaveOffset = f;
                            return true;
                        case 425:
                            this.mWavePhase = f;
                            return true;
                        default:
                            return super.setValue(i, f);
                    }
            }
        }
        this.mTransitionPathRotate = f;
        return true;
    }
}
