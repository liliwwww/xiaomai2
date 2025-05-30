package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import tb.i80;

/* compiled from: Taobao */
@PublishedApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {

    @NotNull
    private final CoroutineScope coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public void onAbandoned() {
        i80.f(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }

    public void onForgotten() {
        i80.f(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }

    public void onRemembered() {
    }
}
