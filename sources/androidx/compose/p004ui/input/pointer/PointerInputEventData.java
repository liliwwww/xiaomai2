package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c8;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PointerInputEventData {
    private final boolean down;

    @NotNull
    private final List<HistoricalChange> historical;

    /* renamed from: id */
    private final long f202id;
    private final boolean issuesEnterExit;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5) {
        this.f202id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.issuesEnterExit = z2;
        this.historical = list;
        this.scrollDelta = j5;
    }

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5);
    }

    /* renamed from: component1-J3iCeTQ, reason: not valid java name */
    public final long m4088component1J3iCeTQ() {
        return this.f202id;
    }

    /* renamed from: component10-F1C5BW0, reason: not valid java name */
    public final long m4089component10F1C5BW0() {
        return this.scrollDelta;
    }

    public final long component2() {
        return this.uptime;
    }

    /* renamed from: component3-F1C5BW0, reason: not valid java name */
    public final long m4090component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: component4-F1C5BW0, reason: not valid java name */
    public final long m4091component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    /* renamed from: component7-T8wyACA, reason: not valid java name */
    public final int m4092component7T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.issuesEnterExit;
    }

    @NotNull
    public final List<HistoricalChange> component9() {
        return this.historical;
    }

    @NotNull
    /* renamed from: copy-gYeeOSc, reason: not valid java name */
    public final PointerInputEventData m4093copygYeeOSc(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, @NotNull List<HistoricalChange> list, long j5) {
        Intrinsics.checkNotNullParameter(list, "historical");
        return new PointerInputEventData(j, j2, j3, j4, z, f, i, z2, list, j5, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m4066equalsimpl0(this.f202id, pointerInputEventData.f202id) && this.uptime == pointerInputEventData.uptime && Offset.m2553equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m2553equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && PointerType.m4139equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual(this.historical, pointerInputEventData.historical) && Offset.m2553equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta);
    }

    public final boolean getDown() {
        return this.down;
    }

    @NotNull
    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m4094getIdJ3iCeTQ() {
        return this.f202id;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m4095getPositionF1C5BW0() {
        return this.position;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m4096getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m4097getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m4098getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int m4067hashCodeimpl = ((((((PointerId.m4067hashCodeimpl(this.f202id) * 31) + c8.a(this.uptime)) * 31) + Offset.m2558hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m2558hashCodeimpl(this.position)) * 31;
        boolean z = this.down;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int floatToIntBits = (((((m4067hashCodeimpl + i) * 31) + Float.floatToIntBits(this.pressure)) * 31) + PointerType.m4140hashCodeimpl(this.type)) * 31;
        boolean z2 = this.issuesEnterExit;
        return ((((floatToIntBits + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.historical.hashCode()) * 31) + Offset.m2558hashCodeimpl(this.scrollDelta);
    }

    @NotNull
    public String toString() {
        return "PointerInputEventData(id=" + ((Object) PointerId.m4068toStringimpl(this.f202id)) + ", uptime=" + this.uptime + ", positionOnScreen=" + ((Object) Offset.m2564toStringimpl(this.positionOnScreen)) + ", position=" + ((Object) Offset.m2564toStringimpl(this.position)) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + ((Object) PointerType.m4141toStringimpl(this.type)) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + ((Object) Offset.m2564toStringimpl(this.scrollDelta)) + ')';
    }

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? new ArrayList() : list, (i2 & 512) != 0 ? Offset.Companion.m2572getZeroF1C5BW0() : j5, null);
    }
}
