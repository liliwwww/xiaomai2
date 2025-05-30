package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PointerInputChangeEventProducer {

    @NotNull
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    @NotNull
    public final InternalPointerEvent produce(@NotNull PointerInputEvent pointerInputEvent, @NotNull PositionCalculator positionCalculator) {
        long j;
        boolean down;
        long j2;
        Intrinsics.checkNotNullParameter(pointerInputEvent, "pointerInputEvent");
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = pointers.get(i);
            PointerInputData pointerInputData = this.previousPointerInputData.get(PointerId.box-impl(pointerInputEventData.m2002getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                j = pointerInputEventData.getUptime();
                j2 = pointerInputEventData.m2003getPositionF1C5BW0();
                down = false;
            } else {
                long uptime = pointerInputData.getUptime();
                j = uptime;
                down = pointerInputData.getDown();
                j2 = positionCalculator.screenToLocal-MK-Hz9U(pointerInputData.getPositionOnScreen-F1C5BW0());
            }
            linkedHashMap.put(PointerId.box-impl(pointerInputEventData.m2002getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m2002getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m2003getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), j, j2, down, false, pointerInputEventData.m2006getTypeT8wyACA(), pointerInputEventData.getHistorical(), pointerInputEventData.m2005getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(PointerId.box-impl(pointerInputEventData.m2002getIdJ3iCeTQ()), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m2004getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m2006getTypeT8wyACA(), (DefaultConstructorMarker) null));
            } else {
                this.previousPointerInputData.remove(PointerId.box-impl(pointerInputEventData.m2002getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }
}
