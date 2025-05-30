package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class NodeCoordinator$Companion$onCommitAffectingLayerParams$1 extends Lambda implements Function1<NodeCoordinator, Unit> {
    public static final NodeCoordinator$Companion$onCommitAffectingLayerParams$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayerParams$1();

    NodeCoordinator$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NodeCoordinator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        if (nodeCoordinator.isValid()) {
            LayerPositionalProperties access$getLayerPositionalProperties$p = NodeCoordinator.access$getLayerPositionalProperties$p(nodeCoordinator);
            if (access$getLayerPositionalProperties$p == null) {
                NodeCoordinator.access$updateLayerParameters(nodeCoordinator);
                return;
            }
            NodeCoordinator.access$getTmpLayerPositionalProperties$cp().copyFrom(access$getLayerPositionalProperties$p);
            NodeCoordinator.access$updateLayerParameters(nodeCoordinator);
            if (NodeCoordinator.access$getTmpLayerPositionalProperties$cp().hasSameValuesAs(access$getLayerPositionalProperties$p)) {
                return;
            }
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
            if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            }
            Owner owner$ui_release = layoutNode.getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.requestOnPositionedCallback(layoutNode);
            }
        }
    }
}
