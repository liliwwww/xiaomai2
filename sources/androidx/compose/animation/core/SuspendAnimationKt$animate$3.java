package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T, V] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SuspendAnimationKt$animate$3<T, V> extends Lambda implements Function1<AnimationScope<T, V>, Unit> {
    final /* synthetic */ Function2<T, T, Unit> $block;
    final /* synthetic */ TwoWayConverter<T, V> $typeConverter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SuspendAnimationKt$animate$3(Function2<? super T, ? super T, Unit> function2, TwoWayConverter<T, V> twoWayConverter) {
        super(1);
        this.$block = function2;
        this.$typeConverter = twoWayConverter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationScope<T, V> animationScope) {
        Intrinsics.checkNotNullParameter(animationScope, "$this$animate");
        this.$block.invoke(animationScope.getValue(), this.$typeConverter.getConvertFromVector().invoke(animationScope.getVelocityVector()));
    }
}
