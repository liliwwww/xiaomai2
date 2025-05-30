package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyMeasuredItemProvider {
    private final int defaultMainAxisSpacing;

    @NotNull
    private final LazyGridItemProvider itemProvider;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    @ExperimentalFoundationApi
    public LazyMeasuredItemProvider(@NotNull LazyGridItemProvider lazyGridItemProvider, @NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, @NotNull MeasuredItemFactory measuredItemFactory) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "measureScope");
        Intrinsics.checkNotNullParameter(measuredItemFactory, "measuredItemFactory");
        this.itemProvider = lazyGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.defaultMainAxisSpacing = i;
        this.measuredItemFactory = measuredItemFactory;
    }

    /* renamed from: getAndMeasure-ednRnyU$default, reason: not valid java name */
    public static /* synthetic */ LazyMeasuredItem m304getAndMeasureednRnyU$default(LazyMeasuredItemProvider lazyMeasuredItemProvider, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = lazyMeasuredItemProvider.defaultMainAxisSpacing;
        }
        return lazyMeasuredItemProvider.m305getAndMeasureednRnyU(i, i2, j);
    }

    @NotNull
    /* renamed from: getAndMeasure-ednRnyU, reason: not valid java name */
    public final LazyMeasuredItem m305getAndMeasureednRnyU(int i, int i2, long j) {
        int m2123getMinHeightimpl;
        Object key = this.itemProvider.getKey(i);
        List<Placeable> mo309measure0kLqBqw = this.measureScope.mo309measure0kLqBqw(i, j);
        if (Constraints.m2120getHasFixedWidthimpl(j)) {
            m2123getMinHeightimpl = Constraints.m2124getMinWidthimpl(j);
        } else {
            if (!Constraints.m2119getHasFixedHeightimpl(j)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            m2123getMinHeightimpl = Constraints.m2123getMinHeightimpl(j);
        }
        return this.measuredItemFactory.mo296createItemPU_OBEw(i, key, m2123getMinHeightimpl, i2, mo309measure0kLqBqw);
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemProvider.getKeyToIndexMap();
    }
}
