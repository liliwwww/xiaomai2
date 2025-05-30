package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$1$1(LazyGridState lazyGridState) {
        super(0);
        this.$state = lazyGridState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m293invoke() {
        return Integer.valueOf(this.$state.getFirstVisibleItemIndex());
    }
}
