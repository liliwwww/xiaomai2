package androidx.compose.ui.node;

import androidx.compose.ui.node.Owner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BackwardsCompatNode$initializeModifier$2 implements Owner.OnLayoutCompletedListener {
    final /* synthetic */ BackwardsCompatNode this$0;

    BackwardsCompatNode$initializeModifier$2(BackwardsCompatNode backwardsCompatNode) {
        this.this$0 = backwardsCompatNode;
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        if (BackwardsCompatNode.access$getLastOnPlacedCoordinates$p(this.this$0) == null) {
            BackwardsCompatNode backwardsCompatNode = this.this$0;
            backwardsCompatNode.onPlaced(DelegatableNodeKt.requireCoordinator-64DMado(backwardsCompatNode, NodeKind.constructor-impl(128)));
        }
    }
}
