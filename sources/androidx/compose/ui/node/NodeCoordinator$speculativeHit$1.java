package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class NodeCoordinator$speculativeHit$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $distanceFromEdge;
    final /* synthetic */ HitTestResult<T> $hitTestResult;
    final /* synthetic */ NodeCoordinator.HitTestSource<T> $hitTestSource;
    final /* synthetic */ boolean $isInLayer;
    final /* synthetic */ boolean $isTouchEvent;
    final /* synthetic */ long $pointerPosition;
    final /* synthetic */ DelegatableNode $this_speculativeHit;
    final /* synthetic */ NodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZF)V */
    NodeCoordinator$speculativeHit$1(NodeCoordinator nodeCoordinator, DelegatableNode delegatableNode, NodeCoordinator.HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        super(0);
        this.this$0 = nodeCoordinator;
        this.$this_speculativeHit = delegatableNode;
        this.$hitTestSource = hitTestSource;
        this.$pointerPosition = j;
        this.$hitTestResult = hitTestResult;
        this.$isTouchEvent = z;
        this.$isInLayer = z2;
        this.$distanceFromEdge = f;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2172invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2172invoke() {
        NodeCoordinator.access$speculativeHit-JHbHoSQ(this.this$0, (DelegatableNode) NodeCoordinatorKt.access$nextUncheckedUntil-hw7D004(this.$this_speculativeHit, this.$hitTestSource.entityType-OLwlOKw(), NodeKind.constructor-impl(2)), this.$hitTestSource, this.$pointerPosition, this.$hitTestResult, this.$isTouchEvent, this.$isInLayer, this.$distanceFromEdge);
    }
}
