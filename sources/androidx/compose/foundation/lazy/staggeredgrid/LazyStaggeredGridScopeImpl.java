package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyStaggeredGridScopeImpl implements LazyStaggeredGridScope {

    @NotNull
    private final MutableIntervalList<LazyStaggeredGridIntervalContent> intervals = new MutableIntervalList<>();

    @NotNull
    public final MutableIntervalList<LazyStaggeredGridIntervalContent> getIntervals() {
        return this.intervals;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
    @ExperimentalFoundationApi
    public void item(@Nullable Object obj, @Nullable final Object obj2, @NotNull final Function3<? super LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        items(1, obj != null ? new item.1.1(obj) : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScopeImpl$item$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return invoke(((Number) obj3).intValue());
            }

            @Nullable
            public final Object invoke(int i) {
                return obj2;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2037756640, true, new Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScopeImpl$item$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((LazyStaggeredGridItemScope) obj3, ((Number) obj4).intValue(), (Composer) obj5, ((Number) obj6).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@NotNull LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, @Nullable Composer composer, int i2) {
                Intrinsics.checkNotNullParameter(lazyStaggeredGridItemScope, "$this$items");
                if ((i2 & 14) == 0) {
                    i2 |= composer.changed(lazyStaggeredGridItemScope) ? 4 : 2;
                }
                if ((i2 & 651) == 130 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2037756640, i2, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScopeImpl.item.<anonymous> (LazyStaggeredGridScope.kt:37)");
                }
                function3.invoke(lazyStaggeredGridItemScope, composer, Integer.valueOf(i2 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
    public void items(int i, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        this.intervals.addInterval(i, new LazyStaggeredGridIntervalContent(function1, function12, function4));
    }
}
