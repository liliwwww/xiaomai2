package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {

    @NotNull
    private final IntervalList<IntervalContent> intervals;

    @NotNull
    private final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> itemContentProvider;

    @NotNull
    private final Map<Object, Integer> keyToIndexMap;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultLazyLayoutItemsProvider(@NotNull Function4<? super IntervalList.Interval<? extends IntervalContent>, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @NotNull IntervalList<? extends IntervalContent> intervalList, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(function4, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        this.itemContentProvider = function4;
        this.intervals = intervalList;
        this.keyToIndexMap = generateKeyToIndexMap(intRange, intervalList);
    }

    @ExperimentalFoundationApi
    private final Map<Object, Integer> generateKeyToIndexMap(IntRange intRange, IntervalList<? extends LazyLayoutIntervalContent> intervalList) {
        int first = intRange.getFirst();
        if (!(first >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int min = Math.min(intRange.getLast(), intervalList.getSize() - 1);
        if (min < first) {
            return MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        intervalList.forEach(first, min, new generateKeyToIndexMap.1.1(first, min, hashMap));
        return hashMap;
    }

    private final <T> T withLocalIntervalIndex(int i, Function2<? super Integer, ? super IntervalContent, ? extends T> function2) {
        IntervalList.Interval interval = this.intervals.get(i);
        return (T) function2.invoke(Integer.valueOf(i - interval.getStartIndex()), interval.getValue());
    }

    @Composable
    public void Item(final int i, @Nullable Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1877726744);
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
                ComposerKt.traceEventStart(-1877726744, i3, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:116)");
            }
            this.itemContentProvider.invoke(this.intervals.get(i), Integer.valueOf(i), startRestartGroup, Integer.valueOf((i3 << 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider$Item$1
            final /* synthetic */ DefaultLazyLayoutItemsProvider<IntervalContent> $tmp0_rcvr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$tmp0_rcvr = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                this.$tmp0_rcvr.Item(i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
            }
        });
    }

    @Nullable
    public Object getContentType(int i) {
        IntervalList.Interval interval = this.intervals.get(i);
        return ((LazyLayoutIntervalContent) interval.getValue()).getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }

    @NotNull
    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    @NotNull
    public final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public int getItemCount() {
        return this.intervals.getSize();
    }

    @NotNull
    public Object getKey(int i) {
        Object invoke;
        IntervalList.Interval interval = this.intervals.get(i);
        int startIndex = i - interval.getStartIndex();
        Function1 key = ((LazyLayoutIntervalContent) interval.getValue()).getKey();
        return (key == null || (invoke = key.invoke(Integer.valueOf(startIndex))) == null) ? Lazy_androidKt.getDefaultLazyLayoutKey(i) : invoke;
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }
}
