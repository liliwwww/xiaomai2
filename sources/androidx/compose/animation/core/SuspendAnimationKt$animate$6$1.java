package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SuspendAnimationKt$animate$6$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnimationState<T, V> $this_animate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendAnimationKt$animate$6$1(AnimationState<T, V> animationState) {
        super(0);
        this.$this_animate = animationState;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m96invoke() {
        this.$this_animate.setRunning$animation_core_release(false);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m96invoke();
        return Unit.INSTANCE;
    }
}
