package androidx.lifecycle;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tb.bb2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {

    @NotNull
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.coroutineContext = coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bb2.e(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
