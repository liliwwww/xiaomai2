package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eo4;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListState implements ScrollableState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<LazyListState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @NotNull
        public final List<Integer> invoke(@NotNull SaverScope saverScope, @NotNull LazyListState lazyListState) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
            Intrinsics.checkNotNullParameter(lazyListState, "it");
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(lazyListState.getFirstVisibleItemIndex()), Integer.valueOf(lazyListState.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        @Nullable
        public final LazyListState invoke(@NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            return new LazyListState(list.get(0).intValue(), list.get(1).intValue());
        }
    });

    @NotNull
    private final LazyListAnimateScrollScope animateScrollScope;

    @NotNull
    private final AwaitFirstLayoutModifier awaitLayoutModifier;

    @NotNull
    private final MutableState canScrollBackward$delegate;

    @NotNull
    private final MutableState canScrollForward$delegate;

    @Nullable
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;

    @NotNull
    private final MutableState density$delegate;
    private int indexToPrefetch;

    @NotNull
    private final MutableInteractionSource internalInteractionSource;

    @NotNull
    private final MutableState<LazyListLayoutInfo> layoutInfoState;
    private int numMeasurePasses;

    @NotNull
    private final SnapshotStateList<LazyListPinnedItem> pinnedItems;

    @NotNull
    private final MutableState placementAnimator$delegate;

    @NotNull
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;

    @NotNull
    private final MutableState premeasureConstraints$delegate;

    @NotNull
    private final MutableState remeasurement$delegate;

    @NotNull
    private final RemeasurementModifier remeasurementModifier;

    @NotNull
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;

    @NotNull
    private final ScrollableState scrollableState;
    private boolean wasScrollingForward;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.Saver;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LazyListState() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.<init>():void");
    }

    public LazyListState(int i, int i2) {
        MutableState<LazyListLayoutInfo> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        this.scrollPosition = new LazyListScrollPosition(i, i2);
        this.animateScrollScope = new LazyListAnimateScrollScope(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyListLayoutInfo.INSTANCE, null, 2, null);
        this.layoutInfoState = mutableStateOf$default;
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DensityKt.Density(1.0f, 1.0f), null, 2, null);
        this.density$delegate = mutableStateOf$default2;
        this.scrollableState = ScrollableStateKt.ScrollableState(new scrollableState.1(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurement$delegate = mutableStateOf$default3;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1
            public /* synthetic */ boolean all(Function1 function1) {
                return nt2.a(this, function1);
            }

            public /* synthetic */ boolean any(Function1 function1) {
                return nt2.b(this, function1);
            }

            public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
                return nt2.c(this, obj, function2);
            }

            public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
                return nt2.d(this, obj, function2);
            }

            public void onRemeasurementAvailable(@NotNull Remeasurement remeasurement) {
                Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
                LazyListState.this.setRemeasurement(remeasurement);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* synthetic */ Modifier then(Modifier modifier) {
                return mt2.a(this, modifier);
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.placementAnimator$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Constraints.box-impl(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null)), null, 2, null);
        this.premeasureConstraints$delegate = mutableStateOf$default5;
        this.pinnedItems = SnapshotStateKt.mutableStateListOf();
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollForward$delegate = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollBackward$delegate = mutableStateOf$default7;
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.animateScrollToItem(i, i2, continuation);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyListLayoutInfo lazyListLayoutInfo) {
        if (this.indexToPrefetch == -1 || !(!lazyListLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            return;
        }
        if (this.indexToPrefetch != (this.wasScrollingForward ? ((LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1)) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    private final void notifyPrefetch(float f) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled) {
            LazyListLayoutInfo layoutInfo = getLayoutInfo();
            if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                boolean z = f < 0.0f;
                int index = z ? ((LazyListItemInfo) CollectionsKt.last(layoutInfo.getVisibleItemsInfo())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first(layoutInfo.getVisibleItemsInfo())).getIndex() - 1;
                if (index != this.indexToPrefetch) {
                    if (index >= 0 && index < layoutInfo.getTotalItemsCount()) {
                        if (this.wasScrollingForward != z && (prefetchHandle = this.currentPrefetchHandle) != null) {
                            prefetchHandle.cancel();
                        }
                        this.wasScrollingForward = z;
                        this.indexToPrefetch = index;
                        this.currentPrefetchHandle = this.prefetchState.m490schedulePrefetch0kLqBqw(index, m435getPremeasureConstraintsmsEJaDk$foundation_release());
                    }
                }
            }
        }
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState lazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyListState.scrollToItem(i, i2, continuation);
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    @Nullable
    public final Object animateScrollToItem(int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i, i2, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(@NotNull LazyListMeasureResult lazyListMeasureResult) {
        Intrinsics.checkNotNullParameter(lazyListMeasureResult, "result");
        this.scrollPosition.updateFromMeasureResult(lazyListMeasureResult);
        this.scrollToBeConsumed -= lazyListMeasureResult.getConsumedScroll();
        this.layoutInfoState.setValue(lazyListMeasureResult);
        setCanScrollForward(lazyListMeasureResult.getCanScrollForward());
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        setCanScrollBackward(((firstVisibleItem != null ? firstVisibleItem.getIndex() : 0) == 0 && lazyListMeasureResult.getFirstVisibleItemScrollOffset() == 0) ? false : true);
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(lazyListMeasureResult);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @NotNull
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Density getDensity$foundation_release() {
        return (Density) this.density$delegate.getValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.m432getIndexjQJCoq8();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final LazyListLayoutInfo getLayoutInfo() {
        return (LazyListLayoutInfo) this.layoutInfoState.getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    @NotNull
    public final SnapshotStateList<LazyListPinnedItem> getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    @Nullable
    public final LazyListItemPlacementAnimator getPlacementAnimator$foundation_release() {
        return (LazyListItemPlacementAnimator) this.placementAnimator$delegate.getValue();
    }

    @NotNull
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name */
    public final long m435getPremeasureConstraintsmsEJaDk$foundation_release() {
        return ((Constraints) this.premeasureConstraints$delegate.getValue()).unbox-impl();
    }

    @Nullable
    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    @NotNull
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final float onScroll$foundation_release(float f) {
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
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object scroll(@org.jetbrains.annotations.NotNull androidx.compose.foundation.MutatePriority r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.L$2
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.L$1
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.lazy.LazyListState r2 = (androidx.compose.foundation.lazy.LazyListState) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.scrollableState
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L6c
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object scrollToItem(int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object e = eo4.e(this, (MutatePriority) null, new LazyListState$scrollToItem$2(this, i, i2, null), continuation, 1, (Object) null);
        return e == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? e : Unit.INSTANCE;
    }

    public final void setDensity$foundation_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density$delegate.setValue(density);
    }

    public final void setPlacementAnimator$foundation_release(@Nullable LazyListItemPlacementAnimator lazyListItemPlacementAnimator) {
        this.placementAnimator$delegate.setValue(lazyListItemPlacementAnimator);
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m436setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints$delegate.setValue(Constraints.box-impl(j));
    }

    public final void snapToItemIndexInternal$foundation_release(int i, int i2) {
        this.scrollPosition.m433requestPositionAhXoVpI(DataIndex.constructor-impl(i), i2);
        LazyListItemPlacementAnimator placementAnimator$foundation_release = getPlacementAnimator$foundation_release();
        if (placementAnimator$foundation_release != null) {
            placementAnimator$foundation_release.reset();
        }
        Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(@NotNull LazyListItemProvider lazyListItemProvider) {
        Intrinsics.checkNotNullParameter(lazyListItemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyListItemProvider);
    }

    public /* synthetic */ LazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
