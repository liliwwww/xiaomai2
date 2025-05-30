package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class EnterTransitionImpl extends EnterTransition {

    @NotNull
    private final TransitionData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterTransitionImpl(@NotNull TransitionData transitionData) {
        super(null);
        Intrinsics.checkNotNullParameter(transitionData, "data");
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.EnterTransition
    @NotNull
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
