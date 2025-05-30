package androidx.compose.foundation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollState$scrollableState$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ ScrollState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollState$scrollableState$1(ScrollState scrollState) {
        super(1);
        this.this$0 = scrollState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    @NotNull
    public final Float invoke(float f) {
        float value = this.this$0.getValue() + f + ScrollState.access$getAccumulator$p(this.this$0);
        float coerceIn = RangesKt.coerceIn(value, 0.0f, this.this$0.getMaxValue());
        boolean z = !(value == coerceIn);
        float value2 = coerceIn - this.this$0.getValue();
        int roundToInt = MathKt.roundToInt(value2);
        ScrollState scrollState = this.this$0;
        ScrollState.access$setValue(scrollState, scrollState.getValue() + roundToInt);
        ScrollState.access$setAccumulator$p(this.this$0, value2 - roundToInt);
        if (z) {
            f = value2;
        }
        return Float.valueOf(f);
    }
}
