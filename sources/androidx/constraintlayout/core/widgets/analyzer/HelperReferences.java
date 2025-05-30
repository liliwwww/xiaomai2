package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode dependencyNode) {
        ((WidgetRun) this).start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(((WidgetRun) this).start);
    }

    void apply() {
        Barrier barrier = ((WidgetRun) this).widget;
        if (barrier instanceof Barrier) {
            ((WidgetRun) this).start.delegateToWidgetRun = true;
            Barrier barrier2 = barrier;
            int barrierType = barrier2.getBarrierType();
            boolean allowsGoneWidget = barrier2.getAllowsGoneWidget();
            int i = 0;
            if (barrierType == 0) {
                ((WidgetRun) this).start.type = DependencyNode.Type.LEFT;
                while (i < ((HelperWidget) barrier2).mWidgetsCount) {
                    ConstraintWidget constraintWidget = ((HelperWidget) barrier2).mWidgets[i];
                    if (allowsGoneWidget || constraintWidget.getVisibility() != 8) {
                        DependencyNode dependencyNode = ((WidgetRun) constraintWidget.horizontalRun).start;
                        dependencyNode.dependencies.add(((WidgetRun) this).start);
                        ((WidgetRun) this).start.targets.add(dependencyNode);
                    }
                    i++;
                }
                addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).start);
                addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).end);
                return;
            }
            if (barrierType == 1) {
                ((WidgetRun) this).start.type = DependencyNode.Type.RIGHT;
                while (i < ((HelperWidget) barrier2).mWidgetsCount) {
                    ConstraintWidget constraintWidget2 = ((HelperWidget) barrier2).mWidgets[i];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = ((WidgetRun) constraintWidget2.horizontalRun).end;
                        dependencyNode2.dependencies.add(((WidgetRun) this).start);
                        ((WidgetRun) this).start.targets.add(dependencyNode2);
                    }
                    i++;
                }
                addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).start);
                addDependency(((WidgetRun) ((WidgetRun) this).widget.horizontalRun).end);
                return;
            }
            if (barrierType == 2) {
                ((WidgetRun) this).start.type = DependencyNode.Type.TOP;
                while (i < ((HelperWidget) barrier2).mWidgetsCount) {
                    ConstraintWidget constraintWidget3 = ((HelperWidget) barrier2).mWidgets[i];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = ((WidgetRun) constraintWidget3.verticalRun).start;
                        dependencyNode3.dependencies.add(((WidgetRun) this).start);
                        ((WidgetRun) this).start.targets.add(dependencyNode3);
                    }
                    i++;
                }
                addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).start);
                addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).end);
                return;
            }
            if (barrierType != 3) {
                return;
            }
            ((WidgetRun) this).start.type = DependencyNode.Type.BOTTOM;
            while (i < ((HelperWidget) barrier2).mWidgetsCount) {
                ConstraintWidget constraintWidget4 = ((HelperWidget) barrier2).mWidgets[i];
                if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                    DependencyNode dependencyNode4 = ((WidgetRun) constraintWidget4.verticalRun).end;
                    dependencyNode4.dependencies.add(((WidgetRun) this).start);
                    ((WidgetRun) this).start.targets.add(dependencyNode4);
                }
                i++;
            }
            addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).start);
            addDependency(((WidgetRun) ((WidgetRun) this).widget.verticalRun).end);
        }
    }

    public void applyToWidget() {
        Barrier barrier = ((WidgetRun) this).widget;
        if (barrier instanceof Barrier) {
            int barrierType = barrier.getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                ((WidgetRun) this).widget.setX(((WidgetRun) this).start.value);
            } else {
                ((WidgetRun) this).widget.setY(((WidgetRun) this).start.value);
            }
        }
    }

    void clear() {
        ((WidgetRun) this).runGroup = null;
        ((WidgetRun) this).start.clear();
    }

    void reset() {
        ((WidgetRun) this).start.resolved = false;
    }

    boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        Barrier barrier = ((WidgetRun) this).widget;
        int barrierType = barrier.getBarrierType();
        Iterator it = ((WidgetRun) this).start.targets.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((DependencyNode) it.next()).value;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            ((WidgetRun) this).start.resolve(i2 + barrier.getMargin());
        } else {
            ((WidgetRun) this).start.resolve(i + barrier.getMargin());
        }
    }
}
