package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ LazyListBeyondBoundsInfo $beyondBoundsInfo;
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment$Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListItemProvider $itemProvider;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment$Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyListState lazyListState, LazyListItemProvider lazyListItemProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i, Alignment$Horizontal alignment$Horizontal, Alignment$Vertical alignment$Vertical) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyListState;
        this.$itemProvider = lazyListItemProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = alignment$Horizontal;
        this.$verticalAlignment = alignment$Vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m260invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m2128unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final LazyListMeasureResult m260invoke0kLqBqw(@NotNull final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        float f;
        long IntOffset;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m125checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        int mo319roundToPx0680j_4 = this.$isVertical ? lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo217calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int mo319roundToPx0680j_42 = this.$isVertical ? lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo218calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo319roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        int mo319roundToPx0680j_43 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo219calculateTopPaddingD9Ej5fM());
        int mo319roundToPx0680j_44 = lazyLayoutMeasureScope.mo319roundToPx0680j_4(this.$contentPadding.mo216calculateBottomPaddingD9Ej5fM());
        final int i = mo319roundToPx0680j_43 + mo319roundToPx0680j_44;
        final int i2 = mo319roundToPx0680j_4 + mo319roundToPx0680j_42;
        boolean z = this.$isVertical;
        int i3 = z ? i : i2;
        int i4 = (!z || this.$reverseLayout) ? (z && this.$reverseLayout) ? mo319roundToPx0680j_44 : (z || this.$reverseLayout) ? mo319roundToPx0680j_42 : mo319roundToPx0680j_4 : mo319roundToPx0680j_43;
        int i5 = i3 - i4;
        long m2138offsetNN6EwU = ConstraintsKt.m2138offsetNN6EwU(j, -i2, -i);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$itemProvider.getItemScope().setMaxSize(Constraints.m2122getMaxWidthimpl(m2138offsetNN6EwU), Constraints.m2121getMaxHeightimpl(m2138offsetNN6EwU));
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
        int itemCount = this.$itemProvider.getItemCount();
        int m2121getMaxHeightimpl = this.$isVertical ? Constraints.m2121getMaxHeightimpl(j) - i : Constraints.m2122getMaxWidthimpl(j) - i2;
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
        boolean z3 = this.$isVertical;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(m2138offsetNN6EwU, z3, this.$itemProvider, lazyLayoutMeasureScope, new measuredItemProvider.1(itemCount, mo319roundToPx0680j_45, lazyLayoutMeasureScope, z3, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, i4, i5, this.$placementAnimator, IntOffset), null);
        this.$state.setPremeasureConstraints-BRTryo0$foundation_release(lazyMeasuredItemProvider.m268getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                int m245constructorimpl = DataIndex.m245constructorimpl(lazyListState.getFirstVisibleItemIndex());
                int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.dispose();
                LazyListMeasureResult m263measureLazyListQaF8Ofo = LazyListMeasureKt.m263measureLazyListQaF8Ofo(itemCount, lazyMeasuredItemProvider, m2121getMaxHeightimpl, i4, i5, mo319roundToPx0680j_45, m245constructorimpl, firstVisibleItemScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), m2138offsetNN6EwU, this.$isVertical, this.$itemProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, this.$beyondBoundsInfo, this.$beyondBoundsItemCount, this.$state.getPinnedItems$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) obj3);
                    }

                    @NotNull
                    public final MeasureResult invoke(int i6, int i7, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                        Intrinsics.checkNotNullParameter(function1, "placement");
                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2136constrainWidthK40F9xA(j, i6 + i2), ConstraintsKt.m2135constrainHeightK40F9xA(j, i7 + i), MapsKt.emptyMap(), function1);
                    }
                });
                this.$state.applyMeasureResult$foundation_release(m263measureLazyListQaF8Ofo);
                return m263measureLazyListQaF8Ofo;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
