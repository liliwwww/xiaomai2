package androidx.compose.runtime;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BroadcastFrameClock$withFrameNanos$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Ref.ObjectRef<BroadcastFrameClock$FrameAwaiter<R>> $awaiter;
    final /* synthetic */ BroadcastFrameClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BroadcastFrameClock$withFrameNanos$2$1(BroadcastFrameClock broadcastFrameClock, Ref.ObjectRef<BroadcastFrameClock$FrameAwaiter<R>> objectRef) {
        super(1);
        this.this$0 = broadcastFrameClock;
        this.$awaiter = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        BroadcastFrameClock$FrameAwaiter broadcastFrameClock$FrameAwaiter;
        Object access$getLock$p = BroadcastFrameClock.access$getLock$p(this.this$0);
        BroadcastFrameClock broadcastFrameClock = this.this$0;
        Ref.ObjectRef<BroadcastFrameClock$FrameAwaiter<R>> objectRef = this.$awaiter;
        synchronized (access$getLock$p) {
            List access$getAwaiters$p = BroadcastFrameClock.access$getAwaiters$p(broadcastFrameClock);
            Object obj = objectRef.element;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                broadcastFrameClock$FrameAwaiter = null;
            } else {
                broadcastFrameClock$FrameAwaiter = (BroadcastFrameClock$FrameAwaiter) obj;
            }
            access$getAwaiters$p.remove(broadcastFrameClock$FrameAwaiter);
            Unit unit = Unit.INSTANCE;
        }
    }
}
