package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    private final long m299copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int i = this.isVertical ? IntOffset.getX-impl(j) : ((Number) function1.invoke(Integer.valueOf(IntOffset.getX-impl(j)))).intValue();
        boolean z = this.isVertical;
        int i2 = IntOffset.getY-impl(j);
        if (z) {
            i2 = ((Number) function1.invoke(Integer.valueOf(i2))).intValue();
        }
        return IntOffsetKt.IntOffset(i, i2);
    }

    @Nullable
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i) {
        Object parentData = this.placeables.get(i).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public int getColumn() {
        return this.column;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.getX-impl(m300getOffsetnOccac()) : IntOffset.getY-impl(m300getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.getWidth-impl(m301getSizeYbymL2g()) : IntSize.getHeight-impl(m301getSizeYbymL2g());
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize(int i) {
        return getMainAxisSize(this.placeables.get(i));
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public long m300getOffsetnOccac() {
        return this.offset;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public int getRow() {
        return this.row;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public long m301getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.placeables.get(i);
            long j = getAnimationSpec(i) != null ? this.placementAnimator.getAnimatedOffset-YT5a7pE(getKey(), i, this.minMainAxisOffset - getMainAxisSize(placeable), this.maxMainAxisOffset, m300getOffsetnOccac()) : m300getOffsetnOccac();
            if (this.reverseLayout) {
                j = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.getX-impl(j) : (this.mainAxisLayoutSize - IntOffset.getX-impl(j)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.getY-impl(j)) - getMainAxisSize(placeable) : IntOffset.getY-impl(j));
            }
            if (this.isVertical) {
                long j2 = this.visualOffset;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.getX-impl(j) + IntOffset.getX-impl(j2), IntOffset.getY-impl(j) + IntOffset.getY-impl(j2)), 0.0f, (Function1) null, 6, (Object) null);
            } else {
                long j3 = this.visualOffset;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.getX-impl(j) + IntOffset.getX-impl(j3), IntOffset.getY-impl(j) + IntOffset.getY-impl(j3)), 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    public final int getMainAxisSize() {
        return this.isVertical ? IntSize.getHeight-impl(m301getSizeYbymL2g()) : IntSize.getWidth-impl(m301getSizeYbymL2g());
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
