package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class UpdatableAnimationState$animateToZero$3 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Float, Unit> $beforeFrame;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UpdatableAnimationState$animateToZero$3(UpdatableAnimationState updatableAnimationState, float f, Function1<? super Float, Unit> function1) {
        super(1);
        this.this$0 = updatableAnimationState;
        this.$durationScale = f;
        this.$beforeFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        if (UpdatableAnimationState.access$getLastFrameTime$p(this.this$0) == Long.MIN_VALUE) {
            UpdatableAnimationState.access$setLastFrameTime$p(this.this$0, j);
        }
        AnimationVector1D animationVector1D = new AnimationVector1D(this.this$0.getValue());
        long durationNanos = (this.$durationScale > 0.0f ? 1 : (this.$durationScale == 0.0f ? 0 : -1)) == 0 ? UpdatableAnimationState.access$getCompanion$p().getRebasableAnimationSpec().getDurationNanos(new AnimationVector1D(this.this$0.getValue()), UpdatableAnimationState.access$getCompanion$p().getZeroVector(), UpdatableAnimationState.access$getLastVelocity$p(this.this$0)) : MathKt.roundToLong((j - UpdatableAnimationState.access$getLastFrameTime$p(this.this$0)) / this.$durationScale);
        float value = ((AnimationVector1D) UpdatableAnimationState.access$getCompanion$p().getRebasableAnimationSpec().getValueFromNanos(durationNanos, animationVector1D, UpdatableAnimationState.access$getCompanion$p().getZeroVector(), UpdatableAnimationState.access$getLastVelocity$p(this.this$0))).getValue();
        UpdatableAnimationState.access$setLastVelocity$p(this.this$0, (AnimationVector1D) UpdatableAnimationState.access$getCompanion$p().getRebasableAnimationSpec().getVelocityFromNanos(durationNanos, animationVector1D, UpdatableAnimationState.access$getCompanion$p().getZeroVector(), UpdatableAnimationState.access$getLastVelocity$p(this.this$0)));
        UpdatableAnimationState.access$setLastFrameTime$p(this.this$0, j);
        float value2 = this.this$0.getValue() - value;
        this.this$0.setValue(value);
        this.$beforeFrame.invoke(Float.valueOf(value2));
    }
}
