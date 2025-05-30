package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SuspendAnimationKt {
    @Nullable
    public static final Object animate(float f, float f2, float f3, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function2<? super Float, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f2), Boxing.boxFloat(f3), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4 = (i & 4) != 0 ? 0.0f : f3;
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f2, f4, animationSpec, function2, continuation);
    }

    @Nullable
    public static final Object animateDecay(float f, float f2, @NotNull FloatDecayAnimationSpec floatDecayAnimationSpec, @NotNull final Function2<? super Float, ? super Float, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(f, f2, 0L, 0L, false, 28, (Object) null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f, f2), 0L, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                Intrinsics.checkNotNullParameter(animationScope, "$this$animate");
                function2.invoke(animationScope.getValue(), Float.valueOf(((AnimationVector1D) animationScope.getVelocityVector()).getValue()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((AnimationScope) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateTo(@NotNull AnimationState<T, V> animationState, T t, @NotNull AnimationSpec<T> animationSpec, boolean z, @NotNull Function1<? super AnimationScope<T, V>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new TargetBasedAnimation(animationSpec, (TwoWayConverter<T, AnimationVector>) animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            function1 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((AnimationScope) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        return animation.isInfinite() ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation) : MonotonicFrameClockKt.withFrameNanos(new callWithFrameNanos.2(function1), continuation);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, long j2, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(j2));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(j2));
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        doAnimationFrame(animationScope, j, (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0 ? animation.getDurationNanos() : (long) ((j - animationScope.getStartTimeNanos()) / f), animation, animationState, function1);
    }

    public static final float getDurationScale(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        MotionDurationScale motionDurationScale = coroutineContext.get(MotionDurationScale.Key);
        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scaleFactor >= 0.0f) {
            return scaleFactor;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final <T, V extends AnimationVector> void updateState(@NotNull AnimationScope<T, V> animationScope, @NotNull AnimationState<T, V> animationState) {
        Intrinsics.checkNotNullParameter(animationScope, "<this>");
        Intrinsics.checkNotNullParameter(animationState, "state");
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animateDecay(@NotNull AnimationState<T, V> animationState, @NotNull DecayAnimationSpec<T> decayAnimationSpec, boolean z, @NotNull Function1<? super AnimationScope<T, V>, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new DecayAnimation((DecayAnimationSpec<Object>) decayAnimationSpec, (TwoWayConverter<Object, AnimationVector>) animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = animate.5.INSTANCE;
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    @Nullable
    public static final <T, V extends AnimationVector> Object animate(@NotNull TwoWayConverter<T, V> twoWayConverter, T t, T t2, @Nullable T t3, @NotNull AnimationSpec<T> animationSpec, @NotNull Function2<? super T, ? super T, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        AnimationVector newInstance;
        if (t3 == null || (newInstance = (AnimationVector) twoWayConverter.getConvertToVector().invoke(t3)) == null) {
            newInstance = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t));
        }
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, newInstance, 0L, 0L, false, 56, (DefaultConstructorMarker) null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, newInstance), 0L, new animate.3(function2, twoWayConverter), continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ee A[Catch: CancellationException -> 0x0061, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0061, blocks: (B:12:0x005a, B:15:0x00e1, B:17:0x00ee), top: B:11:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationState<T, V> r25, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.Animation<T, V> r26, long r27, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
