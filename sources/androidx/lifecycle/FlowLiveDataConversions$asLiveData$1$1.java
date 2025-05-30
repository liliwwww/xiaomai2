package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FlowLiveDataConversions$asLiveData$1$1<T> implements FlowCollector {
    final /* synthetic */ LiveDataScope<T> $$this$liveData;

    FlowLiveDataConversions$asLiveData$1$1(LiveDataScope<T> liveDataScope) {
        this.$$this$liveData = liveDataScope;
    }

    @Nullable
    public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Object emit = this.$$this$liveData.emit(t, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}
