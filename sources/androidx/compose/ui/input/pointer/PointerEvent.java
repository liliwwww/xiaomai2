package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;

    @NotNull
    private final List<PointerInputChange> changes;

    @Nullable
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(@NotNull List<PointerInputChange> list, @Nullable InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(list, "changes");
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        this.buttons = PointerButtons.constructor-impl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.constructor-impl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m1981calculatePointerEventType7fucELk();
    }

    /* renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m1981calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int actionMasked = motionEvent$ui_release.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                        }
                        return PointerEventType.Companion.getPress-7fucELk();
                    }
                    return PointerEventType.Companion.getMove-7fucELk();
                }
                return PointerEventType.Companion.getRelease-7fucELk();
            }
            return PointerEventType.Companion.getPress-7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.getRelease-7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.getPress-7fucELk();
            }
        }
        return PointerEventType.Companion.getMove-7fucELk();
    }

    @NotNull
    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    @NotNull
    public final PointerEvent copy(@NotNull List<PointerInputChange> list, @Nullable MotionEvent motionEvent) {
        PointerEvent pointerEvent = this;
        List<PointerInputChange> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "changes");
        if (motionEvent == null) {
            return new PointerEvent(list2, null);
        }
        if (Intrinsics.areEqual(motionEvent, getMotionEvent$ui_release())) {
            return new PointerEvent(list2, pointerEvent.internalPointerEvent);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = list2.get(i);
            linkedHashMap.put(PointerId.box-impl(pointerInputChange.getId-J3iCeTQ()), pointerInputChange);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int i2 = 0;
        while (i2 < size2) {
            PointerInputChange pointerInputChange2 = list2.get(i2);
            long j = pointerInputChange2.getId-J3iCeTQ();
            long uptimeMillis = pointerInputChange2.getUptimeMillis();
            long j2 = pointerInputChange2.getPosition-F1C5BW0();
            long j3 = pointerInputChange2.getPosition-F1C5BW0();
            boolean pressed = pointerInputChange2.getPressed();
            float pressure = pointerInputChange2.getPressure();
            int i3 = pointerInputChange2.getType-T8wyACA();
            InternalPointerEvent internalPointerEvent = pointerEvent.internalPointerEvent;
            boolean z = true;
            if (internalPointerEvent == null || !internalPointerEvent.issuesEnterExitEvent-0FcD4WY(pointerInputChange2.getId-J3iCeTQ())) {
                z = false;
            }
            arrayList.add(new PointerInputEventData(j, uptimeMillis, j2, j3, pressed, pressure, i3, z, null, 0L, 768, null));
            i2++;
            pointerEvent = this;
            list2 = list;
        }
        return new PointerEvent(list, new InternalPointerEvent(linkedHashMap, new PointerInputEvent(motionEvent.getEventTime(), arrayList, motionEvent)));
    }

    /* renamed from: getButtons-ry648PA, reason: not valid java name */
    public final int m1982getButtonsry648PA() {
        return this.buttons;
    }

    @NotNull
    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    @Nullable
    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    public final int m1983getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    @Nullable
    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    /* renamed from: getType-7fucELk, reason: not valid java name */
    public final int m1984getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m1985setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointerEvent(@NotNull List<PointerInputChange> list) {
        this(list, null);
        Intrinsics.checkNotNullParameter(list, "changes");
    }
}
