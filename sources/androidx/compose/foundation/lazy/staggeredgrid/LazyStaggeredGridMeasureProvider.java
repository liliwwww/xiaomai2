package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.p004ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class LazyStaggeredGridMeasureProvider {
    private final boolean isVertical;

    @NotNull
    private final LazyLayoutItemProvider itemProvider;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    @NotNull
    private final int[] resolvedSlotSums;

    public LazyStaggeredGridMeasureProvider(boolean z, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull int[] iArr, @NotNull MeasuredItemFactory measuredItemFactory) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "measureScope");
        Intrinsics.checkNotNullParameter(iArr, "resolvedSlotSums");
        Intrinsics.checkNotNullParameter(measuredItemFactory, "measuredItemFactory");
        this.isVertical = z;
        this.itemProvider = lazyLayoutItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.resolvedSlotSums = iArr;
        this.measuredItemFactory = measuredItemFactory;
    }

    /* renamed from: childConstraints-OenEA2s, reason: not valid java name */
    private final long m1639childConstraintsOenEA2s(int i) {
        int i2 = this.resolvedSlotSums[i] - (i == 0 ? 0 : this.resolvedSlotSums[i - 1]);
        return this.isVertical ? Constraints.Companion.m5194fixedWidthOenEA2s(i2) : Constraints.Companion.m5193fixedHeightOenEA2s(i2);
    }

    @NotNull
    public final LazyStaggeredGridMeasuredItem getAndMeasure(int i, int i2) {
        return this.measuredItemFactory.createItem(i, i2, this.itemProvider.getKey(i), this.measureScope.mo1615measure0kLqBqw(i, m1639childConstraintsOenEA2s(i2)));
    }
}
