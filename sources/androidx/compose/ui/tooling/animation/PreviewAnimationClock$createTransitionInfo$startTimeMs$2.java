package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PreviewAnimationClock$createTransitionInfo$startTimeMs$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $this_createTransitionInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$createTransitionInfo$startTimeMs$2(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState) {
        super(0);
        this.$this_createTransitionInfo = transitionAnimationState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Long m2105invoke() {
        Number valueOf;
        TweenSpec animationSpec = this.$this_createTransitionInfo.getAnimationSpec();
        if (animationSpec instanceof TweenSpec) {
            valueOf = Integer.valueOf(animationSpec.getDelay());
        } else if (animationSpec instanceof SnapSpec) {
            valueOf = Integer.valueOf(((SnapSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof KeyframesSpec) {
            valueOf = Integer.valueOf(((KeyframesSpec) animationSpec).getConfig().getDelayMillis());
        } else if (animationSpec instanceof RepeatableSpec) {
            RepeatableSpec repeatableSpec = (RepeatableSpec) animationSpec;
            valueOf = StartOffsetType.m95equalsimpl0(StartOffset.getOffsetType-Eo1U57Q(repeatableSpec.m86getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m99getDelayEo1U57Q()) ? Integer.valueOf(StartOffset.getOffsetMillis-impl(repeatableSpec.m86getInitialStartOffsetRmkjzm4())) : 0L;
        } else if (animationSpec instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) animationSpec;
            valueOf = StartOffsetType.m95equalsimpl0(StartOffset.getOffsetType-Eo1U57Q(infiniteRepeatableSpec.m84getInitialStartOffsetRmkjzm4()), StartOffsetType.Companion.m99getDelayEo1U57Q()) ? Integer.valueOf(StartOffset.getOffsetMillis-impl(infiniteRepeatableSpec.m84getInitialStartOffsetRmkjzm4())) : 0L;
        } else {
            valueOf = animationSpec instanceof VectorizedDurationBasedAnimationSpec ? Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).getDelayMillis()) : 0L;
        }
        return Long.valueOf(valueOf.longValue());
    }
}
