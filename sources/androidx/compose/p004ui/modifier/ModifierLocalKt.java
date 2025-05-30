package androidx.compose.p004ui.modifier;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ModifierLocalKt {
    @NotNull
    public static final <T> ProvidableModifierLocal<T> modifierLocalOf(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
        return new ProvidableModifierLocal<>(function0);
    }
}
