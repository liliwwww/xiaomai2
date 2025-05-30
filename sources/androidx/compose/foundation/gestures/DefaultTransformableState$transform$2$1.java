package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1", f = "TransformableState.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultTransformableState$transform$2$1 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TransformScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultTransformableState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultTransformableState$transform$2$1(DefaultTransformableState defaultTransformableState, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultTransformableState$transform$2$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultTransformableState;
        this.$block = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DefaultTransformableState$transform$2$1 defaultTransformableState$transform$2$1 = new DefaultTransformableState$transform$2$1(this.this$0, this.$block, continuation);
        defaultTransformableState$transform$2$1.L$0 = obj;
        return defaultTransformableState$transform$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return create(transformScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                mutableState2 = this.this$0.isTransformingState;
                mutableState2.setValue(Boxing.boxBoolean(true));
                Function2<TransformScope, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (function2.invoke(transformScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            mutableState3 = this.this$0.isTransformingState;
            mutableState3.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableState = this.this$0.isTransformingState;
            mutableState.setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }
}
