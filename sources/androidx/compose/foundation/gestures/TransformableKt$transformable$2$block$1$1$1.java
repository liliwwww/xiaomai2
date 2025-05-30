package androidx.compose.foundation.gestures;

import androidx.appcompat.R;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1$1", f = "Transformable.kt", i = {}, l = {R.styleable.AppCompatTheme_listPreferredItemHeightLarge}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TransformableKt$transformable$2$block$1$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<TransformableState> $updatedState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableKt$transformable$2$block$1$1$1(State<Boolean> state, State<? extends TransformableState> state2, Continuation<? super TransformableKt$transformable$2$block$1$1$1> continuation) {
        super(2, continuation);
        this.$updatePanZoomLock = state;
        this.$updatedState = state2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableKt$transformable$2$block$1$1$1 transformableKt$transformable$2$block$1$1$1 = new TransformableKt$transformable$2$block$1$1$1(this.$updatePanZoomLock, this.$updatedState, continuation);
        transformableKt$transformable$2$block$1$1$1.L$0 = obj;
        return transformableKt$transformable$2$block$1$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object detectZoom;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            State<Boolean> state = this.$updatePanZoomLock;
            State<TransformableState> state2 = this.$updatedState;
            this.label = 1;
            detectZoom = TransformableKt.detectZoom(pointerInputScope, state, state2, this);
            if (detectZoom == coroutine_suspended) {
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
