package androidx.compose.foundation.relocation;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BringIntoViewKt {

    @NotNull
    private static final ProvidableModifierLocal<BringIntoViewParent> ModifierLocalBringIntoViewParent = ModifierLocalKt.modifierLocalOf(ModifierLocalBringIntoViewParent.1.INSTANCE);

    @NotNull
    public static final ProvidableModifierLocal<BringIntoViewParent> getModifierLocalBringIntoViewParent() {
        return ModifierLocalBringIntoViewParent;
    }

    public static /* synthetic */ void getModifierLocalBringIntoViewParent$annotations() {
    }
}
