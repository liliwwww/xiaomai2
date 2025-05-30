package androidx.compose.foundation.lazy;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ LazyListPinnableItem $pinnableItem$inlined;

    public LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$1$1$invoke$$inlined$onDispose$1(LazyListPinnableItem lazyListPinnableItem) {
        this.$pinnableItem$inlined = lazyListPinnableItem;
    }

    public void dispose() {
        this.$pinnableItem$inlined.onDisposed();
    }
}
