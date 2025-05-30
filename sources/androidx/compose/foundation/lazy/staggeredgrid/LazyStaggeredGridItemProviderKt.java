package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyStaggeredGridItemProviderKt {
    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final LazyLayoutItemProvider rememberStaggeredGridItemProvider(@NotNull final LazyStaggeredGridState lazyStaggeredGridState, @NotNull Function1<? super LazyStaggeredGridScope, Unit> function1, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(function1, "content");
        composer.startReplaceableGroup(290499291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290499291, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider (LazyStaggeredGridItemProvider.kt:29)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        State<IntRange> rememberLazyNearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState(new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m328invoke() {
                return Integer.valueOf(LazyStaggeredGridState.this.getFirstVisibleItemIndex());
            }
        }, rememberStaggeredGridItemProvider.nearestItemsRangeState.2.INSTANCE, rememberStaggeredGridItemProvider.nearestItemsRangeState.3.INSTANCE, composer, 432);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(lazyStaggeredGridState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new rememberStaggeredGridItemProvider.1.1(SnapshotStateKt.derivedStateOf(new rememberStaggeredGridItemProvider.1.itemProviderState.1(rememberUpdatedState, rememberLazyNearestItemsRangeState)));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        rememberStaggeredGridItemProvider.1.1 r0 = (rememberStaggeredGridItemProvider.1.1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
