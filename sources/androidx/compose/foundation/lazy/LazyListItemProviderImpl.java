package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyListItemProviderImpl implements LazyListItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

    @NotNull
    private final List<Integer> headerIndexes;

    @NotNull
    private final LazyItemScopeImpl itemScope;

    public LazyListItemProviderImpl(@NotNull IntervalList<LazyListIntervalContent> intervalList, @NotNull IntRange intRange, @NotNull List<Integer> list, @NotNull final LazyItemScopeImpl lazyItemScopeImpl, @NotNull final LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        Intrinsics.checkNotNullParameter(list, "headerIndexes");
        Intrinsics.checkNotNullParameter(lazyItemScopeImpl, "itemScope");
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        this.headerIndexes = list;
        this.itemScope = lazyItemScopeImpl;
        this.$$delegate_0 = LazyLayoutItemProviderKt.LazyLayoutItemProvider(intervalList, intRange, ComposableLambdaKt.composableLambdaInstance(2070454083, true, new Function4<IntervalList.Interval<? extends LazyListIntervalContent>, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((IntervalList.Interval<LazyListIntervalContent>) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@NotNull final IntervalList.Interval<LazyListIntervalContent> interval, final int i, @Nullable Composer composer, int i2) {
                int i3;
                Intrinsics.checkNotNullParameter(interval, "interval");
                if ((i2 & 14) == 0) {
                    i3 = (composer.changed(interval) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 112) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if ((i3 & 731) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2070454083, i3, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.$$delegate_0.<anonymous> (LazyListItemProvider.kt:80)");
                }
                LazyListState lazyListState2 = lazyListState;
                final LazyItemScopeImpl lazyItemScopeImpl2 = lazyItemScopeImpl;
                LazyListPinnableContainerProviderKt.LazyListPinnableContainerProvider(lazyListState2, i, ComposableLambdaKt.composableLambda(composer, -1137011645, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i4) {
                        if ((i4 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1137011645, i4, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.$$delegate_0.<anonymous>.<anonymous> (LazyListItemProvider.kt:81)");
                        }
                        interval.getValue().getItem().invoke(lazyItemScopeImpl2, Integer.valueOf(i - interval.getStartIndex()), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer, (i3 & 112) | 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @Composable
    public void Item(final int i, @Nullable Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1645068522);
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645068522, i3, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:-1)");
            }
            this.$$delegate_0.Item(i, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                LazyListItemProviderImpl.this.Item(i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @Nullable
    public Object getContentType(int i) {
        return this.$$delegate_0.getContentType(i);
    }

    @NotNull
    public List<Integer> getHeaderIndexes() {
        return this.headerIndexes;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    @NotNull
    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @NotNull
    public Object getKey(int i) {
        return this.$$delegate_0.getKey(i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }
}
