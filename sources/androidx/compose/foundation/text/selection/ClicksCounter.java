package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClicksCounter {
    private int clicks;

    @Nullable
    private PointerInputChange prevClick;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    public ClicksCounter(@NotNull ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    public final int getClicks() {
        return this.clicks;
    }

    @Nullable
    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(@NotNull PointerInputChange pointerInputChange, @NotNull PointerInputChange pointerInputChange2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "prevClick");
        Intrinsics.checkNotNullParameter(pointerInputChange2, "newClick");
        return ((double) Offset.m846getDistanceimpl(Offset.m852minusMKHz9U(pointerInputChange2.m1465getPositionF1C5BW0(), pointerInputChange.m1465getPositionF1C5BW0()))) < 100.0d;
    }

    public final void setClicks(int i) {
        this.clicks = i;
    }

    public final void setPrevClick(@Nullable PointerInputChange pointerInputChange) {
        this.prevClick = pointerInputChange;
    }

    public final boolean timeIsTolerable(@NotNull PointerInputChange pointerInputChange, @NotNull PointerInputChange pointerInputChange2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "prevClick");
        Intrinsics.checkNotNullParameter(pointerInputChange2, "newClick");
        return pointerInputChange2.getUptimeMillis() - pointerInputChange.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis();
    }

    public final void update(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, NotificationCompat.CATEGORY_EVENT);
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.getChanges().get(0);
        if (pointerInputChange != null && timeIsTolerable(pointerInputChange, pointerInputChange2) && positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks++;
        } else {
            this.clicks = 1;
        }
        this.prevClick = pointerInputChange2;
    }
}
