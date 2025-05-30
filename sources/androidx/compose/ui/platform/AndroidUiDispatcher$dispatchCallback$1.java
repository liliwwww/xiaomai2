package androidx.compose.ui.platform;

import android.view.Choreographer;
import kotlin.Unit;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidUiDispatcher$dispatchCallback$1 implements Choreographer.FrameCallback, Runnable {
    final /* synthetic */ AndroidUiDispatcher this$0;

    AndroidUiDispatcher$dispatchCallback$1(AndroidUiDispatcher androidUiDispatcher) {
        this.this$0 = androidUiDispatcher;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        AndroidUiDispatcher.access$getHandler$p(this.this$0).removeCallbacks(this);
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        AndroidUiDispatcher.access$performFrameDispatch(this.this$0, j);
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        Object access$getLock$p = AndroidUiDispatcher.access$getLock$p(this.this$0);
        AndroidUiDispatcher androidUiDispatcher = this.this$0;
        synchronized (access$getLock$p) {
            if (AndroidUiDispatcher.access$getToRunOnFrame$p(androidUiDispatcher).isEmpty()) {
                androidUiDispatcher.getChoreographer().removeFrameCallback(this);
                AndroidUiDispatcher.access$setScheduledFrameDispatch$p(androidUiDispatcher, false);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
