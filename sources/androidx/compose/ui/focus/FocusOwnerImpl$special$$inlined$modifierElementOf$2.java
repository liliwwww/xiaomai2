package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusOwnerImpl$special$$inlined$modifierElementOf$2 extends ModifierNodeElement<FocusTargetModifierNode> {
    final /* synthetic */ FocusOwnerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusOwnerImpl$special$$inlined$modifierElementOf$2(Function1 function1, FocusOwnerImpl focusOwnerImpl) {
        super(null, true, function1);
        this.this$0 = focusOwnerImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public FocusTargetModifierNode create() {
        return this.this$0.getRootFocusNode$ui_release();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public FocusTargetModifierNode update(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
        return focusTargetModifierNode;
    }
}
