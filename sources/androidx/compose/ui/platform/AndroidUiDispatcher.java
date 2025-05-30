package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidUiDispatcher extends CoroutineDispatcher {

    @NotNull
    private final Choreographer choreographer;

    @NotNull
    private final dispatchCallback.1 dispatchCallback;

    @NotNull
    private final MonotonicFrameClock frameClock;

    @NotNull
    private final Handler handler;

    @NotNull
    private final Object lock;
    private boolean scheduledFrameDispatch;
    private boolean scheduledTrampolineDispatch;

    @NotNull
    private List<Choreographer.FrameCallback> spareToRunOnFrame;

    @NotNull
    private List<Choreographer.FrameCallback> toRunOnFrame;

    @NotNull
    private final ArrayDeque<Runnable> toRunTrampolined;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Lazy<CoroutineContext> Main$delegate = LazyKt.lazy(Companion.Main.2.INSTANCE);

    @NotNull
    private static final ThreadLocal<CoroutineContext> currentThread = new Companion.currentThread.1();

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CoroutineContext getCurrentThread() {
            if (AndroidUiDispatcher_androidKt.access$isMainThread()) {
                return getMain();
            }
            CoroutineContext coroutineContext = (CoroutineContext) AndroidUiDispatcher.currentThread.get();
            if (coroutineContext != null) {
                return coroutineContext;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }

        @NotNull
        public final CoroutineContext getMain() {
            return (CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue();
        }
    }

    private AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.choreographer = choreographer;
        this.handler = handler;
        this.lock = new Object();
        this.toRunTrampolined = new ArrayDeque<>();
        this.toRunOnFrame = new ArrayList();
        this.spareToRunOnFrame = new ArrayList();
        this.dispatchCallback = new dispatchCallback.1(this);
        this.frameClock = new AndroidUiFrameClock(choreographer);
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer, Handler handler, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographer, handler);
    }

    private final Runnable nextTask() {
        Runnable runnable;
        synchronized (this.lock) {
            runnable = (Runnable) this.toRunTrampolined.removeFirstOrNull();
        }
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performFrameDispatch(long j) {
        synchronized (this.lock) {
            if (this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = false;
                List<Choreographer.FrameCallback> list = this.toRunOnFrame;
                this.toRunOnFrame = this.spareToRunOnFrame;
                this.spareToRunOnFrame = list;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).doFrame(j);
                }
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performTrampolineDispatch() {
        boolean z;
        do {
            Runnable nextTask = nextTask();
            while (nextTask != null) {
                nextTask.run();
                nextTask = nextTask();
            }
            synchronized (this.lock) {
                z = false;
                if (this.toRunTrampolined.isEmpty()) {
                    this.scheduledTrampolineDispatch = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(runnable, "block");
        synchronized (this.lock) {
            this.toRunTrampolined.addLast(runnable);
            if (!this.scheduledTrampolineDispatch) {
                this.scheduledTrampolineDispatch = true;
                this.handler.post(this.dispatchCallback);
                if (!this.scheduledFrameDispatch) {
                    this.scheduledFrameDispatch = true;
                    this.choreographer.postFrameCallback(this.dispatchCallback);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    @NotNull
    public final MonotonicFrameClock getFrameClock() {
        return this.frameClock;
    }

    public final void postFrameCallback$ui_release(@NotNull Choreographer.FrameCallback frameCallback) {
        Intrinsics.checkNotNullParameter(frameCallback, "callback");
        synchronized (this.lock) {
            this.toRunOnFrame.add(frameCallback);
            if (!this.scheduledFrameDispatch) {
                this.scheduledFrameDispatch = true;
                this.choreographer.postFrameCallback(this.dispatchCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFrameCallback$ui_release(@NotNull Choreographer.FrameCallback frameCallback) {
        Intrinsics.checkNotNullParameter(frameCallback, "callback");
        synchronized (this.lock) {
            this.toRunOnFrame.remove(frameCallback);
        }
    }
}
