package androidx.compose.animation;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
final class ExitTransitionImpl extends ExitTransition {

    @NotNull
    private final TransitionData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitTransitionImpl(@NotNull TransitionData transitionData) {
        super(null);
        Intrinsics.checkNotNullParameter(transitionData, ApiConstants.DATA);
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.ExitTransition
    @NotNull
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
