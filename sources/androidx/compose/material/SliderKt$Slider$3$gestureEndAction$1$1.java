package androidx.compose.material;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$Slider$3$gestureEndAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $current;
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ float $target;
    final /* synthetic */ float $velocity;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3$gestureEndAction$1$1(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super SliderKt$Slider$3$gestureEndAction$1$1> continuation) {
        super(2, continuation);
        this.$draggableState = sliderDraggableState;
        this.$current = f;
        this.$target = f2;
        this.$velocity = f3;
        this.$onValueChangeFinished = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SliderKt$Slider$3$gestureEndAction$1$1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
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
            SliderDraggableState sliderDraggableState = this.$draggableState;
            float f = this.$current;
            float f2 = this.$target;
            float f3 = this.$velocity;
            this.label = 1;
            if (SliderKt.access$animateToTarget(sliderDraggableState, f, f2, f3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Function0<Unit> function0 = this.$onValueChangeFinished;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
