package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import tb.dp5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TransformableStateKt$animatePanBy$2$1 extends Lambda implements Function1<AnimationScope<Offset, AnimationVector2D>, Unit> {
    final /* synthetic */ TransformScope $$this$transform;
    final /* synthetic */ Ref.LongRef $previous;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animatePanBy$2$1(Ref.LongRef longRef, TransformScope transformScope) {
        super(1);
        this.$previous = longRef;
        this.$$this$transform = transformScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Offset, AnimationVector2D>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<Offset, AnimationVector2D> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
        dp5.a(this.$$this$transform, 0.0f, Offset.minus-MK-Hz9U(((Offset) animationScope.getValue()).unbox-impl(), this.$previous.element), 0.0f, 5, (Object) null);
        this.$previous.element = ((Offset) animationScope.getValue()).unbox-impl();
    }
}
