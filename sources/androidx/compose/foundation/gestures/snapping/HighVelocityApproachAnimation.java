package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class HighVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {

    @NotNull
    private final DecayAnimationSpec<Float> decayAnimationSpec;

    public HighVelocityApproachAnimation(@NotNull DecayAnimationSpec<Float> decayAnimationSpec) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        this.decayAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return approachAnimation(scrollScope, f.floatValue(), f2.floatValue(), function1, continuation);
    }

    @Nullable
    public Object approachAnimation(@NotNull ScrollScope scrollScope, float f, float f2, @NotNull Function1<? super Float, Unit> function1, @NotNull Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object animateDecay;
        animateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.decayAnimationSpec, function1, continuation);
        return animateDecay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateDecay : (AnimationResult) animateDecay;
    }
}
