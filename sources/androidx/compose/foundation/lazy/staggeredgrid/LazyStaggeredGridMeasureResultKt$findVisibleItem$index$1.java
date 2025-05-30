package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1 extends Lambda implements Function1<LazyStaggeredGridItemInfo, Integer> {
    final /* synthetic */ int $itemIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1(int i) {
        super(1);
        this.$itemIndex = i;
    }

    @NotNull
    public final Integer invoke(@NotNull LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridItemInfo, "it");
        return Integer.valueOf(lazyStaggeredGridItemInfo.getIndex() - this.$itemIndex);
    }
}
