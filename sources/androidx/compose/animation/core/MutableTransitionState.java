package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MutableTransitionState<S> {
    public static final int $stable = 0;

    @NotNull
    private final MutableState currentState$delegate;

    @NotNull
    private final MutableState isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);

    @NotNull
    private final MutableState targetState$delegate;

    public MutableTransitionState(S s) {
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final S getCurrentState() {
        return (S) this.currentState$delegate.getValue();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final boolean isIdle() {
        return Intrinsics.areEqual(getCurrentState(), getTargetState()) && !isRunning$animation_core_release();
    }

    public final boolean isRunning$animation_core_release() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final void setCurrentState$animation_core_release(S s) {
        this.currentState$delegate.setValue(s);
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setTargetState(S s) {
        this.targetState$delegate.setValue(s);
    }
}
