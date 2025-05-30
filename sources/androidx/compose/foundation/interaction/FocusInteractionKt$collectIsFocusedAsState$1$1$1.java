package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FocusInteractionKt$collectIsFocusedAsState$1$1$1 implements FlowCollector<Interaction> {
    final /* synthetic */ List<FocusInteraction.Focus> $focusInteractions;
    final /* synthetic */ MutableState<Boolean> $isFocused;

    FocusInteractionKt$collectIsFocusedAsState$1$1$1(List<FocusInteraction.Focus> list, MutableState<Boolean> mutableState) {
        this.$focusInteractions = list;
        this.$isFocused = mutableState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Interaction) obj, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        if (interaction instanceof FocusInteraction.Focus) {
            this.$focusInteractions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.$focusInteractions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        }
        this.$isFocused.setValue(Boxing.boxBoolean(!this.$focusInteractions.isEmpty()));
        return Unit.INSTANCE;
    }
}
