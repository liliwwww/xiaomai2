package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.SwipeableV2State$animateTo$2", f = "SwipeableV2.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwipeableV2State$animateTo$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $targetOffset;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$animateTo$2(SwipeableV2State<T> swipeableV2State, float f, float f2, Continuation<? super SwipeableV2State$animateTo$2> continuation) {
        super(2, continuation);
        this.this$0 = swipeableV2State;
        this.$targetOffset = f;
        this.$velocity = f2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SwipeableV2State$animateTo$2 swipeableV2State$animateTo$2 = new SwipeableV2State$animateTo$2(this.this$0, this.$targetOffset, this.$velocity, continuation);
        swipeableV2State$animateTo$2.L$0 = obj;
        return swipeableV2State$animateTo$2;
    }

    @Nullable
    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
        return create(dragScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableState mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DragScope dragScope = (DragScope) this.L$0;
                this.this$0.setAnimationRunning(true);
                Ref.FloatRef floatRef = new Ref.FloatRef();
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                float floatValue = ((Number) mutableState.getValue()).floatValue();
                floatRef.element = floatValue;
                float f = this.$targetOffset;
                float f2 = this.$velocity;
                AnimationSpec<Float> animationSpec = this.this$0.getAnimationSpec();
                1 r9 = new 1(dragScope, floatRef, this.this$0);
                this.label = 1;
                if (SuspendAnimationKt.animate(floatValue, f, f2, animationSpec, r9, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.setAnimationRunning(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.setAnimationRunning(false);
            throw th;
        }
    }
}
