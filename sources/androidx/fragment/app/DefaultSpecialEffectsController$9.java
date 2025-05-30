package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$9 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionInfo val$transitionInfo;

    DefaultSpecialEffectsController$9(DefaultSpecialEffectsController defaultSpecialEffectsController, DefaultSpecialEffectsController.TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitionInfo = transitionInfo;
        this.val$operation = operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$transitionInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Transition for operation " + this.val$operation + "has completed");
        }
    }
}
