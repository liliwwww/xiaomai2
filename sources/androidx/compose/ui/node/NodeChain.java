package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NodeChain {

    @Nullable
    private MutableVector<Modifier$Element> buffer;

    @Nullable
    private Differ cachedDiffer;

    @Nullable
    private MutableVector<Modifier$Element> current;

    @NotNull
    private Modifier$Node head;

    @NotNull
    private final InnerNodeCoordinator innerCoordinator;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private Logger logger;

    @NotNull
    private NodeCoordinator outerCoordinator;

    @NotNull
    private final Modifier$Node tail;

    public NodeChain(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier$Node tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier$Node createAndInsertNodeAsParent(Modifier$Element modifier$Element, Modifier$Node modifier$Node) {
        Modifier$Node backwardsCompatNode;
        if (modifier$Element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) modifier$Element).create();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(modifier$Element);
        }
        return insertParent(backwardsCompatNode, modifier$Node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier$Node disposeAndRemoveNode(Modifier$Node modifier$Node) {
        if (modifier$Node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(modifier$Node);
            modifier$Node.detach$ui_release();
        }
        return removeNode(modifier$Node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    private final Differ getDiffer(Modifier$Node modifier$Node, MutableVector<Modifier$Element> mutableVector, MutableVector<Modifier$Element> mutableVector2) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(this, modifier$Node, modifier$Node.getAggregateChildKindSet$ui_release(), mutableVector, mutableVector2);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(modifier$Node);
        differ.setAggregateChildKindSet(modifier$Node.getAggregateChildKindSet$ui_release());
        differ.setBefore(mutableVector);
        differ.setAfter(mutableVector2);
        return differ;
    }

    private final Modifier$Node insertParent(Modifier$Node modifier$Node, Modifier$Node modifier$Node2) {
        Modifier$Node parent$ui_release = modifier$Node2.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(modifier$Node);
            modifier$Node.setParent$ui_release(parent$ui_release);
        }
        modifier$Node2.setParent$ui_release(modifier$Node);
        modifier$Node.setChild$ui_release(modifier$Node2);
        return modifier$Node;
    }

    private final boolean isUpdating() {
        return this.head == NodeChainKt.access$getSentinelHead$p();
    }

    private final void padChain() {
        if (!(this.head != NodeChainKt.access$getSentinelHead$p())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node modifier$Node = this.head;
        modifier$Node.setParent$ui_release(NodeChainKt.access$getSentinelHead$p());
        NodeChainKt.access$getSentinelHead$p().setChild$ui_release(modifier$Node);
        this.head = NodeChainKt.access$getSentinelHead$p();
    }

    private final Modifier$Node removeNode(Modifier$Node modifier$Node) {
        Modifier$Node child$ui_release = modifier$Node.getChild$ui_release();
        Modifier$Node parent$ui_release = modifier$Node.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            modifier$Node.setChild$ui_release(null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            modifier$Node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(child$ui_release);
        return child$ui_release;
    }

    private final Modifier$Node replaceNode(Modifier$Node modifier$Node, Modifier$Node modifier$Node2) {
        Modifier$Node parent$ui_release = modifier$Node.getParent$ui_release();
        if (parent$ui_release != null) {
            modifier$Node2.setParent$ui_release(parent$ui_release);
            parent$ui_release.setChild$ui_release(modifier$Node2);
            modifier$Node.setParent$ui_release(null);
        }
        Modifier$Node child$ui_release = modifier$Node.getChild$ui_release();
        if (child$ui_release != null) {
            modifier$Node2.setChild$ui_release(child$ui_release);
            child$ui_release.setParent$ui_release(modifier$Node2);
            modifier$Node.setChild$ui_release(null);
        }
        modifier$Node2.updateCoordinator$ui_release(modifier$Node.getCoordinator$ui_release());
        return modifier$Node2;
    }

    private final void structuralUpdate(MutableVector<Modifier$Element> mutableVector, int i, MutableVector<Modifier$Element> mutableVector2, int i2, Modifier$Node modifier$Node) {
        MyersDiffKt.executeDiff(i, i2, getDiffer(modifier$Node, mutableVector, mutableVector2));
    }

    private final void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = this.innerCoordinator;
        for (LayoutModifierNode parent$ui_release = this.tail.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (((NodeKind.m1660constructorimpl(2) & parent$ui_release.getKindSet$ui_release()) != 0) && (parent$ui_release instanceof LayoutModifierNode)) {
                if (parent$ui_release.isAttached()) {
                    LayoutModifierNodeCoordinator coordinator$ui_release = parent$ui_release.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = coordinator$ui_release;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(parent$ui_release);
                    if (layoutModifierNode != parent$ui_release) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, parent$ui_release);
                    parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                layoutModifierNodeCoordinator2.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrapped$ui_release(layoutModifierNodeCoordinator2);
                layoutModifierNodeCoordinator2 = layoutModifierNodeCoordinator;
            } else {
                parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator2);
            }
        }
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        layoutModifierNodeCoordinator2.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = layoutModifierNodeCoordinator2;
    }

    private final void trimChain() {
        if (!(this.head == NodeChainKt.access$getSentinelHead$p())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node child$ui_release = NodeChainKt.access$getSentinelHead$p().getChild$ui_release();
        if (child$ui_release == null) {
            child$ui_release = this.tail;
        }
        this.head = child$ui_release;
        child$ui_release.setParent$ui_release(null);
        NodeChainKt.access$getSentinelHead$p().setChild$ui_release(null);
        if (!(this.head != NodeChainKt.access$getSentinelHead$p())) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier$Node updateNodeAndReplaceIfNeeded(Modifier$Element modifier$Element, Modifier$Element modifier$Element2, Modifier$Node modifier$Node) {
        if (!(modifier$Element instanceof ModifierNodeElement) || !(modifier$Element2 instanceof ModifierNodeElement)) {
            if (!(modifier$Node instanceof BackwardsCompatNode)) {
                throw new IllegalStateException("Unknown Modifier.Node type".toString());
            }
            ((BackwardsCompatNode) modifier$Node).setElement(modifier$Element2);
            NodeKindKt.autoInvalidateUpdatedNode(modifier$Node);
            return modifier$Node;
        }
        ModifierNodeElement modifierNodeElement = (ModifierNodeElement) modifier$Element2;
        Modifier$Node access$updateUnsafe = NodeChainKt.access$updateUnsafe(modifierNodeElement, modifier$Node);
        if (access$updateUnsafe == modifier$Node) {
            if (modifierNodeElement.getAutoInvalidate$ui_release()) {
                NodeKindKt.autoInvalidateUpdatedNode(access$updateUnsafe);
            }
            return access$updateUnsafe;
        }
        NodeKindKt.autoInvalidateRemovedNode(modifier$Node);
        modifier$Node.detach$ui_release();
        Modifier$Node replaceNode = replaceNode(modifier$Node, access$updateUnsafe);
        NodeKindKt.autoInvalidateInsertedNode(access$updateUnsafe);
        return replaceNode;
    }

    public final void attach(boolean z) {
        for (Modifier$Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if (!head$ui_release.isAttached()) {
                head$ui_release.attach$ui_release();
                if (z) {
                    NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
                }
            }
        }
    }

    public final void detach$ui_release() {
        for (Modifier$Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.detach$ui_release();
            }
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m1621firstFromHeadaLcG6gQ$ui_release(int i, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getHead$ui_release(); obj != null; obj = (T) ((Modifier$Node) obj).getChild$ui_release()) {
            if ((((Modifier$Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    return (T) obj;
                }
            }
            if ((((Modifier$Node) obj).getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }

    @NotNull
    public final Modifier$Node getHead$ui_release() {
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
        MutableVector<Modifier$Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier$Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            NodeCoordinator coordinator$ui_release = head$ui_release.getCoordinator$ui_release();
            if (coordinator$ui_release == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            mutableVector2.add(new ModifierInfo((Modifier) mutableVector.getContent()[i], coordinator$ui_release, coordinator$ui_release.getLayer()));
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
    public final Modifier$Node getTail$ui_release() {
        return this.tail;
    }

    public final boolean has$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    /* renamed from: has-H91voCI$ui_release, reason: not valid java name */
    public final boolean m1622hasH91voCI$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    /* renamed from: head-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m1623headH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getHead$ui_release(); obj != null; obj = (T) ((Modifier$Node) obj).getChild$ui_release()) {
            if ((((Modifier$Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
            if ((((Modifier$Node) obj).getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }

    public final void headToTail$ui_release(int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier$Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(head$ui_release);
            }
            if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                return;
            }
        }
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m1624headToTailaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier$Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
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

    public final void headToTailExclusive$ui_release(@NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier$Node head$ui_release = getHead$ui_release(); head$ui_release != null && head$ui_release != getTail$ui_release(); head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }

    /* renamed from: tail-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m1625tailH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (Object obj = (T) getTail$ui_release(); obj != null; obj = (T) ((Modifier$Node) obj).getParent$ui_release()) {
            if ((((Modifier$Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
        }
        return null;
    }

    public final void tailToHead$ui_release(int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return;
        }
        for (Modifier$Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(tail$ui_release);
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m1626tailToHeadaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier$Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
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
            Modifier$Node head$ui_release = getHead$ui_release();
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateFrom$ui_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r18) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void useLogger$ui_release(@Nullable Logger logger) {
        this.logger = logger;
    }

    public final void tailToHead$ui_release(@NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier$Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            function1.invoke(tail$ui_release);
        }
    }

    public final void headToTail$ui_release(@NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier$Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }
}
