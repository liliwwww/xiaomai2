package androidx.compose.foundation.lazy.grid;

import androidx.compose.p004ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ItemInfo {
    private int crossAxisOffset;
    private int crossAxisSize;
    private long notAnimatableDelta = IntOffset.Companion.m5344getZeronOccac();

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
    public final long m1555getNotAnimatableDeltanOccac() {
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
    public final void m1556setNotAnimatableDeltagyyYBs(long j) {
        this.notAnimatableDelta = j;
    }
}
