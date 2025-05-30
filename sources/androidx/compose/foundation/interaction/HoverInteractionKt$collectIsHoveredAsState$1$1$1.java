package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class HoverInteractionKt$collectIsHoveredAsState$1$1$1 implements FlowCollector<Interaction> {
    final /* synthetic */ List<HoverInteraction.Enter> $hoverInteractions;
    final /* synthetic */ MutableState<Boolean> $isHovered;

    HoverInteractionKt$collectIsHoveredAsState$1$1$1(List<HoverInteraction.Enter> list, MutableState<Boolean> mutableState) {
        this.$hoverInteractions = list;
        this.$isHovered = mutableState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Interaction) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        if (interaction instanceof HoverInteraction.Enter) {
            this.$hoverInteractions.add(interaction);
        } else if (interaction instanceof HoverInteraction$Exit) {
            this.$hoverInteractions.remove(((HoverInteraction$Exit) interaction).getEnter());
        }
        this.$isHovered.setValue(Boxing.boxBoolean(!this.$hoverInteractions.isEmpty()));
        return Unit.INSTANCE;
    }
}
