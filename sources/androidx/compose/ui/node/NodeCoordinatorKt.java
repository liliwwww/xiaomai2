package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: nextUncheckedUntil-hw7D004, reason: not valid java name */
    public static final <T> T m1658nextUncheckedUntilhw7D004(DelegatableNode delegatableNode, int i, int i2) {
        Modifier$Node modifier$Node = (T) delegatableNode.getNode().getChild$ui_release();
        if (modifier$Node == null) {
            return null;
        }
        int aggregateChildKindSet$ui_release = modifier$Node.getAggregateChildKindSet$ui_release() & i;
        if (aggregateChildKindSet$ui_release == 0) {
            return null;
        }
        for (Object obj = modifier$Node; obj != null; obj = (T) ((Modifier$Node) obj).getChild$ui_release()) {
            int kindSet$ui_release = ((Modifier$Node) obj).getKindSet$ui_release();
            if ((kindSet$ui_release & i2) != 0) {
                return null;
            }
            if ((kindSet$ui_release & i) != 0) {
                return (T) obj;
            }
        }
        return null;
    }
}
