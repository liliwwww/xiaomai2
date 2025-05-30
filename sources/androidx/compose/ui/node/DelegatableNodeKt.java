package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier$Node;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DelegatableNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier$Node> mutableVector, Modifier$Node modifier$Node) {
        MutableVector mutableVector2 = requireLayoutNode(modifier$Node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector2.getContent();
            do {
                mutableVector.add(((LayoutNode) content[i]).getNodes$ui_release().getHead$ui_release());
                i--;
            } while (i >= 0);
        }
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final List<Modifier$Node> ancestors(@NotNull DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(parent$ui_release);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return arrayList;
    }

    @ExperimentalComposeUiApi
    /* renamed from: ancestors-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m1594ancestors64DMado(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$ancestors");
        List<T> list = (List<T>) ancestors(delegatableNode, i);
        if (list instanceof List) {
            return list;
        }
        return null;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier$Node firstChild(@NotNull DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, modifier$Node);
            } else {
                while (modifier$Node != null) {
                    if ((modifier$Node.getKindSet$ui_release() & i) != 0) {
                        return modifier$Node;
                    }
                    modifier$Node = modifier$Node.getChild$ui_release();
                }
            }
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: firstChild-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m1595firstChild64DMado(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$firstChild");
        T t = (T) firstChild(delegatableNode, i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @ExperimentalComposeUiApi
    /* renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m1596has64DMado(@NotNull DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$has");
        return (delegatableNode.getNode().getAggregateChildKindSet$ui_release() & i) != 0;
    }

    @ExperimentalComposeUiApi
    public static final void invalidateSubtree(@NotNull DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (delegatableNode.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, (Object) null);
        }
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier$Node localChild(@NotNull DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
            return null;
        }
        while (child$ui_release != null) {
            if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: localChild-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m1597localChild64DMado(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$localChild");
        T t = (T) localChild(delegatableNode, i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier$Node localParent(@NotNull DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        for (Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                return parent$ui_release;
            }
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: localParent-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m1598localParent64DMado(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$localParent");
        T t = (T) localParent(delegatableNode, i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @ExperimentalComposeUiApi
    @Nullable
    public static final Modifier$Node nearestAncestor(@NotNull DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        return parent$ui_release;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m1599nearestAncestor64DMado(DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$nearestAncestor");
        T t = (T) nearestAncestor(delegatableNode, i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m1600requireCoordinator64DMado(@NotNull DelegatableNode delegatableNode, int i) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$requireCoordinator");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != delegatableNode || !NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(i)) {
            return coordinator$ui_release;
        }
        NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final LayoutNode requireLayoutNode(@NotNull DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Owner requireOwner(@NotNull DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Owner owner$ui_release = requireLayoutNode(delegatableNode).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @ExperimentalComposeUiApi
    public static final void visitAncestors(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        function1.invoke(parent$ui_release);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1601visitAncestors6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        function1.invoke(parent$ui_release);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitChildren(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, modifier$Node);
            } else {
                while (true) {
                    if (modifier$Node == null) {
                        break;
                    }
                    if ((modifier$Node.getKindSet$ui_release() & i) != 0) {
                        function1.invoke(modifier$Node);
                        break;
                    }
                    modifier$Node = modifier$Node.getChild$ui_release();
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1602visitChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & i) == 0) {
                addLayoutNodeChildren(mutableVector, modifier$Node);
            } else {
                while (true) {
                    if (modifier$Node == null) {
                        break;
                    }
                    if ((modifier$Node.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        function1.invoke(modifier$Node);
                        break;
                    }
                    modifier$Node = modifier$Node.getChild$ui_release();
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalChildren(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
            return;
        }
        for (Modifier$Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(child$ui_release);
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1603visitLocalChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitLocalChildren");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
            for (Modifier$Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    function1.invoke(child$ui_release);
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalParents(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                function1.invoke(parent$ui_release);
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalParents-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1604visitLocalParents6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitLocalParents");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier$Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                function1.invoke(parent$ui_release);
            }
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtree(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
            }
            if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        function1.invoke(child$ui_release);
                    }
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
                child$ui_release = null;
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtree-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1605visitSubtree6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child$ui_release == null) {
                child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
            }
            if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                while (child$ui_release != null) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        function1.invoke(child$ui_release);
                    }
                    child$ui_release = child$ui_release.getChild$ui_release();
                }
                child$ui_release = null;
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtreeIf(@NotNull DelegatableNode delegatableNode, int i, @NotNull Function1<? super Modifier$Node, Boolean> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier$Node modifier$Node2 = modifier$Node; modifier$Node2 != null; modifier$Node2 = modifier$Node2.getChild$ui_release()) {
                    if ((modifier$Node2.getKindSet$ui_release() & i) == 0 || ((Boolean) function1.invoke(modifier$Node2)).booleanValue()) {
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, modifier$Node);
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtreeIf-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m1606visitSubtreeIf6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(delegatableNode, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier$Node modifier$Node2 = modifier$Node; modifier$Node2 != null; modifier$Node2 = modifier$Node2.getChild$ui_release()) {
                    if ((modifier$Node2.getKindSet$ui_release() & i) != 0) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (((Boolean) function1.invoke(modifier$Node2)).booleanValue()) {
                        }
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, modifier$Node);
        }
    }
}
