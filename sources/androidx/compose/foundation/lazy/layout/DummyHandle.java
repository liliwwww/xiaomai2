package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DummyHandle implements LazyLayoutPrefetchState.PrefetchHandle {

    @NotNull
    public static final DummyHandle INSTANCE = new DummyHandle();

    private DummyHandle() {
    }

    public void cancel() {
    }
}
