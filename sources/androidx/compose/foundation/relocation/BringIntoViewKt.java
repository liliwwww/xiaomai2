package androidx.compose.foundation.relocation;

import androidx.compose.p004ui.modifier.ModifierLocalKt;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class BringIntoViewKt {

    @NotNull
    private static final ProvidableModifierLocal<BringIntoViewParent> ModifierLocalBringIntoViewParent = ModifierLocalKt.modifierLocalOf(new Function0<BringIntoViewParent>() { // from class: androidx.compose.foundation.relocation.BringIntoViewKt$ModifierLocalBringIntoViewParent$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BringIntoViewParent m1660invoke() {
            return null;
        }
    });

    @NotNull
    public static final ProvidableModifierLocal<BringIntoViewParent> getModifierLocalBringIntoViewParent() {
        return ModifierLocalBringIntoViewParent;
    }

    public static /* synthetic */ void getModifierLocalBringIntoViewParent$annotations() {
    }
}
