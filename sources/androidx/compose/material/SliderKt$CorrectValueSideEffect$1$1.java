package androidx.compose.material;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$CorrectValueSideEffect$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Float, Float> $scaleToOffset;
    final /* synthetic */ ClosedFloatingPointRange<Float> $trackRange;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    final /* synthetic */ MutableState<Float> $valueState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$CorrectValueSideEffect$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super Float, Float> function1, float f, MutableState<Float> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(0);
        this.$valueRange = closedFloatingPointRange;
        this.$scaleToOffset = function1;
        this.$value = f;
        this.$valueState = mutableState;
        this.$trackRange = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m654invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m654invoke() {
        float floatValue = (((Number) this.$valueRange.getEndInclusive()).floatValue() - ((Number) this.$valueRange.getStart()).floatValue()) / WVURLRuleConstants.LOGIN;
        float floatValue2 = ((Number) this.$scaleToOffset.invoke(Float.valueOf(this.$value))).floatValue();
        if (Math.abs(floatValue2 - this.$valueState.getValue().floatValue()) <= floatValue || !this.$trackRange.contains(this.$valueState.getValue())) {
            return;
        }
        this.$valueState.setValue(Float.valueOf(floatValue2));
    }
}
