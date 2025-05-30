package androidx.compose.foundation.gestures;

import androidx.constraintlayout.motion.widget.Key;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {106, 110}, m = "detectZoom", n = {"$this$detectZoom", "panZoomLock", "state", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "lockedToPanZoom", "touchSlop"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "F$0"})
/* loaded from: classes.dex */
final class TransformableKt$detectZoom$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    TransformableKt$detectZoom$1(Continuation<? super TransformableKt$detectZoom$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object detectZoom;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        detectZoom = TransformableKt.detectZoom(null, null, null, this);
        return detectZoom;
    }
}
