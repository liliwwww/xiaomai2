package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.$state = lazyStaggeredGridState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m332invoke() {
        return Float.valueOf(this.$state.getFirstVisibleItemIndex() + (this.$state.getFirstVisibleItemScrollOffset() / 100000.0f));
    }
}
