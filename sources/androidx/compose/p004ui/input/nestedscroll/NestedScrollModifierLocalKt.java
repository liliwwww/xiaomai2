package androidx.compose.p004ui.input.nestedscroll;

import androidx.compose.p004ui.modifier.ModifierLocalKt;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class NestedScrollModifierLocalKt {

    @NotNull
    private static final ProvidableModifierLocal<NestedScrollModifierLocal> ModifierLocalNestedScroll = ModifierLocalKt.modifierLocalOf(new Function0<NestedScrollModifierLocal>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocalKt$ModifierLocalNestedScroll$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final NestedScrollModifierLocal m3984invoke() {
            return null;
        }
    });

    @NotNull
    public static final ProvidableModifierLocal<NestedScrollModifierLocal> getModifierLocalNestedScroll() {
        return ModifierLocalNestedScroll;
    }
}
