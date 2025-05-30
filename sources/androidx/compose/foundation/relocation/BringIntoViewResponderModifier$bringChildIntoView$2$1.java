package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2$1", f = "BringIntoViewResponder.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BringIntoViewResponderModifier$bringChildIntoView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Rect> $boundsProvider;
    final /* synthetic */ LayoutCoordinates $childCoordinates;
    int label;
    final /* synthetic */ BringIntoViewResponderModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderModifier$bringChildIntoView$2$1(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super BringIntoViewResponderModifier$bringChildIntoView$2$1> continuation) {
        super(2, continuation);
        this.this$0 = bringIntoViewResponderModifier;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BringIntoViewResponderModifier$bringChildIntoView$2$1(this.this$0, this.$childCoordinates, this.$boundsProvider, continuation);
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
            BringIntoViewResponder responder = this.this$0.getResponder();
            1 r1 = new 1(this.this$0, this.$childCoordinates, this.$boundsProvider);
            this.label = 1;
            if (responder.bringChildIntoView(r1, this) == coroutine_suspended) {
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
