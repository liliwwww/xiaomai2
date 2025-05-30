package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ConstraintLayout$LayoutParams extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int CIRCLE = 8;
    public static final int END = 7;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    public int baselineMargin;
    public int baselineToBaseline;
    public int baselineToBottom;
    public int baselineToTop;
    public int bottomToBottom;
    public int bottomToTop;
    public float circleAngle;
    public int circleConstraint;
    public int circleRadius;
    public boolean constrainedHeight;
    public boolean constrainedWidth;
    public String constraintTag;
    public String dimensionRatio;
    int dimensionRatioSide;
    float dimensionRatioValue;
    public int editorAbsoluteX;
    public int editorAbsoluteY;
    public int endToEnd;
    public int endToStart;
    public int goneBaselineMargin;
    public int goneBottomMargin;
    public int goneEndMargin;
    public int goneLeftMargin;
    public int goneRightMargin;
    public int goneStartMargin;
    public int goneTopMargin;
    public int guideBegin;
    public int guideEnd;
    public float guidePercent;
    public boolean guidelineUseRtl;
    boolean heightSet;
    public boolean helped;
    public float horizontalBias;
    public int horizontalChainStyle;
    boolean horizontalDimensionFixed;
    public float horizontalWeight;
    boolean isGuideline;
    boolean isHelper;
    boolean isInPlaceholder;
    boolean isVirtualGroup;
    public int leftToLeft;
    public int leftToRight;
    public int matchConstraintDefaultHeight;
    public int matchConstraintDefaultWidth;
    public int matchConstraintMaxHeight;
    public int matchConstraintMaxWidth;
    public int matchConstraintMinHeight;
    public int matchConstraintMinWidth;
    public float matchConstraintPercentHeight;
    public float matchConstraintPercentWidth;
    boolean needsBaseline;
    public int orientation;
    int resolveGoneLeftMargin;
    int resolveGoneRightMargin;
    int resolvedGuideBegin;
    int resolvedGuideEnd;
    float resolvedGuidePercent;
    float resolvedHorizontalBias;
    int resolvedLeftToLeft;
    int resolvedLeftToRight;
    int resolvedRightToLeft;
    int resolvedRightToRight;
    public int rightToLeft;
    public int rightToRight;
    public int startToEnd;
    public int startToStart;
    public int topToBottom;
    public int topToTop;
    public float verticalBias;
    public int verticalChainStyle;
    boolean verticalDimensionFixed;
    public float verticalWeight;
    ConstraintWidget widget;
    boolean widthSet;
    public int wrapBehaviorInParent;

    public ConstraintLayout$LayoutParams(ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams) constraintLayout$LayoutParams);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.guidelineUseRtl = true;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.baselineToTop = -1;
        this.baselineToBottom = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = Integer.MIN_VALUE;
        this.goneTopMargin = Integer.MIN_VALUE;
        this.goneRightMargin = Integer.MIN_VALUE;
        this.goneBottomMargin = Integer.MIN_VALUE;
        this.goneStartMargin = Integer.MIN_VALUE;
        this.goneEndMargin = Integer.MIN_VALUE;
        this.goneBaselineMargin = Integer.MIN_VALUE;
        this.baselineMargin = 0;
        this.widthSet = true;
        this.heightSet = true;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.wrapBehaviorInParent = 0;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = Integer.MIN_VALUE;
        this.resolveGoneRightMargin = Integer.MIN_VALUE;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
        this.guideBegin = constraintLayout$LayoutParams.guideBegin;
        this.guideEnd = constraintLayout$LayoutParams.guideEnd;
        this.guidePercent = constraintLayout$LayoutParams.guidePercent;
        this.guidelineUseRtl = constraintLayout$LayoutParams.guidelineUseRtl;
        this.leftToLeft = constraintLayout$LayoutParams.leftToLeft;
        this.leftToRight = constraintLayout$LayoutParams.leftToRight;
        this.rightToLeft = constraintLayout$LayoutParams.rightToLeft;
        this.rightToRight = constraintLayout$LayoutParams.rightToRight;
        this.topToTop = constraintLayout$LayoutParams.topToTop;
        this.topToBottom = constraintLayout$LayoutParams.topToBottom;
        this.bottomToTop = constraintLayout$LayoutParams.bottomToTop;
        this.bottomToBottom = constraintLayout$LayoutParams.bottomToBottom;
        this.baselineToBaseline = constraintLayout$LayoutParams.baselineToBaseline;
        this.baselineToTop = constraintLayout$LayoutParams.baselineToTop;
        this.baselineToBottom = constraintLayout$LayoutParams.baselineToBottom;
        this.circleConstraint = constraintLayout$LayoutParams.circleConstraint;
        this.circleRadius = constraintLayout$LayoutParams.circleRadius;
        this.circleAngle = constraintLayout$LayoutParams.circleAngle;
        this.startToEnd = constraintLayout$LayoutParams.startToEnd;
        this.startToStart = constraintLayout$LayoutParams.startToStart;
        this.endToStart = constraintLayout$LayoutParams.endToStart;
        this.endToEnd = constraintLayout$LayoutParams.endToEnd;
        this.goneLeftMargin = constraintLayout$LayoutParams.goneLeftMargin;
        this.goneTopMargin = constraintLayout$LayoutParams.goneTopMargin;
        this.goneRightMargin = constraintLayout$LayoutParams.goneRightMargin;
        this.goneBottomMargin = constraintLayout$LayoutParams.goneBottomMargin;
        this.goneStartMargin = constraintLayout$LayoutParams.goneStartMargin;
        this.goneEndMargin = constraintLayout$LayoutParams.goneEndMargin;
        this.goneBaselineMargin = constraintLayout$LayoutParams.goneBaselineMargin;
        this.baselineMargin = constraintLayout$LayoutParams.baselineMargin;
        this.horizontalBias = constraintLayout$LayoutParams.horizontalBias;
        this.verticalBias = constraintLayout$LayoutParams.verticalBias;
        this.dimensionRatio = constraintLayout$LayoutParams.dimensionRatio;
        this.dimensionRatioValue = constraintLayout$LayoutParams.dimensionRatioValue;
        this.dimensionRatioSide = constraintLayout$LayoutParams.dimensionRatioSide;
        this.horizontalWeight = constraintLayout$LayoutParams.horizontalWeight;
        this.verticalWeight = constraintLayout$LayoutParams.verticalWeight;
        this.horizontalChainStyle = constraintLayout$LayoutParams.horizontalChainStyle;
        this.verticalChainStyle = constraintLayout$LayoutParams.verticalChainStyle;
        this.constrainedWidth = constraintLayout$LayoutParams.constrainedWidth;
        this.constrainedHeight = constraintLayout$LayoutParams.constrainedHeight;
        this.matchConstraintDefaultWidth = constraintLayout$LayoutParams.matchConstraintDefaultWidth;
        this.matchConstraintDefaultHeight = constraintLayout$LayoutParams.matchConstraintDefaultHeight;
        this.matchConstraintMinWidth = constraintLayout$LayoutParams.matchConstraintMinWidth;
        this.matchConstraintMaxWidth = constraintLayout$LayoutParams.matchConstraintMaxWidth;
        this.matchConstraintMinHeight = constraintLayout$LayoutParams.matchConstraintMinHeight;
        this.matchConstraintMaxHeight = constraintLayout$LayoutParams.matchConstraintMaxHeight;
        this.matchConstraintPercentWidth = constraintLayout$LayoutParams.matchConstraintPercentWidth;
        this.matchConstraintPercentHeight = constraintLayout$LayoutParams.matchConstraintPercentHeight;
        this.editorAbsoluteX = constraintLayout$LayoutParams.editorAbsoluteX;
        this.editorAbsoluteY = constraintLayout$LayoutParams.editorAbsoluteY;
        this.orientation = constraintLayout$LayoutParams.orientation;
        this.horizontalDimensionFixed = constraintLayout$LayoutParams.horizontalDimensionFixed;
        this.verticalDimensionFixed = constraintLayout$LayoutParams.verticalDimensionFixed;
        this.needsBaseline = constraintLayout$LayoutParams.needsBaseline;
        this.isGuideline = constraintLayout$LayoutParams.isGuideline;
        this.resolvedLeftToLeft = constraintLayout$LayoutParams.resolvedLeftToLeft;
        this.resolvedLeftToRight = constraintLayout$LayoutParams.resolvedLeftToRight;
        this.resolvedRightToLeft = constraintLayout$LayoutParams.resolvedRightToLeft;
        this.resolvedRightToRight = constraintLayout$LayoutParams.resolvedRightToRight;
        this.resolveGoneLeftMargin = constraintLayout$LayoutParams.resolveGoneLeftMargin;
        this.resolveGoneRightMargin = constraintLayout$LayoutParams.resolveGoneRightMargin;
        this.resolvedHorizontalBias = constraintLayout$LayoutParams.resolvedHorizontalBias;
        this.constraintTag = constraintLayout$LayoutParams.constraintTag;
        this.wrapBehaviorInParent = constraintLayout$LayoutParams.wrapBehaviorInParent;
        this.widget = constraintLayout$LayoutParams.widget;
        this.widthSet = constraintLayout$LayoutParams.widthSet;
        this.heightSet = constraintLayout$LayoutParams.heightSet;
    }

    public String getConstraintTag() {
        return this.constraintTag;
    }

    public ConstraintWidget getConstraintWidget() {
        return this.widget;
    }

    public void reset() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            constraintWidget.reset();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    @android.annotation.TargetApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout$LayoutParams.resolveLayoutDirection(int):void");
    }

    public void setWidgetDebugName(String str) {
        this.widget.setDebugName(str);
    }

    public void validate() {
        this.isGuideline = false;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.constrainedWidth) {
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth == 0) {
                this.matchConstraintDefaultWidth = 1;
            }
        }
        int i2 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i2 == -2 && this.constrainedHeight) {
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight == 0) {
                this.matchConstraintDefaultHeight = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.horizontalDimensionFixed = false;
            if (i == 0 && this.matchConstraintDefaultWidth == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.constrainedWidth = true;
            }
        }
        if (i2 == 0 || i2 == -1) {
            this.verticalDimensionFixed = false;
            if (i2 == 0 && this.matchConstraintDefaultHeight == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.constrainedHeight = true;
            }
        }
        if (this.guidePercent == -1.0f && this.guideBegin == -1 && this.guideEnd == -1) {
            return;
        }
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof Guideline)) {
            this.widget = new Guideline();
        }
        ((Guideline) this.widget).setOrientation(this.orientation);
    }

    public ConstraintLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.guidelineUseRtl = true;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.baselineToTop = -1;
        this.baselineToBottom = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = Integer.MIN_VALUE;
        this.goneTopMargin = Integer.MIN_VALUE;
        this.goneRightMargin = Integer.MIN_VALUE;
        this.goneBottomMargin = Integer.MIN_VALUE;
        this.goneStartMargin = Integer.MIN_VALUE;
        this.goneEndMargin = Integer.MIN_VALUE;
        this.goneBaselineMargin = Integer.MIN_VALUE;
        this.baselineMargin = 0;
        this.widthSet = true;
        this.heightSet = true;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.wrapBehaviorInParent = 0;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = Integer.MIN_VALUE;
        this.resolveGoneRightMargin = Integer.MIN_VALUE;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            int i2 = Table.map.get(index);
            switch (i2) {
                case 1:
                    this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                    this.circleConstraint = resourceId;
                    if (resourceId == -1) {
                        this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                    break;
                case 4:
                    float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                    this.circleAngle = f;
                    if (f < 0.0f) {
                        this.circleAngle = (360.0f - f) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                    break;
                case 6:
                    this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                    break;
                case 7:
                    this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                    this.leftToLeft = resourceId2;
                    if (resourceId2 == -1) {
                        this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                    this.leftToRight = resourceId3;
                    if (resourceId3 == -1) {
                        this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                    this.rightToLeft = resourceId4;
                    if (resourceId4 == -1) {
                        this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                    this.rightToRight = resourceId5;
                    if (resourceId5 == -1) {
                        this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                    this.topToTop = resourceId6;
                    if (resourceId6 == -1) {
                        this.topToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                    this.topToBottom = resourceId7;
                    if (resourceId7 == -1) {
                        this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                    this.bottomToTop = resourceId8;
                    if (resourceId8 == -1) {
                        this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                    this.bottomToBottom = resourceId9;
                    if (resourceId9 == -1) {
                        this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                    this.baselineToBaseline = resourceId10;
                    if (resourceId10 == -1) {
                        this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                    this.startToEnd = resourceId11;
                    if (resourceId11 == -1) {
                        this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                    this.startToStart = resourceId12;
                    if (resourceId12 == -1) {
                        this.startToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                    this.endToStart = resourceId13;
                    if (resourceId13 == -1) {
                        this.endToStart = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                    this.endToEnd = resourceId14;
                    if (resourceId14 == -1) {
                        this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                    break;
                case 22:
                    this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                    break;
                case 23:
                    this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                    break;
                case 24:
                    this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                    break;
                case 25:
                    this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                    break;
                case 26:
                    this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                    break;
                case 27:
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                    break;
                case 28:
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                    break;
                case 29:
                    this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                    break;
                case 30:
                    this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                    break;
                case 31:
                    int i3 = obtainStyledAttributes.getInt(index, 0);
                    this.matchConstraintDefaultWidth = i3;
                    if (i3 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i4 = obtainStyledAttributes.getInt(index, 0);
                    this.matchConstraintDefaultHeight = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                            this.matchConstraintMinWidth = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                            this.matchConstraintMaxWidth = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                    this.matchConstraintDefaultWidth = 2;
                    break;
                case 36:
                    try {
                        this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                            this.matchConstraintMinHeight = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                            this.matchConstraintMaxHeight = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                    this.matchConstraintDefaultHeight = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            ConstraintSet.parseDimensionRatioString(this, obtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            break;
                        case 46:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            break;
                        case 47:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_checkboxStyle /* 48 */:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_checkedTextViewStyle /* 49 */:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorAccent /* 50 */:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorBackgroundFloating /* 51 */:
                            this.constraintTag = obtainStyledAttributes.getString(index);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorButtonNormal /* 52 */:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                            this.baselineToTop = resourceId15;
                            if (resourceId15 == -1) {
                                this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorControlActivated /* 53 */:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                            this.baselineToBottom = resourceId16;
                            if (resourceId16 == -1) {
                                this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorControlHighlight /* 54 */:
                            this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                            break;
                        case androidx.appcompat.R.styleable.AppCompatTheme_colorControlNormal /* 55 */:
                            this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                                    this.widthSet = true;
                                    break;
                                case androidx.appcompat.R.styleable.AppCompatTheme_dividerVertical /* 65 */:
                                    ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                                    this.heightSet = true;
                                    break;
                                case androidx.appcompat.R.styleable.AppCompatTheme_dropDownListViewStyle /* 66 */:
                                    this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                    break;
                                case androidx.appcompat.R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /* 67 */:
                                    this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                    break;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        validate();
    }

    public ConstraintLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.guidelineUseRtl = true;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.baselineToTop = -1;
        this.baselineToBottom = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = Integer.MIN_VALUE;
        this.goneTopMargin = Integer.MIN_VALUE;
        this.goneRightMargin = Integer.MIN_VALUE;
        this.goneBottomMargin = Integer.MIN_VALUE;
        this.goneStartMargin = Integer.MIN_VALUE;
        this.goneEndMargin = Integer.MIN_VALUE;
        this.goneBaselineMargin = Integer.MIN_VALUE;
        this.baselineMargin = 0;
        this.widthSet = true;
        this.heightSet = true;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.wrapBehaviorInParent = 0;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = Integer.MIN_VALUE;
        this.resolveGoneRightMargin = Integer.MIN_VALUE;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
    }

    public ConstraintLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.guideBegin = -1;
        this.guideEnd = -1;
        this.guidePercent = -1.0f;
        this.guidelineUseRtl = true;
        this.leftToLeft = -1;
        this.leftToRight = -1;
        this.rightToLeft = -1;
        this.rightToRight = -1;
        this.topToTop = -1;
        this.topToBottom = -1;
        this.bottomToTop = -1;
        this.bottomToBottom = -1;
        this.baselineToBaseline = -1;
        this.baselineToTop = -1;
        this.baselineToBottom = -1;
        this.circleConstraint = -1;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.startToEnd = -1;
        this.startToStart = -1;
        this.endToStart = -1;
        this.endToEnd = -1;
        this.goneLeftMargin = Integer.MIN_VALUE;
        this.goneTopMargin = Integer.MIN_VALUE;
        this.goneRightMargin = Integer.MIN_VALUE;
        this.goneBottomMargin = Integer.MIN_VALUE;
        this.goneStartMargin = Integer.MIN_VALUE;
        this.goneEndMargin = Integer.MIN_VALUE;
        this.goneBaselineMargin = Integer.MIN_VALUE;
        this.baselineMargin = 0;
        this.widthSet = true;
        this.heightSet = true;
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
        this.dimensionRatio = null;
        this.dimensionRatioValue = 0.0f;
        this.dimensionRatioSide = 1;
        this.horizontalWeight = -1.0f;
        this.verticalWeight = -1.0f;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.matchConstraintDefaultWidth = 0;
        this.matchConstraintDefaultHeight = 0;
        this.matchConstraintMinWidth = 0;
        this.matchConstraintMinHeight = 0;
        this.matchConstraintMaxWidth = 0;
        this.matchConstraintMaxHeight = 0;
        this.matchConstraintPercentWidth = 1.0f;
        this.matchConstraintPercentHeight = 1.0f;
        this.editorAbsoluteX = -1;
        this.editorAbsoluteY = -1;
        this.orientation = -1;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.constraintTag = null;
        this.wrapBehaviorInParent = 0;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        this.needsBaseline = false;
        this.isGuideline = false;
        this.isHelper = false;
        this.isInPlaceholder = false;
        this.isVirtualGroup = false;
        this.resolvedLeftToLeft = -1;
        this.resolvedLeftToRight = -1;
        this.resolvedRightToLeft = -1;
        this.resolvedRightToRight = -1;
        this.resolveGoneLeftMargin = Integer.MIN_VALUE;
        this.resolveGoneRightMargin = Integer.MIN_VALUE;
        this.resolvedHorizontalBias = 0.5f;
        this.widget = new ConstraintWidget();
        this.helped = false;
    }
}
