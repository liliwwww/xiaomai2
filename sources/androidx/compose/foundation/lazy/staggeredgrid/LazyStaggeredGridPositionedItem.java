package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class LazyStaggeredGridPositionedItem implements LazyStaggeredGridItemInfo {
    private final long contentOffset;
    private final int index;
    private final boolean isVertical;

    @NotNull
    private final Object key;
    private final int lane;
    private final long offset;

    @NotNull
    private final List<Placeable> placeables;
    private final long size;

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridPositionedItem(long j, int i, int i2, Object obj, long j2, List<? extends Placeable> list, long j3, boolean z) {
        this.offset = j;
        this.index = i;
        this.lane = i2;
        this.key = obj;
        this.size = j2;
        this.placeables = list;
        this.contentOffset = j3;
        this.isVertical = z;
    }

    public /* synthetic */ LazyStaggeredGridPositionedItem(long j, int i, int i2, Object obj, long j2, List list, long j3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, i2, obj, j2, list, j3, z);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    @NotNull
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getOffset-nOcc-ac */
    public long mo1629getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getSize-YbymL2g */
    public long mo1630getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            if (this.isVertical) {
                long mo1629getOffsetnOccac = mo1629getOffsetnOccac();
                long j = this.contentOffset;
                Placeable.PlacementScope.m4226placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(mo1629getOffsetnOccac) + IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(mo1629getOffsetnOccac) + IntOffset.m5335getYimpl(j)), 0.0f, null, 6, null);
            } else {
                long mo1629getOffsetnOccac2 = mo1629getOffsetnOccac();
                long j2 = this.contentOffset;
                Placeable.PlacementScope.m4225placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(mo1629getOffsetnOccac2) + IntOffset.m5334getXimpl(j2), IntOffset.m5335getYimpl(mo1629getOffsetnOccac2) + IntOffset.m5335getYimpl(j2)), 0.0f, null, 6, null);
            }
        }
    }
}
