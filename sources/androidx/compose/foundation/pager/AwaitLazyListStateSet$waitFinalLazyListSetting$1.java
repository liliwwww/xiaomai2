package androidx.compose.foundation.pager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.pager.AwaitLazyListStateSet", f = "PagerState.kt", i = {0, 0}, l = {396}, m = "waitFinalLazyListSetting", n = {"this", "previousContinuation"}, s = {"L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AwaitLazyListStateSet$waitFinalLazyListSetting$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitLazyListStateSet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AwaitLazyListStateSet$waitFinalLazyListSetting$1(AwaitLazyListStateSet awaitLazyListStateSet, Continuation<? super AwaitLazyListStateSet$waitFinalLazyListSetting$1> continuation) {
        super(continuation);
        this.this$0 = awaitLazyListStateSet;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitFinalLazyListSetting(this);
    }
}
