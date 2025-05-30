package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", i = {0}, l = {577}, m = "invokeSuspend", n = {"velocityLeft"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ ScrollScope $this_performFling;
    Object L$0;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultFlingBehavior$performFling$2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Float> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        float f;
        DecayAnimationSpec decayAnimationSpec;
        Ref.FloatRef floatRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Math.abs(this.$initialVelocity) <= 1.0f) {
                f = this.$initialVelocity;
                return Boxing.boxFloat(f);
            }
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            floatRef2.element = this.$initialVelocity;
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(0.0f, this.$initialVelocity, 0L, 0L, false, 28, (Object) null);
            decayAnimationSpec = this.this$0.flingDecay;
            final ScrollScope scrollScope = this.$this_performFling;
            final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateDecay");
                    float floatValue = ((Number) animationScope.getValue()).floatValue() - floatRef3.element;
                    float scrollBy = scrollScope.scrollBy(floatValue);
                    floatRef3.element = ((Number) animationScope.getValue()).floatValue();
                    floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
                    if (Math.abs(floatValue - scrollBy) > 0.5f) {
                        animationScope.cancelAnimation();
                    }
                    DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                    defaultFlingBehavior2.setLastAnimationCycleCount(defaultFlingBehavior2.getLastAnimationCycleCount() + 1);
                }
            };
            this.L$0 = floatRef2;
            this.label = 1;
            if (SuspendAnimationKt.animateDecay$default(AnimationState$default, decayAnimationSpec, false, function1, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            floatRef = floatRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        f = floatRef.element;
        return Boxing.boxFloat(f);
    }
}
