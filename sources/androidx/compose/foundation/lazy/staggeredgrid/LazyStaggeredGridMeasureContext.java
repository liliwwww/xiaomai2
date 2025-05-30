package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridMeasureContext {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final int crossAxisSpacing;
    private final boolean isVertical;

    @NotNull
    private final LazyLayoutItemProvider itemProvider;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;

    @NotNull
    private final int[] resolvedSlotSums;

    @NotNull
    private final LazyStaggeredGridSpans spans;

    @NotNull
    private final LazyStaggeredGridState state;

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, int i4, int i5) {
        this.state = lazyStaggeredGridState;
        this.itemProvider = lazyLayoutItemProvider;
        this.resolvedSlotSums = iArr;
        this.constraints = j;
        this.isVertical = z;
        this.measureScope = lazyLayoutMeasureScope;
        this.mainAxisAvailableSize = i;
        this.contentOffset = j2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.mainAxisSpacing = i4;
        this.crossAxisSpacing = i5;
        this.measuredItemProvider = new LazyStaggeredGridMeasureProvider(z, lazyLayoutItemProvider, lazyLayoutMeasureScope, iArr, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext$measuredItemProvider$1
            @NotNull
            public final LazyStaggeredGridMeasuredItem createItem(int i6, int i7, @NotNull Object obj, @NotNull List<? extends Placeable> list) {
                Intrinsics.checkNotNullParameter(obj, "key");
                Intrinsics.checkNotNullParameter(list, "placeables");
                return new LazyStaggeredGridMeasuredItem(i6, obj, list, LazyStaggeredGridMeasureContext.this.isVertical(), LazyStaggeredGridMeasureContext.this.m503getContentOffsetnOccac(), LazyStaggeredGridMeasureContext.this.getSpans().findNextItemIndex(i6, i7) >= LazyStaggeredGridMeasureContext.this.getItemProvider().getItemCount() ? 0 : LazyStaggeredGridMeasureContext.this.getMainAxisSpacing(), null);
            }
        });
        this.spans = lazyStaggeredGridState.getSpans$foundation_release();
    }

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, lazyLayoutItemProvider, iArr, j, z, lazyLayoutMeasureScope, i, j2, i2, i3, i4, i5);
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    /* renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public final long m502getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: getContentOffset-nOcc-ac, reason: not valid java name */
    public final long m503getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getCrossAxisSpacing() {
        return this.crossAxisSpacing;
    }

    @NotNull
    public final LazyLayoutItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    @NotNull
    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    @NotNull
    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    @NotNull
    public final int[] getResolvedSlotSums() {
        return this.resolvedSlotSums;
    }

    @NotNull
    public final LazyStaggeredGridSpans getSpans() {
        return this.spans;
    }

    @NotNull
    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }
}
