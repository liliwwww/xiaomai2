package androidx.compose.foundation.pager;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PagerState$settledPage$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$settledPage$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m347invoke() {
        int access$coerceInPageRange;
        if (this.this$0.getPageCount$foundation_release() == 0) {
            access$coerceInPageRange = 0;
        } else {
            PagerState pagerState = this.this$0;
            access$coerceInPageRange = PagerState.access$coerceInPageRange(pagerState, PagerState.access$getSettledPageState(pagerState));
        }
        return Integer.valueOf(access$coerceInPageRange);
    }
}
