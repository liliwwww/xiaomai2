package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1", f = "LazyNearestItemsRange.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Integer> $extraItemCount;
    final /* synthetic */ Function0<Integer> $firstVisibleItemIndex;
    final /* synthetic */ Function0<Integer> $slidingWindowSize;
    final /* synthetic */ MutableState<IntRange> $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1(Function0<Integer> function0, Function0<Integer> function02, Function0<Integer> function03, MutableState<IntRange> mutableState, Continuation<? super LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1> continuation) {
        super(2, continuation);
        this.$firstVisibleItemIndex = function0;
        this.$slidingWindowSize = function02;
        this.$extraItemCount = function03;
        this.$state = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1(this.$firstVisibleItemIndex, this.$slidingWindowSize, this.$extraItemCount, this.$state, continuation);
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
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new 1(this.$firstVisibleItemIndex, this.$slidingWindowSize, this.$extraItemCount));
            2 r1 = new 2(this.$state);
            this.label = 1;
            if (snapshotFlow.collect(r1, this) == coroutine_suspended) {
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
