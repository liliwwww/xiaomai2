package androidx.compose.foundation.lazy;

import androidx.compose.p004ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class ItemInfo {
    private long notAnimatableDelta = IntOffset.Companion.m5344getZeronOccac();

    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    /* renamed from: getNotAnimatableDelta-nOcc-ac, reason: not valid java name */
    public final long m1495getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    /* renamed from: setNotAnimatableDelta--gyyYBs, reason: not valid java name */
    public final void m1496setNotAnimatableDeltagyyYBs(long j) {
        this.notAnimatableDelta = j;
    }
}
