package androidx.transition;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.transition.TransitionManager;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TransitionManager$MultiListener$1 extends TransitionListenerAdapter {
    final /* synthetic */ TransitionManager.MultiListener this$0;
    final /* synthetic */ ArrayMap val$runningTransitions;

    TransitionManager$MultiListener$1(TransitionManager.MultiListener multiListener, ArrayMap arrayMap) {
        this.this$0 = multiListener;
        this.val$runningTransitions = arrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTransitionEnd(@NonNull Transition transition) {
        ((ArrayList) this.val$runningTransitions.get(this.this$0.mSceneRoot)).remove(transition);
        transition.removeListener(this);
    }
}
