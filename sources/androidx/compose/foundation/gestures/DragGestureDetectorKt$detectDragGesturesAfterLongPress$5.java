package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {235, 236, 241}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes2.dex */
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008e A[Catch: CancellationException -> 0x0031, TryCatch #0 {CancellationException -> 0x0031, blocks: (B:8:0x0015, B:9:0x0086, B:11:0x008e, B:13:0x009d, B:15:0x00a9, B:17:0x00ac, B:20:0x00af, B:24:0x00b5, B:28:0x0025, B:29:0x005e, B:31:0x0062, B:36:0x002d, B:37:0x004d, B:41:0x0040), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5 A[Catch: CancellationException -> 0x0031, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0031, blocks: (B:8:0x0015, B:9:0x0086, B:11:0x008e, B:13:0x009d, B:15:0x00a9, B:17:0x00ac, B:20:0x00af, B:24:0x00b5, B:28:0x0025, B:29:0x005e, B:31:0x0062, B:36:0x002d, B:37:0x004d, B:41:0x0040), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062 A[Catch: CancellationException -> 0x0031, TryCatch #0 {CancellationException -> 0x0031, blocks: (B:8:0x0015, B:9:0x0086, B:11:0x008e, B:13:0x009d, B:15:0x00a9, B:17:0x00ac, B:20:0x00af, B:24:0x00b5, B:28:0x0025, B:29:0x005e, B:31:0x0062, B:36:0x002d, B:37:0x004d, B:41:0x0040), top: B:2:0x0009 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 == r4) goto L29
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r0 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L31
            goto L86
        L19:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L21:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L31
            goto L5e
        L29:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L31
            goto L4d
        L31:
            r12 = move-exception
            goto Lbd
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p004ui.input.pointer.AwaitPointerEventScope) r1
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L31
            r11.label = r4     // Catch: java.util.concurrent.CancellationException -> L31
            r5 = r1
            r8 = r11
            java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L31
            if (r12 != r0) goto L4d
            return r0
        L4d:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.p004ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> L31
            long r4 = r12.m4080getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> L31
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L31
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> L31
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m1220awaitLongPressOrCancellationrnUCldI(r1, r4, r11)     // Catch: java.util.concurrent.CancellationException -> L31
            if (r12 != r0) goto L5e
            return r0
        L5e:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.p004ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> L31
            if (r12 == 0) goto Lba
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L31
            long r4 = r12.m4081getPositionF1C5BW0()     // Catch: java.util.concurrent.CancellationException -> L31
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.p004ui.geometry.Offset.m2545boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> L31
            r3.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> L31
            long r3 = r12.m4080getIdJ3iCeTQ()     // Catch: java.util.concurrent.CancellationException -> L31
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> L31
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> L31
            r12.<init>()     // Catch: java.util.concurrent.CancellationException -> L31
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L31
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L31
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m1230dragjO51t88(r1, r3, r12, r11)     // Catch: java.util.concurrent.CancellationException -> L31
            if (r12 != r0) goto L85
            return r0
        L85:
            r0 = r1
        L86:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.util.concurrent.CancellationException -> L31
            boolean r12 = r12.booleanValue()     // Catch: java.util.concurrent.CancellationException -> L31
            if (r12 == 0) goto Lb5
            androidx.compose.ui.input.pointer.PointerEvent r12 = r0.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> L31
            java.util.List r12 = r12.getChanges()     // Catch: java.util.concurrent.CancellationException -> L31
            r0 = 0
            int r1 = r12.size()     // Catch: java.util.concurrent.CancellationException -> L31
        L9b:
            if (r0 >= r1) goto Laf
            java.lang.Object r2 = r12.get(r0)     // Catch: java.util.concurrent.CancellationException -> L31
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.p004ui.input.pointer.PointerInputChange) r2     // Catch: java.util.concurrent.CancellationException -> L31
            boolean r3 = androidx.compose.p004ui.input.pointer.PointerEventKt.changedToUp(r2)     // Catch: java.util.concurrent.CancellationException -> L31
            if (r3 == 0) goto Lac
            r2.consume()     // Catch: java.util.concurrent.CancellationException -> L31
        Lac:
            int r0 = r0 + 1
            goto L9b
        Laf:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L31
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L31
            goto Lba
        Lb5:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L31
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L31
        Lba:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lbd:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r11.$onDragCancel
            r0.invoke()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
