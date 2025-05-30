package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bz4;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MutableInteractionSourceImpl implements MutableInteractionSource {

    @NotNull
    private final MutableSharedFlow<Interaction> interactions = bz4.b(0, 16, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    @Nullable
    public Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        Object emit = getInteractions().emit(interaction, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public boolean tryEmit(@NotNull Interaction interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        return getInteractions().tryEmit(interaction);
    }

    @NotNull
    public MutableSharedFlow<Interaction> getInteractions() {
        return this.interactions;
    }
}
