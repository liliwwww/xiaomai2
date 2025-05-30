package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SliderKt$RangeSlider$2$gestureEndAction$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ boolean $isStart;
        final /* synthetic */ Ref.FloatRef $maxPx;
        final /* synthetic */ Ref.FloatRef $minPx;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableState<Float> $rawOffsetEnd;
        final /* synthetic */ MutableState<Float> $rawOffsetStart;
        final /* synthetic */ float $target;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f, float f2, Function0<Unit> function0, boolean z, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$onValueChangeFinished = function0;
            this.$isStart = z;
            this.$rawOffsetStart = mutableState;
            this.$rawOffsetEnd = mutableState2;
            this.$onValueChangeState = state;
            this.$minPx = floatRef;
            this.$maxPx = floatRef2;
            this.$valueRange = closedFloatingPointRange;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            DurationBasedAnimationSpec durationBasedAnimationSpec;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable Animatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, (Object) null);
                Float boxFloat = Boxing.boxFloat(this.$target);
                durationBasedAnimationSpec = SliderKt.SliderToTickAnimation;
                Float boxFloat2 = Boxing.boxFloat(0.0f);
                1 r5 = new 1(this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange);
                this.label = 1;
                if (Animatable$default.animateTo(boxFloat, durationBasedAnimationSpec, boxFloat2, r5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Function0<Unit> function0 = this.$onValueChangeFinished;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$gestureEndAction$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, List<Float> list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0<Unit> function0, CoroutineScope coroutineScope, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$tickFractions = list;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
        this.$onValueChangeFinished = function0;
        this.$scope = coroutineScope;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        float snapValueToTick;
        float floatValue = ((Number) (z ? this.$rawOffsetStart : this.$rawOffsetEnd).getValue()).floatValue();
        snapValueToTick = SliderKt.snapValueToTick(floatValue, this.$tickFractions, this.$minPx.element, this.$maxPx.element);
        if (!(floatValue == snapValueToTick)) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(floatValue, snapValueToTick, this.$onValueChangeFinished, z, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, null), 3, (Object) null);
            return;
        }
        Function0<Unit> function0 = this.$onValueChangeFinished;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
