package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bb2;
import tb.eo4;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ContentInViewModifier$launchAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* compiled from: Taobao */
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1", f = "ContentInViewModifier.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $animationJob;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewModifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContentInViewModifier contentInViewModifier, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = contentInViewModifier;
            this.$animationJob = job;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
            return create(scrollScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            UpdatableAnimationState updatableAnimationState;
            float calculateScrollDelta;
            UpdatableAnimationState updatableAnimationState2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                updatableAnimationState = this.this$0.animationState;
                calculateScrollDelta = this.this$0.calculateScrollDelta();
                updatableAnimationState.setValue(calculateScrollDelta);
                updatableAnimationState2 = this.this$0.animationState;
                final ContentInViewModifier contentInViewModifier = this.this$0;
                final Job job = this.$animationJob;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke(((Number) obj2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        boolean z;
                        z = ContentInViewModifier.this.reverseDirection;
                        float f2 = z ? 1.0f : -1.0f;
                        float scrollBy = f2 * scrollScope.scrollBy(f2 * f);
                        if (scrollBy < f) {
                            bb2.f(job, "Scroll animation cancelled because scroll was not consumed (" + scrollBy + " < " + f + ')', (Throwable) null, 2, (Object) null);
                        }
                    }
                };
                final ContentInViewModifier contentInViewModifier2 = this.this$0;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.2
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m162invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m162invoke() {
                        boolean z;
                        UpdatableAnimationState updatableAnimationState3;
                        float calculateScrollDelta2;
                        Rect focusedChildBounds;
                        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = ContentInViewModifier.this.bringIntoViewRequests;
                        ContentInViewModifier contentInViewModifier3 = ContentInViewModifier.this;
                        while (true) {
                            if (!BringIntoViewRequestPriorityQueue.access$getRequests$p(bringIntoViewRequestPriorityQueue).isNotEmpty()) {
                                break;
                            }
                            Rect rect = (Rect) ((ContentInViewModifier.Request) BringIntoViewRequestPriorityQueue.access$getRequests$p(bringIntoViewRequestPriorityQueue).last()).getCurrentBounds().invoke();
                            if (!(rect == null ? true : ContentInViewModifier.m159isMaxVisibleO0kMr_c$default(contentInViewModifier3, rect, 0L, 1, null))) {
                                break;
                            }
                            CancellableContinuation continuation = ((ContentInViewModifier.Request) BringIntoViewRequestPriorityQueue.access$getRequests$p(bringIntoViewRequestPriorityQueue).removeAt(BringIntoViewRequestPriorityQueue.access$getRequests$p(bringIntoViewRequestPriorityQueue).getSize() - 1)).getContinuation();
                            Unit unit = Unit.INSTANCE;
                            Result.Companion companion = Result.Companion;
                            continuation.resumeWith(Result.constructor-impl(unit));
                        }
                        z = ContentInViewModifier.this.trackingFocusedChild;
                        if (z) {
                            focusedChildBounds = ContentInViewModifier.this.getFocusedChildBounds();
                            if (focusedChildBounds != null && ContentInViewModifier.m159isMaxVisibleO0kMr_c$default(ContentInViewModifier.this, focusedChildBounds, 0L, 1, null)) {
                                ContentInViewModifier.this.trackingFocusedChild = false;
                            }
                        }
                        updatableAnimationState3 = ContentInViewModifier.this.animationState;
                        calculateScrollDelta2 = ContentInViewModifier.this.calculateScrollDelta();
                        updatableAnimationState3.setValue(calculateScrollDelta2);
                    }
                };
                this.label = 1;
                if (updatableAnimationState2.animateToZero(function1, function0, this) == coroutine_suspended) {
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
    ContentInViewModifier$launchAnimation$1(ContentInViewModifier contentInViewModifier, Continuation<? super ContentInViewModifier$launchAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1 = new ContentInViewModifier$launchAnimation$1(this.this$0, continuation);
        contentInViewModifier$launchAnimation$1.L$0 = obj;
        return contentInViewModifier$launchAnimation$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ScrollableState scrollableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job l = bb2.l(((CoroutineScope) this.L$0).getCoroutineContext());
                    this.this$0.isAnimationRunning = true;
                    scrollableState = this.this$0.scrollState;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, l, null);
                    this.label = 1;
                    if (eo4.e(scrollableState, (MutatePriority) null, anonymousClass1, this, 1, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll((Throwable) null);
                this.this$0.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            this.this$0.isAnimationRunning = false;
            this.this$0.bringIntoViewRequests.cancelAndRemoveAll((Throwable) null);
            this.this$0.trackingFocusedChild = false;
            throw th;
        }
    }
}
