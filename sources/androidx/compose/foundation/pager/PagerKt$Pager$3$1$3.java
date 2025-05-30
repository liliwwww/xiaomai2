package androidx.compose.foundation.pager;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PagerKt$Pager$3$1$3 implements FlowCollector<Boolean> {
    final /* synthetic */ PagerState $state;

    PagerKt$Pager$3$1$3(PagerState pagerState) {
        this.$state = pagerState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(boolean z, @NotNull Continuation<? super Unit> continuation) {
        this.$state.updateOnScrollStopped$foundation_release();
        return Unit.INSTANCE;
    }
}
