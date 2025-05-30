package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AbstractResolvableFuture$Waiter {
    static final AbstractResolvableFuture$Waiter TOMBSTONE = new AbstractResolvableFuture$Waiter(false);

    @Nullable
    volatile AbstractResolvableFuture$Waiter next;

    @Nullable
    volatile Thread thread;

    AbstractResolvableFuture$Waiter(boolean z) {
    }

    void setNext(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter) {
        AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, abstractResolvableFuture$Waiter);
    }

    void unpark() {
        Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }

    AbstractResolvableFuture$Waiter() {
        AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
}
