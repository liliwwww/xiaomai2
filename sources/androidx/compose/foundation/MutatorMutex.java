package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutatorMutex {

    @NotNull
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);

    @NotNull
    private final Mutex mutex = MutexKt.b(false, 1, (Object) null);

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, function1, continuation);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!this.currentMutator.compareAndSet(mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    @Nullable
    public final <R> Object mutate(@NotNull MutatePriority mutatePriority, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1, @NotNull Continuation<? super R> continuation) {
        return i80.g(new mutate.2(mutatePriority, this, function1, (Continuation) null), continuation);
    }

    @Nullable
    public final <T, R> Object mutateWith(T t, @NotNull MutatePriority mutatePriority, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        return i80.g(new MutatorMutex$mutateWith$2(mutatePriority, this, function2, t, null), continuation);
    }
}
