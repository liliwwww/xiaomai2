package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntSize;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int mainAxisLayoutSize;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;

    @NotNull
    private final List<Placeable> placeables;

    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int row;
    private final long size;
    private final long visualOffset;

    /* JADX WARN: Multi-variable type inference failed */
    private LazyGridPositionedItem(long j, int i, Object obj, int i2, int i3, long j2, int i4, int i5, boolean z, List<? extends Placeable> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j3, int i6, boolean z2) {
        this.offset = j;
        this.index = i;
        this.key = obj;
        this.row = i2;
        this.column = i3;
        this.size = j2;
        this.minMainAxisOffset = i4;
        this.maxMainAxisOffset = i5;
        this.isVertical = z;
        this.placeables = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j3;
        this.mainAxisLayoutSize = i6;
        this.reverseLayout = z2;
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

    public /* synthetic */ LazyGridPositionedItem(long j, int i, Object obj, int i2, int i3, long j2, int i4, int i5, boolean z, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j3, int i6, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, obj, i2, i3, j2, i4, i5, z, list, lazyGridItemPlacementAnimator, j3, i6, z2);
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1580copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
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
        Object parentData = this.placeables.get(i).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5334getXimpl(mo1565getOffsetnOccac()) : IntOffset.m5335getYimpl(mo1565getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m5376getWidthimpl(mo1566getSizeYbymL2g()) : IntSize.m5375getHeightimpl(mo1566getSizeYbymL2g());
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize(int i) {
        return getMainAxisSize(this.placeables.get(i));
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getOffset-nOcc-ac */
    public long mo1565getOffsetnOccac() {
        return this.offset;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* renamed from: getSize-YbymL2g */
    public long mo1566getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.placeables.get(i);
            long m1569getAnimatedOffsetYT5a7pE = getAnimationSpec(i) != null ? this.placementAnimator.m1569getAnimatedOffsetYT5a7pE(getKey(), i, this.minMainAxisOffset - getMainAxisSize(placeable), this.maxMainAxisOffset, mo1565getOffsetnOccac()) : mo1565getOffsetnOccac();
            if (this.reverseLayout) {
                m1569getAnimatedOffsetYT5a7pE = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5334getXimpl(m1569getAnimatedOffsetYT5a7pE) : (this.mainAxisLayoutSize - IntOffset.m5334getXimpl(m1569getAnimatedOffsetYT5a7pE)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5335getYimpl(m1569getAnimatedOffsetYT5a7pE)) - getMainAxisSize(placeable) : IntOffset.m5335getYimpl(m1569getAnimatedOffsetYT5a7pE));
            }
            if (this.isVertical) {
                long j = this.visualOffset;
                Placeable.PlacementScope.m4226placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1569getAnimatedOffsetYT5a7pE) + IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(m1569getAnimatedOffsetYT5a7pE) + IntOffset.m5335getYimpl(j)), 0.0f, null, 6, null);
            } else {
                long j2 = this.visualOffset;
                Placeable.PlacementScope.m4225placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m1569getAnimatedOffsetYT5a7pE) + IntOffset.m5334getXimpl(j2), IntOffset.m5335getYimpl(m1569getAnimatedOffsetYT5a7pE) + IntOffset.m5335getYimpl(j2)), 0.0f, null, 6, null);
            }
        }
    }

    public final int getMainAxisSize() {
        return this.isVertical ? IntSize.m5375getHeightimpl(mo1566getSizeYbymL2g()) : IntSize.m5376getWidthimpl(mo1566getSizeYbymL2g());
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
