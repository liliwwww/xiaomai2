package androidx.compose.material.pullrefresh;

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
@DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshKt$pullRefresh$2$2", f = "PullRefresh.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class PullRefreshKt$pullRefresh$2$2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullRefreshState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullRefreshKt$pullRefresh$2$2(PullRefreshState pullRefreshState, Continuation<? super PullRefreshKt$pullRefresh$2$2> continuation) {
        super(2, continuation);
        this.$state = pullRefreshState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PullRefreshKt$pullRefresh$2$2(this.$state, continuation);
    }

    @Nullable
    public final Object invoke(float f, @Nullable Continuation<? super Unit> continuation) {
        return create(Float.valueOf(f), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), (Continuation<? super Unit>) obj2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$state.onRelease$material_release();
        return Unit.INSTANCE;
    }
}
