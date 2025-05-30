package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ItemInfo {
    private int crossAxisOffset;
    private int crossAxisSize;
    private long notAnimatableDelta = IntOffset.Companion.getZero-nOcc-ac();

    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    public ItemInfo(int i, int i2) {
        this.crossAxisSize = i;
        this.crossAxisOffset = i2;
    }

    public final int getCrossAxisOffset() {
        return this.crossAxisOffset;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* renamed from: getNotAnimatableDelta-nOcc-ac, reason: not valid java name */
    public final long m282getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    public final void setCrossAxisOffset(int i) {
        this.crossAxisOffset = i;
    }

    public final void setCrossAxisSize(int i) {
        this.crossAxisSize = i;
    }

    /* renamed from: setNotAnimatableDelta--gyyYBs, reason: not valid java name */
    public final void m283setNotAnimatableDeltagyyYBs(long j) {
        this.notAnimatableDelta = j;
    }
}
