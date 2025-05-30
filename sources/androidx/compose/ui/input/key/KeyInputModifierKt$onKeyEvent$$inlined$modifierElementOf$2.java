package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$2 extends ModifierNodeElement<KeyInputInputModifierNodeImpl> {
    final /* synthetic */ Function1 $onKeyEvent$inlined;
    final /* synthetic */ Function1 $onKeyEvent$inlined$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$2(Object obj, Function1 function1, Function1 function12, Function1 function13) {
        super(obj, true, function1);
        this.$onKeyEvent$inlined = function12;
        this.$onKeyEvent$inlined$1 = function13;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public KeyInputInputModifierNodeImpl create() {
        return new KeyInputInputModifierNodeImpl(this.$onKeyEvent$inlined, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @NotNull
    public KeyInputInputModifierNodeImpl update(@NotNull KeyInputInputModifierNodeImpl keyInputInputModifierNodeImpl) {
        Intrinsics.checkNotNullParameter(keyInputInputModifierNodeImpl, "node");
        keyInputInputModifierNodeImpl.setOnEvent(this.$onKeyEvent$inlined$1);
        return keyInputInputModifierNodeImpl;
    }
}
