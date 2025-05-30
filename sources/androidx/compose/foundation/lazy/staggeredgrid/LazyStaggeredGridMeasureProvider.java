package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
    private final long m505childConstraintsOenEA2s(int i) {
        int i2 = this.resolvedSlotSums[i] - (i == 0 ? 0 : this.resolvedSlotSums[i - 1]);
        return this.isVertical ? Constraints.Companion.fixedWidth-OenEA2s(i2) : Constraints.Companion.fixedHeight-OenEA2s(i2);
    }

    @NotNull
    public final LazyStaggeredGridMeasuredItem getAndMeasure(int i, int i2) {
        return this.measuredItemFactory.createItem(i, i2, this.itemProvider.getKey(i), this.measureScope.measure-0kLqBqw(i, m505childConstraintsOenEA2s(i2)));
    }
}
