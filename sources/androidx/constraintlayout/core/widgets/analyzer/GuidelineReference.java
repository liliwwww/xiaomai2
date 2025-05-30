package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.clear();
        constraintWidget.verticalRun.clear();
        ((WidgetRun) this).orientation = ((Guideline) constraintWidget).getOrientation();
    }

    private void addDependency(DependencyNode dependencyNode) {
        ((WidgetRun) this).start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(((WidgetRun) this).start);
    }

    void apply() {
        Guideline guideline = (Guideline) ((WidgetRun) this).widget;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                ((WidgetRun) this).start.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).start);
                ((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).start.dependencies.add(((WidgetRun) this).start);
                ((WidgetRun) this).start.margin = relativeBegin;
            } else if (relativeEnd != -1) {
                ((WidgetRun) this).start.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).end);
                ((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).end.dependencies.add(((WidgetRun) this).start);
                ((WidgetRun) this).start.margin = -relativeEnd;
            } else {
                DependencyNode dependencyNode = ((WidgetRun) this).start;
                dependencyNode.delegateToWidgetRun = true;
                dependencyNode.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).end);
                ((WidgetRun) ((WidgetRun) this).widget.mParent.horizontalRun).end.dependencies.add(((WidgetRun) this).start);
            }
            addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).start);
            addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).end);
            return;
        }
        if (relativeBegin != -1) {
            ((WidgetRun) this).start.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).start);
            ((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).start.dependencies.add(((WidgetRun) this).start);
            ((WidgetRun) this).start.margin = relativeBegin;
        } else if (relativeEnd != -1) {
            ((WidgetRun) this).start.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).end);
            ((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).end.dependencies.add(((WidgetRun) this).start);
            ((WidgetRun) this).start.margin = -relativeEnd;
        } else {
            DependencyNode dependencyNode2 = ((WidgetRun) this).start;
            dependencyNode2.delegateToWidgetRun = true;
            dependencyNode2.targets.add(((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).end);
            ((WidgetRun) ((WidgetRun) this).widget.mParent.verticalRun).end.dependencies.add(((WidgetRun) this).start);
        }
        addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).start);
        addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).end);
    }

    public void applyToWidget() {
        if (((Guideline) ((WidgetRun) this).widget).getOrientation() == 1) {
            ((WidgetRun) this).widget.setX(((WidgetRun) this).start.value);
        } else {
            ((WidgetRun) this).widget.setY(((WidgetRun) this).start.value);
        }
    }

    void clear() {
        ((WidgetRun) this).start.clear();
    }

    void reset() {
        ((WidgetRun) this).start.resolved = false;
        ((WidgetRun) this).end.resolved = false;
    }

    boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        DependencyNode dependencyNode = ((WidgetRun) this).start;
        if (dependencyNode.readyToSolve && !dependencyNode.resolved) {
            ((WidgetRun) this).start.resolve((int) ((((DependencyNode) dependencyNode.targets.get(0)).value * ((Guideline) ((WidgetRun) this).widget).getRelativePercent()) + 0.5f));
        }
    }
}
