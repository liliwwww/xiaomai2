package androidx.compose.material;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableState$draggableState$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableState$draggableState$1(SwipeableState<T> swipeableState) {
        super(1);
        this.this$0 = swipeableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        float floatValue = ((Number) SwipeableState.access$getAbsoluteOffset$p(this.this$0).getValue()).floatValue() + f;
        float coerceIn = RangesKt.coerceIn(floatValue, this.this$0.getMinBound$material_release(), this.this$0.getMaxBound$material_release());
        float f2 = floatValue - coerceIn;
        ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
        SwipeableState.access$getOffsetState$p(this.this$0).setValue(Float.valueOf(coerceIn + (resistance$material_release != null ? resistance$material_release.computeResistance(f2) : 0.0f)));
        SwipeableState.access$getOverflowState$p(this.this$0).setValue(Float.valueOf(f2));
        SwipeableState.access$getAbsoluteOffset$p(this.this$0).setValue(Float.valueOf(floatValue));
    }
}
