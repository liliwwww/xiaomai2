package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            ((DependencyNode) this).type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            ((DependencyNode) this).type = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public void resolve(int i) {
        if (((DependencyNode) this).resolved) {
            return;
        }
        ((DependencyNode) this).resolved = true;
        ((DependencyNode) this).value = i;
        for (Dependency dependency : ((DependencyNode) this).dependencies) {
            dependency.update(dependency);
        }
    }
}
