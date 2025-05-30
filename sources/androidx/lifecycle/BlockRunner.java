package androidx.lifecycle;

import androidx.annotation.MainThread;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m11;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class BlockRunner<T> {

    @NotNull
    private final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;

    @Nullable
    private Job cancellationJob;

    @NotNull
    private final CoroutineLiveData<T> liveData;

    @NotNull
    private final Function0<Unit> onDone;

    @Nullable
    private Job runningJob;

    @NotNull
    private final CoroutineScope scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@NotNull CoroutineLiveData<T> coroutineLiveData, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, @NotNull CoroutineScope coroutineScope, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(coroutineLiveData, "liveData");
        Intrinsics.checkNotNullParameter(function2, "block");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "onDone");
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        this.cancellationJob = d.d(this.scope, m11.c().a(), (CoroutineStart) null, new BlockRunner$cancel$1(this, null), 2, (Object) null);
    }

    @MainThread
    public final void maybeRun() {
        Job job = this.cancellationJob;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BlockRunner$maybeRun$1(this, null), 3, (Object) null);
    }
}
