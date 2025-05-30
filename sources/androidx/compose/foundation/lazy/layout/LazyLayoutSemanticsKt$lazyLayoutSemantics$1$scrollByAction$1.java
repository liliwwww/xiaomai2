package androidx.compose.foundation.lazy.layout;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 extends Lambda implements Function2<Float, Float, Boolean> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1", f = "LazyLayoutSemantics.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $delta;
        final /* synthetic */ LazyLayoutSemanticState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyLayoutSemanticState lazyLayoutSemanticState, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = lazyLayoutSemanticState;
            this.$delta = f;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$delta, continuation);
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
                LazyLayoutSemanticState lazyLayoutSemanticState = this.$state;
                float f = this.$delta;
                this.label = 1;
                if (lazyLayoutSemanticState.animateScrollBy(f, this) == coroutine_suspended) {
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
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1(boolean z, CoroutineScope coroutineScope, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(2);
        this.$isVertical = z;
        this.$coroutineScope = coroutineScope;
        this.$state = lazyLayoutSemanticState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
    }

    @NotNull
    public final Boolean invoke(float f, float f2) {
        if (this.$isVertical) {
            f = f2;
        }
        d.d(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$state, f, null), 3, (Object) null);
        return Boolean.TRUE;
    }
}
