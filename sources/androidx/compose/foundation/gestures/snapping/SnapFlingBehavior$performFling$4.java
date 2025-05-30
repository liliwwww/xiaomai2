package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$4", f = "SnapFlingBehavior.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapFlingBehavior$performFling$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onSettlingDistanceUpdated;
    final /* synthetic */ ScrollScope $this_performFling;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapFlingBehavior$performFling$4(SnapFlingBehavior snapFlingBehavior, ScrollScope scrollScope, float f, Function1<? super Float, Unit> function1, Continuation<? super SnapFlingBehavior$performFling$4> continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$this_performFling = scrollScope;
        this.$initialVelocity = f;
        this.$onSettlingDistanceUpdated = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SnapFlingBehavior$performFling$4(this.this$0, this.$this_performFling, this.$initialVelocity, this.$onSettlingDistanceUpdated, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SnapFlingBehavior snapFlingBehavior = this.this$0;
            ScrollScope scrollScope = this.$this_performFling;
            float f = this.$initialVelocity;
            Function1<Float, Unit> function1 = this.$onSettlingDistanceUpdated;
            this.label = 1;
            obj = SnapFlingBehavior.access$fling(snapFlingBehavior, scrollScope, f, function1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
