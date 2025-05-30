package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SuspendAnimationKt$animate$9 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Animation<T, V> $animation;
    final /* synthetic */ Function1<AnimationScope<T, V>, Unit> $block;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ Ref.ObjectRef<AnimationScope<T, V>> $lateInitScope;
    final /* synthetic */ AnimationState<T, V> $this_animate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SuspendAnimationKt$animate$9(Ref.ObjectRef<AnimationScope<T, V>> objectRef, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        super(1);
        this.$lateInitScope = objectRef;
        this.$durationScale = f;
        this.$animation = animation;
        this.$this_animate = animationState;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        Object obj = this.$lateInitScope.element;
        Intrinsics.checkNotNull(obj);
        SuspendAnimationKt.access$doAnimationFrameWithScale((AnimationScope) obj, j, this.$durationScale, this.$animation, this.$this_animate, this.$block);
    }
}
