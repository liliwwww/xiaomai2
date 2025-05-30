package androidx.compose.material;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ModalBottomSheetState $sheetState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sheetState = modalBottomSheetState;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$sheetState, continuation);
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
                ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                this.label = 1;
                if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        super(0);
        this.$sheetState = modalBottomSheetState;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m776invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m776invoke() {
        if (((Boolean) this.$sheetState.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden)).booleanValue()) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$sheetState, null), 3, (Object) null);
        }
    }
}
