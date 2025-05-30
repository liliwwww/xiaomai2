package androidx.compose.material;

import androidx.compose.material.SliderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SliderKt$RangeSlider$2$onDrag$1$1 extends Lambda implements Function2<Boolean, Float, Unit> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$onDrag$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$value = closedFloatingPointRange;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, float f) {
        ClosedFloatingPointRange rangeTo;
        if (z) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(((Number) mutableState.getValue()).floatValue() + f));
            this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt.RangeSlider.2.access$invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, ((Number) this.$value.getEndInclusive()).floatValue())));
            float floatValue = ((Number) this.$rawOffsetEnd.getValue()).floatValue();
            rangeTo = RangesKt.rangeTo(RangesKt.coerceIn(((Number) this.$rawOffsetStart.getValue()).floatValue(), this.$minPx.element, floatValue), floatValue);
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(((Number) mutableState2.getValue()).floatValue() + f));
            this.$rawOffsetStart.setValue(Float.valueOf(SliderKt.RangeSlider.2.access$invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, ((Number) this.$value.getStart()).floatValue())));
            float floatValue2 = ((Number) this.$rawOffsetStart.getValue()).floatValue();
            rangeTo = RangesKt.rangeTo(floatValue2, RangesKt.coerceIn(((Number) this.$rawOffsetEnd.getValue()).floatValue(), floatValue2, this.$maxPx.element));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt.RangeSlider.2.access$invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, rangeTo));
    }
}
