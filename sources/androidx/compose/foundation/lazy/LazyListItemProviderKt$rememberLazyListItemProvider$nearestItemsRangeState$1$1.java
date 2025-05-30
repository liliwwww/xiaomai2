package androidx.compose.foundation.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyListState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1(LazyListState lazyListState) {
        super(0);
        this.$state = lazyListState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m426invoke() {
        return Integer.valueOf(this.$state.getFirstVisibleItemIndex());
    }
}
