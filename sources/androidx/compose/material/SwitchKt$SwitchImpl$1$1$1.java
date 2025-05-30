package androidx.compose.material;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwitchKt$SwitchImpl$1$1$1 implements FlowCollector<Interaction> {
    final /* synthetic */ SnapshotStateList<Interaction> $interactions;

    SwitchKt$SwitchImpl$1$1$1(SnapshotStateList<Interaction> snapshotStateList) {
        this.$interactions = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Interaction) obj, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        if (interaction instanceof PressInteraction.Press) {
            this.$interactions.add(interaction);
        } else if (interaction instanceof PressInteraction.Release) {
            this.$interactions.remove(((PressInteraction.Release) interaction).getPress());
        } else if (interaction instanceof PressInteraction.Cancel) {
            this.$interactions.remove(((PressInteraction.Cancel) interaction).getPress());
        } else if (interaction instanceof DragInteraction.Start) {
            this.$interactions.add(interaction);
        } else if (interaction instanceof DragInteraction$Stop) {
            this.$interactions.remove(((DragInteraction$Stop) interaction).getStart());
        } else if (interaction instanceof DragInteraction$Cancel) {
            this.$interactions.remove(((DragInteraction$Cancel) interaction).getStart());
        }
        return Unit.INSTANCE;
    }
}
