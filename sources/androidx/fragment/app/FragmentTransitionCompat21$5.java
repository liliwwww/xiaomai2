package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionCompat21$5 extends Transition.EpicenterCallback {
    final /* synthetic */ FragmentTransitionCompat21 this$0;
    final /* synthetic */ Rect val$epicenter;

    FragmentTransitionCompat21$5(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
        this.this$0 = fragmentTransitionCompat21;
        this.val$epicenter = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.val$epicenter;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.val$epicenter;
    }
}
