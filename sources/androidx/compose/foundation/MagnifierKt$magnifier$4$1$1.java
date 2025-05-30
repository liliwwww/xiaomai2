package androidx.compose.foundation;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1$1", f = "Magnifier.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MagnifierKt$magnifier$4$1$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlatformMagnifier $magnifier;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$1$1(PlatformMagnifier platformMagnifier, Continuation<? super MagnifierKt$magnifier$4$1$1> continuation) {
        super(2, continuation);
        this.$magnifier = platformMagnifier;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagnifierKt$magnifier$4$1$1(this.$magnifier, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Unit unit, @Nullable Continuation<? super Unit> continuation) {
        return create(unit, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$magnifier.updateContent();
        return Unit.INSTANCE;
    }
}
