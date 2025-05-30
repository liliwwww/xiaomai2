package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawModifierNode nextDrawNode(DelegatableNode delegatableNode) {
        int i = NodeKind.constructor-impl(4);
        int i2 = NodeKind.constructor-impl(2);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
            return null;
        }
        while (child$ui_release != null && (child$ui_release.getKindSet$ui_release() & i2) == 0) {
            if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                return (DrawModifierNode) child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }
}
