package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$8 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ ArrayList val$transitioningViews;

    DefaultSpecialEffectsController$8(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitioningViews = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.setViewVisibility(this.val$transitioningViews, 4);
    }
}
