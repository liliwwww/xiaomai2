package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1$2 implements FlowCollector<Boolean> {
    final /* synthetic */ MutableState<Boolean> $isAnimationVisible;

    AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1$2(MutableState<Boolean> mutableState) {
        this.$isAnimationVisible = mutableState;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(boolean z, @NotNull Continuation<? super Unit> continuation) {
        this.$isAnimationVisible.setValue(Boxing.boxBoolean(z));
        return Unit.INSTANCE;
    }
}
