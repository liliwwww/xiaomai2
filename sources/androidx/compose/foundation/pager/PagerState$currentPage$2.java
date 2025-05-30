package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PagerState$currentPage$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PagerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerState$currentPage$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m346invoke() {
        LazyListItemInfo access$getClosestPageToSnappedPosition = PagerState.access$getClosestPageToSnappedPosition(this.this$0);
        return Integer.valueOf(access$getClosestPageToSnappedPosition != null ? access$getClosestPageToSnappedPosition.getIndex() : 0);
    }
}
