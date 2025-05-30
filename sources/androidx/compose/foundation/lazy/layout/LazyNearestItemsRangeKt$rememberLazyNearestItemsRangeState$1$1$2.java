package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1$2 implements FlowCollector<IntRange> {
    final /* synthetic */ MutableState<IntRange> $state;

    LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1$2(MutableState<IntRange> mutableState) {
        this.$state = mutableState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((IntRange) obj, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(@NotNull IntRange intRange, @NotNull Continuation<? super Unit> continuation) {
        this.$state.setValue(intRange);
        return Unit.INSTANCE;
    }
}
