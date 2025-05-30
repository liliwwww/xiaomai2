package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        ((WidgetRun) this).start.type = DependencyNode.Type.LEFT;
        ((WidgetRun) this).end.type = DependencyNode.Type.RIGHT;
        ((WidgetRun) this).orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = ((WidgetRun) this).widget;
        if (constraintWidget.measured) {
            ((WidgetRun) this).dimension.resolve(constraintWidget.getWidth());
        }
        if (((DependencyNode) ((WidgetRun) this).dimension).resolved) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ((WidgetRun) this).dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (parent = ((WidgetRun) this).widget.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour2)) {
                addTarget(((WidgetRun) this).start, ((WidgetRun) parent.horizontalRun).start, ((WidgetRun) this).widget.mLeft.getMargin());
                addTarget(((WidgetRun) this).end, ((WidgetRun) parent.horizontalRun).end, -((WidgetRun) this).widget.mRight.getMargin());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = ((WidgetRun) this).widget.getHorizontalDimensionBehaviour();
            ((WidgetRun) this).dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour3 && (parent2 = ((WidgetRun) this).widget.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                    int width = (parent2.getWidth() - ((WidgetRun) this).widget.mLeft.getMargin()) - ((WidgetRun) this).widget.mRight.getMargin();
                    addTarget(((WidgetRun) this).start, ((WidgetRun) parent2.horizontalRun).start, ((WidgetRun) this).widget.mLeft.getMargin());
                    addTarget(((WidgetRun) this).end, ((WidgetRun) parent2.horizontalRun).end, -((WidgetRun) this).widget.mRight.getMargin());
                    ((WidgetRun) this).dimension.resolve(width);
                    return;
                }
                if (((WidgetRun) this).dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    ((WidgetRun) this).dimension.resolve(((WidgetRun) this).widget.getWidth());
                }
            }
        }
        DimensionDependency dimensionDependency = ((WidgetRun) this).dimension;
        if (((DependencyNode) dimensionDependency).resolved) {
            ConstraintWidget constraintWidget2 = ((WidgetRun) this).widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                if (constraintAnchorArr[0].mTarget != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        ((WidgetRun) this).start.margin = ((WidgetRun) this).widget.mListAnchors[0].getMargin();
                        ((WidgetRun) this).end.margin = -((WidgetRun) this).widget.mListAnchors[1].getMargin();
                        return;
                    }
                    DependencyNode target = getTarget(((WidgetRun) this).widget.mListAnchors[0]);
                    if (target != null) {
                        addTarget(((WidgetRun) this).start, target, ((WidgetRun) this).widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = getTarget(((WidgetRun) this).widget.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(((WidgetRun) this).end, target2, -((WidgetRun) this).widget.mListAnchors[1].getMargin());
                    }
                    ((WidgetRun) this).start.delegateToWidgetRun = true;
                    ((WidgetRun) this).end.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchorArr[0].mTarget != null) {
                    DependencyNode target3 = getTarget(constraintAnchorArr[0]);
                    if (target3 != null) {
                        addTarget(((WidgetRun) this).start, target3, ((WidgetRun) this).widget.mListAnchors[0].getMargin());
                        addTarget(((WidgetRun) this).end, ((WidgetRun) this).start, ((DependencyNode) ((WidgetRun) this).dimension).value);
                        return;
                    }
                    return;
                }
                if (constraintAnchorArr[1].mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchorArr[1]);
                    if (target4 != null) {
                        addTarget(((WidgetRun) this).end, target4, -((WidgetRun) this).widget.mListAnchors[1].getMargin());
                        addTarget(((WidgetRun) this).start, ((WidgetRun) this).end, -((DependencyNode) ((WidgetRun) this).dimension).value);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof Helper) || constraintWidget2.getParent() == null || ((WidgetRun) this).widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                    return;
                }
                addTarget(((WidgetRun) this).start, ((WidgetRun) ((WidgetRun) this).widget.getParent().horizontalRun).start, ((WidgetRun) this).widget.getX());
                addTarget(((WidgetRun) this).end, ((WidgetRun) this).start, ((DependencyNode) ((WidgetRun) this).dimension).value);
                return;
            }
        }
        if (((WidgetRun) this).dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = ((WidgetRun) this).widget;
            int i = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency2 = ((WidgetRun) parent3.verticalRun).dimension;
                    ((DependencyNode) ((WidgetRun) this).dimension).targets.add(dimensionDependency2);
                    ((DependencyNode) dimensionDependency2).dependencies.add(((WidgetRun) this).dimension);
                    DimensionDependency dimensionDependency3 = ((WidgetRun) this).dimension;
                    ((DependencyNode) dimensionDependency3).delegateToWidgetRun = true;
                    ((DependencyNode) dimensionDependency3).dependencies.add(((WidgetRun) this).start);
                    ((DependencyNode) ((WidgetRun) this).dimension).dependencies.add(((WidgetRun) this).end);
                }
            } else if (i == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    ((WidgetRun) this).start.updateDelegate = this;
                    ((WidgetRun) this).end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                    ((WidgetRun) verticalWidgetRun).start.updateDelegate = this;
                    ((WidgetRun) verticalWidgetRun).end.updateDelegate = this;
                    ((DependencyNode) dimensionDependency).updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        ((DependencyNode) ((WidgetRun) this).dimension).targets.add(((WidgetRun) ((WidgetRun) this).widget.verticalRun).dimension);
                        ((DependencyNode) ((WidgetRun) ((WidgetRun) this).widget.verticalRun).dimension).dependencies.add(((WidgetRun) this).dimension);
                        VerticalWidgetRun verticalWidgetRun2 = ((WidgetRun) this).widget.verticalRun;
                        ((DependencyNode) ((WidgetRun) verticalWidgetRun2).dimension).updateDelegate = this;
                        ((DependencyNode) ((WidgetRun) this).dimension).targets.add(((WidgetRun) verticalWidgetRun2).start);
                        ((DependencyNode) ((WidgetRun) this).dimension).targets.add(((WidgetRun) ((WidgetRun) this).widget.verticalRun).end);
                        ((WidgetRun) ((WidgetRun) this).widget.verticalRun).start.dependencies.add(((WidgetRun) this).dimension);
                        ((WidgetRun) ((WidgetRun) this).widget.verticalRun).end.dependencies.add(((WidgetRun) this).dimension);
                    } else if (((WidgetRun) this).widget.isInHorizontalChain()) {
                        ((DependencyNode) ((WidgetRun) ((WidgetRun) this).widget.verticalRun).dimension).targets.add(((WidgetRun) this).dimension);
                        ((DependencyNode) ((WidgetRun) this).dimension).dependencies.add(((WidgetRun) ((WidgetRun) this).widget.verticalRun).dimension);
                    } else {
                        ((DependencyNode) ((WidgetRun) ((WidgetRun) this).widget.verticalRun).dimension).targets.add(((WidgetRun) this).dimension);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = ((WidgetRun) constraintWidget3.verticalRun).dimension;
                    ((DependencyNode) dimensionDependency).targets.add(dimensionDependency4);
                    ((DependencyNode) dimensionDependency4).dependencies.add(((WidgetRun) this).dimension);
                    ((WidgetRun) ((WidgetRun) this).widget.verticalRun).start.dependencies.add(((WidgetRun) this).dimension);
                    ((WidgetRun) ((WidgetRun) this).widget.verticalRun).end.dependencies.add(((WidgetRun) this).dimension);
                    DimensionDependency dimensionDependency5 = ((WidgetRun) this).dimension;
                    ((DependencyNode) dimensionDependency5).delegateToWidgetRun = true;
                    ((DependencyNode) dimensionDependency5).dependencies.add(((WidgetRun) this).start);
                    ((DependencyNode) ((WidgetRun) this).dimension).dependencies.add(((WidgetRun) this).end);
                    ((WidgetRun) this).start.targets.add(((WidgetRun) this).dimension);
                    ((WidgetRun) this).end.targets.add(((WidgetRun) this).dimension);
                }
            }
        }
        ConstraintWidget constraintWidget4 = ((WidgetRun) this).widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        if (constraintAnchorArr2[0].mTarget != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget4.isInHorizontalChain()) {
                ((WidgetRun) this).start.margin = ((WidgetRun) this).widget.mListAnchors[0].getMargin();
                ((WidgetRun) this).end.margin = -((WidgetRun) this).widget.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = getTarget(((WidgetRun) this).widget.mListAnchors[0]);
            DependencyNode target6 = getTarget(((WidgetRun) this).widget.mListAnchors[1]);
            if (target5 != null) {
                target5.addDependency(this);
            }
            if (target6 != null) {
                target6.addDependency(this);
            }
            ((WidgetRun) this).mRunType = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchorArr2[0].mTarget != null) {
            DependencyNode target7 = getTarget(constraintAnchorArr2[0]);
            if (target7 != null) {
                addTarget(((WidgetRun) this).start, target7, ((WidgetRun) this).widget.mListAnchors[0].getMargin());
                addTarget(((WidgetRun) this).end, ((WidgetRun) this).start, 1, ((WidgetRun) this).dimension);
                return;
            }
            return;
        }
        if (constraintAnchorArr2[1].mTarget != null) {
            DependencyNode target8 = getTarget(constraintAnchorArr2[1]);
            if (target8 != null) {
                addTarget(((WidgetRun) this).end, target8, -((WidgetRun) this).widget.mListAnchors[1].getMargin());
                addTarget(((WidgetRun) this).start, ((WidgetRun) this).end, -1, ((WidgetRun) this).dimension);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof Helper) || constraintWidget4.getParent() == null) {
            return;
        }
        addTarget(((WidgetRun) this).start, ((WidgetRun) ((WidgetRun) this).widget.getParent().horizontalRun).start, ((WidgetRun) this).widget.getX());
        addTarget(((WidgetRun) this).end, ((WidgetRun) this).start, 1, ((WidgetRun) this).dimension);
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = ((WidgetRun) this).start;
        if (dependencyNode.resolved) {
            ((WidgetRun) this).widget.setX(dependencyNode.value);
        }
    }

    void clear() {
        ((WidgetRun) this).runGroup = null;
        ((WidgetRun) this).start.clear();
        ((WidgetRun) this).end.clear();
        ((WidgetRun) this).dimension.clear();
        ((WidgetRun) this).resolved = false;
    }

    void reset() {
        ((WidgetRun) this).resolved = false;
        ((WidgetRun) this).start.clear();
        ((WidgetRun) this).start.resolved = false;
        ((WidgetRun) this).end.clear();
        ((WidgetRun) this).end.resolved = false;
        ((DependencyNode) ((WidgetRun) this).dimension).resolved = false;
    }

    boolean supportsWrapComputation() {
        return ((WidgetRun) this).dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || ((WidgetRun) this).widget.mMatchConstraintDefaultWidth == 0;
    }

    public String toString() {
        return "HorizontalRun " + ((WidgetRun) this).widget.getDebugName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02bb, code lost:
    
        if (r14 != 1) goto L135;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
