package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$4 implements Animation.AnimationListener {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ DefaultSpecialEffectsController.AnimationInfo val$animationInfo;
    final /* synthetic */ ViewGroup val$container;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;
    final /* synthetic */ View val$viewToAnimate;

    DefaultSpecialEffectsController$4(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationInfo animationInfo) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$operation = operation;
        this.val$container = viewGroup;
        this.val$viewToAnimate = view;
        this.val$animationInfo = animationInfo;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.val$container.post(new 1(this));
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + this.val$operation + " has reached onAnimationStart.");
        }
    }
}
