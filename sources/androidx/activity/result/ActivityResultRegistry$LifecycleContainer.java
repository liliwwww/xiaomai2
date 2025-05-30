package androidx.activity.result;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ActivityResultRegistry$LifecycleContainer {
    final Lifecycle mLifecycle;
    private final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

    ActivityResultRegistry$LifecycleContainer(@NonNull Lifecycle lifecycle) {
        this.mLifecycle = lifecycle;
    }

    void addObserver(@NonNull LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle.addObserver(lifecycleEventObserver);
        this.mObservers.add(lifecycleEventObserver);
    }

    void clearObservers() {
        Iterator<LifecycleEventObserver> it = this.mObservers.iterator();
        while (it.hasNext()) {
            this.mLifecycle.removeObserver(it.next());
        }
        this.mObservers.clear();
    }
}
