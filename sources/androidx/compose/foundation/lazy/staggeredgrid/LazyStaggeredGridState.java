package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eo4;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyStaggeredGridState implements ScrollableState {

    @NotNull
    private final LazyStaggeredGridAnimateScrollScope animateScrollScope;

    @NotNull
    private final MutableState canScrollBackward$delegate;

    @NotNull
    private final MutableState canScrollForward$delegate;

    @NotNull
    private final Map<Integer, LazyLayoutPrefetchState$PrefetchHandle> currentItemPrefetchHandles;

    @NotNull
    private Density density;
    private boolean isVertical;

    @NotNull
    private int[] laneWidthsPrefixSum;

    @NotNull
    private final MutableState<LazyStaggeredGridLayoutInfo> layoutInfoState;
    private int measurePassCount;

    @NotNull
    private final MutableInteractionSource mutableInteractionSource;
    private int prefetchBaseIndex;

    @NotNull
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;

    @Nullable
    private Remeasurement remeasurement;

    @NotNull
    private final RemeasurementModifier remeasurementModifier;

    @NotNull
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;

    @NotNull
    private final ScrollableState scrollableState;

    @NotNull
    private final LazyStaggeredGridSpans spans;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Saver<LazyStaggeredGridState, Object> Saver = ListSaverKt.listSaver(Companion.Saver.1.INSTANCE, Companion.Saver.2.INSTANCE);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }

    private LazyStaggeredGridState(int[] iArr, int[] iArr2) {
        this.scrollPosition = new LazyStaggeredGridScrollPosition(iArr, iArr2, new scrollPosition.1(this));
        this.layoutInfoState = SnapshotStateKt.mutableStateOf$default(EmptyLazyStaggeredGridLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.spans = new LazyStaggeredGridSpans();
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animateScrollScope = new LazyStaggeredGridAnimateScrollScope(this);
        this.remeasurementModifier = new remeasurementModifier.1(this);
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState();
        this.scrollableState = ScrollableStateKt.ScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollableState$1
            {
                super(1);
            }

            @NotNull
            public final Float invoke(float f) {
                float onScroll;
                onScroll = LazyStaggeredGridState.this.onScroll(-f);
                return Float.valueOf(-onScroll);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        });
        this.laneWidthsPrefixSum = new int[0];
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
    }

    public /* synthetic */ LazyStaggeredGridState(int[] iArr, int[] iArr2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2);
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i, i2, continuation);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo) {
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridLayoutInfo.getVisibleItemsInfo();
        if (this.prefetchBaseIndex != -1) {
            if (!visibleItemsInfo.isEmpty()) {
                int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(visibleItemsInfo)).getIndex();
                int index2 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(visibleItemsInfo)).getIndex();
                int i = this.prefetchBaseIndex;
                if (index <= i && i <= index2) {
                    return;
                }
                this.prefetchBaseIndex = -1;
                Iterator<T> it = this.currentItemPrefetchHandles.values().iterator();
                while (it.hasNext()) {
                    ((LazyLayoutPrefetchState$PrefetchHandle) it.next()).cancel();
                }
                this.currentItemPrefetchHandles.clear();
            }
        }
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> set) {
        Iterator<Map.Entry<Integer, LazyLayoutPrefetchState$PrefetchHandle>> it = this.currentItemPrefetchHandles.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, LazyLayoutPrefetchState$PrefetchHandle> next = it.next();
            if (!set.contains(next.getKey())) {
                next.getValue().cancel();
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] fillNearestIndices(int i, int i2) {
        this.spans.ensureValidIndex(i + i2);
        int span = this.spans.getSpan(i);
        int min = span == -1 ? 0 : Math.min(span, i2);
        int[] iArr = new int[i2];
        int i3 = min - 1;
        int i4 = i;
        while (true) {
            if (-1 >= i3) {
                break;
            }
            iArr[i3] = this.spans.findPreviousItemIndex(i4, i3);
            if (iArr[i3] == -1) {
                ArraysKt.fill$default(iArr, -1, 0, i3, 2, (Object) null);
                break;
            }
            i4 = iArr[i3];
            i3--;
        }
        iArr[min] = i;
        while (true) {
            min++;
            if (min >= i2) {
                return iArr;
            }
            iArr[min] = this.spans.findNextItemIndex(i, min);
            i = iArr[min];
        }
    }

    private final void notifyPrefetch(float f) {
        LazyStaggeredGridLayoutInfo value = this.layoutInfoState.getValue();
        if (!value.getVisibleItemsInfo().isEmpty()) {
            boolean z = f < 0.0f;
            int index = z ? ((LazyStaggeredGridItemInfo) CollectionsKt.last(value.getVisibleItemsInfo())).getIndex() : ((LazyStaggeredGridItemInfo) CollectionsKt.first(value.getVisibleItemsInfo())).getIndex();
            if (index == this.prefetchBaseIndex) {
                return;
            }
            this.prefetchBaseIndex = index;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int length = this.laneWidthsPrefixSum.length;
            int i = 0;
            while (i < length) {
                int findNextItemIndex = z ? this.spans.findNextItemIndex(index, i) : this.spans.findPreviousItemIndex(index, i);
                if (!(findNextItemIndex >= 0 && findNextItemIndex < value.getTotalItemsCount()) || index == findNextItemIndex) {
                    return;
                }
                linkedHashSet.add(Integer.valueOf(findNextItemIndex));
                if (!this.currentItemPrefetchHandles.containsKey(Integer.valueOf(findNextItemIndex))) {
                    int[] iArr = this.laneWidthsPrefixSum;
                    int i2 = iArr[i] - (i == 0 ? 0 : iArr[i - 1]);
                    this.currentItemPrefetchHandles.put(Integer.valueOf(findNextItemIndex), this.prefetchState.schedulePrefetch-0kLqBqw(findNextItemIndex, this.isVertical ? Constraints.Companion.m2132fixedWidthOenEA2s(i2) : Constraints.Companion.m2131fixedHeightOenEA2s(i2)));
                }
                i++;
                index = findNextItemIndex;
            }
            clearLeftoverPrefetchHandles(linkedHashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float onScroll(float f) {
        if ((f < 0.0f && !getCanScrollForward()) || (f > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (!(Math.abs(this.scrollToBeConsumed) <= 0.5f)) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        float f2 = this.scrollToBeConsumed + f;
        this.scrollToBeConsumed = f2;
        if (Math.abs(f2) > 0.5f) {
            float f3 = this.scrollToBeConsumed;
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
            if (this.prefetchingEnabled) {
                notifyPrefetch(f3 - this.scrollToBeConsumed);
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return f;
        }
        float f4 = f - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f4;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i, i2, continuation);
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    @Nullable
    public final Object animateScrollToItem(int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i, i2, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(@NotNull LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridMeasureResult, "result");
        this.scrollToBeConsumed -= lazyStaggeredGridMeasureResult.getConsumedScroll();
        setCanScrollBackward(lazyStaggeredGridMeasureResult.getCanScrollBackward());
        setCanScrollForward(lazyStaggeredGridMeasureResult.getCanScrollForward());
        this.layoutInfoState.setValue(lazyStaggeredGridMeasureResult);
        cancelPrefetchIfVisibleItemsChanged(lazyStaggeredGridMeasureResult);
        this.scrollPosition.updateFromMeasureResult(lazyStaggeredGridMeasureResult);
        this.measurePassCount++;
    }

    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final int getFirstVisibleItemIndex() {
        Integer num;
        int[] indices = this.scrollPosition.getIndices();
        if (indices.length == 0) {
            num = null;
        } else {
            int i = indices[0];
            if (i == -1) {
                i = 0;
            }
            Integer valueOf = Integer.valueOf(i);
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(indices)).iterator();
            while (it.hasNext()) {
                int i2 = indices[it.nextInt()];
                if (i2 == -1) {
                    i2 = 0;
                }
                Integer valueOf2 = Integer.valueOf(i2);
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    public final int getFirstVisibleItemScrollOffset() {
        int[] offsets = this.scrollPosition.getOffsets();
        if (offsets.length == 0) {
            return 0;
        }
        return offsets[LazyStaggeredGridMeasureKt.indexOfMinValue(this.scrollPosition.getIndices())];
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    public final int getLaneCount$foundation_release() {
        return this.laneWidthsPrefixSum.length;
    }

    @NotNull
    public final int[] getLaneWidthsPrefixSum$foundation_release() {
        return this.laneWidthsPrefixSum;
    }

    @NotNull
    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    @NotNull
    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    @NotNull
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    @NotNull
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    @NotNull
    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    @NotNull
    public final LazyStaggeredGridSpans getSpans$foundation_release() {
        return this.spans;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final boolean isVertical$foundation_release() {
        return this.isVertical;
    }

    @Nullable
    public Object scroll(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, function2, continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    @Nullable
    public final Object scrollToItem(int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object e = eo4.e(this, (MutatePriority) null, new scrollToItem.2(this, i, i2, (Continuation) null), continuation, 1, (Object) null);
        return e == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? e : Unit.INSTANCE;
    }

    public final void setDensity$foundation_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density = density;
    }

    public final void setLaneWidthsPrefixSum$foundation_release(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.laneWidthsPrefixSum = iArr;
    }

    public final void setMeasurePassCount$foundation_release(int i) {
        this.measurePassCount = i;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical = z;
    }

    public final void snapToItemInternal$foundation_release(@NotNull ScrollScope scrollScope, int i, int i2) {
        Intrinsics.checkNotNullParameter(scrollScope, "<this>");
        LazyStaggeredGridItemInfo findVisibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(getLayoutInfo(), i);
        if (findVisibleItem != null) {
            boolean z = this.isVertical;
            long j = findVisibleItem.getOffset-nOcc-ac();
            scrollScope.scrollBy((z ? IntOffset.getY-impl(j) : IntOffset.getX-impl(j)) + i2);
        } else {
            this.scrollPosition.requestPosition(i, i2);
            Remeasurement remeasurement = this.remeasurement;
            if (remeasurement != null) {
                remeasurement.forceRemeasure();
            }
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(@NotNull LazyLayoutItemProvider lazyLayoutItemProvider) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyLayoutItemProvider);
    }

    public /* synthetic */ LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyStaggeredGridState(int i, int i2) {
        this(new int[]{i}, new int[]{i2});
    }
}
