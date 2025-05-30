package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface MutableInteractionSource extends InteractionSource {
    @Nullable
    Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation);

    boolean tryEmit(@NotNull Interaction interaction);
}
