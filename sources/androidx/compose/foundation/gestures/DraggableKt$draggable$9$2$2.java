package androidx.compose.foundation.gestures;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2", f = "Draggable.kt", i = {0}, l = {246}, m = "invokeSuspend", n = {"$this$drag"}, s = {"L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$draggable$9$2$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<DragEvent> $channel;
    final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
    final /* synthetic */ Orientation $orientation;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$9$2$2(Ref.ObjectRef<DragEvent> objectRef, Channel<DragEvent> channel, Orientation orientation, Continuation<? super DraggableKt$draggable$9$2$2> continuation) {
        super(2, continuation);
        this.$event = objectRef;
        this.$channel = channel;
        this.$orientation = orientation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DraggableKt$draggable$9$2$2 draggableKt$draggable$9$2$2 = new DraggableKt$draggable$9$2$2(this.$event, this.$channel, this.$orientation, continuation);
        draggableKt$draggable$9$2$2.L$0 = obj;
        return draggableKt$draggable$9$2$2;
    }

    @Nullable
    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
        return create(dragScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0060 -> B:5:0x0066). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r8.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r8.L$0
            androidx.compose.foundation.gestures.DragScope r3 = (androidx.compose.foundation.gestures.DragScope) r3
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r8
            goto L66
        L1b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L23:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            androidx.compose.foundation.gestures.DragScope r9 = (androidx.compose.foundation.gestures.DragScope) r9
            r3 = r9
            r9 = r8
        L2c:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
            java.lang.Object r1 = r1.element
            boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
            if (r4 != 0) goto L6c
            boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
            if (r4 != 0) goto L6c
            boolean r4 = r1 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
            if (r4 == 0) goto L3f
            androidx.compose.foundation.gestures.DragEvent$DragDelta r1 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r1
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L4f
            androidx.compose.foundation.gestures.Orientation r4 = r9.$orientation
            long r5 = r1.m164getDeltaF1C5BW0()
            float r1 = androidx.compose.foundation.gestures.DraggableKt.access$toFloat-3MmeM6k(r5, r4)
            r3.dragBy(r1)
        L4f:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r9.$event
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.DragEvent> r4 = r9.$channel
            r9.L$0 = r3
            r9.L$1 = r1
            r9.label = r2
            java.lang.Object r4 = r4.receive(r9)
            if (r4 != r0) goto L60
            return r0
        L60:
            r7 = r0
            r0 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r7
        L66:
            r3.element = r9
            r9 = r0
            r0 = r1
            r3 = r4
            goto L2c
        L6c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
