package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {239, 241, 243, 251, 253, 257}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "event", "$this$LaunchedEffect", "event", "$this$LaunchedEffect", "event", "$this$LaunchedEffect", "$this$LaunchedEffect", "$this$LaunchedEffect"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DraggableKt$draggable$9$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<DragEvent> $channel;
    final /* synthetic */ State<DragLogic> $dragLogic$delegate;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ DraggableState $state;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$9$2(Channel<DragEvent> channel, DraggableState draggableState, State<DragLogic> state, Orientation orientation, Continuation<? super DraggableKt$draggable$9$2> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$state = draggableState;
        this.$dragLogic$delegate = state;
        this.$orientation = orientation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DraggableKt$draggable$9$2 draggableKt$draggable$9$2 = new DraggableKt$draggable$9$2(this.$channel, this.$state, this.$dragLogic$delegate, this.$orientation, continuation);
        draggableKt$draggable$9$2.L$0 = obj;
        return draggableKt$draggable$9$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc A[Catch: CancellationException -> 0x010e, TryCatch #3 {CancellationException -> 0x010e, blocks: (B:27:0x00d0, B:29:0x00dc, B:34:0x00f8, B:36:0x00fc), top: B:26:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[Catch: CancellationException -> 0x010e, TryCatch #3 {CancellationException -> 0x010e, blocks: (B:27:0x00d0, B:29:0x00dc, B:34:0x00f8, B:36:0x00fc), top: B:26:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x010a -> B:9:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0126 -> B:9:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x012a -> B:9:0x0067). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
