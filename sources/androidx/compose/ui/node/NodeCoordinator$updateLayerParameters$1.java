package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class NodeCoordinator$updateLayerParameters$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<GraphicsLayerScope, Unit> $layerBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NodeCoordinator$updateLayerParameters$1(Function1<? super GraphicsLayerScope, Unit> function1) {
        super(0);
        this.$layerBlock = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2173invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2173invoke() {
        this.$layerBlock.invoke(NodeCoordinator.access$getGraphicsLayerScope$cp());
    }
}
