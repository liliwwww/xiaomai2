package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FlowExtKt$flowWithLifecycle$1$1$1<T> implements FlowCollector {
    final /* synthetic */ ProducerScope<T> $$this$callbackFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowExtKt$flowWithLifecycle$1$1$1(ProducerScope<? super T> producerScope) {
        this.$$this$callbackFlow = producerScope;
    }

    @Nullable
    public final Object emit(T t, @NotNull Continuation<? super Unit> continuation) {
        Object send = this.$$this$callbackFlow.send(t, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }
}
