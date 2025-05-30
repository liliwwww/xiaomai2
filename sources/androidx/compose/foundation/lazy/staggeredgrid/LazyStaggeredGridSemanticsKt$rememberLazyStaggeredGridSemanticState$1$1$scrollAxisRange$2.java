package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.$state = lazyStaggeredGridState;
        this.$itemProvider = lazyLayoutItemProvider;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m333invoke() {
        float firstVisibleItemIndex;
        float firstVisibleItemScrollOffset;
        if (this.$state.getCanScrollForward()) {
            firstVisibleItemIndex = this.$itemProvider.getItemCount();
            firstVisibleItemScrollOffset = 1.0f;
        } else {
            firstVisibleItemIndex = this.$state.getFirstVisibleItemIndex();
            firstVisibleItemScrollOffset = this.$state.getFirstVisibleItemScrollOffset() / 100000.0f;
        }
        return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
    }
}
