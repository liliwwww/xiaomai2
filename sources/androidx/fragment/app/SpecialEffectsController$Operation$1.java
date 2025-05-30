package androidx.fragment.app;

import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class SpecialEffectsController$Operation$1 implements CancellationSignal$OnCancelListener {
    final /* synthetic */ SpecialEffectsController.Operation this$0;

    SpecialEffectsController$Operation$1(SpecialEffectsController.Operation operation) {
        this.this$0 = operation;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        this.this$0.cancel();
    }
}
