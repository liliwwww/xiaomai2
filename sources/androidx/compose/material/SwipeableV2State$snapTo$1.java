package androidx.compose.material;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.SwipeableV2State", f = "SwipeableV2.kt", i = {0, 0}, l = {229}, m = "snapTo", n = {"this", "targetState"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class SwipeableV2State$snapTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$snapTo$1(SwipeableV2State<T> swipeableV2State, Continuation<? super SwipeableV2State$snapTo$1> continuation) {
        super(continuation);
        this.this$0 = swipeableV2State;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.snapTo(null, this);
    }
}
