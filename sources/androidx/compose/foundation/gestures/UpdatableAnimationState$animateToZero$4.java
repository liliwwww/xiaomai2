package androidx.compose.foundation.gestures;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class UpdatableAnimationState$animateToZero$4 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Float, Unit> $beforeFrame;
    final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UpdatableAnimationState$animateToZero$4(UpdatableAnimationState updatableAnimationState, Function1<? super Float, Unit> function1) {
        super(1);
        this.this$0 = updatableAnimationState;
        this.$beforeFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        float value = this.this$0.getValue();
        this.this$0.setValue(0.0f);
        this.$beforeFrame.invoke(Float.valueOf(value));
    }
}
