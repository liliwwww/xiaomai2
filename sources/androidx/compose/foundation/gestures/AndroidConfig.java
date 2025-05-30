package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidConfig implements ScrollConfig {

    @NotNull
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    /* renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long m169calculateMouseWheelScroll8xgXZGE(@NotNull Density density, @NotNull PointerEvent pointerEvent, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$calculateMouseWheelScroll");
        Intrinsics.checkNotNullParameter(pointerEvent, "event");
        List<PointerInputChange> changes = pointerEvent.getChanges();
        Offset offset = Offset.box-impl(Offset.Companion.m1024getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            offset = Offset.box-impl(Offset.plus-MK-Hz9U(offset.unbox-impl(), changes.get(i).getScrollDelta-F1C5BW0()));
        }
        return Offset.times-tuRUvjQ(offset.unbox-impl(), -density.toPx-0680j_4(Dp.constructor-impl(64)));
    }
}
