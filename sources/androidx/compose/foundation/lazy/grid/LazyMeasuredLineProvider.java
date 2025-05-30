package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyMeasuredLineProvider {
    private final int crossAxisSpacing;
    private final int gridItemsCount;
    private final boolean isVertical;

    @NotNull
    private final LazyMeasuredItemProvider measuredItemProvider;

    @NotNull
    private final MeasuredLineFactory measuredLineFactory;

    @NotNull
    private final List<Integer> slotSizesSums;
    private final int spaceBetweenLines;

    @NotNull
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyMeasuredLineProvider(boolean z, @NotNull List<Integer> list, int i, int i2, int i3, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, @NotNull LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, @NotNull MeasuredLineFactory measuredLineFactory) {
        Intrinsics.checkNotNullParameter(list, "slotSizesSums");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(measuredLineFactory, "measuredLineFactory");
        this.isVertical = z;
        this.slotSizesSums = list;
        this.crossAxisSpacing = i;
        this.gridItemsCount = i2;
        this.spaceBetweenLines = i3;
        this.measuredItemProvider = lazyMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
        this.measuredLineFactory = measuredLineFactory;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m306childConstraintsJhjzzOo$foundation_release(int i, int i2) {
        int coerceAtLeast = RangesKt.coerceAtLeast((this.slotSizesSums.get((i + i2) - 1).intValue() - (i == 0 ? 0 : this.slotSizesSums.get(i - 1).intValue())) + (this.crossAxisSpacing * (i2 - 1)), 0);
        return this.isVertical ? Constraints.Companion.m2132fixedWidthOenEA2s(coerceAtLeast) : Constraints.Companion.m2131fixedHeightOenEA2s(coerceAtLeast);
    }

    @NotNull
    /* renamed from: getAndMeasure-bKFJvoY, reason: not valid java name */
    public final LazyMeasuredLine m307getAndMeasurebKFJvoY(int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i);
        int size = lineConfiguration.getSpans().size();
        int i2 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyMeasuredItem[] lazyMeasuredItemArr = new LazyMeasuredItem[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int m278getCurrentLineSpanimpl = GridItemSpan.m278getCurrentLineSpanimpl(((GridItemSpan) lineConfiguration.getSpans().get(i4)).m281unboximpl());
            LazyMeasuredItem m305getAndMeasureednRnyU = this.measuredItemProvider.m305getAndMeasureednRnyU(ItemIndex.constructor-impl(lineConfiguration.getFirstItemIndex() + i4), i2, m306childConstraintsJhjzzOo$foundation_release(i3, m278getCurrentLineSpanimpl));
            i3 += m278getCurrentLineSpanimpl;
            Unit unit = Unit.INSTANCE;
            lazyMeasuredItemArr[i4] = m305getAndMeasureednRnyU;
        }
        return this.measuredLineFactory.createLine-H9FfpSk(i, lazyMeasuredItemArr, lineConfiguration.getSpans(), i2);
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.measuredItemProvider.getKeyToIndexMap();
    }
}
