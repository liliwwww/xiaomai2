package androidx.transition;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.transition.Transition;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionSupport$1 extends Transition.EpicenterCallback {
    final /* synthetic */ FragmentTransitionSupport this$0;
    final /* synthetic */ Rect val$epicenter;

    FragmentTransitionSupport$1(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        this.this$0 = fragmentTransitionSupport;
        this.val$epicenter = rect;
    }

    public Rect onGetEpicenter(@NonNull Transition transition) {
        return this.val$epicenter;
    }
}
