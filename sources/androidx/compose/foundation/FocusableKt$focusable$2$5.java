package androidx.compose.foundation;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FocusableKt$focusable$2$5 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ MutableState<FocusInteraction$Focus> $focusedInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;
    final /* synthetic */ MutableState<PinnableContainer.PinnedHandle> $pinHandle$delegate;
    final /* synthetic */ PinnableContainer $pinnableContainer;
    final /* synthetic */ CoroutineScope $scope;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$1", f = "Focusable.kt", i = {1}, l = {147, 151, 154}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
        final /* synthetic */ MutableState<FocusInteraction$Focus> $focusedInteraction;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<FocusInteraction$Focus> mutableState, MutableInteractionSource mutableInteractionSource, BringIntoViewRequester bringIntoViewRequester, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$focusedInteraction = mutableState;
            this.$interactionSource = mutableInteractionSource;
            this.$bringIntoViewRequester = bringIntoViewRequester;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, this.$bringIntoViewRequester, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r9)
                goto L7c
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                java.lang.Object r1 = r8.L$0
                androidx.compose.foundation.interaction.FocusInteraction$Focus r1 = (androidx.compose.foundation.interaction.FocusInteraction$Focus) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L6a
            L26:
                java.lang.Object r1 = r8.L$0
                androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L52
            L2e:
                kotlin.ResultKt.throwOnFailure(r9)
                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r9 = r8.$focusedInteraction
                java.lang.Object r9 = r9.getValue()
                androidx.compose.foundation.interaction.FocusInteraction$Focus r9 = (androidx.compose.foundation.interaction.FocusInteraction$Focus) r9
                if (r9 == 0) goto L56
                androidx.compose.foundation.interaction.MutableInteractionSource r1 = r8.$interactionSource
                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r6 = r8.$focusedInteraction
                androidx.compose.foundation.interaction.FocusInteraction$Unfocus r7 = new androidx.compose.foundation.interaction.FocusInteraction$Unfocus
                r7.<init>(r9)
                if (r1 == 0) goto L53
                r8.L$0 = r6
                r8.label = r4
                java.lang.Object r9 = r1.emit(r7, r8)
                if (r9 != r0) goto L51
                return r0
            L51:
                r1 = r6
            L52:
                r6 = r1
            L53:
                r6.setValue(r5)
            L56:
                androidx.compose.foundation.interaction.FocusInteraction$Focus r1 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
                r1.<init>()
                androidx.compose.foundation.interaction.MutableInteractionSource r9 = r8.$interactionSource
                if (r9 == 0) goto L6a
                r8.L$0 = r1
                r8.label = r3
                java.lang.Object r9 = r9.emit(r1, r8)
                if (r9 != r0) goto L6a
                return r0
            L6a:
                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.FocusInteraction$Focus> r9 = r8.$focusedInteraction
                r9.setValue(r1)
                androidx.compose.foundation.relocation.BringIntoViewRequester r9 = r8.$bringIntoViewRequester
                r8.L$0 = r5
                r8.label = r2
                java.lang.Object r9 = tb.on.a(r9, r5, r8, r4, r5)
                if (r9 != r0) goto L7c
                return r0
            L7c:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableKt$focusable$2$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.foundation.FocusableKt$focusable$2$5$2", f = "Focusable.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.FocusableKt$focusable$2$5$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<FocusInteraction$Focus> $focusedInteraction;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableState<FocusInteraction$Focus> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$focusedInteraction = mutableState;
            this.$interactionSource = mutableInteractionSource;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$focusedInteraction, this.$interactionSource, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            MutableState<FocusInteraction$Focus> mutableState;
            MutableState<FocusInteraction$Focus> mutableState2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FocusInteraction$Focus focusInteraction$Focus = (FocusInteraction$Focus) this.$focusedInteraction.getValue();
                if (focusInteraction$Focus != null) {
                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                    mutableState = this.$focusedInteraction;
                    FocusInteraction focusInteraction$Unfocus = new FocusInteraction$Unfocus(focusInteraction$Focus);
                    if (mutableInteractionSource != null) {
                        this.L$0 = mutableState;
                        this.label = 1;
                        if (mutableInteractionSource.emit(focusInteraction$Unfocus, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableState2 = mutableState;
                    }
                    mutableState.setValue((Object) null);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState2 = (MutableState) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableState = mutableState2;
            mutableState.setValue((Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$5(PinnableContainer pinnableContainer, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<PinnableContainer.PinnedHandle> mutableState2, MutableState<FocusInteraction$Focus> mutableState3, MutableInteractionSource mutableInteractionSource, BringIntoViewRequester bringIntoViewRequester) {
        super(1);
        this.$pinnableContainer = pinnableContainer;
        this.$scope = coroutineScope;
        this.$isFocused$delegate = mutableState;
        this.$pinHandle$delegate = mutableState2;
        this.$focusedInteraction = mutableState3;
        this.$interactionSource = mutableInteractionSource;
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        FocusableKt.focusable.2.access$invoke$lambda$3(this.$isFocused$delegate, focusState.isFocused());
        if (FocusableKt.focusable.2.access$invoke$lambda$2(this.$isFocused$delegate)) {
            MutableState<PinnableContainer.PinnedHandle> mutableState = this.$pinHandle$delegate;
            PinnableContainer pinnableContainer = this.$pinnableContainer;
            FocusableKt.focusable.2.access$invoke$lambda$10(mutableState, pinnableContainer != null ? pinnableContainer.pin() : null);
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$focusedInteraction, this.$interactionSource, this.$bringIntoViewRequester, null), 3, (Object) null);
            return;
        }
        PinnableContainer.PinnedHandle access$invoke$lambda$9 = FocusableKt.focusable.2.access$invoke$lambda$9(this.$pinHandle$delegate);
        if (access$invoke$lambda$9 != null) {
            access$invoke$lambda$9.unpin();
        }
        FocusableKt.focusable.2.access$invoke$lambda$10(this.$pinHandle$delegate, (PinnableContainer.PinnedHandle) null);
        d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$focusedInteraction, this.$interactionSource, null), 3, (Object) null);
    }
}
