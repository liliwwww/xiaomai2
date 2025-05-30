package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;

    @NotNull
    private final List<Placeable> placeables;

    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final long visualOffset;

    /* JADX WARN: Multi-variable type inference failed */
    private LazyMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List<? extends Placeable> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j) {
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.mainAxisSpacing = i3;
        this.reverseLayout = z2;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j;
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            i6 = Math.max(i6, this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = i6;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i6 + this.mainAxisSpacing, 0);
    }

    public /* synthetic */ LazyMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection, i4, i5, list, lazyGridItemPlacementAnimator, j);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* renamed from: getIndex-VZbfaAc, reason: not valid java name */
    public final int m303getIndexVZbfaAc() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    @NotNull
    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    @NotNull
    public final LazyGridPositionedItem position(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = this.isVertical;
        int i7 = z ? i4 : i3;
        int i8 = (z && this.layoutDirection == LayoutDirection.Rtl) ? ((z ? i3 : i4) - i2) - this.crossAxisSize : i2;
        return new LazyGridPositionedItem(z ? IntOffsetKt.IntOffset(i8, i) : IntOffsetKt.IntOffset(i, i8), this.index, this.key, i5, i6, this.isVertical ? IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize), -this.beforeContentPadding, i7 + this.afterContentPadding, this.isVertical, this.placeables, this.placementAnimator, this.visualOffset, i7, this.reverseLayout, null);
    }
}
