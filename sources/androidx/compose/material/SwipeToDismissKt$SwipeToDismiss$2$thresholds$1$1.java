package androidx.compose.material;

import androidx.constraintlayout.core.motion.utils.TypedValues$TransitionType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends Lambda implements Function2<DismissValue, DismissValue, ThresholdConfig> {
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(Function1<? super DismissDirection, ? extends ThresholdConfig> function1) {
        super(2);
        this.$dismissThresholds = function1;
    }

    @NotNull
    public final ThresholdConfig invoke(@NotNull DismissValue dismissValue, @NotNull DismissValue dismissValue2) {
        DismissDirection dismissDirection;
        Intrinsics.checkNotNullParameter(dismissValue, TypedValues$TransitionType.S_FROM);
        Intrinsics.checkNotNullParameter(dismissValue2, TypedValues$TransitionType.S_TO);
        Function1<DismissDirection, ThresholdConfig> function1 = this.$dismissThresholds;
        dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
        Intrinsics.checkNotNull(dismissDirection);
        return (ThresholdConfig) function1.invoke(dismissDirection);
    }
}
