package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
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
@DebugMetadata(c = "androidx.compose.foundation.text.TextFieldGestureModifiersKt$mouseDragGestureDetector$1", f = "TextFieldGestureModifiers.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldGestureModifiersKt$mouseDragGestureDetector$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MouseSelectionObserver $observer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldGestureModifiersKt$mouseDragGestureDetector$1(MouseSelectionObserver mouseSelectionObserver, Continuation<? super TextFieldGestureModifiersKt$mouseDragGestureDetector$1> continuation) {
        super(2, continuation);
        this.$observer = mouseSelectionObserver;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextFieldGestureModifiersKt$mouseDragGestureDetector$1 textFieldGestureModifiersKt$mouseDragGestureDetector$1 = new TextFieldGestureModifiersKt$mouseDragGestureDetector$1(this.$observer, continuation);
        textFieldGestureModifiersKt$mouseDragGestureDetector$1.L$0 = obj;
        return textFieldGestureModifiersKt$mouseDragGestureDetector$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            MouseSelectionObserver mouseSelectionObserver = this.$observer;
            this.label = 1;
            if (TextSelectionMouseDetectorKt.mouseSelectionDetector(pointerInputScope, mouseSelectionObserver, this) == coroutine_suspended) {
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
