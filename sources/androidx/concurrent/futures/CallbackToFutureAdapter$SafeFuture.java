package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CallbackToFutureAdapter$SafeFuture<T> implements ListenableFuture<T> {
    final WeakReference<CallbackToFutureAdapter$Completer<T>> completerWeakReference;
    private final AbstractResolvableFuture<T> delegate = new 1(this);

    CallbackToFutureAdapter$SafeFuture(CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer) {
        this.completerWeakReference = new WeakReference<>(callbackToFutureAdapter$Completer);
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        CallbackToFutureAdapter$Completer<T> callbackToFutureAdapter$Completer = this.completerWeakReference.get();
        boolean cancel = this.delegate.cancel(z);
        if (cancel && callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.fireCancellationListeners();
        }
        return cancel;
    }

    boolean cancelWithoutNotifyingCompleter(boolean z) {
        return this.delegate.cancel(z);
    }

    public T get() throws InterruptedException, ExecutionException {
        return (T) this.delegate.get();
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    boolean set(T t) {
        return this.delegate.set(t);
    }

    boolean setException(Throwable th) {
        return this.delegate.setException(th);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public T get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.get(j, timeUnit);
    }
}
