package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InfiniteTransition {
    public static final int $stable = 8;

    @NotNull
    private final MutableVector<TransitionAnimationState<?, ?>> animations = new MutableVector<>(new TransitionAnimationState[16], 0);

    @NotNull
    private final MutableState refreshChildNeeded$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    private long startTimeNanos = Long.MIN_VALUE;

    @NotNull
    private final MutableState isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);

    private final boolean getRefreshChildNeeded() {
        return ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue();
    }

    private final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFrame(long j) {
        boolean z;
        MutableVector<TransitionAnimationState<?, ?>> mutableVector = this.animations;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            z = true;
            do {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) content[i];
                if (!transitionAnimationState.isFinished()) {
                    transitionAnimationState.onPlayTimeChanged(j);
                }
                if (!transitionAnimationState.isFinished()) {
                    z = false;
                }
                i++;
            } while (i < size);
        } else {
            z = true;
        }
        setRunning(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRefreshChildNeeded(boolean z) {
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final void addAnimation$animation_core_release(@NotNull TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, "animation");
        this.animations.add(transitionAnimationState);
        setRefreshChildNeeded(true);
    }

    @NotNull
    public final MutableVector<TransitionAnimationState<?, ?>> getAnimations$animation_core_release() {
        return this.animations;
    }

    public final void removeAnimation$animation_core_release(@NotNull TransitionAnimationState<?, ?> transitionAnimationState) {
        Intrinsics.checkNotNullParameter(transitionAnimationState, "animation");
        this.animations.remove(transitionAnimationState);
    }

    @Composable
    public final void run$animation_core_release(@Nullable Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-318043801);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-318043801, i, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:140)");
        }
        if (isRunning() || getRefreshChildNeeded()) {
            EffectsKt.LaunchedEffect(this, new run.1(this, (Continuation) null), startRestartGroup, 72);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new run.2(this, i));
    }
}
