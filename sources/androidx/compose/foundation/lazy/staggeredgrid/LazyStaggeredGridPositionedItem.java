package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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

    public int getIndex() {
        return this.index;
    }

    @NotNull
    public Object getKey() {
        return this.key;
    }

    public int getLane() {
        return this.lane;
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public long m330getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public long m331getSizeYbymL2g() {
        return this.size;
    }

    public final void place(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            if (this.isVertical) {
                long m330getOffsetnOccac = m330getOffsetnOccac();
                long j = this.contentOffset;
                Placeable.PlacementScope.placeWithLayer-aW-9-wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.getX-impl(m330getOffsetnOccac) + IntOffset.getX-impl(j), IntOffset.getY-impl(m330getOffsetnOccac) + IntOffset.getY-impl(j)), 0.0f, (Function1) null, 6, (Object) null);
            } else {
                long m330getOffsetnOccac2 = m330getOffsetnOccac();
                long j2 = this.contentOffset;
                Placeable.PlacementScope.placeRelativeWithLayer-aW-9-wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.getX-impl(m330getOffsetnOccac2) + IntOffset.getX-impl(j2), IntOffset.getY-impl(m330getOffsetnOccac2) + IntOffset.getY-impl(j2)), 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }
}
