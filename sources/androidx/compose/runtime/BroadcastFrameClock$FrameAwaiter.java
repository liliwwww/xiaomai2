package androidx.compose.runtime;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BroadcastFrameClock$FrameAwaiter<R> {

    @NotNull
    private final Continuation<R> continuation;

    @NotNull
    private final Function1<Long, R> onFrame;

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock$FrameAwaiter(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        Intrinsics.checkNotNullParameter(function1, "onFrame");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.onFrame = function1;
        this.continuation = continuation;
    }

    @NotNull
    public final Continuation<R> getContinuation() {
        return this.continuation;
    }

    @NotNull
    public final Function1<Long, R> getOnFrame() {
        return this.onFrame;
    }

    public final void resume(long j) {
        Object obj;
        Continuation<R> continuation = this.continuation;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(this.onFrame.invoke(Long.valueOf(j)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        continuation.resumeWith(obj);
    }
}
