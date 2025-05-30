package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3", f = "Draggable.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DraggableKt$draggable$9$3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
    final /* synthetic */ Channel<DragEvent> $channel;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$9$3(boolean z, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z2, Continuation<? super DraggableKt$draggable$9$3> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$canDragState = state;
        this.$startImmediatelyState = state2;
        this.$orientation = orientation;
        this.$channel = channel;
        this.$reverseDirection = z2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DraggableKt$draggable$9$3 draggableKt$draggable$9$3 = new DraggableKt$draggable$9$3(this.$enabled, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
        draggableKt$draggable$9$3.L$0 = obj;
        return draggableKt$draggable$9$3;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.$enabled) {
                return Unit.INSTANCE;
            }
            1 r12 = new 1(pointerInputScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, (Continuation) null);
            this.label = 1;
            if (i80.g(r12, this) == coroutine_suspended) {
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
