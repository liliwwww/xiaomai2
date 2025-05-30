package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;
import tb.ma1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Recomposer$effectJob$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$effectJob$1$1(Recomposer recomposer) {
        super(1);
        this.this$0 = recomposer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable final Throwable th) {
        CancellableContinuation cancellableContinuation;
        CancellableContinuation access$getWorkContinuation$p;
        CancellationException a = ma1.a("Recomposer effect job completed", th);
        Object access$getStateLock$p = Recomposer.access$getStateLock$p(this.this$0);
        final Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            Job access$getRunnerJob$p = Recomposer.access$getRunnerJob$p(recomposer);
            cancellableContinuation = null;
            if (access$getRunnerJob$p != null) {
                Recomposer.access$get_state$p(recomposer).setValue(Recomposer$State.ShuttingDown);
                if (!Recomposer.access$isClosed$p(recomposer)) {
                    access$getRunnerJob$p.cancel(a);
                } else if (Recomposer.access$getWorkContinuation$p(recomposer) != null) {
                    access$getWorkContinuation$p = Recomposer.access$getWorkContinuation$p(recomposer);
                    Recomposer.access$setWorkContinuation$p(recomposer, (CancellableContinuation) null);
                    access$getRunnerJob$p.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Throwable) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Throwable th2) {
                            Object access$getStateLock$p2 = Recomposer.access$getStateLock$p(recomposer);
                            Recomposer recomposer2 = recomposer;
                            Throwable th3 = th;
                            synchronized (access$getStateLock$p2) {
                                if (th3 == null) {
                                    th3 = null;
                                } else if (th2 != null) {
                                    if (!(!(th2 instanceof CancellationException))) {
                                        th2 = null;
                                    }
                                    if (th2 != null) {
                                        ExceptionsKt.addSuppressed(th3, th2);
                                    }
                                }
                                Recomposer.access$setCloseCause$p(recomposer2, th3);
                                Recomposer.access$get_state$p(recomposer2).setValue(Recomposer$State.ShutDown);
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    });
                    cancellableContinuation = access$getWorkContinuation$p;
                }
                access$getWorkContinuation$p = null;
                Recomposer.access$setWorkContinuation$p(recomposer, (CancellableContinuation) null);
                access$getRunnerJob$p.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@Nullable Throwable th2) {
                        Object access$getStateLock$p2 = Recomposer.access$getStateLock$p(recomposer);
                        Recomposer recomposer2 = recomposer;
                        Throwable th3 = th;
                        synchronized (access$getStateLock$p2) {
                            if (th3 == null) {
                                th3 = null;
                            } else if (th2 != null) {
                                if (!(!(th2 instanceof CancellationException))) {
                                    th2 = null;
                                }
                                if (th2 != null) {
                                    ExceptionsKt.addSuppressed(th3, th2);
                                }
                            }
                            Recomposer.access$setCloseCause$p(recomposer2, th3);
                            Recomposer.access$get_state$p(recomposer2).setValue(Recomposer$State.ShutDown);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
                cancellableContinuation = access$getWorkContinuation$p;
            } else {
                Recomposer.access$setCloseCause$p(recomposer, a);
                Recomposer.access$get_state$p(recomposer).setValue(Recomposer$State.ShutDown);
                Unit unit = Unit.INSTANCE;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}
