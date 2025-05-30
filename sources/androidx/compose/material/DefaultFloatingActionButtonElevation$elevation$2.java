package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", f = "FloatingActionButton.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DefaultFloatingActionButtonElevation$elevation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultFloatingActionButtonElevation$elevation$2(Animatable<Dp, AnimationVector1D> animatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, float f, Interaction interaction, Continuation<? super DefaultFloatingActionButtonElevation$elevation$2> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.this$0 = defaultFloatingActionButtonElevation;
        this.$target = f;
        this.$interaction = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$2(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float m2156unboximpl = this.$animatable.getTargetValue().m2156unboximpl();
            HoverInteraction.Enter enter = null;
            if (Dp.m2147equalsimpl0(m2156unboximpl, DefaultFloatingActionButtonElevation.access$getPressedElevation$p(this.this$0))) {
                enter = new PressInteraction.Press(Offset.Companion.getZero-F1C5BW0(), (DefaultConstructorMarker) null);
            } else if (Dp.m2147equalsimpl0(m2156unboximpl, DefaultFloatingActionButtonElevation.access$getHoveredElevation$p(this.this$0))) {
                enter = new HoverInteraction.Enter();
            } else if (Dp.m2147equalsimpl0(m2156unboximpl, DefaultFloatingActionButtonElevation.access$getFocusedElevation$p(this.this$0))) {
                enter = new FocusInteraction.Focus();
            }
            Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
            float f = this.$target;
            Interaction interaction = this.$interaction;
            this.label = 1;
            if (ElevationKt.animateElevation-rAjV9yQ(animatable, f, enter, interaction, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
