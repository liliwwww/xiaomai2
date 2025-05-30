package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {

    @NotNull
    private final Continuation<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(@NotNull Continuation<? super T> continuation) {
        super(false);
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // java.util.function.Consumer
    public void accept(T t) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(t));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @NotNull
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
