package androidx.constraintlayout.core.state;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public final HashMap<String, CustomVariable> mCustom;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    private static void add(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        int i3;
        float f2;
        int i4;
        float f3;
        float f4;
        int i5;
        float f5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f6 = 100.0f * f;
        int i10 = (int) f6;
        int i11 = widgetFrame2.left;
        int i12 = widgetFrame2.top;
        int i13 = widgetFrame3.left;
        int i14 = widgetFrame3.top;
        int i15 = widgetFrame2.right - i11;
        int i16 = widgetFrame2.bottom - i12;
        int i17 = widgetFrame3.right - i13;
        int i18 = widgetFrame3.bottom - i14;
        float f7 = widgetFrame2.alpha;
        float f8 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            i11 = (int) (i11 - (i17 / 2.0f));
            i12 = (int) (i12 - (i18 / 2.0f));
            if (Float.isNaN(f7)) {
                i4 = i18;
                i3 = i17;
                f2 = 0.0f;
            } else {
                f2 = f7;
                i3 = i17;
                i4 = i18;
            }
        } else {
            i3 = i15;
            f2 = f7;
            i4 = i16;
        }
        if (widgetFrame3.visibility == 8) {
            i13 = (int) (i13 - (i3 / 2.0f));
            i14 = (int) (i14 - (i4 / 2.0f));
            i17 = i3;
            i18 = i4;
            if (Float.isNaN(f8)) {
                f8 = 0.0f;
            }
        }
        if (Float.isNaN(f2) && !Float.isNaN(f8)) {
            f2 = 1.0f;
        }
        if (!Float.isNaN(f2) && Float.isNaN(f8)) {
            f8 = 1.0f;
        }
        if (widgetFrame2.visibility == 4) {
            f4 = f8;
            f3 = 0.0f;
        } else {
            f3 = f2;
            f4 = f8;
        }
        float f9 = widgetFrame3.visibility == 4 ? 0.0f : f4;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            i5 = i11;
            f5 = f;
        } else {
            Transition.KeyPosition findPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i10);
            i5 = i11;
            Transition.KeyPosition findNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i10);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i5 = (int) (findPreviousPosition.x * i);
                i7 = i2;
                i12 = (int) (findPreviousPosition.y * i7);
                i8 = findPreviousPosition.frame;
                i6 = i;
            } else {
                i6 = i;
                i7 = i2;
                i8 = 0;
            }
            if (findNextPosition != null) {
                i13 = (int) (findNextPosition.x * i6);
                i14 = (int) (findNextPosition.y * i7);
                i9 = findNextPosition.frame;
            } else {
                i9 = 100;
            }
            f5 = (f6 - i8) / (i9 - i8);
        }
        widgetFrame.widget = widgetFrame2.widget;
        int i19 = (int) (i5 + ((i13 - r9) * f5));
        widgetFrame.left = i19;
        int i20 = (int) (i12 + (f5 * (i14 - i12)));
        widgetFrame.top = i20;
        float f10 = 1.0f - f;
        widgetFrame.right = i19 + ((int) ((i3 * f10) + (i17 * f)));
        widgetFrame.bottom = i20 + ((int) ((f10 * i4) + (i18 * f)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f);
        widgetFrame.alpha = interpolate(f3, f9, 1.0f, f);
        Set<String> keySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : keySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i21 = 0; i21 < numberOfInterpolatedValues; i21++) {
                        fArr[i21] = interpolate(fArr[i21], fArr2[i21], 0.0f, f);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, TypedValues$Custom.TYPE_COLOR, i);
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, TypedValues$Custom.TYPE_FLOAT, f);
    }

    public float centerX() {
        return this.left + ((this.right - r0) / 2.0f);
    }

    public float centerY() {
        return this.top + ((this.bottom - r0) / 2.0f);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        return constraintWidget == null ? EnvironmentCompat.MEDIA_UNKNOWN : constraintWidget.stringId;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha)) {
            return OLD_SYSTEM;
        }
        return false;
    }

    void logv(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % WVURLRuleConstants.LOGIN);
        if (this.widget != null) {
            str2 = str3 + WVNativeCallbackUtil.SEPERATER + (this.widget.hashCode() % WVURLRuleConstants.LOGIN);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + " " + str);
    }

    void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i = 0; i < size; i++) {
            CLKey cLKey = cLObject.get(i);
            cLKey.content();
            CLElement value = cLKey.getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(cLKey.content(), TypedValues$Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(cLKey.content(), TypedValues$Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(cLKey.content(), TypedValues$Custom.TYPE_STRING, content);
            }
        }
    }

    void printCustomAttributes() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % WVURLRuleConstants.LOGIN);
        String str2 = this.widget != null ? str + WVNativeCallbackUtil.SEPERATER + (this.widget.hashCode() % WVURLRuleConstants.LOGIN) + " " : str + "/NULL ";
        HashMap<String, CustomVariable> hashMap = this.mCustom;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                System.out.println(str2 + this.mCustom.get(str3).toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i, float f) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        str.hashCode();
        switch (str) {
            case "phone_orientation":
                phone_orientation = cLElement.getFloat();
                return OLD_SYSTEM;
            case "bottom":
                this.bottom = cLElement.getInt();
                return OLD_SYSTEM;
            case "custom":
                parseCustom(cLElement);
                return OLD_SYSTEM;
            case "rotationX":
                this.rotationX = cLElement.getFloat();
                return OLD_SYSTEM;
            case "rotationY":
                this.rotationY = cLElement.getFloat();
                return OLD_SYSTEM;
            case "rotationZ":
                this.rotationZ = cLElement.getFloat();
                return OLD_SYSTEM;
            case "translationX":
                this.translationX = cLElement.getFloat();
                return OLD_SYSTEM;
            case "translationY":
                this.translationY = cLElement.getFloat();
                return OLD_SYSTEM;
            case "translationZ":
                this.translationZ = cLElement.getFloat();
                return OLD_SYSTEM;
            case "pivotX":
                this.pivotX = cLElement.getFloat();
                return OLD_SYSTEM;
            case "pivotY":
                this.pivotY = cLElement.getFloat();
                return OLD_SYSTEM;
            case "scaleX":
                this.scaleX = cLElement.getFloat();
                return OLD_SYSTEM;
            case "scaleY":
                this.scaleY = cLElement.getFloat();
                return OLD_SYSTEM;
            case "top":
                this.top = cLElement.getInt();
                return OLD_SYSTEM;
            case "left":
                this.left = cLElement.getInt();
                return OLD_SYSTEM;
            case "alpha":
                this.alpha = cLElement.getFloat();
                return OLD_SYSTEM;
            case "right":
                this.right = cLElement.getInt();
                return OLD_SYSTEM;
            case "interpolatedPos":
                this.interpolatedPos = cLElement.getFloat();
                return OLD_SYSTEM;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, MotionKey.ROTATION_X, this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, MotionKey.ROTATION, this.rotationZ);
        add(sb, MotionKey.TRANSLATION_X, this.translationX);
        add(sb, MotionKey.TRANSLATION_Y, this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, MotionKey.SCALE_X, this.scaleX);
        add(sb, MotionKey.SCALE_Y, this.scaleY);
        add(sb, MotionKey.ALPHA, this.alpha);
        add(sb, MotionKey.VISIBILITY, this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case TypedValues$Custom.TYPE_INT /* 900 */:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues$Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues$Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues$Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues$Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues$Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i, int i2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, i2));
        }
    }

    private static void add(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, z));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    private static float interpolate(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return f + (f4 * (f2 - f));
    }
}
