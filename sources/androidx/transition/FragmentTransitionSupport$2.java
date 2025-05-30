package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionSupport$2 implements Transition.TransitionListener {
    final /* synthetic */ FragmentTransitionSupport this$0;
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ View val$fragmentView;

    FragmentTransitionSupport$2(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
        this.this$0 = fragmentTransitionSupport;
        this.val$fragmentView = view;
        this.val$exitingViews = arrayList;
    }

    public void onTransitionCancel(@NonNull Transition transition) {
    }

    public void onTransitionEnd(@NonNull Transition transition) {
        transition.removeListener(this);
        this.val$fragmentView.setVisibility(8);
        int size = this.val$exitingViews.size();
        for (int i = 0; i < size; i++) {
            ((View) this.val$exitingViews.get(i)).setVisibility(0);
        }
    }

    public void onTransitionPause(@NonNull Transition transition) {
    }

    public void onTransitionResume(@NonNull Transition transition) {
    }

    public void onTransitionStart(@NonNull Transition transition) {
    }
}
