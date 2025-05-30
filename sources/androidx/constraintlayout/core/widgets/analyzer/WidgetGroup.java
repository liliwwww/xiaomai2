package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    int id;
    int orientation;
    ArrayList<ConstraintWidget> widgets = new ArrayList<>();
    boolean authoritative = false;
    ArrayList<MeasureResult> results = null;
    private int moveTo = -1;

    public WidgetGroup(int i) {
        this.id = -1;
        this.orientation = 0;
        int i2 = count;
        count = i2 + 1;
        this.id = i2;
        this.orientation = i;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.widgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int i = this.orientation;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    private int measureWrap(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i);
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            return i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight();
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.ConstraintWidgetContainer] */
    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int objectVariableValue;
        int objectVariableValue2;
        ?? r1 = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        r1.addToSolver(linearSystem, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).addToSolver(linearSystem, false);
        }
        if (i == 0 && r1.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(r1, linearSystem, arrayList, 0);
        }
        if (i == 1 && r1.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(r1, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.results = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.results.add(new MeasureResult(this, arrayList.get(i3), linearSystem, i));
        }
        if (i == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(r1.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(r1.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(r1.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(r1.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.widgets.contains(constraintWidget)) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.results != null && this.authoritative) {
            for (int i = 0; i < this.results.size(); i++) {
                this.results.get(i).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.widgets.size();
        if (this.moveTo != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.moveTo == widgetGroup.id) {
                    moveTo(this.orientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i = 0; i < this.widgets.size(); i++) {
            if (widgetGroup.contains(this.widgets.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.moveTo = widgetGroup.id;
    }

    public void setAuthoritative(boolean z) {
        this.authoritative = z;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        String str = getOrientationString() + " [" + this.id + "] <";
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().getDebugName();
        }
        return str + " >";
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        if (this.widgets.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.widgets, i);
    }
}
