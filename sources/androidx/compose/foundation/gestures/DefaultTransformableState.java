package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultTransformableState implements TransformableState {

    @NotNull
    private final MutableState<Boolean> isTransformingState;

    @NotNull
    private final Function3<Float, Offset, Float, Unit> onTransformation;

    @NotNull
    private final MutatorMutex transformMutex;

    @NotNull
    private final TransformScope transformScope;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultTransformableState(@NotNull Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        MutableState<Boolean> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(function3, "onTransformation");
        this.onTransformation = function3;
        this.transformScope = new transformScope.1(this);
        this.transformMutex = new MutatorMutex();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isTransformingState = mutableStateOf$default;
    }

    @NotNull
    public final Function3<Float, Offset, Float, Unit> getOnTransformation() {
        return this.onTransformation;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public boolean isTransformInProgress() {
        return ((Boolean) this.isTransformingState.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    @Nullable
    public Object transform(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object g = i80.g(new transform.2(this, mutatePriority, function2, (Continuation) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
