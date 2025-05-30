package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
        MutableVector zSortedChildren = layoutNode.getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = zSortedChildren.getContent();
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
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

    @Nullable
    public static final SemanticsModifierNode getOuterMergingSemantics(@NotNull LayoutNode layoutNode) {
        SemanticsModifierNode semanticsModifierNode;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int m1660constructorimpl = NodeKind.m1660constructorimpl(8);
        if ((nodes$ui_release.getAggregateChildKindSet() & m1660constructorimpl) != 0) {
            semanticsModifierNode = nodes$ui_release.getHead$ui_release();
            while (semanticsModifierNode != null) {
                if ((semanticsModifierNode.getKindSet$ui_release() & m1660constructorimpl) == 0 || !(semanticsModifierNode instanceof SemanticsModifierNode) || !semanticsModifierNode.getSemanticsConfiguration().isMergingSemanticsOfDescendants()) {
                    if ((semanticsModifierNode.getAggregateChildKindSet$ui_release() & m1660constructorimpl) == 0) {
                        break;
                    }
                    semanticsModifierNode = semanticsModifierNode.getChild$ui_release();
                } else {
                    break;
                }
            }
        }
        semanticsModifierNode = null;
        return semanticsModifierNode;
    }

    public static /* synthetic */ void getOuterMergingSemantics$annotations(LayoutNode layoutNode) {
    }

    @Nullable
    public static final SemanticsModifierNode getOuterSemantics(@NotNull LayoutNode layoutNode) {
        Modifier$Node modifier$Node;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int m1660constructorimpl = NodeKind.m1660constructorimpl(8);
        if ((nodes$ui_release.getAggregateChildKindSet() & m1660constructorimpl) != 0) {
            modifier$Node = nodes$ui_release.getHead$ui_release();
            while (modifier$Node != null) {
                if ((modifier$Node.getKindSet$ui_release() & m1660constructorimpl) != 0 && (modifier$Node instanceof SemanticsModifierNode)) {
                    break;
                }
                if ((modifier$Node.getAggregateChildKindSet$ui_release() & m1660constructorimpl) == 0) {
                    break;
                }
                modifier$Node = modifier$Node.getChild$ui_release();
            }
        }
        modifier$Node = null;
        return (SemanticsModifierNode) modifier$Node;
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
