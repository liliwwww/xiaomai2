package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyAnimateScrollKt$animateScrollToItem$2$5 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ Ref.FloatRef $prevValue;
    final /* synthetic */ float $target;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2$5(float f, Ref.FloatRef floatRef, ScrollScope scrollScope) {
        super(1);
        this.$target = f;
        this.$prevValue = floatRef;
        this.$$this$scroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
    
        if ((r1 == ((java.lang.Number) r6.getValue()).floatValue()) == false) goto L18;
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
            float r0 = r5.$target
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L1d
            java.lang.Object r0 = r6.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r1 = r5.$target
            float r1 = kotlin.ranges.RangesKt.coerceAtMost(r0, r1)
            goto L31
        L1d:
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L31
            java.lang.Object r0 = r6.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r1 = r5.$target
            float r1 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r1)
        L31:
            kotlin.jvm.internal.Ref$FloatRef r0 = r5.$prevValue
            float r0 = r0.element
            float r0 = r1 - r0
            androidx.compose.foundation.gestures.ScrollScope r2 = r5.$$this$scroll
            float r2 = r2.scrollBy(r0)
            r3 = 1
            r4 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L45
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r6.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L57
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 != 0) goto L5d
        L5a:
            r6.cancelAnimation()
        L5d:
            kotlin.jvm.internal.Ref$FloatRef r6 = r5.$prevValue
            float r1 = r6.element
            float r1 = r1 + r0
            r6.element = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5.invoke(androidx.compose.animation.core.AnimationScope):void");
    }
}
