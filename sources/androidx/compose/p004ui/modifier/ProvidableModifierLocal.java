package androidx.compose.p004ui.modifier;

import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public final class ProvidableModifierLocal<T> extends ModifierLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableModifierLocal(@NotNull Function0<? extends T> function0) {
        super(function0, null);
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
    }
}
