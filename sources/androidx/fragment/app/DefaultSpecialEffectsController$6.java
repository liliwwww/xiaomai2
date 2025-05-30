package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$6 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ SpecialEffectsController.Operation val$firstOut;
    final /* synthetic */ boolean val$isPop;
    final /* synthetic */ SpecialEffectsController.Operation val$lastIn;
    final /* synthetic */ ArrayMap val$lastInViews;

    DefaultSpecialEffectsController$6(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z, ArrayMap arrayMap) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$lastIn = operation;
        this.val$firstOut = operation2;
        this.val$isPop = z;
        this.val$lastInViews = arrayMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTransition.callSharedElementStartEnd(this.val$lastIn.getFragment(), this.val$firstOut.getFragment(), this.val$isPop, this.val$lastInViews, false);
    }
}
