package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$2$1", f = "Focusable.kt", i = {}, l = {androidx.appcompat.R.styleable.AppCompatTheme_spinnerDropDownItemStyle}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FocusableKt$focusable$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<FocusInteraction.Focus> $focusedInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$2$1(MutableState<FocusInteraction.Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super FocusableKt$focusable$2$2$1> continuation) {
        super(2, continuation);
        this.$focusedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FocusableKt$focusable$2$2$1(this.$focusedInteraction, this.$interactionSource, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableState<FocusInteraction.Focus> mutableState;
        MutableState<FocusInteraction.Focus> mutableState2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FocusInteraction.Focus value = this.$focusedInteraction.getValue();
            if (value != null) {
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                mutableState = this.$focusedInteraction;
                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(value);
                if (mutableInteractionSource != null) {
                    this.L$0 = mutableState;
                    this.label = 1;
                    if (mutableInteractionSource.emit(unfocus, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableState2 = mutableState;
                }
                mutableState.setValue(null);
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableState2 = (MutableState) this.L$0;
        ResultKt.throwOnFailure(obj);
        mutableState = mutableState2;
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }
}
