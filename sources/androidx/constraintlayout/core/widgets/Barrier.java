package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean resolved = false;

    public Barrier() {
    }

    public void addToSolver(LinearSystem linearSystem, boolean z) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z2;
        int i;
        int i2;
        int i3;
        ConstraintAnchor[] constraintAnchorArr2 = ((ConstraintWidget) this).mListAnchors;
        constraintAnchorArr2[0] = ((ConstraintWidget) this).mLeft;
        constraintAnchorArr2[2] = ((ConstraintWidget) this).mTop;
        constraintAnchorArr2[1] = ((ConstraintWidget) this).mRight;
        constraintAnchorArr2[3] = ((ConstraintWidget) this).mBottom;
        int i4 = 0;
        while (true) {
            constraintAnchorArr = ((ConstraintWidget) this).mListAnchors;
            if (i4 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i4].mSolverVariable = linearSystem.createObjectVariable(constraintAnchorArr[i4]);
            i4++;
        }
        int i5 = this.mBarrierType;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i5];
        if (!this.resolved) {
            allSolved();
        }
        if (this.resolved) {
            this.resolved = false;
            int i6 = this.mBarrierType;
            if (i6 == 0 || i6 == 1) {
                linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mX);
                linearSystem.addEquality(((ConstraintWidget) this).mRight.mSolverVariable, ((ConstraintWidget) this).mX);
                return;
            } else {
                if (i6 == 2 || i6 == 3) {
                    linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mY);
                    linearSystem.addEquality(((ConstraintWidget) this).mBottom.mSolverVariable, ((ConstraintWidget) this).mY);
                    return;
                }
                return;
            }
        }
        for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
            ConstraintWidget constraintWidget = this.mWidgets[i7];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = ((ConstraintWidget) this).mLeft.hasCenteredDependents() || ((ConstraintWidget) this).mRight.hasCenteredDependents();
        boolean z4 = ((ConstraintWidget) this).mTop.hasCenteredDependents() || ((ConstraintWidget) this).mBottom.hasCenteredDependents();
        int i8 = !z2 && (((i = this.mBarrierType) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4)))) ? 5 : 4;
        for (int i9 = 0; i9 < this.mWidgetsCount; i9++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i9];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                int i10 = this.mBarrierType;
                constraintAnchorArr3[i10].mSolverVariable = createObjectVariable;
                int i11 = (constraintAnchorArr3[i10].mTarget == null || constraintAnchorArr3[i10].mTarget.mOwner != this) ? 0 : constraintAnchorArr3[i10].mMargin + 0;
                if (i10 == 0 || i10 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin - i11, z2);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i11, z2);
                }
                linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i11, i8);
            }
        }
        int i12 = this.mBarrierType;
        if (i12 == 0) {
            linearSystem.addEquality(((ConstraintWidget) this).mRight.mSolverVariable, ((ConstraintWidget) this).mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i12 == 1) {
            linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(((ConstraintWidget) this).mLeft.mSolverVariable, ((ConstraintWidget) this).mParent.mRight.mSolverVariable, 0, 0);
        } else if (i12 == 2) {
            linearSystem.addEquality(((ConstraintWidget) this).mBottom.mSolverVariable, ((ConstraintWidget) this).mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mParent.mTop.mSolverVariable, 0, 0);
        } else if (i12 == 3) {
            linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(((ConstraintWidget) this).mTop.mSolverVariable, ((ConstraintWidget) this).mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.mWidgetsCount;
            if (i4 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i4];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i2 = this.mBarrierType) == 0 || i2 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i3 = this.mBarrierType) == 2 || i3 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i6];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i7 = this.mBarrierType;
                    if (i7 == 0) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor$Type.LEFT).getFinalValue();
                    } else if (i7 == 1) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor$Type.RIGHT).getFinalValue();
                    } else if (i7 == 2) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor$Type.TOP).getFinalValue();
                    } else if (i7 == 3) {
                        i5 = constraintWidget2.getAnchor(ConstraintAnchor$Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i8 = this.mBarrierType;
                if (i8 == 0) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor$Type.LEFT).getFinalValue());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor$Type.RIGHT).getFinalValue());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, constraintWidget2.getAnchor(ConstraintAnchor$Type.TOP).getFinalValue());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, constraintWidget2.getAnchor(ConstraintAnchor$Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i9 = i5 + this.mMargin;
        int i10 = this.mBarrierType;
        if (i10 == 0 || i10 == 1) {
            setFinalHorizontal(i9, i9);
        } else {
            setFinalVertical(i9, i9);
        }
        this.resolved = true;
        return true;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    protected void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i2 = this.mBarrierType;
                if (i2 == 0 || i2 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setMargin(int i) {
        this.mMargin = i;
    }

    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
