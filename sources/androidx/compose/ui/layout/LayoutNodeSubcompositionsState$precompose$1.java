package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutNodeSubcompositionsState$precompose$1 implements SubcomposeLayoutState.PrecomposedSlotHandle {
    final /* synthetic */ Object $slotId;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    LayoutNodeSubcompositionsState$precompose$1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Object obj) {
        this.this$0 = layoutNodeSubcompositionsState;
        this.$slotId = obj;
    }

    public void dispose() {
        this.this$0.makeSureStateIsConsistent();
        LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.access$getPrecomposeMap$p(this.this$0).remove(this.$slotId);
        if (layoutNode != null) {
            if (!(LayoutNodeSubcompositionsState.access$getPrecomposedCount$p(this.this$0) > 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            int indexOf = LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0).getFoldedChildren$ui_release().indexOf(layoutNode);
            if (!(indexOf >= LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0).getFoldedChildren$ui_release().size() - LayoutNodeSubcompositionsState.access$getPrecomposedCount$p(this.this$0))) {
                throw new IllegalStateException("Check failed.".toString());
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
            LayoutNodeSubcompositionsState.access$setReusableCount$p(layoutNodeSubcompositionsState, LayoutNodeSubcompositionsState.access$getReusableCount$p(layoutNodeSubcompositionsState) + 1);
            LayoutNodeSubcompositionsState.access$setPrecomposedCount$p(this.this$0, LayoutNodeSubcompositionsState.access$getPrecomposedCount$p(r1) - 1);
            int size = (LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0).getFoldedChildren$ui_release().size() - LayoutNodeSubcompositionsState.access$getPrecomposedCount$p(this.this$0)) - LayoutNodeSubcompositionsState.access$getReusableCount$p(this.this$0);
            LayoutNodeSubcompositionsState.access$move(this.this$0, indexOf, size, 1);
            this.this$0.disposeOrReuseStartingFromIndex(size);
        }
    }

    public int getPlaceablesCount() {
        List children$ui_release;
        LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.access$getPrecomposeMap$p(this.this$0).get(this.$slotId);
        if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
            return 0;
        }
        return children$ui_release.size();
    }

    /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
    public void m1541premeasure0kLqBqw(int i, long j) {
        LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.access$getPrecomposeMap$p(this.this$0).get(this.$slotId);
        if (layoutNode == null || !layoutNode.isAttached()) {
            return;
        }
        int size = layoutNode.getChildren$ui_release().size();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + size + ')');
        }
        if (!(!layoutNode.isPlaced())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        LayoutNode access$getRoot$p = LayoutNodeSubcompositionsState.access$getRoot$p(this.this$0);
        LayoutNode.access$setIgnoreRemeasureRequests$p(access$getRoot$p, true);
        LayoutNodeKt.requireOwner(layoutNode).measureAndLayout-0kLqBqw((LayoutNode) layoutNode.getChildren$ui_release().get(i), j);
        LayoutNode.access$setIgnoreRemeasureRequests$p(access$getRoot$p, false);
    }
}
