package androidx.core.provider;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RequestExecutor$ReplyRunnable<T> implements Runnable {

    @NonNull
    private Callable<T> mCallable;

    @NonNull
    private Consumer<T> mConsumer;

    @NonNull
    private Handler mHandler;

    RequestExecutor$ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        this.mCallable = callable;
        this.mConsumer = consumer;
        this.mHandler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        final T t;
        try {
            t = this.mCallable.call();
        } catch (Exception unused) {
            t = null;
        }
        final Consumer<T> consumer = this.mConsumer;
        this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor$ReplyRunnable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                consumer.accept(t);
            }
        });
    }
}
