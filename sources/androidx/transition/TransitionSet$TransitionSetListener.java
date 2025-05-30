package androidx.transition;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class TransitionSet$TransitionSetListener extends TransitionListenerAdapter {
    TransitionSet mTransitionSet;

    TransitionSet$TransitionSetListener(TransitionSet transitionSet) {
        this.mTransitionSet = transitionSet;
    }

    @Override // androidx.transition.TransitionListenerAdapter
    public void onTransitionEnd(@NonNull Transition transition) {
        TransitionSet transitionSet = this.mTransitionSet;
        int i = transitionSet.mCurrentListeners - 1;
        transitionSet.mCurrentListeners = i;
        if (i == 0) {
            transitionSet.mStarted = false;
            transitionSet.end();
        }
        transition.removeListener(this);
    }

    @Override // androidx.transition.TransitionListenerAdapter
    public void onTransitionStart(@NonNull Transition transition) {
        TransitionSet transitionSet = this.mTransitionSet;
        if (transitionSet.mStarted) {
            return;
        }
        transitionSet.start();
        this.mTransitionSet.mStarted = true;
    }
}
