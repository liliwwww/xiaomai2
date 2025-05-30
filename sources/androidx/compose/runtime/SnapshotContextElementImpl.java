package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SnapshotContextElementImpl implements SnapshotContextElement, ThreadContextElement<Snapshot> {

    @NotNull
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return SnapshotContextElement.Key;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return SnapshotContextElement.DefaultImpls.plus(this, coroutineContext);
    }

    public void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @Nullable Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        this.snapshot.unsafeLeave(snapshot);
    }

    @Nullable
    /* renamed from: updateThreadContext, reason: merged with bridge method [inline-methods] */
    public Snapshot m915updateThreadContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return this.snapshot.unsafeEnter();
    }
}
