package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyLayoutPrefetchState {

    @NotNull
    private final MutableState prefetcher$delegate;

    /* compiled from: Taobao */
    public interface Prefetcher {
        @NotNull
        /* renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        PrefetchHandle mo491schedulePrefetch0kLqBqw(int i, long j);
    }

    public LazyLayoutPrefetchState() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.prefetcher$delegate = mutableStateOf$default;
    }

    @Nullable
    public final Prefetcher getPrefetcher$foundation_release() {
        return (Prefetcher) this.prefetcher$delegate.getValue();
    }

    @NotNull
    /* renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m490schedulePrefetch0kLqBqw(int i, long j) {
        PrefetchHandle mo491schedulePrefetch0kLqBqw;
        Prefetcher prefetcher$foundation_release = getPrefetcher$foundation_release();
        return (prefetcher$foundation_release == null || (mo491schedulePrefetch0kLqBqw = prefetcher$foundation_release.mo491schedulePrefetch0kLqBqw(i, j)) == null) ? DummyHandle.INSTANCE : mo491schedulePrefetch0kLqBqw;
    }

    public final void setPrefetcher$foundation_release(@Nullable Prefetcher prefetcher) {
        this.prefetcher$delegate.setValue(prefetcher);
    }
}
