package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
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
@DebugMetadata(c = "androidx.compose.material.SliderDraggableState$drag$2", f = "Slider.kt", i = {}, l = {1184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SliderDraggableState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $dragPriority;
    int label;
    final /* synthetic */ SliderDraggableState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderDraggableState$drag$2(SliderDraggableState sliderDraggableState, MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SliderDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = sliderDraggableState;
        this.$dragPriority = mutatePriority;
        this.$block = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SliderDraggableState$drag$2(this.this$0, this.$dragPriority, this.$block, continuation);
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
            SliderDraggableState.access$setDragging(this.this$0, true);
            MutatorMutex access$getScrollMutex$p = SliderDraggableState.access$getScrollMutex$p(this.this$0);
            DragScope access$getDragScope$p = SliderDraggableState.access$getDragScope$p(this.this$0);
            MutatePriority mutatePriority = this.$dragPriority;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (access$getScrollMutex$p.mutateWith(access$getDragScope$p, mutatePriority, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SliderDraggableState.access$setDragging(this.this$0, false);
        return Unit.INSTANCE;
    }
}
