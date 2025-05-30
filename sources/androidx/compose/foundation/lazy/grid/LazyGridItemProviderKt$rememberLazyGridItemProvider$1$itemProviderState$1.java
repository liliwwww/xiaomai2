package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyGridItemProviderImpl> {
    final /* synthetic */ State<Function1<LazyGridScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyGridScope, Unit>> state, State<IntRange> state2) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final LazyGridItemProviderImpl m292invoke() {
        LazyGridScopeImpl lazyGridScopeImpl = new LazyGridScopeImpl();
        ((Function1) this.$latestContent.getValue()).invoke(lazyGridScopeImpl);
        return new LazyGridItemProviderImpl(lazyGridScopeImpl.getIntervals$foundation_release(), lazyGridScopeImpl.getHasCustomSpans$foundation_release(), (IntRange) this.$nearestItemsRangeState.getValue());
    }
}
