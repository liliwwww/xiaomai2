package androidx.compose.ui.modifier;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ModifierLocalNode extends ModifierLocalReadScope, DelegatableNode {
    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal);

    @NotNull
    ModifierLocalMap getProvidedValues();

    <T> void provide(@NotNull ModifierLocal<T> modifierLocal, T t);
}
