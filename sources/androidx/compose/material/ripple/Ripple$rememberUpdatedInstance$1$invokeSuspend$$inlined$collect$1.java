package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Interaction> {
    final /* synthetic */ CoroutineScope $$this$LaunchedEffect$inlined;
    final /* synthetic */ RippleIndicationInstance $instance$inlined;

    public Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1(RippleIndicationInstance rippleIndicationInstance, CoroutineScope coroutineScope) {
        this.$instance$inlined = rippleIndicationInstance;
        this.$$this$LaunchedEffect$inlined = coroutineScope;
    }

    @Nullable
    public Object emit(Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        Interaction interaction2 = interaction;
        if (interaction2 instanceof PressInteraction.Press) {
            this.$instance$inlined.addRipple((PressInteraction.Press) interaction2, this.$$this$LaunchedEffect$inlined);
        } else if (interaction2 instanceof PressInteraction.Release) {
            this.$instance$inlined.removeRipple(((PressInteraction.Release) interaction2).getPress());
        } else if (interaction2 instanceof PressInteraction.Cancel) {
            this.$instance$inlined.removeRipple(((PressInteraction.Cancel) interaction2).getPress());
        } else {
            this.$instance$inlined.updateStateLayer$material_ripple_release(interaction2, this.$$this$LaunchedEffect$inlined);
        }
        return Unit.INSTANCE;
    }
}
