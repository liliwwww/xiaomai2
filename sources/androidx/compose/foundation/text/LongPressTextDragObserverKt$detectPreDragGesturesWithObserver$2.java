package androidx.compose.foundation.text;

import androidx.appcompat.R;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {0, 1, 1}, l = {R.styleable.AppCompatTheme_selectableItemBackgroundBorderless, 102}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextDragObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.$observer = textDragObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.$observer, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[EDGE_INSN: B:25:0x0099->B:17:0x0099 BREAK  A[LOOP:0: B:7:0x0073->B:14:0x0096], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0064 -> B:6:0x0067). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
        /*
            r16 = this;
            r6 = r16
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L32
            if (r0 == r9) goto L27
            if (r0 != r8) goto L1f
            java.lang.Object r0 = r6.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            java.lang.Object r1 = r6.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r17)
            r3 = r17
            r2 = r6
            goto L67
        L1f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L27:
            java.lang.Object r0 = r6.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r0 = r17
            goto L4c
        L32:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r0 = r6.L$0
            r10 = r0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            r1 = 0
            r2 = 0
            r4 = 3
            r5 = 0
            r6.L$0 = r10
            r6.label = r9
            r0 = r10
            r3 = r16
            java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r0, r1, r2, r3, r4, r5)
            if (r0 != r7) goto L4c
            return r7
        L4c:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            androidx.compose.foundation.text.TextDragObserver r1 = r6.$observer
            long r2 = r0.m1465getPositionF1C5BW0()
            r1.mo434onDownk4lQ0M(r2)
            r2 = r6
            r1 = r10
        L59:
            r2.L$0 = r1
            r2.L$1 = r0
            r2.label = r8
            r3 = 0
            java.lang.Object r3 = tb.je.t(r1, r3, r2, r9, r3)
            if (r3 != r7) goto L67
            return r7
        L67:
            androidx.compose.ui.input.pointer.PointerEvent r3 = (androidx.compose.ui.input.pointer.PointerEvent) r3
            java.util.List r3 = r3.getChanges()
            int r4 = r3.size()
            r5 = 0
            r10 = 0
        L73:
            if (r10 >= r4) goto L99
            java.lang.Object r11 = r3.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            long r12 = r11.m1464getIdJ3iCeTQ()
            long r14 = r0.m1464getIdJ3iCeTQ()
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m1450equalsimpl0(r12, r14)
            if (r12 == 0) goto L91
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L91
            r11 = 1
            goto L92
        L91:
            r11 = 0
        L92:
            if (r11 == 0) goto L96
            r5 = 1
            goto L99
        L96:
            int r10 = r10 + 1
            goto L73
        L99:
            if (r5 != 0) goto L59
            androidx.compose.foundation.text.TextDragObserver r0 = r2.$observer
            r0.onUp()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
