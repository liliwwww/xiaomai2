package androidx.constraintlayout.widget;

import android.util.SparseIntArray;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ConstraintLayout$LayoutParams$Table {
    public static final int ANDROID_ORIENTATION = 1;
    public static final int GUIDELINE_USE_RTL = 67;
    public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
    public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
    public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF = 53;
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF = 52;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
    public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
    public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
    public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
    public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
    public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
    public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
    public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
    public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
    public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
    public static final int LAYOUT_CONSTRAINT_HEIGHT = 65;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
    public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
    public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
    public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
    public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
    public static final int LAYOUT_CONSTRAINT_TAG = 51;
    public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
    public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
    public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
    public static final int LAYOUT_CONSTRAINT_WIDTH = 64;
    public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
    public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
    public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
    public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
    public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
    public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
    public static final int LAYOUT_GONE_MARGIN_BASELINE = 55;
    public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
    public static final int LAYOUT_GONE_MARGIN_END = 26;
    public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
    public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
    public static final int LAYOUT_GONE_MARGIN_START = 25;
    public static final int LAYOUT_GONE_MARGIN_TOP = 22;
    public static final int LAYOUT_MARGIN_BASELINE = 54;
    public static final int LAYOUT_WRAP_BEHAVIOR_IN_PARENT = 66;
    public static final int UNUSED = 0;
    public static final SparseIntArray map;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        map = sparseIntArray;
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
        sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
    }

    private ConstraintLayout$LayoutParams$Table() {
    }
}
