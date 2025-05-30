package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CallbackToFutureAdapter$Completer<T> {
    private boolean attemptedSetting;
    private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
    CallbackToFutureAdapter$SafeFuture<T> future;
    Object tag;

    CallbackToFutureAdapter$Completer() {
    }

    private void setCompletedNormally() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture = null;
    }

    public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(runnable, executor);
        }
    }

    protected void finalize() {
        ResolvableFuture<Void> resolvableFuture;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null && !callbackToFutureAdapter$SafeFuture.isDone()) {
            callbackToFutureAdapter$SafeFuture.setException(new CallbackToFutureAdapter.FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
        }
        if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
            return;
        }
        resolvableFuture.set(null);
    }

    void fireCancellationListeners() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture.set(null);
    }

    public boolean set(T t) {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.set(t);
        if (z) {
            setCompletedNormally();
        }
        return z;
    }

    public boolean setCancelled() {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.cancelWithoutNotifyingCompleter(true);
        if (z) {
            setCompletedNormally();
        }
        return z;
    }

    public boolean setException(@NonNull Throwable th) {
        this.attemptedSetting = true;
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = this.future;
        boolean z = callbackToFutureAdapter$SafeFuture != null && callbackToFutureAdapter$SafeFuture.setException(th);
        if (z) {
            setCompletedNormally();
        }
        return z;
    }
}
