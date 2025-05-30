package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
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
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
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
    private final List<LazyListPositionedItem> movingInFromEndBound;

    @NotNull
    private final List<LazyListPositionedItem> movingInFromStartBound;

    @NotNull
    private final CoroutineScope scope;

    public LazyListItemPlacementAnimator(@NotNull CoroutineScope coroutineScope, boolean z) {
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

    private final ItemInfo createItemInfo(LazyListPositionedItem lazyListPositionedItem, int i) {
        ItemInfo itemInfo = new ItemInfo();
        long m1518getOffsetBjo55l4 = lazyListPositionedItem.m1518getOffsetBjo55l4(0);
        long m5330copyiSbpLlY$default = this.isVertical ? IntOffset.m5330copyiSbpLlY$default(m1518getOffsetBjo55l4, 0, i, 1, null) : IntOffset.m5330copyiSbpLlY$default(m1518getOffsetBjo55l4, i, 0, 2, null);
        int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            long m1518getOffsetBjo55l42 = lazyListPositionedItem.m1518getOffsetBjo55l4(i2);
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1518getOffsetBjo55l42) - IntOffset.m5334getXimpl(m1518getOffsetBjo55l4), IntOffset.m5335getYimpl(m1518getOffsetBjo55l42) - IntOffset.m5335getYimpl(m1518getOffsetBjo55l4));
            itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m5330copyiSbpLlY$default) + IntOffset.m5334getXimpl(IntOffset), IntOffset.m5335getYimpl(m5330copyiSbpLlY$default) + IntOffset.m5335getYimpl(IntOffset)), lazyListPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListPositionedItem lazyListPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyListItemPlacementAnimator.m1504getMainAxisgyyYBs(lazyListPositionedItem.m1518getOffsetBjo55l4(0));
        }
        return lazyListItemPlacementAnimator.createItemInfo(lazyListPositionedItem, i);
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1504getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5335getYimpl(j) : IntOffset.m5334getXimpl(j);
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List<PlaceableInfo> placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = placeables.get(i2);
            long m1530getTargetOffsetnOccac = placeableInfo.m1530getTargetOffsetnOccac();
            long m1495getNotAnimatableDeltanOccac = itemInfo.m1495getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1530getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(m1530getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac));
            if (m1504getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m1504getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (true) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (itemInfo.getPlaceables().size() >= lazyListPositionedItem.getPlaceablesCount()) {
                break;
            }
            int size = itemInfo.getPlaceables().size();
            long m1518getOffsetBjo55l4 = lazyListPositionedItem.m1518getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long m1495getNotAnimatableDeltanOccac = itemInfo.m1495getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1518getOffsetBjo55l4) - IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(m1518getOffsetBjo55l4) - IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac)), lazyListPositionedItem.getMainAxisSize(size), defaultConstructorMarker));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long m1530getTargetOffsetnOccac = placeableInfo.m1530getTargetOffsetnOccac();
            long m1495getNotAnimatableDeltanOccac2 = itemInfo.m1495getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1530getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac2), IntOffset.m5335getYimpl(m1530getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac2));
            long m1518getOffsetBjo55l42 = lazyListPositionedItem.m1518getOffsetBjo55l4(i);
            placeableInfo.setMainAxisSize(lazyListPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m5333equalsimpl0(IntOffset, m1518getOffsetBjo55l42)) {
                long m1495getNotAnimatableDeltanOccac3 = itemInfo.m1495getNotAnimatableDeltanOccac();
                placeableInfo.m1531setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1518getOffsetBjo55l42) - IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac3), IntOffset.m5335getYimpl(m1518getOffsetBjo55l42) - IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m1505toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m1506getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long m5343unboximpl = placeableInfo.getAnimatedOffset().getValue().m5343unboximpl();
        long m1495getNotAnimatableDeltanOccac = itemInfo.m1495getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m5343unboximpl) + IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac), IntOffset.m5335getYimpl(m5343unboximpl) + IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac));
        long m1530getTargetOffsetnOccac = placeableInfo.m1530getTargetOffsetnOccac();
        long m1495getNotAnimatableDeltanOccac2 = itemInfo.m1495getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1530getTargetOffsetnOccac) + IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac2), IntOffset.m5335getYimpl(m1530getTargetOffsetnOccac) + IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac2));
        if (placeableInfo.getInProgress() && ((m1504getMainAxisgyyYBs(IntOffset2) <= i2 && m1504getMainAxisgyyYBs(IntOffset) <= i2) || (m1504getMainAxisgyyYBs(IntOffset2) >= i3 && m1504getMainAxisgyyYBs(IntOffset) >= i3))) {
            d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void onMeasured(int i, int i2, int i3, @NotNull List<LazyListPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z;
        boolean z2;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(list, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "itemProvider");
        int size = list.size();
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
        LazyListPositionedItem lazyListPositionedItem = (LazyListPositionedItem) CollectionsKt.firstOrNull(list);
        this.firstVisibleIndex = lazyListPositionedItem != null ? lazyListPositionedItem.getIndex() : 0;
        final Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m1505toOffsetBjo55l4 = m1505toOffsetBjo55l4(i);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = list.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyListPositionedItem lazyListPositionedItem2 = list.get(i9);
            this.movingAwayKeys.remove(lazyListPositionedItem2.getKey());
            if (lazyListPositionedItem2.getHasAnimations()) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyListPositionedItem2.getKey());
                if (itemInfo == null) {
                    Integer num = map.get(lazyListPositionedItem2.getKey());
                    if (num == null || lazyListPositionedItem2.getIndex() == num.intValue()) {
                        i4 = i7;
                        i5 = size2;
                        this.keyToItemInfoMap.put(lazyListPositionedItem2.getKey(), createItemInfo$default(this, lazyListPositionedItem2, 0, 2, null));
                    } else {
                        if (num.intValue() < i7) {
                            this.movingInFromStartBound.add(lazyListPositionedItem2);
                        } else {
                            this.movingInFromEndBound.add(lazyListPositionedItem2);
                        }
                        i4 = i7;
                        i5 = size2;
                    }
                } else {
                    i4 = i7;
                    i5 = size2;
                    long m1495getNotAnimatableDeltanOccac = itemInfo.m1495getNotAnimatableDeltanOccac();
                    itemInfo.m1496setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1495getNotAnimatableDeltanOccac) + IntOffset.m5334getXimpl(m1505toOffsetBjo55l4), IntOffset.m5335getYimpl(m1495getNotAnimatableDeltanOccac) + IntOffset.m5335getYimpl(m1505toOffsetBjo55l4)));
                    startAnimationsIfNeeded(lazyListPositionedItem2, itemInfo);
                }
            } else {
                i4 = i7;
                i5 = size2;
                this.keyToItemInfoMap.remove(lazyListPositionedItem2.getKey());
            }
            i9++;
            size2 = i5;
            i7 = i4;
        }
        int i10 = 0;
        List<LazyListPositionedItem> list2 = this.movingInFromStartBound;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyListPositionedItem) t2).getKey()), (Integer) map.get(((LazyListPositionedItem) t).getKey()));
                }
            });
        }
        List<LazyListPositionedItem> list3 = this.movingInFromStartBound;
        int size3 = list3.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size3; i12++) {
            LazyListPositionedItem lazyListPositionedItem3 = list3.get(i12);
            int size4 = (0 - i11) - lazyListPositionedItem3.getSize();
            i11 += lazyListPositionedItem3.getSize();
            ItemInfo createItemInfo = createItemInfo(lazyListPositionedItem3, size4);
            this.keyToItemInfoMap.put(lazyListPositionedItem3.getKey(), createItemInfo);
            startAnimationsIfNeeded(lazyListPositionedItem3, createItemInfo);
        }
        List<LazyListPositionedItem> list4 = this.movingInFromEndBound;
        if (list4.size() > 1) {
            CollectionsKt.sortWith(list4, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) map.get(((LazyListPositionedItem) t).getKey()), (Integer) map.get(((LazyListPositionedItem) t2).getKey()));
                }
            });
        }
        List<LazyListPositionedItem> list5 = this.movingInFromEndBound;
        int size5 = list5.size();
        int i13 = 0;
        for (int i14 = 0; i14 < size5; i14++) {
            LazyListPositionedItem lazyListPositionedItem4 = list5.get(i14);
            int i15 = i8 + i13;
            i13 += lazyListPositionedItem4.getSize();
            ItemInfo createItemInfo2 = createItemInfo(lazyListPositionedItem4, i15);
            this.keyToItemInfoMap.put(lazyListPositionedItem4.getKey(), createItemInfo2);
            startAnimationsIfNeeded(lazyListPositionedItem4, createItemInfo2);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, obj);
            Integer num2 = this.keyToIndexMap.get(obj);
            List<PlaceableInfo> placeables = itemInfo2.getPlaceables();
            int size6 = placeables.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size6) {
                    z2 = false;
                    break;
                } else {
                    if (placeables.get(i16).getInProgress()) {
                        z2 = true;
                        break;
                    }
                    i16++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || !(z2 || isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyMeasuredItem m1526getAndMeasureZjPyQlc = lazyMeasuredItemProvider.m1526getAndMeasureZjPyQlc(DataIndex.m1483constructorimpl(num2.intValue()));
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m1526getAndMeasureZjPyQlc);
                } else {
                    this.movingAwayToEndBound.add(m1526getAndMeasureZjPyQlc);
                }
            }
        }
        List<LazyMeasuredItem> list6 = this.movingAwayToStartBound;
        if (list6.size() > 1) {
            CollectionsKt.sortWith(list6, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    Integer num3 = (Integer) map2.get(((LazyMeasuredItem) t2).getKey());
                    map3 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues(num3, (Integer) map3.get(((LazyMeasuredItem) t).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list7 = this.movingAwayToStartBound;
        int size7 = list7.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size7; i18++) {
            LazyMeasuredItem lazyMeasuredItem = list7.get(i18);
            int size8 = (0 - i17) - lazyMeasuredItem.getSize();
            i17 += lazyMeasuredItem.getSize();
            ItemInfo itemInfo3 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem.getKey());
            LazyListPositionedItem position = lazyMeasuredItem.position(size8, i2, i3);
            list.add(position);
            startAnimationsIfNeeded(position, itemInfo3);
        }
        List<LazyMeasuredItem> list8 = this.movingAwayToEndBound;
        if (list8.size() > 1) {
            CollectionsKt.sortWith(list8, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map map2;
                    Map map3;
                    map2 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    Integer num3 = (Integer) map2.get(((LazyMeasuredItem) t).getKey());
                    map3 = LazyListItemPlacementAnimator.this.keyToIndexMap;
                    return ComparisonsKt.compareValues(num3, (Integer) map3.get(((LazyMeasuredItem) t2).getKey()));
                }
            });
        }
        List<LazyMeasuredItem> list9 = this.movingAwayToEndBound;
        int size9 = list9.size();
        for (int i19 = 0; i19 < size9; i19++) {
            LazyMeasuredItem lazyMeasuredItem2 = list9.get(i19);
            int i20 = i8 + i10;
            i10 += lazyMeasuredItem2.getSize();
            ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem2.getKey());
            LazyListPositionedItem position2 = lazyMeasuredItem2.position(i20, i2, i3);
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
