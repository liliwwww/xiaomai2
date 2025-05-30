package androidx.compose.p004ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class PointerInputChangeEventProducer {

    @NotNull
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        private PointerInputData(long j, long j2, boolean z, int i) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
            this.type = i;
        }

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z, i);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
        public final long m4085getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        /* renamed from: getType-T8wyACA, reason: not valid java name */
        public final int m4086getTypeT8wyACA() {
            return this.type;
        }

        public final long getUptime() {
            return this.uptime;
        }
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    @NotNull
    public final InternalPointerEvent produce(@NotNull PointerInputEvent pointerInputEvent, @NotNull PositionCalculator positionCalculator) {
        long j;
        boolean down;
        long mo4149screenToLocalMKHz9U;
        Intrinsics.checkNotNullParameter(pointerInputEvent, "pointerInputEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = pointers.get(i);
            PointerInputData pointerInputData = this.previousPointerInputData.get(PointerId.m4063boximpl(pointerInputEventData.m4094getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                j = pointerInputEventData.getUptime();
                mo4149screenToLocalMKHz9U = pointerInputEventData.m4095getPositionF1C5BW0();
                down = false;
            } else {
                long uptime = pointerInputData.getUptime();
                j = uptime;
                down = pointerInputData.getDown();
                mo4149screenToLocalMKHz9U = positionCalculator.mo4149screenToLocalMKHz9U(pointerInputData.m4085getPositionOnScreenF1C5BW0());
            }
            linkedHashMap.put(PointerId.m4063boximpl(pointerInputEventData.m4094getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m4094getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m4095getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), j, mo4149screenToLocalMKHz9U, down, false, pointerInputEventData.m4098getTypeT8wyACA(), (List) pointerInputEventData.getHistorical(), pointerInputEventData.m4097getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(PointerId.m4063boximpl(pointerInputEventData.m4094getIdJ3iCeTQ()), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m4096getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m4098getTypeT8wyACA(), null));
            } else {
                this.previousPointerInputData.remove(PointerId.m4063boximpl(pointerInputEventData.m4094getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }
}
