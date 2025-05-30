package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusRequesterModifierKt$focusRequester$$inlined$modifierElementOf$2 extends ModifierNodeElement<FocusRequesterModifierNodeImpl> {
    final /* synthetic */ FocusRequester $focusRequester$inlined;
    final /* synthetic */ FocusRequester $focusRequester$inlined$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusRequesterModifierKt$focusRequester$$inlined$modifierElementOf$2(Object obj, Function1 function1, FocusRequester focusRequester, FocusRequester focusRequester2) {
        super(obj, true, function1);
        this.$focusRequester$inlined = focusRequester;
        this.$focusRequester$inlined$1 = focusRequester2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public FocusRequesterModifierNodeImpl create() {
        return new FocusRequesterModifierNodeImpl(this.$focusRequester$inlined);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public FocusRequesterModifierNodeImpl update(@NotNull FocusRequesterModifierNodeImpl focusRequesterModifierNodeImpl) {
        Intrinsics.checkNotNullParameter(focusRequesterModifierNodeImpl, "node");
        FocusRequesterModifierNodeImpl focusRequesterModifierNodeImpl2 = focusRequesterModifierNodeImpl;
        focusRequesterModifierNodeImpl2.getFocusRequester().getFocusRequesterNodes$ui_release().remove(focusRequesterModifierNodeImpl2);
        focusRequesterModifierNodeImpl2.setFocusRequester(this.$focusRequester$inlined$1);
        focusRequesterModifierNodeImpl2.getFocusRequester().getFocusRequesterNodes$ui_release().add(focusRequesterModifierNodeImpl2);
        return focusRequesterModifierNodeImpl;
    }
}
