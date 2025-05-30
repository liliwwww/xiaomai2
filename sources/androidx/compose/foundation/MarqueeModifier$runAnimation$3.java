package androidx.compose.foundation;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifier$runAnimation$3", f = "BasicMarquee.kt", i = {0, 0}, l = {277, 279, 281, 281}, m = "invokeSuspend", n = {"contentWithSpacingWidth", "spec"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class MarqueeModifier$runAnimation$3 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MarqueeModifier$runAnimation$3(MarqueeModifier marqueeModifier, Continuation<? super MarqueeModifier$runAnimation$3> continuation) {
        super(2, continuation);
        this.this$0 = marqueeModifier;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MarqueeModifier$runAnimation$3 marqueeModifier$runAnimation$3 = new MarqueeModifier$runAnimation$3(this.this$0, continuation);
        marqueeModifier$runAnimation$3.L$0 = obj;
        return marqueeModifier$runAnimation$3;
    }

    @Nullable
    public final Object invoke(@Nullable Float f, @Nullable Continuation<? super Unit> continuation) {
        return create(f, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b9 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r9 = r21
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            r11 = 4
            r12 = 3
            r1 = 2
            r2 = 1
            r13 = 0
            r14 = 0
            if (r0 == 0) goto L42
            if (r0 == r2) goto L35
            if (r0 == r1) goto L2e
            if (r0 == r12) goto L29
            if (r0 == r11) goto L20
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L20:
            java.lang.Object r0 = r9.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r22)
            goto Ld4
        L29:
            kotlin.ResultKt.throwOnFailure(r22)
            goto Lba
        L2e:
            kotlin.ResultKt.throwOnFailure(r22)     // Catch: java.lang.Throwable -> L32
            goto La7
        L32:
            r0 = move-exception
            goto Lbd
        L35:
            java.lang.Object r0 = r9.L$1
            androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
            java.lang.Object r2 = r9.L$0
            java.lang.Float r2 = (java.lang.Float) r2
            kotlin.ResultKt.throwOnFailure(r22)
            r3 = r0
            goto L8c
        L42:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r0 = r9.L$0
            java.lang.Float r0 = (java.lang.Float) r0
            if (r0 != 0) goto L4e
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L4e:
            androidx.compose.foundation.MarqueeModifier r3 = r9.this$0
            int r15 = androidx.compose.foundation.MarqueeModifier.access$getIterations$p(r3)
            float r16 = r0.floatValue()
            androidx.compose.foundation.MarqueeModifier r3 = r9.this$0
            int r17 = androidx.compose.foundation.MarqueeModifier.access$getInitialDelayMillis$p(r3)
            androidx.compose.foundation.MarqueeModifier r3 = r9.this$0
            int r18 = androidx.compose.foundation.MarqueeModifier.access$getDelayMillis$p(r3)
            androidx.compose.foundation.MarqueeModifier r3 = r9.this$0
            float r19 = androidx.compose.foundation.MarqueeModifier.access$getVelocity$p(r3)
            androidx.compose.foundation.MarqueeModifier r3 = r9.this$0
            androidx.compose.ui.unit.Density r20 = androidx.compose.foundation.MarqueeModifier.access$getDensity$p(r3)
            androidx.compose.animation.core.AnimationSpec r3 = androidx.compose.foundation.BasicMarqueeKt.m1118access$createMarqueeAnimationSpecZ4HSEVQ(r15, r16, r17, r18, r19, r20)
            androidx.compose.foundation.MarqueeModifier r4 = r9.this$0
            androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.MarqueeModifier.access$getOffset$p(r4)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14)
            r9.L$0 = r0
            r9.L$1 = r3
            r9.label = r2
            java.lang.Object r2 = r4.snapTo(r5, r9)
            if (r2 != r10) goto L8b
            return r10
        L8b:
            r2 = r0
        L8c:
            androidx.compose.foundation.MarqueeModifier r0 = r9.this$0     // Catch: java.lang.Throwable -> L32
            androidx.compose.animation.core.Animatable r0 = androidx.compose.foundation.MarqueeModifier.access$getOffset$p(r0)     // Catch: java.lang.Throwable -> L32
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            r9.L$0 = r13     // Catch: java.lang.Throwable -> L32
            r9.L$1 = r13     // Catch: java.lang.Throwable -> L32
            r9.label = r1     // Catch: java.lang.Throwable -> L32
            r1 = r0
            r6 = r21
            java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L32
            if (r0 != r10) goto La7
            return r10
        La7:
            androidx.compose.foundation.MarqueeModifier r0 = r9.this$0
            androidx.compose.animation.core.Animatable r0 = androidx.compose.foundation.MarqueeModifier.access$getOffset$p(r0)
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14)
            r9.label = r12
            java.lang.Object r0 = r0.snapTo(r1, r9)
            if (r0 != r10) goto Lba
            return r10
        Lba:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Lbd:
            androidx.compose.foundation.MarqueeModifier r1 = r9.this$0
            androidx.compose.animation.core.Animatable r1 = androidx.compose.foundation.MarqueeModifier.access$getOffset$p(r1)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r14)
            r9.L$0 = r0
            r9.L$1 = r13
            r9.label = r11
            java.lang.Object r1 = r1.snapTo(r2, r9)
            if (r1 != r10) goto Ld4
            return r10
        Ld4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifier$runAnimation$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
