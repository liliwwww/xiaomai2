package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;

    @Nullable
    private final Alignment$Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;

    @NotNull
    private final LayoutDirection layoutDirection;

    @NotNull
    private final List<Placeable> placeables;

    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;

    @Nullable
    private final Alignment$Vertical verticalAlignment;
    private final long visualOffset;

    /* JADX WARN: Multi-variable type inference failed */
    private LazyMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment$Horizontal alignment$Horizontal, Alignment$Vertical alignment$Vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = alignment$Horizontal;
        this.verticalAlignment = alignment$Vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            i5 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            i6 = Math.max(i6, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = i5;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(i5 + this.spacing, 0);
        this.crossAxisSize = i6;
    }

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItem(int i, List list, boolean z, Alignment$Horizontal alignment$Horizontal, Alignment$Vertical alignment$Vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, alignment$Horizontal, alignment$Vertical, layoutDirection, z2, i2, i3, lazyListItemPlacementAnimator, i4, j, obj);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    @NotNull
    public final LazyListPositionedItem position(int i, int i2, int i3) {
        long IntOffset;
        ArrayList arrayList = new ArrayList();
        int i4 = this.isVertical ? i3 : i2;
        List<Placeable> list = this.placeables;
        int size = list.size();
        int i5 = i;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = list.get(i6);
            if (this.isVertical) {
                Alignment$Horizontal alignment$Horizontal = this.horizontalAlignment;
                if (alignment$Horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IntOffset = IntOffsetKt.IntOffset(alignment$Horizontal.align(placeable.getWidth(), i2, this.layoutDirection), i5);
            } else {
                Alignment$Vertical alignment$Vertical = this.verticalAlignment;
                if (alignment$Vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IntOffset = IntOffsetKt.IntOffset(i5, alignment$Vertical.align(placeable.getHeight(), i3));
            }
            i5 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            arrayList.add(new LazyListPlaceableWrapper(IntOffset, placeable, null));
        }
        return new LazyListPositionedItem(i, this.index, this.key, this.size, -this.beforeContentPadding, i4 + this.afterContentPadding, this.isVertical, arrayList, this.placementAnimator, this.visualOffset, this.reverseLayout, i4, null);
    }
}
