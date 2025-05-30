package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SubcomposeLayoutState$setCompositionContext$1 extends Lambda implements Function2<LayoutNode, CompositionContext, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setCompositionContext$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (CompositionContext) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull CompositionContext compositionContext) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$null");
        Intrinsics.checkNotNullParameter(compositionContext, "it");
        SubcomposeLayoutState.access$getState(this.this$0).setCompositionContext(compositionContext);
    }
}
