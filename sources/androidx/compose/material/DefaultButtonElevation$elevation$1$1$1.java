package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
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
final class DefaultButtonElevation$elevation$1$1$1 implements FlowCollector<Interaction> {
    final /* synthetic */ SnapshotStateList<Interaction> $interactions;

    DefaultButtonElevation$elevation$1$1$1(SnapshotStateList<Interaction> snapshotStateList) {
        this.$interactions = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Interaction) obj, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(@NotNull Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        if (interaction instanceof HoverInteraction.Enter) {
            this.$interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.$interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.$interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.$interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof PressInteraction.Press) {
            this.$interactions.add(interaction);
        } else if (interaction instanceof PressInteraction.Release) {
            this.$interactions.remove(((PressInteraction.Release) interaction).getPress());
        } else if (interaction instanceof PressInteraction.Cancel) {
            this.$interactions.remove(((PressInteraction.Cancel) interaction).getPress());
        }
        return Unit.INSTANCE;
    }
}
