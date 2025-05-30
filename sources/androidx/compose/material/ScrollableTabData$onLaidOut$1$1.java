package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.ScrollableTabData$onLaidOut$1$1", f = "TabRow.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollableTabData$onLaidOut$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $calculatedOffset;
    int label;
    final /* synthetic */ ScrollableTabData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableTabData$onLaidOut$1$1(ScrollableTabData scrollableTabData, int i, Continuation<? super ScrollableTabData$onLaidOut$1$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollableTabData;
        this.$calculatedOffset = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ScrollableTabData$onLaidOut$1$1(this.this$0, this.$calculatedOffset, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollState access$getScrollState$p = ScrollableTabData.access$getScrollState$p(this.this$0);
            int i2 = this.$calculatedOffset;
            AnimationSpec access$getScrollableTabRowScrollSpec$p = TabRowKt.access$getScrollableTabRowScrollSpec$p();
            this.label = 1;
            if (access$getScrollState$p.animateScrollTo(i2, access$getScrollableTabRowScrollSpec$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
