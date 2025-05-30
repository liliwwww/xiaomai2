package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Transition<EnterExitState> $childTransition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1$1(Transition<EnterExitState> transition) {
        super(0);
        this.$childTransition = transition;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m38invoke() {
        EnterExitState currentState = this.$childTransition.getCurrentState();
        EnterExitState enterExitState = EnterExitState.Visible;
        return Boolean.valueOf(currentState == enterExitState || this.$childTransition.getTargetState() == enterExitState);
    }
}
