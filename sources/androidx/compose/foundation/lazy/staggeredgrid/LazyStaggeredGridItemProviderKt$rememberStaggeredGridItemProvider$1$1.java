package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1 implements LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

    LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1(State<? extends LazyLayoutItemProvider> state) {
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(state);
    }

    @Composable
    public void Item(int i, @Nullable Composer composer, int i2) {
        composer.startReplaceableGroup(-1058165788);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1058165788, i2, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<no name provided>.Item (LazyStaggeredGridItemProvider.kt:-1)");
        }
        this.$$delegate_0.Item(i, composer, i2 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Nullable
    public Object getContentType(int i) {
        return this.$$delegate_0.getContentType(i);
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    @NotNull
    public Object getKey(int i) {
        return this.$$delegate_0.getKey(i);
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }
}
