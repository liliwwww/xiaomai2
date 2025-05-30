package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapFlingBehaviorKt$animateSnap$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ float $cancelOffset;
    final /* synthetic */ Ref.FloatRef $consumedUpToNow;
    final /* synthetic */ Function1<Float, Unit> $onAnimationStep;
    final /* synthetic */ ScrollScope $this_animateSnap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapFlingBehaviorKt$animateSnap$2(float f, Ref.FloatRef floatRef, ScrollScope scrollScope, Function1<? super Float, Unit> function1) {
        super(1);
        this.$cancelOffset = f;
        this.$consumedUpToNow = floatRef;
        this.$this_animateSnap = scrollScope;
        this.$onAnimationStep = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0046, code lost:
    
        if ((r0 == ((java.lang.Number) r6.getValue()).floatValue()) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationScope<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "$this$animateTo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r6.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r1 = r5.$cancelOffset
            float r0 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.access$coerceToTarget(r0, r1)
            kotlin.jvm.internal.Ref$FloatRef r1 = r5.$consumedUpToNow
            float r1 = r1.element
            float r1 = r0 - r1
            androidx.compose.foundation.gestures.ScrollScope r2 = r5.$this_animateSnap
            float r2 = r2.scrollBy(r1)
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r3 = r5.$onAnimationStep
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            r3.invoke(r4)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            r3 = 1056964608(0x3f000000, float:0.5)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L48
            java.lang.Object r1 = r6.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L45
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            if (r0 != 0) goto L4b
        L48:
            r6.cancelAnimation()
        L4b:
            kotlin.jvm.internal.Ref$FloatRef r6 = r5.$consumedUpToNow
            float r0 = r6.element
            float r0 = r0 + r2
            r6.element = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2.invoke(androidx.compose.animation.core.AnimationScope):void");
    }
}
