package androidx.compose.ui.platform;

import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidComposeView$resendMotionEventOnLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$resendMotionEventOnLayout$1(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2198invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2198invoke() {
        MotionEvent access$getPreviousMotionEvent$p = AndroidComposeView.access$getPreviousMotionEvent$p(this.this$0);
        if (access$getPreviousMotionEvent$p != null) {
            int actionMasked = access$getPreviousMotionEvent$p.getActionMasked();
            if (actionMasked == 7 || actionMasked == 9) {
                AndroidComposeView.access$setRelayoutTime$p(this.this$0, SystemClock.uptimeMillis());
                AndroidComposeView androidComposeView = this.this$0;
                androidComposeView.post(AndroidComposeView.access$getResendMotionEventRunnable$p(androidComposeView));
            }
        }
    }
}
