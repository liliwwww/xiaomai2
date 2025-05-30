package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1", f = "Scrollable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollableKt$pointerScrollable$3$1 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<NestedScrollDispatcher> $nestedScrollDispatcher;
    final /* synthetic */ State<ScrollingLogic> $scrollLogic;
    /* synthetic */ long J$0;
    int label;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1", f = "Scrollable.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<ScrollingLogic> $scrollLogic;
        final /* synthetic */ long $velocity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<ScrollingLogic> state, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scrollLogic = state;
            this.$velocity = j;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$scrollLogic, this.$velocity, continuation);
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
                ScrollingLogic value = this.$scrollLogic.getValue();
                long j = this.$velocity;
                this.label = 1;
                if (value.m244onDragStoppedsFctU(j, this) == coroutine_suspended) {
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
    ScrollableKt$pointerScrollable$3$1(MutableState<NestedScrollDispatcher> mutableState, State<ScrollingLogic> state, Continuation<? super ScrollableKt$pointerScrollable$3$1> continuation) {
        super(3, continuation);
        this.$nestedScrollDispatcher = mutableState;
        this.$scrollLogic = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m240invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m2719unboximpl(), (Continuation) obj3);
    }

    @Nullable
    /* renamed from: invoke-LuvzFrg, reason: not valid java name */
    public final Object m240invokeLuvzFrg(@NotNull CoroutineScope coroutineScope, long j, @Nullable Continuation<? super Unit> continuation) {
        ScrollableKt$pointerScrollable$3$1 scrollableKt$pointerScrollable$3$1 = new ScrollableKt$pointerScrollable$3$1(this.$nestedScrollDispatcher, this.$scrollLogic, continuation);
        scrollableKt$pointerScrollable$3$1.J$0 = j;
        return scrollableKt$pointerScrollable$3$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        d.d(((NestedScrollDispatcher) this.$nestedScrollDispatcher.getValue()).getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$scrollLogic, this.J$0, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
