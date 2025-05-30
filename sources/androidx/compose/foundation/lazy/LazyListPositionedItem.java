package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LazyListPositionedItem implements LazyListItemInfo {
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int mainAxisLayoutSize;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final int offset;

    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final long visualOffset;

    @NotNull
    private final List<LazyListPlaceableWrapper> wrappers;

    private LazyListPositionedItem(int i, int i2, Object obj, int i3, int i4, int i5, boolean z, List<LazyListPlaceableWrapper> list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j, boolean z2, int i6) {
        this.offset = i;
        this.index = i2;
        this.key = obj;
        this.size = i3;
        this.minMainAxisOffset = i4;
        this.maxMainAxisOffset = i5;
        this.isVertical = z;
        this.wrappers = list;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.visualOffset = j;
        this.reverseLayout = z2;
        this.mainAxisLayoutSize = i6;
        int placeablesCount = getPlaceablesCount();
        boolean z3 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= placeablesCount) {
                break;
            }
            if (getAnimationSpec(i7) != null) {
                z3 = true;
                break;
            }
            i7++;
        }
        this.hasAnimations = z3;
    }

    public /* synthetic */ LazyListPositionedItem(int i, int i2, Object obj, int i3, int i4, int i5, boolean z, List list, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, long j, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, obj, i3, i4, i5, z, list, lazyListItemPlacementAnimator, j, z2, i6);
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1517copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int m5334getXimpl = this.isVertical ? IntOffset.m5334getXimpl(j) : ((Number) function1.invoke(Integer.valueOf(IntOffset.m5334getXimpl(j)))).intValue();
        boolean z = this.isVertical;
        int m5335getYimpl = IntOffset.m5335getYimpl(j);
        if (z) {
            m5335getYimpl = ((Number) function1.invoke(Integer.valueOf(m5335getYimpl))).intValue();
        }
        return IntOffsetKt.IntOffset(m5334getXimpl, m5335getYimpl);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i) {
        Object parentData = this.wrappers.get(i).getPlaceable().getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize(int i) {
        return getMainAxisSize(this.wrappers.get(i).getPlaceable());
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m1518getOffsetBjo55l4(int i) {
        return this.wrappers.get(i).m1516getOffsetnOccac();
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.wrappers.get(i).getPlaceable();
            long m1506getAnimatedOffsetYT5a7pE = getAnimationSpec(i) != null ? this.placementAnimator.m1506getAnimatedOffsetYT5a7pE(getKey(), i, this.minMainAxisOffset - getMainAxisSize(placeable), this.maxMainAxisOffset, m1518getOffsetBjo55l4(i)) : m1518getOffsetBjo55l4(i);
            if (this.reverseLayout) {
                m1506getAnimatedOffsetYT5a7pE = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5334getXimpl(m1506getAnimatedOffsetYT5a7pE) : (this.mainAxisLayoutSize - IntOffset.m5334getXimpl(m1506getAnimatedOffsetYT5a7pE)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5335getYimpl(m1506getAnimatedOffsetYT5a7pE)) - getMainAxisSize(placeable) : IntOffset.m5335getYimpl(m1506getAnimatedOffsetYT5a7pE));
            }
            if (this.isVertical) {
                long j = this.visualOffset;
                Placeable.PlacementScope.m4226placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1506getAnimatedOffsetYT5a7pE) + IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(m1506getAnimatedOffsetYT5a7pE) + IntOffset.m5335getYimpl(j)), 0.0f, null, 6, null);
            } else {
                long j2 = this.visualOffset;
                Placeable.PlacementScope.m4225placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1506getAnimatedOffsetYT5a7pE) + IntOffset.m5334getXimpl(j2), IntOffset.m5335getYimpl(m1506getAnimatedOffsetYT5a7pE) + IntOffset.m5335getYimpl(j2)), 0.0f, null, 6, null);
            }
        }
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
