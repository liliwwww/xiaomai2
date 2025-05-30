package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$3", f = "Button.kt", i = {}, l = {561}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultButtonElevation$elevation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ DefaultButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultButtonElevation$elevation$3(Animatable<Dp, AnimationVector1D> animatable, DefaultButtonElevation defaultButtonElevation, float f, Interaction interaction, Continuation<? super DefaultButtonElevation$elevation$3> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.this$0 = defaultButtonElevation;
        this.$target = f;
        this.$interaction = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultButtonElevation$elevation$3(this.$animatable, this.this$0, this.$target, this.$interaction, continuation);
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
            float f = ((Dp) this.$animatable.getTargetValue()).unbox-impl();
            HoverInteraction.Enter enter = null;
            if (Dp.equals-impl0(f, DefaultButtonElevation.access$getPressedElevation$p(this.this$0))) {
                enter = new PressInteraction$Press(Offset.Companion.m1024getZeroF1C5BW0(), null);
            } else if (Dp.equals-impl0(f, DefaultButtonElevation.access$getHoveredElevation$p(this.this$0))) {
                enter = new HoverInteraction.Enter();
            } else if (Dp.equals-impl0(f, DefaultButtonElevation.access$getFocusedElevation$p(this.this$0))) {
                enter = new FocusInteraction$Focus();
            }
            Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
            float f2 = this.$target;
            Interaction interaction = this.$interaction;
            this.label = 1;
            if (ElevationKt.m747animateElevationrAjV9yQ(animatable, f2, enter, interaction, this) == coroutine_suspended) {
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
