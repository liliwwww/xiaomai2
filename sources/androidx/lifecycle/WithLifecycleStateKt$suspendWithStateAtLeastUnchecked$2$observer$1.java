package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Function0<R> $block;
    final /* synthetic */ CancellableContinuation<R> $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX WARN: Multi-variable type inference failed */
    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, CancellableContinuation<? super R> cancellableContinuation, Function0<? extends R> function0) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = cancellableContinuation;
        this.$block = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle$Event lifecycle$Event) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(lifecycle$Event, "event");
        if (lifecycle$Event != Lifecycle$Event.Companion.upTo(this.$state)) {
            if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
                CancellableContinuation<R> cancellableContinuation = this.$co;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(new LifecycleDestroyedException())));
                return;
            }
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
        CancellableContinuation<R> cancellableContinuation2 = this.$co;
        Function0<R> function0 = this.$block;
        try {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        cancellableContinuation2.resumeWith(obj);
    }
}
