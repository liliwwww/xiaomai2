package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bb2;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LaunchedEffectImpl implements RememberObserver {

    @Nullable
    private Job job;

    @NotNull
    private final CoroutineScope scope;

    @NotNull
    private final Function2<CoroutineScope, Continuation<? super Unit>, Object> task;

    public LaunchedEffectImpl(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "parentCoroutineContext");
        Intrinsics.checkNotNullParameter(function2, "task");
        this.task = function2;
        this.scope = i80.a(coroutineContext);
    }

    public void onAbandoned() {
        Job job = this.job;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }

    public void onForgotten() {
        Job job = this.job;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }

    public void onRemembered() {
        Job job = this.job;
        if (job != null) {
            bb2.f(job, "Old job was still running!", (Throwable) null, 2, (Object) null);
        }
        this.job = d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, this.task, 3, (Object) null);
    }
}
