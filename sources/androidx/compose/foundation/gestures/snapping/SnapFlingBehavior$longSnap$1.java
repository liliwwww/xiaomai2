package androidx.compose.foundation.gestures.snapping;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0}, l = {179, 191}, m = "longSnap", n = {"this", "$this$longSnap", "onAnimationStep", "remainingScrollOffset"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
final class SnapFlingBehavior$longSnap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$longSnap$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$longSnap$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object longSnap;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        longSnap = this.this$0.longSnap(null, 0.0f, null, this);
        return longSnap;
    }
}
