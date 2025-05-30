package androidx.compose.material;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$sliderSemantics$1$1 extends Lambda implements Function1<Float, Boolean> {
    final /* synthetic */ float $coerced;
    final /* synthetic */ Function1<Float, Unit> $onValueChange;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ int $steps;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SliderKt$sliderSemantics$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, Function1<? super Float, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$valueRange = closedFloatingPointRange;
        this.$steps = i;
        this.$coerced = f;
        this.$onValueChange = function1;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    @NotNull
    public final Boolean invoke(float f) {
        int i;
        float coerceIn = RangesKt.coerceIn(f, ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue());
        int i2 = this.$steps;
        boolean z = false;
        if (i2 > 0 && (i = i2 + 1) >= 0) {
            float f2 = coerceIn;
            float f3 = f2;
            int i3 = 0;
            while (true) {
                float lerp = MathHelpersKt.lerp(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), i3 / (this.$steps + 1));
                float f4 = lerp - coerceIn;
                if (Math.abs(f4) <= f2) {
                    f2 = Math.abs(f4);
                    f3 = lerp;
                }
                if (i3 == i) {
                    break;
                }
                i3++;
            }
            coerceIn = f3;
        }
        if (!(coerceIn == this.$coerced)) {
            this.$onValueChange.invoke(Float.valueOf(coerceIn));
            Function0<Unit> function0 = this.$onValueChangeFinished;
            if (function0 != null) {
                function0.invoke();
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
