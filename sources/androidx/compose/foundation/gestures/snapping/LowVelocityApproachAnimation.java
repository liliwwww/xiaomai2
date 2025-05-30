package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.p004ui.unit.Density;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class LowVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {

    @NotNull
    private final Density density;

    @NotNull
    private final SnapLayoutInfoProvider layoutInfoProvider;

    @NotNull
    private final AnimationSpec<Float> lowVelocityAnimationSpec;

    public LowVelocityApproachAnimation(@NotNull AnimationSpec<Float> animationSpec, @NotNull SnapLayoutInfoProvider snapLayoutInfoProvider, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(animationSpec, "lowVelocityAnimationSpec");
        Intrinsics.checkNotNullParameter(snapLayoutInfoProvider, "layoutInfoProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        this.lowVelocityAnimationSpec = animationSpec;
        this.layoutInfoProvider = snapLayoutInfoProvider;
        this.density = density;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return approachAnimation(scrollScope, f.floatValue(), f2.floatValue(), function1, continuation);
    }

    @Nullable
    public Object approachAnimation(@NotNull ScrollScope scrollScope, float f, float f2, @NotNull Function1<? super Float, Unit> function1, @NotNull Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object animateSnap;
        animateSnap = SnapFlingBehaviorKt.animateSnap(scrollScope, (Math.abs(f) + this.layoutInfoProvider.calculateSnapStepSize(this.density)) * Math.signum(f2), f, AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null), this.lowVelocityAnimationSpec, function1, continuation);
        return animateSnap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateSnap : (AnimationResult) animateSnap;
    }
}
