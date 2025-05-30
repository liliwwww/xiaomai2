package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemProvider $itemProvider;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, List<Integer>> $slotSizesSums;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyGridState;
        this.$itemProvider = lazyGridItemProvider;
        this.$slotSizesSums = function2;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m294invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m2128unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyGridMeasureResult m294invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        float f;
        float f2;
        long IntOffset;
        int firstVisibleItemScrollOffset;
        int i;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m125checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        int mo319roundToPx0680j_4 = this.$isVertical ? lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo217calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int mo319roundToPx0680j_42 = this.$isVertical ? lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo218calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int mo319roundToPx0680j_43 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo219calculateTopPaddingD9Ej5fM());
        int mo319roundToPx0680j_44 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo216calculateBottomPaddingD9Ej5fM());
        final int i2 = mo319roundToPx0680j_43 + mo319roundToPx0680j_44;
        final int i3 = mo319roundToPx0680j_4 + mo319roundToPx0680j_42;
        boolean z = this.$isVertical;
        int i4 = z ? i2 : i3;
        int i5 = (!z || this.$reverseLayout) ? (z && this.$reverseLayout) ? mo319roundToPx0680j_44 : (z || this.$reverseLayout) ? mo319roundToPx0680j_42 : mo319roundToPx0680j_4 : mo319roundToPx0680j_43;
        final int i6 = i4 - i5;
        long m2138offsetNN6EwU = ConstraintsKt.m2138offsetNN6EwU(j, -i3, -i2);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        final LazyGridSpanLayoutProvider spanLayoutProvider = this.$itemProvider.getSpanLayoutProvider();
        final List list = (List) this.$slotSizesSums.invoke(lazyLayoutMeasureScope, Constraints.m2110boximpl(j));
        spanLayoutProvider.setSlotsPerLine(list.size());
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$state.setSlotsPerLine$foundation_release(list.size());
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            f = vertical.getSpacing-D9Ej5fM();
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            f = horizontal.getSpacing-D9Ej5fM();
        }
        int mo319roundToPx0680j_45 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(f);
        if (this.$isVertical) {
            Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
            f2 = horizontal2 != null ? horizontal2.getSpacing-D9Ej5fM() : Dp.m2142constructorimpl(0);
        } else {
            Arrangement.Vertical vertical2 = this.$verticalArrangement;
            f2 = vertical2 != null ? vertical2.getSpacing-D9Ej5fM() : Dp.m2142constructorimpl(0);
        }
        final int mo319roundToPx0680j_46 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(f2);
        int itemCount = this.$itemProvider.getItemCount();
        int m2121getMaxHeightimpl = this.$isVertical ? Constraints.m2121getMaxHeightimpl(j) - i2 : Constraints.m2122getMaxWidthimpl(j) - i3;
        if (!this.$reverseLayout || m2121getMaxHeightimpl > 0) {
            IntOffset = IntOffsetKt.IntOffset(mo319roundToPx0680j_4, mo319roundToPx0680j_43);
        } else {
            boolean z2 = this.$isVertical;
            if (!z2) {
                mo319roundToPx0680j_4 += m2121getMaxHeightimpl;
            }
            if (z2) {
                mo319roundToPx0680j_43 += m2121getMaxHeightimpl;
            }
            IntOffset = IntOffsetKt.IntOffset(mo319roundToPx0680j_4, mo319roundToPx0680j_43);
        }
        final long j2 = IntOffset;
        LazyGridItemProvider lazyGridItemProvider = this.$itemProvider;
        final boolean z3 = this.$isVertical;
        final boolean z4 = this.$reverseLayout;
        final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = this.$placementAnimator;
        final int i7 = i5;
        int i8 = i5;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider, lazyLayoutMeasureScope, mo319roundToPx0680j_45, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
            @NotNull
            /* renamed from: createItem-PU_OBEw, reason: not valid java name */
            public final LazyMeasuredItem mo296createItemPU_OBEw(int i9, @NotNull Object obj, int i10, int i11, @NotNull List<? extends Placeable> list2) {
                Intrinsics.checkNotNullParameter(obj, "key");
                Intrinsics.checkNotNullParameter(list2, "placeables");
                return new LazyMeasuredItem(i9, obj, z3, i10, i11, z4, LazyLayoutMeasureScope.this.getLayoutDirection(), i7, i6, list2, lazyGridItemPlacementAnimator, j2, null);
            }
        });
        final boolean z5 = this.$isVertical;
        final LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z5, list, mo319roundToPx0680j_46, itemCount, mo319roundToPx0680j_45, lazyMeasuredItemProvider, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            @NotNull
            /* renamed from: createLine-H9FfpSk, reason: not valid java name */
            public final LazyMeasuredLine m297createLineH9FfpSk(int i9, @NotNull LazyMeasuredItem[] lazyMeasuredItemArr, @NotNull List<GridItemSpan> list2, int i10) {
                Intrinsics.checkNotNullParameter(lazyMeasuredItemArr, "items");
                Intrinsics.checkNotNullParameter(list2, "spans");
                return new LazyMeasuredLine(i9, lazyMeasuredItemArr, list2, z5, list.size(), lazyLayoutMeasureScope.getLayoutDirection(), i10, mo319roundToPx0680j_46, (DefaultConstructorMarker) null);
            }
        });
        this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m295invokebKFJvoY(((LineIndex) obj).unbox-impl());
            }

            @NotNull
            /* renamed from: invoke-bKFJvoY, reason: not valid java name */
            public final ArrayList<Pair<Integer, Constraints>> m295invokebKFJvoY(int i9) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i9);
                int i10 = ItemIndex.constructor-impl(lineConfiguration.getFirstItemIndex());
                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                List spans = lineConfiguration.getSpans();
                LazyMeasuredLineProvider lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
                int size = spans.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    int m278getCurrentLineSpanimpl = GridItemSpan.m278getCurrentLineSpanimpl(((GridItemSpan) spans.get(i12)).m281unboximpl());
                    arrayList.add(TuplesKt.to(Integer.valueOf(i10), Constraints.m2110boximpl(lazyMeasuredLineProvider2.m306childConstraintsJhjzzOo$foundation_release(i11, m278getCurrentLineSpanimpl))));
                    i10 = ItemIndex.constructor-impl(i10 + 1);
                    i11 += m278getCurrentLineSpanimpl;
                }
                return arrayList;
            }
        });
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                if (lazyGridState.getFirstVisibleItemIndex() >= itemCount && itemCount > 0) {
                    i = spanLayoutProvider.getLineIndexOfItem--_Ze7BM(itemCount - 1);
                    firstVisibleItemScrollOffset = 0;
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.dispose();
                    LazyGridMeasureResult lazyGridMeasureResult = LazyGridMeasureKt.measureLazyGrid-0cYbdkg(itemCount, lazyMeasuredLineProvider, lazyMeasuredItemProvider, m2121getMaxHeightimpl, i8, i6, mo319roundToPx0680j_45, i, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), m2138offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, spanLayoutProvider, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) obj3);
                        }

                        @NotNull
                        public final MeasureResult invoke(int i9, int i10, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                            Intrinsics.checkNotNullParameter(function1, "placement");
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2136constrainWidthK40F9xA(j, i9 + i3), ConstraintsKt.m2135constrainHeightK40F9xA(j, i10 + i2), MapsKt.emptyMap(), function1);
                        }
                    });
                    this.$state.applyMeasureResult$foundation_release(lazyGridMeasureResult);
                    return lazyGridMeasureResult;
                }
                int i9 = spanLayoutProvider.getLineIndexOfItem--_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                firstVisibleItemScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                i = i9;
                Unit unit2 = Unit.INSTANCE;
                createNonObservableSnapshot.dispose();
                LazyGridMeasureResult lazyGridMeasureResult2 = LazyGridMeasureKt.measureLazyGrid-0cYbdkg(itemCount, lazyMeasuredLineProvider, lazyMeasuredItemProvider, m2121getMaxHeightimpl, i8, i6, mo319roundToPx0680j_45, i, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), m2138offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, spanLayoutProvider, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) obj3);
                    }

                    @NotNull
                    public final MeasureResult invoke(int i92, int i10, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                        Intrinsics.checkNotNullParameter(function1, "placement");
                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2136constrainWidthK40F9xA(j, i92 + i3), ConstraintsKt.m2135constrainHeightK40F9xA(j, i10 + i2), MapsKt.emptyMap(), function1);
                    }
                });
                this.$state.applyMeasureResult$foundation_release(lazyGridMeasureResult2);
                return lazyGridMeasureResult2;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
