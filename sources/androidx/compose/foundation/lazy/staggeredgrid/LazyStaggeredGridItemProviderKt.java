package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        final State<IntRange> rememberLazyNearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState(new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$1
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1632invoke() {
                return Integer.valueOf(LazyStaggeredGridState.this.getFirstVisibleItemIndex());
            }
        }, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$2
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1633invoke() {
                return 90;
            }
        }, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$nearestItemsRangeState$3
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1634invoke() {
                return 200;
            }
        }, composer, 432);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(lazyStaggeredGridState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            final State derivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @ComposableOpenTarget(index = 0)
                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final LazyLayoutItemProvider m1631invoke() {
                    LazyStaggeredGridScopeImpl lazyStaggeredGridScopeImpl = new LazyStaggeredGridScopeImpl();
                    rememberUpdatedState.getValue().invoke(lazyStaggeredGridScopeImpl);
                    return LazyLayoutItemProviderKt.LazyLayoutItemProvider(lazyStaggeredGridScopeImpl.getIntervals(), rememberLazyNearestItemsRangeState.getValue(), ComposableSingletons$LazyStaggeredGridItemProviderKt.INSTANCE.m1623getLambda1$foundation_release());
                }
            });
            rememberedValue = new LazyLayoutItemProvider(derivedStateOf) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1
                private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

                {
                    this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(derivedStateOf);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                @Composable
                public void Item(int i2, @Nullable Composer composer2, int i3) {
                    composer2.startReplaceableGroup(-1058165788);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1058165788, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<no name provided>.Item (LazyStaggeredGridItemProvider.kt:-1)");
                    }
                    this.$$delegate_0.Item(i2, composer2, i3 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                @Nullable
                public Object getContentType(int i2) {
                    return this.$$delegate_0.getContentType(i2);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                public int getItemCount() {
                    return this.$$delegate_0.getItemCount();
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                @NotNull
                public Object getKey(int i2) {
                    return this.$$delegate_0.getKey(i2);
                }

                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
                @NotNull
                public Map<Object, Integer> getKeyToIndexMap() {
                    return this.$$delegate_0.getKeyToIndexMap();
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        C0545x329c90aa c0545x329c90aa = (C0545x329c90aa) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c0545x329c90aa;
    }
}
