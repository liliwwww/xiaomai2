package androidx.compose.material;

import androidx.compose.material.SwipeableState;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.SwipeableState$animateTo$2", f = "Swipeable.kt", i = {0, 0}, l = {335}, m = "emit", n = {"this", "anchors"}, s = {"L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwipeableState$animateTo$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableState.animateTo.2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableState$animateTo$2$emit$1(SwipeableState.animateTo.2 r1, Continuation<? super SwipeableState$animateTo$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Map) null, this);
    }
}
