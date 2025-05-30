package androidx.compose.animation;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
final class EnterTransitionImpl extends EnterTransition {

    @NotNull
    private final TransitionData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterTransitionImpl(@NotNull TransitionData transitionData) {
        super(null);
        Intrinsics.checkNotNullParameter(transitionData, ApiConstants.DATA);
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.EnterTransition
    @NotNull
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
