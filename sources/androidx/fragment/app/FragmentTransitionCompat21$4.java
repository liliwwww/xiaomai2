package androidx.fragment.app;

import android.transition.Transition;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionCompat21$4 implements Transition.TransitionListener {
    final /* synthetic */ FragmentTransitionCompat21 this$0;
    final /* synthetic */ Runnable val$transitionCompleteRunnable;

    FragmentTransitionCompat21$4(FragmentTransitionCompat21 fragmentTransitionCompat21, Runnable runnable) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$transitionCompleteRunnable = runnable;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        this.val$transitionCompleteRunnable.run();
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
    }
}
