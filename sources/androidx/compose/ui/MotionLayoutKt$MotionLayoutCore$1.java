package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MotionLayoutKt$MotionLayoutCore$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ ConstraintSet $targetConstraintSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$1(Channel<ConstraintSet> channel, ConstraintSet constraintSet) {
        super(0);
        this.$channel = channel;
        this.$targetConstraintSet = constraintSet;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2295invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2295invoke() {
        this.$channel.trySend-JP2dKIU(this.$targetConstraintSet);
    }
}
