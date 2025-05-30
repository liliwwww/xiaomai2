package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyMeasuredLine {
    private final int crossAxisSpacing;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final LazyMeasuredItem[] items;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final int slotsPerLine;

    @NotNull
    private final List<GridItemSpan> spans;

    private LazyMeasuredLine(int i, LazyMeasuredItem[] lazyMeasuredItemArr, List<GridItemSpan> list, boolean z, int i2, LayoutDirection layoutDirection, int i3, int i4) {
        this.index = i;
        this.items = lazyMeasuredItemArr;
        this.spans = list;
        this.isVertical = z;
        this.slotsPerLine = i2;
        this.layoutDirection = layoutDirection;
        this.mainAxisSpacing = i3;
        this.crossAxisSpacing = i4;
        int i5 = 0;
        for (LazyMeasuredItem lazyMeasuredItem : lazyMeasuredItemArr) {
            i5 = Math.max(i5, lazyMeasuredItem.getMainAxisSize());
        }
        this.mainAxisSize = i5;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i5 + this.mainAxisSpacing, 0);
    }

    public /* synthetic */ LazyMeasuredLine(int i, LazyMeasuredItem[] lazyMeasuredItemArr, List list, boolean z, int i2, LayoutDirection layoutDirection, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lazyMeasuredItemArr, list, z, i2, layoutDirection, i3, i4);
    }

    /* renamed from: getIndex-hA7yfN8, reason: not valid java name */
    public final int m470getIndexhA7yfN8() {
        return this.index;
    }

    @NotNull
    public final LazyMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        return this.items.length == 0;
    }

    @NotNull
    public final List<LazyGridPositionedItem> position(int i, int i2, int i3) {
        LazyMeasuredItem[] lazyMeasuredItemArr = this.items;
        ArrayList arrayList = new ArrayList(lazyMeasuredItemArr.length);
        int length = lazyMeasuredItemArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < length) {
            LazyMeasuredItem lazyMeasuredItem = lazyMeasuredItemArr[i4];
            int i8 = i5 + 1;
            int i9 = GridItemSpan.getCurrentLineSpan-impl(this.spans.get(i5).unbox-impl());
            int i10 = this.layoutDirection == LayoutDirection.Rtl ? (this.slotsPerLine - i6) - i9 : i6;
            boolean z = this.isVertical;
            int i11 = z ? this.index : i10;
            if (!z) {
                i10 = this.index;
            }
            LazyGridPositionedItem position = lazyMeasuredItem.position(i, i7, i2, i3, i11, i10);
            i7 += lazyMeasuredItem.getCrossAxisSize() + this.crossAxisSpacing;
            i6 += i9;
            arrayList.add(position);
            i4++;
            i5 = i8;
        }
        return arrayList;
    }
}
