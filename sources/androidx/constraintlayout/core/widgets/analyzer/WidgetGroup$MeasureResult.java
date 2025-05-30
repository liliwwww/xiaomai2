package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WidgetGroup$MeasureResult {
    int baseline;
    int bottom;
    int left;
    int orientation;
    int right;
    final /* synthetic */ WidgetGroup this$0;
    int top;
    WeakReference<ConstraintWidget> widgetRef;

    public WidgetGroup$MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
        this.this$0 = widgetGroup;
        this.widgetRef = new WeakReference<>(constraintWidget);
        this.left = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
        this.top = linearSystem.getObjectVariableValue(constraintWidget.mTop);
        this.right = linearSystem.getObjectVariableValue(constraintWidget.mRight);
        this.bottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
        this.baseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
        this.orientation = i;
    }

    public void apply() {
        ConstraintWidget constraintWidget = this.widgetRef.get();
        if (constraintWidget != null) {
            constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
        }
    }
}
