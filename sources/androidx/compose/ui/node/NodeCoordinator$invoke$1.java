package androidx.compose.ui.node;

import androidx.compose.ui.graphics.Canvas;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class NodeCoordinator$invoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ NodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NodeCoordinator$invoke$1(NodeCoordinator nodeCoordinator, Canvas canvas) {
        super(0);
        this.this$0 = nodeCoordinator;
        this.$canvas = canvas;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2171invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2171invoke() {
        NodeCoordinator.access$drawContainedDrawModifiers(this.this$0, this.$canvas);
    }
}
