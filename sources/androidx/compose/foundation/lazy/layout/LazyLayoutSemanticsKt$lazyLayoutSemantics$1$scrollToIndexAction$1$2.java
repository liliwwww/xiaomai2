package androidx.compose.foundation.lazy.layout;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", f = "LazyLayoutSemantics.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ LazyLayoutSemanticState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2(LazyLayoutSemanticState lazyLayoutSemanticState, int i, Continuation<? super LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2> continuation) {
        super(2, continuation);
        this.$state = lazyLayoutSemanticState;
        this.$index = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2(this.$state, this.$index, continuation);
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
            LazyLayoutSemanticState lazyLayoutSemanticState = this.$state;
            int i2 = this.$index;
            this.label = 1;
            if (lazyLayoutSemanticState.scrollToItem(i2, this) == coroutine_suspended) {
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
