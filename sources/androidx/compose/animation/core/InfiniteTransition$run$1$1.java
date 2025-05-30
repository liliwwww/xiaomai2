package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class InfiniteTransition$run$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ CoroutineScope $$this$LaunchedEffect;
    final /* synthetic */ Ref.FloatRef $durationScale;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfiniteTransition$run$1$1(InfiniteTransition infiniteTransition, Ref.FloatRef floatRef, CoroutineScope coroutineScope) {
        super(1);
        this.this$0 = infiniteTransition;
        this.$durationScale = floatRef;
        this.$$this$LaunchedEffect = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if ((r7.$durationScale.element == androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r7.$$this$LaunchedEffect.getCoroutineContext())) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(long r8) {
        /*
            r7 = this;
            androidx.compose.animation.core.InfiniteTransition r0 = r7.this$0
            long r0 = androidx.compose.animation.core.InfiniteTransition.access$getStartTimeNanos$p(r0)
            r2 = 1
            r3 = 0
            r4 = -9223372036854775808
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L25
            kotlin.jvm.internal.Ref$FloatRef r0 = r7.$durationScale
            float r0 = r0.element
            kotlinx.coroutines.CoroutineScope r1 = r7.$$this$LaunchedEffect
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            float r1 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 != 0) goto L53
        L25:
            androidx.compose.animation.core.InfiniteTransition r0 = r7.this$0
            androidx.compose.animation.core.InfiniteTransition.access$setStartTimeNanos$p(r0, r8)
            androidx.compose.animation.core.InfiniteTransition r0 = r7.this$0
            androidx.compose.runtime.collection.MutableVector r0 = r0.getAnimations$animation_core_release()
            int r1 = r0.getSize()
            if (r1 <= 0) goto L45
            java.lang.Object[] r0 = r0.getContent()
            r4 = 0
        L3b:
            r5 = r0[r4]
            androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r5 = (androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState) r5
            r5.reset()
            int r4 = r4 + r2
            if (r4 < r1) goto L3b
        L45:
            kotlin.jvm.internal.Ref$FloatRef r0 = r7.$durationScale
            kotlinx.coroutines.CoroutineScope r1 = r7.$$this$LaunchedEffect
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            float r1 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r1)
            r0.element = r1
        L53:
            kotlin.jvm.internal.Ref$FloatRef r0 = r7.$durationScale
            float r0 = r0.element
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5e
            r0 = 1
            goto L5f
        L5e:
            r0 = 0
        L5f:
            if (r0 == 0) goto L7c
            androidx.compose.animation.core.InfiniteTransition r8 = r7.this$0
            androidx.compose.runtime.collection.MutableVector r8 = r8.getAnimations$animation_core_release()
            int r9 = r8.getSize()
            if (r9 <= 0) goto L8f
            java.lang.Object[] r8 = r8.getContent()
        L71:
            r0 = r8[r3]
            androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r0 = (androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState) r0
            r0.skipToEnd()
            int r3 = r3 + r2
            if (r3 < r9) goto L71
            goto L8f
        L7c:
            androidx.compose.animation.core.InfiniteTransition r0 = r7.this$0
            long r0 = androidx.compose.animation.core.InfiniteTransition.access$getStartTimeNanos$p(r0)
            long r8 = r8 - r0
            float r8 = (float) r8
            kotlin.jvm.internal.Ref$FloatRef r9 = r7.$durationScale
            float r9 = r9.element
            float r8 = r8 / r9
            long r8 = (long) r8
            androidx.compose.animation.core.InfiniteTransition r0 = r7.this$0
            androidx.compose.animation.core.InfiniteTransition.access$onFrame(r0, r8)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransition$run$1$1.invoke(long):void");
    }
}
