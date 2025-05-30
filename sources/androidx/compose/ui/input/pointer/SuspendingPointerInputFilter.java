package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iw1;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SuspendingPointerInputFilter extends PointerInputFilter implements PointerInputModifier, PointerInputScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private long boundsSize;

    @NotNull
    private CoroutineScope coroutineScope;

    @NotNull
    private PointerEvent currentEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;

    @Nullable
    private PointerEvent lastPointerEvent;

    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputFilter $$delegate_0;

        @NotNull
        private PointerEventPass awaitPass;

        @NotNull
        private final Continuation<R> completion;

        @NotNull
        private final CoroutineContext context;

        @Nullable
        private CancellableContinuation<? super PointerEvent> pointerAwaiter;
        final /* synthetic */ SuspendingPointerInputFilter this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public PointerEventHandlerCoroutine(@NotNull SuspendingPointerInputFilter suspendingPointerInputFilter, Continuation<? super R> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            this.this$0 = suspendingPointerInputFilter;
            this.completion = continuation;
            this.$$delegate_0 = suspendingPointerInputFilter;
            this.awaitPass = PointerEventPass.Main;
            this.context = EmptyCoroutineContext.INSTANCE;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @Nullable
        public Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public final void cancel(@Nullable Throwable th) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(th);
            }
            this.pointerAwaiter = null;
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.context;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public PointerEvent getCurrentEvent() {
            return this.this$0.currentEvent;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getExtendedTouchPadding-NH-jbRc */
        public long mo1409getExtendedTouchPaddingNHjbRc() {
            return this.this$0.mo1473getExtendedTouchPaddingNHjbRc();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /* renamed from: getSize-YbymL2g */
        public long mo1410getSizeYbymL2g() {
            return this.this$0.boundsSize;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @NotNull
        public ViewConfiguration getViewConfiguration() {
            return this.this$0.getViewConfiguration();
        }

        public final void offerPointerEvent(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            Intrinsics.checkNotNullParameter(pointerEvent, NotificationCompat.CATEGORY_EVENT);
            Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
            if (pointerEventPass != this.awaitPass || (cancellableContinuation = this.pointerAwaiter) == null) {
                return;
            }
            this.pointerAwaiter = null;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl(pointerEvent));
        }

        public void resumeWith(@NotNull Object obj) {
            MutableVector mutableVector = this.this$0.pointerHandlers;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.this$0;
            synchronized (mutableVector) {
                suspendingPointerInputFilter.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: roundToPx--R2X_6o */
        public int mo318roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo318roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: roundToPx-0680j_4 */
        public int mo319roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo319roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDp-GaN1DYA */
        public float mo310toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo310toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDp-u2uoSUM */
        public float mo311toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo311toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDp-u2uoSUM */
        public float mo312toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo312toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toDpSize-k-rfVVM */
        public long mo313toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo313toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toPx--R2X_6o */
        public float mo320toPxR2X_6o(long j) {
            return this.$$delegate_0.mo320toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toPx-0680j_4 */
        public float mo321toPx0680j_4(float f) {
            return this.$$delegate_0.mo321toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        @NotNull
        public Rect toRect(@NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSize-XkaWNTQ */
        public long mo314toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo314toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSp-0xMU5do */
        public long mo315toSp0xMU5do(float f) {
            return this.$$delegate_0.mo315toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSp-kPz2Gy4 */
        public long mo316toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo316toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        @Stable
        /* renamed from: toSp-kPz2Gy4 */
        public long mo317toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo317toSpkPz2Gy4(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /* JADX WARN: Type inference failed for: r12v3, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeout(long r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r15) {
            /*
                r11 = this;
                boolean r0 = r15 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout.1
                if (r0 == 0) goto L13
                r0 = r15
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout.1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r11, r15)
            L18:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r12 = r0.L$0
                kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12
                kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L2e
                goto L75
            L2e:
                r13 = move-exception
                goto L79
            L30:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L38:
                kotlin.ResultKt.throwOnFailure(r15)
                r5 = 0
                int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r15 > 0) goto L57
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r15 = r11.pointerAwaiter
                if (r15 == 0) goto L57
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r12)
                java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
                java.lang.Object r2 = kotlin.Result.constructor-impl(r2)
                r15.resumeWith(r2)
            L57:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter r15 = r11.this$0
                kotlinx.coroutines.CoroutineScope r5 = r15.getCoroutineScope()
                r6 = 0
                r7 = 0
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 r8 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1
                r8.<init>(r12, r11, r4)
                r9 = 3
                r10 = 0
                kotlinx.coroutines.Job r12 = kotlinx.coroutines.d.d(r5, r6, r7, r8, r9, r10)
                r0.L$0 = r12     // Catch: java.lang.Throwable -> L2e
                r0.label = r3     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r15 = r14.invoke(r11, r0)     // Catch: java.lang.Throwable -> L2e
                if (r15 != r1) goto L75
                return r1
            L75:
                kotlinx.coroutines.Job.a.b(r12, r4, r3, r4)
                return r15
            L79:
                kotlinx.coroutines.Job.a.b(r12, r4, r3, r4)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public <T> java.lang.Object withTimeoutOrNull(long r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull.1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull.1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                goto L3e
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.throwOnFailure(r8)
                r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                java.lang.Object r8 = r4.withTimeout(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                if (r8 != r1) goto L3e
                return r1
            L3d:
                r8 = 0
            L3e:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public /* synthetic */ SuspendingPointerInputFilter(ViewConfiguration viewConfiguration, Density density, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewConfiguration, (i & 2) != 0 ? DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null) : density);
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
            mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    int i2 = 0;
                    Object[] content = mutableVector3.getContent();
                    do {
                        ((PointerEventHandlerCoroutine) content[i2]).offerPointerEvent(pointerEvent, pointerEventPass);
                        i2++;
                    } while (i2 < size2);
                }
            } else if (i == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i3 = size - 1;
                Object[] content2 = mutableVector.getContent();
                do {
                    ((PointerEventHandlerCoroutine) content2[i3]).offerPointerEvent(pointerEvent, pointerEventPass);
                    i3--;
                } while (i3 >= 0);
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    private final void forEachCurrentPointerHandler(PointerEventPass pointerEventPass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> function1) {
        MutableVector<PointerEventHandlerCoroutine<?>> mutableVector;
        int size;
        synchronized (this.pointerHandlers) {
            try {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                mutableVector2.addAll(mutableVector2.getSize(), this.pointerHandlers);
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i == 1 || i == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    int i2 = 0;
                    Object[] content = mutableVector3.getContent();
                    do {
                        function1.invoke(content[i2]);
                        i2++;
                    } while (i2 < size2);
                }
            } else if (i == 3 && (size = (mutableVector = this.dispatchingPointerHandlers).getSize()) > 0) {
                int i3 = size - 1;
                Object[] content2 = mutableVector.getContent();
                do {
                    function1.invoke(content2[i3]);
                    i3--;
                } while (i3 >= 0);
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    @Nullable
    public <R> Object awaitPointerEventScope(@NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(this, cancellableContinuationImpl);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            Continuation createCoroutine = ContinuationKt.createCoroutine(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.Companion;
            createCoroutine.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$awaitPointerEventScope$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Throwable th) {
                pointerEventHandlerCoroutine.cancel(th);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    /* renamed from: getExtendedTouchPadding-NH-jbRc */
    public long mo1473getExtendedTouchPaddingNHjbRc() {
        long mo314toSizeXkaWNTQ = mo314toSizeXkaWNTQ(getViewConfiguration().m1796getMinimumTouchTargetSizeMYxV2XQ());
        long j = getSize-YbymL2g();
        return SizeKt.Size(Math.max(0.0f, Size.m903getWidthimpl(mo314toSizeXkaWNTQ) - IntSize.getWidth-impl(j)) / 2.0f, Math.max(0.0f, Size.m900getHeightimpl(mo314toSizeXkaWNTQ) - IntSize.getHeight-impl(j)) / 2.0f);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @NotNull
    public PointerInputFilter getPointerInputFilter() {
        return this;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void onCancel() {
        boolean z;
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent == null) {
            return;
        }
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        while (true) {
            z = true;
            if (i >= size) {
                break;
            }
            if (!(true ^ ((PointerInputChange) changes.get(i)).getPressed())) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            return;
        }
        List changes2 = pointerEvent.getChanges();
        ArrayList arrayList = new ArrayList(changes2.size());
        int size2 = changes2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = (PointerInputChange) changes2.get(i2);
            long m1464getIdJ3iCeTQ = pointerInputChange.m1464getIdJ3iCeTQ();
            long m1465getPositionF1C5BW0 = pointerInputChange.m1465getPositionF1C5BW0();
            arrayList.add(new PointerInputChange(m1464getIdJ3iCeTQ, pointerInputChange.getUptimeMillis(), m1465getPositionF1C5BW0, false, pointerInputChange.getPressure(), pointerInputChange.getUptimeMillis(), pointerInputChange.m1465getPositionF1C5BW0(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), 0, 0L, 1536, (DefaultConstructorMarker) null));
        }
        PointerEvent pointerEvent2 = new PointerEvent(arrayList);
        this.currentEvent = pointerEvent2;
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
        dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
        this.lastPointerEvent = null;
    }

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m1499onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        this.boundsSize = j;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        dispatchPointerEvent(pointerEvent, pointerEventPass);
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) changes.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (!(!z)) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: roundToPx--R2X_6o */
    public int mo318roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo318roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: roundToPx-0680j_4 */
    public int mo319roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo319roundToPx0680j_4(f);
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void setInterceptOutOfBoundsChildEvents(boolean z) {
        this.interceptOutOfBoundsChildEvents = z;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-GaN1DYA */
    public float mo310toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo310toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo311toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo311toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo312toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo312toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    public long mo313toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo313toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toPx--R2X_6o */
    public float mo320toPxR2X_6o(long j) {
        return this.$$delegate_0.mo320toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toPx-0680j_4 */
    public float mo321toPx0680j_4(float f) {
        return this.$$delegate_0.mo321toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ */
    public long mo314toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo314toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-0xMU5do */
    public long mo315toSp0xMU5do(float f) {
        return this.$$delegate_0.mo315toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo316toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo316toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo317toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo317toSpkPz2Gy4(i);
    }

    public SuspendingPointerInputFilter(@NotNull ViewConfiguration viewConfiguration, @NotNull Density density) {
        PointerEvent pointerEvent;
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        Intrinsics.checkNotNullParameter(density, "density");
        this.viewConfiguration = viewConfiguration;
        this.$$delegate_0 = density;
        pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.currentEvent = pointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.getZero-YbymL2g();
        this.coroutineScope = iw1.INSTANCE;
    }
}
