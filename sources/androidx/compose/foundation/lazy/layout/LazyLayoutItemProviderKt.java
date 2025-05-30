package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyLayoutItemProviderKt {
    @ExperimentalFoundationApi
    @NotNull
    public static final LazyLayoutItemProvider DelegatingLazyLayoutItemProvider(@NotNull State<? extends LazyLayoutItemProvider> state) {
        Intrinsics.checkNotNullParameter(state, "delegate");
        return new DefaultDelegatingLazyLayoutItemProvider(state);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final <T extends LazyLayoutIntervalContent> LazyLayoutItemProvider LazyLayoutItemProvider(@NotNull IntervalList<? extends T> intervalList, @NotNull IntRange intRange, @NotNull Function4<? super IntervalList.Interval<? extends T>, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        return new DefaultLazyLayoutItemsProvider(function4, intervalList, intRange);
    }

    @ExperimentalFoundationApi
    public static final int findIndexByKey(@NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @Nullable Object obj, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        return obj == null ? i : ((i >= lazyLayoutItemProvider.getItemCount() || !Intrinsics.areEqual(obj, lazyLayoutItemProvider.getKey(i))) && (num = (Integer) lazyLayoutItemProvider.getKeyToIndexMap().get(obj)) != null) ? num.intValue() : i;
    }
}
