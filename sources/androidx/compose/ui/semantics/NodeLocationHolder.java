package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dd2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NodeLocationHolder implements Comparable<NodeLocationHolder> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static ComparisonStrategy comparisonStrategy = ComparisonStrategy.Stripe;

    @NotNull
    private final LayoutDirection layoutDirection;

    @Nullable
    private final Rect location;

    @NotNull
    private final LayoutNode node;

    @NotNull
    private final LayoutNode subtreeRoot;

    /* compiled from: Taobao */
    public enum ComparisonStrategy {
        Stripe,
        Location
    }

    public NodeLocationHolder(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode, "subtreeRoot");
        Intrinsics.checkNotNullParameter(layoutNode2, "node");
        this.subtreeRoot = layoutNode;
        this.node = layoutNode2;
        this.layoutDirection = layoutNode.getLayoutDirection();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        NodeCoordinator findCoordinatorToGetBounds = SemanticsSortKt.findCoordinatorToGetBounds(layoutNode2);
        Rect rect = null;
        if (innerCoordinator$ui_release.isAttached() && findCoordinatorToGetBounds.isAttached()) {
            rect = dd2.c(innerCoordinator$ui_release, findCoordinatorToGetBounds, false, 2, (Object) null);
        }
        this.location = rect;
    }

    @NotNull
    public final LayoutNode getNode$ui_release() {
        return this.node;
    }

    @NotNull
    public final LayoutNode getSubtreeRoot$ui_release() {
        return this.subtreeRoot;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull NodeLocationHolder nodeLocationHolder) {
        Intrinsics.checkNotNullParameter(nodeLocationHolder, "other");
        Rect rect = this.location;
        if (rect == null) {
            return 1;
        }
        if (nodeLocationHolder.location == null) {
            return -1;
        }
        if (comparisonStrategy == ComparisonStrategy.Stripe) {
            if (rect.getBottom() - nodeLocationHolder.location.getTop() <= 0.0f) {
                return -1;
            }
            if (this.location.getTop() - nodeLocationHolder.location.getBottom() >= 0.0f) {
                return 1;
            }
        }
        if (this.layoutDirection == LayoutDirection.Ltr) {
            float left = this.location.getLeft() - nodeLocationHolder.location.getLeft();
            if (!(left == 0.0f)) {
                return left < 0.0f ? -1 : 1;
            }
        } else {
            float right = this.location.getRight() - nodeLocationHolder.location.getRight();
            if (!(right == 0.0f)) {
                return right < 0.0f ? 1 : -1;
            }
        }
        float top = this.location.getTop() - nodeLocationHolder.location.getTop();
        if (!(top == 0.0f)) {
            return top < 0.0f ? -1 : 1;
        }
        final Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(this.node));
        final Rect boundsInRoot2 = LayoutCoordinatesKt.boundsInRoot(SemanticsSortKt.findCoordinatorToGetBounds(nodeLocationHolder.node));
        LayoutNode findNodeByPredicateTraversal = SemanticsSortKt.findNodeByPredicateTraversal(this.node, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.NodeLocationHolder$compareTo$child1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "it");
                NodeCoordinator findCoordinatorToGetBounds = SemanticsSortKt.findCoordinatorToGetBounds(layoutNode);
                return Boolean.valueOf(findCoordinatorToGetBounds.isAttached() && !Intrinsics.areEqual(boundsInRoot, LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds)));
            }
        });
        LayoutNode findNodeByPredicateTraversal2 = SemanticsSortKt.findNodeByPredicateTraversal(nodeLocationHolder.node, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.NodeLocationHolder$compareTo$child2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "it");
                NodeCoordinator findCoordinatorToGetBounds = SemanticsSortKt.findCoordinatorToGetBounds(layoutNode);
                return Boolean.valueOf(findCoordinatorToGetBounds.isAttached() && !Intrinsics.areEqual(boundsInRoot2, LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds)));
            }
        });
        if (findNodeByPredicateTraversal != null && findNodeByPredicateTraversal2 != null) {
            return new NodeLocationHolder(this.subtreeRoot, findNodeByPredicateTraversal).compareTo(new NodeLocationHolder(nodeLocationHolder.subtreeRoot, findNodeByPredicateTraversal2));
        }
        if (findNodeByPredicateTraversal != null) {
            return 1;
        }
        if (findNodeByPredicateTraversal2 != null) {
            return -1;
        }
        int compare = LayoutNode.Companion.getZComparator$ui_release().compare(this.node, nodeLocationHolder.node);
        return compare != 0 ? -compare : this.node.getSemanticsId() - nodeLocationHolder.node.getSemanticsId();
    }
}
