package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerInputEvent {

    @NotNull
    private final MotionEvent motionEvent;

    @NotNull
    private final List<PointerInputEventData> pointers;
    private final long uptime;

    public PointerInputEvent(long j, @NotNull List<PointerInputEventData> list, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(list, "pointers");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.uptime = j;
        this.pointers = list;
        this.motionEvent = motionEvent;
    }

    @NotNull
    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    @NotNull
    public final List<PointerInputEventData> getPointers() {
        return this.pointers;
    }

    public final long getUptime() {
        return this.uptime;
    }
}
