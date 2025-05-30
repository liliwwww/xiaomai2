package androidx.compose.ui.input.pointer;

import androidx.appcompat.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", f = "PointerIcon.kt", i = {}, l = {R.styleable.AppCompatTheme_listPreferredItemPaddingStart}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PointerIconKt$pointerHoverIcon$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerIcon $icon;
    final /* synthetic */ boolean $overrideDescendants;
    final /* synthetic */ PointerIconService $pointerIconService;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1", f = "PointerIcon.kt", i = {0}, l = {R.styleable.AppCompatTheme_radioButtonStyle}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerIcon $icon;
        final /* synthetic */ boolean $overrideDescendants;
        final /* synthetic */ PointerIconService $pointerIconService;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$overrideDescendants = z;
            this.$pointerIconService = pointerIconService;
            this.$icon = pointerIcon;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x003b -> B:5:0x0040). Please report as a decompilation issue!!! */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                r3 = r1
                r1 = r0
                r0 = r12
                goto L40
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                r1 = r13
                r13 = r12
            L27:
                boolean r3 = r13.$overrideDescendants
                if (r3 == 0) goto L2e
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                goto L30
            L2e:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            L30:
                r13.L$0 = r1
                r13.label = r2
                java.lang.Object r3 = r1.awaitPointerEvent(r3, r13)
                if (r3 != r0) goto L3b
                return r0
            L3b:
                r11 = r0
                r0 = r13
                r13 = r3
                r3 = r1
                r1 = r11
            L40:
                androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
                int r4 = r13.getType-7fucELk()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
                int r6 = r5.m1425getRelease7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.equals-impl0(r4, r6)
                r6 = 0
                if (r4 == 0) goto L6e
                java.util.List r4 = r13.getChanges()
                java.lang.Object r4 = r4.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                long r7 = r3.mo1410getSizeYbymL2g()
                androidx.compose.ui.geometry.Size$Companion r9 = androidx.compose.ui.geometry.Size.Companion
                long r9 = r9.m912getZeroNHjbRc()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.isOutOfBounds-jwHxaWs(r4, r7, r9)
                if (r4 == 0) goto L6e
                r6 = 1
            L6e:
                int r13 = r13.getType-7fucELk()
                int r4 = r5.m1422getExit7fucELk()
                boolean r13 = androidx.compose.ui.input.pointer.PointerEventType.equals-impl0(r13, r4)
                if (r13 != 0) goto L85
                if (r6 != 0) goto L85
                androidx.compose.ui.input.pointer.PointerIconService r13 = r0.$pointerIconService
                androidx.compose.ui.input.pointer.PointerIcon r4 = r0.$icon
                r13.setCurrent(r4)
            L85:
                r13 = r0
                r0 = r1
                r1 = r3
                goto L27
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PointerIconKt$pointerHoverIcon$2$1(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super PointerIconKt$pointerHoverIcon$2$1> continuation) {
        super(2, continuation);
        this.$overrideDescendants = z;
        this.$pointerIconService = pointerIconService;
        this.$icon = pointerIcon;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PointerIconKt$pointerHoverIcon$2$1 pointerIconKt$pointerHoverIcon$2$1 = new PointerIconKt$pointerHoverIcon$2$1(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
        pointerIconKt$pointerHoverIcon$2$1.L$0 = obj;
        return pointerIconKt$pointerHoverIcon$2$1;
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$overrideDescendants, this.$pointerIconService, this.$icon, null);
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutine_suspended) {
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
