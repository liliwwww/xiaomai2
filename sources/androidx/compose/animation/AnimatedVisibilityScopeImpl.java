package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalAnimationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {

    @NotNull
    private final MutableState<IntSize> targetSize;

    @NotNull
    private Transition<EnterExitState> transition;

    public AnimatedVisibilityScopeImpl(@NotNull Transition<EnterExitState> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.transition = transition;
        this.targetSize = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ Modifier animateEnterExit(Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str) {
        return AnimatedVisibilityScope$CC.a(this, modifier, enterTransition, exitTransition, str);
    }

    @NotNull
    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }

    @NotNull
    public Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public void setTransition(@NotNull Transition<EnterExitState> transition) {
        Intrinsics.checkNotNullParameter(transition, "<set-?>");
        this.transition = transition;
    }
}
