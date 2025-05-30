package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AbstractResolvableFuture$Listener {
    static final AbstractResolvableFuture$Listener TOMBSTONE = new AbstractResolvableFuture$Listener(null, null);
    final Executor executor;

    @Nullable
    AbstractResolvableFuture$Listener next;
    final Runnable task;

    AbstractResolvableFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}
