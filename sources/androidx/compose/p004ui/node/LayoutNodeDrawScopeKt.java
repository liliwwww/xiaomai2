package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final DrawModifierNode nextDrawNode(DelegatableNode delegatableNode) {
        int m4398constructorimpl = NodeKind.m4398constructorimpl(4);
        int m4398constructorimpl2 = NodeKind.m4398constructorimpl(2);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            return null;
        }
        int aggregateChildKindSet$ui_release = child$ui_release.getAggregateChildKindSet$ui_release() & m4398constructorimpl;
        if (aggregateChildKindSet$ui_release == 0) {
            return null;
        }
        for (Modifier.Node node = child$ui_release; node != 0 && (node.getKindSet$ui_release() & m4398constructorimpl2) == 0; node = node.getChild$ui_release()) {
            if ((node.getKindSet$ui_release() & m4398constructorimpl) != 0) {
                return (DrawModifierNode) node;
            }
        }
        return null;
    }
}
