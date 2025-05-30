package androidx.compose.p004ui.modifier;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface ModifierLocalNode extends ModifierLocalReadScope, DelegatableNode {
    @Override // androidx.compose.p004ui.modifier.ModifierLocalReadScope
    <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal);

    @NotNull
    ModifierLocalMap getProvidedValues();

    <T> void provide(@NotNull ModifierLocal<T> modifierLocal, T t);
}
