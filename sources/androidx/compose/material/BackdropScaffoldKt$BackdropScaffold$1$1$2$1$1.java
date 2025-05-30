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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BackdropScaffoldState $scaffoldState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scaffoldState = backdropScaffoldState;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$scaffoldState, continuation);
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
                BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                this.label = 1;
                if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
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
    BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1(boolean z, BackdropScaffoldState backdropScaffoldState, CoroutineScope coroutineScope) {
        super(0);
        this.$gesturesEnabled = z;
        this.$scaffoldState = backdropScaffoldState;
        this.$scope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m499invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m499invoke() {
        if (this.$gesturesEnabled && ((Boolean) this.$scaffoldState.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed)).booleanValue()) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$scaffoldState, null), 3, (Object) null);
        }
    }
}
