package androidx.compose.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2", f = "MotionLayout.kt", i = {}, l = {237, 247}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MotionLayoutKt$MotionLayoutCore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animateToEnd$delegate;
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableState<ConstraintSet> $end$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $start$delegate;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$2(Channel<ConstraintSet> channel, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3, Continuation<? super MotionLayoutKt$MotionLayoutCore$2> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$progress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$animateToEnd$delegate = mutableState;
        this.$start$delegate = mutableState2;
        this.$end$delegate = mutableState3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MotionLayoutKt$MotionLayoutCore$2(this.$channel, this.$progress, this.$animationSpec, this.$finishedAnimationListener, this.$animateToEnd$delegate, this.$start$delegate, this.$end$delegate, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00c6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b4 -> B:6:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00cb -> B:9:0x0034). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r1 = r13.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r1
            r1 = r13
            goto Lb6
        L19:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L21:
            java.lang.Object r1 = r13.L$0
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r12 = r13
            goto L42
        L2a:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.channels.Channel<androidx.constraintlayout.compose.ConstraintSet> r14 = r13.$channel
            kotlinx.coroutines.channels.ChannelIterator r14 = r14.iterator()
            r1 = r13
        L34:
            r1.L$0 = r14
            r1.label = r3
            java.lang.Object r4 = r14.hasNext(r1)
            if (r4 != r0) goto L3f
            return r0
        L3f:
            r12 = r1
            r1 = r14
            r14 = r4
        L42:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto Lcf
            java.lang.Object r14 = r1.next()
            androidx.constraintlayout.compose.ConstraintSet r14 = (androidx.constraintlayout.compose.ConstraintSet) r14
            kotlinx.coroutines.channels.Channel<androidx.constraintlayout.compose.ConstraintSet> r4 = r12.$channel
            java.lang.Object r4 = r4.tryReceive-PtdJZtk()
            java.lang.Object r4 = tb.is.f(r4)
            androidx.constraintlayout.compose.ConstraintSet r4 = (androidx.constraintlayout.compose.ConstraintSet) r4
            if (r4 != 0) goto L5f
            goto L60
        L5f:
            r14 = r4
        L60:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r12.$animateToEnd$delegate
            boolean r4 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-16(r4)
            if (r4 == 0) goto L6b
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L6c
        L6b:
            r4 = 0
        L6c:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r12.$animateToEnd$delegate
            boolean r5 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-16(r5)
            if (r5 == 0) goto L7b
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r5 = r12.$start$delegate
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-8(r5)
            goto L81
        L7b:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r5 = r12.$end$delegate
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-11(r5)
        L81:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r5)
            if (r5 != 0) goto Lcb
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r12.$animateToEnd$delegate
            boolean r5 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-16(r5)
            if (r5 == 0) goto L95
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r5 = r12.$end$delegate
            androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-12(r5, r14)
            goto L9a
        L95:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r5 = r12.$start$delegate
            androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-9(r5, r14)
        L9a:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r14 = r12.$progress
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r6 = r12.$animationSpec
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r12.L$0 = r1
            r12.label = r2
            r4 = r14
            r9 = r12
            java.lang.Object r14 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r14 != r0) goto Lb4
            return r0
        Lb4:
            r14 = r1
            r1 = r12
        Lb6:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r1.$animateToEnd$delegate
            boolean r5 = androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-16(r4)
            r5 = r5 ^ r3
            androidx.constraintlayout.compose.MotionLayoutKt.access$MotionLayoutCore$lambda-17(r4, r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r1.$finishedAnimationListener
            if (r4 != 0) goto Lc6
            goto L34
        Lc6:
            r4.invoke()
            goto L34
        Lcb:
            r14 = r1
            r1 = r12
            goto L34
        Lcf:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.MotionLayoutKt$MotionLayoutCore$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
