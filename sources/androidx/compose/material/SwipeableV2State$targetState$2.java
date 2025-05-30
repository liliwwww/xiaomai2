package androidx.compose.material;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$targetState$2<T> extends Lambda implements Function0<T> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$targetState$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    public final T invoke() {
        return Float.isNaN(SwipeableV2State.access$getUnsafeOffset(this.this$0)) ? (T) this.this$0.getCurrentState() : (T) SwipeableV2Kt.access$closestState(this.this$0.getAnchors$material_release(), SwipeableV2State.access$getUnsafeOffset(this.this$0));
    }
}
