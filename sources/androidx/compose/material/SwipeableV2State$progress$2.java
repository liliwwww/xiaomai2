package androidx.compose.material;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$progress$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$progress$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m835invoke() {
        Float f = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentState());
        float f2 = 0.0f;
        float floatValue = f != null ? f.floatValue() : 0.0f;
        Float f3 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getTargetState());
        float floatValue2 = (f3 != null ? f3.floatValue() : 0.0f) - floatValue;
        if (Math.abs(floatValue2) > 1.0E-6f) {
            float floatValue3 = (((Number) this.this$0.getOffset().getValue()).floatValue() - floatValue) / floatValue2;
            if (floatValue3 >= 1.0E-6f) {
                if (floatValue3 <= 0.999999f) {
                    f2 = floatValue3;
                }
            }
            return Float.valueOf(f2);
        }
        f2 = 1.0f;
        return Float.valueOf(f2);
    }
}
