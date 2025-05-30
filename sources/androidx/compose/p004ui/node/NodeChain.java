package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.ModifierInfo;
import androidx.compose.runtime.collection.MutableVector;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class NodeChain {

    @Nullable
    private MutableVector<Modifier.Element> buffer;

    @Nullable
    private Differ cachedDiffer;

    @Nullable
    private MutableVector<Modifier.Element> current;

    @NotNull
    private Modifier.Node head;

    @NotNull
    private final InnerNodeCoordinator innerCoordinator;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private Logger logger;

    @NotNull
    private NodeCoordinator outerCoordinator;

    @NotNull
    private final Modifier.Node tail;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private final class Differ implements DiffCallback {

        @NotNull
        private MutableVector<Modifier.Element> after;
        private int aggregateChildKindSet;

        @NotNull
        private MutableVector<Modifier.Element> before;

        @NotNull
        private Modifier.Node node;
        final /* synthetic */ NodeChain this$0;

        public Differ(@NotNull NodeChain nodeChain, Modifier.Node node, @NotNull int i, @NotNull MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(mutableVector, "before");
            Intrinsics.checkNotNullParameter(mutableVector2, "after");
            this.this$0 = nodeChain;
            this.node = node;
            this.aggregateChildKindSet = i;
            this.before = mutableVector;
            this.after = mutableVector2;
        }

        @Override // androidx.compose.p004ui.node.DiffCallback
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

        @Override // androidx.compose.p004ui.node.DiffCallback
        public void insert(int i, int i2) {
            Modifier.Node node = this.node;
            this.node = this.this$0.createAndInsertNodeAsParent(this.after.getContent()[i2], node);
            Logger logger = this.this$0.logger;
            if (logger != null) {
                logger.nodeInserted(i, i2, this.after.getContent()[i2], node, this.node);
            }
            int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
            this.aggregateChildKindSet = kindSet$ui_release;
            this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }

        @Override // androidx.compose.p004ui.node.DiffCallback
        public void remove(int i) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Logger logger = this.this$0.logger;
            if (logger != null) {
                logger.nodeRemoved(i, this.before.getContent()[i], this.node);
            }
            this.node = this.this$0.disposeAndRemoveNode(this.node);
        }

        @Override // androidx.compose.p004ui.node.DiffCallback
        public void same(int i, int i2) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Modifier.Element element = this.before.getContent()[i];
            Modifier.Element element2 = this.after.getContent()[i2];
            if (Intrinsics.areEqual(element, element2)) {
                Logger logger = this.this$0.logger;
                if (logger != null) {
                    logger.nodeReused(i, i2, element, element2, this.node);
                }
            } else {
                Modifier.Node node = this.node;
                this.node = this.this$0.updateNodeAndReplaceIfNeeded(element, element2, node);
                Logger logger2 = this.this$0.logger;
                if (logger2 != null) {
                    logger2.nodeUpdated(i, i2, element, element2, node, this.node);
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

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Logger {
        void linearDiffAborted(int i, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node);

        void nodeInserted(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Node node, @NotNull Modifier.Node node2);

        void nodeRemoved(int i, @NotNull Modifier.Element element, @NotNull Modifier.Node node);

        void nodeReused(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node);

        void nodeUpdated(int i, int i2, @NotNull Modifier.Element element, @NotNull Modifier.Element element2, @NotNull Modifier.Node node, @NotNull Modifier.Node node2);
    }

    public NodeChain(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier.Node tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node node) {
        Modifier.Node backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).create();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        return insertParent(backwardsCompatNode, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node disposeAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.detach$ui_release();
        }
        return removeNode(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    private final Differ getDiffer(Modifier.Node node, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(this, node, node.getAggregateChildKindSet$ui_release(), mutableVector, mutableVector2);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(node);
        differ.setAggregateChildKindSet(node.getAggregateChildKindSet$ui_release());
        differ.setBefore(mutableVector);
        differ.setAfter(mutableVector2);
        return differ;
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node parent$ui_release = node2.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(node);
            node.setParent$ui_release(parent$ui_release);
        }
        node2.setParent$ui_release(node);
        node.setChild$ui_release(node2);
        return node;
    }

    private final boolean isUpdating() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        return node == nodeChainKt$SentinelHead$1;
    }

    private final void padChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node != nodeChainKt$SentinelHead$1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node2 = this.head;
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        node2.setParent$ui_release(nodeChainKt$SentinelHead$12);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(node2);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        this.head = nodeChainKt$SentinelHead$14;
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child$ui_release = node.getChild$ui_release();
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release(null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(child$ui_release);
        return child$ui_release;
    }

    private final Modifier.Node replaceNode(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (parent$ui_release != null) {
            node2.setParent$ui_release(parent$ui_release);
            parent$ui_release.setChild$ui_release(node2);
            node.setParent$ui_release(null);
        }
        Modifier.Node child$ui_release = node.getChild$ui_release();
        if (child$ui_release != null) {
            node2.setChild$ui_release(child$ui_release);
            child$ui_release.setParent$ui_release(node2);
            node.setChild$ui_release(null);
        }
        node2.updateCoordinator$ui_release(node.getCoordinator$ui_release());
        return node2;
    }

    private final void structuralUpdate(MutableVector<Modifier.Element> mutableVector, int i, MutableVector<Modifier.Element> mutableVector2, int i2, Modifier.Node node) {
        MyersDiffKt.executeDiff(i, i2, getDiffer(node, mutableVector, mutableVector2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private final void syncCoordinators() {
        NodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        for (LayoutModifierNode layoutModifierNode = this.tail.getParent$ui_release(); layoutModifierNode != 0; layoutModifierNode = layoutModifierNode.getParent$ui_release()) {
            if (((NodeKind.m4398constructorimpl(2) & layoutModifierNode.getKindSet$ui_release()) != 0) && (layoutModifierNode instanceof LayoutModifierNode)) {
                if (layoutModifierNode.isAttached()) {
                    NodeCoordinator coordinator$ui_release = layoutModifierNode.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode layoutModifierNode2 = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(layoutModifierNode);
                    if (layoutModifierNode2 != layoutModifierNode) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, layoutModifierNode);
                    layoutModifierNode.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrapped$ui_release(nodeCoordinator);
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                layoutModifierNode.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        nodeCoordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = nodeCoordinator;
    }

    private final void trimChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node == nodeChainKt$SentinelHead$1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        Modifier.Node child$ui_release = nodeChainKt$SentinelHead$12.getChild$ui_release();
        if (child$ui_release == null) {
            child$ui_release = this.tail;
        }
        this.head = child$ui_release;
        child$ui_release.setParent$ui_release(null);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(null);
        Modifier.Node node2 = this.head;
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        if (!(node2 != nodeChainKt$SentinelHead$14)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node updateNodeAndReplaceIfNeeded(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        Modifier.Node updateUnsafe;
        if (!(element instanceof ModifierNodeElement) || !(element2 instanceof ModifierNodeElement)) {
            if (!(node instanceof BackwardsCompatNode)) {
                throw new IllegalStateException("Unknown Modifier.Node type".toString());
            }
            ((BackwardsCompatNode) node).setElement(element2);
            NodeKindKt.autoInvalidateUpdatedNode(node);
            return node;
        }
        ModifierNodeElement modifierNodeElement = (ModifierNodeElement) element2;
        updateUnsafe = NodeChainKt.updateUnsafe(modifierNodeElement, node);
        if (updateUnsafe == node) {
            if (modifierNodeElement.getAutoInvalidate$ui_release()) {
                NodeKindKt.autoInvalidateUpdatedNode(updateUnsafe);
            }
            return updateUnsafe;
        }
        NodeKindKt.autoInvalidateRemovedNode(node);
        node.detach$ui_release();
        Modifier.Node replaceNode = replaceNode(node, updateUnsafe);
        NodeKindKt.autoInvalidateInsertedNode(updateUnsafe);
        return replaceNode;
    }

    public final void attach(boolean z) {
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if (!head$ui_release.isAttached()) {
                head$ui_release.attach$ui_release();
                if (z) {
                    NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
                }
            }
        }
    }

    public final void detach$ui_release() {
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.detach$ui_release();
            }
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m4355firstFromHeadaLcG6gQ$ui_release(int i, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getHead$ui_release(); obj != null; obj = (T) ((Modifier.Node) obj).getChild$ui_release()) {
            if ((((Modifier.Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    return (T) obj;
                }
            }
            if ((((Modifier.Node) obj).getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }

    @NotNull
    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    @NotNull
    public final InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @NotNull
    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            NodeCoordinator coordinator$ui_release = head$ui_release.getCoordinator$ui_release();
            if (coordinator$ui_release == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            mutableVector2.add(new ModifierInfo(mutableVector.getContent()[i], coordinator$ui_release, coordinator$ui_release.getLayer()));
            head$ui_release = head$ui_release.getChild$ui_release();
            i++;
        }
        return mutableVector2.asMutableList();
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    @NotNull
    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final boolean has$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    /* renamed from: has-H91voCI$ui_release, reason: not valid java name */
    public final boolean m4356hasH91voCI$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    /* renamed from: head-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m4357headH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getHead$ui_release(); obj != null; obj = (T) ((Modifier.Node) obj).getChild$ui_release()) {
            if ((((Modifier.Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
            if ((((Modifier.Node) obj).getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }

    public final void headToTail$ui_release(int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(head$ui_release);
            }
            if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                return;
            }
        }
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m4358headToTailaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    function1.invoke(head$ui_release);
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                    return;
                }
            }
        }
    }

    public final void headToTailExclusive$ui_release(@NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null && head$ui_release != getTail$ui_release(); head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }

    /* renamed from: tail-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m4359tailH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getTail$ui_release(); obj != null; obj = (T) ((Modifier.Node) obj).getParent$ui_release()) {
            if ((((Modifier.Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
        }
        return null;
    }

    public final void tailToHead$ui_release(int i, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(tail$ui_release);
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m4360tailToHeadaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    function1.invoke(tail$ui_release);
                }
            }
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.head != this.tail) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (true) {
                if (head$ui_release == null || head$ui_release == getTail$ui_release()) {
                    break;
                }
                sb.append(String.valueOf(head$ui_release));
                if (head$ui_release.getChild$ui_release() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head$ui_release = head$ui_release.getChild$ui_release();
            }
        } else {
            sb.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateFrom$ui_release(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.Modifier r18) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void useLogger$ui_release(@Nullable Logger logger) {
        this.logger = logger;
    }

    public final void tailToHead$ui_release(@NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            function1.invoke(tail$ui_release);
        }
    }

    public final void headToTail$ui_release(@NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }
}
