package androidx.compose.foundation.lazy;

import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ItemInfo {
    private long notAnimatableDelta = IntOffset.Companion.m2653getZeronOccac();

    @NotNull
    private final List<PlaceableInfo> placeables = new ArrayList();

    /* renamed from: getNotAnimatableDelta-nOcc-ac, reason: not valid java name */
    public final long m416getNotAnimatableDeltanOccac() {
        return this.notAnimatableDelta;
    }

    @NotNull
    public final List<PlaceableInfo> getPlaceables() {
        return this.placeables;
    }

    /* renamed from: setNotAnimatableDelta--gyyYBs, reason: not valid java name */
    public final void m417setNotAnimatableDeltagyyYBs(long j) {
        this.notAnimatableDelta = j;
    }
}
