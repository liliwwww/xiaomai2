package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DefaultSpecialEffectsController$1 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ List val$awaitingContainerChanges;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;

    DefaultSpecialEffectsController$1(DefaultSpecialEffectsController defaultSpecialEffectsController, List list, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$awaitingContainerChanges = list;
        this.val$operation = operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
            this.val$awaitingContainerChanges.remove(this.val$operation);
            this.this$0.applyContainerChanges(this.val$operation);
        }
    }
}
