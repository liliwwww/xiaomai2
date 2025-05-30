package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import tb.m11;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {

    @JvmField
    @NotNull
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        if (m11.c().a().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
