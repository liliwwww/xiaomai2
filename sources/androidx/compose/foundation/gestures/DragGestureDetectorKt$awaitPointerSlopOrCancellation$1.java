package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {674, 708}, m = "awaitPointerSlopOrCancellation-wtdNQyU", n = {"$this$awaitPointerSlopOrCancellation_u2dwtdNQyU", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "dragEvent", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "F$0", "F$1", "F$2"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m178awaitPointerSlopOrCancellationwtdNQyU(null, 0L, 0, null, false, null, this);
    }
}
