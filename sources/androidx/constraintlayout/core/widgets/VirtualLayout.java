package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class VirtualLayout extends HelperWidget {
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingEnd = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;
    private boolean mNeedsCallFromSolver = false;
    private int mMeasuredWidth = 0;
    private int mMeasuredHeight = 0;
    protected BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    BasicMeasure.Measurer mMeasurer = null;

    public void applyRtl(boolean z) {
        int i = this.mPaddingStart;
        if (i > 0 || this.mPaddingEnd > 0) {
            if (z) {
                this.mResolvedPaddingLeft = this.mPaddingEnd;
                this.mResolvedPaddingRight = i;
            } else {
                this.mResolvedPaddingLeft = i;
                this.mResolvedPaddingRight = this.mPaddingEnd;
            }
        }
    }

    public void captureWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            if (hashSet.contains(this.mWidgets[i])) {
                return true;
            }
        }
        return false;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    protected void measure(ConstraintWidget constraintWidget, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int i, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int i2) {
        while (this.mMeasurer == null && getParent() != null) {
            this.mMeasurer = getParent().getMeasurer();
        }
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = constraintWidget$DimensionBehaviour;
        measure.verticalBehavior = constraintWidget$DimensionBehaviour2;
        measure.horizontalDimension = i;
        measure.verticalDimension = i2;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    protected boolean measureChildren() {
        ConstraintWidgetContainer constraintWidgetContainer = ((ConstraintWidget) this).mParent;
        BasicMeasure.Measurer measurer = constraintWidgetContainer != null ? constraintWidgetContainer.getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (constraintWidget != null && !(constraintWidget instanceof Guideline)) {
                ConstraintWidget$DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget$DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (!(dimensionBehaviour == constraintWidget$DimensionBehaviour && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == constraintWidget$DimensionBehaviour && constraintWidget.mMatchConstraintDefaultHeight != 1)) {
                    if (dimensionBehaviour == constraintWidget$DimensionBehaviour) {
                        dimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
                        dimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget.getHeight();
                    measurer.measure(constraintWidget, this.mMeasure);
                    constraintWidget.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
            i++;
        }
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    protected void needsCallbackFromSolver(boolean z) {
        this.mNeedsCallFromSolver = z;
    }

    public void setMeasure(int i, int i2) {
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    public void setPadding(int i) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i;
        this.mPaddingRight = i;
        this.mPaddingBottom = i;
        this.mPaddingStart = i;
        this.mPaddingEnd = i;
    }

    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    public void setPaddingEnd(int i) {
        this.mPaddingEnd = i;
    }

    public void setPaddingLeft(int i) {
        this.mPaddingLeft = i;
        this.mResolvedPaddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.mPaddingRight = i;
        this.mResolvedPaddingRight = i;
    }

    public void setPaddingStart(int i) {
        this.mPaddingStart = i;
        this.mResolvedPaddingLeft = i;
        this.mResolvedPaddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
