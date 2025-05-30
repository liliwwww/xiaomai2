package androidx.compose.foundation.pager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0}, l = {248, 254}, m = "scrollToPage", n = {"this", "page", "pageOffsetFraction"}, s = {"L$0", "I$0", "F$0"})
/* loaded from: classes2.dex */
final class PagerState$scrollToPage$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$scrollToPage$1(PagerState pagerState, Continuation<? super PagerState$scrollToPage$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scrollToPage(0, 0.0f, this);
    }
}
