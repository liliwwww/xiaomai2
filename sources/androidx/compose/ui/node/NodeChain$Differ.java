package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NodeChain$Differ implements DiffCallback {

    @NotNull
    private MutableVector<Modifier.Element> after;
    private int aggregateChildKindSet;

    @NotNull
    private MutableVector<Modifier.Element> before;

    @NotNull
    private Modifier.Node node;
    final /* synthetic */ NodeChain this$0;

    public NodeChain$Differ(@NotNull NodeChain nodeChain, Modifier.Node node, @NotNull int i, @NotNull MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(mutableVector, "before");
        Intrinsics.checkNotNullParameter(mutableVector2, "after");
        this.this$0 = nodeChain;
        this.node = node;
        this.aggregateChildKindSet = i;
        this.before = mutableVector;
        this.after = mutableVector2;
    }

    @Override // androidx.compose.ui.node.DiffCallback
    public boolean areItemsTheSame(int i, int i2) {
        return NodeChainKt.reuseActionForModifiers(this.before.getContent()[i], this.after.getContent()[i2]) != 0;
    }

    @NotNull
    public final MutableVector<Modifier.Element> getAfter() {
        return this.after;
    }

    public final int getAggregateChildKindSet() {
        return this.aggregateChildKindSet;
    }

    @NotNull
    public final MutableVector<Modifier.Element> getBefore() {
        return this.before;
    }

    @NotNull
    public final Modifier.Node getNode() {
        return this.node;
    }

    @Override // androidx.compose.ui.node.DiffCallback
    public void insert(int i, int i2) {
        Modifier.Node node = this.node;
        this.node = NodeChain.access$createAndInsertNodeAsParent(this.this$0, this.after.getContent()[i2], node);
        NodeChain$Logger access$getLogger$p = NodeChain.access$getLogger$p(this.this$0);
        if (access$getLogger$p != null) {
            access$getLogger$p.nodeInserted(i, i2, this.after.getContent()[i2], node, this.node);
        }
        int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
        this.aggregateChildKindSet = kindSet$ui_release;
        this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
    }

    @Override // androidx.compose.ui.node.DiffCallback
    public void remove(int i) {
        Modifier.Node parent$ui_release = this.node.getParent$ui_release();
        Intrinsics.checkNotNull(parent$ui_release);
        this.node = parent$ui_release;
        NodeChain$Logger access$getLogger$p = NodeChain.access$getLogger$p(this.this$0);
        if (access$getLogger$p != null) {
            access$getLogger$p.nodeRemoved(i, this.before.getContent()[i], this.node);
        }
        this.node = NodeChain.access$disposeAndRemoveNode(this.this$0, this.node);
    }

    @Override // androidx.compose.ui.node.DiffCallback
    public void same(int i, int i2) {
        Modifier.Node parent$ui_release = this.node.getParent$ui_release();
        Intrinsics.checkNotNull(parent$ui_release);
        this.node = parent$ui_release;
        Modifier.Element element = this.before.getContent()[i];
        Modifier.Element element2 = this.after.getContent()[i2];
        if (Intrinsics.areEqual(element, element2)) {
            NodeChain$Logger access$getLogger$p = NodeChain.access$getLogger$p(this.this$0);
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeReused(i, i2, element, element2, this.node);
            }
        } else {
            Modifier.Node node = this.node;
            this.node = NodeChain.access$updateNodeAndReplaceIfNeeded(this.this$0, element, element2, node);
            NodeChain$Logger access$getLogger$p2 = NodeChain.access$getLogger$p(this.this$0);
            if (access$getLogger$p2 != null) {
                access$getLogger$p2.nodeUpdated(i, i2, element, element2, node, this.node);
            }
        }
        int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
        this.aggregateChildKindSet = kindSet$ui_release;
        this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
    }

    public final void setAfter(@NotNull MutableVector<Modifier.Element> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
        this.after = mutableVector;
    }

    public final void setAggregateChildKindSet(int i) {
        this.aggregateChildKindSet = i;
    }

    public final void setBefore(@NotNull MutableVector<Modifier.Element> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
        this.before = mutableVector;
    }

    public final void setNode(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "<set-?>");
        this.node = node;
    }
}
