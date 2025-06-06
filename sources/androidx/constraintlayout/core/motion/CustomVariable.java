package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.mBooleanValue = customVariable.mBooleanValue;
    }

    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static String colorString(int i) {
        return "#" + ("00000000" + Integer.toHexString(i)).substring(r2.length() - 8);
    }

    public static int hsvToRgb(float f, float f2, float f3) {
        float f4 = f * 6.0f;
        int i = (int) f4;
        float f5 = f4 - i;
        float f6 = f3 * 255.0f;
        int i2 = (int) (((1.0f - f2) * f6) + 0.5f);
        int i3 = (int) (((1.0f - (f5 * f2)) * f6) + 0.5f);
        int i4 = (int) (((1.0f - ((1.0f - f5) * f2)) * f6) + 0.5f);
        int i5 = (int) (f6 + 0.5f);
        if (i == 0) {
            return ((i5 << 16) + (i4 << 8) + i2) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 1) {
            return ((i3 << 16) + (i5 << 8) + i2) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 2) {
            return ((i2 << 16) + (i5 << 8) + i4) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 3) {
            return ((i2 << 16) + (i3 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 4) {
            return ((i4 << 16) + (i2 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i != 5) {
            return 0;
        }
        return ((i5 << 16) + (i2 << 8) + i3) | ViewCompat.MEASURED_STATE_MASK;
    }

    public static int rgbaTocColor(float f, float f2, float f3, float f4) {
        int clamp = clamp((int) (f * 255.0f));
        int clamp2 = clamp((int) (f2 * 255.0f));
        return (clamp << 16) | (clamp((int) (f4 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f3 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i = this.mType;
        switch (i) {
            case 900:
            case 902:
            case 906:
                motionWidget.setCustomAttribute(this.mName, i, this.mIntegerValue);
                break;
            case 901:
            case 905:
                motionWidget.setCustomAttribute(this.mName, i, this.mFloatValue);
                break;
            case 903:
                motionWidget.setCustomAttribute(this.mName, i, this.mStringValue);
                break;
            case 904:
                motionWidget.setCustomAttribute(this.mName, i, this.mBooleanValue);
                break;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i;
        if (customVariable == null || (i = this.mType) != customVariable.mType) {
            return false;
        }
        switch (i) {
            case 900:
            case 906:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                }
                break;
            case 901:
                if (this.mFloatValue == customVariable.mFloatValue) {
                }
                break;
            case 902:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                }
                break;
            case 903:
                if (this.mIntegerValue == customVariable.mIntegerValue) {
                }
                break;
            case 904:
                if (this.mBooleanValue == customVariable.mBooleanValue) {
                }
                break;
            case 905:
                if (this.mFloatValue == customVariable.mFloatValue) {
                }
                break;
        }
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case 900:
                return this.mIntegerValue;
            case 901:
                return this.mFloatValue;
            case 902:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case 905:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case 900:
                fArr[0] = this.mIntegerValue;
                return;
            case 901:
                fArr[0] = this.mFloatValue;
                return;
            case 902:
                int i = (this.mIntegerValue >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case 905:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i = this.mType;
        return (i == 903 || i == 904 || i == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.mType != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z) {
        this.mBooleanValue = z;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i = this.mType;
        switch (i) {
            case 900:
                motionWidget.setCustomAttribute(this.mName, i, (int) fArr[0]);
                return;
            case 901:
            case 905:
                motionWidget.setCustomAttribute(this.mName, i, fArr[0]);
                return;
            case 902:
                motionWidget.setCustomAttribute(this.mName, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case 903:
            case 906:
                throw new RuntimeException("unable to interpolate " + this.mName);
            case 904:
                motionWidget.setCustomAttribute(this.mName, i, fArr[0] > 0.5f);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case 900:
            case 906:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 901:
            case 905:
                this.mFloatValue = fArr[0];
                return;
            case 902:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.mName + ':';
        switch (this.mType) {
            case 900:
                return str + this.mIntegerValue;
            case 901:
                return str + this.mFloatValue;
            case 902:
                return str + colorString(this.mIntegerValue);
            case 903:
                return str + this.mStringValue;
            case 904:
                return str + Boolean.valueOf(this.mBooleanValue);
            case 905:
                return str + this.mFloatValue;
            default:
                return str + "????";
        }
    }

    public CustomVariable(String str, int i, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        this.mStringValue = str2;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case 900:
            case 906:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case 901:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case 902:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case 903:
                this.mStringValue = (String) obj;
                break;
            case 904:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 905:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }

    public CustomVariable(String str, int i, int i2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        if (i == 901) {
            this.mFloatValue = i2;
        } else {
            this.mIntegerValue = i2;
        }
    }

    public CustomVariable(String str, int i, float f) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        this.mFloatValue = f;
    }

    public CustomVariable(String str, int i, boolean z) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        this.mBooleanValue = z;
    }

    public CustomVariable(String str, int i) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
    }

    public CustomVariable(String str, int i, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        setValue(obj);
    }
}
