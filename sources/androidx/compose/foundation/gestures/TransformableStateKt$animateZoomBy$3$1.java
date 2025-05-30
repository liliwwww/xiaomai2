package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import tb.dp5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TransformableStateKt$animateZoomBy$3$1 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ TransformScope $$this$transform;
    final /* synthetic */ Ref.FloatRef $previous;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animateZoomBy$3$1(Ref.FloatRef floatRef, TransformScope transformScope) {
        super(1);
        this.$previous = floatRef;
        this.$$this$transform = transformScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
        dp5.a(this.$$this$transform, (this.$previous.element > 0.0f ? 1 : (this.$previous.element == 0.0f ? 0 : -1)) == 0 ? 1.0f : animationScope.getValue().floatValue() / this.$previous.element, 0L, 0.0f, 6, (Object) null);
        this.$previous.element = animationScope.getValue().floatValue();
    }
}
