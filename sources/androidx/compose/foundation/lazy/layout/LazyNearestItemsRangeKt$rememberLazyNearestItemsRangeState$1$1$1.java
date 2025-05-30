package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1$1 extends Lambda implements Function0<IntRange> {
    final /* synthetic */ Function0<Integer> $extraItemCount;
    final /* synthetic */ Function0<Integer> $firstVisibleItemIndex;
    final /* synthetic */ Function0<Integer> $slidingWindowSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1$1(Function0<Integer> function0, Function0<Integer> function02, Function0<Integer> function03) {
        super(0);
        this.$firstVisibleItemIndex = function0;
        this.$slidingWindowSize = function02;
        this.$extraItemCount = function03;
    }

    @NotNull
    public final IntRange invoke() {
        IntRange calculateNearestItemsRange;
        calculateNearestItemsRange = LazyNearestItemsRangeKt.calculateNearestItemsRange(((Number) this.$firstVisibleItemIndex.invoke()).intValue(), ((Number) this.$slidingWindowSize.invoke()).intValue(), ((Number) this.$extraItemCount.invoke()).intValue());
        return calculateNearestItemsRange;
    }
}
