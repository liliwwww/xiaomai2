package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SubcomposeLayoutState$setRoot$1 extends Lambda implements Function2<LayoutNode, SubcomposeLayoutState, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setRoot$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (SubcomposeLayoutState) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull SubcomposeLayoutState subcomposeLayoutState) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "it");
        SubcomposeLayoutState subcomposeLayoutState2 = this.this$0;
        LayoutNodeSubcompositionsState subcompositionsState$ui_release = layoutNode.getSubcompositionsState$ui_release();
        if (subcompositionsState$ui_release == null) {
            subcompositionsState$ui_release = new LayoutNodeSubcompositionsState(layoutNode, SubcomposeLayoutState.access$getSlotReusePolicy$p(this.this$0));
            layoutNode.setSubcompositionsState$ui_release(subcompositionsState$ui_release);
        }
        SubcomposeLayoutState.access$set_state$p(subcomposeLayoutState2, subcompositionsState$ui_release);
        SubcomposeLayoutState.access$getState(this.this$0).makeSureStateIsConsistent();
        SubcomposeLayoutState.access$getState(this.this$0).setSlotReusePolicy(SubcomposeLayoutState.access$getSlotReusePolicy$p(this.this$0));
    }
}
