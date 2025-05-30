package androidx.compose.p004ui.input.pointer;

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
/* loaded from: classes2.dex */
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
        this.buttons = PointerButtons.m4017constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m4130constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m4023calculatePointerEventType7fucELk();
    }

    /* renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m4023calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int actionMasked = motionEvent$ui_release.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                        }
                        return PointerEventType.Companion.m4040getPress7fucELk();
                    }
                    return PointerEventType.Companion.m4039getMove7fucELk();
                }
                return PointerEventType.Companion.m4041getRelease7fucELk();
            }
            return PointerEventType.Companion.m4040getPress7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m4041getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m4040getPress7fucELk();
            }
        }
        return PointerEventType.Companion.m4039getMove7fucELk();
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
            linkedHashMap.put(PointerId.m4063boximpl(pointerInputChange.m4080getIdJ3iCeTQ()), pointerInputChange);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int i2 = 0;
        while (i2 < size2) {
            PointerInputChange pointerInputChange2 = list2.get(i2);
            long m4080getIdJ3iCeTQ = pointerInputChange2.m4080getIdJ3iCeTQ();
            long uptimeMillis = pointerInputChange2.getUptimeMillis();
            long m4081getPositionF1C5BW0 = pointerInputChange2.m4081getPositionF1C5BW0();
            long m4081getPositionF1C5BW02 = pointerInputChange2.m4081getPositionF1C5BW0();
            boolean pressed = pointerInputChange2.getPressed();
            float pressure = pointerInputChange2.getPressure();
            int m4084getTypeT8wyACA = pointerInputChange2.m4084getTypeT8wyACA();
            InternalPointerEvent internalPointerEvent = pointerEvent.internalPointerEvent;
            boolean z = true;
            if (internalPointerEvent == null || !internalPointerEvent.m4013issuesEnterExitEvent0FcD4WY(pointerInputChange2.m4080getIdJ3iCeTQ())) {
                z = false;
            }
            arrayList.add(new PointerInputEventData(m4080getIdJ3iCeTQ, uptimeMillis, m4081getPositionF1C5BW0, m4081getPositionF1C5BW02, pressed, pressure, m4084getTypeT8wyACA, z, null, 0L, 768, null));
            i2++;
            pointerEvent = this;
            list2 = list;
        }
        return new PointerEvent(list, new InternalPointerEvent(linkedHashMap, new PointerInputEvent(motionEvent.getEventTime(), arrayList, motionEvent)));
    }

    /* renamed from: getButtons-ry648PA, reason: not valid java name */
    public final int m4024getButtonsry648PA() {
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
    public final int m4025getKeyboardModifiersk7X9c1A() {
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
    public final int m4026getType7fucELk() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m4027setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointerEvent(@NotNull List<PointerInputChange> list) {
        this(list, null);
        Intrinsics.checkNotNullParameter(list, "changes");
    }
}
