package androidx.concurrent.futures;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AbstractResolvableFuture$Cancellation {
    static final AbstractResolvableFuture$Cancellation CAUSELESS_CANCELLED;
    static final AbstractResolvableFuture$Cancellation CAUSELESS_INTERRUPTED;

    @Nullable
    final Throwable cause;
    final boolean wasInterrupted;

    static {
        if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
        } else {
            CAUSELESS_CANCELLED = new AbstractResolvableFuture$Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new AbstractResolvableFuture$Cancellation(true, null);
        }
    }

    AbstractResolvableFuture$Cancellation(boolean z, @Nullable Throwable th) {
        this.wasInterrupted = z;
        this.cause = th;
    }
}
