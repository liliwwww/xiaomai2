package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SliderKt$animateToTarget$2$1 extends Lambda implements Function1<Animatable<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ DragScope $$this$drag;
    final /* synthetic */ Ref.FloatRef $latestValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$animateToTarget$2$1(DragScope dragScope, Ref.FloatRef floatRef) {
        super(1);
        this.$$this$drag = dragScope;
        this.$latestValue = floatRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animatable<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
        Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
        this.$$this$drag.dragBy(((Number) animatable.getValue()).floatValue() - this.$latestValue.element);
        this.$latestValue.element = ((Number) animatable.getValue()).floatValue();
    }
}
