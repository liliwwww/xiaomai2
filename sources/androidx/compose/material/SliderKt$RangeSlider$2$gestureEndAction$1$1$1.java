package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$RangeSlider$2$gestureEndAction$1$1$1 extends Lambda implements Function1<Animatable<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ boolean $isStart;
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$gestureEndAction$1$1$1(boolean z, MutableState<Float> mutableState, MutableState<Float> mutableState2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.$isStart = z;
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$onValueChangeState = state;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animatable<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
        ClosedFloatingPointRange invoke$scaleToUserValue;
        Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
        (this.$isStart ? this.$rawOffsetStart : this.$rawOffsetEnd).setValue(animatable.getValue());
        Function1 function1 = (Function1) this.$onValueChangeState.getValue();
        invoke$scaleToUserValue = SliderKt$RangeSlider$2.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, RangesKt.rangeTo(this.$rawOffsetStart.getValue().floatValue(), this.$rawOffsetEnd.getValue().floatValue()));
        function1.invoke(invoke$scaleToUserValue);
    }
}
