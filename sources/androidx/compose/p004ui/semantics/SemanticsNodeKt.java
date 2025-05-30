package androidx.compose.p004ui.semantics;

import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.NodeChain;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.node.SemanticsModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SemanticsNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (((Boolean) function1.invoke(parent$ui_release)).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    private static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsModifierNode> list) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = zSortedChildren.getContent();
            do {
                LayoutNode layoutNode2 = content[i];
                SemanticsModifierNode outerSemantics = getOuterSemantics(layoutNode2);
                if (outerSemantics != null) {
                    list.add(outerSemantics);
                } else {
                    findOneLayerOfSemanticsWrappers(layoutNode2, list);
                }
                i++;
            } while (i < size);
        }
        return list;
    }

    static /* synthetic */ List findOneLayerOfSemanticsWrappers$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappers(layoutNode, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Nullable
    public static final SemanticsModifierNode getOuterMergingSemantics(@NotNull LayoutNode layoutNode) {
        SemanticsModifierNode semanticsModifierNode;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int m4398constructorimpl = NodeKind.m4398constructorimpl(8);
        if ((nodes$ui_release.getAggregateChildKindSet() & m4398constructorimpl) != 0) {
            semanticsModifierNode = nodes$ui_release.getHead$ui_release();
            while (semanticsModifierNode != 0) {
                if ((semanticsModifierNode.getKindSet$ui_release() & m4398constructorimpl) == 0 || !(semanticsModifierNode instanceof SemanticsModifierNode) || !semanticsModifierNode.getSemanticsConfiguration().isMergingSemanticsOfDescendants()) {
                    if ((semanticsModifierNode.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                        break;
                    }
                    semanticsModifierNode = semanticsModifierNode.getChild$ui_release();
                } else {
                    break;
                }
            }
        }
        semanticsModifierNode = 0;
        return (SemanticsModifierNode) semanticsModifierNode;
    }

    public static /* synthetic */ void getOuterMergingSemantics$annotations(LayoutNode layoutNode) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Nullable
    public static final SemanticsModifierNode getOuterSemantics(@NotNull LayoutNode layoutNode) {
        ?? r2;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int m4398constructorimpl = NodeKind.m4398constructorimpl(8);
        if ((nodes$ui_release.getAggregateChildKindSet() & m4398constructorimpl) != 0) {
            r2 = nodes$ui_release.getHead$ui_release();
            while (r2 != 0) {
                if ((r2.getKindSet$ui_release() & m4398constructorimpl) != 0 && (r2 instanceof SemanticsModifierNode)) {
                    break;
                }
                if ((r2.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                    break;
                }
                r2 = r2.getChild$ui_release();
            }
        }
        r2 = 0;
        return (SemanticsModifierNode) r2;
    }

    public static /* synthetic */ void getOuterSemantics$annotations(LayoutNode layoutNode) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
