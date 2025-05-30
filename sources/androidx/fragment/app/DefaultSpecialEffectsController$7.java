package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$7 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ FragmentTransitionImpl val$impl;
    final /* synthetic */ Rect val$lastInEpicenterRect;
    final /* synthetic */ View val$lastInEpicenterView;

    DefaultSpecialEffectsController$7(DefaultSpecialEffectsController defaultSpecialEffectsController, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$impl = fragmentTransitionImpl;
        this.val$lastInEpicenterView = view;
        this.val$lastInEpicenterRect = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
    }
}
