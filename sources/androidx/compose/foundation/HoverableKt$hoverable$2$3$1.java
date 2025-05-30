package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3$1", f = "Hoverable.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class HoverableKt$hoverable$2$3$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $currentContext;
    final /* synthetic */ MutableState<HoverInteraction.Enter> $hoverInteraction$delegate;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HoverableKt$hoverable$2$3$1(CoroutineContext coroutineContext, CoroutineScope coroutineScope, MutableInteractionSource mutableInteractionSource, MutableState<HoverInteraction.Enter> mutableState, Continuation<? super HoverableKt$hoverable$2$3$1> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$scope = coroutineScope;
        this.$interactionSource = mutableInteractionSource;
        this.$hoverInteraction$delegate = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        HoverableKt$hoverable$2$3$1 hoverableKt$hoverable$2$3$1 = new HoverableKt$hoverable$2$3$1(this.$currentContext, this.$scope, this.$interactionSource, this.$hoverInteraction$delegate, continuation);
        hoverableKt$hoverable$2$3$1.L$0 = obj;
        return hoverableKt$hoverable$2$3$1;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0052  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003b -> B:5:0x0040). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r14.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            r4 = r1
            r1 = r0
            r0 = r14
            goto L40
        L17:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1f:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r15 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r15
            r1 = r15
            r15 = r14
        L28:
            kotlin.coroutines.CoroutineContext r4 = r15.$currentContext
            boolean r4 = tb.bb2.m(r4)
            if (r4 == 0) goto L85
            r15.L$0 = r1
            r15.label = r2
            java.lang.Object r4 = tb.je.t(r1, r3, r15, r2, r3)
            if (r4 != r0) goto L3b
            return r0
        L3b:
            r13 = r0
            r0 = r15
            r15 = r4
            r4 = r1
            r1 = r13
        L40:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            int r15 = r15.m1984getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r6 = r5.getEnter-7fucELk()
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m1991equalsimpl0(r15, r6)
            if (r6 == 0) goto L65
            kotlinx.coroutines.CoroutineScope r7 = r0.$scope
            r8 = 0
            r9 = 0
            androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1 r10 = new androidx.compose.foundation.HoverableKt$hoverable$2$3$1$1
            androidx.compose.foundation.interaction.MutableInteractionSource r15 = r0.$interactionSource
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter> r5 = r0.$hoverInteraction$delegate
            r10.<init>(r15, r5, r3)
            r11 = 3
            r12 = 0
            kotlinx.coroutines.d.d(r7, r8, r9, r10, r11, r12)
            goto L81
        L65:
            int r5 = r5.getExit-7fucELk()
            boolean r15 = androidx.compose.ui.input.pointer.PointerEventType.m1991equalsimpl0(r15, r5)
            if (r15 == 0) goto L81
            kotlinx.coroutines.CoroutineScope r5 = r0.$scope
            r6 = 0
            r7 = 0
            androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2 r8 = new androidx.compose.foundation.HoverableKt$hoverable$2$3$1$2
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction$Enter> r15 = r0.$hoverInteraction$delegate
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$interactionSource
            r8.<init>(r15, r9, r3)
            r9 = 3
            r10 = 0
            kotlinx.coroutines.d.d(r5, r6, r7, r8, r9, r10)
        L81:
            r15 = r0
            r0 = r1
            r1 = r4
            goto L28
        L85:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
