package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
        long m266getOffsetBjo55l4 = lazyListPositionedItem.m266getOffsetBjo55l4(0);
        long j = this.isVertical ? IntOffset.copy-iSbpLlY$default(m266getOffsetBjo55l4, 0, i, 1, (Object) null) : IntOffset.copy-iSbpLlY$default(m266getOffsetBjo55l4, i, 0, 2, (Object) null);
        int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            long m266getOffsetBjo55l42 = lazyListPositionedItem.m266getOffsetBjo55l4(i2);
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.getX-impl(m266getOffsetBjo55l42) - IntOffset.getX-impl(m266getOffsetBjo55l4), IntOffset.getY-impl(m266getOffsetBjo55l42) - IntOffset.getY-impl(m266getOffsetBjo55l4));
            itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.getX-impl(j) + IntOffset.getX-impl(IntOffset), IntOffset.getY-impl(j) + IntOffset.getY-impl(IntOffset)), lazyListPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListPositionedItem lazyListPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyListItemPlacementAnimator.m256getMainAxisgyyYBs(lazyListPositionedItem.m266getOffsetBjo55l4(0));
        }
        return lazyListItemPlacementAnimator.createItemInfo(lazyListPositionedItem, i);
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m256getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.getY-impl(j) : IntOffset.getX-impl(j);
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = (PlaceableInfo) placeables.get(i2);
            long m271getTargetOffsetnOccac = placeableInfo.m271getTargetOffsetnOccac();
            long j = itemInfo.getNotAnimatableDelta-nOcc-ac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.getX-impl(m271getTargetOffsetnOccac) + IntOffset.getX-impl(j), IntOffset.getY-impl(m271getTargetOffsetnOccac) + IntOffset.getY-impl(j));
            if (m256getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m256getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyListPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long m266getOffsetBjo55l4 = lazyListPositionedItem.m266getOffsetBjo55l4(size);
            List placeables = itemInfo.getPlaceables();
            long j = itemInfo.getNotAnimatableDelta-nOcc-ac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.getX-impl(m266getOffsetBjo55l4) - IntOffset.getX-impl(j), IntOffset.getY-impl(m266getOffsetBjo55l4) - IntOffset.getY-impl(j)), lazyListPositionedItem.getMainAxisSize(size), null));
        }
        List placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = (PlaceableInfo) placeables2.get(i);
            long m271getTargetOffsetnOccac = placeableInfo.m271getTargetOffsetnOccac();
            long j2 = itemInfo.getNotAnimatableDelta-nOcc-ac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.getX-impl(m271getTargetOffsetnOccac) + IntOffset.getX-impl(j2), IntOffset.getY-impl(m271getTargetOffsetnOccac) + IntOffset.getY-impl(j2));
            long m266getOffsetBjo55l42 = lazyListPositionedItem.m266getOffsetBjo55l4(i);
            placeableInfo.setMainAxisSize(lazyListPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem.getAnimationSpec(i);
            if (!IntOffset.equals-impl0(IntOffset, m266getOffsetBjo55l42)) {
                long j3 = itemInfo.getNotAnimatableDelta-nOcc-ac();
                placeableInfo.m272setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.getX-impl(m266getOffsetBjo55l42) - IntOffset.getX-impl(j3), IntOffset.getY-impl(m266getOffsetBjo55l42) - IntOffset.getY-impl(j3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m257toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m258getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = (PlaceableInfo) itemInfo.getPlaceables().get(i);
        long j2 = placeableInfo.getAnimatedOffset().getValue().unbox-impl();
        long j3 = itemInfo.getNotAnimatableDelta-nOcc-ac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.getX-impl(j2) + IntOffset.getX-impl(j3), IntOffset.getY-impl(j2) + IntOffset.getY-impl(j3));
        long m271getTargetOffsetnOccac = placeableInfo.m271getTargetOffsetnOccac();
        long j4 = itemInfo.getNotAnimatableDelta-nOcc-ac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.getX-impl(m271getTargetOffsetnOccac) + IntOffset.getX-impl(j4), IntOffset.getY-impl(m271getTargetOffsetnOccac) + IntOffset.getY-impl(j4));
        if (placeableInfo.getInProgress() && ((m256getMainAxisgyyYBs(IntOffset2) <= i2 && m256getMainAxisgyyYBs(IntOffset) <= i2) || (m256getMainAxisgyyYBs(IntOffset2) >= i3 && m256getMainAxisgyyYBs(IntOffset) >= i3))) {
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
        Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m257toOffsetBjo55l4 = m257toOffsetBjo55l4(i);
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
                    long j = itemInfo.getNotAnimatableDelta-nOcc-ac();
                    itemInfo.setNotAnimatableDelta--gyyYBs(IntOffsetKt.IntOffset(IntOffset.getX-impl(j) + IntOffset.getX-impl(m257toOffsetBjo55l4), IntOffset.getY-impl(j) + IntOffset.getY-impl(m257toOffsetBjo55l4)));
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
            CollectionsKt.sortWith(list2, new LazyListItemPlacementAnimator$onMeasured$.inlined.sortByDescending.1(map));
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
            CollectionsKt.sortWith(list4, new LazyListItemPlacementAnimator$onMeasured$.inlined.sortBy.1(map));
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
            List placeables = itemInfo2.getPlaceables();
            int size6 = placeables.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size6) {
                    z2 = false;
                    break;
                } else {
                    if (((PlaceableInfo) placeables.get(i16)).getInProgress()) {
                        z2 = true;
                        break;
                    }
                    i16++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || !(z2 || isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyMeasuredItem m267getAndMeasureZjPyQlc = lazyMeasuredItemProvider.m267getAndMeasureZjPyQlc(DataIndex.m245constructorimpl(num2.intValue()));
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(m267getAndMeasureZjPyQlc);
                } else {
                    this.movingAwayToEndBound.add(m267getAndMeasureZjPyQlc);
                }
            }
        }
        List<LazyMeasuredItem> list6 = this.movingAwayToStartBound;
        if (list6.size() > 1) {
            CollectionsKt.sortWith(list6, new LazyListItemPlacementAnimator$onMeasured$.inlined.sortByDescending.2(this));
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
            CollectionsKt.sortWith(list8, new LazyListItemPlacementAnimator$onMeasured$.inlined.sortBy.2(this));
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
