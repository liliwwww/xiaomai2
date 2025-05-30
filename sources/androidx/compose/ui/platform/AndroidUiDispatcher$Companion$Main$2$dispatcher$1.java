package androidx.compose.ui.platform;

import android.view.Choreographer;
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
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2$dispatcher$1", f = "AndroidUiDispatcher.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidUiDispatcher$Companion$Main$2$dispatcher$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Choreographer>, Object> {
    int label;

    AndroidUiDispatcher$Companion$Main$2$dispatcher$1(Continuation<? super AndroidUiDispatcher$Companion$Main$2$dispatcher$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Choreographer> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Choreographer.getInstance();
    }
}
