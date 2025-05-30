package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$awaitDrag$2 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ SendChannel<DragEvent> $channel;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DraggableKt$awaitDrag$2(VelocityTracker velocityTracker, SendChannel<? super DragEvent> sendChannel, boolean z) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.$channel = sendChannel;
        this.$reverseDirection = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            return;
        }
        long positionChange = PointerEventKt.positionChange(pointerInputChange);
        pointerInputChange.consume();
        SendChannel<DragEvent> sendChannel = this.$channel;
        if (this.$reverseDirection) {
            positionChange = Offset.m855timestuRUvjQ(positionChange, -1.0f);
        }
        sendChannel.trySend-JP2dKIU(new DragEvent.DragDelta(positionChange, null));
    }
}
