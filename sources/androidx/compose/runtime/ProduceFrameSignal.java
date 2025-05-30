package androidx.compose.runtime;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ProduceFrameSignal {

    @Nullable
    private Object pendingFrameContinuation;

    @Nullable
    public final Object awaitFrameRequest(@NotNull Object obj, @NotNull Continuation<? super Unit> continuation) {
        Object obj2;
        Object obj3;
        Continuation continuation2;
        Object obj4;
        Object obj5;
        synchronized (obj) {
            Object obj6 = this.pendingFrameContinuation;
            obj2 = RecomposerKt.ProduceAnotherFrame;
            if (obj6 == obj2) {
                obj5 = RecomposerKt.FramePending;
                this.pendingFrameContinuation = obj5;
                return Unit.INSTANCE;
            }
            Unit unit = Unit.INSTANCE;
            Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            synchronized (obj) {
                Object obj7 = this.pendingFrameContinuation;
                obj3 = RecomposerKt.ProduceAnotherFrame;
                if (obj7 == obj3) {
                    obj4 = RecomposerKt.FramePending;
                    this.pendingFrameContinuation = obj4;
                    continuation2 = cancellableContinuationImpl;
                } else {
                    this.pendingFrameContinuation = cancellableContinuationImpl;
                    continuation2 = null;
                }
            }
            if (continuation2 != null) {
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(unit));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : unit;
        }
    }

    @Nullable
    public final Continuation<Unit> requestFrameLocked() {
        Object obj;
        Object obj2;
        boolean areEqual;
        Object obj3;
        Object obj4;
        Object obj5 = this.pendingFrameContinuation;
        if (obj5 instanceof Continuation) {
            obj4 = RecomposerKt.FramePending;
            this.pendingFrameContinuation = obj4;
            return (Continuation) obj5;
        }
        obj = RecomposerKt.ProduceAnotherFrame;
        if (Intrinsics.areEqual(obj5, obj)) {
            areEqual = true;
        } else {
            obj2 = RecomposerKt.FramePending;
            areEqual = Intrinsics.areEqual(obj5, obj2);
        }
        if (areEqual) {
            return null;
        }
        if (obj5 == null) {
            obj3 = RecomposerKt.ProduceAnotherFrame;
            this.pendingFrameContinuation = obj3;
            return null;
        }
        throw new IllegalStateException(("invalid pendingFrameContinuation " + obj5).toString());
    }

    public final void takeFrameRequestLocked() {
        Object obj;
        Object obj2 = this.pendingFrameContinuation;
        obj = RecomposerKt.FramePending;
        if (!(obj2 == obj)) {
            throw new IllegalStateException("frame not pending".toString());
        }
        this.pendingFrameContinuation = null;
    }
}
