package androidx.compose.foundation.pager;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PagerKt$Pager$3$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ PagerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerKt$Pager$3$1$1(PagerState pagerState) {
        super(0);
        this.$state = pagerState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m511invoke() {
        return Boolean.valueOf(this.$state.isScrollInProgress());
    }
}
