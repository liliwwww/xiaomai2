package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Placeholder extends VirtualLayout {
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        if (this.mWidgetsCount > 0) {
            ConstraintWidget constraintWidget = this.mWidgets[0];
            constraintWidget.resetAllConstraints();
            ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
            constraintWidget.connect(constraintAnchor$Type, this, constraintAnchor$Type);
            ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.RIGHT;
            constraintWidget.connect(constraintAnchor$Type2, this, constraintAnchor$Type2);
            ConstraintAnchor$Type constraintAnchor$Type3 = ConstraintAnchor$Type.TOP;
            constraintWidget.connect(constraintAnchor$Type3, this, constraintAnchor$Type3);
            ConstraintAnchor$Type constraintAnchor$Type4 = ConstraintAnchor$Type.BOTTOM;
            constraintWidget.connect(constraintAnchor$Type4, this, constraintAnchor$Type4);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft() + getPaddingRight() + 0;
        int paddingTop = getPaddingTop() + getPaddingBottom() + 0;
        if (this.mWidgetsCount > 0) {
            paddingLeft += this.mWidgets[0].getWidth();
            paddingTop += this.mWidgets[0].getHeight();
        }
        int max = Math.max(getMinWidth(), paddingLeft);
        int max2 = Math.max(getMinHeight(), paddingTop);
        if (i != 1073741824) {
            i2 = i == Integer.MIN_VALUE ? Math.min(max, i2) : i == 0 ? max : 0;
        }
        if (i3 != 1073741824) {
            i4 = i3 == Integer.MIN_VALUE ? Math.min(max2, i4) : i3 == 0 ? max2 : 0;
        }
        setMeasure(i2, i4);
        setWidth(i2);
        setHeight(i4);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }
}
