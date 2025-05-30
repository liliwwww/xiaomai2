package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", i = {0, 0, 0, 0, 0}, l = {471}, m = "onDragOrUp-Axegvzg", n = {"onDrag", "motionFromChange", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DraggableKt$onDragOrUp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    DraggableKt$onDragOrUp$1(Continuation<? super DraggableKt$onDragOrUp$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m212onDragOrUpAxegvzg;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m212onDragOrUpAxegvzg = DraggableKt.m212onDragOrUpAxegvzg(null, null, 0L, null, this);
        return m212onDragOrUpAxegvzg;
    }
}
