package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    public String mIdString;
    private boolean mValidate;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static SparseIntArray mapToConstant = new SparseIntArray();
    private static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    /* compiled from: Taobao */
    public static class Constraint {
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
            this.mViewId = i;
            Layout layout = this.layout;
            layout.leftToLeft = constraintLayout$LayoutParams.leftToLeft;
            layout.leftToRight = constraintLayout$LayoutParams.leftToRight;
            layout.rightToLeft = constraintLayout$LayoutParams.rightToLeft;
            layout.rightToRight = constraintLayout$LayoutParams.rightToRight;
            layout.topToTop = constraintLayout$LayoutParams.topToTop;
            layout.topToBottom = constraintLayout$LayoutParams.topToBottom;
            layout.bottomToTop = constraintLayout$LayoutParams.bottomToTop;
            layout.bottomToBottom = constraintLayout$LayoutParams.bottomToBottom;
            layout.baselineToBaseline = constraintLayout$LayoutParams.baselineToBaseline;
            layout.baselineToTop = constraintLayout$LayoutParams.baselineToTop;
            layout.baselineToBottom = constraintLayout$LayoutParams.baselineToBottom;
            layout.startToEnd = constraintLayout$LayoutParams.startToEnd;
            layout.startToStart = constraintLayout$LayoutParams.startToStart;
            layout.endToStart = constraintLayout$LayoutParams.endToStart;
            layout.endToEnd = constraintLayout$LayoutParams.endToEnd;
            layout.horizontalBias = constraintLayout$LayoutParams.horizontalBias;
            layout.verticalBias = constraintLayout$LayoutParams.verticalBias;
            layout.dimensionRatio = constraintLayout$LayoutParams.dimensionRatio;
            layout.circleConstraint = constraintLayout$LayoutParams.circleConstraint;
            layout.circleRadius = constraintLayout$LayoutParams.circleRadius;
            layout.circleAngle = constraintLayout$LayoutParams.circleAngle;
            layout.editorAbsoluteX = constraintLayout$LayoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = constraintLayout$LayoutParams.editorAbsoluteY;
            layout.orientation = constraintLayout$LayoutParams.orientation;
            layout.guidePercent = constraintLayout$LayoutParams.guidePercent;
            layout.guideBegin = constraintLayout$LayoutParams.guideBegin;
            layout.guideEnd = constraintLayout$LayoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).bottomMargin;
            layout.baselineMargin = constraintLayout$LayoutParams.baselineMargin;
            layout.verticalWeight = constraintLayout$LayoutParams.verticalWeight;
            layout.horizontalWeight = constraintLayout$LayoutParams.horizontalWeight;
            layout.verticalChainStyle = constraintLayout$LayoutParams.verticalChainStyle;
            layout.horizontalChainStyle = constraintLayout$LayoutParams.horizontalChainStyle;
            layout.constrainedWidth = constraintLayout$LayoutParams.constrainedWidth;
            layout.constrainedHeight = constraintLayout$LayoutParams.constrainedHeight;
            layout.widthDefault = constraintLayout$LayoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = constraintLayout$LayoutParams.matchConstraintDefaultHeight;
            layout.widthMax = constraintLayout$LayoutParams.matchConstraintMaxWidth;
            layout.heightMax = constraintLayout$LayoutParams.matchConstraintMaxHeight;
            layout.widthMin = constraintLayout$LayoutParams.matchConstraintMinWidth;
            layout.heightMin = constraintLayout$LayoutParams.matchConstraintMinHeight;
            layout.widthPercent = constraintLayout$LayoutParams.matchConstraintPercentWidth;
            layout.heightPercent = constraintLayout$LayoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = constraintLayout$LayoutParams.constraintTag;
            layout.goneTopMargin = constraintLayout$LayoutParams.goneTopMargin;
            layout.goneBottomMargin = constraintLayout$LayoutParams.goneBottomMargin;
            layout.goneLeftMargin = constraintLayout$LayoutParams.goneLeftMargin;
            layout.goneRightMargin = constraintLayout$LayoutParams.goneRightMargin;
            layout.goneStartMargin = constraintLayout$LayoutParams.goneStartMargin;
            layout.goneEndMargin = constraintLayout$LayoutParams.goneEndMargin;
            layout.goneBaselineMargin = constraintLayout$LayoutParams.goneBaselineMargin;
            layout.mWrapBehavior = constraintLayout$LayoutParams.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT >= 17) {
                layout.endMargin = constraintLayout$LayoutParams.getMarginEnd();
                this.layout.startMargin = constraintLayout$LayoutParams.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String str, int i) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String str, float f) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String str, int i) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyDelta(Constraint constraint) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.applyDelta(constraint);
            }
        }

        public void applyTo(ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
            Layout layout = this.layout;
            constraintLayout$LayoutParams.leftToLeft = layout.leftToLeft;
            constraintLayout$LayoutParams.leftToRight = layout.leftToRight;
            constraintLayout$LayoutParams.rightToLeft = layout.rightToLeft;
            constraintLayout$LayoutParams.rightToRight = layout.rightToRight;
            constraintLayout$LayoutParams.topToTop = layout.topToTop;
            constraintLayout$LayoutParams.topToBottom = layout.topToBottom;
            constraintLayout$LayoutParams.bottomToTop = layout.bottomToTop;
            constraintLayout$LayoutParams.bottomToBottom = layout.bottomToBottom;
            constraintLayout$LayoutParams.baselineToBaseline = layout.baselineToBaseline;
            constraintLayout$LayoutParams.baselineToTop = layout.baselineToTop;
            constraintLayout$LayoutParams.baselineToBottom = layout.baselineToBottom;
            constraintLayout$LayoutParams.startToEnd = layout.startToEnd;
            constraintLayout$LayoutParams.startToStart = layout.startToStart;
            constraintLayout$LayoutParams.endToStart = layout.endToStart;
            constraintLayout$LayoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).bottomMargin = layout.bottomMargin;
            constraintLayout$LayoutParams.goneStartMargin = layout.goneStartMargin;
            constraintLayout$LayoutParams.goneEndMargin = layout.goneEndMargin;
            constraintLayout$LayoutParams.goneTopMargin = layout.goneTopMargin;
            constraintLayout$LayoutParams.goneBottomMargin = layout.goneBottomMargin;
            constraintLayout$LayoutParams.horizontalBias = layout.horizontalBias;
            constraintLayout$LayoutParams.verticalBias = layout.verticalBias;
            constraintLayout$LayoutParams.circleConstraint = layout.circleConstraint;
            constraintLayout$LayoutParams.circleRadius = layout.circleRadius;
            constraintLayout$LayoutParams.circleAngle = layout.circleAngle;
            constraintLayout$LayoutParams.dimensionRatio = layout.dimensionRatio;
            constraintLayout$LayoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            constraintLayout$LayoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            constraintLayout$LayoutParams.verticalWeight = layout.verticalWeight;
            constraintLayout$LayoutParams.horizontalWeight = layout.horizontalWeight;
            constraintLayout$LayoutParams.verticalChainStyle = layout.verticalChainStyle;
            constraintLayout$LayoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            constraintLayout$LayoutParams.constrainedWidth = layout.constrainedWidth;
            constraintLayout$LayoutParams.constrainedHeight = layout.constrainedHeight;
            constraintLayout$LayoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            constraintLayout$LayoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            constraintLayout$LayoutParams.matchConstraintMaxWidth = layout.widthMax;
            constraintLayout$LayoutParams.matchConstraintMaxHeight = layout.heightMax;
            constraintLayout$LayoutParams.matchConstraintMinWidth = layout.widthMin;
            constraintLayout$LayoutParams.matchConstraintMinHeight = layout.heightMin;
            constraintLayout$LayoutParams.matchConstraintPercentWidth = layout.widthPercent;
            constraintLayout$LayoutParams.matchConstraintPercentHeight = layout.heightPercent;
            constraintLayout$LayoutParams.orientation = layout.orientation;
            constraintLayout$LayoutParams.guidePercent = layout.guidePercent;
            constraintLayout$LayoutParams.guideBegin = layout.guideBegin;
            constraintLayout$LayoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                constraintLayout$LayoutParams.constraintTag = str;
            }
            constraintLayout$LayoutParams.wrapBehaviorInParent = layout.mWrapBehavior;
            if (Build.VERSION.SDK_INT >= 17) {
                constraintLayout$LayoutParams.setMarginStart(layout.startMargin);
                constraintLayout$LayoutParams.setMarginEnd(this.layout.endMargin);
            }
            constraintLayout$LayoutParams.validate();
        }

        public void printDelta(String str) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.printDelta(str);
            } else {
                Log.v(str, "DELTA IS NULL");
            }
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Constraint m2318clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }

        /* compiled from: Taobao */
        static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            int[] mTypeInt = new int[10];
            int[] mValueInt = new int[10];
            int mCountInt = 0;
            int[] mTypeFloat = new int[10];
            float[] mValueFloat = new float[10];
            int mCountFloat = 0;
            int[] mTypeString = new int[5];
            String[] mValueString = new String[5];
            int mCountString = 0;
            int[] mTypeBoolean = new int[4];
            boolean[] mValueBoolean = new boolean[4];
            int mCountBoolean = 0;

            Delta() {
            }

            void add(int i, int i2) {
                int i3 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i3 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i4 = this.mCountInt;
                iArr3[i4] = i;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i4 + 1;
                iArr4[i4] = i2;
            }

            void applyDelta(Constraint constraint) {
                for (int i = 0; i < this.mCountInt; i++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeInt[i], this.mValueInt[i]);
                }
                for (int i2 = 0; i2 < this.mCountFloat; i2++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeFloat[i2], this.mValueFloat[i2]);
                }
                for (int i3 = 0; i3 < this.mCountString; i3++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeString[i3], this.mValueString[i3]);
                }
                for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeBoolean[i4], this.mValueBoolean[i4]);
                }
            }

            @SuppressLint({"LogConditional"})
            void printDelta(String str) {
                Log.v(str, "int");
                for (int i = 0; i < this.mCountInt; i++) {
                    Log.v(str, this.mTypeInt[i] + " = " + this.mValueInt[i]);
                }
                Log.v(str, TypedValues$Custom.S_FLOAT);
                for (int i2 = 0; i2 < this.mCountFloat; i2++) {
                    Log.v(str, this.mTypeFloat[i2] + " = " + this.mValueFloat[i2]);
                }
                Log.v(str, "strings");
                for (int i3 = 0; i3 < this.mCountString; i3++) {
                    Log.v(str, this.mTypeString[i3] + " = " + this.mValueString[i3]);
                }
                Log.v(str, TypedValues$Custom.S_BOOLEAN);
                for (int i4 = 0; i4 < this.mCountBoolean; i4++) {
                    Log.v(str, this.mTypeBoolean[i4] + " = " + this.mValueBoolean[i4]);
                }
            }

            void add(int i, float f) {
                int i2 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i2 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i3 = this.mCountFloat;
                iArr2[i3] = i;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i3 + 1;
                fArr2[i3] = f;
            }

            void add(int i, String str) {
                int i2 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i2 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i3 = this.mCountString;
                iArr2[i3] = i;
                String[] strArr2 = this.mValueString;
                this.mCountString = i3 + 1;
                strArr2[i3] = str;
            }

            void add(int i, boolean z) {
                int i2 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i2 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i3 = this.mCountBoolean;
                iArr2[i3] = i;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i3 + 1;
                zArr2[i3] = z;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i, Constraints.LayoutParams layoutParams) {
            fillFrom(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }
    }

    /* compiled from: Taobao */
    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.mQuantizeInterpolatorString = string;
                            if (string.indexOf(WVNativeCallbackUtil.SEPERATER) > 0) {
                                this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -1;
                                break;
                            }
                        } else {
                            this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: Taobao */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: Taobao */
    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.applyElevation = true;
                            this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: Taobao */
    class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        Context context;
        int flags;
        ConstraintLayout layout;
        Writer writer;
        int unknownCount = 0;
        final String LEFT = "'left'";
        final String RIGHT = "'right'";
        final String BASELINE = "'baseline'";
        final String BOTTOM = "'bottom'";
        final String TOP = "'top'";
        final String START = "'start'";
        final String END = "'end'";
        HashMap<Integer, String> idMap = new HashMap<>();

        WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
            this.writer = writer;
            this.layout = constraintLayout;
            this.context = constraintLayout.getContext();
            this.flags = i;
        }

        private void writeBaseDimension(String str, int i, int i2) throws IOException {
            if (i != i2) {
                if (i == -2) {
                    this.writer.write(SPACE + str + "=\"wrap_content\"");
                    return;
                }
                if (i == -1) {
                    this.writer.write(SPACE + str + "=\"match_parent\"");
                    return;
                }
                this.writer.write(SPACE + str + "=\"" + i + "dp\"");
            }
        }

        private void writeBoolen(String str, boolean z, boolean z2) throws IOException {
            if (z != z2) {
                this.writer.write(SPACE + str + "=\"" + z + "dp\"");
            }
        }

        private void writeDimension(String str, int i, int i2) throws IOException {
            if (i != i2) {
                this.writer.write(SPACE + str + "=\"" + i + "dp\"");
            }
        }

        private void writeEnum(String str, int i, String[] strArr, int i2) throws IOException {
            if (i != i2) {
                this.writer.write(SPACE + str + "=\"" + strArr[i] + "\"");
            }
        }

        String getName(int i) {
            if (this.idMap.containsKey(Integer.valueOf(i))) {
                return "@+id/" + this.idMap.get(Integer.valueOf(i)) + "";
            }
            if (i == 0) {
                return ConstraintSet.KEY_PERCENT_PARENT;
            }
            String lookup = lookup(i);
            this.idMap.put(Integer.valueOf(i), lookup);
            return "@+id/" + lookup + "";
        }

        String lookup(int i) {
            try {
                if (i != -1) {
                    return this.context.getResources().getResourceEntryName(i);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(EnvironmentCompat.MEDIA_UNKNOWN);
                int i2 = this.unknownCount + 1;
                this.unknownCount = i2;
                sb.append(i2);
                return sb.toString();
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EnvironmentCompat.MEDIA_UNKNOWN);
                int i3 = this.unknownCount + 1;
                this.unknownCount = i3;
                sb2.append(i3);
                return sb2.toString();
            }
        }

        void writeCircle(int i, float f, int i2) throws IOException {
            if (i == -1) {
                return;
            }
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(i));
            this.writer.write(", " + f);
            this.writer.write(i2 + "]");
        }

        void writeConstraint(String str, int i, String str2, int i2, int i3) throws IOException {
            if (i == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":[");
            this.writer.write(getName(i));
            this.writer.write(" , ");
            this.writer.write(str2);
            if (i2 != 0) {
                this.writer.write(" , " + i2);
            }
            this.writer.write("],\n");
        }

        void writeLayout() throws IOException {
            this.writer.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                Constraint constraint = (Constraint) ConstraintSet.this.mConstraints.get(num);
                String name = getName(num.intValue());
                this.writer.write("  <Constraint");
                this.writer.write("\n       android:id=\"" + name + "\"");
                Layout layout = constraint.layout;
                writeBaseDimension("android:layout_width", layout.mWidth, -5);
                writeBaseDimension("android:layout_height", layout.mHeight, -5);
                writeVariable("app:layout_constraintGuide_begin", (float) layout.guideBegin, -1.0f);
                writeVariable("app:layout_constraintGuide_end", layout.guideEnd, -1.0f);
                writeVariable("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                writeVariable("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                writeVariable("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                writeVariable("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                writeXmlConstraint("app:layout_constraintCircle", layout.circleConstraint);
                writeVariable("app:layout_constraintCircleRadius", layout.circleRadius, 0.0f);
                writeVariable("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                writeVariable("android:orientation", layout.orientation, -1.0f);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle, 0.0f);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle, 0.0f);
                writeVariable("app:barrierDirection", layout.mBarrierDirection, -1.0f);
                writeVariable("app:barrierMargin", layout.mBarrierMargin, 0.0f);
                writeDimension("app:layout_marginLeft", layout.leftMargin, 0);
                writeDimension("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginRight", layout.rightMargin, 0);
                writeDimension("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginStart", layout.startMargin, 0);
                writeDimension("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginEnd", layout.endMargin, 0);
                writeDimension("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginTop", layout.topMargin, 0);
                writeDimension("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginBottom", layout.bottomMargin, 0);
                writeDimension("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                writeDimension("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                writeDimension("app:baselineMargin", layout.baselineMargin, 0);
                writeBoolen("app:layout_constrainedWidth", layout.constrainedWidth, false);
                writeBoolen("app:layout_constrainedHeight", layout.constrainedHeight, false);
                writeBoolen("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("app:layout_wrapBehaviorInParent", layout.mWrapBehavior, 0.0f);
                writeXmlConstraint("app:baselineToBaseline", layout.baselineToBaseline);
                writeXmlConstraint("app:baselineToBottom", layout.baselineToBottom);
                writeXmlConstraint("app:baselineToTop", layout.baselineToTop);
                writeXmlConstraint("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                writeXmlConstraint("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                writeXmlConstraint("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                writeXmlConstraint("app:layout_constraintEnd_toStartOf", layout.endToStart);
                writeXmlConstraint("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                writeXmlConstraint("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                writeXmlConstraint("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                writeXmlConstraint("app:layout_constraintRight_toRightOf", layout.rightToRight);
                writeXmlConstraint("app:layout_constraintStart_toEndOf", layout.startToEnd);
                writeXmlConstraint("app:layout_constraintStart_toStartOf", layout.startToStart);
                writeXmlConstraint("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                writeXmlConstraint("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                writeEnum("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                writeVariable("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                writeDimension("app:layout_constraintHeight_min", layout.heightMin, 0);
                writeDimension("app:layout_constraintHeight_max", layout.heightMax, 0);
                writeBoolen("android:layout_constrainedHeight", layout.constrainedHeight, false);
                writeEnum("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                writeVariable("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                writeDimension("app:layout_constraintWidth_min", layout.widthMin, 0);
                writeDimension("app:layout_constraintWidth_max", layout.widthMax, 0);
                writeBoolen("android:layout_constrainedWidth", layout.constrainedWidth, false);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                writeEnum("app:barrierDirection", layout.mBarrierDirection, new String[]{"left", "right", "top", "bottom", "start", "end"}, -1);
                writeVariable("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.writer.write(" />\n");
            }
            this.writer.write("</ConstraintSet>\n");
        }

        void writeVariable(String str, int i) throws IOException {
            if (i == 0 || i == -1) {
                return;
            }
            this.writer.write(SPACE + str + "=\"" + i + "\"\n");
        }

        void writeXmlConstraint(String str, int i) throws IOException {
            if (i == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + getName(i) + "\"");
        }

        void writeVariable(String str, float f, float f2) throws IOException {
            if (f == f2) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + f + "\"");
        }

        void writeVariable(String str, String str2, String str3) throws IOException {
            if (str2 == null || str2.equals(str3)) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + str2 + "\"");
        }

        void writeVariable(String str, int[] iArr) throws IOException {
            if (iArr == null) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":");
            int i = 0;
            while (i < iArr.length) {
                Writer writer = this.writer;
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "[" : ", ");
                sb.append(getName(iArr[i]));
                writer.write(sb.toString());
                i++;
            }
            this.writer.write("],\n");
        }

        void writeVariable(String str, String str2) throws IOException {
            if (str2 == null) {
                return;
            }
            this.writer.write(str);
            this.writer.write(":");
            this.writer.write(", " + str2);
            this.writer.write("\n");
        }
    }

    static {
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = overrideMapToConstant;
        int i = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i, 6);
        overrideMapToConstant.append(i, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (this.mSavedAttributes.containsKey(strArr[i])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i]);
                if (constraintAttribute != null && constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i], new ConstraintAttribute(strArr[i], attributeType));
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        populateOverride(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] convertReferenceString(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = view.getParent().getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        populateConstraint(context, constraint, obtainStyledAttributes, z);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i));
    }

    static String getDebugName(int i) {
        for (Field field : ConstraintSet.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt(null) == i) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return "UNKNOWN";
    }

    static String getLine(Context context, int i, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    static void parseDimensionConstraints(Object obj, TypedArray typedArray, int i, int i2) {
        if (obj == null) {
            return;
        }
        int i3 = typedArray.peekValue(i).type;
        if (i3 == 3) {
            parseDimensionConstraintsString(obj, typedArray.getString(i), i2);
            return;
        }
        int i4 = -2;
        boolean z = false;
        if (i3 != 5) {
            int i5 = typedArray.getInt(i, 0);
            if (i5 != -4) {
                i4 = (i5 == -3 || !(i5 == -2 || i5 == -1)) ? 0 : i5;
            } else {
                z = true;
            }
        } else {
            i4 = typedArray.getDimensionPixelSize(i, 0);
        }
        if (obj instanceof ConstraintLayout$LayoutParams) {
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) obj;
            if (i2 == 0) {
                ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).width = i4;
                constraintLayout$LayoutParams.constrainedWidth = z;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).height = i4;
                constraintLayout$LayoutParams.constrainedHeight = z;
                return;
            }
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            if (i2 == 0) {
                layout.mWidth = i4;
                layout.constrainedWidth = z;
                return;
            } else {
                layout.mHeight = i4;
                layout.constrainedHeight = z;
                return;
            }
        }
        if (obj instanceof Constraint.Delta) {
            Constraint.Delta delta = (Constraint.Delta) obj;
            if (i2 == 0) {
                delta.add(23, i4);
                delta.add(80, z);
            } else {
                delta.add(21, i4);
                delta.add(81, z);
            }
        }
    }

    static void parseDimensionConstraintsString(Object obj, String str, int i) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if (KEY_RATIO.equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout$LayoutParams) {
                    ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) obj;
                    if (i == 0) {
                        ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams).height = 0;
                    }
                    parseDimensionRatioString(constraintLayout$LayoutParams, trim2);
                    return;
                }
                if (obj instanceof Layout) {
                    ((Layout) obj).dimensionRatio = trim2;
                    return;
                } else {
                    if (obj instanceof Constraint.Delta) {
                        ((Constraint.Delta) obj).add(5, trim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if (KEY_WEIGHT.equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout$LayoutParams) {
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = (ConstraintLayout$LayoutParams) obj;
                        if (i == 0) {
                            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams2).width = 0;
                            constraintLayout$LayoutParams2.horizontalWeight = parseFloat;
                        } else {
                            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams2).height = 0;
                            constraintLayout$LayoutParams2.verticalWeight = parseFloat;
                        }
                    } else if (obj instanceof Layout) {
                        Layout layout = (Layout) obj;
                        if (i == 0) {
                            layout.mWidth = 0;
                            layout.horizontalWeight = parseFloat;
                        } else {
                            layout.mHeight = 0;
                            layout.verticalWeight = parseFloat;
                        }
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta.add(23, 0);
                            delta.add(39, parseFloat);
                        } else {
                            delta.add(21, 0);
                            delta.add(40, parseFloat);
                        }
                    }
                } else {
                    if (!KEY_PERCENT_PARENT.equalsIgnoreCase(trim)) {
                        return;
                    }
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout$LayoutParams) {
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams3 = (ConstraintLayout$LayoutParams) obj;
                        if (i == 0) {
                            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams3).width = 0;
                            constraintLayout$LayoutParams3.matchConstraintPercentWidth = max;
                            constraintLayout$LayoutParams3.matchConstraintDefaultWidth = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams3).height = 0;
                            constraintLayout$LayoutParams3.matchConstraintPercentHeight = max;
                            constraintLayout$LayoutParams3.matchConstraintDefaultHeight = 2;
                        }
                    } else if (obj instanceof Layout) {
                        Layout layout2 = (Layout) obj;
                        if (i == 0) {
                            layout2.mWidth = 0;
                            layout2.widthPercent = max;
                            layout2.widthDefault = 2;
                        } else {
                            layout2.mHeight = 0;
                            layout2.heightPercent = max;
                            layout2.heightDefault = 2;
                        }
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta2.add(23, 0);
                            delta2.add(54, 2);
                        } else {
                            delta2.add(21, 0);
                            delta2.add(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void parseDimensionRatioString(ConstraintLayout$LayoutParams constraintLayout$LayoutParams, String str) {
        float f = Float.NaN;
        int i = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i2 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i = 1;
                }
                i2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i2);
                    if (substring2.length() > 0) {
                        f = Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        constraintLayout$LayoutParams.dimensionRatio = str;
        constraintLayout$LayoutParams.dimensionRatioValue = f;
        constraintLayout$LayoutParams.dimensionRatioSide = i;
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray, boolean z) {
        if (z) {
            populateOverride(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        Layout layout7 = constraint.layout;
                        layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        Layout layout29 = constraint.layout;
                        layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        Transform transform = constraint.transform;
                        transform.applyElevation = true;
                        transform.elevation = typedArray.getDimension(index, transform.elevation);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        Transform transform10 = constraint.transform;
                        transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Motion motion5 = constraint.motion;
                    motion5.mAnimateCircleAngleTo = typedArray.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case 83:
                    Transform transform12 = constraint.transform;
                    transform12.transformPivotTarget = lookupID(typedArray, index, transform12.transformPivotTarget);
                    break;
                case 84:
                    Motion motion6 = constraint.motion;
                    motion6.mQuantizeMotionSteps = typedArray.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case 85:
                    Motion motion7 = constraint.motion;
                    motion7.mQuantizeMotionPhase = typedArray.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case 86:
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        Motion motion8 = constraint.motion;
                        if (motion8.mQuantizeInterpolatorID != -1) {
                            motion8.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                        if (constraint.motion.mQuantizeInterpolatorString.indexOf(WVNativeCallbackUtil.SEPERATER) > 0) {
                            constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -1;
                            break;
                        }
                    } else {
                        Motion motion9 = constraint.motion;
                        motion9.mQuantizeInterpolatorType = typedArray.getInteger(index, motion9.mQuantizeInterpolatorID);
                        break;
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.layout;
                    layout54.baselineToTop = lookupID(typedArray, index, layout54.baselineToTop);
                    break;
                case 92:
                    Layout layout55 = constraint.layout;
                    layout55.baselineToBottom = lookupID(typedArray, index, layout55.baselineToBottom);
                    break;
                case 93:
                    Layout layout56 = constraint.layout;
                    layout56.baselineMargin = typedArray.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case 94:
                    Layout layout57 = constraint.layout;
                    layout57.goneBaselineMargin = typedArray.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case 95:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.layout;
                    layout58.mWrapBehavior = typedArray.getInt(index, layout58.mWrapBehavior);
                    break;
            }
        }
        Layout layout59 = constraint.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private static void populateOverride(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.mDelta = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 5:
                    delta.add(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.add(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.add(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    delta.add(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.add(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.add(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                        break;
                    } else {
                        break;
                    }
                case 34:
                    delta.add(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.mViewId);
                    constraint.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.add(44, true);
                        delta.add(44, typedArray.getDimension(index, constraint.transform.elevation));
                        break;
                    } else {
                        break;
                    }
                case 45:
                    delta.add(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.add(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.add(53, typedArray.getDimension(index, constraint.transform.translationZ));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    delta.add(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    delta.add(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    delta.add(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    delta.add(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    delta.add(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    delta.add(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    delta.add(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    delta.add(64, lookupID(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.add(65, typedArray.getString(index));
                        break;
                    } else {
                        delta.add(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    delta.add(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    delta.add(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    delta.add(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.add(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.add(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.add(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.add(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.add(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.add(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.add(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.add(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    delta.add(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    delta.add(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    delta.add(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.add(83, lookupID(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.add(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.add(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion = constraint.motion;
                        if (motion.mQuantizeInterpolatorID != -1) {
                            motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                        delta.add(90, constraint.motion.mQuantizeInterpolatorString);
                        if (constraint.motion.mQuantizeInterpolatorString.indexOf(WVNativeCallbackUtil.SEPERATER) > 0) {
                            constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                            delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -1;
                            delta.add(88, -1);
                            break;
                        }
                    } else {
                        Motion motion2 = constraint.motion;
                        motion2.mQuantizeInterpolatorType = typedArray.getInteger(index, motion2.mQuantizeInterpolatorID);
                        delta.add(88, constraint.motion.mQuantizeInterpolatorType);
                        break;
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 93:
                    delta.add(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    delta.add(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    parseDimensionConstraints(delta, typedArray, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.add(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, constraint.mViewId);
                        constraint.mViewId = resourceId2;
                        if (resourceId2 == -1) {
                            constraint.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.mTargetString = typedArray.getString(index);
                        break;
                    } else {
                        constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                        break;
                    }
                case 99:
                    delta.add(99, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i, float f) {
        if (i == 19) {
            constraint.layout.guidePercent = f;
        }
        if (i == 20) {
            constraint.layout.horizontalBias = f;
            return;
        }
        if (i == 37) {
            constraint.layout.verticalBias = f;
            return;
        }
        if (i == 60) {
            constraint.transform.rotation = f;
            return;
        }
        if (i == 63) {
            constraint.layout.circleAngle = f;
            return;
        }
        if (i == 79) {
            constraint.motion.mMotionStagger = f;
            return;
        }
        if (i == 85) {
            constraint.motion.mQuantizeMotionPhase = f;
            return;
        }
        if (i != 87) {
            if (i == 39) {
                constraint.layout.horizontalWeight = f;
                return;
            }
            if (i == 40) {
                constraint.layout.verticalWeight = f;
                return;
            }
            switch (i) {
                case 43:
                    constraint.propertySet.alpha = f;
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.elevation = f;
                    transform.applyElevation = true;
                    break;
                case 45:
                    constraint.transform.rotationX = f;
                    break;
                case 46:
                    constraint.transform.rotationY = f;
                    break;
                case 47:
                    constraint.transform.scaleX = f;
                    break;
                case 48:
                    constraint.transform.scaleY = f;
                    break;
                case 49:
                    constraint.transform.transformPivotX = f;
                    break;
                case 50:
                    constraint.transform.transformPivotY = f;
                    break;
                case 51:
                    constraint.transform.translationX = f;
                    break;
                case 52:
                    constraint.transform.translationY = f;
                    break;
                case 53:
                    constraint.transform.translationZ = f;
                    break;
                default:
                    switch (i) {
                        case 67:
                            constraint.motion.mPathRotate = f;
                            break;
                        case 68:
                            constraint.propertySet.mProgress = f;
                            break;
                        case 69:
                            constraint.layout.widthPercent = f;
                            break;
                        case 70:
                            constraint.layout.heightPercent = f;
                            break;
                        default:
                            Log.w(TAG, "Unknown attribute 0x");
                            break;
                    }
            }
        }
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == ',' && !z) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (charArray[i2] == '\"') {
                z = !z;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.mConstraints.values()) {
            if (constraint.mDelta != null) {
                if (constraint.mTargetString != null) {
                    Iterator<Integer> it = this.mConstraints.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraint2 = getConstraint(it.next().intValue());
                        String str = constraint2.layout.mConstraintTag;
                        if (str != null && constraint.mTargetString.matches(str)) {
                            constraint.mDelta.applyDelta(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                } else {
                    constraint.mDelta.applyDelta(getConstraint(constraint.mViewId));
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout$LayoutParams constraintLayout$LayoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, constraintLayout$LayoutParams, sparseArray);
        }
    }

    void applyToInternal(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
                            constraintLayout$LayoutParams.validate();
                            constraint.applyTo(constraintLayout$LayoutParams);
                            if (z) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(constraintLayout$LayoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 17) {
                                childAt.setAlpha(constraint.propertySet.alpha);
                                childAt.setRotation(constraint.transform.rotation);
                                childAt.setRotationX(constraint.transform.rotationX);
                                childAt.setRotationY(constraint.transform.rotationY);
                                childAt.setScaleX(constraint.transform.scaleX);
                                childAt.setScaleY(constraint.transform.scaleY);
                                Transform transform = constraint.transform;
                                if (transform.transformPivotTarget != -1) {
                                    if (((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget) != null) {
                                        float top = (r6.getTop() + r6.getBottom()) / 2.0f;
                                        float left = (r6.getLeft() + r6.getRight()) / 2.0f;
                                        if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                            childAt.setPivotX(left - childAt.getLeft());
                                            childAt.setPivotY(top - childAt.getTop());
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(transform.transformPivotX)) {
                                        childAt.setPivotX(constraint.transform.transformPivotX);
                                    }
                                    if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                        childAt.setPivotY(constraint.transform.transformPivotY);
                                    }
                                }
                                childAt.setTranslationX(constraint.transform.translationX);
                                childAt.setTranslationY(constraint.transform.translationY);
                                if (i2 >= 21) {
                                    childAt.setTranslationZ(constraint.transform.translationZ);
                                    Transform transform2 = constraint.transform;
                                    if (transform2.applyElevation) {
                                        childAt.setElevation(transform2.elevation);
                                    }
                                }
                            }
                        }
                    } else {
                        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout$LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout$LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i)) || (constraint = this.mConstraints.get(Integer.valueOf(i))) == null) {
            return;
        }
        constraint.applyTo(constraintLayout$LayoutParams);
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet((ConstraintSet) null);
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i3 == 1 || i3 == 2) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            if (constraint != null) {
                constraint.layout.horizontalBias = f;
                return;
            }
            return;
        }
        if (i3 == 6 || i3 == 7) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(i));
            if (constraint2 != null) {
                constraint2.layout.horizontalBias = f;
                return;
            }
            return;
        }
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        Constraint constraint3 = this.mConstraints.get(Integer.valueOf(i));
        if (constraint3 != null) {
            constraint3.layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.verticalBias = f;
        }
    }

    public void clear(int i) {
        this.mConstraints.remove(Integer.valueOf(i));
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("Left to " + sideToString(i4) + " undefined");
                    }
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                } else {
                    if (i4 != 4) {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                }
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                } else {
                    if (i4 != 3) {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                }
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i4 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i3;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = i3;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i3;
                    layout12.startToEnd = -1;
                } else {
                    if (i4 != 7) {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = i3;
                    layout13.startToStart = -1;
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i3;
                    layout14.endToStart = -1;
                } else {
                    if (i4 != 6) {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = i3;
                    layout15.endToEnd = -1;
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                throw new IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        Layout layout = get(i).layout;
        layout.circleConstraint = i2;
        layout.circleRadius = i3;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        get(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        get(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        get(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        get(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        get(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        get(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        get(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        get(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        get(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        get(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        get(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        get(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        Layout layout = get(i).layout;
        layout.mIsGuideline = true;
        layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Layout layout = get(i).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i2;
        layout.mBarrierMargin = i3;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.verticalWeight = fArr[0];
        }
        get(iArr[0]).layout.verticalChainStyle = i5;
        connect(iArr[0], 3, i, i2, 0);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            connect(iArr[i6], 3, iArr[i8], 4, 0);
            connect(iArr[i8], 4, iArr[i6], 3, 0);
            if (fArr != null) {
                get(iArr[i6]).layout.verticalWeight = fArr[i6];
            }
        }
        connect(iArr[iArr.length - 1], 4, i3, i4, 0);
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            if (constraint != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                constraint.layout.dump(motionScene, sb);
                sb.append("/>\n");
            }
        }
        System.out.println(sb.toString());
    }

    public boolean getApplyElevation(int i) {
        return get(i).transform.applyElevation;
    }

    public Constraint getConstraint(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            return this.mConstraints.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i) {
        return get(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i) {
        return get(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = get(i).layout.mReferenceIds;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i) {
        return get(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return get(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return get(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i]);
            } else {
                constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i]);
            } else {
                constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i]);
            } else {
                constraint.setFloatValue(split2[0], Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] splitString = splitString(str);
        for (int i = 0; i < splitString.length; i++) {
            String[] split = splitString[i].split("=");
            Log.w(TAG, " Unable to parse " + splitString[i]);
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.mConstraints.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i)) || (constraint = this.mConstraints.get(Integer.valueOf(i))) == null) {
            return;
        }
        Layout layout = constraint.layout;
        int i2 = layout.leftToRight;
        int i3 = layout.rightToLeft;
        if (i2 != -1 || i3 != -1) {
            if (i2 == -1 || i3 == -1) {
                int i4 = layout.rightToRight;
                if (i4 != -1) {
                    connect(i2, 2, i4, 2, 0);
                } else {
                    int i5 = layout.leftToLeft;
                    if (i5 != -1) {
                        connect(i3, 1, i5, 1, 0);
                    }
                }
            } else {
                connect(i2, 2, i3, 1, 0);
                connect(i3, 1, i2, 2, 0);
            }
            clear(i, 1);
            clear(i, 2);
            return;
        }
        int i6 = layout.startToEnd;
        int i7 = layout.endToStart;
        if (i6 != -1 || i7 != -1) {
            if (i6 != -1 && i7 != -1) {
                connect(i6, 7, i7, 6, 0);
                connect(i7, 6, i2, 7, 0);
            } else if (i7 != -1) {
                int i8 = layout.rightToRight;
                if (i8 != -1) {
                    connect(i2, 7, i8, 7, 0);
                } else {
                    int i9 = layout.leftToLeft;
                    if (i9 != -1) {
                        connect(i7, 6, i9, 6, 0);
                    }
                }
            }
        }
        clear(i, 6);
        clear(i, 7);
    }

    public void removeFromVerticalChain(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            if (constraint == null) {
                return;
            }
            Layout layout = constraint.layout;
            int i2 = layout.topToBottom;
            int i3 = layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 == -1 || i3 == -1) {
                    int i4 = layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                } else {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        get(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(i).transform.applyElevation = z;
        }
    }

    public void setBarrierType(int i, int i2) {
        get(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        get(i).setColorValue(str, i2);
    }

    public void setDimensionRatio(int i, String str) {
        get(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        get(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        get(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(i).transform.elevation = f;
            get(i).transform.applyElevation = true;
        }
    }

    public void setFloatValue(int i, String str, float f) {
        get(i).setFloatValue(str, f);
    }

    public void setForceId(boolean z) {
        this.mForceId = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.goneLeftMargin = i3;
                return;
            case 2:
                constraint.layout.goneRightMargin = i3;
                return;
            case 3:
                constraint.layout.goneTopMargin = i3;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i3;
                return;
            case 5:
                constraint.layout.goneBaselineMargin = i3;
                return;
            case 6:
                constraint.layout.goneStartMargin = i3;
                return;
            case 7:
                constraint.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        get(i).layout.guideBegin = i2;
        get(i).layout.guideEnd = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        get(i).layout.guideEnd = i2;
        get(i).layout.guideBegin = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        get(i).layout.guidePercent = f;
        get(i).layout.guideEnd = -1;
        get(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        get(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        get(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        get(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, String str, int i2) {
        get(i).setIntValue(str, i2);
    }

    public void setLayoutWrapBehavior(int i, int i2) {
        if (i2 < 0 || i2 > 3) {
            return;
        }
        get(i).layout.mWrapBehavior = i2;
    }

    public void setMargin(int i, int i2, int i3) {
        Constraint constraint = get(i);
        switch (i2) {
            case 1:
                constraint.layout.leftMargin = i3;
                return;
            case 2:
                constraint.layout.rightMargin = i3;
                return;
            case 3:
                constraint.layout.topMargin = i3;
                return;
            case 4:
                constraint.layout.bottomMargin = i3;
                return;
            case 5:
                constraint.layout.baselineMargin = i3;
                return;
            case 6:
                constraint.layout.startMargin = i3;
                return;
            case 7:
                constraint.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        get(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        get(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        get(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        get(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        get(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        get(i).transform.scaleY = f;
    }

    public void setStringValue(int i, String str, String str2) {
        get(i).setStringValue(str, str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        Transform transform = get(i).transform;
        transform.transformPivotY = f2;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        get(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        get(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        Transform transform = get(i).transform;
        transform.translationX = f;
        transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        get(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        get(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(i).transform.translationZ = f;
        }
    }

    public void setValidateOnParse(boolean z) {
        this.mValidate = z;
    }

    public void setVerticalBias(int i, float f) {
        get(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        get(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        get(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        get(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        get(i).propertySet.mVisibilityMode = i2;
    }

    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i).writeLayout();
        } else {
            new WriteJsonEngine(this, writer, constraintLayout, i).writeLayout();
        }
        writer.write("\n---------------------------------------------\n");
    }

    private void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.horizontalWeight = fArr[0];
        }
        get(iArr[0]).layout.horizontalChainStyle = i5;
        connect(iArr[0], i6, i, i2, -1);
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            int i10 = i8 - 1;
            connect(iArr[i8], i6, iArr[i10], i7, -1);
            connect(iArr[i10], i7, iArr[i8], i6, -1);
            if (fArr != null) {
                get(iArr[i8]).layout.horizontalWeight = fArr[i8];
            }
        }
        connect(iArr[iArr.length - 1], i7, i3, i4, -1);
    }

    public void clear(int i, int i2) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i)) || (constraint = this.mConstraints.get(Integer.valueOf(i))) == null) {
            return;
        }
        switch (i2) {
            case 1:
                Layout layout = constraint.layout;
                layout.leftToRight = -1;
                layout.leftToLeft = -1;
                layout.leftMargin = -1;
                layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.layout;
                layout2.rightToRight = -1;
                layout2.rightToLeft = -1;
                layout2.rightMargin = -1;
                layout2.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.layout;
                layout3.topToBottom = -1;
                layout3.topToTop = -1;
                layout3.topMargin = 0;
                layout3.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.layout;
                layout4.bottomToTop = -1;
                layout4.bottomToBottom = -1;
                layout4.bottomMargin = 0;
                layout4.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.layout;
                layout5.baselineToBaseline = -1;
                layout5.baselineToTop = -1;
                layout5.baselineToBottom = -1;
                layout5.baselineMargin = 0;
                layout5.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.layout;
                layout6.startToEnd = -1;
                layout6.startToStart = -1;
                layout6.startMargin = 0;
                layout6.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.layout;
                layout7.endToStart = -1;
                layout7.endToEnd = -1;
                layout7.endMargin = 0;
                layout7.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.layout;
                layout8.circleAngle = -1.0f;
                layout8.circleRadius = -1;
                layout8.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (constraint != null) {
                this.mConstraints.put(num, constraint.m2318clone());
            }
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            Barrier childAt = constraintLayout.getChildAt(i);
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                constraint.fillFrom(id, constraintLayout$LayoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    if (i2 >= 21) {
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            transform2.elevation = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Barrier childAt = constraintLayout.getChildAt(i);
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id, constraintLayout$LayoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = childAt.getRotation();
                        constraint.transform.rotationX = childAt.getRotationX();
                        constraint.transform.rotationY = childAt.getRotationY();
                        constraint.transform.scaleX = childAt.getScaleX();
                        constraint.transform.scaleY = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = childAt.getTranslationX();
                        constraint.transform.translationY = childAt.getTranslationY();
                        if (i2 >= 21) {
                            constraint.transform.translationZ = childAt.getTranslationZ();
                            Transform transform3 = constraint.transform;
                            if (transform3.applyElevation) {
                                transform3.elevation = childAt.getElevation();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i, int i2) {
        if (i == 6) {
            constraint.layout.editorAbsoluteX = i2;
            return;
        }
        if (i == 7) {
            constraint.layout.editorAbsoluteY = i2;
            return;
        }
        if (i == 8) {
            constraint.layout.endMargin = i2;
            return;
        }
        if (i == 27) {
            constraint.layout.orientation = i2;
            return;
        }
        if (i == 28) {
            constraint.layout.rightMargin = i2;
            return;
        }
        if (i == 41) {
            constraint.layout.horizontalChainStyle = i2;
            return;
        }
        if (i == 42) {
            constraint.layout.verticalChainStyle = i2;
            return;
        }
        if (i == 61) {
            constraint.layout.circleConstraint = i2;
            return;
        }
        if (i == 62) {
            constraint.layout.circleRadius = i2;
            return;
        }
        if (i == 72) {
            constraint.layout.mBarrierDirection = i2;
            return;
        }
        if (i != 73) {
            switch (i) {
                case 2:
                    constraint.layout.bottomMargin = i2;
                    break;
                case 11:
                    constraint.layout.goneBottomMargin = i2;
                    break;
                case 12:
                    constraint.layout.goneEndMargin = i2;
                    break;
                case 13:
                    constraint.layout.goneLeftMargin = i2;
                    break;
                case 14:
                    constraint.layout.goneRightMargin = i2;
                    break;
                case 15:
                    constraint.layout.goneStartMargin = i2;
                    break;
                case 16:
                    constraint.layout.goneTopMargin = i2;
                    break;
                case 17:
                    constraint.layout.guideBegin = i2;
                    break;
                case 18:
                    constraint.layout.guideEnd = i2;
                    break;
                case 31:
                    constraint.layout.startMargin = i2;
                    break;
                case 34:
                    constraint.layout.topMargin = i2;
                    break;
                case 38:
                    constraint.mViewId = i2;
                    break;
                case 64:
                    constraint.motion.mAnimateRelativeTo = i2;
                    break;
                case 66:
                    constraint.motion.mDrawPath = i2;
                    break;
                case 76:
                    constraint.motion.mPathMotionArc = i2;
                    break;
                case 78:
                    constraint.propertySet.mVisibilityMode = i2;
                    break;
                case 93:
                    constraint.layout.baselineMargin = i2;
                    break;
                case 94:
                    constraint.layout.goneBaselineMargin = i2;
                    break;
                case 97:
                    constraint.layout.mWrapBehavior = i2;
                    break;
                default:
                    switch (i) {
                        case 21:
                            constraint.layout.mHeight = i2;
                            break;
                        case 22:
                            constraint.propertySet.visibility = i2;
                            break;
                        case 23:
                            constraint.layout.mWidth = i2;
                            break;
                        case 24:
                            constraint.layout.leftMargin = i2;
                            break;
                        default:
                            switch (i) {
                                case 54:
                                    constraint.layout.widthDefault = i2;
                                    break;
                                case 55:
                                    constraint.layout.heightDefault = i2;
                                    break;
                                case 56:
                                    constraint.layout.widthMax = i2;
                                    break;
                                case 57:
                                    constraint.layout.heightMax = i2;
                                    break;
                                case 58:
                                    constraint.layout.widthMin = i2;
                                    break;
                                case 59:
                                    constraint.layout.heightMin = i2;
                                    break;
                                default:
                                    switch (i) {
                                        case 82:
                                            constraint.motion.mAnimateCircleAngleTo = i2;
                                            break;
                                        case 83:
                                            constraint.transform.transformPivotTarget = i2;
                                            break;
                                        case 84:
                                            constraint.motion.mQuantizeMotionSteps = i2;
                                            break;
                                        default:
                                            switch (i) {
                                                case 87:
                                                    break;
                                                case 88:
                                                    constraint.motion.mQuantizeInterpolatorType = i2;
                                                    break;
                                                case 89:
                                                    constraint.motion.mQuantizeInterpolatorID = i2;
                                                    break;
                                                default:
                                                    Log.w(TAG, "Unknown attribute 0x");
                                                    break;
                                            }
                                    }
                            }
                    }
            }
            return;
        }
        constraint.layout.mBarrierMargin = i2;
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.fillFromConstraints(id, layoutParams);
            }
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                    return;
                } else if (i4 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + sideToString(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                    return;
                } else if (i4 == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    return;
                }
                if (i4 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                    return;
                }
                if (i4 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i4 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i3;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i4 == 4) {
                    Layout layout11 = constraint.layout;
                    layout11.baselineToBottom = i3;
                    layout11.bottomToBottom = -1;
                    layout11.bottomToTop = -1;
                    layout11.topToTop = -1;
                    layout11.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i3;
                    layout12.startToEnd = -1;
                    return;
                } else if (i4 == 7) {
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = i3;
                    layout13.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i3;
                    layout14.endToStart = -1;
                    return;
                } else if (i4 == 6) {
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = i3;
                    layout15.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                }
            default:
                throw new IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i, String str) {
        if (i == 5) {
            constraint.layout.dimensionRatio = str;
            return;
        }
        if (i == 65) {
            constraint.motion.mTransitionEasing = str;
            return;
        }
        if (i == 74) {
            Layout layout = constraint.layout;
            layout.mReferenceIdString = str;
            layout.mReferenceIds = null;
        } else if (i == 77) {
            constraint.layout.mConstraintTag = str;
        } else if (i != 87) {
            if (i != 90) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.motion.mQuantizeInterpolatorString = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i, boolean z) {
        if (i == 44) {
            constraint.transform.applyElevation = z;
            return;
        }
        if (i == 75) {
            constraint.layout.mBarrierAllowsGoneWidgets = z;
            return;
        }
        if (i != 87) {
            if (i == 80) {
                constraint.layout.constrainedWidth = z;
            } else if (i != 81) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.layout.constrainedHeight = z;
            }
        }
    }
}
