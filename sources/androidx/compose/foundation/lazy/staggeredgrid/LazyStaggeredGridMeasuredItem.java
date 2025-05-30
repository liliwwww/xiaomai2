package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridMeasuredItem {
    private final long contentOffset;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int mainAxisSize;

    @NotNull
    private final List<Placeable> placeables;
    private final int sizeWithSpacings;
    private final int spacing;

    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, long j, int i2) {
        Integer num;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.contentOffset = j;
        this.spacing = i2;
        Integer num2 = 0;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = list.get(i3);
            num2 = Integer.valueOf(num2.intValue() + (this.isVertical ? placeable.getHeight() : placeable.getWidth()));
        }
        int intValue = num2.intValue();
        this.mainAxisSize = intValue;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(intValue + this.spacing, 0);
        List<Placeable> list2 = this.placeables;
        if (list2.isEmpty()) {
            num = null;
        } else {
            Placeable placeable2 = list2.get(0);
            Integer valueOf = Integer.valueOf(this.isVertical ? placeable2.getWidth() : placeable2.getHeight());
            int lastIndex = CollectionsKt.getLastIndex(list2);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Placeable placeable3 = list2.get(i4);
                    Integer valueOf2 = Integer.valueOf(this.isVertical ? placeable3.getWidth() : placeable3.getHeight());
                    valueOf = valueOf2.compareTo(valueOf) > 0 ? valueOf2 : valueOf;
                    if (i4 == lastIndex) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            num = valueOf;
        }
        Integer num3 = num;
        this.crossAxisSize = num3 != null ? num3.intValue() : 0;
    }

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, j, i2);
    }

    /* renamed from: getContentOffset-nOcc-ac, reason: not valid java name */
    public final long m507getContentOffsetnOccac() {
        return this.contentOffset;
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

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @NotNull
    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    @NotNull
    public final LazyStaggeredGridPositionedItem position(int i, int i2, int i3) {
        return new LazyStaggeredGridPositionedItem(this.isVertical ? IntOffsetKt.IntOffset(i3, i2) : IntOffsetKt.IntOffset(i2, i3), this.index, i, this.key, this.isVertical ? IntSizeKt.IntSize(this.crossAxisSize, this.sizeWithSpacings) : IntSizeKt.IntSize(this.sizeWithSpacings, this.crossAxisSize), this.placeables, this.contentOffset, this.isVertical, (DefaultConstructorMarker) null);
    }
}
