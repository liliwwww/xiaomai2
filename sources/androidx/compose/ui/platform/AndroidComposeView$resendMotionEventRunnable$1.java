package androidx.compose.ui.platform;

import android.view.MotionEvent;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeView$resendMotionEventRunnable$1 implements Runnable {
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$resendMotionEventRunnable$1(AndroidComposeView androidComposeView) {
        this.this$0 = androidComposeView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.removeCallbacks(this);
        MotionEvent access$getPreviousMotionEvent$p = AndroidComposeView.access$getPreviousMotionEvent$p(this.this$0);
        if (access$getPreviousMotionEvent$p != null) {
            boolean z = false;
            boolean z2 = access$getPreviousMotionEvent$p.getToolType(0) == 3;
            int actionMasked = access$getPreviousMotionEvent$p.getActionMasked();
            if (!z2 ? actionMasked != 1 : !(actionMasked == 10 || actionMasked == 1)) {
                z = true;
            }
            if (z) {
                int i = (actionMasked == 7 || actionMasked == 9) ? 7 : 2;
                AndroidComposeView androidComposeView = this.this$0;
                AndroidComposeView.access$sendSimulatedEvent(androidComposeView, access$getPreviousMotionEvent$p, i, AndroidComposeView.access$getRelayoutTime$p(androidComposeView), false);
            }
        }
    }
}
