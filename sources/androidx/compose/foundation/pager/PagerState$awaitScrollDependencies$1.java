package androidx.compose.foundation.pager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0}, l = {312, 313}, m = "awaitScrollDependencies", n = {"this"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PagerState$awaitScrollDependencies$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$awaitScrollDependencies$1(PagerState pagerState, Continuation<? super PagerState$awaitScrollDependencies$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object awaitScrollDependencies;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitScrollDependencies = this.this$0.awaitScrollDependencies(this);
        return awaitScrollDependencies;
    }
}
