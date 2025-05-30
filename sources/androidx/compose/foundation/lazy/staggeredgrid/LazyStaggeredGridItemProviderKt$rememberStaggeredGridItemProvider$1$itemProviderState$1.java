package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.staggeredgrid.ComposableSingletons;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyLayoutItemProvider> {
    final /* synthetic */ State<Function1<LazyStaggeredGridScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyStaggeredGridScope, Unit>> state, State<IntRange> state2) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
    }

    @ComposableOpenTarget(index = 0)
    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final LazyLayoutItemProvider m499invoke() {
        LazyStaggeredGridScopeImpl lazyStaggeredGridScopeImpl = new LazyStaggeredGridScopeImpl();
        this.$latestContent.getValue().invoke(lazyStaggeredGridScopeImpl);
        return LazyLayoutItemProviderKt.LazyLayoutItemProvider(lazyStaggeredGridScopeImpl.getIntervals(), this.$nearestItemsRangeState.getValue(), ComposableSingletons.LazyStaggeredGridItemProviderKt.INSTANCE.getLambda-1$foundation_release());
    }
}
