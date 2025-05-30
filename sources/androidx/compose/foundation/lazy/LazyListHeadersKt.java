package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListHeadersKt {
    @Nullable
    public static final LazyListPositionedItem findOrComposeLazyListHeader(@NotNull List<LazyListPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, @NotNull List<Integer> list2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(list2, "headerIndexes");
        int index = ((LazyListPositionedItem) CollectionsKt.first(list)).getIndex();
        int size = list2.size();
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (i4 < size && list2.get(i4).intValue() <= index) {
            i5 = list2.get(i4).intValue();
            i4++;
            i6 = ((i4 < 0 || i4 > CollectionsKt.getLastIndex(list2)) ? -1 : list2.get(i4)).intValue();
        }
        int size2 = list.size();
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MIN_VALUE;
        int i9 = -1;
        for (int i10 = 0; i10 < size2; i10++) {
            LazyListPositionedItem lazyListPositionedItem = list.get(i10);
            if (lazyListPositionedItem.getIndex() == i5) {
                i7 = lazyListPositionedItem.getOffset();
                i9 = i10;
            } else if (lazyListPositionedItem.getIndex() == i6) {
                i8 = lazyListPositionedItem.getOffset();
            }
        }
        if (i5 == -1) {
            return null;
        }
        LazyMeasuredItem lazyMeasuredItem = lazyMeasuredItemProvider.getAndMeasure-ZjPyQlc(DataIndex.constructor-impl(i5));
        int max = i7 != Integer.MIN_VALUE ? Math.max(-i, i7) : -i;
        if (i8 != Integer.MIN_VALUE) {
            max = Math.min(max, i8 - lazyMeasuredItem.getSize());
        }
        LazyListPositionedItem position = lazyMeasuredItem.position(max, i2, i3);
        if (i9 != -1) {
            list.set(i9, position);
        } else {
            list.add(0, position);
        }
        return position;
    }
}
