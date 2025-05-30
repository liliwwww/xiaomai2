package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.core.app.NotificationCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0, 0}, l = {415, 418}, m = "processDragStop", n = {"this", "$this$processDragStop", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DragLogic$processDragStop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DragLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragLogic$processDragStop$1(DragLogic dragLogic, Continuation<? super DragLogic$processDragStop$1> continuation) {
        super(continuation);
        this.this$0 = dragLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processDragStop((CoroutineScope) null, (DragEvent.DragStopped) null, this);
    }
}
