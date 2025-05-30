package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapFlingBehaviorKt$animateDecay$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ Function1<Float, Unit> $onAnimationStep;
    final /* synthetic */ Ref.FloatRef $previousValue;
    final /* synthetic */ float $targetOffset;
    final /* synthetic */ ScrollScope $this_animateDecay;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapFlingBehaviorKt$animateDecay$2(float f, Ref.FloatRef floatRef, ScrollScope scrollScope, Function1<? super Float, Unit> function1) {
        super(1);
        this.$targetOffset = f;
        this.$previousValue = floatRef;
        this.$this_animateDecay = scrollScope;
        this.$onAnimationStep = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateDecay");
        if (Math.abs(((Number) animationScope.getValue()).floatValue()) >= Math.abs(this.$targetOffset)) {
            SnapFlingBehaviorKt.access$animateDecay$consumeDelta(animationScope, this.$this_animateDecay, this.$onAnimationStep, SnapFlingBehaviorKt.access$coerceToTarget(((Number) animationScope.getValue()).floatValue(), this.$targetOffset) - this.$previousValue.element);
            animationScope.cancelAnimation();
        } else {
            SnapFlingBehaviorKt.access$animateDecay$consumeDelta(animationScope, this.$this_animateDecay, this.$onAnimationStep, ((Number) animationScope.getValue()).floatValue() - this.$previousValue.element);
            this.$previousValue.element = ((Number) animationScope.getValue()).floatValue();
        }
    }
}
