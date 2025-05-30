package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$5 implements CancellationSignal.OnCancelListener {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final /* synthetic */ ViewGroup val$container;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;
    final /* synthetic */ View val$viewToAnimate;

    DefaultSpecialEffectsController$5(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, ViewGroup viewGroup, DefaultSpecialEffectsController.AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$viewToAnimate = view;
        this.val$container = viewGroup;
        this.val$animationInfo = animationInfo;
        this.val$operation = operation;
    }

    public void onCancel() {
        this.val$viewToAnimate.clearAnimation();
        this.val$container.endViewTransition(this.val$viewToAnimate);
        this.val$animationInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has been cancelled.");
        }
    }
}
