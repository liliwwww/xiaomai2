package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class AndroidConfig implements ScrollConfig {

    @NotNull
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo1201calculateMouseWheelScroll8xgXZGE(@NotNull Density density, @NotNull PointerEvent pointerEvent, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$calculateMouseWheelScroll");
        Intrinsics.checkNotNullParameter(pointerEvent, NotificationCompat.CATEGORY_EVENT);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        Offset m2545boximpl = Offset.m2545boximpl(Offset.Companion.m2572getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            m2545boximpl = Offset.m2545boximpl(Offset.m2561plusMKHz9U(m2545boximpl.m2566unboximpl(), changes.get(i).m4083getScrollDeltaF1C5BW0()));
        }
        return Offset.m2563timestuRUvjQ(m2545boximpl.m2566unboximpl(), -density.mo1283toPx0680j_4(C0856Dp.m5216constructorimpl(64)));
    }
}
