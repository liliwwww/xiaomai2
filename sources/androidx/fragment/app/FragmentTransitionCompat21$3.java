package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionCompat21$3 implements Transition.TransitionListener {
    final /* synthetic */ FragmentTransitionCompat21 this$0;
    final /* synthetic */ Object val$enterTransition;
    final /* synthetic */ ArrayList val$enteringViews;
    final /* synthetic */ Object val$exitTransition;
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ Object val$sharedElementTransition;
    final /* synthetic */ ArrayList val$sharedElementsIn;

    FragmentTransitionCompat21$3(FragmentTransitionCompat21 fragmentTransitionCompat21, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$enterTransition = obj;
        this.val$enteringViews = arrayList;
        this.val$exitTransition = obj2;
        this.val$exitingViews = arrayList2;
        this.val$sharedElementTransition = obj3;
        this.val$sharedElementsIn = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        FragmentTransitionCompat21$Api19Impl.removeListener(transition, this);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Object obj = this.val$enterTransition;
        if (obj != null) {
            this.this$0.replaceTargets(obj, this.val$enteringViews, (ArrayList) null);
        }
        Object obj2 = this.val$exitTransition;
        if (obj2 != null) {
            this.this$0.replaceTargets(obj2, this.val$exitingViews, (ArrayList) null);
        }
        Object obj3 = this.val$sharedElementTransition;
        if (obj3 != null) {
            this.this$0.replaceTargets(obj3, this.val$sharedElementsIn, (ArrayList) null);
        }
    }
}
