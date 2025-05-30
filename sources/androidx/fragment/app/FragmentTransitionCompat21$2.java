package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionCompat21$2 implements Transition.TransitionListener {
    final /* synthetic */ FragmentTransitionCompat21 this$0;
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ View val$fragmentView;

    FragmentTransitionCompat21$2(FragmentTransitionCompat21 fragmentTransitionCompat21, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        FragmentTransitionCompat21$Api19Impl.removeListener(transition, this);
        this.val$fragmentView.setVisibility(8);
        int size = this.val$exitingViews.size();
        for (int i = 0; i < size; i++) {
            ((View) this.val$exitingViews.get(i)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        FragmentTransitionCompat21$Api19Impl.removeListener(transition, this);
        FragmentTransitionCompat21$Api19Impl.addListener(transition, this);
    }
}
