package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final boolean isVertical;

    @NotNull
    private Map<Object, Integer> keyToIndexMap;

    @NotNull
    private final Map<Object, ItemInfo> keyToItemInfoMap;

    @NotNull
    private final LinkedHashSet<Object> movingAwayKeys;

    @NotNull
    private final List<LazyMeasuredItem> movingAwayToEndBound;

    @NotNull
    private final List<LazyMeasuredItem> movingAwayToStartBound;

    @NotNull
    private final List<LazyGridPositionedItem> movingInFromEndBound;

    @NotNull
    private final List<LazyGridPositionedItem> movingInFromStartBound;

    @NotNull
    private final CoroutineScope scope;

    public LazyGridItemPlacementAnimator(@NotNull CoroutineScope coroutineScope, boolean z) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.movingAwayKeys = new LinkedHashSet<>();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
    }

    private final ItemInfo createItemInfo(LazyGridPositionedItem lazyGridPositionedItem, int i) {
        ItemInfo itemInfo = new ItemInfo(lazyGridPositionedItem.getCrossAxisSize(), lazyGridPositionedItem.getCrossAxisOffset());
        long m5330copyiSbpLlY$default = this.isVertical ? IntOffset.m5330copyiSbpLlY$default(lazyGridPositionedItem.mo1565getOffsetnOccac(), 0, i, 1, null) : IntOffset.m5330copyiSbpLlY$default(lazyGridPositionedItem.mo1565getOffsetnOccac(), i, 0, 2, null);
        int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            itemInfo.getPlaceables().add(new PlaceableInfo(m5330copyiSbpLlY$default, lazyGridPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridPositionedItem lazyGridPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyGridItemPlacementAnimator.m1567getMainAxisgyyYBs(lazyGridPositionedItem.mo1565getOffsetnOccac());
        }
        return lazyGridItemPlacementAnimator.createItemInfo(lazyGridPositionedItem, i);
    }

    private final int getLine(LazyGridPositionedItem lazyGridPositionedItem) {
        return this.isVertical ? lazyGridPositionedItem.getRow() : lazyGridPositionedItem.getColumn();
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1567getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5335getYimpl(j) : IntOffset.m5334getXimpl(j);
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List<PlaceableInfo> placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = placeables.get(i2);
            long m1611getTargetOffsetnOccac = placeableInfo.m1611getTargetOffsetnOccac();
            long m1555getNotAnimatableDeltanOccac = itemInfo.m1555getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1611getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(m1611getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac));
            if (m1567getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m1567getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem lazyGridPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyGridPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (true) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (itemInfo.getPlaceables().size() >= lazyGridPositionedItem.getPlaceablesCount()) {
                break;
            }
            int size = itemInfo.getPlaceables().size();
            long mo1565getOffsetnOccac = lazyGridPositionedItem.mo1565getOffsetnOccac();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long m1555getNotAnimatableDeltanOccac = itemInfo.m1555getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(mo1565getOffsetnOccac) - IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(mo1565getOffsetnOccac) - IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac)), lazyGridPositionedItem.getMainAxisSize(size), defaultConstructorMarker));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long m1611getTargetOffsetnOccac = placeableInfo.m1611getTargetOffsetnOccac();
            long m1555getNotAnimatableDeltanOccac2 = itemInfo.m1555getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1611getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac2), IntOffset.m5335getYimpl(m1611getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac2));
            long mo1565getOffsetnOccac2 = lazyGridPositionedItem.mo1565getOffsetnOccac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyGridPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m5333equalsimpl0(IntOffset, mo1565getOffsetnOccac2)) {
                long m1555getNotAnimatableDeltanOccac3 = itemInfo.m1555getNotAnimatableDeltanOccac();
                placeableInfo.m1612setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(mo1565getOffsetnOccac2) - IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac3), IntOffset.m5335getYimpl(mo1565getOffsetnOccac2) - IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m1568toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m1569getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long m5343unboximpl = placeableInfo.getAnimatedOffset().getValue().m5343unboximpl();
        long m1555getNotAnimatableDeltanOccac = itemInfo.m1555getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m5343unboximpl) + IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(m5343unboximpl) + IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac));
        long m1611getTargetOffsetnOccac = placeableInfo.m1611getTargetOffsetnOccac();
        long m1555getNotAnimatableDeltanOccac2 = itemInfo.m1555getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1611getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac2), IntOffset.m5335getYimpl(m1611getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m1567getMainAxisgyyYBs(IntOffset2) <= i2 && m1567getMainAxisgyyYBs(IntOffset) < i2) || (m1567getMainAxisgyyYBs(IntOffset2) >= i3 && m1567getMainAxisgyyYBs(IntOffset) > i3))) {
            d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void onMeasured(int i, int i2, int i3, @NotNull List<LazyGridPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, @NotNull LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        boolean z;
        boolean z2;
        int i4;
        Intrinsics.checkNotNullParameter(list, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                z = false;
                break;
            } else {
                if (list.get(i6).getHasAnimations()) {
                    z = true;
                    break;
                }
                i6++;
            }
        }
        if (!z && this.keyToItemInfoMap.isEmpty()) {
            reset();
            return;
        }
        int i7 = this.firstVisibleIndex;
        LazyGridPositionedItem lazyGridPositionedItem = (LazyGridPositionedItem) CollectionsKt.firstOrNull(list);
        this.firstVisibleIndex = lazyGridPositionedItem != null ? lazyGridPositionedItem.getIndex() : 0;
        final Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m1568toOffsetBjo55l4 = m1568toOffsetBjo55l4(i);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = list.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyGridPositionedItem lazyGridPositionedItem2 = list.get(i9);
            this.movingAwayKeys.remove(lazyGridPositionedItem2.getKey());
            if (lazyGridPositionedItem2.getHasAnimations()) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridPositionedItem2.getKey());
                if (itemInfo == null) {
                    Integer num = map.get(lazyGridPositionedItem2.getKey());
                    if (num == null || lazyGridPositionedItem2.getIndex() == num.intValue()) {
                        i4 = i7;
                        this.keyToItemInfoMap.put(lazyGridPositionedItem2.getKey(), createItemInfo$default(this, lazyGridPositionedItem2, i5, 2, null));
                    } else {
                        if (num.intValue() < i7) {
                            this.movingInFromStartBound.add(lazyGridPositionedItem2);
                        } else {
                            this.movingInFromEndBound.add(lazyGridPositionedItem2);
                        }
                        i4 = i7;
                    }
                } else {
                    i4 = i7;
                    long m1555getNotAnimatableDeltanOccac = itemInfo.m1555getNotAnimatableDeltanOccac();
                    itemInfo.m1556setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1555getNotAnimatableDeltanOccac) + IntOffset.m5334getXimpl(m1568toOffsetBjo55l4), IntOffset.m5335getYimpl(m1555getNotAnimatableDeltanOccac) + IntOffset.m5335getYimpl(m1568toOffsetBjo55l4)));
                    itemInfo.setCrossAxisSize(lazyGridPositionedItem2.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(lazyGridPositionedItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyGridPositionedItem2, itemInfo);
                }
            } else {
                i4 = i7;
                this.keyToItemInfoMap.remove(lazyGridPositionedItem2.getKey());
            }
            i9++;
            i7 = i4;
            i5 = 0;
        }
        List<LazyGridPositionedItem> list2 = this.movingInFromStartBound;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyGridPositionedItem) t2).getKey()), (Integer) map.get(((LazyGridPositionedItem) t).getKey()));
                }
            });
        }
        List<LazyGridPositionedItem> list3 = this.movingInFromStartBound;
        int size3 = list3.size();
        int i10 = -1;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        while (i11 < size3) {
            LazyGridPositionedItem lazyGridPositionedItem3 = list3.get(i11);
            int line = getLine(lazyGridPositionedItem3);
            if (line == i10 || line != i12) {
                i13 += i14;
                i14 = lazyGridPositionedItem3.getMainAxisSize();
                i12 = line;
            } else {
                i14 = Math.max(i14, lazyGridPositionedItem3.getMainAxisSize());
            }
            ItemInfo createItemInfo = createItemInfo(lazyGridPositionedItem3, (0 - i13) - lazyGridPositionedItem3.getMainAxisSize());
            this.keyToItemInfoMap.put(lazyGridPositionedItem3.getKey(), createItemInfo);
            startAnimationsIfNeeded(lazyGridPositionedItem3, createItemInfo);
            i11++;
            i10 = -1;
        }
        List<LazyGridPositionedItem> list4 = this.movingInFromEndBound;
        if (list4.size() > 1) {
            CollectionsKt.sortWith(list4, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyGridPositionedItem) t).getKey()), (Integer) map.get(((LazyGridPositionedItem) t2).getKey()));
                }
            });
        }
        List<LazyGridPositionedItem> list5 = this.movingInFromEndBound;
        int size4 = list5.size();
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size4; i18++) {
            LazyGridPositionedItem lazyGridPositionedItem4 = list5.get(i18);
            int line2 = getLine(lazyGridPositionedItem4);
            if (line2 == -1 || line2 != i15) {
                i16 += i17;
                i17 = lazyGridPositionedItem4.getMainAxisSize();
                i15 = line2;
            } else {
                i17 = Math.max(i17, lazyGridPositionedItem4.getMainAxisSize());
            }
            ItemInfo createItemInfo2 = createItemInfo(lazyGridPositionedItem4, i8 + i16);
            this.keyToItemInfoMap.put(lazyGridPositionedItem4.getKey(), createItemInfo2);
            startAnimationsIfNeeded(lazyGridPositionedItem4, createItemInfo2);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            Integer num2 = this.keyToIndexMap.get(obj);
            List<PlaceableInfo> placeables = itemInfo2.getPlaceables();
            int size5 = placeables.size();
            int i19 = 0;
            while (true) {
                if (i19 >= size5) {
                    z2 = false;
                    break;
                } else {
                    if (placeables.get(i19).getInProgress()) {
                        z2 = true;
                        break;
                    }
                    i19++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || !(z2 || isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyMeasuredItem m1591getAndMeasureednRnyU$default = LazyMeasuredItemProvider.m1591getAndMeasureednRnyU$default(lazyMeasuredItemProvider, ItemIndex.m1544constructorimpl(num2.intValue()), 0, this.isVertical ? Constraints.Companion.m5194fixedWidthOenEA2s(itemInfo2.getCrossAxisSize()) : Constraints.Companion.m5193fixedHeightOenEA2s(itemInfo2.getCrossAxisSize()), 2, null);
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m1591getAndMeasureednRnyU$default);
                } else {
                    this.movingAwayToEndBound.add(m1591getAndMeasureednRnyU$default);
                }
            }
        }
        List<LazyMeasuredItem> list6 = this.movingAwayToStartBound;
        if (list6.size() > 1) {
            CollectionsKt.sortWith(list6, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    Integer num3 = (Integer) map2.get(((LazyMeasuredItem) t2).getKey());
                    map3 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues(num3, (Integer) map3.get(((LazyMeasuredItem) t).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list7 = this.movingAwayToStartBound;
        int size6 = list7.size();
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        for (int i23 = 0; i23 < size6; i23++) {
            LazyMeasuredItem lazyMeasuredItem = list7.get(i23);
            int m1587getLineIndexOfItem_Ze7BM = lazyGridSpanLayoutProvider.m1587getLineIndexOfItem_Ze7BM(lazyMeasuredItem.m1590getIndexVZbfaAc());
            if (m1587getLineIndexOfItem_Ze7BM == -1 || m1587getLineIndexOfItem_Ze7BM != i22) {
                i20 += i21;
                i21 = lazyMeasuredItem.getMainAxisSize();
                i22 = m1587getLineIndexOfItem_Ze7BM;
            } else {
                i21 = Math.max(i21, lazyMeasuredItem.getMainAxisSize());
            }
            int mainAxisSize = (0 - i20) - lazyMeasuredItem.getMainAxisSize();
            ItemInfo itemInfo3 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem.getKey());
            LazyGridPositionedItem position = lazyMeasuredItem.position(mainAxisSize, itemInfo3.getCrossAxisOffset(), i2, i3, -1, -1);
            list.add(position);
            startAnimationsIfNeeded(position, itemInfo3);
        }
        List<LazyMeasuredItem> list8 = this.movingAwayToEndBound;
        if (list8.size() > 1) {
            CollectionsKt.sortWith(list8, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    Integer num3 = (Integer) map2.get(((LazyMeasuredItem) t).getKey());
                    map3 = LazyGridItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues(num3, (Integer) map3.get(((LazyMeasuredItem) t2).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list9 = this.movingAwayToEndBound;
        int size7 = list9.size();
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < size7; i27++) {
            LazyMeasuredItem lazyMeasuredItem2 = list9.get(i27);
            int m1587getLineIndexOfItem_Ze7BM2 = lazyGridSpanLayoutProvider.m1587getLineIndexOfItem_Ze7BM(lazyMeasuredItem2.m1590getIndexVZbfaAc());
            if (m1587getLineIndexOfItem_Ze7BM2 == -1 || m1587getLineIndexOfItem_Ze7BM2 != i24) {
                i26 += i25;
                i25 = lazyMeasuredItem2.getMainAxisSize();
                i24 = m1587getLineIndexOfItem_Ze7BM2;
            } else {
                i25 = Math.max(i25, lazyMeasuredItem2.getMainAxisSize());
            }
            ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem2.getKey());
            LazyGridPositionedItem position2 = lazyMeasuredItem2.position(i8 + i26, itemInfo4.getCrossAxisOffset(), i2, i3, -1, -1);
            list.add(position2);
            startAnimationsIfNeeded(position2, itemInfo4);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.firstVisibleIndex = -1;
    }
}
