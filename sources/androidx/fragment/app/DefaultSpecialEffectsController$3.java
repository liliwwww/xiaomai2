package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$3 implements CancellationSignal.OnCancelListener {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ Animator val$animator;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;

    DefaultSpecialEffectsController$3(DefaultSpecialEffectsController defaultSpecialEffectsController, Animator animator, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$animator = animator;
        this.val$operation = operation;
    }

    public void onCancel() {
        this.val$animator.end();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animator from operation " + this.val$operation + " has been canceled.");
        }
    }
}
