package androidx.compose.material;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$draggableState$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$draggableState$1(SwipeableV2State<T> swipeableV2State) {
        super(1);
        this.this$0 = swipeableV2State;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        SwipeableV2State.access$getDragPosition$p(this.this$0).setValue(Float.valueOf(((Number) SwipeableV2State.access$getDragPosition$p(this.this$0).getValue()).floatValue() + f));
    }
}
