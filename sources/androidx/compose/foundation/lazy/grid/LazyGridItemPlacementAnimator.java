package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
        long m2639copyiSbpLlY$default = this.isVertical ? IntOffset.m2639copyiSbpLlY$default(lazyGridPositionedItem.getOffset-nOcc-ac(), 0, i, 1, null) : IntOffset.m2639copyiSbpLlY$default(lazyGridPositionedItem.getOffset-nOcc-ac(), i, 0, 2, null);
        int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            itemInfo.getPlaceables().add(new PlaceableInfo(m2639copyiSbpLlY$default, lazyGridPositionedItem.getMainAxisSize(i2), null));
        }
        return itemInfo;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridPositionedItem lazyGridPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyGridItemPlacementAnimator.m455getMainAxisgyyYBs(lazyGridPositionedItem.getOffset-nOcc-ac());
        }
        return lazyGridItemPlacementAnimator.createItemInfo(lazyGridPositionedItem, i);
    }

    private final int getLine(LazyGridPositionedItem lazyGridPositionedItem) {
        return this.isVertical ? lazyGridPositionedItem.getRow() : lazyGridPositionedItem.getColumn();
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m455getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m2644getYimpl(j) : IntOffset.m2643getXimpl(j);
    }

    private final boolean isWithinBounds(ItemInfo itemInfo, int i) {
        List placeables = itemInfo.getPlaceables();
        int size = placeables.size();
        for (int i2 = 0; i2 < size; i2++) {
            PlaceableInfo placeableInfo = (PlaceableInfo) placeables.get(i2);
            long m487getTargetOffsetnOccac = placeableInfo.m487getTargetOffsetnOccac();
            long j = itemInfo.getNotAnimatableDelta-nOcc-ac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m487getTargetOffsetnOccac) + IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(m487getTargetOffsetnOccac) + IntOffset.m2644getYimpl(j));
            if (m455getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m455getMainAxisgyyYBs(IntOffset) < i) {
                return true;
            }
        }
        return false;
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem lazyGridPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyGridPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyGridPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long j = lazyGridPositionedItem.getOffset-nOcc-ac();
            List placeables = itemInfo.getPlaceables();
            long j2 = itemInfo.getNotAnimatableDelta-nOcc-ac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) - IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) - IntOffset.m2644getYimpl(j2)), lazyGridPositionedItem.getMainAxisSize(size), null));
        }
        List placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = (PlaceableInfo) placeables2.get(i);
            long m487getTargetOffsetnOccac = placeableInfo.m487getTargetOffsetnOccac();
            long j3 = itemInfo.getNotAnimatableDelta-nOcc-ac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m487getTargetOffsetnOccac) + IntOffset.m2643getXimpl(j3), IntOffset.m2644getYimpl(m487getTargetOffsetnOccac) + IntOffset.m2644getYimpl(j3));
            long j4 = lazyGridPositionedItem.getOffset-nOcc-ac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec animationSpec = lazyGridPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m2642equalsimpl0(IntOffset, j4)) {
                long j5 = itemInfo.getNotAnimatableDelta-nOcc-ac();
                placeableInfo.m488setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j4) - IntOffset.m2643getXimpl(j5), IntOffset.m2644getYimpl(j4) - IntOffset.m2644getYimpl(j5)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new startAnimationsIfNeeded.1.1(placeableInfo, animationSpec, (Continuation) null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m456toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m457getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = (PlaceableInfo) itemInfo.getPlaceables().get(i);
        long m2652unboximpl = ((IntOffset) placeableInfo.getAnimatedOffset().getValue()).m2652unboximpl();
        long j2 = itemInfo.getNotAnimatableDelta-nOcc-ac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m2652unboximpl) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(m2652unboximpl) + IntOffset.m2644getYimpl(j2));
        long m487getTargetOffsetnOccac = placeableInfo.m487getTargetOffsetnOccac();
        long j3 = itemInfo.getNotAnimatableDelta-nOcc-ac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m487getTargetOffsetnOccac) + IntOffset.m2643getXimpl(j3), IntOffset.m2644getYimpl(m487getTargetOffsetnOccac) + IntOffset.m2644getYimpl(j3));
        if (placeableInfo.getInProgress() && ((m455getMainAxisgyyYBs(IntOffset2) <= i2 && m455getMainAxisgyyYBs(IntOffset) < i2) || (m455getMainAxisgyyYBs(IntOffset2) >= i3 && m455getMainAxisgyyYBs(IntOffset) > i3))) {
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
        Map<Object, Integer> map = this.keyToIndexMap;
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
        int i8 = this.isVertical ? i3 : i2;
        long m456toOffsetBjo55l4 = m456toOffsetBjo55l4(i);
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
                    long j = itemInfo.getNotAnimatableDelta-nOcc-ac();
                    itemInfo.setNotAnimatableDelta--gyyYBs(IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(m456toOffsetBjo55l4), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(m456toOffsetBjo55l4)));
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
            CollectionsKt.sortWith(list2, new LazyGridItemPlacementAnimator$onMeasured$.inlined.sortByDescending.1(map));
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
            CollectionsKt.sortWith(list4, new LazyGridItemPlacementAnimator$onMeasured$.inlined.sortBy.1(map));
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
            List placeables = itemInfo2.getPlaceables();
            int size5 = placeables.size();
            int i19 = 0;
            while (true) {
                if (i19 >= size5) {
                    z2 = false;
                    break;
                } else {
                    if (((PlaceableInfo) placeables.get(i19)).getInProgress()) {
                        z2 = true;
                        break;
                    }
                    i19++;
                }
            }
            if (itemInfo2.getPlaceables().isEmpty() || num2 == null || ((!z2 && Intrinsics.areEqual(num2, map.get(obj))) || !(z2 || isWithinBounds(itemInfo2, i8)))) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyMeasuredItem lazyMeasuredItem = LazyMeasuredItemProvider.getAndMeasure-ednRnyU$default(lazyMeasuredItemProvider, ItemIndex.m441constructorimpl(num2.intValue()), 0, this.isVertical ? Constraints.Companion.fixedWidth-OenEA2s(itemInfo2.getCrossAxisSize()) : Constraints.Companion.fixedHeight-OenEA2s(itemInfo2.getCrossAxisSize()), 2, (Object) null);
                if (num2.intValue() < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(lazyMeasuredItem);
                } else {
                    this.movingAwayToEndBound.add(lazyMeasuredItem);
                }
            }
        }
        List<LazyMeasuredItem> list6 = this.movingAwayToStartBound;
        if (list6.size() > 1) {
            CollectionsKt.sortWith(list6, new LazyGridItemPlacementAnimator$onMeasured$.inlined.sortByDescending.2(this));
        }
        List<LazyMeasuredItem> list7 = this.movingAwayToStartBound;
        int size6 = list7.size();
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        for (int i23 = 0; i23 < size6; i23++) {
            LazyMeasuredItem lazyMeasuredItem2 = list7.get(i23);
            int m467getLineIndexOfItem_Ze7BM = lazyGridSpanLayoutProvider.m467getLineIndexOfItem_Ze7BM(lazyMeasuredItem2.getIndex-VZbfaAc());
            if (m467getLineIndexOfItem_Ze7BM == -1 || m467getLineIndexOfItem_Ze7BM != i22) {
                i20 += i21;
                i21 = lazyMeasuredItem2.getMainAxisSize();
                i22 = m467getLineIndexOfItem_Ze7BM;
            } else {
                i21 = Math.max(i21, lazyMeasuredItem2.getMainAxisSize());
            }
            int mainAxisSize = (0 - i20) - lazyMeasuredItem2.getMainAxisSize();
            ItemInfo itemInfo3 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem2.getKey());
            LazyGridPositionedItem position = lazyMeasuredItem2.position(mainAxisSize, itemInfo3.getCrossAxisOffset(), i2, i3, -1, -1);
            list.add(position);
            startAnimationsIfNeeded(position, itemInfo3);
        }
        List<LazyMeasuredItem> list8 = this.movingAwayToEndBound;
        if (list8.size() > 1) {
            CollectionsKt.sortWith(list8, new LazyGridItemPlacementAnimator$onMeasured$.inlined.sortBy.2(this));
        }
        List<LazyMeasuredItem> list9 = this.movingAwayToEndBound;
        int size7 = list9.size();
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < size7; i27++) {
            LazyMeasuredItem lazyMeasuredItem3 = list9.get(i27);
            int m467getLineIndexOfItem_Ze7BM2 = lazyGridSpanLayoutProvider.m467getLineIndexOfItem_Ze7BM(lazyMeasuredItem3.getIndex-VZbfaAc());
            if (m467getLineIndexOfItem_Ze7BM2 == -1 || m467getLineIndexOfItem_Ze7BM2 != i24) {
                i26 += i25;
                i25 = lazyMeasuredItem3.getMainAxisSize();
                i24 = m467getLineIndexOfItem_Ze7BM2;
            } else {
                i25 = Math.max(i25, lazyMeasuredItem3.getMainAxisSize());
            }
            ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, lazyMeasuredItem3.getKey());
            LazyGridPositionedItem position2 = lazyMeasuredItem3.position(i8 + i26, itemInfo4.getCrossAxisOffset(), i2, i3, -1, -1);
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
