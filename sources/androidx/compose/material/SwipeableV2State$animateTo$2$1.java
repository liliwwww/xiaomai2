package androidx.compose.material;

import androidx.compose.foundation.gestures.DragScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$animateTo$2$1 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ DragScope $$this$drag;
    final /* synthetic */ Ref.FloatRef $prev;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$animateTo$2$1(DragScope dragScope, Ref.FloatRef floatRef, SwipeableV2State<T> swipeableV2State) {
        super(2);
        this.$$this$drag = dragScope;
        this.$prev = floatRef;
        this.this$0 = swipeableV2State;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        this.$$this$drag.dragBy(f - this.$prev.element);
        this.$prev.element = f;
        SwipeableV2State.access$setLastVelocity(this.this$0, f2);
    }
}
